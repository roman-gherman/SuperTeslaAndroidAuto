package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f3595a;
    public final /* synthetic */ c b;

    public b(c cVar) {
        this.b = cVar;
        Job job = cVar.f3597a;
        this.f3595a = job != null ? o.f3610a.plus(job) : o.f3610a;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f3595a;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object obj2;
        boolean z6;
        boolean z7;
        Throwable thA;
        Job job;
        Object objA = N1.h.a(obj);
        if (objA == null) {
            objA = N1.m.f1129a;
        }
        c cVar = this.b;
        do {
            obj2 = cVar.state;
            z6 = obj2 instanceof Thread;
            z7 = true;
            if (!(z6 ? true : obj2 instanceof Continuation ? true : kotlin.jvm.internal.h.a(obj2, this))) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f3596f;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(cVar, obj2, objA)) {
                    break;
                } else if (atomicReferenceFieldUpdater.get(cVar) != obj2) {
                    z7 = false;
                    break;
                }
            }
        } while (!z7);
        if (z6) {
            Parking parking = (Parking) l.f3607a.get();
            if (parking == null) {
                parking = f.b;
            }
            parking.unpark(obj2);
        } else if ((obj2 instanceof Continuation) && (thA = N1.h.a(obj)) != null) {
            ((Continuation) obj2).resumeWith(kotlin.reflect.l.n(thA));
        }
        if ((obj instanceof N1.g) && !(N1.h.a(obj) instanceof CancellationException) && (job = this.b.f3597a) != null) {
            job.cancel((CancellationException) null);
        }
        DisposableHandle disposableHandle = this.b.c;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }
}
