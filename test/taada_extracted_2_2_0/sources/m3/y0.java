package m3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import r3.AbstractC0797A;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 extends r3.t {
    public final ThreadLocal e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public y0(Continuation continuation, CoroutineContext coroutineContext) {
        z0 z0Var = z0.f4156a;
        super(continuation, coroutineContext.get(z0Var) == null ? coroutineContext.plus(z0Var) : coroutineContext);
        this.e = new ThreadLocal();
        if (continuation.getContext().get(ContinuationInterceptor.Key) instanceof AbstractC0684s) {
            return;
        }
        Object objC = AbstractC0797A.c(coroutineContext, null);
        AbstractC0797A.a(coroutineContext, objC);
        J(coroutineContext, objC);
    }

    public final boolean I() {
        boolean z6 = this.threadLocalIsSet && this.e.get() == null;
        this.e.remove();
        return !z6;
    }

    public final void J(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.e.set(new N1.e(coroutineContext, obj));
    }

    @Override // r3.t, m3.o0
    public final void c(Object obj) {
        if (this.threadLocalIsSet) {
            N1.e eVar = (N1.e) this.e.get();
            if (eVar != null) {
                AbstractC0797A.a((CoroutineContext) eVar.f1121a, eVar.b);
            }
            this.e.remove();
        }
        Object objH = AbstractC0690y.h(obj);
        Continuation continuation = this.d;
        CoroutineContext context = continuation.getContext();
        Object objC = AbstractC0797A.c(context, null);
        y0 y0VarC = objC != AbstractC0797A.f4696a ? AbstractC0682p.c(continuation, context, objC) : null;
        try {
            this.d.resumeWith(objH);
            if (y0VarC == null || y0VarC.I()) {
                AbstractC0797A.a(context, objC);
            }
        } catch (Throwable th) {
            if (y0VarC == null || y0VarC.I()) {
                AbstractC0797A.a(context, objC);
            }
            throw th;
        }
    }
}
