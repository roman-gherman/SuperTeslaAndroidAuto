(function() {
    'use strict';

    // ---- DOM references ----
    var videoEl = document.getElementById('player-video');
    var canvasEl = document.getElementById('player-canvas');
    var ctx = canvasEl ? canvasEl.getContext('2d') : null;
    var splash = document.getElementById('splash');
    var statusDot = document.getElementById('status-dot');
    var statusText = document.getElementById('status-text');
    var videoContainer = document.getElementById('video-container');

    // ---- Detect capabilities ----
    var useWebCodecs = typeof VideoDecoder === 'function';
    var mode = useWebCodecs ? 'webcodecs' : 'mse';
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

    // MSE state
    var mediaSource = null;
    var sourceBuffer = null;
    var mseQueue = [];
    var mseInitSent = false;
    var mseSeqNum = 1;
    var mseBaseTime = 0;
    var MSE_TIMESCALE = 90000;
    var MSE_FRAME_DUR = MSE_TIMESCALE / 30; // 30fps

    // ---- Status helpers ----
    function setStatus(state, text) {
        if (statusDot) statusDot.className = state;
        if (statusText) statusText.textContent = text;
    }

    function hideSplash() {
        if (splash && !splash.classList.contains('hidden')) {
            splash.classList.add('hidden');
            if (videoContainer) videoContainer.style.display = 'block';
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

    function createWebCodecsDecoder() {
        return new VideoDecoder({
            output: function(frame) {
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

    function configureWebCodecsDecoder() {
        if (!cachedSps || !cachedPps) return;
        if (!decoder || decoder.state === 'closed') {
            decoder = createWebCodecsDecoder();
        }
        var codec = codecStringFromSps(cachedSps);
        var description = buildAnnexBChunk([cachedSps, cachedPps]);
        try {
            decoder.configure({
                codec: codec,
                codedWidth: 1280,
                codedHeight: 720,
                description: description,
                optimizeForLatency: true
            });
            decoderConfigured = true;
            frameTimestamp = 0;
            console.log('WebCodecs configured, codec:', codec);
        } catch (e) {
            console.error('WebCodecs configure failed:', e);
            decoderConfigured = false;
        }
    }

    function decodeWebCodecsNal(nalBody, type) {
        if (!decoderConfigured || !decoder || decoder.state !== 'configured') return;
        var data = wrapAnnexB(nalBody);
        var chunk = new EncodedVideoChunk({
            type: type,
            timestamp: frameTimestamp,
            data: data
        });
        frameTimestamp += 33333;
        try { decoder.decode(chunk); } catch (e) { console.warn('decode error:', e); }
    }

    // ---- MSE / fMP4 implementation (client-side muxing) ----
    function initMSE() {
        videoEl.style.display = 'block';
        mediaSource = new MediaSource();
        videoEl.src = URL.createObjectURL(mediaSource);
        mediaSource.addEventListener('sourceopen', function() {
            try {
                sourceBuffer = mediaSource.addSourceBuffer('video/mp4; codecs="avc1.42801f"');
                sourceBuffer.mode = 'segments';
                sourceBuffer.addEventListener('updateend', flushMseQueue);
                console.log('MSE SourceBuffer created');
            } catch (e) {
                console.error('MSE addSourceBuffer failed:', e);
            }
        });
    }

    function flushMseQueue() {
        if (!sourceBuffer || sourceBuffer.updating || mseQueue.length === 0) return;
        var data = mseQueue.shift();
        try {
            sourceBuffer.appendBuffer(data);
        } catch (e) {
            console.warn('appendBuffer error:', e);
            mseQueue.length = 0;
        }
    }

    function appendToMse(data) {
        mseQueue.push(data);
        flushMseQueue();
    }

    // ---- Minimal fMP4 muxer (JS) ----
    function u32(v) { return [(v>>24)&0xFF, (v>>16)&0xFF, (v>>8)&0xFF, v&0xFF]; }
    function u16(v) { return [(v>>8)&0xFF, v&0xFF]; }
    function box(type, content) {
        var sz = 8 + content.length;
        var b = new Uint8Array(sz);
        b[0]=(sz>>24)&0xFF; b[1]=(sz>>16)&0xFF; b[2]=(sz>>8)&0xFF; b[3]=sz&0xFF;
        b[4]=type.charCodeAt(0); b[5]=type.charCodeAt(1); b[6]=type.charCodeAt(2); b[7]=type.charCodeAt(3);
        b.set(content, 8);
        return b;
    }
    function concat() {
        var total = 0;
        for (var i = 0; i < arguments.length; i++) total += arguments[i].length;
        var out = new Uint8Array(total);
        var off = 0;
        for (var i = 0; i < arguments.length; i++) {
            out.set(arguments[i], off);
            off += arguments[i].length;
        }
        return out;
    }

    function createInitSegment(sps, pps) {
        var w = 1280, h = 720;
        // Try to parse width/height from SPS
        // For simplicity use defaults

        var ftyp = box('ftyp', new Uint8Array([
            0x69,0x73,0x6f,0x6d, // isom
            0x00,0x00,0x02,0x00, // minor version
            0x69,0x73,0x6f,0x6d, // isom
            0x69,0x73,0x6f,0x32, // iso2
            0x61,0x76,0x63,0x31, // avc1
            0x6d,0x70,0x34,0x31  // mp41
        ]));

        // avcC
        var avcC = box('avcC', new Uint8Array([
            1, sps[1], sps[2], sps[3], // configurationVersion, profile, compat, level
            0xFF, // lengthSizeMinusOne=3 | reserved
            0xE1, // numSPS=1 | reserved
            ...u16(sps.length), ...sps,
            1, // numPPS
            ...u16(pps.length), ...pps
        ]));

        // avc1
        var avc1Content = concat(
            new Uint8Array(6), // reserved
            new Uint8Array(u16(1)), // data_reference_index
            new Uint8Array(16), // pre_defined + reserved
            new Uint8Array(u16(w)), new Uint8Array(u16(h)),
            new Uint8Array(u32(0x00480000)), // horiz res
            new Uint8Array(u32(0x00480000)), // vert res
            new Uint8Array(4), // reserved
            new Uint8Array(u16(1)), // frame_count
            new Uint8Array(32), // compressor_name
            new Uint8Array(u16(0x0018)), // depth
            new Uint8Array([0xFF, 0xFF]), // pre_defined = -1
            avcC
        );
        var avc1 = box('avc1', avc1Content);

        var stsd = box('stsd', concat(new Uint8Array(u32(0)), new Uint8Array(u32(1)), avc1));
        var stts = box('stts', new Uint8Array([...u32(0), ...u32(0)]));
        var stsc = box('stsc', new Uint8Array([...u32(0), ...u32(0)]));
        var stsz = box('stsz', new Uint8Array([...u32(0), ...u32(0), ...u32(0)]));
        var stco = box('stco', new Uint8Array([...u32(0), ...u32(0)]));
        var stbl = box('stbl', concat(stsd, stts, stsc, stsz, stco));

        var vmhd = box('vmhd', new Uint8Array([...u32(1), ...u16(0), ...u16(0), ...u16(0), ...u16(0)]));
        var url = box('url ', new Uint8Array(u32(1)));
        var dref = box('dref', concat(new Uint8Array(u32(0)), new Uint8Array(u32(1)), url));
        var dinf = box('dinf', dref);
        var minf = box('minf', concat(vmhd, dinf, stbl));

        var mdhd = box('mdhd', new Uint8Array([...u32(0), ...u32(0), ...u32(0), ...u32(MSE_TIMESCALE), ...u32(0), ...u16(0x55C4), ...u16(0)]));
        var hdlr = box('hdlr', concat(new Uint8Array(u32(0)), new Uint8Array(u32(0)),
            new Uint8Array([0x76,0x69,0x64,0x65]), // vide
            new Uint8Array(12),
            new Uint8Array([0x56,0x69,0x64,0x65,0x6f,0x00]) // "Video\0"
        ));
        var mdia = box('mdia', concat(mdhd, hdlr, minf));

        var tkhd = box('tkhd', concat(
            new Uint8Array(u32(0x00000003)), // flags
            new Uint8Array(u32(0)), new Uint8Array(u32(0)), // times
            new Uint8Array(u32(1)), // track_ID
            new Uint8Array(4), // reserved
            new Uint8Array(u32(0)), // duration
            new Uint8Array(8), // reserved
            new Uint8Array(u16(0)), new Uint8Array(u16(0)), // layer, alt_group
            new Uint8Array(u16(0)), new Uint8Array(u16(0)), // volume, reserved
            // identity matrix
            new Uint8Array(u32(0x00010000)), new Uint8Array(u32(0)), new Uint8Array(u32(0)),
            new Uint8Array(u32(0)), new Uint8Array(u32(0x00010000)), new Uint8Array(u32(0)),
            new Uint8Array(u32(0)), new Uint8Array(u32(0)), new Uint8Array(u32(0x40000000)),
            new Uint8Array(u32(w << 16)), new Uint8Array(u32(h << 16))
        ));
        var trak = box('trak', concat(tkhd, mdia));

        var trex = box('trex', new Uint8Array([...u32(0), ...u32(1), ...u32(1), ...u32(0), ...u32(0), ...u32(0)]));
        var mvex = box('mvex', trex);

        var mvhd = box('mvhd', concat(
            new Uint8Array(u32(0)), new Uint8Array(u32(0)), new Uint8Array(u32(0)),
            new Uint8Array(u32(MSE_TIMESCALE)), new Uint8Array(u32(0)),
            new Uint8Array(u32(0x00010000)), new Uint8Array(u16(0x0100)),
            new Uint8Array(10),
            new Uint8Array(u32(0x00010000)), new Uint8Array(u32(0)), new Uint8Array(u32(0)),
            new Uint8Array(u32(0)), new Uint8Array(u32(0x00010000)), new Uint8Array(u32(0)),
            new Uint8Array(u32(0)), new Uint8Array(u32(0)), new Uint8Array(u32(0x40000000)),
            new Uint8Array(24),
            new Uint8Array(u32(2))
        ));
        var moov = box('moov', concat(mvhd, trak, mvex));

        return concat(ftyp, moov);
    }

    function nalToAvcc(nalBody) {
        // 4-byte length prefix + NAL body (including NAL header byte)
        var len = nalBody.length;
        var out = new Uint8Array(4 + len);
        out[0] = (len>>24)&0xFF; out[1] = (len>>16)&0xFF; out[2] = (len>>8)&0xFF; out[3] = len&0xFF;
        out.set(nalBody, 4);
        return out;
    }

    function createMediaSegment(avccData, isKeyframe) {
        var seq = mseSeqNum++;
        var dur = MSE_FRAME_DUR;

        // mfhd
        var mfhd = box('mfhd', new Uint8Array([...u32(0), ...u32(seq)]));

        // tfhd: default-base-is-moof
        var tfhd = box('tfhd', new Uint8Array([...u32(0x020000), ...u32(1)]));

        // tfdt: version=1, 64-bit baseMediaDecodeTime
        var tfdt = box('tfdt', new Uint8Array([
            1, 0, 0, 0, // version=1, flags=0
            ...u32(Math.floor(mseBaseTime / 0x100000000)),
            ...u32(mseBaseTime & 0xFFFFFFFF)
        ]));

        // trun: data-offset-present(1) | first-sample-flags-present(4) | duration(0x100) | size(0x200)
        var trunFlags = 0x000305;
        var sampleFlags = isKeyframe ? 0x02000000 : 0x01010000;
        var trunContent = new Uint8Array([
            ...u32(trunFlags),
            ...u32(1), // sample_count
            ...u32(0), // data_offset placeholder
            ...u32(sampleFlags),
            ...u32(dur),
            ...u32(avccData.length)
        ]);
        var trun = box('trun', trunContent);

        var traf = box('traf', concat(tfhd, tfdt, trun));
        var moofBytes = box('moof', concat(mfhd, traf));

        // Patch data_offset: offset from moof start to mdat payload
        var dataOffset = moofBytes.length + 8; // +8 for mdat header
        // data_offset is at: moof header(8) + mfhd box(16) + traf header(8) + tfhd box(16) + tfdt box(20) + trun header(8) + flags(4) + count(4) = offset 84
        var doPosInMoof = 8 + 16 + 8 + 16 + 20 + 8 + 4 + 4;
        moofBytes[doPosInMoof] = (dataOffset>>24)&0xFF;
        moofBytes[doPosInMoof+1] = (dataOffset>>16)&0xFF;
        moofBytes[doPosInMoof+2] = (dataOffset>>8)&0xFF;
        moofBytes[doPosInMoof+3] = dataOffset&0xFF;

        var mdat = box('mdat', avccData);

        mseBaseTime += dur;
        return concat(moofBytes, mdat);
    }

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
                    if (useWebCodecs) {
                        if (!decoderConfigured || gotNewSps || gotNewPps) configureWebCodecsDecoder();
                        decodeWebCodecsNal(nal, 'key');
                    } else {
                        if (!mseInitSent && cachedSps && cachedPps) {
                            var init = createInitSegment(cachedSps, cachedPps);
                            appendToMse(init);
                            mseInitSent = true;
                            mseSeqNum = 1;
                            mseBaseTime = 0;
                            console.log('MSE init segment sent');
                        }
                        if (mseInitSent) {
                            appendToMse(createMediaSegment(nalToAvcc(nal), true));
                            hideSplash();
                        }
                    }
                    break;
                case 1: // non-IDR
                    if (useWebCodecs) {
                        if (decoderConfigured) decodeWebCodecsNal(nal, 'delta');
                    } else {
                        if (mseInitSent) {
                            appendToMse(createMediaSegment(nalToAvcc(nal), false));
                            hideSplash();
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        if ((gotNewSps || gotNewPps) && cachedSps && cachedPps && useWebCodecs && !decoderConfigured) {
            configureWebCodecsDecoder();
        }
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

    // ---- WebSocket connection ----
    function connect() {
        var protocol = location.protocol === 'https:' ? 'wss:' : 'ws:';
        var url = protocol + '//' + location.host + '/ws';
        setStatus('buffering', mode.toUpperCase() + ': Connecting...');

        try { ws = new WebSocket(url); } catch (e) {
            setStatus('', 'Connection failed');
            scheduleReconnect();
            return;
        }
        ws.binaryType = 'arraybuffer';

        ws.onopen = function() {
            setStatus('connected', mode.toUpperCase() + ': Connected');
            reconnectDelay = 1000;
            if (window.SuperTeslaTouch) window.SuperTeslaTouch.setWebSocket(ws);
            ws.send(JSON.stringify({ action: 'START' }));
            ws.send(JSON.stringify({ action: 'REQUEST_KEYFRAME' }));
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
                processBinaryFrame(event.data);
                // Send ACK after processing video frame (TaaDa flow control)
                if (ws && ws.readyState === WebSocket.OPEN) {
                    ws.send(JSON.stringify({ action: 'ACK' }));
                }
            } else {
                try {
                    var msg = JSON.parse(event.data);
                    if (msg.type === 'status') setStatus('connected', msg.message || 'Connected');
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
        if (useWebCodecs) {
            decoderConfigured = false;
            frameTimestamp = 0;
            if (decoder) { try { decoder.close(); } catch(e) {} decoder = null; }
        } else {
            mseInitSent = false;
            mseQueue.length = 0;
            mseSeqNum = 1;
            mseBaseTime = 0;
            // Re-init MSE on reconnect
            if (mediaSource) {
                try { mediaSource.endOfStream(); } catch(e) {}
            }
            initMSE();
        }
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
    if (useWebCodecs) {
        canvasEl.style.display = 'block';
    } else {
        initMSE();
    }
    connect();

    // ---- Debug API ----
    window.SuperTeslaPlayer = {
        getMode: function() { return mode; },
        getDecoderState: function() { return decoder ? decoder.state : 'none'; },
        isConfigured: function() { return useWebCodecs ? decoderConfigured : mseInitSent; },
        getCodec: function() { return cachedSps ? codecStringFromSps(cachedSps) : null; }
    };
})();
