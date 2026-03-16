package w3;

import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: renamed from: w3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0891i extends AbstractC0899q {
    public static final C0883a c = new C0883a(C0891i.class, 9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5060a;
    public final int b;

    public C0891i(long j6) {
        this.f5060a = BigInteger.valueOf(j6).toByteArray();
        this.b = 0;
    }

    public static C0891i j(Object obj) {
        if (obj == null || (obj instanceof C0891i)) {
            return (C0891i) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: ".concat(obj.getClass().getName()));
        }
        try {
            return (C0891i) c.d((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    public static int l(int i, byte[] bArr) {
        int length = bArr.length;
        int iMax = Math.max(i, length - 4);
        int i3 = bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return i3;
            }
            i3 = (i3 << 8) | (bArr[iMax] & 255);
        }
    }

    public static boolean n(byte[] bArr) {
        int length = bArr.length;
        if (length != 0) {
            return (length == 1 || bArr[0] != (bArr[1] >> 7) || g5.d.b("org.bouncycastle.asn1.allow_unsafe_integer")) ? false : true;
        }
        return true;
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof C0891i)) {
            return false;
        }
        return Arrays.equals(this.f5060a, ((C0891i) abstractC0899q).f5060a);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        c0898p.m(this.f5060a, 2, z6);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5060a.length, z6);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5060a);
    }

    public final boolean k(int i) {
        byte[] bArr = this.f5060a;
        int length = bArr.length;
        int i3 = this.b;
        return length - i3 <= 4 && l(i3, bArr) == i;
    }

    public final int m() {
        byte[] bArr = this.f5060a;
        int length = bArr.length;
        int i = this.b;
        if (length - i <= 4) {
            return l(i, bArr);
        }
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    public final long o() {
        byte[] bArr = this.f5060a;
        int length = bArr.length;
        int i = this.b;
        if (length - i > 8) {
            throw new ArithmeticException("ASN.1 Integer out of long range");
        }
        int length2 = bArr.length;
        int iMax = Math.max(i, length2 - 8);
        long j6 = bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length2) {
                return j6;
            }
            j6 = (j6 << 8) | ((long) (bArr[iMax] & 255));
        }
    }

    public final String toString() {
        return new BigInteger(this.f5060a).toString();
    }

    public C0891i(BigInteger bigInteger) {
        this.f5060a = bigInteger.toByteArray();
        this.b = 0;
    }

    public C0891i(byte[] bArr) {
        if (n(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.f5060a = bArr;
        int length = bArr.length - 1;
        int i = 0;
        while (i < length) {
            int i3 = i + 1;
            if (bArr[i] != (bArr[i3] >> 7)) {
                break;
            } else {
                i = i3;
            }
        }
        this.b = i;
    }
}
