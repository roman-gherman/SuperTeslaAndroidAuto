package kotlin.reflect.jvm.internal.impl.load.kotlin;

import A2.C0019a;
import G2.H;
import X2.r;
import Z2.n;
import a3.AbstractC0162z;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import s2.C0813c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends f implements AnnotationAndConstantLoader {
    public final MemoizedFunctionToNotNull b;

    public d(n nVar, C0813c c0813c) {
        super(c0813c);
        this.b = nVar.createMemoizedFunction(new C0019a(this, 5));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(X2.r r9, G2.H r10, X2.a r11, a3.AbstractC0162z r12, kotlin.jvm.functions.Function2 r13) {
        /*
            r8 = this;
            I2.b r0 = I2.e.f765A
            int r1 = r10.d
            java.lang.Boolean r6 = r0.c(r1)
            boolean r7 = K2.h.d(r10)
            r4 = 1
            r5 = 1
            r2 = r8
            r3 = r9
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r9 = r2.d(r3, r4, r5, r6, r7)
            r0 = 0
            if (r9 != 0) goto L2e
            boolean r9 = r3 instanceof X2.p
            if (r9 == 0) goto L2d
            r9 = r3
            X2.p r9 = (X2.p) r9
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9 = r9.c
            boolean r1 = r9 instanceof E2.o
            if (r1 == 0) goto L27
            E2.o r9 = (E2.o) r9
            goto L28
        L27:
            r9 = r0
        L28:
            if (r9 == 0) goto L2d
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r9 = r9.f310a
            goto L2e
        L2d:
            r9 = r0
        L2e:
            if (r9 != 0) goto L31
            goto L5f
        L31:
            F2.b r1 = r9.getClassHeader()
            K2.f r1 = r1.b
            K2.f r4 = E2.e.e
            java.lang.String r5 = "version"
            kotlin.jvm.internal.h.f(r4, r5)
            int r5 = r4.b
            int r6 = r4.c
            int r4 = r4.d
            boolean r1 = r1.a(r5, r6, r4)
            I2.f r4 = r3.b
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r3 = r3.f1448a
            E2.p r10 = kotlin.reflect.jvm.internal.impl.load.kotlin.f.c(r10, r3, r4, r11, r1)
            if (r10 != 0) goto L53
            goto L5f
        L53:
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull r11 = r2.b
            java.lang.Object r9 = r11.invoke(r9)
            java.lang.Object r9 = r13.mo5invoke(r9, r10)
            if (r9 != 0) goto L60
        L5f:
            return r0
        L60:
            boolean r10 = k2.t.a(r12)
            if (r10 == 0) goto Lb8
            P2.g r9 = (P2.g) r9
            boolean r10 = r9 instanceof P2.d
            if (r10 == 0) goto L7c
            P2.x r10 = new P2.x
            P2.d r9 = (P2.d) r9
            java.lang.Object r9 = r9.f1217a
            java.lang.Number r9 = (java.lang.Number) r9
            byte r9 = r9.byteValue()
            r10.<init>(r9)
            return r10
        L7c:
            boolean r10 = r9 instanceof P2.u
            if (r10 == 0) goto L90
            P2.x r10 = new P2.x
            P2.u r9 = (P2.u) r9
            java.lang.Object r9 = r9.f1217a
            java.lang.Number r9 = (java.lang.Number) r9
            short r9 = r9.shortValue()
            r10.<init>(r9)
            return r10
        L90:
            boolean r10 = r9 instanceof P2.k
            if (r10 == 0) goto La4
            P2.y r10 = new P2.y
            P2.k r9 = (P2.k) r9
            java.lang.Object r9 = r9.f1217a
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r10.<init>(r9)
            return r10
        La4:
            boolean r10 = r9 instanceof P2.s
            if (r10 == 0) goto Lb8
            P2.x r10 = new P2.x
            P2.s r9 = (P2.s) r9
            java.lang.Object r9 = r9.f1217a
            java.lang.Number r9 = (java.lang.Number) r9
            long r11 = r9.longValue()
            r10.<init>(r11)
            return r10
        Lb8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.d.i(X2.r, G2.H, X2.a, a3.z, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public final Object loadAnnotationDefaultValue(r container, H proto, AbstractC0162z expectedType) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(expectedType, "expectedType");
        return i(container, proto, X2.a.c, expectedType, E2.b.f298a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public final Object loadPropertyConstant(r container, H proto, AbstractC0162z expectedType) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(expectedType, "expectedType");
        return i(container, proto, X2.a.b, expectedType, E2.c.f299a);
    }
}
