package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class SQLiteCursorCompat {

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static void setFillWindowForwardOnly(SQLiteCursor sQLiteCursor, boolean z6) {
            sQLiteCursor.setFillWindowForwardOnly(z6);
        }
    }

    private SQLiteCursorCompat() {
    }

    public static void setFillWindowForwardOnly(SQLiteCursor sQLiteCursor, boolean z6) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setFillWindowForwardOnly(sQLiteCursor, z6);
        }
    }
}
