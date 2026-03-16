package fr.sd.taada.helpers.video;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FpsTracker {
    private final boolean isClientSide;
    private int frameCount = 0;
    private long lastSecondTime = 0;
    private int minFps = Integer.MAX_VALUE;
    private int maxFps = 0;
    private long sumFps = 0;
    private int samples = 0;
    private long lowFpsDurationMs = 0;

    public FpsTracker(boolean z6) {
        this.isClientSide = z6;
    }

    private void recordFps(int i, long j6) {
        if (i < this.minFps) {
            this.minFps = i;
        }
        if (i > this.maxFps) {
            this.maxFps = i;
        }
        this.sumFps += (long) i;
        this.samples++;
        if (i < 20) {
            this.lowFpsDurationMs += j6;
        }
    }

    public synchronized String getStats() {
        int i = this.samples;
        if (i == 0) {
            return "{}";
        }
        int i3 = (int) (this.sumFps / ((long) i));
        Locale locale = Locale.US;
        int i4 = this.minFps;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        return "{\"min\":" + i4 + ", \"max\":" + this.maxFps + ", \"avg\":" + i3 + ", \"low_ms\":" + this.lowFpsDurationMs + "}";
    }

    public synchronized Map<String, Object> getStatsMap(String str) {
        HashMap map;
        map = new HashMap();
        if (this.samples > 0) {
            String str2 = str + "min_fps";
            int i = this.minFps;
            if (i == Integer.MAX_VALUE) {
                i = 0;
            }
            map.put(str2, Integer.valueOf(i));
            map.put(str + "max_fps", Integer.valueOf(this.maxFps));
            map.put(str + "avg_fps", Integer.valueOf((int) (this.sumFps / ((long) this.samples))));
            map.put(str + "low_fps_ms", Long.valueOf(this.lowFpsDurationMs));
        }
        return map;
    }

    public synchronized void onFpsReported(int i) {
        recordFps(i, 1000L);
    }

    public synchronized void onFrame() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.lastSecondTime == 0) {
                this.lastSecondTime = jCurrentTimeMillis;
            }
            int i = this.frameCount + 1;
            this.frameCount = i;
            long j6 = this.lastSecondTime;
            if (jCurrentTimeMillis - j6 >= 1000) {
                recordFps(i, jCurrentTimeMillis - j6);
                this.frameCount = 0;
                this.lastSecondTime = jCurrentTimeMillis;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void reset() {
        this.frameCount = 0;
        this.lastSecondTime = 0L;
        this.minFps = Integer.MAX_VALUE;
        this.maxFps = 0;
        this.sumFps = 0L;
        this.samples = 0;
        this.lowFpsDurationMs = 0L;
    }
}
