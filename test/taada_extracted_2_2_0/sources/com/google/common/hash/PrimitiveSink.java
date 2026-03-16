package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public interface PrimitiveSink {
    PrimitiveSink putBoolean(boolean z6);

    PrimitiveSink putByte(byte b);

    PrimitiveSink putBytes(ByteBuffer byteBuffer);

    PrimitiveSink putBytes(byte[] bArr);

    PrimitiveSink putBytes(byte[] bArr, int i, int i3);

    PrimitiveSink putChar(char c);

    PrimitiveSink putDouble(double d);

    PrimitiveSink putFloat(float f6);

    PrimitiveSink putInt(int i);

    PrimitiveSink putLong(long j6);

    PrimitiveSink putShort(short s3);

    PrimitiveSink putString(CharSequence charSequence, Charset charset);

    PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
