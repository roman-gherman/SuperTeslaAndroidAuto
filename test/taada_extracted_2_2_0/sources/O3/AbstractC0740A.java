package o3;

/* JADX INFO: renamed from: o3.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0740A {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(kotlinx.coroutines.channels.ProducerScope r4, kotlin.jvm.functions.Function0 r5, U1.c r6) {
        /*
            boolean r0 = r6 instanceof o3.z
            if (r0 == 0) goto L13
            r0 = r6
            o3.z r0 = (o3.z) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            o3.z r0 = new o3.z
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.jvm.functions.Function0 r5 = r0.b
            kotlin.reflect.l.e0(r6)     // Catch: java.lang.Throwable -> L29
            goto L65
        L29:
            r4 = move-exception
            goto L6b
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.reflect.l.e0(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            m3.a0 r2 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            if (r6 != r4) goto L6f
            r0.f4358a = r4     // Catch: java.lang.Throwable -> L29
            r0.b = r5     // Catch: java.lang.Throwable -> L29
            r0.d = r3     // Catch: java.lang.Throwable -> L29
            m3.f r6 = new m3.f     // Catch: java.lang.Throwable -> L29
            kotlin.coroutines.Continuation r0 = C5.f.J(r0)     // Catch: java.lang.Throwable -> L29
            r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L29
            r6.initCancellability()     // Catch: java.lang.Throwable -> L29
            A2.a r0 = new A2.a     // Catch: java.lang.Throwable -> L29
            r2 = 27
            r0.<init>(r6, r2)     // Catch: java.lang.Throwable -> L29
            r4.invokeOnClose(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.m()     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L65
            return r1
        L65:
            r5.invoke()
            N1.m r4 = N1.m.f1129a
            return r4
        L6b:
            r5.invoke()
            throw r4
        L6f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.AbstractC0740A.a(kotlinx.coroutines.channels.ProducerScope, kotlin.jvm.functions.Function0, U1.c):java.lang.Object");
    }
}
