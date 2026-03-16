package org.bouncycastle.jcajce.provider.symmetric.util;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes2.dex */
interface BaseBlockCipher$GenericBlockCipher {
    int doFinal(byte[] bArr, int i);

    String getAlgorithmName();

    int getOutputSize(int i);

    BlockCipher getUnderlyingCipher();

    int getUpdateOutputSize(int i);

    void init(boolean z6, CipherParameters cipherParameters);

    int processByte(byte b, byte[] bArr, int i);

    int processBytes(byte[] bArr, int i, int i3, byte[] bArr2, int i4);

    void updateAAD(byte[] bArr, int i, int i3);

    boolean wrapOnNoPadding();
}
