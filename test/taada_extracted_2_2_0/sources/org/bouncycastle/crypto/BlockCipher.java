package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes2.dex */
public interface BlockCipher {
    String getAlgorithmName();

    int getBlockSize();

    void init(boolean z6, CipherParameters cipherParameters);

    int processBlock(byte[] bArr, int i, byte[] bArr2, int i3);

    void reset();
}
