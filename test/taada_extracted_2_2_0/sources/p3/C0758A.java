package p3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;
import q3.AbstractC0785b;
import q3.AbstractC0786c;
import q3.AbstractC0787d;

/* JADX INFO: renamed from: p3.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0758A extends AbstractC0787d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4474a = AtomicReferenceFieldUpdater.newUpdater(C0758A.class, Object.class, "_state");

    @Volatile
    @Nullable
    private volatile Object _state;

    @Override // q3.AbstractC0787d
    public final boolean a(AbstractC0785b abstractC0785b) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4474a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, v.b);
        return true;
    }

    @Override // q3.AbstractC0787d
    public final Continuation[] b(AbstractC0785b abstractC0785b) {
        f4474a.set(this, null);
        return AbstractC0786c.f4653a;
    }
}
