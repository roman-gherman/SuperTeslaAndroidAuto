package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public interface HashFunction {
    int bits();

    b hashBytes(ByteBuffer byteBuffer);

    b hashBytes(byte[] bArr);

    b hashBytes(byte[] bArr, int i, int i3);

    b hashInt(int i);

    b hashLong(long j6);

    <T> b hashObject(T t6, Funnel<? super T> funnel);

    b hashString(CharSequence charSequence, Charset charset);

    b hashUnencodedChars(CharSequence charSequence);

    Hasher newHasher();

    Hasher newHasher(int i);
}
