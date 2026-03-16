package m3;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class P extends Q implements Delay {
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(P.class, Object.class, "_queue");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4111f = AtomicReferenceFieldUpdater.newUpdater(P.class, Object.class, "_delayed");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f4112g = AtomicIntegerFieldUpdater.newUpdater(P.class, "_isCompleted");

    @Volatile
    @Nullable
    private volatile Object _delayed;

    @Volatile
    private volatile int _isCompleted = 0;

    @Volatile
    @Nullable
    private volatile Object _queue;

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005b, code lost:
    
        r7 = null;
     */
    @Override // m3.K
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long d() {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.P.d():long");
    }

    @Override // kotlinx.coroutines.Delay
    public final Object delay(long j6, Continuation continuation) {
        return AbstractC0690y.c(this, j6, continuation);
    }

    @Override // m3.AbstractC0684s
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        h(runnable);
    }

    public void h(Runnable runnable) {
        if (!i(runnable)) {
            RunnableC0691z.f4155h.h(runnable);
            return;
        }
        Thread threadF = f();
        if (Thread.currentThread() != threadF) {
            LockSupport.unpark(threadF);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(java.lang.Runnable r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = m3.P.e
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = m3.P.f4112g
            int r2 = r2.get(r6)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L12
            r2 = r4
            goto L13
        L12:
            r2 = r3
        L13:
            if (r2 == 0) goto L16
            goto L50
        L16:
            if (r1 != 0) goto L27
        L18:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L20
            goto L67
        L20:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L18
            goto L0
        L27:
            boolean r2 = r1 instanceof r3.n
            if (r2 == 0) goto L4c
            r2 = r1
            r3.n r2 = (r3.n) r2
            int r5 = r2.a(r7)
            if (r5 == 0) goto L67
            if (r5 == r4) goto L3a
            r0 = 2
            if (r5 == r0) goto L50
            goto L0
        L3a:
            r3.n r2 = r2.c()
        L3e:
            boolean r3 = r0.compareAndSet(r6, r1, r2)
            if (r3 == 0) goto L45
            goto L0
        L45:
            java.lang.Object r3 = r0.get(r6)
            if (r3 == r1) goto L3e
            goto L0
        L4c:
            E1.h r2 = m3.AbstractC0690y.c
            if (r1 != r2) goto L51
        L50:
            return r3
        L51:
            r3.n r2 = new r3.n
            r3 = 8
            r2.<init>(r3, r4)
            r3 = r1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.a(r3)
            r2.a(r7)
        L61:
            boolean r3 = r0.compareAndSet(r6, r1, r2)
            if (r3 == 0) goto L68
        L67:
            return r4
        L68:
            java.lang.Object r3 = r0.get(r6)
            if (r3 == r1) goto L61
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.P.i(java.lang.Runnable):boolean");
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long j6, Runnable runnable, CoroutineContext coroutineContext) {
        return AbstractC0664A.f4102a.invokeOnTimeout(j6, runnable, coroutineContext);
    }

    public final boolean j() {
        O o6;
        kotlin.collections.i iVar = this.c;
        if (!(iVar != null ? iVar.isEmpty() : true) || ((o6 = (O) f4111f.get(this)) != null && r3.D.b.get(o6) != 0)) {
            return false;
        }
        Object obj = e.get(this);
        if (obj != null) {
            if (obj instanceof r3.n) {
                long j6 = r3.n.f4716f.get((r3.n) obj);
                return ((int) (1073741823 & j6)) == ((int) ((j6 & 1152921503533105152L) >> 30));
            }
            if (obj != AbstractC0690y.c) {
                return false;
            }
        }
        return true;
    }

    public final void k(long j6, N n6) {
        int iA;
        Thread threadF;
        boolean z6 = f4112g.get(this) != 0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4111f;
        if (z6) {
            iA = 1;
        } else {
            O o6 = (O) atomicReferenceFieldUpdater.get(this);
            if (o6 == null) {
                O o7 = new O();
                o7.c = j6;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, o7) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                kotlin.jvm.internal.h.c(obj);
                o6 = (O) obj;
            }
            iA = n6.a(j6, o6, this);
        }
        if (iA != 0) {
            if (iA == 1) {
                g(j6, n6);
                return;
            } else {
                if (iA != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        O o8 = (O) atomicReferenceFieldUpdater.get(this);
        if (o8 != null) {
            synchronized (o8) {
                ThreadSafeHeapNode[] threadSafeHeapNodeArr = o8.f4699a;
                threadSafeHeapNode = threadSafeHeapNodeArr != null ? threadSafeHeapNodeArr[0] : null;
            }
            threadSafeHeapNode = (N) threadSafeHeapNode;
        }
        if (threadSafeHeapNode != n6 || Thread.currentThread() == (threadF = f())) {
            return;
        }
        LockSupport.unpark(threadF);
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j6, CancellableContinuation cancellableContinuation) {
        long j7 = j6 > 0 ? j6 >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j6 : 0L;
        if (j7 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            L l6 = new L(this, j7 + jNanoTime, cancellableContinuation);
            k(jNanoTime, l6);
            cancellableContinuation.invokeOnCancellation(new C0671e(l6, 1));
        }
    }

    @Override // m3.K
    public void shutdown() {
        ThreadSafeHeapNode threadSafeHeapNodeB;
        u0.f4146a.set(null);
        f4112g.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            Object obj = atomicReferenceFieldUpdater.get(this);
            E1.h hVar = AbstractC0690y.c;
            if (obj != null) {
                if (!(obj instanceof r3.n)) {
                    if (obj != hVar) {
                        r3.n nVar = new r3.n(8, true);
                        nVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((r3.n) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, hVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (d() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            O o6 = (O) f4111f.get(this);
            if (o6 == null) {
                return;
            }
            synchronized (o6) {
                threadSafeHeapNodeB = r3.D.b.get(o6) > 0 ? o6.b(0) : null;
            }
            N n6 = (N) threadSafeHeapNodeB;
            if (n6 == null) {
                return;
            } else {
                g(jNanoTime, n6);
            }
        }
    }
}
