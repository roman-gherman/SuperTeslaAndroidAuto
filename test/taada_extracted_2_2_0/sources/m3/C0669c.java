package m3;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: renamed from: m3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0669c extends AbstractC0665a {
    public final Thread d;
    public final K e;

    public C0669c(CoroutineContext coroutineContext, Thread thread, K k6) {
        super(coroutineContext, true);
        this.d = thread;
        this.e = k6;
    }

    @Override // m3.o0
    public final void b(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.d;
        if (kotlin.jvm.internal.h.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
