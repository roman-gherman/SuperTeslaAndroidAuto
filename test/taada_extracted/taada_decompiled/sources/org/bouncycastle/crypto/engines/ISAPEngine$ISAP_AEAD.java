package org.bouncycastle.crypto.engines;

/* JADX INFO: loaded from: classes2.dex */
interface ISAPEngine$ISAP_AEAD {
    void absorbFinalAADBlock();

    void absorbMacBlock(byte[] bArr, int i);

    void init();

    void processEncBlock(byte[] bArr, int i, byte[] bArr2, int i3);

    void processEncFinalBlock(byte[] bArr, int i);

    void processMACFinal(byte[] bArr, int i, int i3, byte[] bArr2);

    void reset();
}
