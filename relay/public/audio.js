(function() {
    'use strict';

    var AudioCtx = window.AudioContext || window.webkitAudioContext;
    var ctx = null;

    // Audio params per channel type (must match AA ServiceDiscovery)
    var CONFIGS = {
        1: { sampleRate: 48000, channels: 2 },  // MEDIA (music)
        2: { sampleRate: 16000, channels: 1 },   // SPEECH (guidance)
        3: { sampleRate: 16000, channels: 1 }    // SYSTEM (notifications)
    };

    var gainNodes = {};

    // Jitter buffer: schedule audio slightly ahead to absorb network jitter.
    // BUFFER_AHEAD_MS is how far ahead we schedule. Higher = more resilient, more latency.
    var BUFFER_AHEAD_MS = 80;  // 80ms jitter buffer
    var MAX_DRIFT_MS = 200;    // If scheduled time drifts >200ms ahead, reset

    // Per-channel scheduling state
    var nextTime = { 1: 0, 2: 0, 3: 0 };
    var chunkCount = { 1: 0, 2: 0, 3: 0 };

    function ensureContext() {
        if (!ctx) {
            ctx = new AudioCtx({ sampleRate: 48000 });
            for (var t in CONFIGS) {
                gainNodes[t] = ctx.createGain();
                gainNodes[t].gain.value = 1.0;
                gainNodes[t].connect(ctx.destination);
            }
        }
        if (ctx.state === 'suspended') ctx.resume();
    }

    function feed(type, pcmBytes) {
        if (!ctx) return;
        if (ctx.state === 'suspended') return;
        var config = CONFIGS[type];
        if (!config || pcmBytes.length < 4) return;

        var sampleCount = Math.floor(pcmBytes.length / 2);
        var channelCount = config.channels;
        var framesPerChannel = Math.floor(sampleCount / channelCount);
        if (framesPerChannel === 0) return;

        var buffer = ctx.createBuffer(channelCount, framesPerChannel, config.sampleRate);
        var view = new DataView(pcmBytes.buffer, pcmBytes.byteOffset, pcmBytes.byteLength);

        for (var ch = 0; ch < channelCount; ch++) {
            var channelData = buffer.getChannelData(ch);
            for (var i = 0; i < framesPerChannel; i++) {
                var idx = (i * channelCount + ch) * 2;
                if (idx + 1 < pcmBytes.length) {
                    channelData[i] = view.getInt16(idx, true) / 32768.0;
                }
            }
        }

        var source = ctx.createBufferSource();
        source.buffer = buffer;
        source.connect(gainNodes[type] || ctx.destination);

        var now = ctx.currentTime;
        var bufferAhead = BUFFER_AHEAD_MS / 1000;

        // Initialize scheduling on first chunk
        if (nextTime[type] === 0 || chunkCount[type] === 0) {
            nextTime[type] = now + bufferAhead;
        }

        // If we've fallen behind (network delay), catch up
        if (nextTime[type] < now) {
            // Drop this chunk silently — we're behind, skip to stay in sync
            nextTime[type] = now + bufferAhead;
        }

        // If we're too far ahead (buffered too much), reset
        if (nextTime[type] > now + MAX_DRIFT_MS / 1000) {
            nextTime[type] = now + bufferAhead;
        }

        source.start(nextTime[type]);
        nextTime[type] += buffer.duration;
        chunkCount[type]++;
    }

    // Resume AudioContext on any user interaction (browser autoplay policy)
    ['pointerdown', 'keydown', 'click'].forEach(function(evt) {
        document.addEventListener(evt, function() {
            ensureContext();
        });
    });

    window.SuperTeslaAudioPCM = {
        feed: feed,
        setVolume: function(type, vol) {
            if (gainNodes[type]) gainNodes[type].gain.value = Math.max(0, Math.min(2, vol));
        },
        getContext: function() { return ctx; },
        getStats: function() {
            return {
                chunks: Object.assign({}, chunkCount),
                drift: ctx ? {
                    1: ((nextTime[1] - ctx.currentTime) * 1000).toFixed(0) + 'ms',
                    2: ((nextTime[2] - ctx.currentTime) * 1000).toFixed(0) + 'ms',
                    3: ((nextTime[3] - ctx.currentTime) * 1000).toFixed(0) + 'ms'
                } : {}
            };
        }
    };
})();
