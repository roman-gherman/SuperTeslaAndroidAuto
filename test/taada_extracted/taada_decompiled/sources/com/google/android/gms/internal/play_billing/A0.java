package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public final class A0 extends AtomicReference implements Runnable {
    public static final RunnableC0312r0 c = new RunnableC0312r0();
    public static final RunnableC0312r0 d = new RunnableC0312r0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f2019a;
    public final /* synthetic */ B0 b;

    public A0(B0 b02, Callable callable) {
        this.b = b02;
        callable.getClass();
        this.f2019a = callable;
    }

    public final void a(Thread thread) {
        Runnable runnable = (Runnable) get();
        RunnableC0310q0 runnableC0310q0 = null;
        boolean z6 = false;
        int i = 0;
        while (true) {
            boolean z7 = runnable instanceof RunnableC0310q0;
            RunnableC0312r0 runnableC0312r0 = d;
            if (!z7) {
                if (runnable != runnableC0312r0) {
                    break;
                }
            } else {
                runnableC0310q0 = (RunnableC0310q0) runnable;
            }
            i++;
            if (i <= 1000) {
                Thread.yield();
            } else if (runnable == runnableC0312r0 || compareAndSet(runnable, runnableC0312r0)) {
                z6 = Thread.interrupted() || z6;
                LockSupport.park(runnableC0310q0);
            }
            runnable = (Runnable) get();
        }
        if (z6) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        Thread threadCurrentThread = Thread.currentThread();
        if (compareAndSet(null, threadCurrentThread)) {
            B0 b02 = this.b;
            boolean zIsDone = b02.isDone();
            RunnableC0312r0 runnableC0312r0 = c;
            if (zIsDone) {
                objCall = null;
            } else {
                try {
                    objCall = this.f2019a.call();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(threadCurrentThread, runnableC0312r0)) {
                            a(threadCurrentThread);
                        }
                        b02.c(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(threadCurrentThread, runnableC0312r0)) {
                            a(threadCurrentThread);
                        }
                        b02.getClass();
                        if (AbstractC0286i0.f2081f.C(b02, null, AbstractC0286i0.f2082g)) {
                            AbstractC0286i0.g(b02);
                        }
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, runnableC0312r0)) {
                a(threadCurrentThread);
            }
            if (zIsDone) {
                return;
            }
            b02.getClass();
            if (objCall == null) {
                objCall = AbstractC0286i0.f2082g;
            }
            if (AbstractC0286i0.f2081f.C(b02, null, objCall)) {
                AbstractC0286i0.g(b02);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        Runnable runnable = (Runnable) get();
        return B2.b.f(runnable == c ? "running=[DONE]" : runnable instanceof RunnableC0310q0 ? "running=[INTERRUPTED]" : runnable instanceof Thread ? androidx.constraintlayout.core.motion.a.q("running=[RUNNING ON ", ((Thread) runnable).getName(), "]") : "running=[NOT STARTED YET]", ", ", this.f2019a.toString());
    }
}
