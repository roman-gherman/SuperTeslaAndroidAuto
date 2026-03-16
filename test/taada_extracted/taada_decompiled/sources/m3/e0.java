package m3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 extends r3.k implements DisposableHandle, Incomplete, Function1 {
    public o0 d;

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        o0 o0VarF = f();
        while (true) {
            Object objP = o0VarF.p();
            if (objP instanceof e0) {
                if (objP != this) {
                    return;
                }
                J j6 = AbstractC0690y.f4153j;
                do {
                    atomicReferenceFieldUpdater2 = o0.f4141a;
                    if (atomicReferenceFieldUpdater2.compareAndSet(o0VarF, objP, j6)) {
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(o0VarF) == objP);
            } else {
                if (!(objP instanceof Incomplete) || ((Incomplete) objP).getList() == null) {
                    return;
                }
                while (true) {
                    Object objC = c();
                    if (objC instanceof r3.r) {
                        r3.k kVar = ((r3.r) objC).f4719a;
                        return;
                    }
                    if (objC == this) {
                        return;
                    }
                    kotlin.jvm.internal.h.d(objC, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                    r3.k kVar2 = (r3.k) objC;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = r3.k.c;
                    r3.r rVar = (r3.r) atomicReferenceFieldUpdater3.get(kVar2);
                    if (rVar == null) {
                        rVar = new r3.r(kVar2);
                        atomicReferenceFieldUpdater3.lazySet(kVar2, rVar);
                    }
                    do {
                        atomicReferenceFieldUpdater = r3.k.f4712a;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, objC, rVar)) {
                            kVar2.a();
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == objC);
                }
            }
        }
    }

    public final o0 f() {
        o0 o0Var = this.d;
        if (o0Var != null) {
            return o0Var;
        }
        kotlin.jvm.internal.h.n("job");
        throw null;
    }

    public abstract void g(Throwable th);

    @Override // kotlinx.coroutines.Incomplete
    public final q0 getList() {
        return null;
    }

    public Job getParent() {
        return f();
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return true;
    }

    @Override // r3.k
    public final String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0690y.e(this) + "[job@" + AbstractC0690y.e(f()) + ']';
    }
}
