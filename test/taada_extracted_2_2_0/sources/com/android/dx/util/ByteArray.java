package com.android.dx.util;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ByteArray {
    private final byte[] bytes;
    private final int size;
    private final int start;

    public interface GetCursor {
        int getCursor();
    }

    public static class MyDataInputStream extends DataInputStream {
        private final MyInputStream wrapped;

        public MyDataInputStream(MyInputStream myInputStream) {
            super(myInputStream);
            this.wrapped = myInputStream;
        }
    }

    public ByteArray(byte[] bArr, int i, int i3) {
        if (bArr == null) {
            throw new NullPointerException("bytes == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (i3 < i) {
            throw new IllegalArgumentException("end < start");
        }
        if (i3 > bArr.length) {
            throw new IllegalArgumentException("end > bytes.length");
        }
        this.bytes = bArr;
        this.start = i;
        this.size = i3 - i;
    }

    private void checkOffsets(int i, int i3) {
        if (i < 0 || i3 < i || i3 > this.size) {
            throw new IllegalArgumentException("bad range: " + i + ".." + i3 + "; actual size " + this.size);
        }
    }

    private int getByte0(int i) {
        return this.bytes[this.start + i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getUnsignedByte0(int i) {
        return this.bytes[this.start + i] & 255;
    }

    public int getByte(int i) {
        checkOffsets(i, i + 1);
        return getByte0(i);
    }

    public void getBytes(byte[] bArr, int i) {
        int length = bArr.length - i;
        int i3 = this.size;
        if (length < i3) {
            throw new IndexOutOfBoundsException("(out.length - offset) < size()");
        }
        System.arraycopy(this.bytes, this.start, bArr, i, i3);
    }

    public int getInt(int i) {
        checkOffsets(i, i + 4);
        return getUnsignedByte0(i + 3) | (getByte0(i) << 24) | (getUnsignedByte0(i + 1) << 16) | (getUnsignedByte0(i + 2) << 8);
    }

    public long getLong(int i) {
        checkOffsets(i, i + 8);
        int byte0 = (getByte0(i) << 24) | (getUnsignedByte0(i + 1) << 16) | (getUnsignedByte0(i + 2) << 8) | getUnsignedByte0(i + 3);
        return (((long) (getUnsignedByte0(i + 7) | (getByte0(i + 4) << 24) | (getUnsignedByte0(i + 5) << 16) | (getUnsignedByte0(i + 6) << 8))) & 4294967295L) | (((long) byte0) << 32);
    }

    public int getShort(int i) {
        checkOffsets(i, i + 2);
        return getUnsignedByte0(i + 1) | (getByte0(i) << 8);
    }

    public int getUnsignedByte(int i) {
        checkOffsets(i, i + 1);
        return getUnsignedByte0(i);
    }

    public int getUnsignedShort(int i) {
        checkOffsets(i, i + 2);
        return getUnsignedByte0(i + 1) | (getUnsignedByte0(i) << 8);
    }

    public MyDataInputStream makeDataInputStream() {
        return new MyDataInputStream(makeInputStream());
    }

    public MyInputStream makeInputStream() {
        return new MyInputStream();
    }

    public int size() {
        return this.size;
    }

    public ByteArray slice(int i, int i3) {
        checkOffsets(i, i3);
        return new ByteArray(Arrays.copyOfRange(this.bytes, i, i3));
    }

    public int underlyingOffset(int i) {
        return this.start + i;
    }

    public class MyInputStream extends InputStream {
        private int cursor = 0;
        private int mark = 0;

        public MyInputStream() {
        }

        @Override // java.io.InputStream
        public int available() {
            return ByteArray.this.size - this.cursor;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.mark = this.cursor;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.cursor >= ByteArray.this.size) {
                return -1;
            }
            int unsignedByte0 = ByteArray.this.getUnsignedByte0(this.cursor);
            this.cursor++;
            return unsignedByte0;
        }

        @Override // java.io.InputStream
        public void reset() {
            this.cursor = this.mark;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i3) {
            if (i + i3 > bArr.length) {
                i3 = bArr.length - i;
            }
            int i4 = ByteArray.this.size - this.cursor;
            if (i3 > i4) {
                i3 = i4;
            }
            System.arraycopy(ByteArray.this.bytes, ByteArray.this.start + this.cursor, bArr, i, i3);
            this.cursor += i3;
            return i3;
        }
    }

    public ByteArray(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }
}
