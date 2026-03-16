package m3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;
import r3.AbstractC0800a;

/* JADX INFO: loaded from: classes2.dex */
public final class E extends r3.t {
    public static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(E.class, "_decision");

    @Volatile
    private volatile int _decision;

    @Override // r3.t, m3.o0
    public final void b(Object obj) {
        c(obj);
    }

    @Override // r3.t, m3.o0
    public final void c(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = e;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                AbstractC0800a.g(AbstractC0690y.h(obj), C5.f.J(this.d));
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
