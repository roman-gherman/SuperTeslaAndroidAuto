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

    // Scheduling state per channel type — chains buffers gaplessly
    var nextTime = { 1: 0, 2: 0, 3: 0 };
    var gainNodes = {};

    function ensureContext() {
        if (!ctx) {
            ctx = new AudioCtx({ sampleRate: 48000 });
            // Create gain nodes per channel type
            for (var t in CONFIGS) {
                gainNodes[t] = ctx.createGain();
                gainNodes[t].connect(ctx.destination);
            }
        }
        if (ctx.state === 'suspended') ctx.resume();
    }

    function feed(type, pcmBytes) {
        ensureContext();
        // Drop audio if context is still suspended (no user gesture yet) to avoid
        // accumulating a huge backlog that plays all at once when resumed.
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
        // If we've fallen behind, skip ahead to avoid accumulating latency
        if (nextTime[type] < now - 0.1) {
            nextTime[type] = now;
        }
        source.start(nextTime[type]);
        nextTime[type] += buffer.duration;
    }

    // Resume AudioContext on any user interaction (browser autoplay policy)
    ['pointerdown', 'keydown', 'click'].forEach(function(evt) {
        document.addEventListener(evt, function() {
            ensureContext();
            if (ctx && ctx.state !== 'running') {
                console.log('Audio: context state =', ctx.state);
            }
        });
    });

    window.SuperTeslaAudioPCM = {
        feed: feed,
        setVolume: function(type, vol) {
            if (gainNodes[type]) gainNodes[type].gain.value = Math.max(0, Math.min(2, vol));
        },
        getContext: function() { return ctx; }
    };
})();
