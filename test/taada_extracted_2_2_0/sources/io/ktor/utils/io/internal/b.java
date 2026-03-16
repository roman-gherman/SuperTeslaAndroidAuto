package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3582a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "state");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "jobCancellationHandler");

    @NotNull
    private volatile /* synthetic */ Object state = null;

    @NotNull
    private volatile /* synthetic */ Object jobCancellationHandler = null;

    public static final void a(b bVar, Job job, Throwable th) {
        while (true) {
            Object obj = bVar.state;
            if (obj instanceof Continuation) {
                Continuation continuation = (Continuation) obj;
                if (continuation.getContext().get(Job.Key) != job) {
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3582a;
                while (!atomicReferenceFieldUpdater.compareAndSet(bVar, obj, null)) {
                    if (atomicReferenceFieldUpdater.get(bVar) != obj) {
                        break;
                    }
                }
                kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<T of io.ktor.utils.io.internal.CancellableReusableContinuation>");
                continuation.resumeWith(kotlin.reflect.l.n(th));
                return;
            }
            return;
        }
    }

    public final void b(Throwable th) {
        resumeWith(kotlin.reflect.l.n(th));
        a aVar = (a) b.getAndSet(this, null);
        if (aVar != null) {
            aVar.a();
        }
    }

    public final Object c(Continuation continuation) throws Throwable {
        while (true) {
            Object obj = this.state;
            if (obj != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3582a;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (obj instanceof Throwable) {
                    throw ((Throwable) obj);
                }
                return obj;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f3582a;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, null, continuation)) {
                if (atomicReferenceFieldUpdater2.get(this) != null) {
                    break;
                }
            }
            Job job = (Job) continuation.getContext().get(Job.Key);
            a aVar = (a) this.jobCancellationHandler;
            if ((aVar != null ? aVar.f3581a : null) != job) {
                if (job == null) {
                    a aVar2 = (a) b.getAndSet(this, null);
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                } else {
                    a aVar3 = new a(this, job);
                    while (true) {
                        Object obj2 = this.jobCancellationHandler;
                        a aVar4 = (a) obj2;
                        if (aVar4 != null && aVar4.f3581a == job) {
                            aVar3.a();
                            break;
                        }
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = b;
                        while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj2, aVar3)) {
                            if (atomicReferenceFieldUpdater3.get(this) != obj2) {
                                break;
                            }
                        }
                        if (aVar4 != null) {
                            aVar4.a();
                        }
                    }
                }
            }
            return T1.a.f1304a;
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        CoroutineContext context;
        Object obj = this.state;
        Continuation continuation = obj instanceof Continuation ? (Continuation) obj : null;
        return (continuation == null || (context = continuation.getContext()) == null) ? S1.g.f1282a : context;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object objA;
        while (true) {
            Object obj2 = this.state;
            if (obj2 == null) {
                objA = N1.h.a(obj);
                if (objA == null) {
                    kotlin.reflect.l.e0(obj);
                    objA = obj;
                }
            } else if (!(obj2 instanceof Continuation)) {
                return;
            } else {
                objA = null;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3582a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (obj2 instanceof Continuation) {
                ((Continuation) obj2).resumeWith(obj);
                return;
            }
            return;
        }
    }
}
