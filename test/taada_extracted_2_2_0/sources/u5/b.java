package u5;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: loaded from: classes.dex */
public final class b extends InputStream {
    public static final int[] e = {1, 2, 2};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f4890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f4891g;
    public final byte[][] d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4892a = 0;
    public int c = 0;
    public byte[] b = f4890f;

    static {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(-21267);
            dataOutputStream.writeShort(5);
            f4890f = byteArrayOutputStream.toByteArray();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
            dataOutputStream2.writeByte(115);
            dataOutputStream2.writeByte(113);
            dataOutputStream2.writeInt(8257536);
            f4891g = byteArrayOutputStream2.toByteArray();
        } catch (IOException e6) {
            throw new Error("IOException: " + e6.getMessage());
        }
    }

    public b(Class cls) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(115);
            dataOutputStream.writeByte(114);
            dataOutputStream.writeUTF(cls.getName());
            dataOutputStream.writeLong(ObjectStreamClass.lookup(cls).getSerialVersionUID());
            dataOutputStream.writeByte(2);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeByte(120);
            dataOutputStream.writeByte(112);
            this.d = new byte[][]{f4890f, byteArrayOutputStream.toByteArray(), f4891g};
        } catch (IOException e6) {
            throw new Error("IOException: " + e6.getMessage());
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return Integer.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.b;
        int i = this.f4892a;
        int i3 = i + 1;
        this.f4892a = i3;
        byte b = bArr[i];
        if (i3 >= bArr.length) {
            this.f4892a = 0;
            int i4 = e[this.c];
            this.c = i4;
            this.b = this.d[i4];
        }
        return b;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) {
        int length = this.b.length - this.f4892a;
        int i4 = i3;
        while (length <= i4) {
            System.arraycopy(this.b, this.f4892a, bArr, i, length);
            i += length;
            i4 -= length;
            this.f4892a = 0;
            int i5 = e[this.c];
            this.c = i5;
            byte[] bArr2 = this.d[i5];
            this.b = bArr2;
            length = bArr2.length;
        }
        if (i4 > 0) {
            System.arraycopy(this.b, this.f4892a, bArr, i, i4);
            this.f4892a += i4;
        }
        return i3;
    }
}
