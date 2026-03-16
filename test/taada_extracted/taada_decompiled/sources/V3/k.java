package v3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Semaphore;
import org.jetbrains.annotations.Nullable;
import r3.AbstractC0800a;
import r3.u;
import t2.q;

/* JADX INFO: loaded from: classes2.dex */
public class k implements Semaphore {
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "head");
    public static final AtomicLongFieldUpdater c = AtomicLongFieldUpdater.newUpdater(k.class, "deqIdx");
    public static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "tail");
    public static final AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(k.class, "enqIdx");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f4950f = AtomicIntegerFieldUpdater.newUpdater(k.class, "_availablePermits");

    @Volatile
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f4951a;

    @Volatile
    private volatile long deqIdx;

    @Volatile
    private volatile long enqIdx;

    @Volatile
    @Nullable
    private volatile Object head;

    @Volatile
    @Nullable
    private volatile Object tail;

    public k() {
        m mVar = new m(0L, null, 2);
        this.head = mVar;
        this.tail = mVar;
        this._availablePermits = 1;
        this.f4951a = new q(this, 2);
    }

    public final boolean a(Waiter waiter) {
        Object objB;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
        m mVar = (m) atomicReferenceFieldUpdater.get(this);
        long andIncrement = e.getAndIncrement(this);
        i iVar = i.f4948a;
        long j6 = andIncrement / ((long) l.f4953f);
        loop0: while (true) {
            objB = AbstractC0800a.b(mVar, j6, iVar);
            if (!AbstractC0800a.e(objB)) {
                u uVarC = AbstractC0800a.c(objB);
                while (true) {
                    u uVar = (u) atomicReferenceFieldUpdater.get(this);
                    if (uVar.c >= uVarC.c) {
                        break loop0;
                    }
                    if (!uVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, uVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != uVar) {
                            if (uVarC.e()) {
                                uVarC.d();
                            }
                        }
                    }
                    if (uVar.e()) {
                        uVar.d();
                    }
                }
            } else {
                break;
            }
        }
        m mVar2 = (m) AbstractC0800a.c(objB);
        int i = (int) (andIncrement % ((long) l.f4953f));
        AtomicReferenceArray atomicReferenceArray = mVar2.e;
        while (!atomicReferenceArray.compareAndSet(i, null, waiter)) {
            if (atomicReferenceArray.get(i) != null) {
                E1.h hVar = l.b;
                E1.h hVar2 = l.c;
                while (!atomicReferenceArray.compareAndSet(i, hVar, hVar2)) {
                    if (atomicReferenceArray.get(i) != hVar) {
                        return false;
                    }
                }
                boolean z6 = waiter instanceof CancellableContinuation;
                N1.m mVar3 = N1.m.f1129a;
                if (z6) {
                    ((CancellableContinuation) waiter).resume(mVar3, this.f4951a);
                    return true;
                }
                if (waiter instanceof SelectInstance) {
                    ((SelectInstance) waiter).selectInRegistrationPhase(mVar3);
                    return true;
                }
                throw new IllegalStateException(("unexpected: " + waiter).toString());
            }
        }
        waiter.invokeOnCancellation(mVar2, i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        r5.resume(r3, r4.f4951a);
     */
    @Override // kotlinx.coroutines.sync.Semaphore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object acquire(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
        L0:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = v3.k.f4950f
            int r1 = r0.getAndDecrement(r4)
            r2 = 1
            if (r1 > r2) goto L0
            N1.m r3 = N1.m.f1129a
            if (r1 <= 0) goto Le
            goto L40
        Le:
            kotlin.coroutines.Continuation r5 = C5.f.J(r5)
            m3.f r5 = m3.AbstractC0690y.f(r5)
            boolean r1 = r4.a(r5)     // Catch: java.lang.Throwable -> L31
            if (r1 != 0) goto L33
        L1c:
            int r1 = r0.getAndDecrement(r4)     // Catch: java.lang.Throwable -> L31
            if (r1 > r2) goto L1c
            if (r1 <= 0) goto L2a
            t2.q r0 = r4.f4951a     // Catch: java.lang.Throwable -> L31
            r5.resume(r3, r0)     // Catch: java.lang.Throwable -> L31
            goto L33
        L2a:
            boolean r1 = r4.a(r5)     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L1c
            goto L33
        L31:
            r0 = move-exception
            goto L41
        L33:
            java.lang.Object r5 = r5.m()
            T1.a r0 = T1.a.f1304a
            if (r5 != r0) goto L3c
            goto L3d
        L3c:
            r5 = r3
        L3d:
            if (r5 != r0) goto L40
            return r5
        L40:
            return r3
        L41:
            r5.s()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.k.acquire(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public final int getAvailablePermits() {
        return Math.max(f4950f.get(this), 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    @Override // kotlinx.coroutines.sync.Semaphore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void release() {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.k.release():void");
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public final boolean tryAcquire() {
        int i;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4950f;
            int i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 > 1) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i > 1) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 1));
            } else {
                if (i3 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i3, i3 - 1)) {
                    return true;
                }
            }
        }
    }
}
