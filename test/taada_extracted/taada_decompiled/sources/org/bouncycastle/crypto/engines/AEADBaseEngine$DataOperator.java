package org.bouncycastle.crypto.engines;

/* JADX INFO: loaded from: classes2.dex */
public interface AEADBaseEngine$DataOperator {
    int getLen();

    int processByte(byte b, byte[] bArr, int i);

    int processBytes(byte[] bArr, int i, int i3, byte[] bArr2, int i4);

    void reset();
}
