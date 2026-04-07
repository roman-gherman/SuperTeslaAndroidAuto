const http = require('http');
const { WebSocketServer } = require('ws');
const url = require('url');

const PORT = parseInt(process.env.PORT || '8080');

// Room storage: roomId -> { phoneWs, teslaWs, sessionKeys[], config, codecConfig, idr, pendingTesla, lastActivity }
const rooms = new Map();

// Pairing codes: code -> { room, expires }
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
        const { room, phoneKey } = JSON.parse(body);
        if (!room || !phoneKey) { res.writeHead(400); res.end('missing room or phoneKey'); return; }
        if (rooms.has(room) && rooms.get(room).phoneKey !== phoneKey) {
          res.writeHead(409); res.end('room taken'); return;
        }
        if (!rooms.has(room)) {
          rooms.set(room, {
            phoneWs: null, teslaWs: null,
            phoneKey,              // Phone's master key (never shared)
            sessionKeys: [],       // Approved Tesla session keys
            config: null, codecConfig: null, idr: null,
            pendingTesla: null,    // Tesla WebSocket waiting for approval
            lastActivity: Date.now()
          });
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
        const { room, phoneKey } = JSON.parse(body);
        const roomData = rooms.get(room);
        if (!roomData || roomData.phoneKey !== phoneKey) {
          res.writeHead(403); res.end('invalid'); return;
        }
        let code;
        do { code = String(Math.floor(1000 + Math.random() * 9000)); } while (pairingCodes.has(code));
        pairingCodes.set(code, { room, expires: Date.now() + 300000 });
        console.log(`Pairing code ${code} for room ${room}`);
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
        pairingCodes.delete(code);
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ room: entry.room }));
      } catch (e) { res.writeHead(400); res.end('invalid json'); }
    });
    return;
  }

  // Config endpoint — return phone's config if available, else defaults
  if (parsed.pathname === '/config') {
    // Extract room from referer or query
    var roomId = parsed.query.room;
    if (!roomId) {
      // Try to extract from referer path (e.g., /5j5s)
      var ref = req.headers.referer || '';
      var m = ref.match(/\/([a-z0-9]{3,8})(?:\?|$)/);
      if (m) roomId = m[1];
    }
    var roomData = roomId ? rooms.get(roomId) : null;
    var cfg = (roomData && roomData.config) || { width: 1280, height: 720 };
    res.writeHead(200, { 'Content-Type': 'application/json' });
    res.end(JSON.stringify({ width: cfg.width || 1280, height: cfg.height || 720, widthMargin: 0, heightMargin: 0, port: 8080, resolution: 1, usebt: false }));
    return;
  }

  if (parsed.pathname === '/api/status') {
    res.writeHead(200, { 'Content-Type': 'application/json' });
    res.end(JSON.stringify({
      rooms: rooms.size,
      activeRooms: [...rooms.values()].filter(r => r.phoneWs).length
    }));
    return;
  }

  // Serve static files
  const fs = require('fs');
  const path = require('path');
  const publicDir = path.join(__dirname, '..', 'public');
  const filePath = parsed.pathname === '/' ? '/index.html' : parsed.pathname;
  const fullPath = path.join(publicDir, filePath);
  const mimeTypes = { '.html': 'text/html', '.js': 'application/javascript', '.css': 'text/css', '.json': 'application/json' };

  fs.readFile(fullPath, (err, data) => {
    if (err) {
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

  if (!roomId || !role || !['phone', 'tesla'].includes(role)) {
    ws.close(4000, 'missing room or role');
    return;
  }

  let roomData = rooms.get(roomId);

  // === PHONE connects ===
  if (role === 'phone') {
    if (!key) { ws.close(4000, 'phone must provide key'); return; }

    // Auto-create room
    if (!roomData) {
      roomData = {
        phoneWs: null, teslaWs: null,
        phoneKey: key, sessionKeys: [],
        config: null, codecConfig: null, idr: null,
        pendingTesla: null, lastActivity: Date.now()
      };
      rooms.set(roomId, roomData);
      console.log(`Room auto-created: ${roomId}`);
    }

    if (roomData.phoneKey !== key) { ws.close(4003, 'invalid phone key'); return; }

    if (roomData.phoneWs) { try { roomData.phoneWs.close(4001, 'replaced'); } catch(e) {} }
    roomData.phoneWs = ws;
    roomData.lastActivity = Date.now();
    // Clear stale codec cache — new phone session may have different resolution
    roomData.codecConfig = null;
    roomData.idr = null;
    roomData.config = null;
    console.log(`Phone connected: ${roomId} (codec cache cleared)`);

    // Notify Tesla
    if (roomData.teslaWs && roomData.teslaWs.readyState === 1) {
      roomData.teslaWs.send(JSON.stringify({ type: 'status', message: 'Phone connected' }));
    }

    // If there's a pending Tesla approval request, re-notify the phone
    if (roomData.pendingTesla && roomData.pendingTesla.readyState === 1) {
      ws.send(JSON.stringify({ type: 'approval_request', message: 'Tesla wants to connect' }));
    }

    ws.on('message', (data, isBinary) => {
      roomData.lastActivity = Date.now();

      if (isBinary) {
        const bytes = Buffer.isBuffer(data) ? data : Buffer.from(data);
        if (bytes.length > 1 && bytes[0] === 0x00) {
          cacheCodecData(roomData, bytes);
        }
        if (roomData.teslaWs && roomData.teslaWs.readyState === 1) {
          roomData.teslaWs.send(data, { binary: true });
        }
      } else {
        const text = data.toString();
        try {
          const json = JSON.parse(text);

          // Phone approves Tesla connection
          if (json.action === 'APPROVE_TESLA') {
            const sessionKey = json.sessionKey;
            if (sessionKey && roomData.pendingTesla) {
              roomData.sessionKeys.push(sessionKey);
              console.log(`Tesla approved for room ${roomId}, key=${sessionKey.substring(0, 8)}...`);
              // Send key to Tesla so it can save to localStorage
              roomData.pendingTesla.send(JSON.stringify({ type: 'approved', sessionKey }));
              // Promote pending Tesla to active
              if (roomData.teslaWs) { try { roomData.teslaWs.close(4001, 'replaced'); } catch(e) {} }
              roomData.teslaWs = roomData.pendingTesla;
              roomData.pendingTesla = null;
              // Set up message forwarding (touch events, etc.)
              setupTeslaHandlers(roomData.teslaWs, roomData, roomId);
              // Send cached config + SPS (no stale IDR)
              if (roomData.config) roomData.teslaWs.send(JSON.stringify(roomData.config));
              if (roomData.codecConfig) roomData.teslaWs.send(roomData.codecConfig);
              // Ask phone for fresh keyframe so Tesla can decode immediately
              if (roomData.phoneWs && roomData.phoneWs.readyState === 1) {
                roomData.phoneWs.send(JSON.stringify({ action: 'REQUEST_KEYFRAME' }));
              }
              return;
            }
          }

          // Phone denies Tesla connection
          if (json.action === 'DENY_TESLA') {
            if (roomData.pendingTesla) {
              roomData.pendingTesla.send(JSON.stringify({ type: 'denied', message: 'Connection denied by phone' }));
              roomData.pendingTesla.close(4003, 'denied');
              roomData.pendingTesla = null;
            }
            return;
          }

          // Phone revokes a session key
          if (json.action === 'REVOKE_KEY') {
            roomData.sessionKeys = roomData.sessionKeys.filter(k => k !== json.sessionKey);
            console.log(`Key revoked in room ${roomId}`);
            return;
          }

          // Phone revokes ALL session keys
          if (json.action === 'REVOKE_ALL_KEYS') {
            roomData.sessionKeys = [];
            if (roomData.teslaWs) {
              roomData.teslaWs.send(JSON.stringify({ type: 'revoked', message: 'Session revoked' }));
              roomData.teslaWs.close(4003, 'revoked');
              roomData.teslaWs = null;
            }
            console.log(`All keys revoked in room ${roomId}`);
            return;
          }

          if (json.action === 'CONFIG') {
            roomData.config = json;
          }
        } catch (e) {}

        if (roomData.teslaWs && roomData.teslaWs.readyState === 1) {
          roomData.teslaWs.send(text);
        }
      }
    });

    ws.on('close', () => {
      if (roomData.phoneWs === ws) {
        roomData.phoneWs = null;
        console.log(`Phone disconnected: ${roomId}`);
        if (roomData.teslaWs && roomData.teslaWs.readyState === 1) {
          roomData.teslaWs.send(JSON.stringify({ type: 'status', message: 'Phone disconnected — waiting...' }));
        }
      }
    });

    ws.on('error', (err) => console.error(`Phone error (${roomId}):`, err.message));
    return;
  }

  // === TESLA connects ===
  if (role === 'tesla') {
    if (!roomData) { ws.close(4004, 'room not found'); return; }
    roomData.lastActivity = Date.now();

    // Tesla has a valid session key → connect immediately
    if (key && roomData.sessionKeys.includes(key)) {
      if (roomData.teslaWs) { try { roomData.teslaWs.close(4001, 'replaced'); } catch(e) {} }
      roomData.teslaWs = ws;
      console.log(`Tesla connected (saved key): ${roomId}`);

      // Send cached config + SPS (no IDR — it's stale and causes artifacts).
      // Browser will silently skip P-frames until a fresh IDR arrives.
      if (roomData.config) ws.send(JSON.stringify(roomData.config));
      if (roomData.codecConfig) ws.send(roomData.codecConfig);

      if (roomData.phoneWs && roomData.phoneWs.readyState === 1) {
        roomData.phoneWs.send(JSON.stringify({ type: 'tesla_connected' }));
        // Request fresh keyframe so Tesla gets a clean IDR ASAP
        roomData.phoneWs.send(JSON.stringify({ action: 'REQUEST_KEYFRAME' }));
      }

      setupTeslaHandlers(ws, roomData, roomId);
      return;
    }

    // No key or invalid key → request phone approval
    if (roomData.pendingTesla) {
      try { roomData.pendingTesla.close(4001, 'replaced by new request'); } catch(e) {}
    }
    roomData.pendingTesla = ws;
    console.log(`Tesla requesting approval: ${roomId}`);

    // Notify phone
    if (roomData.phoneWs && roomData.phoneWs.readyState === 1) {
      roomData.phoneWs.send(JSON.stringify({ type: 'approval_request', message: 'Tesla wants to connect' }));
    }

    // Tell Tesla to wait
    ws.send(JSON.stringify({ type: 'waiting_approval', message: 'Waiting for phone approval...' }));

    ws.on('close', () => {
      if (roomData.pendingTesla === ws) {
        roomData.pendingTesla = null;
        console.log(`Pending Tesla disconnected: ${roomId}`);
        if (roomData.phoneWs && roomData.phoneWs.readyState === 1) {
          roomData.phoneWs.send(JSON.stringify({ type: 'approval_cancelled' }));
        }
      }
    });

    ws.on('error', (err) => console.error(`Tesla pending error (${roomId}):`, err.message));
    return;
  }
});

function setupTeslaHandlers(ws, roomData, roomId) {
  ws.on('message', (data, isBinary) => {
    roomData.lastActivity = Date.now();
    if (roomData.phoneWs && roomData.phoneWs.readyState === 1) {
      roomData.phoneWs.send(data, { binary: isBinary });
    }
  });

  ws.on('close', () => {
    if (roomData.teslaWs === ws) {
      roomData.teslaWs = null;
      console.log(`Tesla disconnected: ${roomId}`);
      if (roomData.phoneWs && roomData.phoneWs.readyState === 1) {
        roomData.phoneWs.send(JSON.stringify({ type: 'tesla_disconnected' }));
      }
    }
  });

  ws.on('error', (err) => console.error(`Tesla error (${roomId}):`, err.message));
}

// --- Codec config caching ---
function cacheCodecData(roomData, bytes) {
  for (let i = 1; i < bytes.length - 4; i++) {
    if (bytes[i] === 0 && bytes[i+1] === 0 && bytes[i+2] === 0 && bytes[i+3] === 1) {
      const nalType = bytes[i+4] & 0x1F;
      if (nalType === 7) { roomData.codecConfig = Buffer.from(bytes); return; }
      if (nalType === 5) { roomData.idr = Buffer.from(bytes); return; }
    }
  }
}

// --- WebSocket ping/pong keepalive (prevents Cloud Run idle timeout) ---
const KEEPALIVE_INTERVAL_MS = 30000;

setInterval(() => {
  wss.clients.forEach((ws) => {
    if (ws.isAlive === false) {
      console.log('Keepalive: terminating unresponsive client');
      return ws.terminate();
    }
    ws.isAlive = false;
    ws.ping();
  });
}, KEEPALIVE_INTERVAL_MS);

// Mark all new connections as alive and track pong responses
wss.on('connection', (ws) => {
  ws.isAlive = true;
  ws.on('pong', () => { ws.isAlive = true; });
});

// --- Cleanup ---
setInterval(() => {
  const now = Date.now();
  for (const [code, entry] of pairingCodes) {
    if (now > entry.expires) pairingCodes.delete(code);
  }
  for (const [id, room] of rooms) {
    if (now - room.lastActivity > 86400000 && !room.phoneWs && !room.teslaWs) {
      rooms.delete(id);
      console.log(`Room ${id} expired`);
    }
  }
}, 60000);

server.listen(PORT, () => {
  console.log(`SuperTesla relay v2 listening on :${PORT}`);
});
