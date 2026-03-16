package E1;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Continuation, CoroutineStackFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f294a = Integer.MIN_VALUE;
    public final /* synthetic */ n b;

    public m(n nVar) {
        this.b = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = l.f293a;
        int i = this.f294a;
        n nVar = this.b;
        if (i == Integer.MIN_VALUE) {
            this.f294a = nVar.f295f;
        }
        int i3 = this.f294a;
        if (i3 < 0) {
            this.f294a = Integer.MIN_VALUE;
            continuation = null;
        } else {
            try {
                Continuation continuation2 = nVar.e[i3];
                if (continuation2 != null) {
                    this.f294a = i3 - 1;
                    continuation = continuation2;
                }
            } catch (Throwable unused) {
            }
        }
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        CoroutineContext context;
        n nVar = this.b;
        Continuation continuation = nVar.e[nVar.f295f];
        if (continuation == null || (context = continuation.getContext()) == null) {
            throw new IllegalStateException("Not started");
        }
        return context;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        boolean z6 = obj instanceof N1.g;
        n nVar = this.b;
        if (!z6) {
            nVar.e(false);
            return;
        }
        Throwable thA = N1.h.a(obj);
        kotlin.jvm.internal.h.c(thA);
        nVar.f(kotlin.reflect.l.n(thA));
    }
}
