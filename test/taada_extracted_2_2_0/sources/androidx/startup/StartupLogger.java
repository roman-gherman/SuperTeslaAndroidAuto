package androidx.startup;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    public static void e(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    public static void i(String str) {
    }

    public static void w(String str) {
        Log.w(TAG, str);
    }
}
