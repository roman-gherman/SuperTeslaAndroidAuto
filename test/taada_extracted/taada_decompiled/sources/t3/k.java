package t3;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;
import r3.AbstractC0800a;
import r3.w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4835a;
    public static final long b;
    public static final int c;
    public static final int d;
    public static final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f4836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f4837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f4838h;

    static {
        String property;
        int i = w.f4721a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f4835a = property;
        b = AbstractC0800a.i(100000L, 1L, LocationRequestCompat.PASSIVE_INTERVAL, "kotlinx.coroutines.scheduler.resolution.ns");
        int i3 = w.f4721a;
        if (i3 < 2) {
            i3 = 2;
        }
        c = AbstractC0800a.j(i3, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        d = AbstractC0800a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        e = TimeUnit.SECONDS.toNanos(AbstractC0800a.i(60L, 1L, LocationRequestCompat.PASSIVE_INTERVAL, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f4836f = f.f4831a;
        f4837g = new i(0);
        f4838h = new i(1);
    }
}
