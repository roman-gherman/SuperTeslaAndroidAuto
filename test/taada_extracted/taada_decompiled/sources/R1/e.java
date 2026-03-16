package r1;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(r1.b r6, java.nio.charset.Charset r7, U1.c r8) throws A.a {
        /*
            boolean r0 = r8 instanceof r1.d
            if (r0 == 0) goto L13
            r0 = r8
            r1.d r0 = (r1.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            r1.d r0 = new r1.d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.nio.charset.CharsetDecoder r6 = r0.f4689a
            kotlin.reflect.l.e0(r8)
            goto L82
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.reflect.l.e0(r8)
            java.lang.String r8 = "<this>"
            kotlin.jvm.internal.h.f(r6, r8)
            io.ktor.http.Headers r8 = r6.getHeaders()
            java.util.List r2 = u1.q.f4869a
            java.lang.String r2 = "Content-Type"
            java.lang.String r8 = r8.get(r2)
            r2 = 0
            if (r8 == 0) goto L4f
            u1.e r4 = u1.C0840e.f4861f
            u1.e r8 = io.ktor.utils.io.b0.x(r8)
            goto L50
        L4f:
            r8 = r2
        L50:
            if (r8 == 0) goto L56
            java.nio.charset.Charset r2 = io.ktor.utils.io.internal.t.d(r8)
        L56:
            if (r2 != 0) goto L59
            goto L5a
        L59:
            r7 = r2
        L5a:
            java.nio.charset.CharsetDecoder r7 = r7.newDecoder()
            h1.b r6 = r6.getCall()
            java.lang.Class<I1.d> r8 = I1.d.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.w.a(r8)
            java.lang.reflect.Type r4 = kotlin.reflect.l.F(r2)
            kotlin.jvm.internal.x r5 = kotlin.jvm.internal.w.f3817a
            kotlin.reflect.KClass r8 = r5.b(r8)
            F1.a r8 = kotlin.reflect.l.i0(r4, r8, r2)
            r0.f4689a = r7
            r0.c = r3
            java.lang.Object r8 = r6.a(r8, r0)
            if (r8 != r1) goto L81
            return r1
        L81:
            r6 = r7
        L82:
            if (r8 == 0) goto L90
            I1.d r8 = (I1.d) r8
            java.lang.String r7 = "decoder"
            kotlin.jvm.internal.h.e(r6, r7)
            java.lang.String r6 = c4.AbstractC0246d.F(r6, r8)
            return r6
        L90:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type io.ktor.utils.io.core.ByteReadPacket"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.e.a(r1.b, java.nio.charset.Charset, U1.c):java.lang.Object");
    }

    public static final void b(b bVar) {
        CoroutineContext.Element element = bVar.getCoroutineContext().get(Job.Key);
        kotlin.jvm.internal.h.c(element);
        ((CompletableJob) element).complete();
    }
}
