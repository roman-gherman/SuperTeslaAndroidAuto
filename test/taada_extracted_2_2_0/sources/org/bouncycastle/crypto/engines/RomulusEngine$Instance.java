package org.bouncycastle.crypto.engines;

/* JADX INFO: loaded from: classes2.dex */
interface RomulusEngine$Instance {
    void processBufferAAD(byte[] bArr, int i);

    void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i3);

    void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i3);

    void processFinalAAD();

    void processFinalBlock(byte[] bArr, int i);

    void reset();
}
