package m3;

import c4.AbstractC0246d;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ParentJob;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class o0 implements Job, ChildJob, ParentJob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4142a = AtomicReferenceFieldUpdater.newUpdater(o0.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(o0.class, Object.class, "_parentHandle");

    @Volatile
    @Nullable
    private volatile Object _parentHandle;

    @Volatile
    @Nullable
    private volatile Object _state;

    public o0(boolean z6) {
        this._state = z6 ? AbstractC0690y.f4154j : AbstractC0690y.i;
    }

    public static String C(Object obj) {
        if (!(obj instanceof h0)) {
            return obj instanceof Incomplete ? ((Incomplete) obj).isActive() ? "Active" : "New" : obj instanceof C0677k ? "Cancelled" : "Completed";
        }
        h0 h0Var = (h0) obj;
        return h0Var.c() ? "Cancelling" : h0Var.d() ? "Completing" : "Active";
    }

    public static CancellationException D(o0 o0Var, Throwable th) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new C0668b0(o0Var.g(), th, o0Var) : cancellationException;
    }

    public static C0675i w(r3.k kVar) {
        while (kVar.e()) {
            r3.k kVarA = kVar.a();
            if (kVarA == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = r3.k.b;
                Object obj = atomicReferenceFieldUpdater.get(kVar);
                while (true) {
                    kVar = (r3.k) obj;
                    if (!kVar.e()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVar);
                }
            } else {
                kVar = kVarA;
            }
        }
        while (true) {
            kVar = kVar.d();
            if (!kVar.e()) {
                if (kVar instanceof C0675i) {
                    return (C0675i) kVar;
                }
                if (kVar instanceof q0) {
                    return null;
                }
            }
        }
    }

    public final void A(e0 e0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        q0 q0Var = new q0();
        e0Var.getClass();
        r3.k.b.lazySet(q0Var, e0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = r3.k.f4713a;
        atomicReferenceFieldUpdater2.lazySet(q0Var, e0Var);
        loop0: while (true) {
            if (e0Var.c() == e0Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(e0Var, e0Var, q0Var)) {
                    if (atomicReferenceFieldUpdater2.get(e0Var) != e0Var) {
                        break;
                    }
                }
                q0Var.b(e0Var);
                break loop0;
            }
            break;
        }
        r3.k kVarD = e0Var.d();
        do {
            atomicReferenceFieldUpdater = f4142a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, e0Var, kVarD)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == e0Var);
    }

    public final int B(Object obj) {
        boolean z6 = obj instanceof J;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4142a;
        if (z6) {
            if (((J) obj).f4108a) {
                return 0;
            }
            J j6 = AbstractC0690y.f4154j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, j6)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            return 1;
        }
        if (!(obj instanceof W)) {
            return 0;
        }
        q0 q0Var = ((W) obj).f4116a;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, q0Var)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        return 1;
    }

    public final Object E(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (!(obj instanceof Incomplete)) {
            return AbstractC0690y.d;
        }
        if (((obj instanceof J) || (obj instanceof e0)) && !(obj instanceof C0675i) && !(obj2 instanceof C0677k)) {
            Incomplete incomplete = (Incomplete) obj;
            Object x = obj2 instanceof Incomplete ? new X((Incomplete) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = f4142a;
                if (atomicReferenceFieldUpdater.compareAndSet(this, incomplete, x)) {
                    y(obj2);
                    i(incomplete, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == incomplete);
            return AbstractC0690y.f4151f;
        }
        Incomplete incomplete2 = (Incomplete) obj;
        q0 q0VarO = o(incomplete2);
        if (q0VarO == null) {
            return AbstractC0690y.f4151f;
        }
        C0675i c0675iW = null;
        h0 h0Var = incomplete2 instanceof h0 ? (h0) incomplete2 : null;
        if (h0Var == null) {
            h0Var = new h0(q0VarO, null);
        }
        synchronized (h0Var) {
            if (h0Var.d()) {
                return AbstractC0690y.d;
            }
            h0.b.set(h0Var, 1);
            if (h0Var != incomplete2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f4142a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, incomplete2, h0Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != incomplete2) {
                        return AbstractC0690y.f4151f;
                    }
                }
            }
            boolean zC = h0Var.c();
            C0677k c0677k = obj2 instanceof C0677k ? (C0677k) obj2 : null;
            if (c0677k != null) {
                h0Var.a(c0677k.f4134a);
            }
            Throwable thB = h0Var.b();
            if (zC) {
                thB = null;
            }
            if (thB != null) {
                x(q0VarO, thB);
            }
            C0675i c0675i = incomplete2 instanceof C0675i ? (C0675i) incomplete2 : null;
            if (c0675i == null) {
                q0 list = incomplete2.getList();
                if (list != null) {
                    c0675iW = w(list);
                }
            } else {
                c0675iW = c0675i;
            }
            if (c0675iW != null) {
                while (c0675iW.e.invokeOnCompletion((1 & 1) == 0, (1 & 2) != 0, new g0(this, h0Var, c0675iW, obj2)) == r0.f4144a) {
                    c0675iW = w(c0675iW);
                    if (c0675iW == null) {
                    }
                }
                return AbstractC0690y.e;
            }
            return k(h0Var, obj2);
        }
    }

    public final boolean a(Incomplete incomplete, q0 q0Var, e0 e0Var) {
        char c;
        j0 j0Var = new j0(e0Var, this, incomplete);
        do {
            r3.k kVarA = q0Var.a();
            if (kVarA == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = r3.k.b;
                Object obj = atomicReferenceFieldUpdater.get(q0Var);
                while (true) {
                    kVarA = (r3.k) obj;
                    if (!kVarA.e()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVarA);
                }
            }
            r3.k.b.lazySet(e0Var, kVarA);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = r3.k.f4713a;
            atomicReferenceFieldUpdater2.lazySet(e0Var, q0Var);
            j0Var.c = q0Var;
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(kVarA, q0Var, j0Var)) {
                    c = j0Var.a(kVarA) == null ? (char) 1 : (char) 2;
                } else if (atomicReferenceFieldUpdater2.get(kVarA) != q0Var) {
                    c = 0;
                    break;
                }
            }
            if (c == 1) {
                return true;
            }
        } while (c != 2);
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob childJob) {
        DisposableHandle disposableHandleInvokeOnCompletion = invokeOnCompletion((1 & 1) == 0, (1 & 2) != 0, new C0675i(childJob));
        kotlin.jvm.internal.h.d(disposableHandleInvokeOnCompletion, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) disposableHandleInvokeOnCompletion;
    }

    public void b(Object obj) {
    }

    public void c(Object obj) {
        b(obj);
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[PHI: r0
      0x003a: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v12 java.lang.Object) binds: [B:3:0x0008, B:16:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(java.lang.Object r10) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.o0.d(java.lang.Object):boolean");
    }

    public void e(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        d(cancellationException);
    }

    public final boolean f(Throwable th) {
        if (!t()) {
            boolean z6 = th instanceof CancellationException;
            ChildHandle childHandle = (ChildHandle) b.get(this);
            return (childHandle == null || childHandle == r0.f4144a) ? z6 : childHandle.childCancelled(th) || z6;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return kotlin.coroutines.a.a(this, obj, function2);
    }

    public String g() {
        return "Job was cancelled";
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return kotlin.coroutines.a.b(this, key);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object objP = p();
        if (!(objP instanceof h0)) {
            if (!(objP instanceof Incomplete)) {
                return objP instanceof C0677k ? D(this, ((C0677k) objP).f4134a) : new C0668b0(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        Throwable thB = ((h0) objP).b();
        if (thB == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        CancellationException c0668b0 = thB instanceof CancellationException ? (CancellationException) thB : null;
        if (c0668b0 == null) {
            if (strConcat == null) {
                strConcat = g();
            }
            c0668b0 = new C0668b0(strConcat, thB, this);
        }
        return c0668b0;
    }

    @Override // kotlinx.coroutines.ParentJob
    public final CancellationException getChildJobCancellationCause() {
        Throwable thB;
        Object objP = p();
        if (objP instanceof h0) {
            thB = ((h0) objP).b();
        } else if (objP instanceof C0677k) {
            thB = ((C0677k) objP).f4134a;
        } else {
            if (objP instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objP).toString());
            }
            thB = null;
        }
        CancellationException cancellationException = thB instanceof CancellationException ? (CancellationException) thB : null;
        return cancellationException == null ? new C0668b0("Parent job is ".concat(C(objP)), thB, this) : cancellationException;
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence getChildren() {
        return new k3.n(new k0(this, null));
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object objP = p();
        if (objP instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        C0677k c0677k = objP instanceof C0677k ? (C0677k) objP : null;
        if (c0677k != null) {
            return c0677k.f4134a;
        }
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key;
    }

    @Override // kotlinx.coroutines.Job
    public final SelectClause0 getOnJoin() {
        kotlin.jvm.internal.z.d(3, n0.f4140a);
        return new B.h(this);
    }

    @Override // kotlinx.coroutines.Job
    public final Job getParent() {
        ChildHandle childHandle = (ChildHandle) b.get(this);
        if (childHandle != null) {
            return childHandle.getParent();
        }
        return null;
    }

    public boolean h(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return d(th) && m();
    }

    public final void i(Incomplete incomplete, Object obj) throws IllegalAccessException, InvocationTargetException {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        if (childHandle != null) {
            childHandle.dispose();
            atomicReferenceFieldUpdater.set(this, r0.f4144a);
        }
        C0.x xVar = null;
        C0677k c0677k = obj instanceof C0677k ? (C0677k) obj : null;
        Throwable th = c0677k != null ? c0677k.f4134a : null;
        if (incomplete instanceof e0) {
            try {
                ((e0) incomplete).g(th);
                return;
            } catch (Throwable th2) {
                r(new C0.x("Exception in completion handler " + incomplete + " for " + this, th2));
                return;
            }
        }
        q0 list = incomplete.getList();
        if (list != null) {
            Object objC = list.c();
            kotlin.jvm.internal.h.d(objC, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (r3.k kVarD = (r3.k) objC; !kVarD.equals(list); kVarD = kVarD.d()) {
                if (kVarD instanceof e0) {
                    e0 e0Var = (e0) kVarD;
                    try {
                        e0Var.g(th);
                    } catch (Throwable th3) {
                        if (xVar != null) {
                            AbstractC0246d.e(xVar, th3);
                        } else {
                            xVar = new C0.x("Exception in completion handler " + e0Var + " for " + this, th3);
                        }
                    }
                }
            }
            if (xVar != null) {
                r(xVar);
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1 function1) {
        return invokeOnCompletion(false, true, function1);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object objP = p();
        return (objP instanceof Incomplete) && ((Incomplete) objP).isActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object objP = p();
        if (objP instanceof C0677k) {
            return true;
        }
        return (objP instanceof h0) && ((h0) objP).c();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(p() instanceof Incomplete);
    }

    public final Throwable j(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new C0668b0(g(), null, this) : th;
        }
        kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) obj).getChildJobCancellationCause();
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation continuation) {
        boolean z6;
        while (true) {
            Object objP = p();
            if (!(objP instanceof Incomplete)) {
                z6 = false;
                break;
            }
            if (B(objP) >= 0) {
                z6 = true;
                break;
            }
        }
        N1.m mVar = N1.m.f1129a;
        if (!z6) {
            AbstractC0690y.d(continuation.getContext());
            return mVar;
        }
        C0672f c0672f = new C0672f(1, C5.f.J(continuation));
        c0672f.initCancellability();
        c0672f.invokeOnCancellation(new C0671e(invokeOnCompletion(false, true, new I(c0672f, 3)), 1));
        Object objM = c0672f.m();
        T1.a aVar = T1.a.f1304a;
        if (objM != aVar) {
            objM = mVar;
        }
        return objM == aVar ? objM : mVar;
    }

    public final Object k(h0 h0Var, Object obj) throws IllegalAccessException, InvocationTargetException {
        Throwable thL;
        C0677k c0677k = obj instanceof C0677k ? (C0677k) obj : null;
        Throwable th = c0677k != null ? c0677k.f4134a : null;
        synchronized (h0Var) {
            h0Var.c();
            ArrayList<Throwable> arrayListE = h0Var.e(th);
            thL = l(h0Var, arrayListE);
            if (thL != null && arrayListE.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListE.size()));
                for (Throwable th2 : arrayListE) {
                    if (th2 != thL && th2 != thL && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        AbstractC0246d.e(thL, th2);
                    }
                }
            }
        }
        if (thL != null && thL != th) {
            obj = new C0677k(thL, false);
        }
        if (thL != null && (f(thL) || q(thL))) {
            kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C0677k.b.compareAndSet((C0677k) obj, 0, 1);
        }
        y(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4142a;
        Object x = obj instanceof Incomplete ? new X((Incomplete) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, h0Var, x) && atomicReferenceFieldUpdater.get(this) == h0Var) {
        }
        i(h0Var, obj);
        return obj;
    }

    public final Throwable l(h0 h0Var, ArrayList arrayList) {
        Object next;
        Object obj = null;
        if (arrayList.isEmpty()) {
            if (h0Var.c()) {
                return new C0668b0(g(), null, this);
            }
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof v0) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof v0)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean m() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return kotlin.coroutines.a.c(this, key);
    }

    public boolean n() {
        return false;
    }

    public final q0 o(Incomplete incomplete) {
        q0 list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof J) {
            return new q0();
        }
        if (incomplete instanceof e0) {
            A((e0) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    public final Object p() {
        while (true) {
            Object obj = f4142a.get(this);
            if (!(obj instanceof r3.q)) {
                return obj;
            }
            ((r3.q) obj).a(this);
        }
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(ParentJob parentJob) throws IllegalAccessException, InvocationTargetException {
        d(parentJob);
    }

    @Override // kotlinx.coroutines.Job
    public final Job plus(Job job) {
        return job;
    }

    public boolean q(Throwable th) {
        return false;
    }

    public void r(C0.x xVar) {
        throw xVar;
    }

    public final void s(Job job) {
        r0 r0Var = r0.f4144a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        if (job == null) {
            atomicReferenceFieldUpdater.set(this, r0Var);
            return;
        }
        job.start();
        ChildHandle childHandleAttachChild = job.attachChild(this);
        atomicReferenceFieldUpdater.set(this, childHandleAttachChild);
        if (isCompleted()) {
            childHandleAttachChild.dispose();
            atomicReferenceFieldUpdater.set(this, r0Var);
        }
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int iB;
        do {
            iB = B(p());
            if (iB == 0) {
                return false;
            }
        } while (iB != 1);
        return true;
    }

    public boolean t() {
        return this instanceof C0669c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(v() + '{' + C(p()) + '}');
        sb.append('@');
        sb.append(AbstractC0690y.e(this));
        return sb.toString();
    }

    public final Object u(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objE;
        do {
            objE = E(p(), obj);
            if (objE == AbstractC0690y.d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                C0677k c0677k = obj instanceof C0677k ? (C0677k) obj : null;
                throw new IllegalStateException(str, c0677k != null ? c0677k.f4134a : null);
            }
        } while (objE == AbstractC0690y.f4151f);
        return objE;
    }

    public String v() {
        return getClass().getSimpleName();
    }

    public final void x(q0 q0Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        Object objC = q0Var.c();
        kotlin.jvm.internal.h.d(objC, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        C0.x xVar = null;
        for (r3.k kVarD = (r3.k) objC; !kVarD.equals(q0Var); kVarD = kVarD.d()) {
            if (kVarD instanceof c0) {
                e0 e0Var = (e0) kVarD;
                try {
                    e0Var.g(th);
                } catch (Throwable th2) {
                    if (xVar != null) {
                        AbstractC0246d.e(xVar, th2);
                    } else {
                        xVar = new C0.x("Exception in completion handler " + e0Var + " for " + this, th2);
                    }
                }
            }
        }
        if (xVar != null) {
            r(xVar);
        }
        f(th);
    }

    public void y(Object obj) {
    }

    public void z() {
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ boolean cancel(Throwable th) throws IllegalAccessException, InvocationTargetException {
        e(th != null ? D(this, th) : new C0668b0(g(), null, this));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ba A[SYNTHETIC] */
    @Override // kotlinx.coroutines.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.DisposableHandle invokeOnCompletion(boolean r8, boolean r9, kotlin.jvm.functions.Function1 r10) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.o0.invokeOnCompletion(boolean, boolean, kotlin.jvm.functions.Function1):kotlinx.coroutines.DisposableHandle");
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return kotlin.coroutines.a.d(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        if (cancellationException == null) {
            cancellationException = new C0668b0(g(), null, this);
        }
        e(cancellationException);
    }
}
