package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes2.dex */
public interface Signer {
    byte[] generateSignature();

    void init(boolean z6, CipherParameters cipherParameters);

    void reset();

    void update(byte b);

    void update(byte[] bArr, int i, int i3);

    boolean verifySignature(byte[] bArr);
}
