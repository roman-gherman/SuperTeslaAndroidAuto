package m3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.Incomplete;
import r3.AbstractC0800a;
import r3.AbstractC0801b;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends AbstractC0801b {
    public final e0 b;
    public q0 c;
    public final /* synthetic */ o0 d;
    public final /* synthetic */ Incomplete e;

    public j0(e0 e0Var, o0 o0Var, Incomplete incomplete) {
        this.d = o0Var;
        this.e = incomplete;
        this.b = e0Var;
    }

    @Override // r3.AbstractC0801b
    public final void b(Object obj, Object obj2) {
        r3.k kVar = (r3.k) obj;
        boolean z6 = obj2 == null;
        e0 e0Var = this.b;
        Incomplete incomplete = z6 ? e0Var : this.c;
        if (incomplete != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = r3.k.f4712a;
            while (!atomicReferenceFieldUpdater.compareAndSet(kVar, this, incomplete)) {
                if (atomicReferenceFieldUpdater.get(kVar) != this) {
                    return;
                }
            }
            if (z6) {
                q0 q0Var = this.c;
                kotlin.jvm.internal.h.c(q0Var);
                e0Var.b(q0Var);
            }
        }
    }

    @Override // r3.AbstractC0801b
    public final E1.h c(Object obj) {
        if (this.d.p() == this.e) {
            return null;
        }
        return AbstractC0800a.e;
    }
}
