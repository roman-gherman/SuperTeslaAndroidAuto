package E1;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends f {
    public final List b;
    public final CoroutineContext c;
    public Object d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Object context, List interceptors, Object subject, CoroutineContext coroutineContext) {
        super(context);
        kotlin.jvm.internal.h.f(context, "context");
        kotlin.jvm.internal.h.f(interceptors, "interceptors");
        kotlin.jvm.internal.h.f(subject, "subject");
        this.b = interceptors;
        this.c = coroutineContext;
        this.d = subject;
    }

    @Override // E1.f
    public final Object a(Object obj, U1.c cVar) {
        this.e = 0;
        kotlin.jvm.internal.h.f(obj, "<set-?>");
        this.d = obj;
        return c(cVar);
    }

    @Override // E1.f
    public final Object b() {
        return this.d;
    }

    @Override // E1.f
    public final Object c(Continuation continuation) {
        int i = this.e;
        if (i < 0) {
            return this.d;
        }
        if (i < this.b.size()) {
            return e(continuation);
        }
        this.e = -1;
        return this.d;
    }

    @Override // E1.f
    public final Object d(Object obj, Continuation continuation) {
        kotlin.jvm.internal.h.f(obj, "<set-?>");
        this.d = obj;
        return c(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof E1.a
            if (r0 == 0) goto L13
            r0 = r8
            E1.a r0 = (E1.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            E1.a r0 = new E1.a
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            E1.b r2 = r0.f285a
            kotlin.reflect.l.e0(r8)
            goto L35
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L31:
            kotlin.reflect.l.e0(r8)
            r2 = r7
        L35:
            int r8 = r2.e
            r4 = -1
            if (r8 != r4) goto L3b
            goto L45
        L3b:
            java.util.List r5 = r2.b
            int r6 = r5.size()
            if (r8 < r6) goto L48
            r2.e = r4
        L45:
            java.lang.Object r8 = r2.d
            return r8
        L48:
            java.lang.Object r4 = r5.get(r8)
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            int r8 = r8 + 1
            r2.e = r8
            java.lang.String r8 = "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext>, TSubject of io.ktor.util.pipeline.DebugPipelineContext, kotlin.Unit>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptor<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext> }"
            kotlin.jvm.internal.h.d(r4, r8)
            java.lang.Object r8 = r2.d
            r0.f285a = r2
            r0.d = r3
            java.lang.Object r8 = r4.invoke(r2, r8, r0)
            if (r8 != r1) goto L35
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: E1.b.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.c;
    }
}
