package f4;

import a.AbstractC0132a;
import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: f4.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0466v extends AbstractC0246d {
    public static final BigInteger i = new BigInteger(1, h5.b.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3248h;

    public C0466v(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        int[] iArrA = E1.k.A(384, bigInteger);
        if (iArrA[11] == -1) {
            int[] iArr = AbstractC0447b.f3226j;
            if (E1.k.S(iArrA, iArr)) {
                long j6 = 0;
                for (int i3 = 0; i3 < 12; i3++) {
                    long j7 = ((((long) iArrA[i3]) & 4294967295L) - (4294967295L & ((long) iArr[i3]))) + j6;
                    iArrA[i3] = (int) j7;
                    j6 = j7 >> 32;
                }
            }
        }
        this.f3248h = iArrA;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        int i3 = 12;
        int[] iArr = new int[12];
        int[] iArr2 = new int[24];
        int[] iArr3 = this.f3248h;
        AbstractC0132a.d0(iArr3, iArr2);
        long j6 = 4294967295L;
        long j7 = ((long) iArr3[6]) & 4294967295L;
        int i4 = 5;
        int i5 = 12;
        int i6 = 0;
        while (true) {
            int i7 = i4 - 1;
            long j8 = j6;
            long j9 = ((long) iArr3[i4 + 6]) & j8;
            long j10 = j9 * j9;
            int i8 = i3;
            int[] iArr4 = iArr;
            iArr2[i5 + 11] = ((int) (j10 >>> 33)) | (i6 << 31);
            int i9 = i5 - 2;
            iArr2[i5 + 10] = (int) (j10 >>> 1);
            i6 = (int) j10;
            if (i7 <= 0) {
                long j11 = j7 * j7;
                long j12 = (((long) (i6 << 31)) & j8) | (j11 >>> 33);
                iArr2[i8] = (int) j11;
                long j13 = ((long) iArr3[7]) & j8;
                long j14 = ((long) iArr2[14]) & j8;
                long j15 = (j13 * j7) + j12;
                int i10 = (int) j15;
                iArr2[13] = (i10 << 1) | (((int) (j11 >>> 32)) & 1);
                long j16 = j14 + (j15 >>> 32);
                long j17 = ((long) iArr3[8]) & j8;
                long j18 = ((long) iArr2[15]) & j8;
                long j19 = ((long) iArr2[16]) & j8;
                long j20 = (j17 * j7) + j16;
                int i11 = (int) j20;
                iArr2[14] = (i11 << 1) | (i10 >>> 31);
                long jE = androidx.constraintlayout.core.motion.a.e(j17, j13, j20 >>> 32, j18);
                long j21 = j19 + (jE >>> 32);
                long j22 = ((long) iArr3[9]) & j8;
                long j23 = (((long) iArr2[17]) & j8) + (j21 >>> 32);
                long j24 = j21 & j8;
                long j25 = (((long) iArr2[18]) & j8) + (j23 >>> 32);
                long j26 = j23 & j8;
                long j27 = (j22 * j7) + (jE & j8);
                int i12 = (int) j27;
                iArr2[15] = (i11 >>> 31) | (i12 << 1);
                int i13 = i12 >>> 31;
                long jE2 = androidx.constraintlayout.core.motion.a.e(j22, j13, j27 >>> 32, j24);
                long jE3 = androidx.constraintlayout.core.motion.a.e(j22, j17, jE2 >>> 32, j26);
                long j28 = j25 + (jE3 >>> 32);
                long j29 = jE3 & j8;
                long j30 = ((long) iArr3[10]) & j8;
                long j31 = (((long) iArr2[19]) & j8) + (j28 >>> 32);
                long j32 = j28 & j8;
                long j33 = (((long) iArr2[20]) & j8) + (j31 >>> 32);
                long j34 = j31 & j8;
                long j35 = (j30 * j7) + (jE2 & j8);
                int i14 = (int) j35;
                iArr2[16] = i13 | (i14 << 1);
                int i15 = i14 >>> 31;
                long jE4 = androidx.constraintlayout.core.motion.a.e(j30, j13, j35 >>> 32, j29);
                long jE5 = androidx.constraintlayout.core.motion.a.e(j30, j17, jE4 >>> 32, j32);
                long jE6 = androidx.constraintlayout.core.motion.a.e(j30, j22, jE5 >>> 32, j34);
                long j36 = jE5 & j8;
                long j37 = j33 + (jE6 >>> 32);
                long j38 = jE6 & j8;
                long j39 = ((long) iArr3[11]) & j8;
                long j40 = (((long) iArr2[21]) & j8) + (j37 >>> 32);
                long j41 = j37 & j8;
                long j42 = (((long) iArr2[22]) & j8) + (j40 >>> 32);
                long j43 = j40 & j8;
                long j44 = (j39 * j7) + (jE4 & j8);
                int i16 = (int) j44;
                iArr2[17] = i15 | (i16 << 1);
                int i17 = i16 >>> 31;
                long jE7 = androidx.constraintlayout.core.motion.a.e(j39, j13, j44 >>> 32, j36);
                long jE8 = androidx.constraintlayout.core.motion.a.e(j39, j17, jE7 >>> 32, j38);
                long jE9 = androidx.constraintlayout.core.motion.a.e(j39, j22, jE8 >>> 32, j41);
                long jE10 = androidx.constraintlayout.core.motion.a.e(j39, j30, jE9 >>> 32, j43);
                long j45 = j42 + (jE10 >>> 32);
                int i18 = (int) jE7;
                iArr2[18] = i17 | (i18 << 1);
                int i19 = i18 >>> 31;
                int i20 = (int) jE8;
                iArr2[19] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) jE9;
                iArr2[20] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) jE10;
                iArr2[21] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j45;
                iArr2[22] = i25 | (i26 << 1);
                iArr2[23] = (i26 >>> 31) | ((iArr2[23] + ((int) (j45 >>> 32))) << 1);
                int iE = AbstractC0132a.e(iArr2, iArr2);
                int iD = iE + AbstractC0132a.d(18, i8, iArr2, iArr2, AbstractC0132a.d(0, 6, iArr2, iArr2, 0) + iE);
                int[] iArr5 = new int[6];
                AbstractC0132a.t(iArr3, iArr3, iArr5);
                int[] iArr6 = new int[i8];
                AbstractC0132a.d0(iArr5, iArr6);
                E1.k.e(24, E1.k.k0(i8, 6, iArr6, iArr2) + iD, 18, iArr2);
                AbstractC0447b.b0(iArr2, iArr4);
                return new C0466v(iArr4);
            }
            i5 = i9;
            i4 = i7;
            j6 = j8;
            i3 = i8;
            iArr = iArr4;
        }
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[12];
        C5.f.i(AbstractC0447b.f3226j, ((C0466v) abstractC0246d).f3248h, iArr);
        AbstractC0447b.y(iArr, this.f3248h, iArr);
        return new C0466v(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return E1.k.n0(12, this.f3248h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[12];
        C5.f.i(AbstractC0447b.f3226j, this.f3248h, iArr);
        return new C0466v(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        int[] iArr = this.f3248h;
        if (iArr[0] == 1) {
            for (int i3 = 1; i3 < 12; i3++) {
                if (iArr[i3] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[12];
        if (E1.k.b(12, this.f3248h, ((C0466v) abstractC0246d).f3248h, iArr) != 0 || (iArr[11] == -1 && E1.k.S(iArr, AbstractC0447b.f3226j))) {
            AbstractC0447b.e(iArr);
        }
        return new C0466v(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        int[] iArr = this.f3248h;
        for (int i3 = 0; i3 < 12; i3++) {
            if (iArr[i3] != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0466v) {
            return E1.k.z(this.f3248h, ((C0466v) obj).f3248h, 12);
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[12];
        AbstractC0447b.y(this.f3248h, ((C0466v) abstractC0246d).f3248h, iArr);
        return new C0466v(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3248h, 12);
    }

    public C0466v(int[] iArr) {
        this.f3248h = iArr;
    }
}
