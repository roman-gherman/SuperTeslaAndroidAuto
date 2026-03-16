package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: f4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0448c extends AbstractC0246d {
    public static final BigInteger i = new BigInteger(1, h5.b.a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3229h;

    public C0448c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[4];
        for (int i3 = 0; i3 < 4; i3++) {
            iArr[i3] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        if ((iArr[3] >>> 1) >= 2147483646) {
            int[] iArr2 = AbstractC0447b.f3222a;
            if (E1.k.R(iArr, iArr2)) {
                long j6 = (((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L);
                iArr[0] = (int) j6;
                long j7 = ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L)) + (j6 >> 32);
                iArr[1] = (int) j7;
                long j8 = ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L)) + (j7 >> 32);
                iArr[2] = (int) j8;
                iArr[3] = (int) (((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L)) + (j8 >> 32));
            }
        }
        this.f3229h = iArr;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        int[] iArr = new int[4];
        int i3 = 8;
        int[] iArr2 = new int[8];
        int[] iArr3 = this.f3229h;
        char c = 0;
        long j6 = 4294967295L;
        long j7 = ((long) iArr3[0]) & 4294967295L;
        int i4 = 0;
        int i5 = 3;
        while (true) {
            int i6 = i5 - 1;
            char c6 = c;
            long j8 = j7;
            long j9 = ((long) iArr3[i5]) & j6;
            long j10 = j9 * j9;
            long j11 = j6;
            iArr2[i3 - 1] = ((int) (j10 >>> 33)) | (i4 << 31);
            i3 -= 2;
            iArr2[i3] = (int) (j10 >>> 1);
            int i7 = (int) j10;
            if (i6 <= 0) {
                long j12 = j8 * j8;
                iArr2[c6] = (int) j12;
                long j13 = ((long) iArr3[1]) & j11;
                long j14 = ((long) iArr2[2]) & j11;
                long j15 = (j13 * j8) + ((((long) (i7 << 31)) & j11) | (j12 >>> 33));
                int i8 = (int) j15;
                iArr2[1] = (i8 << 1) | (((int) (j12 >>> 32)) & 1);
                long j16 = j14 + (j15 >>> 32);
                long j17 = ((long) iArr3[2]) & j11;
                long j18 = ((long) iArr2[3]) & j11;
                long j19 = ((long) iArr2[4]) & j11;
                long j20 = (j17 * j8) + j16;
                int i9 = (int) j20;
                iArr2[2] = (i8 >>> 31) | (i9 << 1);
                long jE = androidx.constraintlayout.core.motion.a.e(j17, j13, j20 >>> 32, j18);
                long j21 = j19 + (jE >>> 32);
                long j22 = ((long) iArr3[3]) & j11;
                long j23 = (((long) iArr2[5]) & j11) + (j21 >>> 32);
                long j24 = j21 & j11;
                long j25 = (((long) iArr2[6]) & j11) + (j23 >>> 32);
                long j26 = j23 & j11;
                long j27 = (j22 * j8) + (jE & j11);
                int i10 = (int) j27;
                iArr2[3] = (i10 << 1) | (i9 >>> 31);
                long jE2 = androidx.constraintlayout.core.motion.a.e(j22, j13, j27 >>> 32, j24);
                long jE3 = androidx.constraintlayout.core.motion.a.e(j22, j17, jE2 >>> 32, j26);
                long j28 = j25 + (jE3 >>> 32);
                int i11 = (int) jE2;
                iArr2[4] = (i10 >>> 31) | (i11 << 1);
                int i12 = i11 >>> 31;
                int i13 = (int) (jE3 & j11);
                iArr2[5] = i12 | (i13 << 1);
                int i14 = (int) j28;
                iArr2[6] = (i13 >>> 31) | (i14 << 1);
                iArr2[7] = (i14 >>> 31) | ((iArr2[7] + ((int) (j28 >>> 32))) << 1);
                AbstractC0447b.I(iArr2, iArr);
                return new C0448c(iArr);
            }
            i4 = i7;
            i5 = i6;
            c = c6;
            j7 = j8;
            j6 = j11;
        }
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[4];
        C5.f.i(AbstractC0447b.f3222a, ((C0448c) abstractC0246d).f3229h, iArr);
        AbstractC0447b.w(iArr, this.f3229h, iArr);
        return new C0448c(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        byte[] bArr = new byte[16];
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = this.f3229h[i3];
            if (i4 != 0) {
                g5.c.o(bArr, i4, (3 - i3) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[4];
        C5.f.i(AbstractC0447b.f3222a, this.f3229h, iArr);
        return new C0448c(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        int[] iArr = this.f3229h;
        if (iArr[0] == 1) {
            for (int i3 = 1; i3 < 4; i3++) {
                if (iArr[i3] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        int[] iArr = ((C0448c) abstractC0246d).f3229h;
        int[] iArr2 = this.f3229h;
        long j6 = (((long) iArr2[0]) & 4294967295L) + (((long) iArr[0]) & 4294967295L);
        long j7 = (((long) iArr2[1]) & 4294967295L) + (((long) iArr[1]) & 4294967295L) + (j6 >>> 32);
        long j8 = (((long) iArr2[2]) & 4294967295L) + (((long) iArr[2]) & 4294967295L) + (j7 >>> 32);
        long j9 = (((long) iArr2[3]) & 4294967295L) + (((long) iArr[3]) & 4294967295L) + (j8 >>> 32);
        int i3 = (int) j9;
        int[] iArr3 = {(int) j6, (int) j7, (int) j8, i3};
        if (((int) (j9 >>> 32)) != 0 || ((i3 >>> 1) >= 2147483646 && E1.k.R(iArr3, AbstractC0447b.f3222a))) {
            AbstractC0447b.a(iArr3);
        }
        return new C0448c(iArr3);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.f3229h[i3] != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0448c)) {
            return false;
        }
        int[] iArr = ((C0448c) obj).f3229h;
        for (int i3 = 3; i3 >= 0; i3--) {
            if (this.f3229h[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[4];
        AbstractC0447b.w(this.f3229h, ((C0448c) abstractC0246d).f3229h, iArr);
        return new C0448c(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3229h, 4);
    }

    public C0448c(int[] iArr) {
        this.f3229h = iArr;
    }
}
