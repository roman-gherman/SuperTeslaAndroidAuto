package m3;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.Job;
import r3.AbstractC0797A;
import r3.AbstractC0800a;

/* JADX INFO: renamed from: m3.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0690y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E1.h f4150a = new E1.h("RESUME_TOKEN", 9);
    public static final E1.h b = new E1.h("REMOVED_TASK", 9);
    public static final E1.h c = new E1.h("CLOSED_EMPTY", 9);
    public static final E1.h d = new E1.h("COMPLETING_ALREADY", 9);
    public static final E1.h e = new E1.h("COMPLETING_WAITING_CHILDREN", 9);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final E1.h f4151f = new E1.h("COMPLETING_RETRY", 9);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final E1.h f4152g = new E1.h("TOO_LATE_TO_CANCEL", 9);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final E1.h f4153h = new E1.h("SEALED", 9);
    public static final J i = new J(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final J f4154j = new J(true);

    public static d0 a() {
        return new d0(null);
    }

    public static t0 b() {
        return new t0(null);
    }

    public static Object c(Delay delay, long j6, Continuation continuation) {
        N1.m mVar = N1.m.f1129a;
        if (j6 > 0) {
            C0672f c0672f = new C0672f(1, C5.f.J(continuation));
            c0672f.initCancellability();
            delay.scheduleResumeAfterDelay(j6, c0672f);
            Object objM = c0672f.m();
            if (objM == T1.a.f1304a) {
                return objM;
            }
        }
        return mVar;
    }

    public static final void d(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null && !job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final String e(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final C0672f f(Continuation continuation) {
        C0672f c0672f;
        C0672f c0672f2;
        if (!(continuation instanceof r3.h)) {
            return new C0672f(1, continuation);
        }
        r3.h hVar = (r3.h) continuation;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = r3.h.f4708h;
            Object obj = atomicReferenceFieldUpdater.get(hVar);
            E1.h hVar2 = AbstractC0800a.d;
            c0672f = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(hVar, hVar2);
                c0672f2 = null;
                break;
            }
            if (obj instanceof C0672f) {
                while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, hVar2)) {
                    if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                        break;
                    }
                }
                c0672f2 = (C0672f) obj;
                break loop0;
            }
            if (obj != hVar2 && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (c0672f2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0672f.f4125g;
            Object obj2 = atomicReferenceFieldUpdater2.get(c0672f2);
            if (!(obj2 instanceof C0676j) || ((C0676j) obj2).d == null) {
                C0672f.f4124f.set(c0672f2, 536870911);
                atomicReferenceFieldUpdater2.set(c0672f2, C0667b.f4120a);
                c0672f = c0672f2;
            } else {
                c0672f2.j();
            }
            if (c0672f != null) {
                return c0672f;
            }
        }
        return new C0672f(2, continuation);
    }

    public static s0 g(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, int i3) {
        if ((i3 & 1) != 0) {
            coroutineContext = S1.g.f1282a;
        }
        s0 s0Var = new s0(AbstractC0682p.b(coroutineScope, coroutineContext), true);
        s0Var.H(1, s0Var, function2);
        return s0Var;
    }

    public static final Object h(Object obj) {
        return obj instanceof C0677k ? kotlin.reflect.l.n(((C0677k) obj).f4134a) : obj;
    }

    public static final void i(C0672f c0672f, Continuation continuation, boolean z6) {
        Object obj = C0672f.f4125g.get(c0672f);
        Throwable thC = c0672f.c(obj);
        Object objN = thC != null ? kotlin.reflect.l.n(thC) : c0672f.d(obj);
        if (!z6) {
            continuation.resumeWith(objN);
            return;
        }
        kotlin.jvm.internal.h.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        r3.h hVar = (r3.h) continuation;
        Continuation continuation2 = hVar.e;
        CoroutineContext context = continuation2.getContext();
        Object objC = AbstractC0797A.c(context, hVar.f4710g);
        y0 y0VarC = objC != AbstractC0797A.f4696a ? AbstractC0682p.c(continuation2, context, objC) : null;
        try {
            continuation2.resumeWith(objN);
            if (y0VarC == null || y0VarC.I()) {
                AbstractC0797A.a(context, objC);
            }
        } catch (Throwable th) {
            if (y0VarC == null || y0VarC.I()) {
                AbstractC0797A.a(context, objC);
            }
            throw th;
        }
    }

    public static final void j(CoroutineContext coroutineContext, Function2 function2) throws Throwable {
        K kA;
        CoroutineContext coroutineContextA;
        Thread threadCurrentThread = Thread.currentThread();
        S1.f fVar = ContinuationInterceptor.Key;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(fVar);
        S1.g gVar = S1.g.f1282a;
        if (continuationInterceptor == null) {
            kA = u0.a();
            coroutineContextA = AbstractC0682p.a(gVar, coroutineContext.plus(kA), true);
            t3.d dVar = G.f4105a;
            if (coroutineContextA != dVar && coroutineContextA.get(fVar) == null) {
                coroutineContextA = coroutineContextA.plus(dVar);
            }
        } else {
            if (continuationInterceptor instanceof K) {
            }
            kA = (K) u0.f4146a.get();
            coroutineContextA = AbstractC0682p.a(gVar, coroutineContext, true);
            t3.d dVar2 = G.f4105a;
            if (coroutineContextA != dVar2 && coroutineContextA.get(fVar) == null) {
                coroutineContextA = coroutineContextA.plus(dVar2);
            }
        }
        C0669c c0669c = new C0669c(coroutineContextA, threadCurrentThread, kA);
        c0669c.H(1, c0669c, function2);
        K k6 = c0669c.e;
        if (k6 != null) {
            int i3 = K.d;
            k6.c(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jD = k6 != null ? k6.d() : LocationRequestCompat.PASSIVE_INTERVAL;
                if (c0669c.isCompleted()) {
                    if (k6 != null) {
                        int i4 = K.d;
                        k6.a(false);
                    }
                    Object objL = l(c0669c.p());
                    C0677k c0677k = objL instanceof C0677k ? (C0677k) objL : null;
                    if (c0677k != null) {
                        throw c0677k.f4134a;
                    }
                    return;
                }
                LockSupport.parkNanos(c0669c, jD);
            } catch (Throwable th) {
                if (k6 != null) {
                    int i5 = K.d;
                    k6.a(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        c0669c.d(interruptedException);
        throw interruptedException;
    }

    public static final String k(Continuation continuation) {
        Object objN;
        if (continuation instanceof r3.h) {
            return continuation.toString();
        }
        try {
            objN = continuation + '@' + e(continuation);
        } catch (Throwable th) {
            objN = kotlin.reflect.l.n(th);
        }
        if (N1.h.a(objN) != null) {
            objN = continuation.getClass().getName() + '@' + e(continuation);
        }
        return (String) objN;
    }

    public static final Object l(Object obj) {
        Incomplete incomplete;
        X x = obj instanceof X ? (X) obj : null;
        return (x == null || (incomplete = x.f4117a) == null) ? obj : incomplete;
    }

    public static final Object m(CoroutineContext coroutineContext, Function2 function2, Continuation continuation) throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContextPlus = !((Boolean) coroutineContext.fold(Boolean.FALSE, C0681o.f4141a)).booleanValue() ? context.plus(coroutineContext) : AbstractC0682p.a(context, coroutineContext, false);
        d(coroutineContextPlus);
        if (coroutineContextPlus == context) {
            r3.t tVar = new r3.t(continuation, coroutineContextPlus);
            return io.ktor.utils.io.internal.t.q(tVar, tVar, function2);
        }
        S1.f fVar = ContinuationInterceptor.Key;
        if (kotlin.jvm.internal.h.a(coroutineContextPlus.get(fVar), context.get(fVar))) {
            y0 y0Var = new y0(continuation, coroutineContextPlus);
            CoroutineContext coroutineContext2 = y0Var.c;
            Object objC = AbstractC0797A.c(coroutineContext2, null);
            try {
                return io.ktor.utils.io.internal.t.q(y0Var, y0Var, function2);
            } finally {
                AbstractC0797A.a(coroutineContext2, objC);
            }
        }
        E e6 = new E(continuation, coroutineContextPlus);
        io.ktor.utils.io.b0.A(function2, e6, e6);
        do {
            atomicIntegerFieldUpdater = E.e;
            int i3 = atomicIntegerFieldUpdater.get(e6);
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                Object objL = l(e6.p());
                if (objL instanceof C0677k) {
                    throw ((C0677k) objL).f4134a;
                }
                return objL;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(e6, 0, 1));
        return T1.a.f1304a;
    }

    public static final Object n(Function2 function2, Continuation continuation) throws Throwable {
        Object c0677k;
        Object objU;
        w0 w0Var = new w0(continuation);
        w0Var.invokeOnCompletion(new I(D.c(w0Var.d.getContext()).invokeOnTimeout(w0Var.e, w0Var, w0Var.c), 0));
        try {
            kotlin.jvm.internal.z.d(2, function2);
            c0677k = function2.mo5invoke(w0Var, w0Var);
        } catch (Throwable th) {
            c0677k = new C0677k(th, false);
        }
        T1.a aVar = T1.a.f1304a;
        if (c0677k == aVar || (objU = w0Var.u(c0677k)) == e) {
            return aVar;
        }
        if (objU instanceof C0677k) {
            Throwable th2 = ((C0677k) objU).f4134a;
            if (!(th2 instanceof v0) || ((v0) th2).f4147a != w0Var) {
                throw th2;
            }
            if (c0677k instanceof C0677k) {
                throw ((C0677k) c0677k).f4134a;
            }
        } else {
            c0677k = l(objU);
        }
        return c0677k;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Object o(U1.c cVar) {
        Object obj;
        CoroutineContext context = cVar.getContext();
        d(context);
        Continuation continuationJ = C5.f.J(cVar);
        r3.h hVar = continuationJ instanceof r3.h ? (r3.h) continuationJ : null;
        T1.a aVar = T1.a.f1304a;
        N1.m mVar = N1.m.f1129a;
        if (hVar == null) {
            obj = mVar;
        } else {
            AbstractC0684s abstractC0684s = hVar.d;
            if (abstractC0684s.isDispatchNeeded(context)) {
                hVar.f4709f = mVar;
                hVar.c = 1;
                abstractC0684s.dispatchYield(context, hVar);
            } else {
                B0 b02 = new B0(B0.b);
                CoroutineContext coroutineContextPlus = context.plus(b02);
                hVar.f4709f = mVar;
                hVar.c = 1;
                abstractC0684s.dispatchYield(coroutineContextPlus, hVar);
                if (b02.f4103a) {
                    K kA = u0.a();
                    kotlin.collections.i iVar = kA.c;
                    if (!(iVar != null ? iVar.isEmpty() : true)) {
                        if (kA.f4109a >= 4294967296L) {
                            hVar.f4709f = mVar;
                            hVar.c = 1;
                            kA.b(hVar);
                        } else {
                            kA.c(true);
                            try {
                                hVar.run();
                                do {
                                } while (kA.e());
                            } finally {
                                try {
                                } finally {
                                }
                            }
                        }
                    }
                    obj = mVar;
                }
            }
            obj = aVar;
        }
        return obj == aVar ? obj : mVar;
    }
}
