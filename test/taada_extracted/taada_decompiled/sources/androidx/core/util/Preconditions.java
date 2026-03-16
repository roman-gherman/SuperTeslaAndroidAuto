package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z6) {
        if (!z6) {
            throw new IllegalArgumentException();
        }
    }

    public static float checkArgumentFinite(float f6, String str) {
        if (Float.isNaN(f6)) {
            throw new IllegalArgumentException(B2.b.e(str, " must not be NaN"));
        }
        if (Float.isInfinite(f6)) {
            throw new IllegalArgumentException(B2.b.e(str, " must not be infinite"));
        }
        return f6;
    }

    public static int checkArgumentInRange(int i, int i3, int i4, String str) {
        if (i < i3) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i3 + ", " + i4 + "] (too low)");
        }
        if (i <= i4) {
            return i;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i3 + ", " + i4 + "] (too high)");
    }

    public static int checkArgumentNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i, int i3) {
        if ((i & i3) == i) {
            return i;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i) + ", but only 0x" + Integer.toHexString(i3) + " are allowed");
    }

    public static <T> T checkNotNull(T t6) {
        t6.getClass();
        return t6;
    }

    public static void checkState(boolean z6, String str) {
        if (!z6) {
            throw new IllegalStateException(str);
        }
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t6) {
        if (TextUtils.isEmpty(t6)) {
            throw new IllegalArgumentException();
        }
        return t6;
    }

    public static void checkArgument(boolean z6, Object obj) {
        if (!z6) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkArgumentNonnegative(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T t6, Object obj) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z6) {
        checkState(z6, null);
    }

    public static void checkArgument(boolean z6, String str, Object... objArr) {
        if (!z6) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t6, Object obj) {
        if (TextUtils.isEmpty(t6)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t6;
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t6, String str, Object... objArr) {
        if (TextUtils.isEmpty(t6)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t6;
    }

    public static long checkArgumentInRange(long j6, long j7, long j8, String str) {
        if (j6 < j7) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + j7 + ", " + j8 + "] (too low)");
        }
        if (j6 <= j8) {
            return j6;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + j7 + ", " + j8 + "] (too high)");
    }

    public static float checkArgumentInRange(float f6, float f7, float f8, String str) {
        if (f6 < f7) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f7), Float.valueOf(f8)));
        }
        if (f6 <= f8) {
            return f6;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f7), Float.valueOf(f8)));
    }

    public static double checkArgumentInRange(double d, double d6, double d7, String str) {
        if (d < d6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d6), Double.valueOf(d7)));
        }
        if (d <= d7) {
            return d;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d6), Double.valueOf(d7)));
    }
}
