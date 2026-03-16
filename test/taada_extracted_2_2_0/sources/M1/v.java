package m1;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static final C0632a d = new C0632a(2);
    public static final z1.a e = new z1.a("HttpResponseValidator");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4068a;
    public final List b;
    public final boolean c;

    public v(List list, List list2, boolean z6) {
        this.f4068a = list;
        this.b = list2;
        this.c = z6;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(m1.v r4, java.lang.Throwable r5, io.ktor.client.request.HttpRequest r6, U1.c r7) {
        /*
            r4.getClass()
            boolean r0 = r7 instanceof m1.t
            if (r0 == 0) goto L16
            r0 = r7
            m1.t r0 = (m1.t) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.c = r1
            goto L1b
        L16:
            m1.t r0 = new m1.t
            r0.<init>(r4, r7)
        L1b:
            java.lang.Object r7 = r0.f4066a
            int r0 = r0.c
            if (r0 == 0) goto L34
            r4 = 1
            r5 = 0
            if (r0 == r4) goto L28
            r4 = 2
            if (r0 != r4) goto L2c
        L28:
            kotlin.reflect.l.e0(r7)
            goto L5d
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.reflect.l.e0(r7)
            org.slf4j.Logger r7 = m1.x.f4070a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Processing exception "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = " for request "
            r0.append(r5)
            u1.D r5 = r6.getUrl()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r7.trace(r5)
            java.util.List r4 = r4.b
            java.util.Iterator r4 = r4.iterator()
            r5 = r4
        L5d:
            boolean r4 = r5.hasNext()
            if (r4 == 0) goto L6a
            java.lang.Object r4 = r5.next()
            io.ktor.client.plugins.HandlerWrapper r4 = (io.ktor.client.plugins.HandlerWrapper) r4
            goto L5d
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.v.a(m1.v, java.lang.Throwable, io.ktor.client.request.HttpRequest, U1.c):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(m1.v r5, r1.b r6, U1.c r7) {
        /*
            r5.getClass()
            boolean r0 = r7 instanceof m1.u
            if (r0 == 0) goto L16
            r0 = r7
            m1.u r0 = (m1.u) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.e = r1
            goto L1b
        L16:
            m1.u r0 = new m1.u
            r0.<init>(r5, r7)
        L1b:
            java.lang.Object r7 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.util.Iterator r5 = r0.b
            r1.b r6 = r0.f4067a
            kotlin.reflect.l.e0(r7)
            goto L5e
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.reflect.l.e0(r7)
            org.slf4j.Logger r7 = m1.x.f4070a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Validating response for request "
            r2.<init>(r4)
            h1.b r4 = r6.getCall()
            io.ktor.client.request.HttpRequest r4 = r4.c()
            u1.D r4 = r4.getUrl()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r7.trace(r2)
            java.util.List r5 = r5.f4068a
            java.util.Iterator r5 = r5.iterator()
        L5e:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L77
            java.lang.Object r7 = r5.next()
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.f4067a = r6
            r0.b = r5
            r0.e = r3
            java.lang.Object r7 = r7.mo5invoke(r6, r0)
            if (r7 != r1) goto L5e
            return r1
        L77:
            N1.m r5 = N1.m.f1129a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.v.b(m1.v, r1.b, U1.c):java.lang.Object");
    }
}
