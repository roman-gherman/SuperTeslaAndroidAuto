package q3;

import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o3.n f4658a;
    public final /* synthetic */ int b;

    public l(o3.n nVar, int i) {
        this.f4658a = nVar;
        this.b = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        if (m3.AbstractC0690y.o(r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof q3.k
            if (r0 == 0) goto L13
            r0 = r7
            q3.k r0 = (q3.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            q3.k r0 = new q3.k
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f4657a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.reflect.l.e0(r7)
            goto L54
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.reflect.l.e0(r7)
            goto L4b
        L36:
            kotlin.reflect.l.e0(r7)
            kotlin.collections.x r7 = new kotlin.collections.x
            int r2 = r5.b
            r7.<init>(r2, r6)
            r0.c = r4
            o3.n r6 = r5.f4658a
            java.lang.Object r6 = r6.send(r7, r0)
            if (r6 != r1) goto L4b
            goto L53
        L4b:
            r0.c = r3
            java.lang.Object r6 = m3.AbstractC0690y.o(r0)
            if (r6 != r1) goto L54
        L53:
            return r1
        L54:
            N1.m r6 = N1.m.f1129a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.l.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
