package r3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: r3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0803d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4703a = AtomicReferenceFieldUpdater.newUpdater(AbstractC0803d.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(AbstractC0803d.class, Object.class, "_prev");

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    @Nullable
    private volatile Object _prev;

    public AbstractC0803d(u uVar) {
        this._prev = uVar;
    }

    public final void a() {
        b.lazySet(this, null);
    }

    public final AbstractC0803d b() {
        Object obj = f4703a.get(this);
        if (obj == AbstractC0800a.b) {
            return null;
        }
        return (AbstractC0803d) obj;
    }

    public abstract boolean c();

    public final void d() {
        AbstractC0803d abstractC0803dB;
        if (b() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            AbstractC0803d abstractC0803d = (AbstractC0803d) atomicReferenceFieldUpdater.get(this);
            while (abstractC0803d != null && abstractC0803d.c()) {
                abstractC0803d = (AbstractC0803d) atomicReferenceFieldUpdater.get(abstractC0803d);
            }
            AbstractC0803d abstractC0803dB2 = b();
            kotlin.jvm.internal.h.c(abstractC0803dB2);
            while (abstractC0803dB2.c() && (abstractC0803dB = abstractC0803dB2.b()) != null) {
                abstractC0803dB2 = abstractC0803dB;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(abstractC0803dB2);
                AbstractC0803d abstractC0803d2 = ((AbstractC0803d) obj) == null ? null : abstractC0803d;
                while (!atomicReferenceFieldUpdater.compareAndSet(abstractC0803dB2, obj, abstractC0803d2)) {
                    if (atomicReferenceFieldUpdater.get(abstractC0803dB2) != obj) {
                        break;
                    }
                }
            }
            if (abstractC0803d != null) {
                f4703a.set(abstractC0803d, abstractC0803dB2);
            }
            if (!abstractC0803dB2.c() || abstractC0803dB2.b() == null) {
                if (abstractC0803d == null || !abstractC0803d.c()) {
                    return;
                }
            }
        }
    }
}
