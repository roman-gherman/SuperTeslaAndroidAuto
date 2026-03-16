package K1;

import io.ktor.utils.io.pool.ObjectPool;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements ObjectPool {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f933f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f934a;
    public final int b;
    public final int c;
    public final AtomicReferenceArray d;
    public final int[] e;
    private volatile long top;

    static {
        AtomicLongFieldUpdater atomicLongFieldUpdaterNewUpdater = AtomicLongFieldUpdater.newUpdater(e.class, d.f932a.getName());
        h.e(atomicLongFieldUpdaterNewUpdater, "newUpdater(Owner::class.java, p.name)");
        f933f = atomicLongFieldUpdaterNewUpdater;
    }

    public e(int i) {
        this.f934a = i;
        if (i <= 0) {
            throw new IllegalArgumentException(B2.b.c(i, "capacity should be positive but it is ").toString());
        }
        if (i > 536870911) {
            throw new IllegalArgumentException(B2.b.c(i, "capacity should be less or equal to 536870911 but it is ").toString());
        }
        int iHighestOneBit = Integer.highestOneBit((i * 4) - 1) * 2;
        this.b = iHighestOneBit;
        this.c = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
        this.d = new AtomicReferenceArray(iHighestOneBit + 1);
        this.e = new int[iHighestOneBit + 1];
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final Object borrow() {
        Object objF = f();
        return objF != null ? c(objF) : e();
    }

    public Object c(Object obj) {
        return obj;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        dispose();
    }

    public void d(Object obj) {
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
        while (true) {
            Object objF = f();
            if (objF == null) {
                return;
            } else {
                d(objF);
            }
        }
    }

    public abstract Object e();

    public final Object f() {
        long j6;
        int i;
        e eVar;
        long j7;
        do {
            j6 = this.top;
            if (j6 != 0) {
                j7 = ((j6 >> 32) & 4294967295L) + 1;
                i = (int) (4294967295L & j6);
                if (i != 0) {
                    eVar = this;
                }
            }
            i = 0;
            eVar = this;
            break;
        } while (!f933f.compareAndSet(eVar, j6, (j7 << 32) | ((long) this.e[i])));
        if (i == 0) {
            return null;
        }
        return eVar.d.getAndSet(i, null);
    }

    public void g(Object obj) {
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final int getCapacity() {
        return this.f934a;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(Object instance) {
        long j6;
        long j7;
        h.f(instance, "instance");
        g(instance);
        int iIdentityHashCode = ((System.identityHashCode(instance) * (-1640531527)) >>> this.c) + 1;
        for (int i = 0; i < 8; i++) {
            AtomicReferenceArray atomicReferenceArray = this.d;
            while (!atomicReferenceArray.compareAndSet(iIdentityHashCode, null, instance)) {
                if (atomicReferenceArray.get(iIdentityHashCode) != null) {
                    iIdentityHashCode--;
                    if (iIdentityHashCode == 0) {
                        iIdentityHashCode = this.b;
                    }
                }
            }
            if (iIdentityHashCode <= 0) {
                throw new IllegalArgumentException("index should be positive");
            }
            do {
                j6 = this.top;
                j7 = ((((j6 >> 32) & 4294967295L) + 1) << 32) | ((long) iIdentityHashCode);
                this.e[iIdentityHashCode] = (int) (4294967295L & j6);
            } while (!f933f.compareAndSet(this, j6, j7));
            return;
        }
        d(instance);
    }
}
