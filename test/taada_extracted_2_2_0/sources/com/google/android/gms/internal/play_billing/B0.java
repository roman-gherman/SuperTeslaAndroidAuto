package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public final class B0 extends AbstractC0301n0 implements RunnableFuture {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile A0 f2021h;

    public B0(Callable callable) {
        this.f2021h = new A0(this, callable);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0286i0
    public final String a() {
        A0 a02 = this.f2021h;
        return a02 != null ? androidx.constraintlayout.core.motion.a.q("task=[", a02.toString(), "]") : super.a();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0286i0
    public final void b() {
        A0 a02;
        Object obj = this.f2083a;
        if (((obj instanceof Z) && ((Z) obj).f2065a) && (a02 = this.f2021h) != null) {
            RunnableC0312r0 runnableC0312r0 = A0.d;
            RunnableC0312r0 runnableC0312r02 = A0.c;
            Runnable runnable = (Runnable) a02.get();
            if (runnable instanceof Thread) {
                RunnableC0310q0 runnableC0310q0 = new RunnableC0310q0(a02);
                runnableC0310q0.setExclusiveOwnerThread(Thread.currentThread());
                if (a02.compareAndSet(runnable, runnableC0310q0)) {
                    try {
                        Thread thread = (Thread) runnable;
                        thread.interrupt();
                        if (((Runnable) a02.getAndSet(runnableC0312r02)) == runnableC0312r0) {
                            LockSupport.unpark(thread);
                        }
                    } catch (Throwable th) {
                        if (((Runnable) a02.getAndSet(runnableC0312r02)) == runnableC0312r0) {
                            LockSupport.unpark((Thread) runnable);
                        }
                        throw th;
                    }
                }
            }
        }
        this.f2021h = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        A0 a02 = this.f2021h;
        if (a02 != null) {
            a02.run();
        }
        this.f2021h = null;
    }
}
