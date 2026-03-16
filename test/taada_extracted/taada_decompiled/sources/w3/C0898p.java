package w3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.util.Encodable;

/* JADX INFO: renamed from: w3.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0898p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f5068a;

    public C0898p() {
        this.f5068a = new ByteArrayOutputStream();
    }

    public static int e(int i) {
        if (i < 128) {
            return 1;
        }
        int i3 = 2;
        while (true) {
            i >>>= 8;
            if (i == 0) {
                return i3;
            }
            i3++;
        }
    }

    public static int f(int i, boolean z6) {
        return e(i) + (z6 ? 1 : 0) + i;
    }

    public static int g(int i) {
        if (i < 31) {
            return 1;
        }
        int i3 = 2;
        while (true) {
            i >>>= 7;
            if (i == 0) {
                return i3;
            }
            i3++;
        }
    }

    public void a(Encodable encodable) {
        try {
            this.f5068a.write(encodable.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void b(byte[] bArr) {
        try {
            this.f5068a.write(bArr);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public X c() {
        return new X(this.f5068a);
    }

    public j0 d() {
        return new j0(this.f5068a);
    }

    public void h(int i) {
        ByteArrayOutputStream byteArrayOutputStream = this.f5068a;
        byteArrayOutputStream.write((byte) (i >>> 24));
        byteArrayOutputStream.write((byte) (i >>> 16));
        byteArrayOutputStream.write((byte) (i >>> 8));
        byteArrayOutputStream.write((byte) i);
    }

    public void i(int i) throws IOException {
        this.f5068a.write(i);
    }

    public void j(byte[] bArr, int i, int i3) throws IOException {
        this.f5068a.write(bArr, i, i3);
    }

    public void k(int i) throws IOException {
        if (i < 128) {
            i(i);
            return;
        }
        int i3 = 5;
        byte[] bArr = new byte[5];
        while (true) {
            int i4 = i3 - 1;
            bArr[i4] = (byte) i;
            i >>>= 8;
            if (i == 0) {
                int i5 = i3 - 2;
                bArr[i5] = (byte) ((5 - i4) | 128);
                j(bArr, i5, 6 - i4);
                return;
            }
            i3 = i4;
        }
    }

    public void l(ASN1Encodable[] aSN1EncodableArr) {
        for (ASN1Encodable aSN1Encodable : aSN1EncodableArr) {
            aSN1Encodable.toASN1Primitive().c(this, true);
        }
    }

    public void m(byte[] bArr, int i, boolean z6) {
        p(i, z6);
        k(bArr.length);
        j(bArr, 0, bArr.length);
    }

    public void n(boolean z6, int i, ASN1Encodable[] aSN1EncodableArr) throws IOException {
        p(i, z6);
        i(128);
        l(aSN1EncodableArr);
        i(0);
        i(0);
    }

    public void o(int i, int i3) throws IOException {
        if (i3 < 31) {
            i(i | i3);
            return;
        }
        byte[] bArr = new byte[6];
        int i4 = 5;
        bArr[5] = (byte) (i3 & 127);
        while (i3 > 127) {
            i3 >>>= 7;
            i4--;
            bArr[i4] = (byte) ((i3 & 127) | 128);
        }
        int i5 = i4 - 1;
        bArr[i5] = (byte) (i | 31);
        j(bArr, i5, 6 - i5);
    }

    public void p(int i, boolean z6) throws IOException {
        if (z6) {
            i(i);
        }
    }

    public void q(AbstractC0899q abstractC0899q) {
        abstractC0899q.c(this, true);
    }

    public void r(AbstractC0899q[] abstractC0899qArr) {
        for (AbstractC0899q abstractC0899q : abstractC0899qArr) {
            abstractC0899q.c(this, true);
        }
    }

    public C0898p(ByteArrayOutputStream byteArrayOutputStream) {
        this.f5068a = byteArrayOutputStream;
    }
}
