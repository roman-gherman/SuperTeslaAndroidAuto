package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes2.dex */
public interface DerivationFunction {
    int generateBytes(byte[] bArr, int i, int i3);

    void init(DerivationParameters derivationParameters);
}
