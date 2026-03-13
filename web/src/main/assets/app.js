(function() {
    'use strict';

    var statusDot = document.getElementById('status-dot');
    var statusText = document.getElementById('status-text');
    var splash = document.getElementById('splash');
    var connectionInfo = document.getElementById('connection-info');
    var ws = null;
    var reconnectTimer = null;
    var reconnectDelay = 1000;

    function setStatus(state, text) {
        statusDot.className = state;
        statusText.textContent = text;
    }

    function connectWebSocket() {
        var protocol = location.protocol === 'https:' ? 'wss:' : 'ws:';
        var url = protocol + '//' + location.host + '/ws';

        setStatus('buffering', 'Connecting...');

        try {
            ws = new WebSocket(url);
        } catch (e) {
            setStatus('', 'Connection failed');
            scheduleReconnect();
            return;
        }

        ws.binaryType = 'arraybuffer';

        ws.onopen = function() {
            setStatus('connected', 'Connected');
            reconnectDelay = 1000;
            connectionInfo.textContent = 'WebSocket connected to ' + location.host;
        };

        ws.onclose = function() {
            setStatus('', 'Disconnected');
            ws = null;
            scheduleReconnect();
        };

        ws.onerror = function() {
            setStatus('', 'Connection error');
        };

        ws.onmessage = function(event) {
            // Phase 3+: Handle video stream data
            // Phase 4+: Handle control messages
            if (typeof event.data === 'string') {
                try {
                    var msg = JSON.parse(event.data);
                    if (msg.type === 'status') {
                        setStatus('connected', msg.message || 'Connected');
                    }
                } catch (e) {
                    // Ignore parse errors
                }
            }
        };
    }

    function scheduleReconnect() {
        if (reconnectTimer) return;
        reconnectTimer = setTimeout(function() {
            reconnectTimer = null;
            connectWebSocket();
        }, reconnectDelay);
        reconnectDelay = Math.min(reconnectDelay * 1.5, 10000);
    }

    // Check server health
    function checkHealth() {
        fetch('/health')
            .then(function(r) { return r.text(); })
            .then(function(text) {
                if (text === 'ok') {
                    connectionInfo.textContent = 'Server: ' + location.host + ' - OK';
                }
            })
            .catch(function() {
                connectionInfo.textContent = 'Server not reachable';
            });
    }

    // Initialize
    checkHealth();
    connectWebSocket();

    // Periodic health check
    setInterval(checkHealth, 10000);

    // Prevent default touch behaviors
    document.addEventListener('touchstart', function(e) {
        if (e.target.id === 'touchpad') {
            e.preventDefault();
        }
    }, { passive: false });

    document.addEventListener('contextmenu', function(e) {
        e.preventDefault();
    });
})();
