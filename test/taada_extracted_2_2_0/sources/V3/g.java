package v3;

import C0.t;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.sync.Mutex;
import m3.AbstractC0690y;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends k implements Mutex {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4946h = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "owner");

    @Volatile
    @Nullable
    private volatile Object owner = h.f4948a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f4947g = new f(this);

    @Override // kotlinx.coroutines.sync.Mutex
    public final SelectClause2 getOnLock() {
        C0857d c0857d = C0857d.f4943a;
        z.d(3, c0857d);
        e eVar = e.f4944a;
        z.d(3, eVar);
        return new t(this, c0857d, eVar, this.f4947g);
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final boolean holdsLock(Object obj) {
        while (isLocked()) {
            Object obj2 = f4946h.get(this);
            if (obj2 != h.f4948a) {
                return obj2 == obj;
            }
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final boolean isLocked() {
        return getAvailablePermits() == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        r0.resume(r1, r3.f4952a);
     */
    @Override // kotlinx.coroutines.sync.Mutex
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object lock(java.lang.Object r4, kotlin.coroutines.Continuation r5) {
        /*
            r3 = this;
            boolean r0 = r3.tryLock(r4)
            N1.m r1 = N1.m.f1129a
            if (r0 == 0) goto L9
            goto L3a
        L9:
            kotlin.coroutines.Continuation r5 = C5.f.J(r5)
            m3.f r5 = m3.AbstractC0690y.f(r5)
            v3.b r0 = new v3.b     // Catch: java.lang.Throwable -> L3b
            r0.<init>(r3, r5, r4)     // Catch: java.lang.Throwable -> L3b
        L16:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = v3.k.f4951f     // Catch: java.lang.Throwable -> L3b
            int r4 = r4.getAndDecrement(r3)     // Catch: java.lang.Throwable -> L3b
            r2 = 1
            if (r4 > r2) goto L16
            if (r4 <= 0) goto L27
            t2.q r4 = r3.f4952a     // Catch: java.lang.Throwable -> L3b
            r0.resume(r1, r4)     // Catch: java.lang.Throwable -> L3b
            goto L2d
        L27:
            boolean r4 = r3.a(r0)     // Catch: java.lang.Throwable -> L3b
            if (r4 == 0) goto L16
        L2d:
            java.lang.Object r4 = r5.m()
            T1.a r5 = T1.a.f1304a
            if (r4 != r5) goto L36
            goto L37
        L36:
            r4 = r1
        L37:
            if (r4 != r5) goto L3a
            return r4
        L3a:
            return r1
        L3b:
            r4 = move-exception
            r5.s()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.g.lock(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String toString() {
        return "Mutex@" + AbstractC0690y.e(this) + "[isLocked=" + isLocked() + ",owner=" + f4946h.get(this) + ']';
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final boolean tryLock(Object obj) {
        char c;
        do {
            if (tryAcquire()) {
                f4946h.set(this, obj);
                c = 0;
                break;
            }
            if (obj == null) {
                break;
            }
            if (holdsLock(obj)) {
                c = 2;
                break;
            }
        } while (!isLocked());
        c = 1;
        if (c == 0) {
            return true;
        }
        if (c == 1) {
            return false;
        }
        if (c != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final void unlock(Object obj) {
        while (isLocked()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4946h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            E1.h hVar = h.f4948a;
            if (obj2 != hVar) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, hVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    release();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }
}
