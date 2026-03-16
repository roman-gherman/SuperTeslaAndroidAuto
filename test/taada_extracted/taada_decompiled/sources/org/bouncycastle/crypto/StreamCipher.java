package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes2.dex */
public interface StreamCipher {
    String getAlgorithmName();

    void init(boolean z6, CipherParameters cipherParameters);

    int processBytes(byte[] bArr, int i, int i3, byte[] bArr2, int i4);

    void reset();

    byte returnByte(byte b);
}
