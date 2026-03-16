package K2;

import G2.C0111k;
import G2.C0113m;
import G2.C0125z;
import G2.D;
import G2.H;
import G2.U;
import G2.d0;
import J2.k;
import J2.l;
import a.AbstractC0132a;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0608i f942a;

    static {
        C0608i c0608i = new C0608i();
        c0608i.a(l.f864a);
        c0608i.a(l.b);
        c0608i.a(l.c);
        c0608i.a(l.d);
        c0608i.a(l.e);
        c0608i.a(l.f865f);
        c0608i.a(l.f866g);
        c0608i.a(l.f867h);
        c0608i.a(l.i);
        c0608i.a(l.f868j);
        c0608i.a(l.f869k);
        c0608i.a(l.f870l);
        c0608i.a(l.f871m);
        c0608i.a(l.f872n);
        f942a = c0608i;
    }

    public static e a(C0113m proto, NameResolver nameResolver, I2.f typeTable) {
        String strV;
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(typeTable, "typeTable");
        o constructorSignature = l.f864a;
        kotlin.jvm.internal.h.e(constructorSignature, "constructorSignature");
        J2.d dVar = (J2.d) AbstractC0132a.D(proto, constructorSignature);
        String string = (dVar == null || (dVar.b & 1) != 1) ? MethodDescription.CONSTRUCTOR_INTERNAL_NAME : nameResolver.getString(dVar.c);
        if (dVar == null || (dVar.b & 2) != 2) {
            List<d0> list = proto.e;
            kotlin.jvm.internal.h.e(list, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(kotlin.collections.o.D(list));
            for (d0 it : list) {
                kotlin.jvm.internal.h.e(it, "it");
                String strE = e(kotlin.reflect.l.h0(it, typeTable), nameResolver);
                if (strE == null) {
                    return null;
                }
                arrayList.add(strE);
            }
            strV = m.V(arrayList, "", "(", ")V", null, 56);
        } else {
            strV = nameResolver.getString(dVar.d);
        }
        return new e(string, strV);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v2 java.lang.String, still in use, count: 2, list:
          (r4v2 java.lang.String) from 0x0052: IF  (r4v2 java.lang.String) == (null java.lang.String)  -> B:23:0x0054 A[HIDDEN]
          (r4v2 java.lang.String) from 0x0055: PHI (r4v3 java.lang.String) = (r4v2 java.lang.String), (r4v5 java.lang.String) binds: [B:22:0x0052, B:20:0x0043] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1118)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1118)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public static K2.d b(G2.H r4, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r5, I2.f r6, boolean r7) {
        /*
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.h.f(r4, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.h.f(r5, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.h.f(r6, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.o r0 = J2.l.d
            java.lang.String r1 = "propertySignature"
            kotlin.jvm.internal.h.e(r0, r1)
            java.lang.Object r0 = a.AbstractC0132a.D(r4, r0)
            J2.f r0 = (J2.f) r0
            r1 = 0
            if (r0 != 0) goto L20
            goto L54
        L20:
            int r2 = r0.b
            r3 = 1
            r2 = r2 & r3
            if (r2 != r3) goto L29
            J2.b r0 = r0.c
            goto L2a
        L29:
            r0 = r1
        L2a:
            if (r0 != 0) goto L2f
            if (r7 == 0) goto L2f
            goto L54
        L2f:
            if (r0 == 0) goto L39
            int r7 = r0.b
            r7 = r7 & r3
            if (r7 != r3) goto L39
            int r7 = r0.c
            goto L3b
        L39:
            int r7 = r4.f453f
        L3b:
            if (r0 == 0) goto L4a
            int r2 = r0.b
            r3 = 2
            r2 = r2 & r3
            if (r2 != r3) goto L4a
            int r4 = r0.d
            java.lang.String r4 = r5.getString(r4)
            goto L55
        L4a:
            G2.U r4 = kotlin.reflect.l.a0(r4, r6)
            java.lang.String r4 = e(r4, r5)
            if (r4 != 0) goto L55
        L54:
            return r1
        L55:
            K2.d r6 = new K2.d
            java.lang.String r5 = r5.getString(r7)
            r6.<init>(r5, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: K2.h.b(G2.H, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, I2.f, boolean):K2.d");
    }

    public static e c(C0125z proto, NameResolver nameResolver, I2.f typeTable) {
        String strConcat;
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(typeTable, "typeTable");
        o methodSignature = l.b;
        kotlin.jvm.internal.h.e(methodSignature, "methodSignature");
        J2.d dVar = (J2.d) AbstractC0132a.D(proto, methodSignature);
        int i = (dVar == null || (dVar.b & 1) != 1) ? proto.f688f : dVar.c;
        if (dVar == null || (dVar.b & 2) != 2) {
            List listZ = n.z(kotlin.reflect.l.X(proto, typeTable));
            List<d0> list = proto.f696o;
            kotlin.jvm.internal.h.e(list, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(kotlin.collections.o.D(list));
            for (d0 it : list) {
                kotlin.jvm.internal.h.e(it, "it");
                arrayList.add(kotlin.reflect.l.h0(it, typeTable));
            }
            ArrayList arrayListB0 = m.b0(arrayList, listZ);
            ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(arrayListB0));
            Iterator it2 = arrayListB0.iterator();
            while (it2.hasNext()) {
                String strE = e((U) it2.next(), nameResolver);
                if (strE == null) {
                    return null;
                }
                arrayList2.add(strE);
            }
            String strE2 = e(kotlin.reflect.l.Z(proto, typeTable), nameResolver);
            if (strE2 == null) {
                return null;
            }
            strConcat = m.V(arrayList2, "", "(", ")", null, 56).concat(strE2);
        } else {
            strConcat = nameResolver.getString(dVar.d);
        }
        return new e(nameResolver.getString(i), strConcat);
    }

    public static final boolean d(H proto) {
        kotlin.jvm.internal.h.f(proto, "proto");
        I2.b bVar = c.f937a;
        I2.b bVar2 = c.f937a;
        Object objD = proto.d(l.e);
        kotlin.jvm.internal.h.e(objD, "proto.getExtension(JvmProtoBuf.flags)");
        return bVar2.c(((Number) objD).intValue()).booleanValue();
    }

    public static String e(U u, NameResolver nameResolver) {
        if (u.i()) {
            return b.b(nameResolver.getQualifiedClassName(u.i));
        }
        return null;
    }

    public static final N1.e f(String[] strArr, String[] strings) {
        kotlin.jvm.internal.h.f(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.a(strArr));
        return new N1.e(g(byteArrayInputStream, strings), (C0111k) C0111k.f622K.parseFrom(byteArrayInputStream, f942a));
    }

    public static g g(ByteArrayInputStream byteArrayInputStream, String[] strArr) {
        k kVar = (k) k.f861h.parseDelimitedFrom(byteArrayInputStream, f942a);
        kotlin.jvm.internal.h.e(kVar, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new g(kVar, strArr);
    }

    public static final N1.e h(String[] data, String[] strings) {
        kotlin.jvm.internal.h.f(data, "data");
        kotlin.jvm.internal.h.f(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.a(data));
        return new N1.e(g(byteArrayInputStream, strings), (D) D.f428l.parseFrom(byteArrayInputStream, f942a));
    }
}
