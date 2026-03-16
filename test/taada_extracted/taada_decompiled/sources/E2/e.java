package E2;

import io.ktor.utils.io.internal.t;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final Set b = t.p(F2.a.CLASS);
    public static final Set c = kotlin.collections.j.N(new F2.a[]{F2.a.FILE_FACADE, F2.a.MULTIFILE_CLASS_PART});
    public static final K2.f d;
    public static final K2.f e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public X2.g f301a;

    static {
        new K2.f(new int[]{1, 1, 2}, false);
        d = new K2.f(new int[]{1, 1, 11}, false);
        e = new K2.f(new int[]{1, 1, 13}, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m a(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r12, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r13) {
        /*
            r11 = this;
            java.lang.String r1 = "Could not read data from "
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.h.f(r12, r0)
            java.lang.String r0 = "kotlinClass"
            kotlin.jvm.internal.h.f(r13, r0)
            F2.b r0 = r13.getClassHeader()
            java.lang.String[] r2 = r0.c
            if (r2 != 0) goto L16
            java.lang.String[] r2 = r0.d
        L16:
            r3 = 0
            if (r2 == 0) goto L24
            F2.a r0 = r0.f352a
            java.util.Set r4 = E2.e.c
            boolean r0 = r4.contains(r0)
            if (r0 == 0) goto L24
            goto L25
        L24:
            r2 = r3
        L25:
            if (r2 != 0) goto L28
            goto L71
        L28:
            F2.b r0 = r13.getClassHeader()
            java.lang.String[] r0 = r0.e
            if (r0 != 0) goto L31
            goto L71
        L31:
            N1.e r0 = K2.h.h(r2, r0)     // Catch: java.lang.Throwable -> L36 kotlin.reflect.jvm.internal.impl.protobuf.r -> L38
            goto L6f
        L36:
            r0 = move-exception
            goto L4f
        L38:
            r0 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L36
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.String r1 = r13.getLocation()     // Catch: java.lang.Throwable -> L36
            r4.append(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L36
            r2.<init>(r1, r0)     // Catch: java.lang.Throwable -> L36
            throw r2     // Catch: java.lang.Throwable -> L36
        L4f:
            X2.g r1 = r11.c()
            X2.h r1 = r1.c
            r1.getClass()
            F2.b r1 = r13.getClassHeader()
            K2.f r1 = r1.b
            X2.g r2 = r11.c()
            X2.h r2 = r2.c
            K2.f r2 = j3.p.g(r2)
            boolean r1 = r1.b(r2)
            if (r1 != 0) goto Lb4
            r0 = r3
        L6f:
            if (r0 != 0) goto L72
        L71:
            return r3
        L72:
            java.lang.Object r1 = r0.f1121a
            r5 = r1
            K2.g r5 = (K2.g) r5
            java.lang.Object r0 = r0.b
            r4 = r0
            G2.D r4 = (G2.D) r4
            E2.g r7 = new E2.g
            r11.d(r13)
            r11.e(r13)
            int r0 = r11.b(r13)
            r7.<init>(r13, r4, r5, r0)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m r2 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m
            F2.b r13 = r13.getClassHeader()
            K2.f r6 = r13.b
            X2.g r8 = r11.c()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "scope for "
            r13.<init>(r0)
            r13.append(r7)
            java.lang.String r0 = " in "
            r13.append(r0)
            r13.append(r12)
            java.lang.String r9 = r13.toString()
            E2.d r10 = E2.d.f300a
            r3 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r2
        Lb4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: E2.e.a(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass):kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m");
    }

    public final int b(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        c().c.getClass();
        int i = kotlinJvmBinaryClass.getClassHeader().f354g;
        if (((i & 64) != 0) && (i & 32) == 0) {
            return 2;
        }
        int i3 = kotlinJvmBinaryClass.getClassHeader().f354g;
        return ((i3 & 16) == 0 || (i3 & 32) != 0) ? 1 : 3;
    }

    public final X2.g c() {
        X2.g gVar = this.f301a;
        if (gVar != null) {
            return gVar;
        }
        kotlin.jvm.internal.h.n("components");
        throw null;
    }

    public final X2.j d(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        c().c.getClass();
        if (kotlinJvmBinaryClass.getClassHeader().b.b(j3.p.g(c().c))) {
            return null;
        }
        K2.f fVar = kotlinJvmBinaryClass.getClassHeader().b;
        K2.f fVar2 = K2.f.f938g;
        K2.f fVarG = j3.p.g(c().c);
        K2.f fVarG2 = j3.p.g(c().c);
        K2.f fVar3 = kotlinJvmBinaryClass.getClassHeader().b;
        fVarG2.getClass();
        K2.f fVar4 = fVar3.f940f ? fVar2 : K2.f.f939h;
        fVar4.getClass();
        int i = fVarG2.b;
        int i3 = fVar4.b;
        if (i3 > i || (i3 >= i && fVar4.c > fVarG2.c)) {
            fVarG2 = fVar4;
        }
        return new X2.j(fVar, fVar2, fVarG, fVarG2, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
    }

    public final boolean e(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        c().c.getClass();
        c().c.getClass();
        return (kotlinJvmBinaryClass.getClassHeader().f354g & 2) != 0 && kotlinJvmBinaryClass.getClassHeader().b.equals(d);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final X2.c f(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r6) {
        /*
            r5 = this;
            java.lang.String r0 = "Could not read data from "
            F2.b r1 = r6.getClassHeader()
            java.lang.String[] r2 = r1.c
            if (r2 != 0) goto Lc
            java.lang.String[] r2 = r1.d
        Lc:
            r3 = 0
            if (r2 == 0) goto L1a
            F2.a r1 = r1.f352a
            java.util.Set r4 = E2.e.b
            boolean r1 = r4.contains(r1)
            if (r1 == 0) goto L1a
            goto L1b
        L1a:
            r2 = r3
        L1b:
            if (r2 != 0) goto L1e
            goto L67
        L1e:
            F2.b r1 = r6.getClassHeader()
            java.lang.String[] r1 = r1.e
            if (r1 != 0) goto L27
            goto L67
        L27:
            N1.e r0 = K2.h.f(r2, r1)     // Catch: java.lang.Throwable -> L2c kotlin.reflect.jvm.internal.impl.protobuf.r -> L2e
            goto L65
        L2c:
            r0 = move-exception
            goto L45
        L2e:
            r1 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2c
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = r6.getLocation()     // Catch: java.lang.Throwable -> L2c
            r4.append(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L2c
            r2.<init>(r0, r1)     // Catch: java.lang.Throwable -> L2c
            throw r2     // Catch: java.lang.Throwable -> L2c
        L45:
            X2.g r1 = r5.c()
            X2.h r1 = r1.c
            r1.getClass()
            F2.b r1 = r6.getClassHeader()
            K2.f r1 = r1.b
            X2.g r2 = r5.c()
            X2.h r2 = r2.c
            K2.f r2 = j3.p.g(r2)
            boolean r1 = r1.b(r2)
            if (r1 != 0) goto L8b
            r0 = r3
        L65:
            if (r0 != 0) goto L68
        L67:
            return r3
        L68:
            java.lang.Object r1 = r0.f1121a
            K2.g r1 = (K2.g) r1
            java.lang.Object r0 = r0.b
            G2.k r0 = (G2.C0111k) r0
            E2.o r2 = new E2.o
            r5.d(r6)
            r5.e(r6)
            int r3 = r5.b(r6)
            r2.<init>(r6, r3)
            X2.c r3 = new X2.c
            F2.b r6 = r6.getClassHeader()
            K2.f r6 = r6.b
            r3.<init>(r1, r0, r6, r2)
            return r3
        L8b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: E2.e.f(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass):X2.c");
    }
}
