package w3;

import java.util.Arrays;
import org.bouncycastle.asn1.ASN1String;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends AbstractC0899q implements ASN1String {
    public static final C0883a b = new C0883a(c0.class, 21);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5049a;

    public c0(byte[] bArr) {
        this.f5049a = bArr;
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof c0)) {
            return false;
        }
        return Arrays.equals(this.f5049a, ((c0) abstractC0899q).f5049a);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        c0898p.m(this.f5049a, 12, z6);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5049a.length, z6);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public final String getString() {
        String str = g5.e.f3346a;
        byte[] bArr = this.f5049a;
        int length = bArr.length;
        char[] cArr = new char[length];
        short[] sArr = h5.d.f3461a;
        int length2 = bArr.length;
        int i = 0;
        int i3 = 0;
        loop0: while (i < length2) {
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 < 0) {
                short s3 = h5.d.f3461a[b2 & 127];
                int i5 = s3 >>> 8;
                byte b6 = (byte) s3;
                while (true) {
                    if (b6 >= 0) {
                        if (i4 >= length2) {
                            break loop0;
                        }
                        int i6 = i4 + 1;
                        byte b7 = bArr[i4];
                        i5 = (i5 << 6) | (b7 & 63);
                        b6 = h5.d.b[b6 + ((b7 & 255) >>> 4)];
                        i4 = i6;
                    } else if (b6 != -2) {
                        if (i5 <= 65535) {
                            if (i3 < length) {
                                cArr[i3] = (char) i5;
                                i3++;
                                i = i4;
                            }
                        } else if (i3 < length - 1) {
                            int i7 = i3 + 1;
                            cArr[i3] = (char) ((i5 >>> 10) + 55232);
                            i3 += 2;
                            cArr[i7] = (char) ((i5 & 1023) | 56320);
                            i = i4;
                        }
                    }
                }
                i3 = -1;
                break;
            }
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            cArr[i3] = (char) b2;
            i = i4;
            i3++;
        }
        if (i3 >= 0) {
            return new String(cArr, 0, i3);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5049a);
    }

    public final String toString() {
        return getString();
    }
}
