package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    public static class Api16Impl {
        private Api16Impl() {
        }

        public static void setDecorFitsSystemWindows(Window window, boolean z6) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z6 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static <T> T requireViewById(Window window, int i) {
            return (T) window.requireViewById(i);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static void setDecorFitsSystemWindows(Window window, boolean z6) {
            window.setDecorFitsSystemWindows(z6);
        }
    }

    private WindowCompat() {
    }

    public static WindowInsetsControllerCompat getInsetsController(Window window, View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    public static <T extends View> T requireViewById(Window window, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) Api28Impl.requireViewById(window, i);
        }
        T t6 = (T) window.findViewById(i);
        if (t6 != null) {
            return t6;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void setDecorFitsSystemWindows(Window window, boolean z6) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setDecorFitsSystemWindows(window, z6);
        } else {
            Api16Impl.setDecorFitsSystemWindows(window, z6);
        }
    }
}
