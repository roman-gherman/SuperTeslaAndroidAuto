package org.bouncycastle.crypto.digests;

/* JADX INFO: loaded from: classes2.dex */
public interface BufferBaseDigest$ProcessingBuffer {
    boolean isLengthExceedingBlockSize(int i, int i3);

    boolean isLengthWithinAvailableSpace(int i, int i3);

    void update(byte b);
}
