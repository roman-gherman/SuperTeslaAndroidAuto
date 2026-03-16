package org.mockito.internal.util;

import org.mockito.internal.exceptions.Reporter;

/* JADX INFO: loaded from: classes.dex */
public class Timer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long durationMillis;
    private long startTime = -1;

    public Timer(long j6) {
        validateInput(j6);
        this.durationMillis = j6;
    }

    private void validateInput(long j6) {
        if (j6 < 0) {
            throw Reporter.cannotCreateTimerWithNegativeDurationTime(j6);
        }
    }

    public long duration() {
        return this.durationMillis;
    }

    public boolean isCounting() {
        return System.currentTimeMillis() - this.startTime <= this.durationMillis;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }
}
