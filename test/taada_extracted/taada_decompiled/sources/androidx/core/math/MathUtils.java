package androidx.core.math;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: loaded from: classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i, int i3) {
        int i4 = i + i3;
        if ((i >= 0) == (i3 >= 0)) {
            if ((i >= 0) != (i4 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i4;
    }

    public static double clamp(double d, double d6, double d7) {
        return d < d6 ? d6 : d > d7 ? d7 : d;
    }

    public static int decrementExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return i - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i) {
        if (i != Integer.MAX_VALUE) {
            return i + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i, int i3) {
        int i4 = i * i3;
        if (i == 0 || i3 == 0 || (i4 / i == i3 && i4 / i3 == i)) {
            return i4;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return -i;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i, int i3) {
        int i4 = i - i3;
        if ((i < 0) != (i3 < 0)) {
            if ((i < 0) != (i4 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i4;
    }

    public static int toIntExact(long j6) {
        if (j6 > 2147483647L || j6 < -2147483648L) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) j6;
    }

    public static long addExact(long j6, long j7) {
        long j8 = j6 + j7;
        if ((j6 >= 0) == (j7 >= 0)) {
            if ((j6 >= 0) != (j8 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j8;
    }

    public static float clamp(float f6, float f7, float f8) {
        return f6 < f7 ? f7 : f6 > f8 ? f8 : f6;
    }

    public static long decrementExact(long j6) {
        if (j6 != Long.MIN_VALUE) {
            return j6 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j6) {
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            return j6 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j6) {
        if (j6 != Long.MIN_VALUE) {
            return -j6;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j6, long j7) {
        long j8 = j6 - j7;
        if ((j6 < 0) != (j7 < 0)) {
            if ((j6 < 0) != (j8 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j8;
    }

    public static int clamp(int i, int i3, int i4) {
        return i < i3 ? i3 : i > i4 ? i4 : i;
    }

    public static long multiplyExact(long j6, long j7) {
        long j8 = j6 * j7;
        if (j6 == 0 || j7 == 0 || (j8 / j6 == j7 && j8 / j7 == j6)) {
            return j8;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j6, long j7, long j8) {
        return j6 < j7 ? j7 : j6 > j8 ? j8 : j6;
    }
}
