package r3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: r3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0801b extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4701a = AtomicReferenceFieldUpdater.newUpdater(AbstractC0801b.class, Object.class, "_consensus");

    @Volatile
    @Nullable
    private volatile Object _consensus = AbstractC0800a.f4700a;

    @Override // r3.q
    public final Object a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4701a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        E1.h hVar = AbstractC0800a.f4700a;
        if (obj2 == hVar) {
            E1.h hVarC = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == hVar) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, hVar, hVarC)) {
                        obj2 = hVarC;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != hVar) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                        break;
                    }
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract E1.h c(Object obj);
}
