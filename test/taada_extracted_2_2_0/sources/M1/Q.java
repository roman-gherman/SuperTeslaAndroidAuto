package m1;

import androidx.core.location.LocationRequestCompat;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f4047a = C5.f.b("io.ktor.client.plugins.HttpTimeout");

    public static final int a(long j6) {
        if (j6 == LocationRequestCompat.PASSIVE_INTERVAL) {
            return 0;
        }
        if (j6 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (j6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j6;
    }
}
