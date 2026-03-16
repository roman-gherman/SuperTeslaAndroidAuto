package p3;

import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x1.f f4487a;
    public final /* synthetic */ kotlin.jvm.internal.v b;

    public n(x1.f fVar, kotlin.jvm.internal.v vVar) {
        this.f4487a = fVar;
        this.b = vVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p3.m
            if (r0 == 0) goto L13
            r0 = r6
            p3.m r0 = (p3.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            p3.m r0 = new p3.m
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.e
            p3.n r0 = r0.f4486a
            kotlin.reflect.l.e0(r6)
            goto L46
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.reflect.l.e0(r6)
            r0.f4486a = r4
            r0.e = r5
            r0.c = r3
            x1.f r6 = r4.f4487a
            java.lang.Object r6 = r6.mo5invoke(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L51
            N1.m r5 = N1.m.f1129a
            return r5
        L51:
            kotlin.jvm.internal.v r6 = r0.b
            r6.f3816a = r5
            q3.a r5 = new q3.a
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.n.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
