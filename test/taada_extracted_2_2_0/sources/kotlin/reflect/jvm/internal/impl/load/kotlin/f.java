package kotlin.reflect.jvm.internal.impl.load.kotlin;

import E2.p;
import G2.C0108h;
import G2.C0113m;
import G2.C0120u;
import G2.C0125z;
import G2.EnumC0110j;
import G2.H;
import G2.U;
import G2.Z;
import X2.q;
import X2.r;
import a.AbstractC0132a;
import com.android.multidex.ClassPathElement;
import j2.AbstractC0565b;
import j2.C0564a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader;
import net.bytebuddy.pool.TypePool;
import s2.C0813c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements AnnotationLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0813c f3834a;

    public f(C0813c c0813c) {
        this.f3834a = c0813c;
    }

    public static /* synthetic */ List b(f fVar, r rVar, p pVar, Boolean bool, boolean z6, int i) {
        boolean z7 = (i & 4) == 0;
        if ((i & 16) != 0) {
            bool = null;
        }
        return fVar.a(rVar, pVar, z7, false, bool, (i & 32) != 0 ? false : z6);
    }

    public static p c(MessageLite messageLite, NameResolver nameResolver, I2.f fVar, X2.a aVar, boolean z6) {
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        if (messageLite instanceof C0113m) {
            C0608i c0608i = K2.h.f942a;
            K2.e eVarA = K2.h.a((C0113m) messageLite, nameResolver, fVar);
            if (eVarA != null) {
                return kotlin.reflect.l.v(eVarA);
            }
        } else if (messageLite instanceof C0125z) {
            C0608i c0608i2 = K2.h.f942a;
            K2.e eVarC = K2.h.c((C0125z) messageLite, nameResolver, fVar);
            if (eVarC != null) {
                return kotlin.reflect.l.v(eVarC);
            }
        } else if (messageLite instanceof H) {
            o propertySignature = J2.l.d;
            kotlin.jvm.internal.h.e(propertySignature, "propertySignature");
            J2.f fVar2 = (J2.f) AbstractC0132a.D((AbstractC0612m) messageLite, propertySignature);
            if (fVar2 != null) {
                int iOrdinal = aVar.ordinal();
                if (iOrdinal == 1) {
                    return E1.k.M((H) messageLite, nameResolver, fVar, true, true, z6);
                }
                if (iOrdinal == 2) {
                    if ((fVar2.b & 4) != 4) {
                        return null;
                    }
                    J2.d dVar = fVar2.e;
                    kotlin.jvm.internal.h.e(dVar, "signature.getter");
                    String name = nameResolver.getString(dVar.c);
                    String desc = nameResolver.getString(dVar.d);
                    kotlin.jvm.internal.h.f(name, "name");
                    kotlin.jvm.internal.h.f(desc, "desc");
                    return new p(name.concat(desc));
                }
                if (iOrdinal != 3 || (fVar2.b & 8) != 8) {
                    return null;
                }
                J2.d dVar2 = fVar2.f844f;
                kotlin.jvm.internal.h.e(dVar2, "signature.setter");
                String name2 = nameResolver.getString(dVar2.c);
                String desc2 = nameResolver.getString(dVar2.d);
                kotlin.jvm.internal.h.f(name2, "name");
                kotlin.jvm.internal.h.f(desc2, "desc");
                return new p(name2.concat(desc2));
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List a(X2.r r7, E2.p r8, boolean r9, boolean r10, java.lang.Boolean r11, boolean r12) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r7 = r0.d(r1, r2, r3, r4, r5)
            if (r7 != 0) goto L24
            boolean r7 = r1 instanceof X2.p
            r9 = 0
            if (r7 == 0) goto L23
            r7 = r1
            X2.p r7 = (X2.p) r7
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = r7.c
            boolean r10 = r7 instanceof E2.o
            if (r10 == 0) goto L1d
            E2.o r7 = (E2.o) r7
            goto L1e
        L1d:
            r7 = r9
        L1e:
            if (r7 == 0) goto L23
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r7 = r7.f310a
            goto L24
        L23:
            r7 = r9
        L24:
            kotlin.collections.u r9 = kotlin.collections.u.f3805a
            if (r7 != 0) goto L29
            goto L3e
        L29:
            r10 = r0
            kotlin.reflect.jvm.internal.impl.load.kotlin.d r10 = (kotlin.reflect.jvm.internal.impl.load.kotlin.d) r10
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull r10 = r10.b
            java.lang.Object r7 = r10.invoke(r7)
            E2.a r7 = (E2.a) r7
            java.util.HashMap r7 = r7.f297a
            java.lang.Object r7 = r7.get(r8)
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto L3f
        L3e:
            return r9
        L3f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.f.a(X2.r, E2.p, boolean, boolean, java.lang.Boolean, boolean):java.util.List");
    }

    public final KotlinJvmBinaryClass d(r rVar, boolean z6, boolean z7, Boolean bool, boolean z8) {
        X2.p pVar;
        EnumC0110j enumC0110j = EnumC0110j.INTERFACE;
        C0813c c0813c = this.f3834a;
        SourceElement sourceElement = rVar.c;
        if (z6) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + rVar + ')').toString());
            }
            if (rVar instanceof X2.p) {
                X2.p pVar2 = (X2.p) rVar;
                if (pVar2.f1446g == enumC0110j) {
                    return AbstractC0132a.u(c0813c, pVar2.f1445f.d(L2.f.e("DefaultImpls")), ((l) this).f3841f);
                }
            }
            if (bool.booleanValue() && (rVar instanceof q)) {
                E2.g gVar = sourceElement instanceof E2.g ? (E2.g) sourceElement : null;
                S2.a aVar = gVar != null ? gVar.b : null;
                if (aVar != null) {
                    String strE = aVar.e();
                    kotlin.jvm.internal.h.e(strE, "facadeClassName.internalName");
                    return AbstractC0132a.u(c0813c, L2.b.j(new L2.c(kotlin.text.r.A(strE, ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH))), ((l) this).f3841f);
                }
            }
        }
        if (z7 && (rVar instanceof X2.p)) {
            X2.p pVar3 = (X2.p) rVar;
            if (pVar3.f1446g == EnumC0110j.COMPANION_OBJECT && (pVar = pVar3.e) != null) {
                EnumC0110j enumC0110j2 = EnumC0110j.CLASS;
                EnumC0110j enumC0110j3 = pVar.f1446g;
                if (enumC0110j3 == enumC0110j2 || enumC0110j3 == EnumC0110j.ENUM_CLASS || (z8 && (enumC0110j3 == enumC0110j || enumC0110j3 == EnumC0110j.ANNOTATION_CLASS))) {
                    SourceElement sourceElement2 = pVar.c;
                    E2.o oVar = sourceElement2 instanceof E2.o ? (E2.o) sourceElement2 : null;
                    if (oVar != null) {
                        return oVar.f310a;
                    }
                    return null;
                }
            }
        }
        if (!(rVar instanceof q) || !(sourceElement instanceof E2.g)) {
            return null;
        }
        kotlin.jvm.internal.h.d(sourceElement, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        E2.g gVar2 = (E2.g) sourceElement;
        KotlinJvmBinaryClass kotlinJvmBinaryClass = gVar2.c;
        return kotlinJvmBinaryClass == null ? AbstractC0132a.u(c0813c, gVar2.a(), ((l) this).f3841f) : kotlinJvmBinaryClass;
    }

    public final boolean e(L2.b bVar) throws InvocationTargetException {
        if (bVar.f() == null || !kotlin.jvm.internal.h.a(bVar.i().b(), "Container")) {
            return false;
        }
        KotlinJvmBinaryClass kotlinJvmBinaryClassU = AbstractC0132a.u(this.f3834a, bVar, ((l) this).f3841f);
        if (kotlinJvmBinaryClassU == null) {
            return false;
        }
        LinkedHashSet linkedHashSet = AbstractC0565b.f3660a;
        s sVar = new s();
        ((s2.e) kotlinJvmBinaryClassU).loadClassAnnotations(new C0564a(sVar), null);
        return sVar.f3814a;
    }

    public abstract k f(L2.b bVar, SourceElement sourceElement, List list);

    public final k g(L2.b bVar, SourceElement sourceElement, List result) {
        kotlin.jvm.internal.h.f(result, "result");
        if (AbstractC0565b.f3660a.contains(bVar)) {
            return null;
        }
        return f(bVar, sourceElement, result);
    }

    public final List h(r rVar, H h3, int i) {
        Boolean boolC = I2.e.f765A.c(h3.d);
        boolean zD = K2.h.d(h3);
        u uVar = u.f3805a;
        I2.f fVar = rVar.b;
        NameResolver nameResolver = rVar.f1448a;
        if (i == 1) {
            p pVarM = E1.k.M(h3, nameResolver, fVar, (40 & 8) == 0, (40 & 16) == 0, true);
            if (pVarM != null) {
                return b(this, rVar, pVarM, boolC, zD, 8);
            }
        } else {
            p pVarM2 = E1.k.M(h3, nameResolver, fVar, (40 & 8) == 0, (40 & 16) == 0, true);
            if (pVarM2 != null) {
                if (kotlin.text.i.D(pVarM2.f311a, "$delegate", false) == (i == 3)) {
                    return a(rVar, pVarM2, true, true, boolC, zD);
                }
            }
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public final List loadCallableAnnotations(r container, MessageLite proto, X2.a kind) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(kind, "kind");
        if (kind == X2.a.b) {
            return h(container, (H) proto, 1);
        }
        p pVarC = c(proto, container.f1448a, container.b, kind, false);
        return pVarC == null ? u.f3805a : b(this, container, pVarC, null, false, 60);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public final List loadClassAnnotations(X2.p container) {
        kotlin.jvm.internal.h.f(container, "container");
        SourceElement sourceElement = container.c;
        E2.o oVar = sourceElement instanceof E2.o ? (E2.o) sourceElement : null;
        KotlinJvmBinaryClass kotlinJvmBinaryClass = oVar != null ? oVar.f310a : null;
        if (kotlinJvmBinaryClass != null) {
            ArrayList arrayList = new ArrayList(1);
            kotlinJvmBinaryClass.loadClassAnnotations(new e(this, arrayList), null);
            return arrayList;
        }
        throw new IllegalStateException(("Class for loading annotations is not found: " + container.f1445f.b()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public final List loadEnumEntryAnnotations(r container, C0120u proto) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        String name = container.f1448a.getString(proto.d);
        String desc = K2.b.b(((X2.p) container).f1445f.c());
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(desc, "desc");
        return b(this, container, new p(name + '#' + desc), null, false, 60);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public final List loadExtensionReceiverParameterAnnotations(r container, MessageLite proto, X2.a kind) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(kind, "kind");
        p pVarC = c(proto, container.f1448a, container.b, kind, false);
        return pVarC != null ? b(this, container, new p(B2.b.h(new StringBuilder(), pVarC.f311a, "@0")), null, false, 60) : u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public final List loadPropertyBackingFieldAnnotations(r container, H proto) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        return h(container, proto, 2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public final List loadPropertyDelegateFieldAnnotations(r container, H proto) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        return h(container, proto, 3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public final List loadTypeAnnotations(U proto, NameResolver nameResolver) {
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        Object objD = proto.d(J2.l.f865f);
        kotlin.jvm.internal.h.e(objD, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<C0108h> iterable = (Iterable) objD;
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(iterable));
        for (C0108h it : iterable) {
            kotlin.jvm.internal.h.e(it, "it");
            arrayList.add(((l) this).e.c(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public final List loadTypeParameterAnnotations(Z proto, NameResolver nameResolver) {
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        Object objD = proto.d(J2.l.f867h);
        kotlin.jvm.internal.h.e(objD, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<C0108h> iterable = (Iterable) objD;
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(iterable));
        for (C0108h it : iterable) {
            kotlin.jvm.internal.h.e(it, "it");
            arrayList.add(((l) this).e.c(it, nameResolver));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List loadValueParameterAnnotations(X2.r r8, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r9, X2.a r10, int r11, G2.d0 r12) {
        /*
            r7 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.h.f(r8, r0)
            java.lang.String r0 = "callableProto"
            kotlin.jvm.internal.h.f(r9, r0)
            java.lang.String r0 = "kind"
            kotlin.jvm.internal.h.f(r10, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.h.f(r12, r0)
            I2.f r12 = r8.b
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r8.f1448a
            r1 = 0
            E2.p r10 = c(r9, r0, r12, r10, r1)
            if (r10 == 0) goto L98
            boolean r12 = r9 instanceof G2.C0125z
            r0 = 64
            r2 = 32
            r3 = 1
            if (r12 == 0) goto L36
            G2.z r9 = (G2.C0125z) r9
            int r9 = r9.c
            r12 = r9 & 32
            if (r12 != r2) goto L31
            goto L34
        L31:
            r9 = r9 & r0
            if (r9 != r0) goto L5b
        L34:
            r1 = r3
            goto L5b
        L36:
            boolean r12 = r9 instanceof G2.H
            if (r12 == 0) goto L47
            G2.H r9 = (G2.H) r9
            int r9 = r9.c
            r12 = r9 & 32
            if (r12 != r2) goto L43
            goto L46
        L43:
            r9 = r9 & r0
            if (r9 != r0) goto L5b
        L46:
            goto L34
        L47:
            boolean r12 = r9 instanceof G2.C0113m
            if (r12 == 0) goto L80
            r9 = r8
            X2.p r9 = (X2.p) r9
            G2.j r12 = G2.EnumC0110j.ENUM_CLASS
            G2.j r2 = r9.f1446g
            if (r2 != r12) goto L56
            r1 = 2
            goto L5b
        L56:
            boolean r9 = r9.f1447h
            if (r9 == 0) goto L5b
            goto L34
        L5b:
            int r11 = r11 + r1
            E2.p r3 = new E2.p
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r10.f311a
            r9.append(r10)
            r9.append(r0)
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            r3.<init>(r9)
            r4 = 0
            r5 = 0
            r6 = 60
            r1 = r7
            r2 = r8
            java.util.List r8 = b(r1, r2, r3, r4, r5, r6)
            return r8
        L80:
            java.lang.UnsupportedOperationException r8 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Unsupported message: "
            r10.<init>(r11)
            java.lang.Class r9 = r9.getClass()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L98:
            kotlin.collections.u r8 = kotlin.collections.u.f3805a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.f.loadValueParameterAnnotations(X2.r, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, X2.a, int, G2.d0):java.util.List");
    }
}
