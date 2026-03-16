package androidx.core.os;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    public static class Api19Impl {
        private Api19Impl() {
        }

        public static String getStorageState(File file) {
            return Environment.getStorageState(file);
        }
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static String getExternalStorageState(File file) {
            return Environment.getExternalStorageState(file);
        }
    }

    private EnvironmentCompat() {
    }

    public static String getStorageState(File file) {
        return Api21Impl.getExternalStorageState(file);
    }
}
