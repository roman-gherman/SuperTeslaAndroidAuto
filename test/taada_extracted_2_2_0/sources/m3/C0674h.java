package m3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import r3.AbstractC0800a;

/* JADX INFO: renamed from: m3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0674h extends c0 {
    public final C0672f e;

    public C0674h(C0672f c0672f) {
        this.e = c0672f;
    }

    @Override // m3.e0
    public final void g(Throwable th) {
        o0 o0VarF = f();
        C0672f c0672f = this.e;
        Throwable thL = c0672f.l(o0VarF);
        if (c0672f.p()) {
            Continuation continuation = c0672f.d;
            kotlin.jvm.internal.h.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            r3.h hVar = (r3.h) continuation;
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = r3.h.f4708h;
                Object obj = atomicReferenceFieldUpdater.get(hVar);
                E1.h hVar2 = AbstractC0800a.d;
                if (!kotlin.jvm.internal.h.a(obj, hVar2)) {
                    if (!(obj instanceof Throwable)) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, null)) {
                            if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    return;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(hVar, hVar2, thL)) {
                    if (atomicReferenceFieldUpdater.get(hVar) != hVar2) {
                        break;
                    }
                }
                return;
            }
        }
        c0672f.cancel(thL);
        if (c0672f.p()) {
            return;
        }
        c0672f.j();
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        g((Throwable) obj);
        return N1.m.f1129a;
    }
}
