package m3;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes2.dex */
public class B extends AbstractC0665a implements Deferred {
    @Override // kotlinx.coroutines.Deferred
    public final Object await(Continuation continuation) throws Throwable {
        Object objP;
        do {
            objP = p();
            if (!(objP instanceof Incomplete)) {
                if (objP instanceof C0677k) {
                    throw ((C0677k) objP).f4133a;
                }
                return AbstractC0690y.l(objP);
            }
        } while (B(objP) < 0);
        f0 f0Var = new f0(C5.f.J(continuation), this);
        f0Var.initCancellability();
        f0Var.invokeOnCancellation(new C0671e(invokeOnCompletion(false, true, new I(f0Var, 2)), 1));
        return f0Var.m();
    }

    @Override // kotlinx.coroutines.Deferred
    public final Object getCompleted() throws Throwable {
        Object objP = p();
        if (objP instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (objP instanceof C0677k) {
            throw ((C0677k) objP).f4133a;
        }
        return AbstractC0690y.l(objP);
    }

    @Override // kotlinx.coroutines.Deferred
    public final SelectClause1 getOnAwait() {
        l0 l0Var = l0.f4135a;
        kotlin.jvm.internal.z.d(3, l0Var);
        m0 m0Var = m0.f4137a;
        kotlin.jvm.internal.z.d(3, m0Var);
        return new B2.d(this, l0Var, m0Var, (o3.k) null);
    }
}
