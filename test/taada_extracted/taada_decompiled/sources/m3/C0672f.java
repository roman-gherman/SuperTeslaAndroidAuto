package m3;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.Waiter;
import org.jetbrains.annotations.Nullable;
import r3.AbstractC0800a;

/* JADX INFO: renamed from: m3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0672f extends F implements CancellableContinuation, CoroutineStackFrame, Waiter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f4123f = AtomicIntegerFieldUpdater.newUpdater(C0672f.class, "_decisionAndIndex");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4124g = AtomicReferenceFieldUpdater.newUpdater(C0672f.class, Object.class, "_state");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4125h = AtomicReferenceFieldUpdater.newUpdater(C0672f.class, Object.class, "_parentHandle");

    @Volatile
    private volatile int _decisionAndIndex;

    @Volatile
    @Nullable
    private volatile Object _parentHandle;

    @Volatile
    @Nullable
    private volatile Object _state;
    public final Continuation d;
    public final CoroutineContext e;

    public C0672f(int i, Continuation continuation) {
        super(i);
        this.d = continuation;
        this.e = continuation.getContext();
        this._decisionAndIndex = 536870911;
        this._state = C0667b.f4119a;
    }

    public static void q(NotCompleted notCompleted, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + notCompleted + ", already has " + obj).toString());
    }

    public static Object u(NotCompleted notCompleted, Object obj, int i, Function1 function1, Object obj2) {
        if (obj instanceof C0677k) {
            return obj;
        }
        if ((i == 1 || i == 2 || obj2 != null) && !(function1 == null && !(notCompleted instanceof C0671e) && obj2 == null)) {
            return new C0676j(obj, notCompleted instanceof C0671e ? (C0671e) notCompleted : null, function1, obj2, null, 16);
        }
        return obj;
    }

    @Override // m3.F
    public final void a(Object obj, CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4124g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof C0677k) {
                return;
            }
            if (!(obj2 instanceof C0676j)) {
                cancellationException2 = cancellationException;
                C0676j c0676j = new C0676j(obj2, null, null, null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0676j)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            C0676j c0676j2 = (C0676j) obj2;
            if (c0676j2.e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            C0676j c0676jA = C0676j.a(c0676j2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0676jA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    cancellationException2 = cancellationException;
                }
            }
            C0671e c0671e = c0676j2.b;
            if (c0671e != null) {
                g(c0671e, cancellationException);
            }
            Function1 function1 = c0676j2.c;
            if (function1 != null) {
                h(function1, cancellationException);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // m3.F
    public final Continuation b() {
        return this.d;
    }

    @Override // m3.F
    public final Throwable c(Object obj) {
        Throwable thC = super.c(obj);
        if (thC != null) {
            return thC;
        }
        return null;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean cancel(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4124g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            C0673g c0673g = new C0673g(this, th, (obj instanceof C0671e) || (obj instanceof r3.u));
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0673g)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            NotCompleted notCompleted = (NotCompleted) obj;
            if (notCompleted instanceof C0671e) {
                g((C0671e) obj, th);
            } else if (notCompleted instanceof r3.u) {
                i((r3.u) obj, th);
            }
            if (!p()) {
                j();
            }
            k(this.c);
            return true;
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void completeResume(Object obj) {
        k(this.c);
    }

    @Override // m3.F
    public final Object d(Object obj) {
        return obj instanceof C0676j ? ((C0676j) obj).f4132a : obj;
    }

    @Override // m3.F
    public final Object f() {
        return f4124g.get(this);
    }

    public final void g(C0671e c0671e, Throwable th) {
        try {
            c0671e.a(th);
        } catch (Throwable th2) {
            AbstractC0686u.a(this.e, new C0.x("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.e;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void h(Function1 function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            AbstractC0686u.a(this.e, new C0.x("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void i(r3.u uVar, Throwable th) {
        CoroutineContext coroutineContext = this.e;
        int i = f4123f.get(this) & 536870911;
        if (i == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            uVar.g(i, coroutineContext);
        } catch (Throwable th2) {
            AbstractC0686u.a(coroutineContext, new C0.x("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void initCancellability() {
        DisposableHandle disposableHandleN = n();
        if (disposableHandleN != null && isCompleted()) {
            disposableHandleN.dispose();
            f4125h.set(this, r0.f4143a);
        }
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(r3.u uVar, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f4123f;
            i3 = atomicIntegerFieldUpdater.get(this);
            if ((i3 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, ((i3 >> 29) << 29) + i));
        o(uVar);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isActive() {
        return f4124g.get(this) instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isCancelled() {
        return f4124g.get(this) instanceof C0673g;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isCompleted() {
        return !(f4124g.get(this) instanceof NotCompleted);
    }

    public final void j() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4125h;
        DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater.get(this);
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        atomicReferenceFieldUpdater.set(this, r0.f4143a);
    }

    public final void k(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f4123f;
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z6 = i == 4;
                Continuation continuation = this.d;
                if (!z6 && (continuation instanceof r3.h)) {
                    boolean z7 = i == 1 || i == 2;
                    int i5 = this.c;
                    if (z7 == (i5 == 1 || i5 == 2)) {
                        AbstractC0684s abstractC0684s = ((r3.h) continuation).d;
                        CoroutineContext context = ((r3.h) continuation).e.getContext();
                        if (abstractC0684s.isDispatchNeeded(context)) {
                            abstractC0684s.dispatch(context, this);
                            return;
                        }
                        K kA = u0.a();
                        if (kA.f4108a >= 4294967296L) {
                            kA.b(this);
                            return;
                        }
                        kA.c(true);
                        try {
                            AbstractC0690y.i(this, continuation, true);
                            do {
                            } while (kA.e());
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        return;
                    }
                }
                AbstractC0690y.i(this, continuation, z6);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, BasicMeasure.EXACTLY + (536870911 & i3)));
    }

    public Throwable l(o0 o0Var) {
        return o0Var.getCancellationException();
    }

    public final Object m() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        boolean zP = p();
        do {
            atomicIntegerFieldUpdater = f4123f;
            i = atomicIntegerFieldUpdater.get(this);
            int i3 = i >> 29;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zP) {
                    s();
                }
                Object obj = f4124g.get(this);
                if (obj instanceof C0677k) {
                    throw ((C0677k) obj).f4133a;
                }
                int i4 = this.c;
                if (i4 == 1 || i4 == 2) {
                    Job job = (Job) this.e.get(Job.Key);
                    if (job != null && !job.isActive()) {
                        CancellationException cancellationException = job.getCancellationException();
                        a(obj, cancellationException);
                        throw cancellationException;
                    }
                }
                return d(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((DisposableHandle) f4125h.get(this)) == null) {
            n();
        }
        if (zP) {
            s();
        }
        return T1.a.f1304a;
    }

    public final DisposableHandle n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Job job = (Job) this.e.get(Job.Key);
        if (job == null) {
            return null;
        }
        DisposableHandle disposableHandleInvokeOnCompletion = job.invokeOnCompletion((1 & 1) == 0, (1 & 2) != 0, new C0674h(this));
        do {
            atomicReferenceFieldUpdater = f4125h;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, disposableHandleInvokeOnCompletion)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return disposableHandleInvokeOnCompletion;
    }

    public final void o(NotCompleted notCompleted) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4124g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof C0667b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, notCompleted)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            if (obj instanceof C0671e ? true : obj instanceof r3.u) {
                q(notCompleted, obj);
                throw null;
            }
            if (obj instanceof C0677k) {
                C0677k c0677k = (C0677k) obj;
                c0677k.getClass();
                if (!C0677k.b.compareAndSet(c0677k, 0, 1)) {
                    q(notCompleted, obj);
                    throw null;
                }
                if (obj instanceof C0673g) {
                    if (obj == null) {
                        c0677k = null;
                    }
                    Throwable th = c0677k != null ? c0677k.f4133a : null;
                    if (notCompleted instanceof C0671e) {
                        g((C0671e) notCompleted, th);
                        return;
                    } else {
                        kotlin.jvm.internal.h.d(notCompleted, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        i((r3.u) notCompleted, th);
                        return;
                    }
                }
                return;
            }
            if (!(obj instanceof C0676j)) {
                if (notCompleted instanceof r3.u) {
                    return;
                }
                kotlin.jvm.internal.h.d(notCompleted, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                C0676j c0676j = new C0676j(obj, (C0671e) notCompleted, null, null, null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0676j)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            C0676j c0676j2 = (C0676j) obj;
            if (c0676j2.b != null) {
                q(notCompleted, obj);
                throw null;
            }
            if (notCompleted instanceof r3.u) {
                return;
            }
            kotlin.jvm.internal.h.d(notCompleted, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
            C0671e c0671e = (C0671e) notCompleted;
            Throwable th2 = c0676j2.e;
            if (th2 != null) {
                g(c0671e, th2);
                return;
            }
            C0676j c0676jA = C0676j.a(c0676j2, c0671e, null, 29);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0676jA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            return;
        }
    }

    public final boolean p() {
        if (this.c != 2) {
            return false;
        }
        Continuation continuation = this.d;
        kotlin.jvm.internal.h.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return r3.h.f4707h.get((r3.h) continuation) != null;
    }

    public String r() {
        return "CancellableContinuation";
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resume(Object obj, Function1 function1) {
        t(obj, this.c, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resumeUndispatched(AbstractC0684s abstractC0684s, Object obj) {
        Continuation continuation = this.d;
        r3.h hVar = continuation instanceof r3.h ? (r3.h) continuation : null;
        t(obj, (hVar != null ? hVar.d : null) == abstractC0684s ? 4 : this.c, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resumeUndispatchedWithException(AbstractC0684s abstractC0684s, Throwable th) {
        Continuation continuation = this.d;
        r3.h hVar = continuation instanceof r3.h ? (r3.h) continuation : null;
        t(new C0677k(th, false), (hVar != null ? hVar.d : null) == abstractC0684s ? 4 : this.c, null);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thA = N1.h.a(obj);
        if (thA != null) {
            obj = new C0677k(thA, false);
        }
        t(obj, this.c, null);
    }

    public final void s() {
        Continuation continuation = this.d;
        Throwable th = null;
        r3.h hVar = continuation instanceof r3.h ? (r3.h) continuation : null;
        if (hVar != null) {
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = r3.h.f4707h;
                Object obj = atomicReferenceFieldUpdater.get(hVar);
                E1.h hVar2 = AbstractC0800a.d;
                if (obj == hVar2) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, hVar2, this)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != hVar2) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            j();
            cancel(th);
        }
    }

    public final void t(Object obj, int i, Function1 function1) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4124g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
                Object objU = u((NotCompleted) obj2, obj, i, function1, null);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objU)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!p()) {
                    j();
                }
                k(i);
                return;
            }
            if (obj2 instanceof C0673g) {
                C0673g c0673g = (C0673g) obj2;
                c0673g.getClass();
                if (C0673g.c.compareAndSet(c0673g, 0, 1)) {
                    if (function1 != null) {
                        h(function1, c0673g.f4133a);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(r());
        sb.append('(');
        sb.append(AbstractC0690y.k(this.d));
        sb.append("){");
        Object obj = f4124g.get(this);
        sb.append(obj instanceof NotCompleted ? "Active" : obj instanceof C0673g ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(AbstractC0690y.e(this));
        return sb.toString();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Object tryResume(Object obj, Object obj2) {
        return v(obj, obj2, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Object tryResumeWithException(Throwable th) {
        return v(new C0677k(th, false), null, null);
    }

    public final E1.h v(Object obj, Object obj2, Function1 function1) {
        E1.h hVar;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4124g;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            boolean z6 = obj3 instanceof NotCompleted;
            hVar = AbstractC0690y.f4149a;
            if (z6) {
                Object objU = u((NotCompleted) obj3, obj, this.c, function1, obj2);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, objU)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        break;
                    }
                }
                if (!p()) {
                    j();
                    return hVar;
                }
            } else if (!(obj3 instanceof C0676j) || obj2 == null || ((C0676j) obj3).d != obj2) {
                return null;
            }
        }
        return hVar;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Object tryResume(Object obj, Object obj2, Function1 function1) {
        return v(obj, obj2, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void invokeOnCancellation(Function1 function1) {
        o(function1 instanceof C0671e ? (C0671e) function1 : new C0671e(function1, 2));
    }
}
