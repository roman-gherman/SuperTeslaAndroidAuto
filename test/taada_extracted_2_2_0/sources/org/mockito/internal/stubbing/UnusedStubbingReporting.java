package org.mockito.internal.stubbing;

import org.mockito.quality.Strictness;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
public final class UnusedStubbingReporting {
    private UnusedStubbingReporting() {
    }

    public static boolean shouldBeReported(Stubbing stubbing) {
        return (stubbing.wasUsed() || stubbing.getStrictness() == Strictness.LENIENT) ? false : true;
    }
}
