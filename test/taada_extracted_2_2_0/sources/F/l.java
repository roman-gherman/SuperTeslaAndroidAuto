package f;

import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;
import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class l implements ByteInput, ByteOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3156a;
    public final ByteBuffer b;
    public final int c;
    public final /* synthetic */ m d;

    public l(m mVar, String str, ByteBuffer byteBuffer) {
        this.d = mVar;
        this.f3156a = str;
        this.b = byteBuffer;
        this.c = byteBuffer.position();
    }

    public final void a() {
        if ((this.b.position() & 3) != 0) {
            throw new IllegalStateException("Not four byte aligned!");
        }
    }

    public final C0438d[] b(int i) {
        C0438d[] c0438dArr = new C0438d[i];
        int iZ = 0;
        for (int i3 = 0; i3 < i; i3++) {
            iZ += C5.f.Z(this);
            c0438dArr[i3] = new C0438d(iZ, C5.f.Z(this), C5.f.Z(this));
        }
        return c0438dArr;
    }

    public final String c() {
        ByteBuffer byteBuffer = this.b;
        int i = byteBuffer.getInt();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        byteBuffer.position(i);
        byteBuffer.limit(byteBuffer.capacity());
        try {
            try {
                int iZ = C5.f.Z(this);
                String strU = E1.k.u(this, new char[iZ]);
                if (strU.length() == iZ) {
                    return strU;
                }
                throw new n("Declared length " + iZ + " doesn't match decoded length of " + strU.length(), null);
            } catch (UTFDataFormatException e) {
                throw new n(null, e);
            }
        } finally {
            byteBuffer.position(iPosition);
            byteBuffer.limit(iLimit);
        }
    }

    public final y d() {
        short[] sArr;
        ByteBuffer byteBuffer = this.b;
        int i = byteBuffer.getInt();
        if (i == 0) {
            sArr = m.f3157j;
        } else {
            short[] sArr2 = new short[i];
            for (int i3 = 0; i3 < i; i3++) {
                sArr2[i3] = byteBuffer.getShort();
            }
            sArr = sArr2;
        }
        byteBuffer.position((byteBuffer.position() + 3) & (-4));
        return new y(this.d, sArr);
    }

    public final int e() {
        return this.b.getShort() & 65535;
    }

    public final int f() {
        return this.b.position() - this.c;
    }

    public final void g(short s3) {
        this.b.putShort(s3);
    }

    public final void h(int i) {
        try {
            C5.f.q0(this, i);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new n("Section limit " + this.b.limit() + " exceeded by " + this.f3156a, null);
        }
    }

    public final void i(int i) {
        try {
            C5.f.r0(this, i);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new n("Section limit " + this.b.limit() + " exceeded by " + this.f3156a, null);
        }
    }

    public final void j(int i) {
        short s3 = (short) i;
        if (i != (65535 & s3)) {
            throw new IllegalArgumentException(B2.b.c(i, "Expected an unsigned short: "));
        }
        g(s3);
    }

    @Override // com.android.dex.util.ByteInput
    public final byte readByte() {
        return this.b.get();
    }

    public final void write(byte[] bArr) {
        this.b.put(bArr);
    }

    @Override // com.android.dex.util.ByteOutput
    public final void writeByte(int i) {
        this.b.put((byte) i);
    }

    public final void writeInt(int i) {
        this.b.putInt(i);
    }
}
