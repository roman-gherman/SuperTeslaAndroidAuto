(function() {
    'use strict';

    var video = document.getElementById('player');
    var splash = document.getElementById('splash');
    var statusDot = document.getElementById('status-dot');
    var statusText = document.getElementById('status-text');
    var videoContainer = document.getElementById('video-container');
    var ws = null;
    var mediaSource = null;
    var sourceBuffer = null;
    var queue = [];
    var appending = false;
    var mode = null;
    var reconnectTimer = null;
    var reconnectDelay = 1000;

    function setStatus(state, text) {
        statusDot.className = state;
        statusText.textContent = text;
    }

    function supportsMediaSource() {
        if (!window.MediaSource) return false;
        // Try multiple codec strings
        var codecs = [
            'video/mp4; codecs="avc1.42E01E"',   // Baseline
            'video/mp4; codecs="avc1.4D401E"',    // Main
            'video/mp4; codecs="avc1.64001E"',     // High
            'video/mp4; codecs="avc1.42C01E"'      // Constrained Baseline
        ];
        for (var i = 0; i < codecs.length; i++) {
            if (MediaSource.isTypeSupported(codecs[i])) return codecs[i];
        }
        return false;
    }

    function initMSE(codecString) {
        mode = 'mse';
        setStatus('buffering', 'MSE: Connecting...');

        mediaSource = new MediaSource();
        video.src = URL.createObjectURL(mediaSource);

        mediaSource.addEventListener('sourceopen', function() {
            try {
                sourceBuffer = mediaSource.addSourceBuffer(codecString);
            } catch (e) {
                console.error('Failed to create SourceBuffer:', e);
                fallbackToMJPEG();
                return;
            }

            sourceBuffer.addEventListener('updateend', onUpdateEnd);
            sourceBuffer.addEventListener('error', function(e) {
                console.error('SourceBuffer error:', e);
            });

            connectVideoWebSocket();
        }, { once: true });

        mediaSource.addEventListener('sourceended', function() {
            console.log('MediaSource ended');
        });

        video.addEventListener('error', function(e) {
            console.error('Video error:', video.error);
        });
    }

    function onUpdateEnd() {
        appending = false;

        // Trim old buffer to prevent memory growth
        try {
            if (sourceBuffer && sourceBuffer.buffered.length > 0) {
                var end = sourceBuffer.buffered.end(0);
                var start = sourceBuffer.buffered.start(0);
                if (end - start > 10) {
                    sourceBuffer.remove(start, end - 5);
                    return; // Will fire another updateend when remove completes
                }
            }
        } catch (e) {
            // Ignore buffer query errors
        }

        appendNext();
    }

    function appendNext() {
        if (!sourceBuffer || appending || queue.length === 0) return;
        if (sourceBuffer.updating) return;

        appending = true;
        try {
            sourceBuffer.appendBuffer(queue.shift());
        } catch (e) {
            appending = false;
            if (e.name === 'QuotaExceededError') {
                // Buffer full - drop oldest data
                console.warn('QuotaExceeded, clearing buffer');
                queue.length = 0;
                try {
                    var start = sourceBuffer.buffered.start(0);
                    var end = sourceBuffer.buffered.end(0);
                    sourceBuffer.remove(start, end - 2);
                } catch (e2) {}
            } else {
                console.error('appendBuffer error:', e);
            }
        }
    }

    function connectVideoWebSocket() {
        var protocol = location.protocol === 'https:' ? 'wss:' : 'ws:';
        var url = protocol + '//' + location.host + '/ws';

        setStatus('buffering', 'MSE: Connecting...');

        try {
            ws = new WebSocket(url);
        } catch (e) {
            setStatus('', 'Connection failed');
            scheduleReconnect();
            return;
        }

        ws.binaryType = 'arraybuffer';

        ws.onopen = function() {
            setStatus('connected', 'MSE: Connected');
            reconnectDelay = 1000;
            // Share WebSocket with touch handler
            if (window.SuperTeslaTouch) {
                window.SuperTeslaTouch.setWebSocket(ws);
            }
            // Tell server we're ready for video (AA relay mode control messages)
            ws.send(JSON.stringify({ action: 'START' }));
            ws.send(JSON.stringify({ action: 'REQUEST_KEYFRAME' }));
        };

        ws.onmessage = function(event) {
            if (event.data instanceof ArrayBuffer) {
                // Binary = fMP4 segment
                queue.push(new Uint8Array(event.data));
                if (!appending) appendNext();

                // Show video container, hide splash
                if (splash && !splash.classList.contains('hidden')) {
                    splash.classList.add('hidden');
                    videoContainer.style.display = 'block';
                }
            } else {
                // Text = control message
                try {
                    var msg = JSON.parse(event.data);
                    if (msg.type === 'status') {
                        setStatus('connected', msg.message || 'Connected');
                    }
                } catch (e) {}
            }
        };

        ws.onclose = function() {
            setStatus('', 'Disconnected');
            ws = null;
            scheduleReconnect();
        };

        ws.onerror = function() {
            setStatus('', 'Connection error');
        };

        // Keep playback near live edge
        setInterval(function() {
            if (video.buffered.length > 0) {
                var liveEdge = video.buffered.end(video.buffered.length - 1);
                if (liveEdge - video.currentTime > 1.5) {
                    video.currentTime = liveEdge - 0.1;
                }
            }
        }, 1000);
    }

    function fallbackToMJPEG() {
        mode = 'mjpeg';
        setStatus('buffering', 'MJPEG mode');

        var img = document.createElement('img');
        img.id = 'player';
        img.src = '/stream.mjpeg';
        img.style.width = '100%';
        img.style.height = '100%';
        img.style.objectFit = 'contain';
        img.style.background = '#000';

        img.onload = function() {
            if (splash && !splash.classList.contains('hidden')) {
                splash.classList.add('hidden');
                videoContainer.style.display = 'block';
            }
            setStatus('connected', 'MJPEG: Playing');
        };

        img.onerror = function() {
            setStatus('', 'MJPEG stream error');
            setTimeout(function() {
                img.src = '/stream.mjpeg?' + Date.now();
            }, 2000);
        };

        video.replaceWith(img);
    }

    // ---- WebRTC ----
    var rtcPc = null;
    var rtcDataChannel = null;

    function supportsWebRTC() {
        return !!(window.RTCPeerConnection);
    }

    function initWebRTC() {
        mode = 'webrtc';
        setStatus('buffering', 'WebRTC: Connecting...');

        rtcPc = new RTCPeerConnection({ iceServers: [] });

        rtcPc.ontrack = function(event) {
            video.srcObject = event.streams[0];
            video.play().catch(function() {});
            if (splash && !splash.classList.contains('hidden')) {
                splash.classList.add('hidden');
                videoContainer.style.display = 'block';
            }
            setStatus('connected', 'WebRTC: Playing');
        };

        rtcPc.ondatachannel = function(event) {
            rtcDataChannel = event.channel;
            rtcDataChannel.onopen = function() {
                console.log('WebRTC DataChannel open - switching touch transport');
                if (window.SuperTeslaTouch) {
                    window.SuperTeslaTouch.setDataChannel(rtcDataChannel);
                }
            };
            rtcDataChannel.onmessage = function(e) {
                console.log('DC message:', e.data);
            };
        };

        rtcPc.oniceconnectionstatechange = function() {
            console.log('ICE state:', rtcPc.iceConnectionState);
            if (rtcPc.iceConnectionState === 'failed' || rtcPc.iceConnectionState === 'disconnected') {
                setStatus('', 'WebRTC: Disconnected');
                scheduleReconnect();
            }
        };

        rtcPc.createOffer({ offerToReceiveVideo: true, offerToReceiveAudio: true })
            .then(function(offer) { return rtcPc.setLocalDescription(offer); })
            .then(function() {
                // Wait for ICE gathering
                return new Promise(function(resolve) {
                    if (rtcPc.iceGatheringState === 'complete') { resolve(); return; }
                    var timeout = setTimeout(resolve, 3000);
                    rtcPc.addEventListener('icegatheringstatechange', function() {
                        if (rtcPc.iceGatheringState === 'complete') {
                            clearTimeout(timeout);
                            resolve();
                        }
                    });
                });
            })
            .then(function() {
                return fetch('/webrtc/offer', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ type: 'offer', sdp: rtcPc.localDescription.sdp })
                });
            })
            .then(function(resp) {
                if (!resp.ok) throw new Error('Signaling failed: ' + resp.status);
                return resp.json();
            })
            .then(function(answer) {
                return rtcPc.setRemoteDescription(new RTCSessionDescription(answer));
            })
            .then(function() {
                setStatus('connected', 'WebRTC: Connected');
                reconnectDelay = 1000;
                // Also connect MSE WebSocket for fallback touch transport
                connectVideoWebSocket();
            })
            .catch(function(err) {
                console.warn('WebRTC failed, falling back:', err);
                cleanupWebRTC();
                fallbackToMSE();
            });
    }

    function cleanupWebRTC() {
        if (rtcDataChannel) { try { rtcDataChannel.close(); } catch(e){} rtcDataChannel = null; }
        if (rtcPc) { try { rtcPc.close(); } catch(e){} rtcPc = null; }
    }

    function fallbackToMSE() {
        var codec = supportsMediaSource();
        if (codec) {
            initMSE(codec);
        } else {
            fallbackToMJPEG();
        }
    }

    function scheduleReconnect() {
        if (reconnectTimer) return;
        reconnectTimer = setTimeout(function() {
            reconnectTimer = null;

            cleanupWebRTC();
            queue.length = 0;
            appending = false;
            if (mediaSource && mediaSource.readyState === 'open') {
                try { mediaSource.endOfStream(); } catch (e) {}
            }
            mediaSource = null;
            sourceBuffer = null;

            // Try WebRTC first, then MSE, then MJPEG
            startPlayer();
        }, reconnectDelay);
        reconnectDelay = Math.min(reconnectDelay * 1.5, 10000);
    }

    function startPlayer() {
        if (supportsWebRTC()) {
            // Check if server supports WebRTC
            fetch('/webrtc/status').then(function(r) { return r.json(); })
                .then(function(data) {
                    if (data.initialized !== undefined) {
                        initWebRTC();
                    } else {
                        fallbackToMSE();
                    }
                })
                .catch(function() { fallbackToMSE(); });
        } else {
            fallbackToMSE();
        }
    }

    // ---- Initialize ----
    startPlayer();

    // Prevent default touch behaviors
    document.addEventListener('touchstart', function(e) {
        if (e.target.id === 'touchpad') e.preventDefault();
    }, { passive: false });
    document.addEventListener('contextmenu', function(e) { e.preventDefault(); });

    // Expose for debugging
    window.SuperTeslaPlayer = {
        getMode: function() { return mode; },
        getBuffered: function() {
            if (video.buffered.length > 0) {
                return {
                    start: video.buffered.start(0),
                    end: video.buffered.end(0),
                    current: video.currentTime
                };
            }
            return null;
        },
        getQueueSize: function() { return queue.length; }
    };
})();
