package r3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import m3.AbstractC0664A;
import m3.AbstractC0684s;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends AbstractC0684s implements Delay {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f4710f = AtomicIntegerFieldUpdater.newUpdater(i.class, "runningWorkers");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0684s f4711a;
    public final int b;
    public final /* synthetic */ Delay c;
    public final l d;
    public final Object e;

    @Volatile
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public i(AbstractC0684s abstractC0684s, int i) {
        this.f4711a = abstractC0684s;
        this.b = i;
        Delay delay = abstractC0684s instanceof Delay ? (Delay) abstractC0684s : null;
        this.c = delay == null ? AbstractC0664A.f4101a : delay;
        this.d = new l();
        this.e = new Object();
    }

    public final Runnable a() {
        while (true) {
            Runnable runnable = (Runnable) this.d.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.e) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4710f;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.d.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean b() {
        synchronized (this.e) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4710f;
            if (atomicIntegerFieldUpdater.get(this) >= this.b) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.Delay
    public final Object delay(long j6, Continuation continuation) {
        return this.c.delay(j6, continuation);
    }

    @Override // m3.AbstractC0684s
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableA;
        this.d.a(runnable);
        if (f4710f.get(this) >= this.b || !b() || (runnableA = a()) == null) {
            return;
        }
        this.f4711a.dispatch(this, new B.o(4, this, runnableA));
    }

    @Override // m3.AbstractC0684s
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableA;
        this.d.a(runnable);
        if (f4710f.get(this) >= this.b || !b() || (runnableA = a()) == null) {
            return;
        }
        this.f4711a.dispatchYield(this, new B.o(4, this, runnableA));
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j6, Runnable runnable, CoroutineContext coroutineContext) {
        return this.c.invokeOnTimeout(j6, runnable, coroutineContext);
    }

    @Override // m3.AbstractC0684s
    public final AbstractC0684s limitedParallelism(int i) {
        AbstractC0800a.a(i);
        return i >= this.b ? this : super.limitedParallelism(i);
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j6, CancellableContinuation cancellableContinuation) {
        this.c.scheduleResumeAfterDelay(j6, cancellableContinuation);
    }
}
