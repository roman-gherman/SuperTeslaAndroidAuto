(function() {
    'use strict';

    var video = document.getElementById('player');
    var unmuted = false;
    var volumeSlider = null;
    var volumeTimeout = null;

    // Unmute on first user interaction (required by browser autoplay policy)
    function tryUnmute() {
        if (unmuted) return;
        if (!video) {
            video = document.getElementById('player');
            if (!video) return;
        }

        video.muted = false;
        video.volume = 1.0;
        unmuted = true;

        // Resume AudioContext if needed
        var AudioCtx = window.AudioContext || window.webkitAudioContext;
        if (AudioCtx) {
            var ctx = new AudioCtx();
            if (ctx.state === 'suspended') {
                ctx.resume();
            }
        }

        showVolumeIndicator();
        console.log('Audio unmuted');
    }

    function showVolumeIndicator() {
        // Brief visual indicator that audio is enabled
        var indicator = document.createElement('div');
        indicator.id = 'audio-indicator';
        indicator.textContent = 'Audio ON';
        indicator.style.cssText = 'position:fixed;bottom:20px;left:50%;transform:translateX(-50%);' +
            'background:rgba(0,0,0,0.7);color:#4caf50;padding:8px 20px;border-radius:20px;' +
            'font-size:14px;z-index:100;transition:opacity 0.5s;pointer-events:none;';
        document.body.appendChild(indicator);

        setTimeout(function() {
            indicator.style.opacity = '0';
            setTimeout(function() { indicator.remove(); }, 500);
        }, 2000);
    }

    // Volume control (shown on double-tap or via API)
    function createVolumeSlider() {
        if (volumeSlider) return;

        volumeSlider = document.createElement('div');
        volumeSlider.id = 'volume-control';
        volumeSlider.style.cssText = 'position:fixed;bottom:60px;left:50%;transform:translateX(-50%);' +
            'background:rgba(0,0,0,0.8);padding:12px 20px;border-radius:12px;z-index:90;' +
            'display:flex;align-items:center;gap:10px;transition:opacity 0.3s;';

        var label = document.createElement('span');
        label.textContent = 'Vol';
        label.style.cssText = 'color:#fff;font-size:12px;';

        var slider = document.createElement('input');
        slider.type = 'range';
        slider.min = '0';
        slider.max = '100';
        slider.value = '100';
        slider.style.cssText = 'width:150px;accent-color:#4fc3f7;';
        slider.addEventListener('input', function() {
            if (video) video.volume = parseInt(slider.value) / 100;
            resetVolumeTimeout();
        });

        volumeSlider.appendChild(label);
        volumeSlider.appendChild(slider);
        document.body.appendChild(volumeSlider);

        resetVolumeTimeout();
    }

    function resetVolumeTimeout() {
        if (volumeTimeout) clearTimeout(volumeTimeout);
        if (volumeSlider) volumeSlider.style.opacity = '1';
        volumeTimeout = setTimeout(function() {
            if (volumeSlider) {
                volumeSlider.style.opacity = '0';
                setTimeout(function() {
                    if (volumeSlider) { volumeSlider.remove(); volumeSlider = null; }
                }, 300);
            }
        }, 4000);
    }

    // Listen for first interaction to unmute
    document.addEventListener('pointerdown', function() {
        tryUnmute();
    }, { once: false });

    // Double-tap shows volume control
    var lastTap = 0;
    document.addEventListener('pointerdown', function(e) {
        var now = Date.now();
        if (now - lastTap < 300) {
            createVolumeSlider();
        }
        lastTap = now;
    });

    // Expose for external control
    window.SuperTeslaAudio = {
        unmute: tryUnmute,
        setVolume: function(v) {
            if (video) video.volume = Math.max(0, Math.min(1, v));
        },
        getVolume: function() {
            return video ? video.volume : 0;
        },
        isMuted: function() {
            return video ? video.muted : true;
        },
        showVolumeControl: createVolumeSlider
    };
})();
