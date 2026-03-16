package N1;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Lazy, Serializable {
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile kotlin.jvm.internal.i f1125a;
    public volatile Object b;

    private final Object writeReplace() {
        return new b(getValue());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.i] */
    @Override // kotlin.Lazy
    public final Object getValue() {
        Object obj = this.b;
        l lVar = l.f1128a;
        if (obj != lVar) {
            return obj;
        }
        ?? r02 = this.f1125a;
        if (r02 != 0) {
            Object objInvoke = r02.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, lVar, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(this) != lVar) {
                }
            }
            this.f1125a = null;
            return objInvoke;
        }
        return this.b;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        return this.b != l.f1128a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
