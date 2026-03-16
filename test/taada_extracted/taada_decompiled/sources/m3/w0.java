package m3;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 extends r3.t implements Runnable {
    public final long e;

    public w0(Continuation continuation) {
        super(continuation, continuation.getContext());
        this.e = 60000L;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r19 = this;
            r0 = r19
            kotlin.coroutines.CoroutineContext r1 = r0.c
            kotlinx.coroutines.Delay r1 = m3.D.c(r1)
            boolean r2 = r1 instanceof kotlinx.coroutines.DelayWithTimeoutDiagnostics
            if (r2 == 0) goto Lf
            kotlinx.coroutines.DelayWithTimeoutDiagnostics r1 = (kotlinx.coroutines.DelayWithTimeoutDiagnostics) r1
            goto L10
        Lf:
            r1 = 0
        L10:
            long r2 = r0.e
            if (r1 == 0) goto L83
            int r4 = l3.AbstractC0624a.f3974a
            l3.c r4 = l3.EnumC0626c.MILLISECONDS
            java.lang.String r5 = "unit"
            kotlin.jvm.internal.h.f(r4, r5)
            l3.c r5 = l3.EnumC0626c.NANOSECONDS
            java.lang.String r6 = "sourceUnit"
            kotlin.jvm.internal.h.f(r5, r6)
            java.util.concurrent.TimeUnit r4 = r4.f3976a
            r6 = 4611686018426999999(0x3ffffffffffa14bf, double:1.9999999999138678)
            java.util.concurrent.TimeUnit r5 = r5.f3976a
            long r6 = r4.convert(r6, r5)
            long r8 = -r6
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            r11 = 1
            if (r10 < 0) goto L39
            goto L56
        L39:
            long r13 = r6 % r11
            r15 = 0
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 < 0) goto L42
            goto L43
        L42:
            long r13 = r13 + r11
        L43:
            long r17 = r8 % r11
            int r10 = (r17 > r15 ? 1 : (r17 == r15 ? 0 : -1))
            if (r10 < 0) goto L4a
            goto L4c
        L4a:
            long r17 = r17 + r11
        L4c:
            long r13 = r13 - r17
            long r13 = r13 % r11
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 < 0) goto L54
            goto L55
        L54:
            long r13 = r13 + r11
        L55:
            long r6 = r6 - r13
        L56:
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            r9 = 1
            if (r8 > 0) goto L67
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 > 0) goto L67
            long r4 = r5.convert(r2, r4)
            long r4 = r4 << r9
            int r6 = l3.AbstractC0625b.f3975a
            goto L7d
        L67:
            long r13 = r4.convert(r2, r4)
            r15 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            r17 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            long r4 = E1.k.k(r13, r15, r17)
            long r4 = r4 << r9
            long r4 = r4 + r11
            int r6 = l3.AbstractC0625b.f3975a
        L7d:
            java.lang.String r1 = r1.m103timeoutMessageLRDsOJo(r4)
            if (r1 != 0) goto L96
        L83:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "Timed out waiting for "
            r1.<init>(r4)
            r1.append(r2)
            java.lang.String r2 = " ms"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L96:
            m3.v0 r2 = new m3.v0
            r2.<init>(r1, r0)
            r0.d(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.w0.run():void");
    }

    @Override // m3.o0
    public final String v() {
        return super.v() + "(timeMillis=" + this.e + ')';
    }
}
