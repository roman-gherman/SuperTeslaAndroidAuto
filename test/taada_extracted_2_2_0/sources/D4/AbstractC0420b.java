package d4;

import C5.f;
import E1.k;

/* JADX INFO: renamed from: d4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0420b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f3124a = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    public static void a(int[] iArr, int[] iArr2) {
        int i = iArr[7];
        int i3 = i;
        int i4 = 0;
        while (i4 < 8) {
            int i5 = iArr[8 + i4];
            iArr2[i4] = (i3 >>> 31) | (i5 << 1);
            i4++;
            i3 = i5;
        }
        long j6 = ((long) 19) & 4294967295L;
        long j7 = ((((long) iArr2[0]) & 4294967295L) * j6) + (((long) iArr[0]) & 4294967295L);
        iArr2[0] = (int) j7;
        long j8 = ((((long) iArr2[1]) & 4294967295L) * j6) + (((long) iArr[1]) & 4294967295L) + (j7 >>> 32);
        iArr2[1] = (int) j8;
        long j9 = ((((long) iArr2[2]) & 4294967295L) * j6) + (((long) iArr[2]) & 4294967295L) + (j8 >>> 32);
        iArr2[2] = (int) j9;
        long j10 = ((((long) iArr2[3]) & 4294967295L) * j6) + (((long) iArr[3]) & 4294967295L) + (j9 >>> 32);
        iArr2[3] = (int) j10;
        long j11 = ((((long) iArr2[4]) & 4294967295L) * j6) + (((long) iArr[4]) & 4294967295L) + (j10 >>> 32);
        iArr2[4] = (int) j11;
        long j12 = ((((long) iArr2[5]) & 4294967295L) * j6) + (((long) iArr[5]) & 4294967295L) + (j11 >>> 32);
        iArr2[5] = (int) j12;
        long j13 = ((((long) iArr2[6]) & 4294967295L) * j6) + (((long) iArr[6]) & 4294967295L) + (j12 >>> 32);
        iArr2[6] = (int) j13;
        long j14 = (j6 * (((long) iArr2[7]) & 4294967295L)) + (4294967295L & ((long) iArr[7])) + (j13 >>> 32);
        int i6 = (int) j14;
        iArr2[7] = i6;
        iArr2[7] = (Integer.MAX_VALUE & i6) + k.f(7, ((((int) (j14 >>> 32)) << 1) + ((i6 >>> 31) - (i >>> 31))) * 19, iArr2);
        if (f.I(iArr2, f3124a)) {
            b(iArr2);
        }
    }

    public static void b(int[] iArr) {
        long j6 = (((long) iArr[0]) & 4294967295L) + 19;
        iArr[0] = (int) j6;
        long jT = j6 >> 32;
        if (jT != 0) {
            jT = k.T(7, 1, iArr);
        }
        iArr[7] = (int) (((((long) iArr[7]) & 4294967295L) - 2147483648L) + jT);
    }
}
