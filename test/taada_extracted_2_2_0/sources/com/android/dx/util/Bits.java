package com.android.dx.util;

/* JADX INFO: loaded from: classes.dex */
public final class Bits {
    private Bits() {
    }

    public static boolean anyInRange(int[] iArr, int i, int i3) {
        int iFindFirst = findFirst(iArr, i);
        return iFindFirst >= 0 && iFindFirst < i3;
    }

    public static int bitCount(int[] iArr) {
        int iBitCount = 0;
        for (int i : iArr) {
            iBitCount += Integer.bitCount(i);
        }
        return iBitCount;
    }

    public static void clear(int[] iArr, int i) {
        int i3 = i >> 5;
        iArr[i3] = (~(1 << (i & 31))) & iArr[i3];
    }

    public static int findFirst(int[] iArr, int i) {
        int iFindFirst;
        int length = iArr.length;
        int i3 = i & 31;
        int i4 = i >> 5;
        while (i4 < length) {
            int i5 = iArr[i4];
            if (i5 != 0 && (iFindFirst = findFirst(i5, i3)) >= 0) {
                return (i4 << 5) + iFindFirst;
            }
            i4++;
            i3 = 0;
        }
        return -1;
    }

    public static boolean get(int[] iArr, int i) {
        return (iArr[i >> 5] & (1 << (i & 31))) != 0;
    }

    public static int getMax(int[] iArr) {
        return iArr.length * 32;
    }

    public static boolean isEmpty(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] makeBitSet(int i) {
        return new int[(i + 31) >> 5];
    }

    public static void or(int[] iArr, int[] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            iArr[i] = iArr[i] | iArr2[i];
        }
    }

    public static void set(int[] iArr, int i, boolean z6) {
        int i3 = i >> 5;
        int i4 = 1 << (i & 31);
        if (z6) {
            iArr[i3] = i4 | iArr[i3];
        } else {
            iArr[i3] = (~i4) & iArr[i3];
        }
    }

    public static String toHuman(int[] iArr) {
        StringBuilder sb = new StringBuilder("{");
        int length = iArr.length * 32;
        boolean z6 = false;
        for (int i = 0; i < length; i++) {
            if (get(iArr, i)) {
                if (z6) {
                    sb.append(',');
                }
                sb.append(i);
                z6 = true;
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static void set(int[] iArr, int i) {
        int i3 = i >> 5;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public static int findFirst(int i, int i3) {
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i & (~((1 << i3) - 1)));
        if (iNumberOfTrailingZeros == 32) {
            return -1;
        }
        return iNumberOfTrailingZeros;
    }
}
