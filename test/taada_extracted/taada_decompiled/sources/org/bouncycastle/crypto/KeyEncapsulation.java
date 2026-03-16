package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes2.dex */
public interface KeyEncapsulation {
    CipherParameters decrypt(byte[] bArr, int i, int i3, int i4);

    CipherParameters encrypt(byte[] bArr, int i, int i3);

    void init(CipherParameters cipherParameters);
}
