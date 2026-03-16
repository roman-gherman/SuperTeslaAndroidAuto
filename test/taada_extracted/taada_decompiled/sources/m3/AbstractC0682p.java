package m3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: m3.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0682p {
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z6) {
        Boolean bool = Boolean.FALSE;
        C0681o c0681o = C0681o.f4140a;
        boolean zBooleanValue = ((Boolean) coroutineContext.fold(bool, c0681o)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) coroutineContext2.fold(bool, c0681o)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return coroutineContext.plus(coroutineContext2);
        }
        kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
        vVar.f3816a = coroutineContext2;
        S1.g gVar = S1.g.f1282a;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(gVar, new C0680n(vVar, z6));
        if (zBooleanValue2) {
            vVar.f3816a = ((CoroutineContext) vVar.f3816a).fold(gVar, C0679m.f4136a);
        }
        return coroutineContext3.plus((CoroutineContext) vVar.f3816a);
    }

    public static final CoroutineContext b(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextA = a(coroutineScope.getCoroutineContext(), coroutineContext, true);
        t3.d dVar = G.f4104a;
        return (coroutineContextA == dVar || coroutineContextA.get(ContinuationInterceptor.Key) != null) ? coroutineContextA : coroutineContextA.plus(dVar);
    }

    public static final y0 c(Continuation continuation, CoroutineContext coroutineContext, Object obj) {
        y0 y0Var = null;
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (coroutineContext.get(z0.f4155a) != null) {
            CoroutineStackFrame callerFrame = (CoroutineStackFrame) continuation;
            while (true) {
                if ((callerFrame instanceof E) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof y0) {
                    y0Var = (y0) callerFrame;
                    break;
                }
            }
            if (y0Var != null) {
                y0Var.J(coroutineContext, obj);
            }
        }
        return y0Var;
    }
}
