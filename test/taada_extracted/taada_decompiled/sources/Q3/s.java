package q3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.flow.FlowCollector;
import m3.AbstractC0690y;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends U1.c implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowCollector f4668a;
    public final CoroutineContext b;
    public final int c;
    public CoroutineContext d;
    public Continuation e;

    public s(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        super(q.f4666a, S1.g.f1282a);
        this.f4668a = flowCollector;
        this.b = coroutineContext;
        this.c = ((Number) coroutineContext.fold(0, r.f4667a)).intValue();
    }

    public final Object a(Continuation continuation, Object obj) {
        CoroutineContext context = continuation.getContext();
        AbstractC0690y.d(context);
        CoroutineContext coroutineContext = this.d;
        if (coroutineContext != context) {
            if (coroutineContext instanceof o) {
                throw new IllegalStateException(kotlin.text.k.t("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((o) coroutineContext).f4665a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) context.fold(0, new v(this))).intValue() != this.c) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.b + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.d = context;
        }
        this.e = continuation;
        t tVar = u.f4670a;
        FlowCollector flowCollector = this.f4668a;
        kotlin.jvm.internal.h.d(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        tVar.getClass();
        Object objEmit = flowCollector.emit(obj, this);
        if (!kotlin.jvm.internal.h.a(objEmit, T1.a.f1304a)) {
            this.e = null;
        }
        return objEmit;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        try {
            Object objA = a(continuation, obj);
            return objA == T1.a.f1304a ? objA : N1.m.f1129a;
        } catch (Throwable th) {
            this.d = new o(continuation.getContext(), th);
            throw th;
        }
    }

    @Override // U1.a, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // U1.c, kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.d;
        return coroutineContext == null ? S1.g.f1282a : coroutineContext;
    }

    @Override // U1.a, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        Throwable thA = N1.h.a(obj);
        if (thA != null) {
            this.d = new o(getContext(), thA);
        }
        Continuation continuation = this.e;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return T1.a.f1304a;
    }
}
