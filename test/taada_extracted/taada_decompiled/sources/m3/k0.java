package m3;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 extends U1.f implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q0 f4134a;
    public r3.k b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ o0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(o0 o0Var, Continuation continuation) {
        super(2, continuation);
        this.e = o0Var;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        k0 k0Var = new k0(this.e, continuation);
        k0Var.d = obj;
        return k0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((k0) create((k3.l) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0062 -> B:25:0x0075). Please report as a decompilation issue!!! */
    @Override // U1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            T1.a r0 = T1.a.f1304a
            int r1 = r5.c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            r3.k r1 = r5.b
            m3.q0 r3 = r5.f4134a
            java.lang.Object r4 = r5.d
            k3.l r4 = (k3.l) r4
            kotlin.reflect.l.e0(r6)
            goto L75
        L18:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L20:
            kotlin.reflect.l.e0(r6)
            goto L7a
        L24:
            kotlin.reflect.l.e0(r6)
            java.lang.Object r6 = r5.d
            k3.l r6 = (k3.l) r6
            m3.o0 r1 = r5.e
            java.lang.Object r1 = r1.p()
            boolean r4 = r1 instanceof m3.C0675i
            if (r4 == 0) goto L3f
            m3.i r1 = (m3.C0675i) r1
            kotlinx.coroutines.ChildJob r1 = r1.e
            r5.c = r3
            r6.a(r1, r5)
            return r0
        L3f:
            boolean r3 = r1 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L7a
            kotlinx.coroutines.Incomplete r1 = (kotlinx.coroutines.Incomplete) r1
            m3.q0 r1 = r1.getList()
            if (r1 == 0) goto L7a
            java.lang.Object r3 = r1.c()
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.h.d(r3, r4)
            r3.k r3 = (r3.k) r3
            r4 = r3
            r3 = r1
            r1 = r4
            r4 = r6
        L5a:
            boolean r6 = r1.equals(r3)
            if (r6 != 0) goto L7a
            boolean r6 = r1 instanceof m3.C0675i
            if (r6 == 0) goto L75
            r6 = r1
            m3.i r6 = (m3.C0675i) r6
            r5.d = r4
            r5.f4134a = r3
            r5.b = r1
            r5.c = r2
            kotlinx.coroutines.ChildJob r6 = r6.e
            r4.a(r6, r5)
            return r0
        L75:
            r3.k r1 = r1.d()
            goto L5a
        L7a:
            N1.m r6 = N1.m.f1129a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.k0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
