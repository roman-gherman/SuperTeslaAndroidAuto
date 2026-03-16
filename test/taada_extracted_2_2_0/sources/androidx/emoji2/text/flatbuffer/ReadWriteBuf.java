package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b);

    void put(byte[] bArr, int i, int i3);

    void putBoolean(boolean z6);

    void putDouble(double d);

    void putFloat(float f6);

    void putInt(int i);

    void putLong(long j6);

    void putShort(short s3);

    boolean requestCapacity(int i);

    void set(int i, byte b);

    void set(int i, byte[] bArr, int i3, int i4);

    void setBoolean(int i, boolean z6);

    void setDouble(int i, double d);

    void setFloat(int i, float f6);

    void setInt(int i, int i3);

    void setLong(int i, long j6);

    void setShort(int i, short s3);

    int writePosition();
}
