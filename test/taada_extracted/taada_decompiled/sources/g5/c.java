package g5;

import net.bytebuddy.asm.Advice;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f3344a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return (obj == null || obj2 == null || !obj.equals(obj2)) ? false : true;
        }
        return true;
    }

    public static int b(int i, byte[] bArr) {
        return (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static short[] d(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return c(bArr2);
        }
        if (bArr2 == null) {
            return c(bArr);
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] f(byte[][] bArr) {
        int length = 0;
        for (int i = 0; i != bArr.length; i++) {
            length += bArr[i].length;
        }
        byte[] bArr2 = new byte[length];
        int length2 = 0;
        for (int i3 = 0; i3 != bArr.length; i3++) {
            byte[] bArr3 = bArr[i3];
            System.arraycopy(bArr3, 0, bArr2, length2, bArr3.length);
            length2 += bArr[i3].length;
        }
        return bArr2;
    }

    public static boolean g(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            if (bArr == bArr2) {
                return true;
            }
            int length = bArr.length < bArr2.length ? bArr.length : bArr2.length;
            int length2 = bArr.length ^ bArr2.length;
            for (int i = 0; i != length; i++) {
                length2 |= bArr[i] ^ bArr2[i];
            }
            while (length < bArr2.length) {
                byte b = bArr2[length];
                length2 |= b ^ (~b);
                length++;
            }
            if (length2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static byte[] h(byte[] bArr, int i, int i3) {
        int i4 = i(i, i3);
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i4));
        return bArr2;
    }

    public static int i(int i, int i3) {
        int i4 = i3 - i;
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException(i + " > " + i3);
    }

    public static int j(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static int k(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ bArr[length];
        }
    }

    public static int l(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ iArr[length];
        }
    }

    public static int m(int[] iArr, int i) {
        if (iArr == null) {
            return 0;
        }
        int i3 = i + 1;
        while (true) {
            i--;
            if (i < 0) {
                return i3;
            }
            i3 = (i3 * 257) ^ iArr[i];
        }
    }

    public static int n(long[] jArr, int i) {
        if (jArr == null) {
            return 0;
        }
        int i3 = i + 1;
        while (true) {
            i--;
            if (i < 0) {
                return i3;
            }
            long j6 = jArr[i];
            i3 = (((i3 * 257) ^ ((int) j6)) * 257) ^ ((int) (j6 >>> 32));
        }
    }

    public static void o(byte[] bArr, int i, int i3) {
        bArr[i3] = (byte) (i >>> 24);
        bArr[i3 + 1] = (byte) (i >>> 16);
        bArr[i3 + 2] = (byte) (i >>> 8);
        bArr[i3 + 3] = (byte) i;
    }

    public static void p(byte[] bArr, int i, int i3) {
        bArr[i3] = (byte) i;
        bArr[i3 + 1] = (byte) (i >>> 8);
        bArr[i3 + 2] = (byte) (i >>> 16);
        bArr[i3 + 3] = (byte) (i >>> 24);
    }

    public static int q(int i, byte[] bArr) {
        return (bArr[i + 3] << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static void r(byte[] bArr, int[] iArr, int i) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            iArr[i4] = q(i3, bArr);
            i3 += 4;
        }
    }

    public static long s(int i, byte[] bArr) {
        return ((((long) q(i + 4, bArr)) & 4294967295L) << 32) | (((long) q(i, bArr)) & 4294967295L);
    }

    public static void t(byte[] bArr, int i, long j6) {
        o(bArr, (int) (j6 >>> 32), i);
        o(bArr, (int) (j6 & 4294967295L), i + 4);
    }

    public static void u(byte[] bArr, int i, long j6) {
        p(bArr, (int) (4294967295L & j6), i);
        p(bArr, (int) (j6 >>> 32), i + 4);
    }
}
