package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes2.dex */
public interface Wrapper {
    String getAlgorithmName();

    void init(boolean z6, CipherParameters cipherParameters);

    byte[] unwrap(byte[] bArr, int i, int i3);

    byte[] wrap(byte[] bArr, int i, int i3);
}
