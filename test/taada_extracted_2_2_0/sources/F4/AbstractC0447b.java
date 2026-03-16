package f4;

import a.AbstractC0132a;
import androidx.core.app.FrameMetricsAggregator;
import c4.AbstractC0246d;

/* JADX INFO: renamed from: f4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0447b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f3222a = {-1, -1, -1, -3};
    public static final int[] b = {Integer.MAX_VALUE, -1, -1, -1, -1};
    public static final int[] c = {-21389, -2, -1, -1, -1};
    public static final int[] d = {-4553, -2, -1, -1, -1, -1};
    public static final int[] e = {-1, -1, -2, -1, -1, -1};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f3223f = {-6803, -2, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f3224g = {1, 0, 0, -1, -1, -1, -1};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f3225h = {-977, -2, -1, -1, -1, -1, -1, -1};
    public static final int[] i = {-1, -1, -1, 0, 0, 0, 1, -1};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f3226j = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f3227k = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, FrameMetricsAggregator.EVERY_DURATION};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long[] f3228l = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    public static void A(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[33];
        C5.f.W(iArr, iArr2, iArr4);
        long j6 = ((long) iArr2[8]) & 4294967295L;
        long j7 = ((long) iArr2[9]) & 4294967295L;
        long j8 = ((long) iArr2[10]) & 4294967295L;
        long j9 = ((long) iArr2[11]) & 4294967295L;
        long j10 = ((long) iArr2[12]) & 4294967295L;
        long j11 = ((long) iArr2[13]) & 4294967295L;
        long j12 = ((long) iArr2[14]) & 4294967295L;
        long j13 = ((long) iArr2[15]) & 4294967295L;
        long j14 = ((long) iArr[8]) & 4294967295L;
        long j15 = j14 * j6;
        iArr4[16] = (int) j15;
        int i3 = 32;
        long j16 = (j14 * j7) + (j15 >>> 32);
        iArr4[17] = (int) j16;
        long j17 = (j14 * j8) + (j16 >>> 32);
        iArr4[18] = (int) j17;
        long j18 = (j14 * j9) + (j17 >>> 32);
        iArr4[19] = (int) j18;
        long j19 = (j14 * j10) + (j18 >>> 32);
        iArr4[20] = (int) j19;
        long j20 = (j14 * j11) + (j19 >>> 32);
        iArr4[21] = (int) j20;
        long j21 = (j14 * j12) + (j20 >>> 32);
        iArr4[22] = (int) j21;
        long j22 = (j14 * j13) + (j21 >>> 32);
        iArr4[23] = (int) j22;
        iArr4[24] = (int) (j22 >>> 32);
        int i4 = 16;
        int i5 = 1;
        while (i5 < 8) {
            int i6 = i4 + 1;
            long j23 = j10;
            int i7 = i3;
            long j24 = ((long) iArr[8 + i5]) & 4294967295L;
            long j25 = j11;
            long j26 = (j24 * j6) + (((long) iArr4[i6]) & 4294967295L);
            iArr4[i6] = (int) j26;
            int i8 = i4 + 2;
            long j27 = (j24 * j7) + (((long) iArr4[i8]) & 4294967295L) + (j26 >>> i7);
            iArr4[i8] = (int) j27;
            int i9 = i4 + 3;
            long j28 = (j24 * j8) + (((long) iArr4[i9]) & 4294967295L) + (j27 >>> i7);
            iArr4[i9] = (int) j28;
            int i10 = i4 + 4;
            long j29 = (j24 * j9) + (((long) iArr4[i10]) & 4294967295L) + (j28 >>> i7);
            iArr4[i10] = (int) j29;
            int i11 = i4 + 5;
            long j30 = (j24 * j23) + (((long) iArr4[i11]) & 4294967295L) + (j29 >>> i7);
            iArr4[i11] = (int) j30;
            int i12 = i4 + 6;
            long j31 = (j24 * j25) + (((long) iArr4[i12]) & 4294967295L) + (j30 >>> i7);
            iArr4[i12] = (int) j31;
            int i13 = i4 + 7;
            long j32 = (j24 * j12) + (((long) iArr4[i13]) & 4294967295L) + (j31 >>> i7);
            iArr4[i13] = (int) j32;
            int i14 = i4 + 8;
            long j33 = (j24 * j13) + (((long) iArr4[i14]) & 4294967295L) + (j32 >>> i7);
            iArr4[i14] = (int) j33;
            iArr4[i4 + 9] = (int) (j33 >>> i7);
            i5++;
            i4 = i6;
            i3 = i7;
            j10 = j23;
            j8 = j8;
            j11 = j25;
        }
        int i15 = i3;
        int iF = C5.f.f(iArr4, iArr4);
        int i16 = 0;
        int iE = C5.f.e(24, 16, iArr4, iArr4, C5.f.e(0, 8, iArr4, iArr4, 0) + iF) + iF;
        int[] iArr5 = new int[8];
        int[] iArr6 = new int[8];
        boolean z6 = C5.f.u(iArr, iArr, iArr5) != C5.f.u(iArr2, iArr2, iArr6);
        int[] iArr7 = new int[16];
        C5.f.W(iArr5, iArr6, iArr7);
        E1.k.e(i15, iE + (z6 ? E1.k.d(16, 8, iArr7, iArr4) : E1.k.k0(16, 8, iArr7, iArr4)), 24, iArr4);
        int i17 = iArr[16];
        int i18 = iArr2[16];
        long j34 = ((long) i17) & 4294967295L;
        long j35 = ((long) i18) & 4294967295L;
        long j36 = 0;
        while (true) {
            long j37 = j34;
            int i19 = 16 + i16;
            long j38 = ((((long) iArr[i16]) & 4294967295L) * j35) + (j37 * (((long) iArr2[i16]) & 4294967295L)) + (((long) iArr4[i19]) & 4294967295L) + j36;
            iArr4[i19] = (int) j38;
            long j39 = j38 >>> 32;
            i16++;
            if (i16 >= 16) {
                iArr4[32] = (i17 * i18) + ((int) j39);
                M(iArr4, iArr3);
                return;
            } else {
                j36 = j39;
                j34 = j37;
            }
        }
    }

    public static void B(long[] jArr, long[] jArr2, long[] jArr3) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = ((jArr[2] << 40) ^ (j7 >>> 24)) & 17592186044415L;
        long j9 = ((j7 << 20) ^ (j6 >>> 44)) & 17592186044415L;
        long j10 = j6 & 17592186044415L;
        long j11 = jArr2[0];
        long j12 = jArr2[1];
        long j13 = ((j12 >>> 24) ^ (jArr2[2] << 40)) & 17592186044415L;
        long j14 = ((j11 >>> 44) ^ (j12 << 20)) & 17592186044415L;
        long j15 = j11 & 17592186044415L;
        long[] jArr4 = new long[10];
        long[] jArr5 = {j, j, j, j, j, j, 0, 0};
        l(jArr5, j10, j15, jArr4, 0);
        l(jArr5, j8, j13, jArr4, 2);
        long j16 = (j10 ^ j9) ^ j8;
        long j17 = (j15 ^ j14) ^ j13;
        l(jArr5, j16, j17, jArr4, 4);
        long j18 = (j9 << 1) ^ (j8 << 2);
        long j19 = (j14 << 1) ^ (j13 << 2);
        l(jArr5, j10 ^ j18, j15 ^ j19, jArr4, 6);
        l(jArr5, j16 ^ j18, j17 ^ j19, jArr4, 8);
        long j20 = jArr4[6];
        long j21 = jArr4[8] ^ j20;
        long j22 = jArr4[7];
        long j23 = j22 ^ jArr4[9];
        long j24 = (j21 << 1) ^ j20;
        long j25 = (j21 ^ (j23 << 1)) ^ j22;
        long j26 = jArr4[0];
        long j27 = jArr4[1];
        long j28 = (j27 ^ j26) ^ jArr4[4];
        long j29 = j27 ^ jArr4[5];
        long j30 = jArr4[2];
        long j31 = ((j24 ^ j26) ^ (j30 << 4)) ^ (j30 << 1);
        long j32 = jArr4[3];
        long j33 = (((j28 ^ j25) ^ (j32 << 4)) ^ (j32 << 1)) ^ (j31 >>> 44);
        long j34 = (j29 ^ j23) ^ (j33 >>> 44);
        long j35 = ((j31 & 17592186044415L) >>> 1) ^ ((j33 & 1) << 43);
        long j36 = j35 ^ (j35 << 1);
        long j37 = j36 ^ (j36 << 2);
        long j38 = j37 ^ (j37 << 4);
        long j39 = j38 ^ (j38 << 8);
        long j40 = j39 ^ (j39 << 16);
        long j41 = (j40 ^ (j40 << 32)) & 17592186044415L;
        long j42 = (((j33 & 17592186044415L) >>> 1) ^ ((j34 & 1) << 43)) ^ (j41 >>> 43);
        long j43 = j42 ^ (j42 << 1);
        long j44 = j43 ^ (j43 << 2);
        long j45 = j44 ^ (j44 << 4);
        long j46 = j45 ^ (j45 << 8);
        long j47 = j46 ^ (j46 << 16);
        long j48 = (j47 ^ (j47 << 32)) & 17592186044415L;
        long j49 = (j34 >>> 1) ^ (j48 >>> 43);
        long j50 = j49 ^ (j49 << 1);
        long j51 = j50 ^ (j50 << 2);
        long j52 = j51 ^ (j51 << 4);
        long j53 = j52 ^ (j52 << 8);
        long j54 = j53 ^ (j53 << 16);
        long j55 = j54 ^ (j54 << 32);
        long j56 = (j28 ^ j41) ^ j30;
        long j57 = ((j29 ^ j48) ^ j41) ^ j32;
        long j58 = j48 ^ j55;
        long j59 = j55 ^ jArr4[2];
        long j60 = jArr4[3];
        jArr5[0] = j26 ^ (j56 << 44);
        jArr5[1] = (j56 >>> 20) ^ (j57 << 24);
        jArr5[2] = ((j57 >>> 40) ^ (j58 << 4)) ^ (j59 << 48);
        jArr5[3] = ((j58 >>> 60) ^ (j60 << 28)) ^ (j59 >>> 16);
        jArr5[4] = j60 >>> 36;
        jArr5[5] = 0;
        O(jArr5, jArr3);
    }

    public static void C(long[] jArr, long[] jArr2, long[] jArr3) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = (j7 >>> 46) ^ (jArr[2] << 18);
        long j9 = ((j7 << 9) ^ (j6 >>> 55)) & 36028797018963967L;
        long j10 = j6 & 36028797018963967L;
        long j11 = jArr2[0];
        long j12 = jArr2[1];
        long j13 = (j12 >>> 46) ^ (jArr2[2] << 18);
        long j14 = ((j11 >>> 55) ^ (j12 << 9)) & 36028797018963967L;
        long j15 = j11 & 36028797018963967L;
        long[] jArr4 = new long[10];
        long[] jArr5 = {j, j, j, j, j, j, 0, 0};
        m(jArr5, j10, j15, jArr4, 0);
        m(jArr5, j8, j13, jArr4, 2);
        long j16 = (j10 ^ j9) ^ j8;
        long j17 = (j15 ^ j14) ^ j13;
        m(jArr5, j16, j17, jArr4, 4);
        long j18 = (j9 << 1) ^ (j8 << 2);
        long j19 = (j14 << 1) ^ (j13 << 2);
        m(jArr5, j10 ^ j18, j15 ^ j19, jArr4, 6);
        m(jArr5, j16 ^ j18, j17 ^ j19, jArr4, 8);
        long j20 = jArr4[6];
        long j21 = jArr4[8] ^ j20;
        long j22 = jArr4[7];
        long j23 = j22 ^ jArr4[9];
        long j24 = (j21 << 1) ^ j20;
        long j25 = (j21 ^ (j23 << 1)) ^ j22;
        long j26 = jArr4[0];
        long j27 = jArr4[1];
        long j28 = (j27 ^ j26) ^ jArr4[4];
        long j29 = j27 ^ jArr4[5];
        long j30 = jArr4[2];
        long j31 = ((j24 ^ j26) ^ (j30 << 4)) ^ (j30 << 1);
        long j32 = jArr4[3];
        long j33 = (((j28 ^ j25) ^ (j32 << 4)) ^ (j32 << 1)) ^ (j31 >>> 55);
        long j34 = (j29 ^ j23) ^ (j33 >>> 55);
        long j35 = ((j31 & 36028797018963967L) >>> 1) ^ ((j33 & 1) << 54);
        long j36 = j35 ^ (j35 << 1);
        long j37 = j36 ^ (j36 << 2);
        long j38 = j37 ^ (j37 << 4);
        long j39 = j38 ^ (j38 << 8);
        long j40 = j39 ^ (j39 << 16);
        long j41 = (j40 ^ (j40 << 32)) & 36028797018963967L;
        long j42 = (((j33 & 36028797018963967L) >>> 1) ^ ((j34 & 1) << 54)) ^ (j41 >>> 54);
        long j43 = j42 ^ (j42 << 1);
        long j44 = j43 ^ (j43 << 2);
        long j45 = j44 ^ (j44 << 4);
        long j46 = j45 ^ (j45 << 8);
        long j47 = j46 ^ (j46 << 16);
        long j48 = (j47 ^ (j47 << 32)) & 36028797018963967L;
        long j49 = (j34 >>> 1) ^ (j48 >>> 54);
        long j50 = j49 ^ (j49 << 1);
        long j51 = j50 ^ (j50 << 2);
        long j52 = j51 ^ (j51 << 4);
        long j53 = j52 ^ (j52 << 8);
        long j54 = j53 ^ (j53 << 16);
        long j55 = j54 ^ (j54 << 32);
        long j56 = (j28 ^ j41) ^ j30;
        long j57 = ((j29 ^ j48) ^ j41) ^ j32;
        long j58 = j55 ^ j48;
        long j59 = j55 ^ jArr4[2];
        long j60 = jArr4[3];
        jArr5[0] = j26 ^ (j56 << 55);
        jArr5[1] = (j56 >>> 9) ^ (j57 << 46);
        jArr5[2] = (j57 >>> 18) ^ (j58 << 37);
        jArr5[3] = (j58 >>> 27) ^ (j59 << 28);
        jArr5[4] = (j59 >>> 36) ^ (j60 << 19);
        jArr5[5] = j60 >>> 45;
        Q(jArr5, jArr3);
    }

    public static void D(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[4];
        long[] jArr6 = new long[4];
        f(jArr, jArr5);
        f(jArr2, jArr6);
        long[] jArr7 = new long[8];
        p(jArr7, jArr5[0], jArr6[0], jArr4, 0);
        p(jArr7, jArr5[1], jArr6[1], jArr4, 1);
        p(jArr7, jArr5[2], jArr6[2], jArr4, 2);
        p(jArr7, jArr5[3], jArr6[3], jArr4, 3);
        for (int i3 = 5; i3 > 0; i3--) {
            jArr4[i3] = jArr4[i3] ^ jArr4[i3 - 1];
        }
        p(jArr7, jArr5[0] ^ jArr5[1], jArr6[0] ^ jArr6[1], jArr4, 1);
        p(jArr7, jArr5[2] ^ jArr5[3], jArr6[2] ^ jArr6[3], jArr4, 3);
        for (int i4 = 7; i4 > 1; i4--) {
            jArr4[i4] = jArr4[i4] ^ jArr4[i4 - 2];
        }
        long j6 = jArr5[0] ^ jArr5[2];
        long j7 = jArr5[1] ^ jArr5[3];
        long j8 = jArr6[0] ^ jArr6[2];
        long j9 = jArr6[1] ^ jArr6[3];
        p(jArr7, j6 ^ j7, j8 ^ j9, jArr4, 3);
        long[] jArr8 = new long[3];
        p(jArr7, j6, j8, jArr8, 0);
        p(jArr7, j7, j9, jArr8, 1);
        long j10 = jArr8[0];
        long j11 = jArr8[1];
        long j12 = jArr8[2];
        long j13 = jArr4[2] ^ j10;
        jArr4[2] = j13;
        long j14 = (j10 ^ j11) ^ jArr4[3];
        jArr4[3] = j14;
        long j15 = (j11 ^ j12) ^ jArr4[4];
        jArr4[4] = j15;
        long j16 = j12 ^ jArr4[5];
        jArr4[5] = j16;
        long j17 = jArr4[0];
        long j18 = jArr4[1];
        long j19 = jArr4[6];
        long j20 = jArr4[7];
        jArr4[0] = j17 ^ (j18 << 49);
        jArr4[1] = (j18 >>> 15) ^ (j13 << 34);
        jArr4[2] = (j13 >>> 30) ^ (j14 << 19);
        jArr4[3] = ((j14 >>> 45) ^ (j15 << 4)) ^ (j16 << 53);
        jArr4[4] = ((j15 >>> 60) ^ (j19 << 38)) ^ (j16 >>> 11);
        jArr4[5] = (j19 >>> 26) ^ (j20 << 23);
        jArr4[6] = j20 >>> 41;
        jArr4[7] = 0;
        S(jArr4, jArr3);
    }

    public static void E(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[4];
        long[] jArr6 = new long[4];
        g(jArr, jArr5);
        g(jArr2, jArr6);
        long[] jArr7 = new long[8];
        q(jArr7, jArr5[0], jArr6[0], jArr4, 0);
        q(jArr7, jArr5[1], jArr6[1], jArr4, 1);
        q(jArr7, jArr5[2], jArr6[2], jArr4, 2);
        q(jArr7, jArr5[3], jArr6[3], jArr4, 3);
        for (int i3 = 5; i3 > 0; i3--) {
            jArr4[i3] = jArr4[i3] ^ jArr4[i3 - 1];
        }
        q(jArr7, jArr5[0] ^ jArr5[1], jArr6[0] ^ jArr6[1], jArr4, 1);
        q(jArr7, jArr5[2] ^ jArr5[3], jArr6[2] ^ jArr6[3], jArr4, 3);
        for (int i4 = 7; i4 > 1; i4--) {
            jArr4[i4] = jArr4[i4] ^ jArr4[i4 - 2];
        }
        long j6 = jArr5[0] ^ jArr5[2];
        long j7 = jArr5[1] ^ jArr5[3];
        long j8 = jArr6[0] ^ jArr6[2];
        long j9 = jArr6[1] ^ jArr6[3];
        q(jArr7, j6 ^ j7, j8 ^ j9, jArr4, 3);
        long[] jArr8 = new long[3];
        q(jArr7, j6, j8, jArr8, 0);
        q(jArr7, j7, j9, jArr8, 1);
        long j10 = jArr8[0];
        long j11 = jArr8[1];
        long j12 = jArr8[2];
        long j13 = jArr4[2] ^ j10;
        jArr4[2] = j13;
        long j14 = (j10 ^ j11) ^ jArr4[3];
        jArr4[3] = j14;
        long j15 = (j11 ^ j12) ^ jArr4[4];
        jArr4[4] = j15;
        long j16 = j12 ^ jArr4[5];
        jArr4[5] = j16;
        long j17 = jArr4[0];
        long j18 = jArr4[1];
        long j19 = jArr4[6];
        long j20 = jArr4[7];
        jArr4[0] = j17 ^ (j18 << 59);
        jArr4[1] = (j18 >>> 5) ^ (j13 << 54);
        jArr4[2] = (j13 >>> 10) ^ (j14 << 49);
        jArr4[3] = (j14 >>> 15) ^ (j15 << 44);
        jArr4[4] = (j15 >>> 20) ^ (j16 << 39);
        jArr4[5] = (j16 >>> 25) ^ (j19 << 34);
        jArr4[6] = (j19 >>> 30) ^ (j20 << 29);
        jArr4[7] = j20 >>> 35;
        U(jArr4, jArr3);
    }

    public static void F(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[4];
        long[] jArr6 = new long[4];
        h(jArr, jArr5);
        h(jArr2, jArr6);
        long[] jArr7 = new long[8];
        r(jArr7, jArr5[0], jArr6[0], jArr4, 0);
        r(jArr7, jArr5[1], jArr6[1], jArr4, 1);
        r(jArr7, jArr5[2], jArr6[2], jArr4, 2);
        r(jArr7, jArr5[3], jArr6[3], jArr4, 3);
        for (int i3 = 5; i3 > 0; i3--) {
            jArr4[i3] = jArr4[i3] ^ jArr4[i3 - 1];
        }
        r(jArr7, jArr5[0] ^ jArr5[1], jArr6[0] ^ jArr6[1], jArr4, 1);
        r(jArr7, jArr5[2] ^ jArr5[3], jArr6[2] ^ jArr6[3], jArr4, 3);
        for (int i4 = 7; i4 > 1; i4--) {
            jArr4[i4] = jArr4[i4] ^ jArr4[i4 - 2];
        }
        long j6 = jArr5[0] ^ jArr5[2];
        long j7 = jArr5[1] ^ jArr5[3];
        long j8 = jArr6[0] ^ jArr6[2];
        long j9 = jArr6[1] ^ jArr6[3];
        r(jArr7, j6 ^ j7, j8 ^ j9, jArr4, 3);
        long[] jArr8 = new long[3];
        r(jArr7, j6, j8, jArr8, 0);
        r(jArr7, j7, j9, jArr8, 1);
        long j10 = jArr8[0];
        long j11 = jArr8[1];
        long j12 = jArr8[2];
        long j13 = jArr4[2] ^ j10;
        jArr4[2] = j13;
        long j14 = (j10 ^ j11) ^ jArr4[3];
        jArr4[3] = j14;
        long j15 = (j11 ^ j12) ^ jArr4[4];
        jArr4[4] = j15;
        long j16 = j12 ^ jArr4[5];
        jArr4[5] = j16;
        long j17 = jArr4[0];
        long j18 = jArr4[1];
        long j19 = jArr4[6];
        long j20 = jArr4[7];
        jArr4[0] = j17 ^ (j18 << 60);
        jArr4[1] = (j18 >>> 4) ^ (j13 << 56);
        jArr4[2] = (j13 >>> 8) ^ (j14 << 52);
        jArr4[3] = (j14 >>> 12) ^ (j15 << 48);
        jArr4[4] = (j15 >>> 16) ^ (j16 << 44);
        jArr4[5] = (j16 >>> 20) ^ (j19 << 40);
        jArr4[6] = (j19 >>> 24) ^ (j20 << 36);
        jArr4[7] = j20 >>> 28;
        W(jArr4, jArr3);
    }

    public static void G(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        i(jArr, jArr4);
        i(jArr2, jArr5);
        long[] jArr6 = new long[26];
        long[] jArr7 = {j, j, j, j, j, j, j, j, j, j};
        n(jArr7, jArr4[0], jArr5[0], jArr6, 0);
        n(jArr7, jArr4[1], jArr5[1], jArr6, 2);
        n(jArr7, jArr4[2], jArr5[2], jArr6, 4);
        n(jArr7, jArr4[3], jArr5[3], jArr6, 6);
        n(jArr7, jArr4[4], jArr5[4], jArr6, 8);
        long j6 = jArr4[0];
        long j7 = j6 ^ jArr4[1];
        long j8 = jArr5[0];
        long j9 = j8 ^ jArr5[1];
        long j10 = jArr4[2];
        long j11 = j6 ^ j10;
        long j12 = jArr5[2];
        long j13 = j8 ^ j12;
        long j14 = jArr4[4];
        long j15 = j10 ^ j14;
        long j16 = jArr5[4];
        long j17 = j12 ^ j16;
        long j18 = jArr4[3];
        long j19 = j18 ^ j14;
        long j20 = jArr5[3];
        long j21 = j20 ^ j16;
        n(jArr7, j11 ^ j18, j13 ^ j20, jArr6, 18);
        n(jArr7, j15 ^ jArr4[1], j17 ^ jArr5[1], jArr6, 20);
        long j22 = j7 ^ j19;
        long j23 = j9 ^ j21;
        long j24 = j22 ^ jArr4[2];
        long j25 = jArr5[2] ^ j23;
        n(jArr7, j22, j23, jArr6, 22);
        n(jArr7, j24, j25, jArr6, 24);
        n(jArr7, j7, j9, jArr6, 10);
        n(jArr7, j11, j13, jArr6, 12);
        n(jArr7, j15, j17, jArr6, 14);
        n(jArr7, j19, j21, jArr6, 16);
        long j26 = jArr6[0];
        long j27 = jArr6[9];
        long j28 = jArr6[0];
        long j29 = j28 ^ jArr6[1];
        long j30 = j29 ^ jArr6[2];
        long j31 = j30 ^ jArr6[10];
        long j32 = jArr6[3] ^ jArr6[4];
        long j33 = j30 ^ (j32 ^ (jArr6[11] ^ jArr6[12]));
        long j34 = j29 ^ j32;
        long j35 = jArr6[5] ^ jArr6[6];
        long j36 = jArr6[8];
        long j37 = (j34 ^ j35) ^ j36;
        long j38 = jArr6[13] ^ jArr6[14];
        long j39 = jArr6[18];
        long j40 = jArr6[22];
        long j41 = jArr6[24];
        long j42 = (j37 ^ j38) ^ ((j39 ^ j40) ^ j41);
        long j43 = jArr6[7] ^ j36;
        long j44 = jArr6[9];
        long j45 = j43 ^ j44;
        long j46 = j45 ^ jArr6[17];
        long j47 = (j45 ^ j35) ^ (jArr6[15] ^ jArr6[16]);
        long j48 = jArr6[19] ^ jArr6[20];
        long j49 = jArr6[25];
        long j50 = jArr6[23];
        long j51 = j48 ^ (j49 ^ j41);
        long j52 = (j51 ^ (j39 ^ j50)) ^ (j47 ^ j31);
        long j53 = jArr6[21];
        long j54 = (j51 ^ (j33 ^ j46)) ^ (j53 ^ j40);
        long j55 = (((((j37 ^ j28) ^ j44) ^ j38) ^ j53) ^ j50) ^ j49;
        jArr7[0] = j26 ^ (j31 << 57);
        jArr7[1] = (j31 >>> 7) ^ (j33 << 50);
        jArr7[2] = (j33 >>> 14) ^ (j42 << 43);
        jArr7[3] = (j42 >>> 21) ^ (j52 << 36);
        jArr7[4] = (j52 >>> 28) ^ (j54 << 29);
        jArr7[5] = (j54 >>> 35) ^ (j55 << 22);
        jArr7[6] = (j55 >>> 42) ^ (j47 << 15);
        jArr7[7] = (j47 >>> 49) ^ (j46 << 8);
        jArr7[8] = (j46 >>> 56) ^ (j27 << 1);
        jArr7[9] = j27 >>> 63;
        Y(jArr7, jArr3);
    }

    public static void H(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[14];
        long[] jArr5 = new long[7];
        long[] jArr6 = new long[7];
        j(jArr, jArr5);
        j(jArr2, jArr6);
        long[] jArr7 = new long[8];
        for (int i3 = 0; i3 < 7; i3++) {
            s(jArr7, jArr5[i3], jArr6[i3], jArr4, i3 << 1);
        }
        long j6 = jArr4[0];
        long j7 = jArr4[1];
        long j8 = jArr4[2] ^ j6;
        long j9 = j8 ^ j7;
        jArr4[1] = j9;
        long j10 = j7 ^ jArr4[3];
        long j11 = j8 ^ jArr4[4];
        long j12 = j11 ^ j10;
        jArr4[2] = j12;
        long j13 = j10 ^ jArr4[5];
        long j14 = j11 ^ jArr4[6];
        long j15 = j14 ^ j13;
        jArr4[3] = j15;
        long j16 = j13 ^ jArr4[7];
        long j17 = j14 ^ jArr4[8];
        long j18 = j17 ^ j16;
        jArr4[4] = j18;
        long j19 = j16 ^ jArr4[9];
        long j20 = j17 ^ jArr4[10];
        long j21 = j20 ^ j19;
        jArr4[5] = j21;
        long j22 = j19 ^ jArr4[11];
        long j23 = j20 ^ jArr4[12];
        long j24 = j23 ^ j22;
        jArr4[6] = j24;
        long j25 = (j22 ^ jArr4[13]) ^ j23;
        jArr4[7] = j6 ^ j25;
        jArr4[8] = j9 ^ j25;
        jArr4[9] = j12 ^ j25;
        jArr4[10] = j15 ^ j25;
        jArr4[11] = j18 ^ j25;
        jArr4[12] = j21 ^ j25;
        jArr4[13] = j24 ^ j25;
        s(jArr7, jArr5[0] ^ jArr5[1], jArr6[0] ^ jArr6[1], jArr4, 1);
        s(jArr7, jArr5[0] ^ jArr5[2], jArr6[0] ^ jArr6[2], jArr4, 2);
        s(jArr7, jArr5[0] ^ jArr5[3], jArr6[0] ^ jArr6[3], jArr4, 3);
        s(jArr7, jArr5[1] ^ jArr5[2], jArr6[1] ^ jArr6[2], jArr4, 3);
        s(jArr7, jArr5[0] ^ jArr5[4], jArr6[0] ^ jArr6[4], jArr4, 4);
        s(jArr7, jArr5[1] ^ jArr5[3], jArr6[1] ^ jArr6[3], jArr4, 4);
        s(jArr7, jArr5[0] ^ jArr5[5], jArr6[0] ^ jArr6[5], jArr4, 5);
        s(jArr7, jArr5[1] ^ jArr5[4], jArr6[1] ^ jArr6[4], jArr4, 5);
        s(jArr7, jArr5[2] ^ jArr5[3], jArr6[2] ^ jArr6[3], jArr4, 5);
        s(jArr7, jArr5[0] ^ jArr5[6], jArr6[0] ^ jArr6[6], jArr4, 6);
        s(jArr7, jArr5[1] ^ jArr5[5], jArr6[1] ^ jArr6[5], jArr4, 6);
        s(jArr7, jArr5[2] ^ jArr5[4], jArr6[2] ^ jArr6[4], jArr4, 6);
        s(jArr7, jArr5[1] ^ jArr5[6], jArr6[1] ^ jArr6[6], jArr4, 7);
        s(jArr7, jArr5[2] ^ jArr5[5], jArr6[2] ^ jArr6[5], jArr4, 7);
        s(jArr7, jArr5[3] ^ jArr5[4], jArr6[3] ^ jArr6[4], jArr4, 7);
        s(jArr7, jArr5[2] ^ jArr5[6], jArr6[2] ^ jArr6[6], jArr4, 8);
        s(jArr7, jArr5[3] ^ jArr5[5], jArr6[3] ^ jArr6[5], jArr4, 8);
        s(jArr7, jArr5[3] ^ jArr5[6], jArr6[3] ^ jArr6[6], jArr4, 9);
        s(jArr7, jArr5[4] ^ jArr5[5], jArr6[4] ^ jArr6[5], jArr4, 9);
        s(jArr7, jArr5[4] ^ jArr5[6], jArr6[4] ^ jArr6[6], jArr4, 10);
        s(jArr7, jArr5[5] ^ jArr5[6], jArr6[5] ^ jArr6[6], jArr4, 11);
        long j26 = jArr4[0];
        long j27 = jArr4[1];
        long j28 = jArr4[2];
        long j29 = jArr4[3];
        long j30 = jArr4[4];
        long j31 = jArr4[5];
        long j32 = jArr4[6];
        long j33 = jArr4[7];
        long j34 = jArr4[8];
        long j35 = jArr4[9];
        long j36 = jArr4[10];
        long j37 = jArr4[11];
        long j38 = jArr4[12];
        long j39 = jArr4[13];
        jArr4[0] = j26 ^ (j27 << 59);
        jArr4[1] = (j27 >>> 5) ^ (j28 << 54);
        jArr4[2] = (j28 >>> 10) ^ (j29 << 49);
        jArr4[3] = (j29 >>> 15) ^ (j30 << 44);
        jArr4[4] = (j30 >>> 20) ^ (j31 << 39);
        jArr4[5] = (j31 >>> 25) ^ (j32 << 34);
        jArr4[6] = (j32 >>> 30) ^ (j33 << 29);
        jArr4[7] = (j33 >>> 35) ^ (j34 << 24);
        jArr4[8] = (j34 >>> 40) ^ (j35 << 19);
        jArr4[9] = (j35 >>> 45) ^ (j36 << 14);
        jArr4[10] = (j36 >>> 50) ^ (j37 << 9);
        jArr4[11] = ((j37 >>> 55) ^ (j38 << 4)) ^ (j39 << 63);
        jArr4[12] = j39 >>> 1;
        a0(jArr4, jArr3);
    }

    public static void I(int[] iArr, int[] iArr2) {
        long j6 = ((long) iArr[0]) & 4294967295L;
        long j7 = ((long) iArr[1]) & 4294967295L;
        long j8 = ((long) iArr[2]) & 4294967295L;
        long j9 = ((long) iArr[3]) & 4294967295L;
        long j10 = ((long) iArr[4]) & 4294967295L;
        long j11 = ((long) iArr[5]) & 4294967295L;
        long j12 = ((long) iArr[6]) & 4294967295L;
        long j13 = ((long) iArr[7]) & 4294967295L;
        long j14 = j9 + j13;
        long j15 = j12 + (j13 << 1);
        long j16 = j11 + (j15 << 1);
        long j17 = j7 + j16;
        long j18 = j10 + (j16 << 1);
        long j19 = j6 + j18;
        iArr2[0] = (int) j19;
        long j20 = j17 + (j19 >>> 32);
        iArr2[1] = (int) j20;
        long j21 = j8 + j15 + (j20 >>> 32);
        iArr2[2] = (int) j21;
        long j22 = j14 + (j18 << 1) + (j21 >>> 32);
        iArr2[3] = (int) j22;
        long j23 = j22 >>> 32;
        while (true) {
            int i3 = (int) j23;
            if (i3 == 0) {
                break;
            }
            long j24 = ((long) i3) & 4294967295L;
            long j25 = (((long) iArr2[0]) & 4294967295L) + j24;
            iArr2[0] = (int) j25;
            long j26 = j25 >> 32;
            if (j26 != 0) {
                long j27 = j26 + (((long) iArr2[1]) & 4294967295L);
                iArr2[1] = (int) j27;
                long j28 = (j27 >> 32) + (((long) iArr2[2]) & 4294967295L);
                iArr2[2] = (int) j28;
                j26 = j28 >> 32;
            }
            long j29 = (((long) iArr2[3]) & 4294967295L) + (j24 << 1) + j26;
            iArr2[3] = (int) j29;
            j23 = j29 >> 32;
        }
        if ((iArr2[3] >>> 1) < 2147483646 || !E1.k.R(iArr2, f3222a)) {
            return;
        }
        a(iArr2);
    }

    public static void J(long[] jArr, long[] jArr2) {
        long j6 = jArr[9];
        long j7 = jArr[17];
        long j8 = (((j6 ^ (j7 >>> 59)) ^ (j7 >>> 57)) ^ (j7 >>> 54)) ^ (j7 >>> 49);
        long j9 = (j7 << 15) ^ (((jArr[8] ^ (j7 << 5)) ^ (j7 << 7)) ^ (j7 << 10));
        for (int i3 = 16; i3 >= 10; i3--) {
            long j10 = jArr[i3];
            jArr2[i3 - 8] = (((j9 ^ (j10 >>> 59)) ^ (j10 >>> 57)) ^ (j10 >>> 54)) ^ (j10 >>> 49);
            j9 = (((jArr[i3 - 9] ^ (j10 << 5)) ^ (j10 << 7)) ^ (j10 << 10)) ^ (j10 << 15);
        }
        jArr2[1] = (((j9 ^ (j8 >>> 59)) ^ (j8 >>> 57)) ^ (j8 >>> 54)) ^ (j8 >>> 49);
        long j11 = (j8 << 15) ^ (((jArr[0] ^ (j8 << 5)) ^ (j8 << 7)) ^ (j8 << 10));
        long j12 = jArr2[8];
        long j13 = j12 >>> 59;
        jArr2[0] = (((j11 ^ j13) ^ (j13 << 2)) ^ (j13 << 5)) ^ (j13 << 10);
        jArr2[8] = 576460752303423487L & j12;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void K(int[] r22, int[] r23) {
        /*
            r0 = r23
            r1 = 5
            r2 = r22[r1]
            long r2 = (long) r2
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            r6 = 6
            r6 = r22[r6]
            long r6 = (long) r6
            long r6 = r6 & r4
            r8 = 7
            r8 = r22[r8]
            long r8 = (long) r8
            long r8 = r8 & r4
            r10 = 8
            r10 = r22[r10]
            long r10 = (long) r10
            long r10 = r10 & r4
            r12 = 9
            r12 = r22[r12]
            long r12 = (long) r12
            long r12 = r12 & r4
            r14 = 0
            r15 = r22[r14]
            r16 = r4
            long r4 = (long) r15
            long r4 = r4 & r16
            long r4 = r4 + r2
            r15 = 31
            long r2 = r2 << r15
            long r4 = r4 + r2
            int r2 = (int) r4
            r0[r14] = r2
            r3 = 32
            long r4 = r4 >>> r3
            r18 = 1
            r19 = r3
            r3 = r22[r18]
            r20 = r14
            r21 = r15
            long r14 = (long) r3
            long r14 = r14 & r16
            long r14 = r14 + r6
            long r6 = r6 << r21
            long r14 = r14 + r6
            long r14 = r14 + r4
            int r3 = (int) r14
            r0[r18] = r3
            long r4 = r14 >>> r19
            r6 = 2
            r7 = r22[r6]
            long r14 = (long) r7
            long r14 = r14 & r16
            long r14 = r14 + r8
            long r7 = r8 << r21
            long r14 = r14 + r7
            long r14 = r14 + r4
            int r4 = (int) r14
            r0[r6] = r4
            long r4 = r14 >>> r19
            r7 = 3
            r8 = r22[r7]
            long r8 = (long) r8
            long r8 = r8 & r16
            long r8 = r8 + r10
            long r10 = r10 << r21
            long r8 = r8 + r10
            long r8 = r8 + r4
            int r4 = (int) r8
            r0[r7] = r4
            long r4 = r8 >>> r19
            r7 = 4
            r8 = r22[r7]
            long r8 = (long) r8
            long r8 = r8 & r16
            long r8 = r8 + r12
            long r10 = r12 << r21
            long r8 = r8 + r10
            long r8 = r8 + r4
            int r4 = (int) r8
            r0[r7] = r4
            long r4 = r8 >>> r19
            int r4 = (int) r4
            r5 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            if (r4 == 0) goto Laa
            long r8 = (long) r5
            long r8 = r8 & r16
            long r10 = (long) r4
            long r10 = r10 & r16
            long r10 = r10 * r8
            long r8 = (long) r2
            long r8 = r8 & r16
            long r10 = r10 + r8
            int r2 = (int) r10
            r0[r20] = r2
            long r8 = r10 >>> r19
            long r2 = (long) r3
            long r2 = r2 & r16
            long r8 = r8 + r2
            int r2 = (int) r8
            r0[r18] = r2
            long r2 = r8 >>> r19
            r8 = 0
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 != 0) goto La4
            r14 = r20
            goto La8
        La4:
            int r14 = E1.k.U(r1, r6, r0)
        La8:
            if (r14 != 0) goto Lb7
        Laa:
            r2 = r0[r7]
            r3 = -1
            if (r2 != r3) goto Lba
            int[] r2 = f4.AbstractC0447b.b
            boolean r2 = c4.AbstractC0246d.U(r0, r2)
            if (r2 == 0) goto Lba
        Lb7:
            E1.k.f(r1, r5, r0)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f4.AbstractC0447b.K(int[], int[]):void");
    }

    public static void L(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = j8 ^ ((j9 >>> 40) ^ (j9 >>> 49));
        long j11 = j6 ^ ((j10 << 15) ^ (j10 << 24));
        long j12 = (j7 ^ ((j9 << 15) ^ (j9 << 24))) ^ ((j10 >>> 40) ^ (j10 >>> 49));
        long j13 = j12 >>> 49;
        jArr2[0] = (j11 ^ j13) ^ (j13 << 9);
        jArr2[1] = 562949953421311L & j12;
    }

    public static void M(int[] iArr, int[] iArr2) {
        int i3 = iArr[32];
        int i4 = i3;
        int i5 = 16;
        while (true) {
            int i6 = i5 - 1;
            if (i6 < 0) {
                break;
            }
            int i7 = iArr[i5 + 15];
            iArr2[i6] = (i4 << (-9)) | (i7 >>> 9);
            i4 = i7;
            i5 = i6;
        }
        int i8 = ((i4 << (-9)) >>> 23) + (i3 >>> 9);
        int i9 = 0;
        long j6 = 0;
        for (int i10 = 0; i10 < 16; i10++) {
            long j7 = (((long) iArr[i10]) & 4294967295L) + (4294967295L & ((long) iArr2[i10])) + j6;
            iArr2[i10] = (int) j7;
            j6 = j7 >>> 32;
        }
        int i11 = i8 + ((int) j6);
        if (i11 > 511 || (i11 == 511 && E1.k.z(iArr2, f3227k, 16))) {
            int i12 = 0;
            while (true) {
                if (i12 >= 16) {
                    i9 = 1;
                    break;
                }
                int i13 = iArr2[i12] + 1;
                iArr2[i12] = i13;
                if (i13 != 0) {
                    break;
                } else {
                    i12++;
                }
            }
            i11 = (i9 + i11) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr2[16] = i11;
    }

    public static void N(int[] iArr, int[] iArr2) {
        long j6 = ((long) 21389) & 4294967295L;
        long j7 = ((long) iArr[5]) & 4294967295L;
        long j8 = (j6 * j7) + (((long) iArr[0]) & 4294967295L);
        int i3 = (int) j8;
        iArr2[0] = i3;
        long j9 = ((long) iArr[6]) & 4294967295L;
        long j10 = (j6 * j9) + j7 + (((long) iArr[1]) & 4294967295L) + (j8 >>> 32);
        int i4 = (int) j10;
        iArr2[1] = i4;
        long j11 = ((long) iArr[7]) & 4294967295L;
        long j12 = (j6 * j11) + j9 + (((long) iArr[2]) & 4294967295L) + (j10 >>> 32);
        int i5 = (int) j12;
        iArr2[2] = i5;
        long j13 = ((long) iArr[8]) & 4294967295L;
        long j14 = (j6 * j13) + j11 + (((long) iArr[3]) & 4294967295L) + (j12 >>> 32);
        int i6 = (int) j14;
        iArr2[3] = i6;
        long j15 = ((long) iArr[9]) & 4294967295L;
        long j16 = (j6 * j15) + j13 + (((long) iArr[4]) & 4294967295L) + (j14 >>> 32);
        iArr2[4] = (int) j16;
        long j17 = (j16 >>> 32) + j15;
        long j18 = j17 & 4294967295L;
        long j19 = (j6 * j18) + (((long) i3) & 4294967295L);
        iArr2[0] = (int) j19;
        long j20 = j17 >>> 32;
        long j21 = (j6 * j20) + j18 + (((long) i4) & 4294967295L) + (j19 >>> 32);
        iArr2[1] = (int) j21;
        long j22 = j20 + (((long) i5) & 4294967295L) + (j21 >>> 32);
        iArr2[2] = (int) j22;
        long j23 = (j22 >>> 32) + (((long) i6) & 4294967295L);
        iArr2[3] = (int) j23;
        if (((j23 >>> 32) == 0 ? 0 : E1.k.U(5, 4, iArr2)) != 0 || (iArr2[4] == -1 && AbstractC0246d.U(iArr2, c))) {
            E1.k.c(5, 21389, iArr2);
        }
    }

    public static void O(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        long j11 = j9 ^ (j10 >>> 59);
        long j12 = j6 ^ ((j11 << 61) ^ (j11 << 63));
        long j13 = (j7 ^ ((j10 << 61) ^ (j10 << 63))) ^ ((((j11 >>> 3) ^ (j11 >>> 1)) ^ j11) ^ (j11 << 5));
        long j14 = (j8 ^ ((((j10 >>> 3) ^ (j10 >>> 1)) ^ j10) ^ (j10 << 5))) ^ (j11 >>> 59);
        long j15 = j14 >>> 3;
        jArr2[0] = (((j12 ^ j15) ^ (j15 << 2)) ^ (j15 << 3)) ^ (j15 << 8);
        jArr2[1] = (j14 >>> 59) ^ j13;
        jArr2[2] = 7 & j14;
    }

    public static void P(int[] iArr, int[] iArr2) {
        long j6 = ((long) 4553) & 4294967295L;
        long j7 = ((long) iArr[6]) & 4294967295L;
        long j8 = (j6 * j7) + (((long) iArr[0]) & 4294967295L);
        int i3 = (int) j8;
        iArr2[0] = i3;
        long j9 = ((long) iArr[7]) & 4294967295L;
        long j10 = (j6 * j9) + j7 + (((long) iArr[1]) & 4294967295L) + (j8 >>> 32);
        int i4 = (int) j10;
        iArr2[1] = i4;
        long j11 = ((long) iArr[8]) & 4294967295L;
        long j12 = (j6 * j11) + j9 + (((long) iArr[2]) & 4294967295L) + (j10 >>> 32);
        int i5 = (int) j12;
        iArr2[2] = i5;
        long j13 = ((long) iArr[9]) & 4294967295L;
        long j14 = (j6 * j13) + j11 + (((long) iArr[3]) & 4294967295L) + (j12 >>> 32);
        int i6 = (int) j14;
        iArr2[3] = i6;
        long j15 = ((long) iArr[10]) & 4294967295L;
        long j16 = (j6 * j15) + j13 + (((long) iArr[4]) & 4294967295L) + (j14 >>> 32);
        iArr2[4] = (int) j16;
        long j17 = ((long) iArr[11]) & 4294967295L;
        long j18 = (j6 * j17) + j15 + (((long) iArr[5]) & 4294967295L) + (j16 >>> 32);
        iArr2[5] = (int) j18;
        long j19 = (j18 >>> 32) + j17;
        long j20 = j19 & 4294967295L;
        long j21 = (j6 * j20) + (((long) i3) & 4294967295L);
        iArr2[0] = (int) j21;
        long j22 = j19 >>> 32;
        long j23 = (j6 * j22) + j20 + (((long) i4) & 4294967295L) + (j21 >>> 32);
        iArr2[1] = (int) j23;
        long j24 = j22 + (((long) i5) & 4294967295L) + (j23 >>> 32);
        iArr2[2] = (int) j24;
        long j25 = (j24 >>> 32) + (((long) i6) & 4294967295L);
        iArr2[3] = (int) j25;
        if (((j25 >>> 32) == 0 ? 0 : E1.k.U(6, 4, iArr2)) != 0 || (iArr2[5] == -1 && AbstractC0132a.F(iArr2, d))) {
            E1.k.c(6, 4553, iArr2);
        }
    }

    public static void Q(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        long j11 = jArr[5];
        long j12 = j9 ^ ((((j11 >>> 35) ^ (j11 >>> 32)) ^ (j11 >>> 29)) ^ (j11 >>> 28));
        long j13 = (j8 ^ ((((j11 << 29) ^ (j11 << 32)) ^ (j11 << 35)) ^ (j11 << 36))) ^ ((j10 >>> 28) ^ (((j10 >>> 35) ^ (j10 >>> 32)) ^ (j10 >>> 29)));
        long j14 = j6 ^ ((((j12 << 29) ^ (j12 << 32)) ^ (j12 << 35)) ^ (j12 << 36));
        long j15 = (j7 ^ ((((j10 << 29) ^ (j10 << 32)) ^ (j10 << 35)) ^ (j10 << 36))) ^ ((j12 >>> 28) ^ (((j12 >>> 35) ^ (j12 >>> 32)) ^ (j12 >>> 29)));
        long j16 = j13 >>> 35;
        jArr2[0] = (((j14 ^ j16) ^ (j16 << 3)) ^ (j16 << 6)) ^ (j16 << 7);
        jArr2[1] = j15;
        jArr2[2] = 34359738367L & j13;
    }

    public static void R(int[] iArr, int[] iArr2) {
        long j6 = ((long) iArr[6]) & 4294967295L;
        long j7 = ((long) iArr[7]) & 4294967295L;
        long j8 = ((long) iArr[8]) & 4294967295L;
        long j9 = ((long) iArr[9]) & 4294967295L;
        long j10 = (((long) iArr[10]) & 4294967295L) + j6;
        long j11 = (((long) iArr[11]) & 4294967295L) + j7;
        long j12 = (((long) iArr[0]) & 4294967295L) + j10;
        int i3 = (int) j12;
        long j13 = (((long) iArr[1]) & 4294967295L) + j11 + (j12 >> 32);
        int i4 = (int) j13;
        iArr2[1] = i4;
        long j14 = j10 + j8;
        long j15 = j11 + j9;
        long j16 = (((long) iArr[2]) & 4294967295L) + j14 + (j13 >> 32);
        long j17 = j16 & 4294967295L;
        long j18 = (((long) iArr[3]) & 4294967295L) + j15 + (j16 >> 32);
        iArr2[3] = (int) j18;
        long j19 = (((long) iArr[4]) & 4294967295L) + (j14 - j6) + (j18 >> 32);
        iArr2[4] = (int) j19;
        long j20 = (((long) iArr[5]) & 4294967295L) + (j15 - j7) + (j19 >> 32);
        iArr2[5] = (int) j20;
        long j21 = j20 >> 32;
        long j22 = j17 + j21;
        long j23 = j21 + (((long) i3) & 4294967295L);
        iArr2[0] = (int) j23;
        long j24 = j23 >> 32;
        if (j24 != 0) {
            long j25 = j24 + (((long) i4) & 4294967295L);
            iArr2[1] = (int) j25;
            j22 += j25 >> 32;
        }
        iArr2[2] = (int) j22;
        if (((j22 >> 32) == 0 || E1.k.T(6, 3, iArr2) == 0) && !(iArr2[5] == -1 && AbstractC0132a.F(iArr2, e))) {
            return;
        }
        b(iArr2);
    }

    public static void S(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        long j11 = jArr[5];
        long j12 = jArr[6];
        long j13 = j10 ^ (j12 >>> 50);
        long j14 = (j9 ^ ((j12 >>> 1) ^ (j12 << 14))) ^ (j11 >>> 50);
        long j15 = j6 ^ (j13 << 63);
        long j16 = (j7 ^ (j11 << 63)) ^ ((j13 >>> 1) ^ (j13 << 14));
        long j17 = ((j8 ^ (j12 << 63)) ^ ((j11 >>> 1) ^ (j11 << 14))) ^ (j13 >>> 50);
        long j18 = j14 >>> 1;
        jArr2[0] = (j15 ^ j18) ^ (j18 << 15);
        jArr2[1] = (j14 >>> 50) ^ j16;
        jArr2[2] = j17;
        jArr2[3] = 1 & j14;
    }

    public static void T(int[] iArr, int[] iArr2) {
        long j6 = ((long) 6803) & 4294967295L;
        long j7 = ((long) iArr[7]) & 4294967295L;
        long j8 = (j6 * j7) + (((long) iArr[0]) & 4294967295L);
        int i3 = (int) j8;
        iArr2[0] = i3;
        long j9 = ((long) iArr[8]) & 4294967295L;
        long j10 = (j6 * j9) + j7 + (((long) iArr[1]) & 4294967295L) + (j8 >>> 32);
        int i4 = (int) j10;
        iArr2[1] = i4;
        long j11 = ((long) iArr[9]) & 4294967295L;
        long j12 = (j6 * j11) + j9 + (((long) iArr[2]) & 4294967295L) + (j10 >>> 32);
        int i5 = (int) j12;
        iArr2[2] = i5;
        long j13 = ((long) iArr[10]) & 4294967295L;
        long j14 = (j6 * j13) + j11 + (((long) iArr[3]) & 4294967295L) + (j12 >>> 32);
        int i6 = (int) j14;
        iArr2[3] = i6;
        long j15 = ((long) iArr[11]) & 4294967295L;
        long j16 = (j6 * j15) + j13 + (((long) iArr[4]) & 4294967295L) + (j14 >>> 32);
        iArr2[4] = (int) j16;
        long j17 = ((long) iArr[12]) & 4294967295L;
        long j18 = (j6 * j17) + j15 + (((long) iArr[5]) & 4294967295L) + (j16 >>> 32);
        iArr2[5] = (int) j18;
        long j19 = ((long) iArr[13]) & 4294967295L;
        long j20 = (j6 * j19) + j17 + (((long) iArr[6]) & 4294967295L) + (j18 >>> 32);
        iArr2[6] = (int) j20;
        long j21 = (j20 >>> 32) + j19;
        long j22 = j21 & 4294967295L;
        long j23 = (j6 * j22) + (((long) i3) & 4294967295L);
        iArr2[0] = (int) j23;
        long j24 = j21 >>> 32;
        long j25 = (j6 * j24) + j22 + (((long) i4) & 4294967295L) + (j23 >>> 32);
        iArr2[1] = (int) j25;
        long j26 = j24 + (((long) i5) & 4294967295L) + (j25 >>> 32);
        iArr2[2] = (int) j26;
        long j27 = (j26 >>> 32) + (((long) i6) & 4294967295L);
        iArr2[3] = (int) j27;
        if (((j27 >>> 32) == 0 ? 0 : E1.k.U(7, 4, iArr2)) != 0 || (iArr2[6] == -1 && kotlin.reflect.l.K(iArr2, f3223f))) {
            E1.k.c(7, 6803, iArr2);
        }
    }

    public static void U(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        long j11 = jArr[5];
        long j12 = jArr[6];
        long j13 = jArr[7];
        long j14 = j11 ^ (j13 >>> 31);
        long j15 = (j10 ^ ((j13 >>> 41) ^ (j13 << 33))) ^ (j12 >>> 31);
        long j16 = ((j9 ^ (j13 << 23)) ^ ((j12 >>> 41) ^ (j12 << 33))) ^ (j14 >>> 31);
        long j17 = j6 ^ (j15 << 23);
        long j18 = (j7 ^ (j14 << 23)) ^ ((j15 >>> 41) ^ (j15 << 33));
        long j19 = ((j8 ^ (j12 << 23)) ^ ((j14 >>> 41) ^ (j14 << 33))) ^ (j15 >>> 31);
        long j20 = j16 >>> 41;
        jArr2[0] = j17 ^ j20;
        jArr2[1] = (j20 << 10) ^ j18;
        jArr2[2] = j19;
        jArr2[3] = 2199023255551L & j16;
    }

    public static void V(int[] iArr, int[] iArr2) {
        long j6 = ((long) iArr[10]) & 4294967295L;
        long j7 = ((long) iArr[11]) & 4294967295L;
        long j8 = ((long) iArr[12]) & 4294967295L;
        long j9 = ((long) iArr[13]) & 4294967295L;
        long j10 = ((((long) iArr[7]) & 4294967295L) + j7) - 1;
        long j11 = (((long) iArr[8]) & 4294967295L) + j8;
        long j12 = (((long) iArr[9]) & 4294967295L) + j9;
        long j13 = (((long) iArr[0]) & 4294967295L) - j10;
        long j14 = j13 & 4294967295L;
        long j15 = ((((long) iArr[1]) & 4294967295L) - j11) + (j13 >> 32);
        int i3 = (int) j15;
        iArr2[1] = i3;
        long j16 = ((((long) iArr[2]) & 4294967295L) - j12) + (j15 >> 32);
        int i4 = (int) j16;
        iArr2[2] = i4;
        long j17 = (((((long) iArr[3]) & 4294967295L) + j10) - j6) + (j16 >> 32);
        long j18 = j17 & 4294967295L;
        long j19 = (((((long) iArr[4]) & 4294967295L) + j11) - j7) + (j17 >> 32);
        iArr2[4] = (int) j19;
        long j20 = (((((long) iArr[5]) & 4294967295L) + j12) - j8) + (j19 >> 32);
        iArr2[5] = (int) j20;
        long j21 = (((((long) iArr[6]) & 4294967295L) + j6) - j9) + (j20 >> 32);
        iArr2[6] = (int) j21;
        long j22 = (j21 >> 32) + 1;
        long j23 = j18 + j22;
        long j24 = j14 - j22;
        iArr2[0] = (int) j24;
        long j25 = j24 >> 32;
        if (j25 != 0) {
            long j26 = j25 + (((long) i3) & 4294967295L);
            iArr2[1] = (int) j26;
            long j27 = (j26 >> 32) + (((long) i4) & 4294967295L);
            iArr2[2] = (int) j27;
            j23 += j27 >> 32;
        }
        iArr2[3] = (int) j23;
        if (((j23 >> 32) == 0 || E1.k.T(7, 4, iArr2) == 0) && !(iArr2[6] == -1 && kotlin.reflect.l.K(iArr2, f3224g))) {
            return;
        }
        c(iArr2);
    }

    public static void W(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        long j11 = jArr[5];
        long j12 = jArr[6];
        long j13 = jArr[7];
        long j14 = j12 ^ (j13 >>> 17);
        long j15 = (j11 ^ (j13 << 47)) ^ (j14 >>> 17);
        long j16 = ((j10 ^ (j13 >>> 47)) ^ (j14 << 47)) ^ (j15 >>> 17);
        long j17 = j6 ^ (j16 << 17);
        long j18 = (j7 ^ (j15 << 17)) ^ (j16 >>> 47);
        long j19 = ((j8 ^ (j14 << 17)) ^ (j15 >>> 47)) ^ (j16 << 47);
        long j20 = (((j9 ^ (j13 << 17)) ^ (j14 >>> 47)) ^ (j15 << 47)) ^ (j16 >>> 17);
        long j21 = j20 >>> 47;
        jArr2[0] = j17 ^ j21;
        jArr2[1] = j18;
        jArr2[2] = (j21 << 30) ^ j19;
        jArr2[3] = 140737488355327L & j20;
    }

    public static void X(int[] iArr, int[] iArr2) {
        long j6 = ((long) 977) & 4294967295L;
        long j7 = ((long) iArr[8]) & 4294967295L;
        long j8 = (j6 * j7) + (((long) iArr[0]) & 4294967295L);
        int i3 = (int) j8;
        iArr2[0] = i3;
        long j9 = ((long) iArr[9]) & 4294967295L;
        long j10 = (j6 * j9) + j7 + (((long) iArr[1]) & 4294967295L) + (j8 >>> 32);
        int i4 = (int) j10;
        iArr2[1] = i4;
        long j11 = ((long) iArr[10]) & 4294967295L;
        long j12 = (j6 * j11) + j9 + (((long) iArr[2]) & 4294967295L) + (j10 >>> 32);
        int i5 = (int) j12;
        iArr2[2] = i5;
        long j13 = ((long) iArr[11]) & 4294967295L;
        long j14 = (j6 * j13) + j11 + (((long) iArr[3]) & 4294967295L) + (j12 >>> 32);
        int i6 = (int) j14;
        iArr2[3] = i6;
        long j15 = ((long) iArr[12]) & 4294967295L;
        long j16 = (j6 * j15) + j13 + (((long) iArr[4]) & 4294967295L) + (j14 >>> 32);
        iArr2[4] = (int) j16;
        long j17 = ((long) iArr[13]) & 4294967295L;
        long j18 = (j6 * j17) + j15 + (((long) iArr[5]) & 4294967295L) + (j16 >>> 32);
        iArr2[5] = (int) j18;
        long j19 = ((long) iArr[14]) & 4294967295L;
        long j20 = (j6 * j19) + j17 + (((long) iArr[6]) & 4294967295L) + (j18 >>> 32);
        iArr2[6] = (int) j20;
        long j21 = ((long) iArr[15]) & 4294967295L;
        long j22 = (j6 * j21) + j19 + (((long) iArr[7]) & 4294967295L) + (j20 >>> 32);
        iArr2[7] = (int) j22;
        long j23 = (j22 >>> 32) + j21;
        long j24 = j23 & 4294967295L;
        long j25 = (j6 * j24) + (((long) i3) & 4294967295L);
        iArr2[0] = (int) j25;
        long j26 = j23 >>> 32;
        long j27 = (j6 * j26) + j24 + (((long) i4) & 4294967295L) + (j25 >>> 32);
        iArr2[1] = (int) j27;
        long j28 = j26 + (((long) i5) & 4294967295L) + (j27 >>> 32);
        iArr2[2] = (int) j28;
        long j29 = (j28 >>> 32) + (((long) i6) & 4294967295L);
        iArr2[3] = (int) j29;
        if (((j29 >>> 32) == 0 ? 0 : E1.k.U(8, 4, iArr2)) != 0 || (iArr2[7] == -1 && C5.f.I(iArr2, f3225h))) {
            E1.k.c(8, 977, iArr2);
        }
    }

    public static void Y(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        long j11 = jArr[5];
        long j12 = jArr[6];
        long j13 = jArr[7];
        long j14 = jArr[8];
        long j15 = j10 ^ ((((j14 >>> 27) ^ (j14 >>> 22)) ^ (j14 >>> 20)) ^ (j14 >>> 15));
        long j16 = j6 ^ ((((j11 << 37) ^ (j11 << 42)) ^ (j11 << 44)) ^ (j11 << 49));
        long j17 = (j7 ^ ((((j12 << 37) ^ (j12 << 42)) ^ (j12 << 44)) ^ (j12 << 49))) ^ ((((j11 >>> 27) ^ (j11 >>> 22)) ^ (j11 >>> 20)) ^ (j11 >>> 15));
        long j18 = j15 >>> 27;
        jArr2[0] = (((j16 ^ j18) ^ (j18 << 5)) ^ (j18 << 7)) ^ (j18 << 12);
        jArr2[1] = j17;
        jArr2[2] = (j8 ^ ((((j13 << 37) ^ (j13 << 42)) ^ (j13 << 44)) ^ (j13 << 49))) ^ ((((j12 >>> 27) ^ (j12 >>> 22)) ^ (j12 >>> 20)) ^ (j12 >>> 15));
        jArr2[3] = (j9 ^ ((((j14 << 37) ^ (j14 << 42)) ^ (j14 << 44)) ^ (j14 << 49))) ^ ((((j13 >>> 27) ^ (j13 >>> 22)) ^ (j13 >>> 20)) ^ (j13 >>> 15));
        jArr2[4] = 134217727 & j15;
    }

    public static void Z(int[] iArr, int[] iArr2) {
        long j6;
        char c6;
        long j7 = ((long) iArr[8]) & 4294967295L;
        long j8 = ((long) iArr[9]) & 4294967295L;
        long j9 = ((long) iArr[10]) & 4294967295L;
        long j10 = ((long) iArr[11]) & 4294967295L;
        long j11 = ((long) iArr[12]) & 4294967295L;
        long j12 = ((long) iArr[13]) & 4294967295L;
        long j13 = ((long) iArr[14]) & 4294967295L;
        long j14 = ((long) iArr[15]) & 4294967295L;
        long j15 = j7 - 6;
        long j16 = j15 + j8;
        long j17 = j8 + j9;
        long j18 = (j9 + j10) - j14;
        long j19 = j10 + j11;
        long j20 = j11 + j12;
        long j21 = j12 + j13;
        long j22 = j13 + j14;
        long j23 = j21 - j16;
        long j24 = ((((long) iArr[0]) & 4294967295L) - j19) - j23;
        int i3 = (int) j24;
        iArr2[0] = i3;
        long j25 = ((((((long) iArr[1]) & 4294967295L) + j17) - j20) - j22) + (j24 >> 32);
        int i4 = (int) j25;
        iArr2[1] = i4;
        long j26 = (((((long) iArr[2]) & 4294967295L) + j18) - j21) + (j25 >> 32);
        int i5 = (int) j26;
        iArr2[2] = i5;
        long j27 = ((((((long) iArr[3]) & 4294967295L) + (j19 << 1)) + j23) - j22) + (j26 >> 32);
        int i6 = (int) j27;
        iArr2[3] = i6;
        long j28 = ((((((long) iArr[4]) & 4294967295L) + (j20 << 1)) + j13) - j17) + (j27 >> 32);
        int i7 = (int) j28;
        iArr2[4] = i7;
        long j29 = (((((long) iArr[5]) & 4294967295L) + (j21 << 1)) - j18) + (j28 >> 32);
        int i8 = (int) j29;
        iArr2[5] = i8;
        long j30 = (((long) iArr[6]) & 4294967295L) + (j22 << 1) + j23 + (j29 >> 32);
        int i9 = (int) j30;
        iArr2[6] = i9;
        long j31 = (((((((long) iArr[7]) & 4294967295L) + (j14 << 1)) + j15) - j18) - j20) + (j30 >> 32);
        int i10 = (int) j31;
        iArr2[7] = i10;
        int i11 = (int) ((j31 >> 32) + 6);
        if (i11 != 0) {
            long j32 = ((long) i11) & 4294967295L;
            long j33 = (((long) i3) & 4294967295L) + j32;
            iArr2[0] = (int) j33;
            long j34 = j33 >> 32;
            if (j34 != 0) {
                c6 = 6;
                long j35 = j34 + (((long) i4) & 4294967295L);
                iArr2[1] = (int) j35;
                long j36 = (j35 >> 32) + (((long) i5) & 4294967295L);
                iArr2[2] = (int) j36;
                j34 = j36 >> 32;
            } else {
                c6 = 6;
            }
            long j37 = ((((long) i6) & 4294967295L) - j32) + j34;
            iArr2[3] = (int) j37;
            long j38 = j37 >> 32;
            if (j38 != 0) {
                long j39 = j38 + (((long) i7) & 4294967295L);
                iArr2[4] = (int) j39;
                long j40 = (j39 >> 32) + (((long) i8) & 4294967295L);
                iArr2[5] = (int) j40;
                j38 = j40 >> 32;
            }
            long j41 = ((((long) i9) & 4294967295L) - j32) + j38;
            iArr2[c6] = (int) j41;
            long j42 = (((long) i10) & 4294967295L) + j32 + (j41 >> 32);
            iArr2[7] = (int) j42;
            j6 = j42 >> 32;
        } else {
            j6 = 0;
        }
        if (j6 != 0 || (iArr2[7] == -1 && C5.f.I(iArr2, i))) {
            d(iArr2);
        }
    }

    public static void a(int[] iArr) {
        long j6 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j6;
        long j7 = j6 >> 32;
        if (j7 != 0) {
            long j8 = j7 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j8;
            long j9 = (j8 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j9;
            j7 = j9 >> 32;
        }
        iArr[3] = (int) ((4294967295L & ((long) iArr[3])) + 2 + j7);
    }

    public static void a0(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        long j11 = jArr[5];
        long j12 = jArr[6];
        long j13 = jArr[7];
        long j14 = jArr[12];
        long j15 = j11 ^ (j14 << 39);
        long j16 = j12 ^ ((j14 >>> 25) ^ (j14 << 62));
        long j17 = j13 ^ (j14 >>> 2);
        long j18 = jArr[11];
        long j19 = j10 ^ (j18 << 39);
        long j20 = j15 ^ ((j18 >>> 25) ^ (j18 << 62));
        long j21 = j16 ^ (j18 >>> 2);
        long j22 = jArr[10];
        long j23 = j9 ^ (j22 << 39);
        long j24 = j19 ^ ((j22 >>> 25) ^ (j22 << 62));
        long j25 = j20 ^ (j22 >>> 2);
        long j26 = jArr[9];
        long j27 = j8 ^ (j26 << 39);
        long j28 = j23 ^ ((j26 >>> 25) ^ (j26 << 62));
        long j29 = j24 ^ (j26 >>> 2);
        long j30 = jArr[8];
        long j31 = j6 ^ (j17 << 39);
        long j32 = (j7 ^ (j30 << 39)) ^ ((j17 >>> 25) ^ (j17 << 62));
        long j33 = (j27 ^ ((j30 >>> 25) ^ (j30 << 62))) ^ (j17 >>> 2);
        long j34 = j21 >>> 25;
        jArr2[0] = j31 ^ j34;
        jArr2[1] = (j34 << 23) ^ j32;
        jArr2[2] = j33;
        jArr2[3] = j28 ^ (j30 >>> 2);
        jArr2[4] = j29;
        jArr2[5] = j25;
        jArr2[6] = j21 & 33554431;
    }

    public static void b(int[] iArr) {
        long j6 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j6;
        long j7 = j6 >> 32;
        if (j7 != 0) {
            long j8 = j7 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j8;
            j7 = j8 >> 32;
        }
        long j9 = (4294967295L & ((long) iArr[2])) + 1 + j7;
        iArr[2] = (int) j9;
        if ((j9 >> 32) != 0) {
            E1.k.T(6, 3, iArr);
        }
    }

    public static void b0(int[] iArr, int[] iArr2) {
        long j6;
        long j7 = ((long) iArr[16]) & 4294967295L;
        long j8 = ((long) iArr[17]) & 4294967295L;
        long j9 = ((long) iArr[18]) & 4294967295L;
        long j10 = ((long) iArr[19]) & 4294967295L;
        long j11 = ((long) iArr[20]) & 4294967295L;
        long j12 = ((long) iArr[21]) & 4294967295L;
        long j13 = ((long) iArr[22]) & 4294967295L;
        long j14 = ((long) iArr[23]) & 4294967295L;
        long j15 = ((((long) iArr[12]) & 4294967295L) + j11) - 1;
        long j16 = (((long) iArr[13]) & 4294967295L) + j13;
        long j17 = (((long) iArr[14]) & 4294967295L) + j13 + j14;
        long j18 = (((long) iArr[15]) & 4294967295L) + j14;
        long j19 = j8 + j12;
        long j20 = j12 - j14;
        long j21 = j13 - j14;
        long j22 = j15 + j20;
        long j23 = (((long) iArr[0]) & 4294967295L) + j22;
        int i3 = (int) j23;
        iArr2[0] = i3;
        long j24 = (((((long) iArr[1]) & 4294967295L) + j14) - j15) + j16 + (j23 >> 32);
        int i4 = (int) j24;
        iArr2[1] = i4;
        long j25 = (((((long) iArr[2]) & 4294967295L) - j12) - j16) + j17 + (j24 >> 32);
        int i5 = (int) j25;
        iArr2[2] = i5;
        long j26 = ((((long) iArr[3]) & 4294967295L) - j17) + j18 + j22 + (j25 >> 32);
        int i6 = (int) j26;
        iArr2[3] = i6;
        long j27 = (((((((long) iArr[4]) & 4294967295L) + j7) + j12) + j16) - j18) + j22 + (j26 >> 32);
        int i7 = (int) j27;
        iArr2[4] = i7;
        long j28 = ((((long) iArr[5]) & 4294967295L) - j7) + j16 + j17 + j19 + (j27 >> 32);
        iArr2[5] = (int) j28;
        long j29 = (((((long) iArr[6]) & 4294967295L) + j9) - j8) + j17 + j18 + (j28 >> 32);
        iArr2[6] = (int) j29;
        long j30 = ((((((long) iArr[7]) & 4294967295L) + j7) + j10) - j9) + j18 + (j29 >> 32);
        iArr2[7] = (int) j30;
        long j31 = (((((((long) iArr[8]) & 4294967295L) + j7) + j8) + j11) - j10) + (j30 >> 32);
        iArr2[8] = (int) j31;
        long j32 = (((((long) iArr[9]) & 4294967295L) + j9) - j11) + j19 + (j31 >> 32);
        iArr2[9] = (int) j32;
        long j33 = ((((((long) iArr[10]) & 4294967295L) + j9) + j10) - j20) + j21 + (j32 >> 32);
        iArr2[10] = (int) j33;
        long j34 = ((((((long) iArr[11]) & 4294967295L) + j10) + j11) - j21) + (j33 >> 32);
        iArr2[11] = (int) j34;
        int i8 = (int) ((j34 >> 32) + 1);
        if (i8 != 0) {
            long j35 = ((long) i8) & 4294967295L;
            long j36 = (((long) i3) & 4294967295L) + j35;
            iArr2[0] = (int) j36;
            long j37 = ((((long) i4) & 4294967295L) - j35) + (j36 >> 32);
            iArr2[1] = (int) j37;
            long j38 = j37 >> 32;
            if (j38 != 0) {
                long j39 = j38 + (((long) i5) & 4294967295L);
                iArr2[2] = (int) j39;
                j38 = j39 >> 32;
            }
            long j40 = (((long) i6) & 4294967295L) + j35 + j38;
            iArr2[3] = (int) j40;
            long j41 = (((long) i7) & 4294967295L) + j35 + (j40 >> 32);
            iArr2[4] = (int) j41;
            j6 = j41 >> 32;
        } else {
            j6 = 0;
        }
        if ((j6 == 0 || E1.k.T(12, 5, iArr2) == 0) && !(iArr2[11] == -1 && E1.k.S(iArr2, f3226j))) {
            return;
        }
        e(iArr2);
    }

    public static void c(int[] iArr) {
        long j6 = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j6;
        long j7 = j6 >> 32;
        if (j7 != 0) {
            long j8 = j7 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j8;
            long j9 = (j8 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j9;
            j7 = j9 >> 32;
        }
        long j10 = (4294967295L & ((long) iArr[3])) + 1 + j7;
        iArr[3] = (int) j10;
        if ((j10 >> 32) != 0) {
            E1.k.T(7, 4, iArr);
        }
    }

    public static void c0(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[8];
        kotlin.reflect.l.t(jArr, 4, jArr3);
        U(jArr3, jArr2);
    }

    public static void d(int[] iArr) {
        long j6 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j6;
        long j7 = j6 >> 32;
        if (j7 != 0) {
            long j8 = j7 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j8;
            long j9 = (j8 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j9;
            j7 = j9 >> 32;
        }
        long j10 = ((((long) iArr[3]) & 4294967295L) - 1) + j7;
        iArr[3] = (int) j10;
        long j11 = j10 >> 32;
        if (j11 != 0) {
            long j12 = j11 + (((long) iArr[4]) & 4294967295L);
            iArr[4] = (int) j12;
            long j13 = (j12 >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j13;
            j11 = j13 >> 32;
        }
        long j14 = ((((long) iArr[6]) & 4294967295L) - 1) + j11;
        iArr[6] = (int) j14;
        iArr[7] = (int) ((4294967295L & ((long) iArr[7])) + 1 + (j14 >> 32));
    }

    public static void d0(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[8];
        kotlin.reflect.l.t(jArr, 4, jArr3);
        W(jArr3, jArr2);
    }

    public static void e(int[] iArr) {
        long j6 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j6;
        long j7 = ((((long) iArr[1]) & 4294967295L) - 1) + (j6 >> 32);
        iArr[1] = (int) j7;
        long j8 = j7 >> 32;
        if (j8 != 0) {
            long j9 = j8 + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j9;
            j8 = j9 >> 32;
        }
        long j10 = (((long) iArr[3]) & 4294967295L) + 1 + j8;
        iArr[3] = (int) j10;
        long j11 = (4294967295L & ((long) iArr[4])) + 1 + (j10 >> 32);
        iArr[4] = (int) j11;
        if ((j11 >> 32) != 0) {
            E1.k.T(12, 5, iArr);
        }
    }

    public static void e0(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[9];
        kotlin.reflect.l.t(jArr, 4, jArr3);
        jArr3[8] = kotlin.reflect.l.s((int) jArr[4]);
        Y(jArr3, jArr2);
    }

    public static void f(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        jArr2[0] = j6 & 562949953421311L;
        jArr2[1] = ((j6 >>> 49) ^ (j7 << 15)) & 562949953421311L;
        jArr2[2] = ((j7 >>> 34) ^ (j8 << 30)) & 562949953421311L;
        jArr2[3] = (j8 >>> 19) ^ (j9 << 45);
    }

    public static void f0(long[] jArr, int i3, long[] jArr2) {
        long[] jArr3 = new long[18];
        kotlin.reflect.l.t(jArr, 9, jArr3);
        while (true) {
            J(jArr3, jArr2);
            i3--;
            if (i3 <= 0) {
                return;
            } else {
                kotlin.reflect.l.t(jArr2, 9, jArr3);
            }
        }
    }

    public static void g(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        jArr2[0] = j6 & 576460752303423487L;
        jArr2[1] = ((j6 >>> 59) ^ (j7 << 5)) & 576460752303423487L;
        jArr2[2] = ((j7 >>> 54) ^ (j8 << 10)) & 576460752303423487L;
        jArr2[3] = (j8 >>> 49) ^ (j9 << 15);
    }

    public static void g0(long[] jArr, int i3, long[] jArr2) {
        long[] jArr3 = new long[4];
        kotlin.reflect.l.t(jArr, 2, jArr3);
        while (true) {
            L(jArr3, jArr2);
            i3--;
            if (i3 <= 0) {
                return;
            } else {
                kotlin.reflect.l.t(jArr2, 2, jArr3);
            }
        }
    }

    public static void h(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        jArr2[0] = j6 & 1152921504606846975L;
        jArr2[1] = ((j6 >>> 60) ^ (j7 << 4)) & 1152921504606846975L;
        jArr2[2] = ((j7 >>> 56) ^ (j8 << 8)) & 1152921504606846975L;
        jArr2[3] = (j8 >>> 52) ^ (j9 << 12);
    }

    public static void h0(long[] jArr, int i3, long[] jArr2) {
        long[] jArr3 = new long[5];
        t(jArr, jArr3);
        while (true) {
            O(jArr3, jArr2);
            i3--;
            if (i3 <= 0) {
                return;
            } else {
                t(jArr2, jArr3);
            }
        }
    }

    public static void i(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        jArr2[0] = j6 & 144115188075855871L;
        jArr2[1] = ((j6 >>> 57) ^ (j7 << 7)) & 144115188075855871L;
        jArr2[2] = ((j7 >>> 50) ^ (j8 << 14)) & 144115188075855871L;
        jArr2[3] = ((j8 >>> 43) ^ (j9 << 21)) & 144115188075855871L;
        jArr2[4] = (j9 >>> 36) ^ (j10 << 28);
    }

    public static void i0(long[] jArr, int i3, long[] jArr2) {
        long[] jArr3 = new long[6];
        kotlin.reflect.l.t(jArr, 3, jArr3);
        while (true) {
            Q(jArr3, jArr2);
            i3--;
            if (i3 <= 0) {
                return;
            } else {
                kotlin.reflect.l.t(jArr2, 3, jArr3);
            }
        }
    }

    public static void j(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr[2];
        long j9 = jArr[3];
        long j10 = jArr[4];
        long j11 = jArr[5];
        long j12 = jArr[6];
        jArr2[0] = j6 & 576460752303423487L;
        jArr2[1] = ((j6 >>> 59) ^ (j7 << 5)) & 576460752303423487L;
        jArr2[2] = ((j7 >>> 54) ^ (j8 << 10)) & 576460752303423487L;
        jArr2[3] = ((j8 >>> 49) ^ (j9 << 15)) & 576460752303423487L;
        jArr2[4] = ((j9 >>> 44) ^ (j10 << 20)) & 576460752303423487L;
        jArr2[5] = ((j10 >>> 39) ^ (j11 << 25)) & 576460752303423487L;
        jArr2[6] = (j11 >>> 34) ^ (j12 << 30);
    }

    public static void j0(long[] jArr, int i3, long[] jArr2) {
        long[] jArr3 = new long[8];
        kotlin.reflect.l.t(jArr, 3, jArr3);
        jArr3[6] = jArr[3] & 1;
        while (true) {
            S(jArr3, jArr2);
            i3--;
            if (i3 <= 0) {
                return;
            }
            kotlin.reflect.l.t(jArr2, 3, jArr3);
            jArr3[6] = jArr2[3] & 1;
        }
    }

    public static void k(long[] jArr, long j6, long j7, long[] jArr2, int i3) {
        jArr[1] = j7;
        long j8 = j7 << 1;
        jArr[2] = j8;
        long j9 = j8 ^ j7;
        jArr[3] = j9;
        long j10 = j7 << 2;
        jArr[4] = j10;
        jArr[5] = j10 ^ j7;
        long j11 = j9 << 1;
        jArr[6] = j11;
        jArr[7] = j11 ^ j7;
        long j12 = jArr[((int) j6) & 7];
        long j13 = 0;
        int i4 = 48;
        do {
            int i5 = (int) (j6 >>> i4);
            long j14 = (jArr[i5 & 7] ^ (jArr[(i5 >>> 3) & 7] << 3)) ^ (jArr[(i5 >>> 6) & 7] << 6);
            j12 ^= j14 << i4;
            j13 ^= j14 >>> (-i4);
            i4 -= 9;
        } while (i4 > 0);
        jArr2[i3] = 144115188075855871L & j12;
        jArr2[i3 + 1] = (((((j6 & 72198606942111744L) & ((j7 << 7) >> 63)) >>> 8) ^ j13) << 7) ^ (j12 >>> 57);
    }

    public static void k0(long[] jArr, int i3, long[] jArr2) {
        long[] jArr3 = new long[8];
        kotlin.reflect.l.t(jArr, 4, jArr3);
        while (true) {
            U(jArr3, jArr2);
            i3--;
            if (i3 <= 0) {
                return;
            } else {
                kotlin.reflect.l.t(jArr2, 4, jArr3);
            }
        }
    }

    public static void l(long[] jArr, long j6, long j7, long[] jArr2, int i3) {
        jArr[1] = j7;
        long j8 = j7 << 1;
        jArr[2] = j8;
        long j9 = j8 ^ j7;
        jArr[3] = j9;
        long j10 = j7 << 2;
        jArr[4] = j10;
        jArr[5] = j10 ^ j7;
        long j11 = j9 << 1;
        jArr[6] = j11;
        jArr[7] = j11 ^ j7;
        int i4 = (int) j6;
        long j12 = (((jArr[i4 & 7] ^ (jArr[(i4 >>> 3) & 7] << 3)) ^ (jArr[(i4 >>> 6) & 7] << 6)) ^ (jArr[(i4 >>> 9) & 7] << 9)) ^ (jArr[(i4 >>> 12) & 7] << 12);
        long j13 = 0;
        int i5 = 30;
        do {
            int i6 = (int) (j6 >>> i5);
            long j14 = (((jArr[i6 & 7] ^ (jArr[(i6 >>> 3) & 7] << 3)) ^ (jArr[(i6 >>> 6) & 7] << 6)) ^ (jArr[(i6 >>> 9) & 7] << 9)) ^ (jArr[(i6 >>> 12) & 7] << 12);
            j12 ^= j14 << i5;
            j13 ^= j14 >>> (-i5);
            i5 -= 15;
        } while (i5 > 0);
        jArr2[i3] = 17592186044415L & j12;
        jArr2[i3 + 1] = (j12 >>> 44) ^ (j13 << 20);
    }

    public static void l0(long[] jArr, int i3, long[] jArr2) {
        long[] jArr3 = new long[8];
        kotlin.reflect.l.t(jArr, 4, jArr3);
        while (true) {
            W(jArr3, jArr2);
            i3--;
            if (i3 <= 0) {
                return;
            } else {
                kotlin.reflect.l.t(jArr2, 4, jArr3);
            }
        }
    }

    public static void m(long[] jArr, long j6, long j7, long[] jArr2, int i3) {
        jArr[1] = j7;
        long j8 = j7 << 1;
        jArr[2] = j8;
        long j9 = j8 ^ j7;
        jArr[3] = j9;
        long j10 = j7 << 2;
        jArr[4] = j10;
        jArr[5] = j10 ^ j7;
        long j11 = j9 << 1;
        jArr[6] = j11;
        jArr[7] = j11 ^ j7;
        long j12 = jArr[((int) j6) & 3];
        long j13 = 0;
        int i4 = 47;
        do {
            int i5 = (int) (j6 >>> i4);
            long j14 = (jArr[i5 & 7] ^ (jArr[(i5 >>> 3) & 7] << 3)) ^ (jArr[(i5 >>> 6) & 7] << 6);
            j12 ^= j14 << i4;
            j13 ^= j14 >>> (-i4);
            i4 -= 9;
        } while (i4 > 0);
        jArr2[i3] = 36028797018963967L & j12;
        jArr2[i3 + 1] = (j12 >>> 55) ^ (j13 << 9);
    }

    public static void m0(long[] jArr, int i3, long[] jArr2) {
        long[] jArr3 = new long[9];
        kotlin.reflect.l.t(jArr, 4, jArr3);
        jArr3[8] = kotlin.reflect.l.s((int) jArr[4]);
        while (true) {
            Y(jArr3, jArr2);
            i3--;
            if (i3 <= 0) {
                return;
            }
            kotlin.reflect.l.t(jArr2, 4, jArr3);
            jArr3[8] = kotlin.reflect.l.s((int) jArr2[4]);
        }
    }

    public static void n(long[] jArr, long j6, long j7, long[] jArr2, int i3) {
        jArr[1] = j7;
        long j8 = j7 << 1;
        jArr[2] = j8;
        long j9 = j8 ^ j7;
        jArr[3] = j9;
        long j10 = j7 << 2;
        jArr[4] = j10;
        jArr[5] = j10 ^ j7;
        long j11 = j9 << 1;
        jArr[6] = j11;
        jArr[7] = j11 ^ j7;
        long j12 = jArr[((int) j6) & 7];
        long j13 = 0;
        int i4 = 48;
        do {
            int i5 = (int) (j6 >>> i4);
            long j14 = (jArr[i5 & 7] ^ (jArr[(i5 >>> 3) & 7] << 3)) ^ (jArr[(i5 >>> 6) & 7] << 6);
            j12 ^= j14 << i4;
            j13 ^= j14 >>> (-i4);
            i4 -= 9;
        } while (i4 > 0);
        jArr2[i3] = 144115188075855871L & j12;
        jArr2[i3 + 1] = (((((j6 & 72198606942111744L) & ((j7 << 7) >> 63)) >>> 8) ^ j13) << 7) ^ (j12 >>> 57);
    }

    public static void n0(long[] jArr, int i3, long[] jArr2) {
        long[] jArr3 = new long[13];
        u(jArr, jArr3);
        while (true) {
            a0(jArr3, jArr2);
            i3--;
            if (i3 <= 0) {
                return;
            } else {
                u(jArr2, jArr3);
            }
        }
    }

    public static void o(long[] jArr, long j6, long j7, long[] jArr2, int i3) {
        long j8 = j6;
        jArr[1] = j7;
        for (int i4 = 2; i4 < 16; i4 += 2) {
            long j9 = jArr[i4 >>> 1] << 1;
            jArr[i4] = j9;
            jArr[i4 + 1] = j9 ^ j7;
        }
        int i5 = (int) j8;
        long j10 = jArr[i5 & 15] ^ (jArr[(i5 >>> 4) & 15] << 4);
        long j11 = 0;
        int i6 = 56;
        do {
            int i7 = (int) (j8 >>> i6);
            long j12 = jArr[i7 & 15] ^ (jArr[(i7 >>> 4) & 15] << 4);
            j10 ^= j12 << i6;
            j11 ^= j12 >>> (-i6);
            i6 -= 8;
        } while (i6 > 0);
        for (int i8 = 0; i8 < 7; i8++) {
            j8 = (j8 & (-72340172838076674L)) >>> 1;
            j11 ^= ((j7 << i8) >> 63) & j8;
        }
        jArr2[i3] = jArr2[i3] ^ j10;
        int i9 = i3 + 1;
        jArr2[i9] = jArr2[i9] ^ j11;
    }

    public static void p(long[] jArr, long j6, long j7, long[] jArr2, int i3) {
        jArr[1] = j7;
        long j8 = j7 << 1;
        jArr[2] = j8;
        long j9 = j8 ^ j7;
        jArr[3] = j9;
        long j10 = j7 << 2;
        jArr[4] = j10;
        jArr[5] = j10 ^ j7;
        long j11 = j9 << 1;
        jArr[6] = j11;
        jArr[7] = j11 ^ j7;
        int i4 = (int) j6;
        long j12 = (jArr[(i4 >>> 3) & 7] << 3) ^ jArr[i4 & 7];
        long j13 = 0;
        int i5 = 36;
        do {
            int i6 = (int) (j6 >>> i5);
            long j14 = (((jArr[i6 & 7] ^ (jArr[(i6 >>> 3) & 7] << 3)) ^ (jArr[(i6 >>> 6) & 7] << 6)) ^ (jArr[(i6 >>> 9) & 7] << 9)) ^ (jArr[(i6 >>> 12) & 7] << 12);
            j12 ^= j14 << i5;
            j13 ^= j14 >>> (-i5);
            i5 -= 15;
        } while (i5 > 0);
        jArr2[i3] = jArr2[i3] ^ (562949953421311L & j12);
        int i7 = i3 + 1;
        jArr2[i7] = jArr2[i7] ^ ((j12 >>> 49) ^ (j13 << 15));
    }

    public static void q(long[] jArr, long j6, long j7, long[] jArr2, int i3) {
        jArr[1] = j7;
        long j8 = j7 << 1;
        jArr[2] = j8;
        long j9 = j8 ^ j7;
        jArr[3] = j9;
        long j10 = j7 << 2;
        jArr[4] = j10;
        jArr[5] = j10 ^ j7;
        long j11 = j9 << 1;
        jArr[6] = j11;
        jArr[7] = j11 ^ j7;
        int i4 = (int) j6;
        long j12 = (jArr[(i4 >>> 3) & 7] << 3) ^ jArr[i4 & 7];
        long j13 = 0;
        int i5 = 54;
        do {
            int i6 = (int) (j6 >>> i5);
            long j14 = jArr[i6 & 7] ^ (jArr[(i6 >>> 3) & 7] << 3);
            j12 ^= j14 << i5;
            j13 ^= j14 >>> (-i5);
            i5 -= 6;
        } while (i5 > 0);
        jArr2[i3] = jArr2[i3] ^ (576460752303423487L & j12);
        int i7 = i3 + 1;
        jArr2[i7] = jArr2[i7] ^ ((j12 >>> 59) ^ (j13 << 5));
    }

    public static void r(long[] jArr, long j6, long j7, long[] jArr2, int i3) {
        jArr[1] = j7;
        long j8 = j7 << 1;
        jArr[2] = j8;
        long j9 = j8 ^ j7;
        jArr[3] = j9;
        long j10 = j7 << 2;
        jArr[4] = j10;
        jArr[5] = j10 ^ j7;
        long j11 = j9 << 1;
        jArr[6] = j11;
        jArr[7] = j11 ^ j7;
        int i4 = (int) j6;
        long j12 = (jArr[(i4 >>> 3) & 7] << 3) ^ jArr[i4 & 7];
        long j13 = 0;
        int i5 = 54;
        do {
            int i6 = (int) (j6 >>> i5);
            long j14 = jArr[i6 & 7] ^ (jArr[(i6 >>> 3) & 7] << 3);
            j12 ^= j14 << i5;
            j13 ^= j14 >>> (-i5);
            i5 -= 6;
        } while (i5 > 0);
        jArr2[i3] = jArr2[i3] ^ (1152921504606846975L & j12);
        int i7 = i3 + 1;
        jArr2[i7] = ((((((j6 & 585610922974906400L) & ((j7 << 4) >> 63)) >>> 5) ^ j13) << 4) ^ (j12 >>> 60)) ^ jArr2[i7];
    }

    public static void s(long[] jArr, long j6, long j7, long[] jArr2, int i3) {
        jArr[1] = j7;
        long j8 = j7 << 1;
        jArr[2] = j8;
        long j9 = j8 ^ j7;
        jArr[3] = j9;
        long j10 = j7 << 2;
        jArr[4] = j10;
        jArr[5] = j10 ^ j7;
        long j11 = j9 << 1;
        jArr[6] = j11;
        jArr[7] = j11 ^ j7;
        int i4 = (int) j6;
        long j12 = (jArr[(i4 >>> 3) & 7] << 3) ^ jArr[i4 & 7];
        long j13 = 0;
        int i5 = 54;
        do {
            int i6 = (int) (j6 >>> i5);
            long j14 = jArr[i6 & 7] ^ (jArr[(i6 >>> 3) & 7] << 3);
            j12 ^= j14 << i5;
            j13 ^= j14 >>> (-i5);
            i5 -= 6;
        } while (i5 > 0);
        jArr2[i3] = jArr2[i3] ^ (576460752303423487L & j12);
        int i7 = i3 + 1;
        jArr2[i7] = jArr2[i7] ^ ((j12 >>> 59) ^ (j13 << 5));
    }

    public static void t(long[] jArr, long[] jArr2) {
        kotlin.reflect.l.t(jArr, 2, jArr2);
        int i3 = ((int) jArr[2]) & 255;
        int i4 = (i3 | (i3 << 4)) & 3855;
        int i5 = (i4 | (i4 << 2)) & 13107;
        jArr2[4] = ((long) ((i5 | (i5 << 1)) & 21845)) & 4294967295L;
    }

    public static void u(long[] jArr, long[] jArr2) {
        kotlin.reflect.l.t(jArr, 6, jArr2);
        jArr2[12] = kotlin.reflect.l.s((int) jArr[6]);
    }

    public static int v(int[] iArr) {
        int i3 = 0;
        for (int i4 = 0; i4 < 5; i4++) {
            i3 |= iArr[i4];
        }
        return (((i3 >>> 1) | (i3 & 1)) - 1) >> 31;
    }

    public static void w(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[8];
        long j6 = ((long) iArr2[0]) & 4294967295L;
        int i3 = 1;
        long j7 = ((long) iArr2[1]) & 4294967295L;
        long j8 = ((long) iArr2[2]) & 4294967295L;
        long j9 = ((long) iArr2[3]) & 4294967295L;
        long j10 = ((long) iArr[0]) & 4294967295L;
        long j11 = j10 * j6;
        iArr4[0] = (int) j11;
        char c6 = ' ';
        long j12 = (j11 >>> 32) + (j10 * j7);
        iArr4[1] = (int) j12;
        long j13 = (j12 >>> 32) + (j10 * j8);
        iArr4[2] = (int) j13;
        long j14 = (j10 * j9) + (j13 >>> 32);
        iArr4[3] = (int) j14;
        int i4 = 4;
        iArr4[4] = (int) (j14 >>> 32);
        while (i3 < i4) {
            long j15 = ((long) iArr[i3]) & 4294967295L;
            char c7 = c6;
            long j16 = (((long) iArr4[i3]) & 4294967295L) + (j15 * j6);
            iArr4[i3] = (int) j16;
            int i5 = i3 + 1;
            long j17 = j8;
            long j18 = (j16 >>> c7) + (j15 * j7) + (((long) iArr4[i5]) & 4294967295L);
            iArr4[i5] = (int) j18;
            int i6 = i3 + 2;
            long j19 = (j15 * j17) + (((long) iArr4[i6]) & 4294967295L) + (j18 >>> c7);
            iArr4[i6] = (int) j19;
            long j20 = j19 >>> c7;
            int i7 = i3 + 3;
            long j21 = (j15 * j9) + (((long) iArr4[i7]) & 4294967295L) + j20;
            iArr4[i7] = (int) j21;
            iArr4[i3 + 4] = (int) (j21 >>> c7);
            i3 = i5;
            j8 = j17;
            i4 = 4;
            c6 = c7;
        }
        I(iArr4, iArr3);
    }

    public static void x(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        long[] jArr5 = new long[16];
        for (int i3 = 0; i3 < 9; i3++) {
            o(jArr5, jArr[i3], jArr2[i3], jArr4, i3 << 1);
        }
        long j6 = jArr4[0];
        long j7 = jArr4[1];
        long j8 = jArr4[2] ^ j6;
        long j9 = j8 ^ j7;
        jArr4[1] = j9;
        long j10 = j7 ^ jArr4[3];
        long j11 = j8 ^ jArr4[4];
        long j12 = j11 ^ j10;
        jArr4[2] = j12;
        long j13 = j10 ^ jArr4[5];
        long j14 = j11 ^ jArr4[6];
        long j15 = j14 ^ j13;
        jArr4[3] = j15;
        long j16 = j13 ^ jArr4[7];
        long j17 = j14 ^ jArr4[8];
        long j18 = j17 ^ j16;
        jArr4[4] = j18;
        long j19 = j16 ^ jArr4[9];
        long j20 = j17 ^ jArr4[10];
        long j21 = j20 ^ j19;
        jArr4[5] = j21;
        long j22 = j19 ^ jArr4[11];
        long j23 = j20 ^ jArr4[12];
        long j24 = j23 ^ j22;
        jArr4[6] = j24;
        long j25 = j22 ^ jArr4[13];
        long j26 = j23 ^ jArr4[14];
        long j27 = j26 ^ j25;
        jArr4[7] = j27;
        long j28 = j25 ^ jArr4[15];
        long j29 = j26 ^ jArr4[16];
        long j30 = j29 ^ j28;
        jArr4[8] = j30;
        long j31 = (j28 ^ jArr4[17]) ^ j29;
        jArr4[9] = j6 ^ j31;
        jArr4[10] = j9 ^ j31;
        jArr4[11] = j12 ^ j31;
        jArr4[12] = j15 ^ j31;
        jArr4[13] = j18 ^ j31;
        jArr4[14] = j21 ^ j31;
        jArr4[15] = j24 ^ j31;
        jArr4[16] = j27 ^ j31;
        jArr4[17] = j30 ^ j31;
        o(jArr5, jArr[0] ^ jArr[1], jArr2[0] ^ jArr2[1], jArr4, 1);
        o(jArr5, jArr[0] ^ jArr[2], jArr2[0] ^ jArr2[2], jArr4, 2);
        o(jArr5, jArr[0] ^ jArr[3], jArr2[0] ^ jArr2[3], jArr4, 3);
        o(jArr5, jArr[1] ^ jArr[2], jArr2[1] ^ jArr2[2], jArr4, 3);
        o(jArr5, jArr[0] ^ jArr[4], jArr2[0] ^ jArr2[4], jArr4, 4);
        o(jArr5, jArr[1] ^ jArr[3], jArr2[1] ^ jArr2[3], jArr4, 4);
        o(jArr5, jArr[0] ^ jArr[5], jArr2[0] ^ jArr2[5], jArr4, 5);
        o(jArr5, jArr[1] ^ jArr[4], jArr2[1] ^ jArr2[4], jArr4, 5);
        o(jArr5, jArr[2] ^ jArr[3], jArr2[2] ^ jArr2[3], jArr4, 5);
        o(jArr5, jArr[0] ^ jArr[6], jArr2[0] ^ jArr2[6], jArr4, 6);
        o(jArr5, jArr[1] ^ jArr[5], jArr2[1] ^ jArr2[5], jArr4, 6);
        o(jArr5, jArr[2] ^ jArr[4], jArr2[2] ^ jArr2[4], jArr4, 6);
        o(jArr5, jArr[0] ^ jArr[7], jArr2[0] ^ jArr2[7], jArr4, 7);
        o(jArr5, jArr[1] ^ jArr[6], jArr2[1] ^ jArr2[6], jArr4, 7);
        o(jArr5, jArr[2] ^ jArr[5], jArr2[2] ^ jArr2[5], jArr4, 7);
        o(jArr5, jArr[3] ^ jArr[4], jArr2[3] ^ jArr2[4], jArr4, 7);
        o(jArr5, jArr[0] ^ jArr[8], jArr2[0] ^ jArr2[8], jArr4, 8);
        o(jArr5, jArr[1] ^ jArr[7], jArr2[1] ^ jArr2[7], jArr4, 8);
        o(jArr5, jArr[2] ^ jArr[6], jArr2[2] ^ jArr2[6], jArr4, 8);
        o(jArr5, jArr[3] ^ jArr[5], jArr2[3] ^ jArr2[5], jArr4, 8);
        o(jArr5, jArr[1] ^ jArr[8], jArr2[1] ^ jArr2[8], jArr4, 9);
        o(jArr5, jArr[2] ^ jArr[7], jArr2[2] ^ jArr2[7], jArr4, 9);
        o(jArr5, jArr[3] ^ jArr[6], jArr2[3] ^ jArr2[6], jArr4, 9);
        o(jArr5, jArr[4] ^ jArr[5], jArr2[4] ^ jArr2[5], jArr4, 9);
        o(jArr5, jArr[2] ^ jArr[8], jArr2[2] ^ jArr2[8], jArr4, 10);
        o(jArr5, jArr[3] ^ jArr[7], jArr2[3] ^ jArr2[7], jArr4, 10);
        o(jArr5, jArr[4] ^ jArr[6], jArr2[4] ^ jArr2[6], jArr4, 10);
        o(jArr5, jArr[3] ^ jArr[8], jArr2[3] ^ jArr2[8], jArr4, 11);
        o(jArr5, jArr[4] ^ jArr[7], jArr2[4] ^ jArr2[7], jArr4, 11);
        o(jArr5, jArr[5] ^ jArr[6], jArr2[5] ^ jArr2[6], jArr4, 11);
        o(jArr5, jArr[4] ^ jArr[8], jArr2[4] ^ jArr2[8], jArr4, 12);
        o(jArr5, jArr[5] ^ jArr[7], jArr2[5] ^ jArr2[7], jArr4, 12);
        o(jArr5, jArr[5] ^ jArr[8], jArr2[5] ^ jArr2[8], jArr4, 13);
        o(jArr5, jArr[6] ^ jArr[7], jArr2[6] ^ jArr2[7], jArr4, 13);
        o(jArr5, jArr[6] ^ jArr[8], jArr2[6] ^ jArr2[8], jArr4, 14);
        o(jArr5, jArr[7] ^ jArr[8], jArr2[7] ^ jArr2[8], jArr4, 15);
        J(jArr4, jArr3);
    }

    public static void y(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[24];
        AbstractC0132a.U(iArr, iArr2, iArr4);
        long j6 = ((long) iArr2[6]) & 4294967295L;
        long j7 = ((long) iArr2[7]) & 4294967295L;
        long j8 = ((long) iArr2[8]) & 4294967295L;
        long j9 = ((long) iArr2[9]) & 4294967295L;
        long j10 = ((long) iArr2[10]) & 4294967295L;
        long j11 = ((long) iArr2[11]) & 4294967295L;
        long j12 = ((long) iArr[6]) & 4294967295L;
        long j13 = j12 * j6;
        iArr4[12] = (int) j13;
        long j14 = (j12 * j7) + (j13 >>> 32);
        iArr4[13] = (int) j14;
        long j15 = (j12 * j8) + (j14 >>> 32);
        iArr4[14] = (int) j15;
        long j16 = (j12 * j9) + (j15 >>> 32);
        iArr4[15] = (int) j16;
        long j17 = (j12 * j10) + (j16 >>> 32);
        iArr4[16] = (int) j17;
        long j18 = (j12 * j11) + (j17 >>> 32);
        iArr4[17] = (int) j18;
        iArr4[18] = (int) (j18 >>> 32);
        int i3 = 12;
        int i4 = 1;
        while (i4 < 6) {
            int i5 = i3 + 1;
            long j19 = ((long) iArr[6 + i4]) & 4294967295L;
            long j20 = j7;
            long j21 = (j19 * j6) + (((long) iArr4[i5]) & 4294967295L);
            iArr4[i5] = (int) j21;
            int i6 = i3 + 2;
            long j22 = (j19 * j20) + (((long) iArr4[i6]) & 4294967295L) + (j21 >>> 32);
            iArr4[i6] = (int) j22;
            int i7 = i3 + 3;
            long j23 = (j19 * j8) + (((long) iArr4[i7]) & 4294967295L) + (j22 >>> 32);
            iArr4[i7] = (int) j23;
            int i8 = i3 + 4;
            long j24 = (j19 * j9) + (((long) iArr4[i8]) & 4294967295L) + (j23 >>> 32);
            iArr4[i8] = (int) j24;
            int i9 = i3 + 5;
            long j25 = (j19 * j10) + (((long) iArr4[i9]) & 4294967295L) + (j24 >>> 32);
            iArr4[i9] = (int) j25;
            int i10 = i3 + 6;
            long j26 = (j19 * j11) + (((long) iArr4[i10]) & 4294967295L) + (j25 >>> 32);
            iArr4[i10] = (int) j26;
            iArr4[i3 + 7] = (int) (j26 >>> 32);
            i4++;
            i3 = i5;
            j7 = j20;
        }
        int iE = AbstractC0132a.e(iArr4, iArr4);
        int iD = AbstractC0132a.d(18, 12, iArr4, iArr4, AbstractC0132a.d(0, 6, iArr4, iArr4, 0) + iE) + iE;
        int[] iArr5 = new int[6];
        int[] iArr6 = new int[6];
        boolean z6 = AbstractC0132a.t(iArr, iArr, iArr5) != AbstractC0132a.t(iArr2, iArr2, iArr6);
        int[] iArr7 = new int[12];
        AbstractC0132a.U(iArr5, iArr6, iArr7);
        E1.k.e(24, iD + (z6 ? E1.k.d(12, 6, iArr7, iArr4) : E1.k.k0(12, 6, iArr7, iArr4)), 18, iArr4);
        b0(iArr4, iArr3);
    }

    public static void z(long[] jArr, long[] jArr2, long[] jArr3) {
        long j6 = jArr[0];
        long j7 = ((jArr[1] << 7) ^ (j6 >>> 57)) & 144115188075855871L;
        long j8 = j6 & 144115188075855871L;
        long j9 = jArr2[0];
        long j10 = ((jArr2[1] << 7) ^ (j9 >>> 57)) & 144115188075855871L;
        long j11 = j9 & 144115188075855871L;
        long[] jArr4 = new long[6];
        long[] jArr5 = {(j << 57) ^ j, (j >>> 7) ^ (j << 50), (j >>> 14) ^ (j << 43), j >>> 21, 0, 0, 0, 0};
        k(jArr5, j8, j11, jArr4, 0);
        k(jArr5, j7, j10, jArr4, 2);
        k(jArr5, j7 ^ j8, j11 ^ j10, jArr4, 4);
        long j12 = jArr4[1] ^ jArr4[2];
        long j13 = jArr4[0];
        long j14 = jArr4[3];
        long j15 = (jArr4[4] ^ j13) ^ j12;
        long j16 = j12 ^ (jArr4[5] ^ j14);
        L(jArr5, jArr3);
    }
}
