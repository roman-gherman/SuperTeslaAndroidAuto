package v3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Waiter;
import m3.AbstractC0684s;
import m3.C0672f;
import r3.u;

/* JADX INFO: renamed from: v3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0855b implements CancellableContinuation, Waiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0672f f4941a;
    public final Object b;
    public final /* synthetic */ g c;

    public C0855b(g gVar, C0672f c0672f, Object obj) {
        this.c = gVar;
        this.f4941a = c0672f;
        this.b = obj;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean cancel(Throwable th) {
        return this.f4941a.cancel(th);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void completeResume(Object obj) {
        this.f4941a.completeResume(obj);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f4941a.e;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void initCancellability() {
        this.f4941a.initCancellability();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void invokeOnCancellation(Function1 function1) {
        this.f4941a.invokeOnCancellation(function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isActive() {
        return this.f4941a.isActive();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isCancelled() {
        return this.f4941a.isCancelled();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isCompleted() {
        return this.f4941a.isCompleted();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resume(Object obj, Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g.f4946h;
        g gVar = this.c;
        atomicReferenceFieldUpdater.set(gVar, this.b);
        C0854a c0854a = new C0854a(gVar, this, 0);
        this.f4941a.resume((N1.m) obj, c0854a);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resumeUndispatched(AbstractC0684s abstractC0684s, Object obj) {
        this.f4941a.resumeUndispatched(abstractC0684s, (N1.m) obj);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resumeUndispatchedWithException(AbstractC0684s abstractC0684s, Throwable th) {
        this.f4941a.resumeUndispatchedWithException(abstractC0684s, th);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.f4941a.resumeWith(obj);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Object tryResume(Object obj, Object obj2) {
        return this.f4941a.v((N1.m) obj, obj2, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Object tryResumeWithException(Throwable th) {
        return this.f4941a.tryResumeWithException(th);
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(u uVar, int i) {
        this.f4941a.invokeOnCancellation(uVar, i);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Object tryResume(Object obj, Object obj2, Function1 function1) {
        g gVar = this.c;
        C0854a c0854a = new C0854a(gVar, this, 1);
        E1.h hVarV = this.f4941a.v((N1.m) obj, obj2, c0854a);
        if (hVarV != null) {
            g.f4946h.set(gVar, this.b);
        }
        return hVarV;
    }
}
