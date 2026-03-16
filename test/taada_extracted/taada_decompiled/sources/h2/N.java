package h2;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class N extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3375a = 1;
    public final /* synthetic */ P b;
    public final /* synthetic */ S c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(P p5, S s3) {
        super(0);
        this.b = p5;
        this.c = s3;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke() {
        /*
            r4 = this;
            int r0 = r4.f3375a
            switch(r0) {
                case 0: goto L43;
                default: goto L5;
            }
        L5:
            h2.P r0 = r4.b
            r0.getClass()
            kotlin.reflect.KProperty[] r1 = h2.P.f3377h
            r2 = 0
            r1 = r1[r2]
            h2.q0 r0 = r0.c
            java.lang.Object r0 = r0.invoke()
            s2.e r0 = (s2.e) r0
            r1 = 0
            if (r0 == 0) goto L25
            F2.b r0 = r0.b
            F2.a r2 = F2.a.MULTIFILE_CLASS_PART
            F2.a r3 = r0.f352a
            if (r3 != r2) goto L25
            java.lang.String r0 = r0.f353f
            goto L26
        L25:
            r0 = r1
        L26:
            if (r0 == 0) goto L42
            int r2 = r0.length()
            if (r2 <= 0) goto L42
            h2.S r1 = r4.c
            java.lang.Class r1 = r1.b
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r2 = 46
            r3 = 47
            java.lang.String r0 = kotlin.text.r.A(r0, r3, r2)
            java.lang.Class r1 = r1.loadClass(r0)
        L42:
            return r1
        L43:
            h2.P r0 = r4.b
            r0.getClass()
            kotlin.reflect.KProperty[] r1 = h2.P.f3377h
            r2 = 1
            r1 = r1[r2]
            h2.q0 r0 = r0.d
            java.lang.Object r0 = r0.invoke()
            java.lang.String r1 = "<get-scope>(...)"
            kotlin.jvm.internal.h.e(r0, r1)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) r0
            h2.S r1 = r4.c
            java.util.List r0 = r1.f(r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.N.invoke():java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(S s3, P p5) {
        super(0);
        this.c = s3;
        this.b = p5;
    }
}
