package com.android.dx.io.instructions;

/* JADX INFO: loaded from: classes.dex */
public interface CodeOutput extends CodeCursor {
    void write(short s3);

    void write(short s3, short s6);

    void write(short s3, short s6, short s7);

    void write(short s3, short s6, short s7, short s8);

    void write(short s3, short s6, short s7, short s8, short s9);

    void write(byte[] bArr);

    void write(int[] iArr);

    void write(long[] jArr);

    void write(short[] sArr);

    void writeInt(int i);

    void writeLong(long j6);
}
