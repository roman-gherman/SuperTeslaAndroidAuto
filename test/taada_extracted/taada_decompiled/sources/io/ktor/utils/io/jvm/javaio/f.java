package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Parking {
    public static final f b = new f(0);
    public static final f c = new f(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3600a;

    public /* synthetic */ f(int i) {
        this.f3600a = i;
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final void park(long j6) {
        switch (this.f3600a) {
            case 0:
                if (j6 < 0) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                LockSupport.parkNanos(j6);
                return;
            default:
                throw new UnsupportedOperationException("Parking is prohibited on this thread. Most likely you are using blocking operation on the wrong thread/dispatcher that doesn't allow blocking. Consider wrapping you blocking code withContext(Dispatchers.IO) {...}.");
        }
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final Object token() {
        switch (this.f3600a) {
            case 0:
                Thread threadCurrentThread = Thread.currentThread();
                kotlin.jvm.internal.h.e(threadCurrentThread, "currentThread()");
                return threadCurrentThread;
            default:
                throw new UnsupportedOperationException("Parking is prohibited on this thread. Most likely you are using blocking operation on the wrong thread/dispatcher that doesn't allow blocking. Consider wrapping you blocking code withContext(Dispatchers.IO) {...}.");
        }
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final void unpark(Object obj) {
        switch (this.f3600a) {
            case 0:
                Thread token = (Thread) obj;
                kotlin.jvm.internal.h.f(token, "token");
                LockSupport.unpark(token);
                break;
            default:
                Thread token2 = (Thread) obj;
                kotlin.jvm.internal.h.f(token2, "token");
                LockSupport.unpark(token2);
                break;
        }
    }
}
