package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public interface Hasher extends PrimitiveSink {
    b hash();

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBoolean(boolean z6);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putByte(byte b);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr, int i, int i3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putChar(char c);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putDouble(double d);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putFloat(float f6);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putInt(int i);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putLong(long j6);

    <T> Hasher putObject(T t6, Funnel<? super T> funnel);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putShort(short s3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putUnencodedChars(CharSequence charSequence);
}
