package q3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import m3.AbstractC0684s;
import o3.EnumC0743a;
import r3.AbstractC0797A;

/* JADX INFO: renamed from: q3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0786c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Continuation[] f4653a = new Continuation[0];
    public static final E1.h b = new E1.h("NULL", 9);
    public static final E1.h c = new E1.h("UNINITIALIZED", 9);

    public static /* synthetic */ Flow a(FusibleFlow fusibleFlow, AbstractC0684s abstractC0684s, int i, EnumC0743a enumC0743a, int i3) {
        CoroutineContext coroutineContext = abstractC0684s;
        if ((i3 & 1) != 0) {
            coroutineContext = S1.g.f1282a;
        }
        if ((i3 & 2) != 0) {
            i = -3;
        }
        if ((i3 & 4) != 0) {
            enumC0743a = EnumC0743a.f4321a;
        }
        return fusibleFlow.fuse(coroutineContext, i, enumC0743a);
    }

    public static final Object b(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation) {
        Object objC = AbstractC0797A.c(coroutineContext, obj2);
        try {
            x xVar = new x(continuation, coroutineContext);
            kotlin.jvm.internal.z.d(2, function2);
            Object objMo5invoke = function2.mo5invoke(obj, xVar);
            AbstractC0797A.a(coroutineContext, objC);
            if (objMo5invoke == T1.a.f1304a) {
                U1.d.a(continuation);
            }
            return objMo5invoke;
        } catch (Throwable th) {
            AbstractC0797A.a(coroutineContext, objC);
            throw th;
        }
    }
}
