package com.android.dx.io.instructions;

/* JADX INFO: loaded from: classes.dex */
public final class ShortArrayCodeOutput extends BaseCodeCursor implements CodeOutput {
    private final short[] array;

    public ShortArrayCodeOutput(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("maxSize < 0");
        }
        this.array = new short[i];
    }

    public short[] getArray() {
        int iCursor = cursor();
        short[] sArr = this.array;
        if (iCursor == sArr.length) {
            return sArr;
        }
        short[] sArr2 = new short[iCursor];
        System.arraycopy(sArr, 0, sArr2, 0, iCursor);
        return sArr2;
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void write(short s3) {
        this.array[cursor()] = s3;
        advance(1);
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void writeInt(int i) {
        write((short) i);
        write((short) (i >> 16));
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void writeLong(long j6) {
        write((short) j6);
        write((short) (j6 >> 16));
        write((short) (j6 >> 32));
        write((short) (j6 >> 48));
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void write(short s3, short s6) {
        write(s3);
        write(s6);
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void write(short s3, short s6, short s7) {
        write(s3);
        write(s6);
        write(s7);
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void write(short s3, short s6, short s7, short s8) {
        write(s3);
        write(s6);
        write(s7);
        write(s8);
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void write(short s3, short s6, short s7, short s8, short s9) {
        write(s3);
        write(s6);
        write(s7);
        write(s8);
        write(s9);
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void write(byte[] bArr) {
        int i = 0;
        boolean z6 = true;
        for (byte b : bArr) {
            if (z6) {
                i = b & 255;
                z6 = false;
            } else {
                int i3 = (b << 8) | i;
                write((short) i3);
                i = i3;
                z6 = true;
            }
        }
        if (z6) {
            return;
        }
        write((short) i);
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void write(short[] sArr) {
        for (short s3 : sArr) {
            write(s3);
        }
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void write(int[] iArr) {
        for (int i : iArr) {
            writeInt(i);
        }
    }

    @Override // com.android.dx.io.instructions.CodeOutput
    public void write(long[] jArr) {
        for (long j6 : jArr) {
            writeLong(j6);
        }
    }
}
