package org.bouncycastle.crypto.engines;

/* JADX INFO: loaded from: classes2.dex */
public interface AEADBaseEngine$AADOperator {
    int getLen();

    void processAADByte(byte b);

    void processAADBytes(byte[] bArr, int i, int i3);

    void reset();
}
