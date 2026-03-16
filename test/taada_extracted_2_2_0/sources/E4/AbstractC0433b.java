package e4;

import C5.f;

/* JADX INFO: renamed from: e4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0433b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f3137a = {-1, -1, 0, -1, -1, -1, -1, -2};

    public static void a(int[] iArr) {
        long j6 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j6;
        long j7 = j6 >> 32;
        if (j7 != 0) {
            long j8 = j7 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j8;
            j7 = j8 >> 32;
        }
        long j9 = ((((long) iArr[2]) & 4294967295L) - 1) + j7;
        iArr[2] = (int) j9;
        long j10 = (((long) iArr[3]) & 4294967295L) + 1 + (j9 >> 32);
        iArr[3] = (int) j10;
        long j11 = j10 >> 32;
        if (j11 != 0) {
            long j12 = j11 + (((long) iArr[4]) & 4294967295L);
            iArr[4] = (int) j12;
            long j13 = (j12 >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j13;
            long j14 = (j13 >> 32) + (((long) iArr[6]) & 4294967295L);
            iArr[6] = (int) j14;
            j11 = j14 >> 32;
        }
        iArr[7] = (int) ((4294967295L & ((long) iArr[7])) + 1 + j11);
    }

    public static void b(int[] iArr, int[] iArr2) {
        long j6;
        long j7;
        long j8 = ((long) iArr[8]) & 4294967295L;
        long j9 = ((long) iArr[9]) & 4294967295L;
        long j10 = ((long) iArr[10]) & 4294967295L;
        long j11 = ((long) iArr[11]) & 4294967295L;
        long j12 = ((long) iArr[12]) & 4294967295L;
        long j13 = ((long) iArr[13]) & 4294967295L;
        long j14 = ((long) iArr[14]) & 4294967295L;
        long j15 = ((long) iArr[15]) & 4294967295L;
        long j16 = j10 + j11;
        long j17 = j13 + j14;
        long j18 = j17 + (j15 << 1);
        long j19 = j8 + j9 + j17;
        long j20 = j16 + j12 + j15 + j19;
        long j21 = (((long) iArr[0]) & 4294967295L) + j20 + j13 + j14 + j15;
        int i = (int) j21;
        iArr2[0] = i;
        long j22 = (((((long) iArr[1]) & 4294967295L) + j20) - j8) + j14 + j15 + (j21 >> 32);
        int i3 = (int) j22;
        iArr2[1] = i3;
        long j23 = ((((long) iArr[2]) & 4294967295L) - j19) + (j22 >> 32);
        int i4 = (int) j23;
        iArr2[2] = i4;
        long j24 = ((((((long) iArr[3]) & 4294967295L) + j20) - j9) - j10) + j13 + (j23 >> 32);
        int i5 = (int) j24;
        iArr2[3] = i5;
        long j25 = ((((((long) iArr[4]) & 4294967295L) + j20) - j16) - j8) + j14 + (j24 >> 32);
        int i6 = (int) j25;
        iArr2[4] = i6;
        long j26 = (((long) iArr[5]) & 4294967295L) + j18 + j10 + (j25 >> 32);
        int i7 = (int) j26;
        iArr2[5] = i7;
        long j27 = (((long) iArr[6]) & 4294967295L) + j11 + j14 + j15 + (j26 >> 32);
        int i8 = (int) j27;
        iArr2[6] = i8;
        long j28 = (((long) iArr[7]) & 4294967295L) + j20 + j18 + j12 + (j27 >> 32);
        int i9 = (int) j28;
        iArr2[7] = i9;
        int i10 = (int) (j28 >> 32);
        if (i10 != 0) {
            long j29 = ((long) i10) & 4294967295L;
            long j30 = (((long) i) & 4294967295L) + j29;
            iArr2[0] = (int) j30;
            long j31 = j30 >> 32;
            j6 = 0;
            if (j31 != 0) {
                long j32 = j31 + (((long) i3) & 4294967295L);
                iArr2[1] = (int) j32;
                j31 = j32 >> 32;
            }
            long j33 = ((((long) i4) & 4294967295L) - j29) + j31;
            iArr2[2] = (int) j33;
            long j34 = (((long) i5) & 4294967295L) + j29 + (j33 >> 32);
            iArr2[3] = (int) j34;
            long j35 = j34 >> 32;
            if (j35 != 0) {
                long j36 = j35 + (((long) i6) & 4294967295L);
                iArr2[4] = (int) j36;
                long j37 = (j36 >> 32) + (((long) i7) & 4294967295L);
                iArr2[5] = (int) j37;
                long j38 = (j37 >> 32) + (((long) i8) & 4294967295L);
                iArr2[6] = (int) j38;
                j35 = j38 >> 32;
            }
            long j39 = (((long) i9) & 4294967295L) + j29 + j35;
            iArr2[7] = (int) j39;
            j7 = j39 >> 32;
        } else {
            j6 = 0;
            j7 = 0;
        }
        if (j7 != j6 || ((iArr2[7] >>> 1) >= Integer.MAX_VALUE && f.I(iArr2, f3137a))) {
            a(iArr2);
        }
    }
}
