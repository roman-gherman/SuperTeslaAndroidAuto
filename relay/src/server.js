const http = require('http');
const { WebSocketServer } = require('ws');
const url = require('url');

const PORT = parseInt(process.env.PORT || '8080');

// Room storage: roomId -> { phoneWs, teslaWs, sessionKey, config, codecConfig, idr, lastActivity }
const rooms = new Map();

// Pairing codes: code -> { room, key, expires }
const pairingCodes = new Map();

// --- HTTP server ---
const server = http.createServer((req, res) => {
  const parsed = url.parse(req.url, true);
  res.setHeader('Access-Control-Allow-Origin', '*');
  res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
  res.setHeader('Access-Control-Allow-Headers', 'Content-Type');

  if (req.method === 'OPTIONS') { res.writeHead(204); res.end(); return; }

  if (parsed.pathname === '/health') {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('ok');
    return;
  }

  if (parsed.pathname === '/api/register' && req.method === 'POST') {
    let body = '';
    req.on('data', c => body += c);
    req.on('end', () => {
      try {
        const { room, key } = JSON.parse(body);
        if (!room || !key) { res.writeHead(400); res.end('missing room or key'); return; }
        if (rooms.has(room) && rooms.get(room).sessionKey !== key) {
          res.writeHead(409); res.end('room taken'); return;
        }
        if (!rooms.has(room)) {
          rooms.set(room, { phoneWs: null, teslaWs: null, sessionKey: key, config: null, codecConfig: null, idr: null, lastActivity: Date.now() });
        }
        console.log(`Room registered: ${room}`);
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ ok: true }));
      } catch (e) { res.writeHead(400); res.end('invalid json'); }
    });
    return;
  }

  if (parsed.pathname === '/api/pair/create' && req.method === 'POST') {
    let body = '';
    req.on('data', c => body += c);
    req.on('end', () => {
      try {
        const { room, key } = JSON.parse(body);
        // Generate unique 4-digit code
        let code;
        do { code = String(Math.floor(1000 + Math.random() * 9000)); } while (pairingCodes.has(code));
        pairingCodes.set(code, { room, key, expires: Date.now() + 300000 }); // 5 min TTL
        console.log(`Pairing code ${code} created for room ${room}`);
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ code }));
      } catch (e) { res.writeHead(400); res.end('invalid json'); }
    });
    return;
  }

  if (parsed.pathname === '/api/pair/lookup' && req.method === 'POST') {
    let body = '';
    req.on('data', c => body += c);
    req.on('end', () => {
      try {
        const { code } = JSON.parse(body);
        const entry = pairingCodes.get(code);
        if (!entry || Date.now() > entry.expires) {
          pairingCodes.delete(code);
          res.writeHead(404); res.end('invalid or expired code'); return;
        }
        pairingCodes.delete(code); // One-time use
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ room: entry.room, key: entry.key }));
      } catch (e) { res.writeHead(400); res.end('invalid json'); }
    });
    return;
  }

  if (parsed.pathname === '/api/status') {
    res.writeHead(200, { 'Content-Type': 'application/json' });
    res.end(JSON.stringify({
      rooms: rooms.size,
      activeRooms: [...rooms.values()].filter(r => r.phoneWs).length,
      pairingCodes: pairingCodes.size
    }));
    return;
  }

  // Serve static files from public/ directory (for local dev / standalone mode)
  const fs = require('fs');
  const path = require('path');
  const publicDir = path.join(__dirname, '..', 'public');
  const filePath = parsed.pathname === '/' ? '/index.html' : parsed.pathname;
  const fullPath = path.join(publicDir, filePath);
  const mimeTypes = { '.html': 'text/html', '.js': 'application/javascript', '.css': 'text/css', '.json': 'application/json' };

  fs.readFile(fullPath, (err, data) => {
    if (err) {
      // SPA fallback: serve index.html for room code paths
      fs.readFile(path.join(publicDir, 'index.html'), (err2, html) => {
        if (err2) { res.writeHead(404); res.end('not found'); return; }
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(html);
      });
      return;
    }
    const ext = path.extname(fullPath);
    res.writeHead(200, { 'Content-Type': mimeTypes[ext] || 'text/plain' });
    res.end(data);
  });
});

// --- WebSocket server ---
const wss = new WebSocketServer({ server });

