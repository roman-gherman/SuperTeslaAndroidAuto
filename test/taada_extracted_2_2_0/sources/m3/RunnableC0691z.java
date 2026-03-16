package m3;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: m3.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0691z extends P implements Runnable {

    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final RunnableC0691z f4155h;
    public static final long i;

    static {
        Long l6;
        RunnableC0691z runnableC0691z = new RunnableC0691z();
        f4155h = runnableC0691z;
        runnableC0691z.c(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l6 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l6 = 1000L;
        }
        i = timeUnit.toNanos(l6.longValue());
    }

    @Override // m3.Q
    public final Thread f() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // m3.Q
    public final void g(long j6, N n6) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // m3.P
    public final void h(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.h(runnable);
    }

    @Override // m3.P, kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j6, Runnable runnable, CoroutineContext coroutineContext) {
        long j7 = j6 > 0 ? j6 >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j6 : 0L;
        if (j7 >= 4611686018427387903L) {
            return r0.f4144a;
        }
        long jNanoTime = System.nanoTime();
        M m6 = new M(j7 + jNanoTime, runnable);
        k(jNanoTime, m6);
        return m6;
    }

    public final synchronized void l() {
        int i3 = debugStatus;
        if (i3 == 2 || i3 == 3) {
            debugStatus = 3;
            P.e.set(this, null);
            P.f4111f.set(this, null);
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zJ;
        u0.f4146a.set(this);
        try {
            synchronized (this) {
                int i3 = debugStatus;
                if (i3 == 2 || i3 == 3) {
                    if (zJ) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j6 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jD = d();
                    if (jD == LocationRequestCompat.PASSIVE_INTERVAL) {
                        long jNanoTime = System.nanoTime();
                        if (j6 == LocationRequestCompat.PASSIVE_INTERVAL) {
                            j6 = i + jNanoTime;
                        }
                        long j7 = j6 - jNanoTime;
                        if (j7 <= 0) {
                            _thread = null;
                            l();
                            if (j()) {
                                return;
                            }
                            f();
                            return;
                        }
                        if (jD > j7) {
                            jD = j7;
                        }
                    } else {
                        j6 = Long.MAX_VALUE;
                    }
                    if (jD > 0) {
                        int i4 = debugStatus;
                        if (i4 == 2 || i4 == 3) {
                            _thread = null;
                            l();
                            if (j()) {
                                return;
                            }
                            f();
                            return;
                        }
                        LockSupport.parkNanos(this, jD);
                    }
                }
            }
        } finally {
            _thread = null;
            l();
            if (!j()) {
                f();
            }
        }
    }

    @Override // m3.P, m3.K
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
