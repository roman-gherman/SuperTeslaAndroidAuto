package org.bouncycastle.crypto.engines;

/* JADX INFO: loaded from: classes2.dex */
interface AEADBaseEngine$AADProcessingBuffer {
    int getUpdateOutputSize(int i);

    boolean isLengthExceedingBlockSize(int i, int i3);

    boolean isLengthWithinAvailableSpace(int i, int i3);

    void processAADByte(byte b);

    int processByte(byte b, byte[] bArr, int i);
}
