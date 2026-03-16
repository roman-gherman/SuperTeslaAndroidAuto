package org.bouncycastle.util.encoders;

/* JADX INFO: loaded from: classes2.dex */
public interface Translator {
    int decode(byte[] bArr, int i, int i3, byte[] bArr2, int i4);

    int encode(byte[] bArr, int i, int i3, byte[] bArr2, int i4);

    int getDecodedBlockSize();

    int getEncodedBlockSize();
}
