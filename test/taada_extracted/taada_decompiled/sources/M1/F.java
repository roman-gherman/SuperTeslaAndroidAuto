package m1;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import m3.t0;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class F extends U1.g implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4036a;
    public /* synthetic */ Object b;
    public final /* synthetic */ g1.f c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(g1.f fVar, Continuation continuation) {
        super(3, continuation);
        this.c = fVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        F f6 = new F(this.c, (Continuation) obj3);
        f6.b = (E1.f) obj;
        return f6.invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        CompletableJob completableJob;
        T1.a aVar = T1.a.f1304a;
        int i = this.f4036a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            completableJob = (CompletableJob) this.b;
            try {
                kotlin.reflect.l.e0(obj);
                completableJob.complete();
                return N1.m.f1129a;
            } catch (Throwable th) {
                th = th;
                try {
                    completableJob.completeExceptionally(th);
                    throw th;
                } catch (Throwable th2) {
                    completableJob.complete();
                    throw th2;
                }
            }
        }
        kotlin.reflect.l.e0(obj);
        E1.f fVar = (E1.f) this.b;
        t0 t0Var = new t0(((q1.c) fVar.f289a).e);
        g1.f fVar2 = this.c;
        CoroutineContext.Element element = fVar2.d.get(Job.Key);
        kotlin.jvm.internal.h.c(element);
        Logger logger = H.f4038a;
        t0Var.invokeOnCompletion(new j1.k(((Job) element).invokeOnCompletion(new j1.l(t0Var, 2)), 1));
        try {
            q1.c cVar = (q1.c) fVar.f289a;
            cVar.getClass();
            cVar.e = t0Var;
            this.b = t0Var;
            this.f4036a = 1;
            if (fVar.c(this) == aVar) {
                return aVar;
            }
            completableJob = t0Var;
            completableJob.complete();
            return N1.m.f1129a;
        } catch (Throwable th3) {
            th = th3;
            completableJob = t0Var;
            completableJob.completeExceptionally(th);
            throw th;
        }
    }
}