wss.on('connection', (ws, req) => {
  const parsed = url.parse(req.url, true);
  const { room: roomId, key, role } = parsed.query;

  if (!roomId || !key || !role || !['phone', 'tesla'].includes(role)) {
    ws.close(4000, 'missing room, key, or role');
    return;
  }

  let roomData = rooms.get(roomId);

  // Auto-create room if phone connects with a key
  if (!roomData && role === 'phone') {
    roomData = { phoneWs: null, teslaWs: null, sessionKey: key, config: null, codecConfig: null, idr: null, lastActivity: Date.now() };
    rooms.set(roomId, roomData);
    console.log(`Room auto-created by phone: ${roomId}`);
  }

  if (!roomData) { ws.close(4004, 'room not found'); return; }
  if (roomData.sessionKey !== key) { ws.close(4003, 'invalid key'); return; }

  roomData.lastActivity = Date.now();

  if (role === 'phone') {
    if (roomData.phoneWs) { try { roomData.phoneWs.close(4001, 'replaced'); } catch(e) {} }
    roomData.phoneWs = ws;
    console.log(`Phone connected to room ${roomId}`);

    // Notify Tesla that phone is back
    if (roomData.teslaWs && roomData.teslaWs.readyState === 1) {
      roomData.teslaWs.send(JSON.stringify({ type: 'status', message: 'Phone connected' }));
    }
  }

  if (role === 'tesla') {
    if (roomData.teslaWs) { try { roomData.teslaWs.close(4001, 'replaced'); } catch(e) {} }
    roomData.teslaWs = ws;
    console.log(`Tesla connected to room ${roomId}`);

    // Send cached config
    if (roomData.config) {
      ws.send(JSON.stringify(roomData.config));
    }
    // Send cached codec config (SPS+PPS) and IDR for immediate decode
    if (roomData.codecConfig) {
      ws.send(roomData.codecConfig);
    }
    if (roomData.idr) {
      ws.send(roomData.idr);
    }

    // Notify phone that Tesla connected
    if (roomData.phoneWs && roomData.phoneWs.readyState === 1) {
      roomData.phoneWs.send(JSON.stringify({ type: 'tesla_connected' }));
    }
  }

  ws.on('message', (data, isBinary) => {
    roomData.lastActivity = Date.now();

    if (role === 'phone') {
      // Phone → Tesla
      if (isBinary) {
        // Cache codec config and IDR for late-joining Tesla
        const bytes = Buffer.isBuffer(data) ? data : Buffer.from(data);
        if (bytes.length > 1 && bytes[0] === 0x00) {
          // Video frame — check for SPS/PPS/IDR
          cacheCodecData(roomData, bytes);
        }
        // Forward to Tesla
        if (roomData.teslaWs && roomData.teslaWs.readyState === 1) {
          roomData.teslaWs.send(data, { binary: true });
        }
      } else {
        // Text frame (config, status, etc.)
        const text = data.toString();
        try {
          const json = JSON.parse(text);
          if (json.action === 'CONFIG') {
            roomData.config = json;
          }
        } catch (e) {}
        // Forward to Tesla
        if (roomData.teslaWs && roomData.teslaWs.readyState === 1) {
          roomData.teslaWs.send(text);
        }
      }
    }

    if (role === 'tesla') {
      // Tesla → Phone (touch events, START, STOP, ACK, PING)
      if (roomData.phoneWs && roomData.phoneWs.readyState === 1) {
        roomData.phoneWs.send(data, { binary: isBinary });
      }
    }
  });

  ws.on('close', () => {
    if (role === 'phone' && roomData.phoneWs === ws) {
      roomData.phoneWs = null;
      console.log(`Phone disconnected from room ${roomId}`);
      if (roomData.teslaWs && roomData.teslaWs.readyState === 1) {
        roomData.teslaWs.send(JSON.stringify({ type: 'status', message: 'Phone disconnected — waiting for reconnect...' }));
      }
    }
    if (role === 'tesla' && roomData.teslaWs === ws) {
      roomData.teslaWs = null;
      console.log(`Tesla disconnected from room ${roomId}`);
      if (roomData.phoneWs && roomData.phoneWs.readyState === 1) {
        roomData.phoneWs.send(JSON.stringify({ type: 'tesla_disconnected' }));
      }
    }
  });

  ws.on('error', (err) => {
    console.error(`WS error in room ${roomId} (${role}):`, err.message);
  });
});

// --- Codec config caching ---
function cacheCodecData(roomData, bytes) {
  // bytes[0] = 0x00 (video prefix), bytes[1+] = Annex B H.264
  // Scan for NAL start codes (0x00000001) and check NAL type
  for (let i = 1; i < bytes.length - 4; i++) {
    if (bytes[i] === 0 && bytes[i+1] === 0 && bytes[i+2] === 0 && bytes[i+3] === 1) {
      const nalType = bytes[i+4] & 0x1F;
      if (nalType === 7) { // SPS (usually SPS+PPS together)
        roomData.codecConfig = Buffer.from(bytes);
        return;
      }
      if (nalType === 5) { // IDR keyframe
        roomData.idr = Buffer.from(bytes);
        return;
      }
    }
  }
}

// --- Cleanup expired rooms and pairing codes ---
setInterval(() => {
  const now = Date.now();
  const DAY = 86400000;

  // Clean expired pairing codes
  for (const [code, entry] of pairingCodes) {
    if (now > entry.expires) pairingCodes.delete(code);
  }

  // Clean idle rooms (24h without activity)
  for (const [id, room] of rooms) {
    if (now - room.lastActivity > DAY && !room.phoneWs && !room.teslaWs) {
      rooms.delete(id);
      console.log(`Room ${id} expired`);
    }
  }
}, 60000);

// --- Start ---
server.listen(PORT, () => {
  console.log(`SuperTesla relay listening on :${PORT}`);
});
