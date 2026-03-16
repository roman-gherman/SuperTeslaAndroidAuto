package o3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelIterator;
import m3.AbstractC0690y;
import m3.C0672f;

/* JADX INFO: renamed from: o3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0744b implements ChannelIterator, Waiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f4322a = p.f4349p;
    public C0672f b;
    public final /* synthetic */ n c;

    public C0744b(n nVar) {
        this.c = nVar;
    }

    @Override // kotlinx.coroutines.channels.ChannelIterator
    public final Object hasNext(Continuation continuation) {
        w wVarJ;
        Boolean bool;
        w wVarJ2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n.f4334g;
        n nVar = this.c;
        w wVar = (w) atomicReferenceFieldUpdater.get(nVar);
        while (!nVar.isClosedForReceive()) {
            long andIncrement = n.c.getAndIncrement(nVar);
            long j6 = p.b;
            long j7 = andIncrement / j6;
            int i = (int) (andIncrement % j6);
            if (wVar.c != j7) {
                wVarJ = nVar.j(j7, wVar);
                if (wVarJ == null) {
                    continue;
                }
            } else {
                wVarJ = wVar;
            }
            Object objB = nVar.B(wVarJ, i, andIncrement, null);
            E1.h hVar = p.f4346m;
            if (objB == hVar) {
                throw new IllegalStateException("unreachable");
            }
            E1.h hVar2 = p.f4348o;
            if (objB != hVar2) {
                if (objB != p.f4347n) {
                    wVarJ.a();
                    this.f4322a = objB;
                    return Boolean.TRUE;
                }
                C0672f c0672fF = AbstractC0690y.f(C5.f.J(continuation));
                try {
                    this.b = c0672fF;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Object objB2 = nVar.B(wVarJ, i, andIncrement, this);
                    if (objB2 == hVar) {
                        invokeOnCancellation(wVarJ, i);
                    } else {
                        if (objB2 == hVar2) {
                            if (andIncrement < nVar.n()) {
                                wVarJ.a();
                            }
                            w wVar2 = (w) n.f4334g.get(nVar);
                            while (true) {
                                if (nVar.isClosedForReceive()) {
                                    C0672f c0672f = this.b;
                                    kotlin.jvm.internal.h.c(c0672f);
                                    this.b = null;
                                    this.f4322a = p.f4345l;
                                    Throwable thK = nVar.k();
                                    if (thK == null) {
                                        c0672f.resumeWith(Boolean.FALSE);
                                    } else {
                                        c0672f.resumeWith(kotlin.reflect.l.n(thK));
                                    }
                                } else {
                                    long andIncrement2 = n.c.getAndIncrement(nVar);
                                    long j8 = p.b;
                                    long j9 = andIncrement2 / j8;
                                    int i3 = (int) (andIncrement2 % j8);
                                    if (wVar2.c != j9) {
                                        wVarJ2 = nVar.j(j9, wVar2);
                                        if (wVarJ2 == null) {
                                        }
                                    } else {
                                        wVarJ2 = wVar2;
                                    }
                                    Object objB3 = nVar.B(wVarJ2, i3, andIncrement2, this);
                                    if (objB3 == p.f4346m) {
                                        invokeOnCancellation(wVarJ2, i3);
                                        break;
                                    }
                                    if (objB3 == p.f4348o) {
                                        if (andIncrement2 < nVar.n()) {
                                            wVarJ2.a();
                                        }
                                        wVar2 = wVarJ2;
                                    } else {
                                        if (objB3 == p.f4347n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        wVarJ2.a();
                                        this.f4322a = objB3;
                                        this.b = null;
                                        bool = Boolean.TRUE;
                                    }
                                }
                            }
                        } else {
                            wVarJ.a();
                            this.f4322a = objB2;
                            this.b = null;
                            bool = Boolean.TRUE;
                        }
                        c0672fF.resume(bool, null);
                    }
                    return c0672fF.m();
                } catch (Throwable th2) {
                    th = th2;
                    c0672fF.s();
                    throw th;
                }
            }
            if (andIncrement < nVar.n()) {
                wVarJ.a();
            }
            wVar = wVarJ;
        }
        this.f4322a = p.f4345l;
        Throwable thK2 = nVar.k();
        if (thK2 == null) {
            return Boolean.FALSE;
        }
        int i4 = r3.v.f4721a;
        throw thK2;
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(r3.u uVar, int i) {
        C0672f c0672f = this.b;
        if (c0672f != null) {
            c0672f.invokeOnCancellation(uVar, i);
        }
    }

    @Override // kotlinx.coroutines.channels.ChannelIterator
    public final /* synthetic */ Object next(Continuation continuation) {
        return io.ktor.utils.io.internal.t.n(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ChannelIterator
    public final Object next() throws Throwable {
        Object obj = this.f4322a;
        E1.h hVar = p.f4349p;
        if (obj == hVar) {
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
        this.f4322a = hVar;
        if (obj != p.f4345l) {
            return obj;
        }
        Throwable thL = this.c.l();
        int i = r3.v.f4721a;
        throw thL;
    }
}
