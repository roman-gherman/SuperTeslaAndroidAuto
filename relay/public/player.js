(function() {
    'use strict';

    // ---- DOM references ----
    var canvasEl = document.getElementById('player-canvas');
    var ctx = canvasEl ? canvasEl.getContext('2d') : null;
    var splash = document.getElementById('splash');
    var statusDot = document.getElementById('status-dot');
    var statusText = document.getElementById('status-text');
    var videoContainer = document.getElementById('video-container');

    // Canvas-only rendering (no <video> element — Tesla blocks video while driving)
    var mode = 'webcodecs';
    console.log('Player mode:', mode);

    // ---- State ----
    var ws = null;
    var cachedSps = null;
    var cachedPps = null;
    var reconnectTimer = null;
    var reconnectDelay = 1000;

    // WebCodecs state
    var decoder = null;
    var decoderConfigured = false;
    var frameTimestamp = 0;

    // Config-driven resolution (defaults, updated when CONFIG message received)
    var configWidth = 1280;
    var configHeight = 720;

    // ---- Status helpers ----
    function setStatus(state, text) {
        if (statusDot) statusDot.className = state;
        if (statusText) statusText.textContent = text;
    }

    function hideSplash() {
        if (splash && !splash.classList.contains('hidden')) {
            splash.classList.add('hidden');
        }
    }

    // ---- Annex B NAL unit parser ----
    function parseNalUnits(data) {
        var nals = [];
        var start = -1;
        for (var i = 0; i < data.length - 3; i++) {
            if (data[i] === 0 && data[i + 1] === 0) {
                if (data[i + 2] === 0 && i + 3 < data.length && data[i + 3] === 1) {
                    if (start >= 0) nals.push(data.subarray(start, i));
                    start = i + 4;
                    i += 3;
                } else if (data[i + 2] === 1) {
                    if (start >= 0) nals.push(data.subarray(start, i));
                    start = i + 3;
                    i += 2;
                }
            }
        }
        if (start >= 0) nals.push(data.subarray(start));
        return nals;
    }

    function nalType(nalBody) { return nalBody[0] & 0x1F; }

    // ---- WebCodecs implementation ----
    function codecStringFromSps(sps) {
        if (sps.length < 4) return 'avc1.42801f';
        return 'avc1.' + [sps[1], sps[2], sps[3]]
            .map(function(b) { return b.toString(16).padStart(2, '0'); })
            .join('');
    }

    function wrapAnnexB(nalBody) {
        var out = new Uint8Array(4 + nalBody.length);
        out[0] = 0; out[1] = 0; out[2] = 0; out[3] = 1;
        out.set(nalBody, 4);
        return out;
    }

    function buildAnnexBChunk(parts) {
        var total = 0;
        for (var i = 0; i < parts.length; i++) total += 4 + parts[i].length;
        var out = new Uint8Array(total);
        var offset = 0;
        for (var i = 0; i < parts.length; i++) {
            out[offset] = 0; out[offset+1] = 0; out[offset+2] = 0; out[offset+3] = 1;
            out.set(parts[i], offset + 4);
            offset += 4 + parts[i].length;
        }
        return out;
    }

    var frameCount = 0;
    function createWebCodecsDecoder() {
        return new VideoDecoder({
            output: function(frame) {
                frameCount++;
                if (frameCount <= 3) {
                    console.log('Frame #' + frameCount + ': ' + frame.displayWidth + 'x' + frame.displayHeight + ' coded:' + frame.codedWidth + 'x' + frame.codedHeight);
                }
                if (ctx) {
                    if (canvasEl.width !== frame.displayWidth || canvasEl.height !== frame.displayHeight) {
                        canvasEl.width = frame.displayWidth;
                        canvasEl.height = frame.displayHeight;
                    }
                    ctx.drawImage(frame, 0, 0);
                }
                frame.close();
                hideSplash();
            },
            error: function(e) {
                console.error('VideoDecoder error:', e);
                decoderConfigured = false;
                cachedSps = null;
                cachedPps = null;
            }
        });
    }

    function buildAvcC(sps, pps) {
        // avcDecoderConfigurationRecord per ISO 14496-15
        var len = 11 + sps.length + pps.length;
        var buf = new Uint8Array(len);
        buf[0] = 1;            // configurationVersion
        buf[1] = sps[1];       // AVCProfileIndication
        buf[2] = sps[2];       // profile_compatibility
        buf[3] = sps[3];       // AVCLevelIndication
        buf[4] = 0xFF;         // lengthSizeMinusOne=3 | 0xFC reserved bits
        buf[5] = 0xE1;         // numSPS=1 | 0xE0 reserved bits
        buf[6] = (sps.length >> 8) & 0xFF;
        buf[7] = sps.length & 0xFF;
        buf.set(sps, 8);
        var off = 8 + sps.length;
        buf[off] = 1;          // numPPS
        buf[off + 1] = (pps.length >> 8) & 0xFF;
        buf[off + 2] = pps.length & 0xFF;
        buf.set(pps, off + 3);
        return buf;
    }

    function configureWebCodecsDecoder() {
        if (!cachedSps || !cachedPps) return;
        if (!decoder || decoder.state === 'closed') {
            decoder = createWebCodecsDecoder();
        }
        var codec = codecStringFromSps(cachedSps);
        var description = buildAvcC(cachedSps, cachedPps);
        try {
            decoder.configure({
                codec: codec,
                description: description,
                optimizeForLatency: true
            });
            decoderConfigured = true;
            frameTimestamp = 0;
            console.log('WebCodecs configured, codec:', codec, 'sps:', cachedSps.length + 'b', 'pps:', cachedPps.length + 'b');
        } catch (e) {
            console.error('WebCodecs configure failed:', e);
            decoderConfigured = false;
        }
    }

    function wrapAvcc(nalBody) {
        // 4-byte length prefix (AVCC format) instead of Annex B start code
        var len = nalBody.length;
        var out = new Uint8Array(4 + len);
        out[0] = (len >> 24) & 0xFF;
        out[1] = (len >> 16) & 0xFF;
        out[2] = (len >> 8) & 0xFF;
        out[3] = len & 0xFF;
        out.set(nalBody, 4);
        return out;
    }

    function decodeWebCodecsNal(nalBody, type) {
        if (!decoderConfigured || !decoder || decoder.state !== 'configured') return;
        var data = wrapAvcc(nalBody);
        var chunk = new EncodedVideoChunk({
            type: type,
            timestamp: frameTimestamp,
            data: data
        });
        frameTimestamp += 33333;
        try { decoder.decode(chunk); } catch (e) { console.warn('decode error:', e); }
    }

    // MSE removed — Tesla blocks <video> elements while driving.
    // WebCodecs + canvas is the only supported rendering path.

    // ---- Process binary WebSocket message ----

    // ---- Process binary WebSocket message ----
    function processBinaryFrame(arrayBuffer) {
        var data = new Uint8Array(arrayBuffer);
        var nals = parseNalUnits(data);

        var gotNewSps = false;
        var gotNewPps = false;

        for (var i = 0; i < nals.length; i++) {
            var nal = nals[i];
            if (nal.length === 0) continue;
            var type = nalType(nal);

            switch (type) {
                case 7: // SPS
                    cachedSps = nal.slice();
                    gotNewSps = true;
                    break;
                case 8: // PPS
                    cachedPps = nal.slice();
                    gotNewPps = true;
                    break;
                case 5: // IDR
                    if (!decoderConfigured || gotNewSps || gotNewPps) configureWebCodecsDecoder();
                    decodeWebCodecsNal(nal, 'key');
                    break;
                case 1: // non-IDR
                    if (decoderConfigured) decodeWebCodecsNal(nal, 'delta');
                    break;
                default:
                    break;
            }
        }

        // Don't configure decoder here — wait for IDR (case 5 above).
        // Configuring on SPS+PPS alone causes "key frame required" errors
        // when the next frame is a P-frame instead of an IDR.
    }

    // ---- Fetch config from server (TaaDa-compatible /config endpoint) ----
    function fetchConfig() {
        var w = screen.width || 1920;
        var h = screen.height || 1080;
        var wc = typeof VideoDecoder === 'function';
        fetch('/config?w=' + w + '&h=' + h + '&webcodec=' + wc)
            .then(function(r) { return r.json(); })
            .then(function(cfg) {
                console.log('Config:', cfg);
                if (cfg.width && cfg.height) {
                    if (window.SuperTeslaTouch) {
                        window.SuperTeslaTouch.DISPLAY_W = cfg.width;
                        window.SuperTeslaTouch.DISPLAY_H = cfg.height;
                    }
                    if (canvasEl) {
                        canvasEl.width = cfg.width;
                        canvasEl.height = cfg.height;
                    }
                }
            })
            .catch(function(e) { console.warn('Config fetch failed:', e); });
    }

    // ---- Connection mode detection ----
    var relayMode = false;
    var relayRoom = null;
    var relayKey = null; // null = need approval, string = saved key
    var RELAY_HOST = window.SUPERTESLA_RELAY_HOST || location.host;

    function detectConnectionMode() {
        var path = location.pathname.replace(/^\//, '').replace(/\/$/, '');

        // Room code from URL path (3-8 alphanumeric chars)
        if (path.length >= 3 && path.length <= 8 && /^[a-z0-9]+$/.test(path)) {
            relayMode = true;
            relayRoom = path;
            // Check localStorage for saved session key
            try {
                relayKey = localStorage.getItem('staa_key_' + relayRoom) || null;
            } catch(e) {}
            return;
        }

        // URL params fallback: ?room=X
        var params = new URLSearchParams(location.search);
        if (params.get('room')) {
            relayMode = true;
            relayRoom = params.get('room');
            try { relayKey = localStorage.getItem('staa_key_' + relayRoom) || null; } catch(e) {}
        }
    }
    detectConnectionMode();

    // Legacy local mode
    function getServerHost() {
        var params = new URLSearchParams(location.search);
        if (params.get('ip')) return params.get('ip') + ':8080';
        if (location.host) return location.host;
        return '192.168.43.1:8080';
    }

    var serverHost = relayMode ? RELAY_HOST : getServerHost();
    console.log(relayMode
        ? 'Relay mode: room=' + relayRoom + ' key=' + (relayKey ? 'saved' : 'none (will request approval)')
        : 'Local mode: ' + serverHost);
    var connInfo = document.getElementById('connection-info');
    if (connInfo) connInfo.textContent = relayMode ? 'Room: ' + relayRoom : 'Server: ' + serverHost;

    // ---- WebSocket connection ----
    function connect() {
        var url;
        if (relayMode) {
            var wsProto = (location.protocol === 'https:') ? 'wss://' : 'ws://';
            url = wsProto + RELAY_HOST + '/ws?room=' + relayRoom + '&role=tesla';
            if (relayKey) url += '&key=' + encodeURIComponent(relayKey);
        } else {
            var wsProto = (location.protocol === 'https:') ? 'wss://' : 'ws://';
            url = wsProto + serverHost + '/ws';
        }
        setStatus('buffering', mode.toUpperCase() + ': Connecting...');

        try { ws = new WebSocket(url); } catch (e) {
            setStatus('', 'Connection failed');
            scheduleReconnect();
            return;
        }
        ws.binaryType = 'arraybuffer';

        ws.onopen = function() {
            setStatus('connected', mode.toUpperCase() + ': Connected');
            // Don't reset reconnectDelay here — only reset after receiving actual video data
            if (window.SuperTeslaTouch) window.SuperTeslaTouch.setWebSocket(ws);
            // Send START once — server will enable video focus
            ws.send(JSON.stringify({ action: 'START' }));
            // Start PING keepalive every 2 seconds (TaaDa compat)
            if (window._pingInterval) clearInterval(window._pingInterval);
            window._pingInterval = setInterval(function() {
                if (ws && ws.readyState === WebSocket.OPEN) {
                    ws.send(JSON.stringify({ action: 'PING', fps: window._currentFps || 0 }));
                }
            }, 2000);
        };

        ws.onmessage = function(event) {
            if (event.data instanceof ArrayBuffer) {
                reconnectDelay = 1000; // Reset backoff on actual data
                var raw = new Uint8Array(event.data);
                var type = raw[0];
                var payload = raw.subarray(1);

                if (type === 0x00) {
                    // Video frame (H.264 NAL)
                    processBinaryFrame(payload.buffer.slice(payload.byteOffset, payload.byteOffset + payload.byteLength));
                    if (ws && ws.readyState === WebSocket.OPEN) {
                        ws.send(JSON.stringify({ action: 'ACK' }));
                    }
                } else if (type >= 0x01 && type <= 0x03) {
                    // Audio PCM
                    if (window.SuperTeslaAudioPCM) {
                        window.SuperTeslaAudioPCM.feed(type, payload);
                    }
                }
            } else {
                try {
                    var msg = JSON.parse(event.data);
                    if (msg.type === 'status') {
                        setStatus('connected', msg.message || 'Connected');
                    } else if (msg.type === 'waiting_approval') {
                        setStatus('buffering', 'Waiting for phone approval...');
                        if (splash) {
                            splash.querySelector('p').textContent = 'Approve on your phone to connect';
                        }
                    } else if (msg.type === 'approved') {
                        // Phone approved! Save session key for future use
                        if (msg.sessionKey && relayRoom) {
                            try { localStorage.setItem('staa_key_' + relayRoom, msg.sessionKey); } catch(e) {}
                            relayKey = msg.sessionKey;
                            console.log('Approved! Session key saved for room ' + relayRoom);
                        }
                        setStatus('connected', 'Connected');
                        // Update splash to show connecting state
                        if (splash) {
                            splash.querySelector('h1').textContent = 'SuperTesla Android Auto';
                            splash.querySelector('p').textContent = 'Starting stream...';
                        }
                        // Send START to begin video
                        if (ws && ws.readyState === WebSocket.OPEN) {
                            ws.send(JSON.stringify({ action: 'START' }));
                        }
                        // Setup touch
                        if (window.SuperTeslaTouch) window.SuperTeslaTouch.setWebSocket(ws);
                    } else if (msg.action === 'CONFIG') {
                        // Store config for touch coordinates only.
                        // Do NOT reconfigure decoder — it uses the SPS from the
                        // actual video stream, which is authoritative.
                        if (msg.width) configWidth = msg.width;
                        if (msg.height) configHeight = msg.height;
                        console.log('Config received: ' + configWidth + 'x' + configHeight);
                        if (window.SuperTeslaTouch) {
                            window.SuperTeslaTouch.DISPLAY_W = configWidth;
                            window.SuperTeslaTouch.DISPLAY_H = configHeight;
                        }
                    } else if (msg.type === 'denied') {
                        setStatus('', 'Connection denied by phone');
                        if (splash) {
                            splash.querySelector('p').textContent = msg.message || 'Connection denied';
                        }
                    } else if (msg.type === 'revoked') {
                        // Session revoked — clear saved key
                        if (relayRoom) {
                            try { localStorage.removeItem('staa_key_' + relayRoom); } catch(e) {}
                        }
                        relayKey = null;
                        setStatus('', 'Session revoked');
                    }
                } catch (e) {}
            }
        };

        ws.onclose = function() {
            setStatus('', 'Disconnected');
            if (window._pingInterval) { clearInterval(window._pingInterval); window._pingInterval = null; }
            ws = null;
            resetState();
            scheduleReconnect();
        };

        ws.onerror = function() { setStatus('', 'Connection error'); };
    }

    function resetState() {
        cachedSps = null;
        cachedPps = null;
        decoderConfigured = false;
        frameTimestamp = 0;
        if (decoder) { try { decoder.close(); } catch(e) {} decoder = null; }
    }

    function scheduleReconnect() {
        if (reconnectTimer) return;
        reconnectTimer = setTimeout(function() {
            reconnectTimer = null;
            connect();
        }, reconnectDelay);
        reconnectDelay = Math.min(reconnectDelay * 1.5, 10000);
    }

    // ---- Prevent default touch behaviors ----
    document.addEventListener('touchstart', function(e) {
        if (e.target.id === 'touchpad') e.preventDefault();
    }, { passive: false });
    document.addEventListener('contextmenu', function(e) { e.preventDefault(); });

    // ---- Start ----
    fetchConfig();
    canvasEl.style.display = 'block';
    connect();

    // ---- Debug API ----
    window.SuperTeslaPlayer = {
        getMode: function() { return mode; },
        getDecoderState: function() { return decoder ? decoder.state : 'none'; },
        isConfigured: function() { return decoderConfigured; },
        getCodec: function() { return cachedSps ? codecStringFromSps(cachedSps) : null; }
    };
})();
