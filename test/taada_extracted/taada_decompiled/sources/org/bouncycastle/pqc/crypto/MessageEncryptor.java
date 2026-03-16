package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes2.dex */
public interface MessageEncryptor {
    void init(boolean z6, CipherParameters cipherParameters);

    byte[] messageDecrypt(byte[] bArr);

    byte[] messageEncrypt(byte[] bArr);
}
