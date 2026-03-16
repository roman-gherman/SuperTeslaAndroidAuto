package androidx.test.internal.util;

import B2.b;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import androidx.test.internal.util.ProcSummary;

/* JADX INFO: loaded from: classes.dex */
public final class LogUtil {
    private static volatile String myProcName;

    public interface Supplier<T> {
        T get();
    }

    private static boolean isLoggable(String str, int i) {
        if (str.length() > 23) {
            str = str.substring(0, 22);
        }
        return Log.isLoggable(str, i);
    }

    public static /* synthetic */ String lambda$logDebug$0(String str) {
        return str;
    }

    public static void logDebug(String str, final String str2, Object... objArr) {
        logDebug(str, (Supplier<String>) new Supplier() { // from class: androidx.test.internal.util.LogUtil$$ExternalSyntheticLambda1
            @Override // androidx.test.internal.util.LogUtil.Supplier
            public final Object get() {
                return LogUtil.lambda$logDebug$0(str2);
            }
        }, objArr);
    }

    public static void logDebugWithProcess(String str, final String str2, Object... objArr) {
        logDebug(str, (Supplier<String>) new Supplier() { // from class: androidx.test.internal.util.LogUtil$$ExternalSyntheticLambda0
            @Override // androidx.test.internal.util.LogUtil.Supplier
            public final Object get() {
                return b.f(str2, " in ", LogUtil.procName());
            }
        }, objArr);
    }

    private static final String procName() {
        String str;
        String str2 = myProcName;
        if (str2 != null) {
            return str2;
        }
        try {
            str = ProcSummary.summarize("self").cmdline;
        } catch (ProcSummary.SummaryException unused) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return (str.length() <= 64 || !str.contains("-classpath")) ? str : "robolectric";
    }

    private static void logDebug(String str, Supplier<String> supplier, Object... objArr) {
        if (isLoggable(str, 3)) {
            String.format(supplier.get(), objArr);
        }
    }
}
