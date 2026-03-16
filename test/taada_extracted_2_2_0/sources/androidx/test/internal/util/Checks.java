package androidx.test.internal.util;

import android.os.Looper;
import androidx.constraintlayout.core.motion.a;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.ThreadChecker;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Checks {
    private static final ThreadChecker THREAD_CHECKER;

    static {
        List listLoadService = ServiceLoaderWrapper.loadService(ThreadChecker.class);
        if (listLoadService.isEmpty()) {
            THREAD_CHECKER = new ThreadChecker() { // from class: androidx.test.internal.util.Checks.1
                @Override // androidx.test.internal.platform.ThreadChecker
                public void checkMainThread() {
                    Checks.checkState(Thread.currentThread().equals(Looper.getMainLooper().getThread()), "Method cannot be called off the main application thread (on: %s)", Thread.currentThread().getName());
                }

                @Override // androidx.test.internal.platform.ThreadChecker
                public void checkNotMainThread() {
                    Checks.checkState(!Thread.currentThread().equals(Looper.getMainLooper().getThread()), "Method cannot be called on the main application thread (on: %s)", Thread.currentThread().getName());
                }
            };
        } else {
            if (listLoadService.size() != 1) {
                throw new IllegalStateException(a.q("Found more than one ", ThreadChecker.class.getName(), " implementations."));
            }
            THREAD_CHECKER = (ThreadChecker) listLoadService.get(0);
        }
    }

    private Checks() {
    }

    public static void checkArgument(boolean z6) {
        if (!z6) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkMainThread() {
        THREAD_CHECKER.checkMainThread();
    }

    public static void checkNotMainThread() {
        THREAD_CHECKER.checkNotMainThread();
    }

    public static <T> T checkNotNull(T t6) {
        t6.getClass();
        return t6;
    }

    public static void checkState(boolean z6) {
        if (!z6) {
            throw new IllegalStateException();
        }
    }

    private static String format(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i = 0;
        int i3 = 0;
        while (i < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i3)) != -1) {
            sb.append(strValueOf.substring(i3, iIndexOf));
            sb.append(objArr[i]);
            i3 = iIndexOf + 2;
            i++;
        }
        sb.append(strValueOf.substring(i3));
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static void checkArgument(boolean z6, Object obj) {
        if (!z6) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T> T checkNotNull(T t6, Object obj) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z6, Object obj) {
        if (!z6) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z6, String str, Object... objArr) {
        if (!z6) {
            throw new IllegalArgumentException(format(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t6, String str, Object... objArr) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(format(str, objArr));
    }

    public static void checkState(boolean z6, String str, Object... objArr) {
        if (!z6) {
            throw new IllegalStateException(format(str, objArr));
        }
    }
}
