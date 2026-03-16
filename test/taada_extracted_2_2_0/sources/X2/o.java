package X2;

import G2.A;
import G2.B;
import G2.C0113m;
import G2.C0125z;
import G2.H;
import G2.U;
import G2.d0;
import G2.k0;
import a3.AbstractC0162z;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import n2.EnumC0709a;
import q2.S;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f1444a;
    public final B.h b;

    public o(i c) {
        kotlin.jvm.internal.h.f(c, "c");
        this.f1444a = c;
        g gVar = c.f1433a;
        this.b = new B.h(gVar.b, gVar.f1424l);
    }

    public final r a(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            L2.c fqName = ((PackageFragmentDescriptor) declarationDescriptor).getFqName();
            i iVar = this.f1444a;
            return new q(fqName, iVar.b, iVar.d, iVar.f1435g);
        }
        if (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) {
            return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) declarationDescriptor).f3909w;
        }
        return null;
    }

    public final Annotations b(AbstractC0612m abstractC0612m, int i, a aVar) {
        if (I2.e.c.c(i).booleanValue()) {
            return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.r(this.f1444a.f1433a.f1418a, new k(this, abstractC0612m, aVar, 0));
        }
        Annotations.Companion.getClass();
        return o2.f.b;
    }

    public final Annotations c(H h3, boolean z6) {
        if (I2.e.c.c(h3.d).booleanValue()) {
            return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.r(this.f1444a.f1433a.f1418a, new l(this, z6, h3));
        }
        Annotations.Companion.getClass();
        return o2.f.b;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b d(C0113m c0113m, boolean z6) {
        i iVar = this.f1444a;
        DeclarationDescriptor declarationDescriptor = iVar.c;
        kotlin.jvm.internal.h.d(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        int i = c0113m.d;
        a aVar = a.f1412a;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b(classDescriptor, null, b(c0113m, i, aVar), z6, EnumC0709a.f4227a, c0113m, iVar.b, iVar.d, iVar.e, iVar.f1435g, null);
        i iVarA = iVar.a(bVar, kotlin.collections.u.f3805a, iVar.b, iVar.d, iVar.e, iVar.f1434f);
        List list = c0113m.e;
        kotlin.jvm.internal.h.e(list, "proto.valueParameterList");
        bVar.t(iVarA.i.g(list, c0113m, aVar), C5.f.s((k0) I2.e.d.c(c0113m.d)));
        bVar.q(classDescriptor.getDefaultType());
        bVar.f4639r = classDescriptor.isExpect();
        bVar.f4643w = !I2.e.f781n.c(c0113m.d).booleanValue();
        return bVar;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.o e(C0125z proto) {
        int i;
        Annotations aVar;
        AbstractC0162z abstractC0162zF;
        kotlin.jvm.internal.h.f(proto, "proto");
        if ((proto.c & 1) == 1) {
            i = proto.d;
        } else {
            int i3 = proto.e;
            i = ((i3 >> 8) << 6) + (i3 & 63);
        }
        int i4 = i;
        a aVar2 = a.f1412a;
        Annotations annotationsB = b(proto, i4, aVar2);
        int i5 = proto.c;
        int i6 = i5 & 32;
        o2.e eVar = o2.f.b;
        i iVar = this.f1444a;
        if (i6 == 32 || (i5 & 64) == 64) {
            aVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.a(iVar.f1433a.f1418a, new k(this, proto, aVar2, 1));
        } else {
            Annotations.Companion.getClass();
            aVar = eVar;
        }
        L2.c cVarG = R2.e.g(iVar.c);
        int i7 = proto.f688f;
        NameResolver nameResolver = iVar.b;
        I2.g gVar = cVarG.c(kotlin.reflect.l.I(nameResolver, i7)).equals(u.f1451a) ? I2.g.b : iVar.e;
        L2.f fVarI = kotlin.reflect.l.I(nameResolver, proto.f688f);
        EnumC0709a enumC0709aU = C5.f.U((A) I2.e.f782o.c(i4));
        I2.f fVar = iVar.d;
        Annotations annotations = aVar;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.o oVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.o(iVar.c, null, annotationsB, fVarI, enumC0709aU, proto, iVar.b, fVar, gVar, iVar.f1435g, null);
        List list = proto.i;
        kotlin.jvm.internal.h.e(list, "proto.typeParameterList");
        i iVarA = iVar.a(oVar, list, iVar.b, iVar.d, iVar.e, iVar.f1434f);
        U uX = kotlin.reflect.l.X(proto, fVar);
        y yVar = iVarA.f1436h;
        q2.w wVarK = (uX == null || (abstractC0162zF = yVar.f(uX)) == null) ? null : N2.q.k(oVar, abstractC0162zF, annotations);
        DeclarationDescriptor declarationDescriptor = iVar.c;
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        ReceiverParameterDescriptor thisAsReceiverParameter = classDescriptor != null ? classDescriptor.getThisAsReceiverParameter() : null;
        List list2 = proto.f693l;
        if (list2.isEmpty()) {
            list2 = null;
        }
        if (list2 == null) {
            List<Integer> contextReceiverTypeIdList = proto.f694m;
            kotlin.jvm.internal.h.e(contextReceiverTypeIdList, "contextReceiverTypeIdList");
            ArrayList arrayList = new ArrayList(kotlin.collections.o.D(contextReceiverTypeIdList));
            for (Integer it : contextReceiverTypeIdList) {
                kotlin.jvm.internal.h.e(it, "it");
                arrayList.add(fVar.a(it.intValue()));
            }
            list2 = arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        int i8 = 0;
        for (Object obj : list2) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                kotlin.collections.n.C();
                throw null;
            }
            AbstractC0162z abstractC0162zF2 = yVar.f((U) obj);
            Annotations.Companion.getClass();
            q2.w wVarE = N2.q.e(oVar, abstractC0162zF2, null, eVar, i8);
            if (wVarE != null) {
                arrayList2.add(wVarE);
            }
            i8 = i9;
        }
        List listO0 = kotlin.collections.m.o0(yVar.f1457g.values());
        List list3 = proto.f696o;
        kotlin.jvm.internal.h.e(list3, "proto.valueParameterList");
        oVar.u(wVarK, thisAsReceiverParameter, arrayList2, listO0, iVarA.i.g(list3, proto, aVar2), yVar.f(kotlin.reflect.l.Z(proto, fVar)), h.b((B) I2.e.e.c(i4)), C5.f.s((k0) I2.e.d.c(i4)), kotlin.collections.v.f3806a);
        oVar.f4635m = I2.e.f783p.c(i4).booleanValue();
        oVar.f4636n = I2.e.q.c(i4).booleanValue();
        oVar.f4637o = I2.e.f786t.c(i4).booleanValue();
        oVar.f4638p = I2.e.f784r.c(i4).booleanValue();
        oVar.q = I2.e.f785s.c(i4).booleanValue();
        oVar.f4642v = I2.e.u.c(i4).booleanValue();
        oVar.f4639r = I2.e.f787v.c(i4).booleanValue();
        oVar.f4643w = !I2.e.f788w.c(i4).booleanValue();
        iVar.f1433a.f1425m.deserializeContractFromFunction(proto, oVar, fVar, yVar);
        return oVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0105  */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12, types: [q2.K] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v26, types: [kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue] */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n, q2.I, q2.U, q2.o] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n f(G2.H r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 980
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X2.o.f(G2.H):kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n");
    }

    public final List g(List list, AbstractC0612m abstractC0612m, a aVar) {
        Annotations rVar;
        o oVar = this;
        i iVar = oVar.f1444a;
        DeclarationDescriptor declarationDescriptor = iVar.c;
        kotlin.jvm.internal.h.d(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor callableDescriptor = (CallableDescriptor) declarationDescriptor;
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        kotlin.jvm.internal.h.e(containingDeclaration, "callableDescriptor.containingDeclaration");
        r rVarA = oVar.a(containingDeclaration);
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(list));
        int i = 0;
        for (Object obj : list) {
            int i3 = i + 1;
            AbstractC0162z abstractC0162zF = null;
            if (i < 0) {
                kotlin.collections.n.C();
                throw null;
            }
            d0 d0Var = (d0) obj;
            int i4 = (d0Var.c & 1) == 1 ? d0Var.d : 0;
            if (rVarA == null || !I2.e.c.c(i4).booleanValue()) {
                Annotations.Companion.getClass();
                rVar = o2.f.b;
            } else {
                rVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.r(iVar.f1433a.f1418a, new n(oVar, rVarA, abstractC0612m, aVar, i, d0Var));
            }
            L2.f fVarI = kotlin.reflect.l.I(iVar.b, d0Var.e);
            I2.f fVar = iVar.d;
            U uH0 = kotlin.reflect.l.h0(d0Var, fVar);
            y yVar = iVar.f1436h;
            AbstractC0162z abstractC0162zF2 = yVar.f(uH0);
            boolean zBooleanValue = I2.e.f769G.c(i4).booleanValue();
            boolean zBooleanValue2 = I2.e.H.c(i4).booleanValue();
            boolean zBooleanValue3 = I2.e.I.c(i4).booleanValue();
            int i5 = d0Var.c;
            U uA = (i5 & 16) == 16 ? d0Var.f565h : (i5 & 32) == 32 ? fVar.a(d0Var.i) : null;
            if (uA != null) {
                abstractC0162zF = yVar.f(uA);
            }
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            kotlin.jvm.internal.h.e(NO_SOURCE, "NO_SOURCE");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new S(callableDescriptor, null, i, rVar, fVarI, abstractC0162zF2, zBooleanValue, zBooleanValue2, zBooleanValue3, abstractC0162zF, NO_SOURCE));
            arrayList = arrayList2;
            i = i3;
            oVar = this;
        }
        return kotlin.collections.m.o0(arrayList);
    }
}
