package r3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.NotCompleted;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends AbstractC0803d implements NotCompleted {
    public static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(u.class, "cleanedAndPointers");
    public final long c;

    @Volatile
    private volatile int cleanedAndPointers;

    public u(long j6, u uVar, int i) {
        super(uVar);
        this.c = j6;
        this.cleanedAndPointers = i << 16;
    }

    @Override // r3.AbstractC0803d
    public final boolean c() {
        return d.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return d.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i, CoroutineContext coroutineContext);

    public final void h() {
        if (d.incrementAndGet(this) == f()) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = d;
            i = atomicIntegerFieldUpdater.get(this);
            if (i == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
