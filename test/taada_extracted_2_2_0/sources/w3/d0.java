package w3;

import java.util.Arrays;
import org.bouncycastle.asn1.ASN1String;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends AbstractC0899q implements ASN1String {
    public static final C0883a b = new C0883a(d0.class, 22);
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5052a;

    public d0(byte[] bArr) {
        this.f5052a = bArr;
    }

    public static void j(StringBuffer stringBuffer, int i) {
        char[] cArr = c;
        stringBuffer.append(cArr[(i >>> 4) & 15]);
        stringBuffer.append(cArr[i & 15]);
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof d0)) {
            return false;
        }
        return Arrays.equals(this.f5052a, ((d0) abstractC0899q).f5052a);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        c0898p.m(this.f5052a, 28, z6);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5052a.length, z6);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public final String getString() {
        int i;
        byte[] bArr = this.f5052a;
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer(((C0898p.e(length) + length) * 2) + 3);
        stringBuffer.append("#1C");
        if (length < 128) {
            j(stringBuffer, length);
        } else {
            byte[] bArr2 = new byte[5];
            int i3 = length;
            int i4 = 5;
            while (true) {
                i = i4 - 1;
                bArr2[i] = (byte) i3;
                i3 >>>= 8;
                if (i3 == 0) {
                    break;
                }
                i4 = i;
            }
            int i5 = i4 - 2;
            bArr2[i5] = (byte) (128 | (5 - i));
            while (true) {
                int i6 = i5 + 1;
                j(stringBuffer, bArr2[i5]);
                if (i6 >= 5) {
                    break;
                }
                i5 = i6;
            }
        }
        for (byte b2 : bArr) {
            j(stringBuffer, b2);
        }
        return stringBuffer.toString();
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5052a);
    }

    public final String toString() {
        return getString();
    }
}
