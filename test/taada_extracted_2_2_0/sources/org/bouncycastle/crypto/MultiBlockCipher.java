package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes2.dex */
public interface MultiBlockCipher extends BlockCipher {
    int getMultiBlockSize();

    int processBlocks(byte[] bArr, int i, int i3, byte[] bArr2, int i4);
}
