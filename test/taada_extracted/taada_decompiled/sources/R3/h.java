package r3;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import m3.AbstractC0678l;
import m3.AbstractC0684s;
import m3.AbstractC0690y;
import m3.C0677k;
import m3.F;
import m3.K;
import m3.u0;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends F implements CoroutineStackFrame, Continuation {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4707h = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_reusableCancellableContinuation");

    @Volatile
    @Nullable
    private volatile Object _reusableCancellableContinuation;
    public final AbstractC0684s d;
    public final Continuation e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f4708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f4709g;

    public h(AbstractC0684s abstractC0684s, Continuation continuation) {
        super(-1);
        this.d = abstractC0684s;
        this.e = continuation;
        this.f4708f = AbstractC0800a.c;
        this.f4709g = AbstractC0797A.b(continuation.getContext());
    }

    @Override // m3.F
    public final void a(Object obj, CancellationException cancellationException) {
        if (obj instanceof AbstractC0678l) {
            ((AbstractC0678l) obj).getClass();
            throw null;
        }
    }

    @Override // m3.F
    public final Continuation b() {
        return this;
    }

    @Override // m3.F
    public final Object f() {
        Object obj = this.f4708f;
        this.f4708f = AbstractC0800a.c;
        return obj;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.e.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Continuation continuation = this.e;
        CoroutineContext context = continuation.getContext();
        Throwable thA = N1.h.a(obj);
        Object c0677k = thA == null ? obj : new C0677k(thA, false);
        AbstractC0684s abstractC0684s = this.d;
        if (abstractC0684s.isDispatchNeeded(context)) {
            this.f4708f = c0677k;
            this.c = 0;
            abstractC0684s.dispatch(context, this);
            return;
        }
        K kA = u0.a();
        if (kA.f4108a >= 4294967296L) {
            this.f4708f = c0677k;
            this.c = 0;
            kA.b(this);
            return;
        }
        kA.c(true);
        try {
            CoroutineContext context2 = continuation.getContext();
            Object objC = AbstractC0797A.c(context2, this.f4709g);
            try {
                continuation.resumeWith(obj);
                while (kA.e()) {
                }
            } finally {
                AbstractC0797A.a(context2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.d + ", " + AbstractC0690y.k(this.e) + ']';
    }
}
