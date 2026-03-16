package m3;

import androidx.core.location.LocationRequestCompat;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Delay;

/* JADX INFO: loaded from: classes2.dex */
public abstract class D {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(U1.c r4) {
        /*
            boolean r0 = r4 instanceof m3.C
            if (r0 == 0) goto L13
            r0 = r4
            m3.C r0 = (m3.C) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            m3.C r0 = new m3.C
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.f4104a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2b:
            kotlin.reflect.l.e0(r4)
            goto L47
        L2f:
            kotlin.reflect.l.e0(r4)
            r0.b = r3
            m3.f r4 = new m3.f
            kotlin.coroutines.Continuation r0 = C5.f.J(r0)
            r4.<init>(r3, r0)
            r4.initCancellability()
            java.lang.Object r4 = r4.m()
            if (r4 != r1) goto L47
            return
        L47:
            C0.x r4 = new C0.x
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.D.a(U1.c):void");
    }

    public static final Object b(long j6, U1.g gVar) {
        N1.m mVar = N1.m.f1129a;
        if (j6 > 0) {
            C0672f c0672f = new C0672f(1, C5.f.J(gVar));
            c0672f.initCancellability();
            if (j6 < LocationRequestCompat.PASSIVE_INTERVAL) {
                c(c0672f.e).scheduleResumeAfterDelay(j6, c0672f);
            }
            Object objM = c0672f.m();
            if (objM == T1.a.f1304a) {
                return objM;
            }
        }
        return mVar;
    }

    public static final Delay c(CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.Key);
        Delay delay = element instanceof Delay ? (Delay) element : null;
        return delay == null ? AbstractC0664A.f4102a : delay;
    }
}
