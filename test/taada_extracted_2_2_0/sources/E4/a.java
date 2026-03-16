package E4;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[][] f320a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 256, 256);
    public static final byte[] b = new byte[256];

    static {
        long j6;
        int i = 1;
        long j7 = 72340172838076673L;
        while (true) {
            j6 = 506097522914230528L;
            if (i > 255) {
                break;
            }
            for (int i3 = 0; i3 < 256; i3 += 8) {
                g5.c.u(f320a[i], i3, b(j7, j6));
                j6 += 578721382704613384L;
            }
            j7 += 72340172838076673L;
            i++;
        }
        for (int i4 = 0; i4 < 256; i4 += 8) {
            long jC = c(j6);
            long jC2 = c(jC);
            long jB = b(b(jC2, jC), c(jC2));
            g5.c.u(b, i4, b(jC, c(b(c(c(c(jB))), jB))));
            j6 += 578721382704613384L;
        }
    }

    public static long a(long j6, long j7) {
        long j8 = j6 & j7;
        long j9 = (((((j6 << 1) & j7) ^ ((j7 << 1) & j6)) & (-6148914691236517206L)) ^ j8) ^ ((j8 & (-6148914691236517206L)) >>> 1);
        long j10 = 3689348814741910323L & j9;
        long j11 = ((j6 ^ (j6 << 2)) & (-3689348814741910324L)) ^ ((j9 & (-3689348814741910324L)) >>> 2);
        long j12 = ((j7 ^ (j7 << 2)) & (-3689348814741910324L)) ^ 2459565876494606882L;
        long j13 = (((j11 << 1) & j12) ^ ((j12 << 1) & j11)) & (-6148914691236517206L);
        long j14 = j11 & j12;
        return ((((j14 & (-6148914691236517206L)) >>> 1) ^ (j14 ^ j13)) ^ (j10 << 2)) ^ j10;
    }

    public static long b(long j6, long j7) {
        long jA = a(j6, j7);
        long j8 = 1085102592571150095L & jA;
        return (a(((j6 ^ (j6 << 4)) & (-1085102592571150096L)) ^ ((jA & (-1085102592571150096L)) >>> 4), ((j7 ^ (j7 << 4)) & (-1085102592571150096L)) ^ 578721382704613384L) ^ (j8 << 4)) ^ j8;
    }

    public static long c(long j6) {
        long j7 = j6 ^ ((j6 & (-6148914691236517206L)) >>> 1);
        long j8 = (-8608480567731124088L) & j7;
        long j9 = j7 ^ (((((4919131752989213764L & j7) << 1) ^ j8) ^ (j8 >>> 1)) >>> 2);
        long j10 = (-4557430888798830400L) & j9;
        long j11 = j10 >>> 2;
        long j12 = (((3472328296227680304L & j9) << 2) ^ j10) ^ j11;
        long j13 = (-6148914691236517206L) & j12;
        return j9 ^ ((((j13 >>> 1) ^ (((6148914691236517205L & j12) << 1) ^ j13)) ^ j11) >>> 4);
    }
}
