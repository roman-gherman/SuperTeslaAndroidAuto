(function() {
    'use strict';

    var touchpad = document.getElementById('touchpad');
    var videoEl = document.getElementById('player');
    var activePointers = {};
    var pendingMoves = {};
    var rafScheduled = false;
    var ws = null;
    var dc = null; // WebRTC DataChannel (preferred transport)

    // Allow player.js to set transport references
    window.SuperTeslaTouch = {
        setWebSocket: function(socket) {
            ws = socket;
        },
        setDataChannel: function(dataChannel) {
            dc = dataChannel;
        }
    };

    function getVideoRect() {
        // Get the actual video display area (accounting for object-fit: contain letterboxing)
        var el = document.getElementById('player');
        if (!el) return null;
        return el.getBoundingClientRect();
    }

    function normalizeCoords(event) {
        var rect = getVideoRect();
        if (!rect || rect.width === 0 || rect.height === 0) {
            return { x: 0.5, y: 0.5 };
        }
        var x = (event.clientX - rect.left) / rect.width;
        var y = (event.clientY - rect.top) / rect.height;
        return {
            x: Math.max(0, Math.min(1, x)),
            y: Math.max(0, Math.min(1, y))
        };
    }

    function sendTouch(action, pointerId, coords) {
        var msg = JSON.stringify({
            type: 'touch',
            action: action,
            pointerId: pointerId,
            x: coords.x,
            y: coords.y,
            timestamp: Date.now()
        });

        // Prefer DataChannel (lower latency) over WebSocket
        if (dc && dc.readyState === 'open') {
            dc.send(msg);
            return;
        }
        if (ws && ws.readyState === WebSocket.OPEN) {
            ws.send(msg);
        }
    }

    // Pointer Events (preferred - supports multi-touch)
    if (touchpad) {
        touchpad.addEventListener('pointerdown', function(e) {
            e.preventDefault();
            touchpad.setPointerCapture(e.pointerId);
            var coords = normalizeCoords(e);
            activePointers[e.pointerId] = coords;
            sendTouch('down', e.pointerId, coords);
        });

        touchpad.addEventListener('pointermove', function(e) {
            if (!(e.pointerId in activePointers)) return;
            var coords = normalizeCoords(e);
            activePointers[e.pointerId] = coords;

            // Throttle move events via requestAnimationFrame
            pendingMoves[e.pointerId] = coords;
            if (!rafScheduled) {
                rafScheduled = true;
                requestAnimationFrame(function() {
                    var ids = Object.keys(pendingMoves);
                    for (var i = 0; i < ids.length; i++) {
                        var id = parseInt(ids[i]);
                        sendTouch('move', id, pendingMoves[id]);
                    }
                    pendingMoves = {};
                    rafScheduled = false;
                });
            }
        });

        touchpad.addEventListener('pointerup', function(e) {
            if (!(e.pointerId in activePointers)) return;
            var coords = normalizeCoords(e);
            delete activePointers[e.pointerId];
            delete pendingMoves[e.pointerId];
            sendTouch('up', e.pointerId, coords);
        });

        touchpad.addEventListener('pointercancel', function(e) {
            if (!(e.pointerId in activePointers)) return;
            var coords = activePointers[e.pointerId] || normalizeCoords(e);
            delete activePointers[e.pointerId];
            delete pendingMoves[e.pointerId];
            sendTouch('up', e.pointerId, coords);
        });

        // Prevent all default touch behaviors
        touchpad.addEventListener('touchstart', function(e) { e.preventDefault(); }, { passive: false });
        touchpad.addEventListener('touchmove', function(e) { e.preventDefault(); }, { passive: false });
        touchpad.addEventListener('touchend', function(e) { e.preventDefault(); }, { passive: false });
        touchpad.addEventListener('contextmenu', function(e) { e.preventDefault(); });

        // Mouse wheel -> vertical swipe gesture
        touchpad.addEventListener('wheel', function(e) {
            e.preventDefault();
            var coords = normalizeCoords(e);
            var deltaY = Math.sign(e.deltaY) * 0.05; // normalize scroll amount

            sendTouch('down', 99, coords);
            setTimeout(function() {
                sendTouch('move', 99, { x: coords.x, y: Math.max(0, Math.min(1, coords.y + deltaY)) });
                setTimeout(function() {
                    sendTouch('up', 99, { x: coords.x, y: Math.max(0, Math.min(1, coords.y + deltaY * 2)) });
                }, 16);
            }, 16);
        }, { passive: false });
    }

    // Prevent browser-level gestures
    document.addEventListener('gesturestart', function(e) { e.preventDefault(); });
    document.addEventListener('gesturechange', function(e) { e.preventDefault(); });
    document.addEventListener('gestureend', function(e) { e.preventDefault(); });
})();
