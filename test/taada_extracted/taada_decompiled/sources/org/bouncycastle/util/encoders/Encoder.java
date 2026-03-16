package org.bouncycastle.util.encoders;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface Encoder {
    int decode(String str, OutputStream outputStream);

    int decode(byte[] bArr, int i, int i3, OutputStream outputStream);

    int encode(byte[] bArr, int i, int i3, OutputStream outputStream);

    int getEncodedLength(int i);

    int getMaxDecodedLength(int i);
}
