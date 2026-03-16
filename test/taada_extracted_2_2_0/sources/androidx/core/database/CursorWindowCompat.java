package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class CursorWindowCompat {

    public static class Api15Impl {
        private Api15Impl() {
        }

        public static CursorWindow createCursorWindow(String str) {
            return new CursorWindow(str);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static CursorWindow createCursorWindow(String str, long j6) {
            return new CursorWindow(str, j6);
        }
    }

    private CursorWindowCompat() {
    }

    public static CursorWindow create(String str, long j6) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.createCursorWindow(str, j6) : Api15Impl.createCursorWindow(str);
    }
}
