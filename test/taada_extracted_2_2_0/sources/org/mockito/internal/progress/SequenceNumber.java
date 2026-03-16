package org.mockito.internal.progress;

/* JADX INFO: loaded from: classes.dex */
public final class SequenceNumber {
    private static int sequenceNumber = 1;

    private SequenceNumber() {
    }

    public static synchronized int next() {
        int i;
        i = sequenceNumber;
        sequenceNumber = i + 1;
        return i;
    }
}
