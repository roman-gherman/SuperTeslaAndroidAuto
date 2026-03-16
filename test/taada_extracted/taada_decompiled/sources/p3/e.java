package p3;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.FlowCollector;
import r3.AbstractC0797A;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4477a = 1;
    public final Object b;
    public final Object c;
    public final Object d;

    public e(f fVar, kotlin.jvm.internal.v vVar, FlowCollector flowCollector) {
        this.b = fVar;
        this.c = vVar;
        this.d = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            int r0 = r7.f4477a
            switch(r0) {
                case 0: goto L1b;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r7.b
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            java.lang.Object r1 = r7.c
            java.lang.Object r2 = r7.d
            q3.z r2 = (q3.z) r2
            java.lang.Object r8 = q3.AbstractC0786c.b(r0, r8, r1, r2, r9)
            T1.a r9 = T1.a.f1304a
            if (r8 != r9) goto L18
            goto L1a
        L18:
            N1.m r8 = N1.m.f1129a
        L1a:
            return r8
        L1b:
            boolean r0 = r9 instanceof p3.d
            if (r0 == 0) goto L2e
            r0 = r9
            p3.d r0 = (p3.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L2e
            int r1 = r1 - r2
            r0.c = r1
            goto L33
        L2e:
            p3.d r0 = new p3.d
            r0.<init>(r7, r9)
        L33:
            java.lang.Object r9 = r0.f4476a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            N1.m r3 = N1.m.f1129a
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 != r4) goto L45
            kotlin.reflect.l.e0(r9)
        L43:
            r1 = r3
            goto L7f
        L45:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4d:
            kotlin.reflect.l.e0(r9)
            java.lang.Object r9 = r7.b
            p3.f r9 = (p3.f) r9
            p3.k r2 = r9.b
            r2.getClass()
            java.lang.Object r2 = r7.c
            kotlin.jvm.internal.v r2 = (kotlin.jvm.internal.v) r2
            java.lang.Object r5 = r2.f3816a
            E1.h r6 = q3.AbstractC0786c.b
            if (r5 == r6) goto L71
            p3.j r9 = r9.c
            java.lang.Object r9 = r9.mo5invoke(r5, r8)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L43
        L71:
            r2.f3816a = r8
            r0.c = r4
            java.lang.Object r9 = r7.d
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r8 = r9.emit(r8, r0)
            if (r8 != r1) goto L43
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.e.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public e(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        this.b = coroutineContext;
        this.c = AbstractC0797A.b(coroutineContext);
        this.d = new q3.z(flowCollector, null);
    }
}
