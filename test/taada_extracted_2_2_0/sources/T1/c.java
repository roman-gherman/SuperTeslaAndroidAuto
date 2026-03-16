package T1;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.z;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1306a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ Continuation c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Continuation continuation, CoroutineContext coroutineContext, Function2 function2, Continuation continuation2) {
        super(continuation, coroutineContext);
        this.b = function2;
        this.c = continuation2;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1306a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f1306a = 2;
            l.e0(obj);
            return obj;
        }
        this.f1306a = 1;
        l.e0(obj);
        Function2 function2 = this.b;
        h.d(function2, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        z.d(2, function2);
        return function2.mo5invoke(this.c, this);
    }
}
