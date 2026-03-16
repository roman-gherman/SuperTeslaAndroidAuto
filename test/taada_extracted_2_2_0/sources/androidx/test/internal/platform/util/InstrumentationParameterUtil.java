package androidx.test.internal.platform.util;

import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class InstrumentationParameterUtil {
    public static long getTimeoutMillis(String str, long j6) {
        Checks.checkArgument(j6 != 0, "default timeout value cannot be zero");
        long j7 = Long.parseLong(InstrumentationRegistry.getArguments().getString(str, "0"));
        if (j7 != 0) {
            j6 = j7;
        }
        return j6 < 0 ? TimeUnit.DAYS.toMillis(1L) : j6;
    }
}
