package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i) {
        return this.buffer[i];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i) {
        return this.buffer[i] != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i) {
        byte[] bArr = this.buffer;
        return (bArr[i] & 255) | (bArr[i + 3] << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i) {
        byte[] bArr = this.buffer;
        int i3 = i + 6;
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i3]) & 255) << 48) | (((long) bArr[i + 7]) << 56);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i] & 255) | (bArr[i + 1] << 8));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i, int i3) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i, i3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i, int i3) {
        set(this.writePos, bArr, i, i3);
        this.writePos += i3;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z6) {
        setBoolean(this.writePos, z6);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d) {
        setDouble(this.writePos, d);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f6) {
        setFloat(this.writePos, f6);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i) {
        setInt(this.writePos, i);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j6) {
        setLong(this.writePos, j6);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s3) {
        setShort(this.writePos, s3);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i) {
        byte[] bArr = this.buffer;
        if (bArr.length > i) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i, byte b) {
        requestCapacity(i + 1);
        this.buffer[i] = b;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i, boolean z6) {
        set(i, z6 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i, double d) {
        requestCapacity(i + 8);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        int i3 = (int) jDoubleToRawLongBits;
        byte[] bArr = this.buffer;
        bArr[i] = (byte) (i3 & 255);
        bArr[i + 1] = (byte) ((i3 >> 8) & 255);
        bArr[i + 2] = (byte) ((i3 >> 16) & 255);
        bArr[i + 3] = (byte) ((i3 >> 24) & 255);
        int i4 = (int) (jDoubleToRawLongBits >> 32);
        bArr[i + 4] = (byte) (i4 & 255);
        bArr[i + 5] = (byte) ((i4 >> 8) & 255);
        bArr[i + 6] = (byte) ((i4 >> 16) & 255);
        bArr[i + 7] = (byte) ((i4 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i, float f6) {
        requestCapacity(i + 4);
        int iFloatToRawIntBits = Float.floatToRawIntBits(f6);
        byte[] bArr = this.buffer;
        bArr[i] = (byte) (iFloatToRawIntBits & 255);
        bArr[i + 1] = (byte) ((iFloatToRawIntBits >> 8) & 255);
        bArr[i + 2] = (byte) ((iFloatToRawIntBits >> 16) & 255);
        bArr[i + 3] = (byte) ((iFloatToRawIntBits >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i, int i3) {
        requestCapacity(i + 4);
        byte[] bArr = this.buffer;
        bArr[i] = (byte) (i3 & 255);
        bArr[i + 1] = (byte) ((i3 >> 8) & 255);
        bArr[i + 2] = (byte) ((i3 >> 16) & 255);
        bArr[i + 3] = (byte) ((i3 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i, long j6) {
        requestCapacity(i + 8);
        int i3 = (int) j6;
        byte[] bArr = this.buffer;
        bArr[i] = (byte) (i3 & 255);
        bArr[i + 1] = (byte) ((i3 >> 8) & 255);
        bArr[i + 2] = (byte) ((i3 >> 16) & 255);
        bArr[i + 3] = (byte) ((i3 >> 24) & 255);
        int i4 = (int) (j6 >> 32);
        bArr[i + 4] = (byte) (i4 & 255);
        bArr[i + 5] = (byte) ((i4 >> 8) & 255);
        bArr[i + 6] = (byte) ((i4 >> 16) & 255);
        bArr[i + 7] = (byte) ((i4 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i, short s3) {
        requestCapacity(i + 2);
        byte[] bArr = this.buffer;
        bArr[i] = (byte) (s3 & 255);
        bArr[i + 1] = (byte) ((s3 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int i) {
        this(new byte[i]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b) {
        set(this.writePos, b);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i, byte[] bArr, int i3, int i4) {
        requestCapacity((i4 - i3) + i);
        System.arraycopy(bArr, i3, this.buffer, i, i4);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i) {
        this.buffer = bArr;
        this.writePos = i;
    }
}
