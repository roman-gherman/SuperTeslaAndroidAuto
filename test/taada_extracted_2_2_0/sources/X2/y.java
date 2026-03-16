package X2;

import G2.U;
import G2.Z;
import a3.AbstractC0162z;
import a3.F;
import a3.M;
import c4.AbstractC0246d;
import io.ktor.utils.io.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f1455a;
    public final y b;
    public final String c;
    public final String d;
    public final MemoizedFunctionToNullable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MemoizedFunctionToNullable f1456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f1457g;

    public y(i c, y yVar, List typeParameterProtos, String debugName, String str) {
        Map linkedHashMap;
        kotlin.jvm.internal.h.f(c, "c");
        kotlin.jvm.internal.h.f(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.h.f(debugName, "debugName");
        this.f1455a = c;
        this.b = yVar;
        this.c = debugName;
        this.d = str;
        g gVar = c.f1433a;
        this.e = gVar.f1418a.createMemoizedFunctionWithNullableValues(new v(this, 0));
        this.f1456f = gVar.f1418a.createMemoizedFunctionWithNullableValues(new v(this, 1));
        if (typeParameterProtos.isEmpty()) {
            linkedHashMap = kotlin.collections.v.f3806a;
        } else {
            linkedHashMap = new LinkedHashMap();
            Iterator it = typeParameterProtos.iterator();
            int i = 0;
            while (it.hasNext()) {
                Z z6 = (Z) it.next();
                linkedHashMap.put(Integer.valueOf(z6.d), new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.q(this.f1455a, z6, i));
                i++;
            }
        }
        this.f1457g = linkedHashMap;
    }

    public static F a(F f6, AbstractC0162z abstractC0162z) {
        k2.i iVarO = AbstractC0246d.O(f6);
        Annotations annotations = f6.getAnnotations();
        AbstractC0162z abstractC0162zR = b0.r(f6);
        List listM = b0.m(f6);
        List listN = kotlin.collections.m.N(b0.s(f6));
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(listN));
        Iterator it = listN.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeProjection) it.next()).getType());
        }
        return b0.i(iVarO, annotations, abstractC0162zR, listM, arrayList, abstractC0162z, true).g(f6.d());
    }

    public static final ArrayList d(U u, y yVar) {
        List argumentList = u.d;
        kotlin.jvm.internal.h.e(argumentList, "argumentList");
        U uR = kotlin.reflect.l.R(u, yVar.f1455a.d);
        Iterable iterableD = uR != null ? d(uR, yVar) : null;
        if (iterableD == null) {
            iterableD = kotlin.collections.u.f3805a;
        }
        return kotlin.collections.m.b0(iterableD, argumentList);
    }

    public static M e(List list, Annotations annotations, TypeConstructor typeConstructor, DeclarationDescriptor declarationDescriptor) {
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeAttributeTranslator) it.next()).toAttributes(annotations, typeConstructor, declarationDescriptor));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            kotlin.collections.s.F((Iterable) it2.next(), arrayList2);
        }
        M.b.getClass();
        return B.h.b(arrayList2);
    }

    public static final ClassDescriptor g(y yVar, U u, int i) {
        L2.b bVarW = kotlin.reflect.l.w(yVar.f1455a.b, i);
        k3.u uVarD = k3.m.D(k3.m.B(u, new v(yVar, 2)), x.f1454a);
        ArrayList arrayList = new ArrayList();
        Iterator it = uVarD.iterator();
        while (true) {
            k3.t tVar = (k3.t) it;
            if (!tVar.hasNext()) {
                break;
            }
            arrayList.add(tVar.next());
        }
        int iV = k3.m.v(k3.m.B(bVarW, w.f1453a));
        while (arrayList.size() < iV) {
            arrayList.add(0);
        }
        return yVar.f1455a.f1433a.f1424l.g(bVarW, arrayList);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    public final TypeParameterDescriptor b(int i) {
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) this.f1457g.get(Integer.valueOf(i));
        if (typeParameterDescriptor != null) {
            return typeParameterDescriptor;
        }
        y yVar = this.b;
        if (yVar != null) {
            return yVar.b(i);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a3.F c(G2.U r27, boolean r28) {
        /*
            Method dump skipped, instruction units count: 1045
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X2.y.c(G2.U, boolean):a3.F");
    }

    public final AbstractC0162z f(U proto) {
        kotlin.jvm.internal.h.f(proto, "proto");
        if (!((proto.c & 2) == 2)) {
            return c(proto, true);
        }
        i iVar = this.f1455a;
        String string = iVar.b.getString(proto.f493f);
        F fC = c(proto, true);
        I2.f fVar = iVar.d;
        int i = proto.c;
        U uA = (i & 4) == 4 ? proto.f494g : (i & 8) == 8 ? fVar.a(proto.f495h) : null;
        kotlin.jvm.internal.h.c(uA);
        return iVar.f1433a.f1422j.create(proto, string, fC, c(uA, true));
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        y yVar = this.b;
        if (yVar == null) {
            str = "";
        } else {
            str = ". Child of " + yVar.c;
        }
        sb.append(str);
        return sb.toString();
    }
}
