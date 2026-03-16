package m3;

import c4.AbstractC0246d;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public abstract class F extends t3.h {
    public int c;

    public F(int i) {
        super(0L, t3.k.f4838g);
        this.c = i;
    }

    public void a(Object obj, CancellationException cancellationException) {
    }

    public abstract Continuation b();

    public Throwable c(Object obj) {
        C0677k c0677k = obj instanceof C0677k ? (C0677k) obj : null;
        if (c0677k != null) {
            return c0677k.f4134a;
        }
        return null;
    }

    public Object d(Object obj) {
        return obj;
    }

    public final void e(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            AbstractC0246d.e(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.h.c(th);
        AbstractC0686u.a(b().getContext(), new N1.d("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object f();

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r13 = this;
            N1.m r0 = N1.m.f1129a
            t3.i r1 = r13.b
            kotlin.coroutines.Continuation r2 = r13.b()     // Catch: java.lang.Throwable -> L25
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            kotlin.jvm.internal.h.d(r2, r3)     // Catch: java.lang.Throwable -> L25
            r3.h r2 = (r3.h) r2     // Catch: java.lang.Throwable -> L25
            kotlin.coroutines.Continuation r3 = r2.e     // Catch: java.lang.Throwable -> L25
            java.lang.Object r2 = r2.f4710g     // Catch: java.lang.Throwable -> L25
            kotlin.coroutines.CoroutineContext r4 = r3.getContext()     // Catch: java.lang.Throwable -> L25
            java.lang.Object r2 = r3.AbstractC0797A.c(r4, r2)     // Catch: java.lang.Throwable -> L25
            E1.h r5 = r3.AbstractC0797A.f4696a     // Catch: java.lang.Throwable -> L25
            r6 = 0
            if (r2 == r5) goto L28
            m3.y0 r5 = m3.AbstractC0682p.c(r3, r4, r2)     // Catch: java.lang.Throwable -> L25
            goto L29
        L25:
            r2 = move-exception
            goto L9f
        L28:
            r5 = r6
        L29:
            kotlin.coroutines.CoroutineContext r7 = r3.getContext()     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r8 = r13.f()     // Catch: java.lang.Throwable -> L4c
            java.lang.Throwable r9 = r13.c(r8)     // Catch: java.lang.Throwable -> L4c
            if (r9 != 0) goto L4e
            int r10 = r13.c     // Catch: java.lang.Throwable -> L4c
            r11 = 1
            if (r10 == r11) goto L41
            r12 = 2
            if (r10 != r12) goto L40
            goto L41
        L40:
            r11 = 0
        L41:
            if (r11 == 0) goto L4e
            m3.a0 r10 = kotlinx.coroutines.Job.Key     // Catch: java.lang.Throwable -> L4c
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r10)     // Catch: java.lang.Throwable -> L4c
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7     // Catch: java.lang.Throwable -> L4c
            goto L4f
        L4c:
            r3 = move-exception
            goto L93
        L4e:
            r7 = r6
        L4f:
            if (r7 == 0) goto L66
            boolean r10 = r7.isActive()     // Catch: java.lang.Throwable -> L4c
            if (r10 != 0) goto L66
            java.util.concurrent.CancellationException r7 = r7.getCancellationException()     // Catch: java.lang.Throwable -> L4c
            r13.a(r8, r7)     // Catch: java.lang.Throwable -> L4c
            N1.g r7 = kotlin.reflect.l.n(r7)     // Catch: java.lang.Throwable -> L4c
            r3.resumeWith(r7)     // Catch: java.lang.Throwable -> L4c
            goto L77
        L66:
            if (r9 == 0) goto L70
            N1.g r7 = kotlin.reflect.l.n(r9)     // Catch: java.lang.Throwable -> L4c
            r3.resumeWith(r7)     // Catch: java.lang.Throwable -> L4c
            goto L77
        L70:
            java.lang.Object r7 = r13.d(r8)     // Catch: java.lang.Throwable -> L4c
            r3.resumeWith(r7)     // Catch: java.lang.Throwable -> L4c
        L77:
            if (r5 == 0) goto L7f
            boolean r3 = r5.I()     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L82
        L7f:
            r3.AbstractC0797A.a(r4, r2)     // Catch: java.lang.Throwable -> L25
        L82:
            r1.getClass()     // Catch: java.lang.Throwable -> L86
            goto L8b
        L86:
            r0 = move-exception
            N1.g r0 = kotlin.reflect.l.n(r0)
        L8b:
            java.lang.Throwable r0 = N1.h.a(r0)
            r13.e(r6, r0)
            goto Laf
        L93:
            if (r5 == 0) goto L9b
            boolean r5 = r5.I()     // Catch: java.lang.Throwable -> L25
            if (r5 == 0) goto L9e
        L9b:
            r3.AbstractC0797A.a(r4, r2)     // Catch: java.lang.Throwable -> L25
        L9e:
            throw r3     // Catch: java.lang.Throwable -> L25
        L9f:
            r1.getClass()     // Catch: java.lang.Throwable -> La3
            goto La8
        La3:
            r0 = move-exception
            N1.g r0 = kotlin.reflect.l.n(r0)
        La8:
            java.lang.Throwable r0 = N1.h.a(r0)
            r13.e(r2, r0)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.F.run():void");
    }
}
