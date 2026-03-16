package j1;

/* JADX INFO: renamed from: j1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0561a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r8v0, types: [io.ktor.client.engine.HttpClientEngine, j1.e] */
    /* JADX WARN: Type inference failed for: r8v1, types: [io.ktor.client.engine.HttpClientEngine, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r8v4, types: [io.ktor.client.engine.HttpClientEngine] */
    /* JADX WARN: Type inference failed for: r9v2, types: [m3.B, m3.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(j1.e r8, q1.d r9, U1.c r10) {
        /*
            r0 = 0
            boolean r1 = r10 instanceof j1.C0562b
            if (r1 == 0) goto L14
            r1 = r10
            j1.b r1 = (j1.C0562b) r1
            int r2 = r1.d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L14
            int r2 = r2 - r3
            r1.d = r2
            goto L19
        L14:
            j1.b r1 = new j1.b
            r1.<init>(r10)
        L19:
            java.lang.Object r10 = r1.c
            T1.a r2 = T1.a.f1304a
            int r3 = r1.d
            r4 = 1
            r5 = 2
            if (r3 == 0) goto L3b
            if (r3 == r4) goto L33
            if (r3 != r5) goto L2b
            kotlin.reflect.l.e0(r10)
            return r10
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            q1.d r9 = r1.b
            io.ktor.client.engine.HttpClientEngine r8 = r1.f3646a
            kotlin.reflect.l.e0(r10)
            goto L7e
        L3b:
            kotlin.reflect.l.e0(r10)
            kotlinx.coroutines.CompletableJob r10 = r9.e
            r1.f3646a = r8
            r1.b = r9
            r1.d = r4
            m3.w r3 = j1.h.f3652a
            m3.d0 r3 = new m3.d0
            r3.<init>(r10)
            kotlin.coroutines.CoroutineContext r10 = r8.getCoroutineContext()
            kotlin.coroutines.CoroutineContext r10 = r10.plus(r3)
            m3.w r6 = j1.h.f3652a
            kotlin.coroutines.CoroutineContext r10 = r10.plus(r6)
            kotlin.coroutines.CoroutineContext r6 = r1.getContext()
            m3.a0 r7 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r7)
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            if (r6 != 0) goto L6a
            goto L7b
        L6a:
            j1.l r7 = new j1.l
            r7.<init>(r3, r0)
            kotlinx.coroutines.DisposableHandle r6 = m3.Z.a(r6, r7, r5)
            j1.k r7 = new j1.k
            r7.<init>(r6, r0)
            r3.invokeOnCompletion(r7)
        L7b:
            if (r10 != r2) goto L7e
            goto La7
        L7e:
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            j1.j r0 = new j1.j
            r0.<init>(r10)
            kotlin.coroutines.CoroutineContext r10 = r10.plus(r0)
            j1.c r0 = new j1.c
            r3 = 0
            r0.<init>(r8, r9, r3)
            kotlin.coroutines.CoroutineContext r8 = m3.AbstractC0682p.b(r8, r10)
            m3.B r9 = new m3.B
            r9.<init>(r8, r4)
            r9.H(r4, r9, r0)
            r1.f3646a = r3
            r1.b = r3
            r1.d = r5
            java.lang.Object r8 = r9.await(r1)
            if (r8 != r2) goto La8
        La7:
            return r2
        La8:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.AbstractC0561a.a(j1.e, q1.d, U1.c):java.lang.Object");
    }
}
