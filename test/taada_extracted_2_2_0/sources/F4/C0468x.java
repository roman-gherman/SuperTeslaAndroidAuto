package f4;

import androidx.core.app.FrameMetricsAggregator;
import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: f4.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0468x extends AbstractC0246d {
    public static final BigInteger i = new BigInteger(1, h5.b.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3250h;

    public C0468x(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        int[] iArrA = E1.k.A(521, bigInteger);
        if (E1.k.z(iArrA, AbstractC0447b.f3227k, 17)) {
            for (int i3 = 0; i3 < 17; i3++) {
                iArrA[i3] = 0;
            }
        }
        this.f3250h = iArrA;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        long j6;
        char c;
        int[] iArr;
        char c6;
        int i3;
        char c7 = 17;
        int[] iArr2 = new int[17];
        char c8 = '!';
        int[] iArr3 = new int[33];
        int[] iArr4 = this.f3250h;
        C5.f.d0(iArr4, iArr3);
        long j7 = 4294967295L;
        long j8 = ((long) iArr4[8]) & 4294967295L;
        int i4 = 7;
        int i5 = 16;
        int i6 = 0;
        while (true) {
            int i7 = i4 - 1;
            j6 = j7;
            long j9 = ((long) iArr4[i4 + 8]) & j6;
            long j10 = j9 * j9;
            c = c7;
            iArr = iArr2;
            iArr3[i5 + 15] = ((int) (j10 >>> c8)) | (i6 << 31);
            int i8 = i5 - 2;
            c6 = c8;
            iArr3[i5 + 14] = (int) (j10 >>> 1);
            i3 = (int) j10;
            if (i7 <= 0) {
                break;
            }
            i5 = i8;
            c8 = c6;
            i4 = i7;
            j7 = j6;
            c7 = c;
            i6 = i3;
            iArr2 = iArr;
        }
        long j11 = j8 * j8;
        iArr3[16] = (int) j11;
        long j12 = ((long) iArr4[9]) & j6;
        long j13 = ((long) iArr3[18]) & j6;
        long j14 = (j12 * j8) + ((((long) (i3 << 31)) & j6) | (j11 >>> c6));
        int i9 = (int) j14;
        iArr3[c] = (i9 << 1) | (((int) (j11 >>> 32)) & 1);
        long j15 = j13 + (j14 >>> 32);
        long j16 = ((long) iArr4[10]) & j6;
        long j17 = ((long) iArr3[19]) & j6;
        long j18 = ((long) iArr3[20]) & j6;
        long j19 = (j16 * j8) + j15;
        int i10 = (int) j19;
        iArr3[18] = (i9 >>> 31) | (i10 << 1);
        int i11 = i10 >>> 31;
        long jE = androidx.constraintlayout.core.motion.a.e(j16, j12, j19 >>> 32, j17);
        long j20 = j18 + (jE >>> 32);
        long j21 = ((long) iArr4[11]) & j6;
        long j22 = (((long) iArr3[21]) & j6) + (j20 >>> 32);
        long j23 = j20 & j6;
        long j24 = (((long) iArr3[22]) & j6) + (j22 >>> 32);
        long j25 = j22 & j6;
        long j26 = (j21 * j8) + (jE & j6);
        int i12 = (int) j26;
        iArr3[19] = (i12 << 1) | i11;
        long jE2 = androidx.constraintlayout.core.motion.a.e(j21, j12, j26 >>> 32, j23);
        long jE3 = androidx.constraintlayout.core.motion.a.e(j21, j16, jE2 >>> 32, j25);
        long j27 = j24 + (jE3 >>> 32);
        long j28 = jE3 & j6;
        long j29 = ((long) iArr4[12]) & j6;
        long j30 = (((long) iArr3[23]) & j6) + (j27 >>> 32);
        long j31 = j27 & j6;
        long j32 = (((long) iArr3[24]) & j6) + (j30 >>> 32);
        long j33 = (j29 * j8) + (jE2 & j6);
        int i13 = (int) j33;
        iArr3[20] = (i13 << 1) | (i12 >>> 31);
        long jE4 = androidx.constraintlayout.core.motion.a.e(j29, j12, j33 >>> 32, j28);
        long jE5 = androidx.constraintlayout.core.motion.a.e(j29, j16, jE4 >>> 32, j31);
        long jE6 = androidx.constraintlayout.core.motion.a.e(j29, j21, jE5 >>> 32, j30 & j6);
        long j34 = j32 + (jE6 >>> 32);
        long j35 = jE6 & j6;
        long j36 = ((long) iArr4[13]) & j6;
        long j37 = (((long) iArr3[25]) & j6) + (j34 >>> 32);
        long j38 = (((long) iArr3[26]) & j6) + (j37 >>> 32);
        long j39 = j37 & j6;
        long j40 = (j36 * j8) + (jE4 & j6);
        int i14 = (int) j40;
        iArr3[21] = (i13 >>> 31) | (i14 << 1);
        int i15 = i14 >>> 31;
        long jE7 = androidx.constraintlayout.core.motion.a.e(j36, j12, j40 >>> 32, jE5 & j6);
        long jE8 = androidx.constraintlayout.core.motion.a.e(j36, j16, jE7 >>> 32, j35);
        long jE9 = androidx.constraintlayout.core.motion.a.e(j36, j21, jE8 >>> 32, j34 & j6);
        long j41 = jE8 & j6;
        long jE10 = androidx.constraintlayout.core.motion.a.e(j36, j29, jE9 >>> 32, j39);
        long j42 = j38 + (jE10 >>> 32);
        long j43 = ((long) iArr4[14]) & j6;
        long j44 = (((long) iArr3[27]) & j6) + (j42 >>> 32);
        long j45 = (((long) iArr3[28]) & j6) + (j44 >>> 32);
        long j46 = j44 & j6;
        long j47 = (j43 * j8) + (jE7 & j6);
        int i16 = (int) j47;
        iArr3[22] = i15 | (i16 << 1);
        long jE11 = androidx.constraintlayout.core.motion.a.e(j43, j12, j47 >>> 32, j41);
        long jE12 = androidx.constraintlayout.core.motion.a.e(j43, j16, jE11 >>> 32, jE9 & j6);
        long jE13 = androidx.constraintlayout.core.motion.a.e(j43, j21, jE12 >>> 32, jE10 & j6);
        long j48 = jE12 & j6;
        long jE14 = androidx.constraintlayout.core.motion.a.e(j43, j29, jE13 >>> 32, j42 & j6);
        long jE15 = androidx.constraintlayout.core.motion.a.e(j43, j36, jE14 >>> 32, j46);
        long j49 = jE14 & j6;
        long j50 = j45 + (jE15 >>> 32);
        long j51 = jE15 & j6;
        long j52 = ((long) iArr4[15]) & j6;
        long j53 = (((long) iArr3[29]) & j6) + (j50 >>> 32);
        long j54 = j50 & j6;
        long j55 = (((long) iArr3[30]) & j6) + (j53 >>> 32);
        long j56 = j53 & j6;
        long j57 = (j52 * j8) + (jE11 & j6);
        int i17 = (int) j57;
        iArr3[23] = (i16 >>> 31) | (i17 << 1);
        int i18 = i17 >>> 31;
        long jE16 = androidx.constraintlayout.core.motion.a.e(j52, j12, j57 >>> 32, j48);
        long jE17 = androidx.constraintlayout.core.motion.a.e(j52, j16, jE16 >>> 32, jE13 & j6);
        long jE18 = androidx.constraintlayout.core.motion.a.e(j52, j21, jE17 >>> 32, j49);
        long jE19 = androidx.constraintlayout.core.motion.a.e(j52, j29, jE18 >>> 32, j51);
        long jE20 = androidx.constraintlayout.core.motion.a.e(j52, j36, jE19 >>> 32, j54);
        long jE21 = androidx.constraintlayout.core.motion.a.e(j52, j43, jE20 >>> 32, j56);
        long j58 = j55 + (jE21 >>> 32);
        int i19 = (int) jE16;
        iArr3[24] = i18 | (i19 << 1);
        int i20 = i19 >>> 31;
        int i21 = (int) jE17;
        iArr3[25] = i20 | (i21 << 1);
        int i22 = i21 >>> 31;
        int i23 = (int) jE18;
        iArr3[26] = i22 | (i23 << 1);
        int i24 = i23 >>> 31;
        int i25 = (int) jE19;
        iArr3[27] = i24 | (i25 << 1);
        int i26 = (int) jE20;
        iArr3[28] = (i25 >>> 31) | (i26 << 1);
        int i27 = i26 >>> 31;
        int i28 = (int) jE21;
        iArr3[29] = i27 | (i28 << 1);
        int i29 = i28 >>> 31;
        int i30 = (int) j58;
        iArr3[30] = i29 | (i30 << 1);
        iArr3[31] = (i30 >>> 31) | ((iArr3[31] + ((int) (j58 >>> 32))) << 1);
        int iF = C5.f.f(iArr3, iArr3);
        int iE = iF + C5.f.e(24, 16, iArr3, iArr3, C5.f.e(0, 8, iArr3, iArr3, 0) + iF);
        int[] iArr5 = new int[8];
        C5.f.u(iArr4, iArr4, iArr5);
        int[] iArr6 = new int[16];
        C5.f.d0(iArr5, iArr6);
        E1.k.e(32, E1.k.k0(16, 8, iArr6, iArr3) + iE, 24, iArr3);
        int i31 = iArr4[16];
        long j59 = ((long) (i31 << 1)) & j6;
        long j60 = 0;
        int i32 = 0;
        do {
            int i33 = 16 + i32;
            long j61 = ((((long) iArr4[i32]) & j6) * j59) + (((long) iArr3[i33]) & j6) + j60;
            iArr3[i33] = (int) j61;
            j60 = j61 >>> 32;
            i32++;
        } while (i32 < 16);
        iArr3[32] = (i31 * i31) + ((int) j60);
        AbstractC0447b.M(iArr3, iArr);
        return new C0468x(iArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[17];
        C5.f.i(AbstractC0447b.f3227k, ((C0468x) abstractC0246d).f3250h, iArr);
        AbstractC0447b.A(iArr, this.f3250h, iArr);
        return new C0468x(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return E1.k.n0(17, this.f3250h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[17];
        C5.f.i(AbstractC0447b.f3227k, this.f3250h, iArr);
        return new C0468x(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        int[] iArr = this.f3250h;
        if (iArr[0] == 1) {
            for (int i3 = 1; i3 < 17; i3++) {
                if (iArr[i3] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[17];
        int[] iArr2 = ((C0468x) abstractC0246d).f3250h;
        int[] iArr3 = this.f3250h;
        int iB = E1.k.b(16, iArr3, iArr2, iArr) + iArr3[16] + iArr2[16];
        if (iB > 511 || (iB == 511 && E1.k.z(iArr, AbstractC0447b.f3227k, 16))) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= 16) {
                    i3 = 1;
                    break;
                }
                int i5 = iArr[i4] + 1;
                iArr[i4] = i5;
                if (i5 != 0) {
                    break;
                }
                i4++;
            }
            iB = (i3 + iB) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr[16] = iB;
        return new C0468x(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        int[] iArr = this.f3250h;
        for (int i3 = 0; i3 < 17; i3++) {
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
        if (obj instanceof C0468x) {
            return E1.k.z(this.f3250h, ((C0468x) obj).f3250h, 17);
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[17];
        AbstractC0447b.A(this.f3250h, ((C0468x) abstractC0246d).f3250h, iArr);
        return new C0468x(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3250h, 17);
    }

    public C0468x(int[] iArr) {
        this.f3250h = iArr;
    }
}
