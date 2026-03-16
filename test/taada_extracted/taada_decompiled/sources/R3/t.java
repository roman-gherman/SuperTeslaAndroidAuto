package r3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import m3.AbstractC0665a;
import m3.AbstractC0690y;

/* JADX INFO: loaded from: classes2.dex */
public class t extends AbstractC0665a implements CoroutineStackFrame {
    public final Continuation d;

    public t(Continuation continuation, CoroutineContext coroutineContext) {
        super(coroutineContext, true);
        this.d = continuation;
    }

    @Override // m3.o0
    public void b(Object obj) {
        AbstractC0800a.g(AbstractC0690y.h(obj), C5.f.J(this.d));
    }

    @Override // m3.o0
    public void c(Object obj) {
        this.d.resumeWith(AbstractC0690y.h(obj));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // m3.o0
    public final boolean t() {
        return true;
    }
}
