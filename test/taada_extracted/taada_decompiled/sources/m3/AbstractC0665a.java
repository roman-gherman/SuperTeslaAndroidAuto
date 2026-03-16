package m3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import r3.AbstractC0797A;

/* JADX INFO: renamed from: m3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0665a extends o0 implements Continuation, CoroutineScope {
    public final CoroutineContext c;

    public AbstractC0665a(CoroutineContext coroutineContext, boolean z6) {
        super(z6);
        s((Job) coroutineContext.get(Job.Key));
        this.c = coroutineContext.plus(this);
    }

    public void F(Throwable th, boolean z6) {
    }

    public void G(Object obj) {
    }

    public final void H(int i, AbstractC0665a abstractC0665a, Function2 function2) {
        int iB = f.s.b(i);
        if (iB == 0) {
            io.ktor.utils.io.b0.A(function2, abstractC0665a, this);
            return;
        }
        if (iB != 1) {
            if (iB == 2) {
                kotlin.jvm.internal.h.f(function2, "<this>");
                C5.f.J(C5.f.r(abstractC0665a, this, function2)).resumeWith(N1.m.f1129a);
                return;
            }
            if (iB != 3) {
                throw new C0.x();
            }
            try {
                CoroutineContext coroutineContext = this.c;
                Object objC = AbstractC0797A.c(coroutineContext, null);
                try {
                    kotlin.jvm.internal.z.d(2, function2);
                    Object objMo5invoke = function2.mo5invoke(abstractC0665a, this);
                    if (objMo5invoke != T1.a.f1304a) {
                        resumeWith(objMo5invoke);
                    }
                } finally {
                    AbstractC0797A.a(coroutineContext, objC);
                }
            } catch (Throwable th) {
                resumeWith(kotlin.reflect.l.n(th));
            }
        }
    }

    @Override // m3.o0
    public final String g() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.c;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.c;
    }

    @Override // m3.o0
    public final void r(C0.x xVar) {
        AbstractC0686u.a(this.c, xVar);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thA = N1.h.a(obj);
        if (thA != null) {
            obj = new C0677k(thA, false);
        }
        Object objU = u(obj);
        if (objU == AbstractC0690y.e) {
            return;
        }
        c(objU);
    }

    @Override // m3.o0
    public final void y(Object obj) {
        if (!(obj instanceof C0677k)) {
            G(obj);
        } else {
            C0677k c0677k = (C0677k) obj;
            F(c0677k.f4133a, C0677k.b.get(c0677k) != 0);
        }
    }
}
