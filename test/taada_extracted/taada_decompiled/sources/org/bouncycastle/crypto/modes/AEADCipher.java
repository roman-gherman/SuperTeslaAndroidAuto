package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes2.dex */
public interface AEADCipher {
    int doFinal(byte[] bArr, int i);

    String getAlgorithmName();

    byte[] getMac();

    int getOutputSize(int i);

    int getUpdateOutputSize(int i);

    void init(boolean z6, CipherParameters cipherParameters);

    void processAADByte(byte b);

    void processAADBytes(byte[] bArr, int i, int i3);

    int processByte(byte b, byte[] bArr, int i);

    int processBytes(byte[] bArr, int i, int i3, byte[] bArr2, int i4);

    void reset();
}
