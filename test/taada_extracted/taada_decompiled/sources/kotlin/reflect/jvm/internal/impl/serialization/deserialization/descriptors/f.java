package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import A2.C0031m;
import G2.C0111k;
import G2.C0113m;
import G2.U;
import a3.F;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import n2.AbstractC0713e;
import n2.AbstractC0718j;
import n2.C0712d;
import n2.C0717i;
import n2.C0721m;
import n2.EnumC0709a;
import n2.EnumC0711c;
import n2.EnumC0719k;
import v2.EnumC0851b;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3893a;
    public final /* synthetic */ g b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(g gVar, int i) {
        super(0);
        this.f3893a = i;
        this.b = gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object next;
        C0712d c0712d;
        Object c0717i;
        SimpleTypeMarker simpleTypeMarker;
        ?? arrayList;
        int i = 5;
        int i3 = 4;
        int i4 = 1;
        g gVar = this.b;
        switch (this.f3893a) {
            case 0:
                return AbstractC0718j.c(gVar);
            case 1:
                return kotlin.collections.m.o0(gVar.f3899l.f1433a.e.loadClassAnnotations(gVar.f3908w));
            case 2:
                C0111k c0111k = gVar.e;
                if ((c0111k.c & 4) != 4) {
                    return null;
                }
                ClassifierDescriptor contributedClassifier = gVar.e().getContributedClassifier(kotlin.reflect.l.I(gVar.f3899l.b, c0111k.f628f), EnumC0851b.f4935g);
                if (contributedClassifier instanceof ClassDescriptor) {
                    return (ClassDescriptor) contributedClassifier;
                }
                return null;
            case 3:
                List list = gVar.e.f637p;
                kotlin.jvm.internal.h.e(list, "classProto.constructorList");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (I2.e.f780m.c(((C0113m) obj).d).booleanValue()) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(kotlin.collections.o.D(arrayList2));
                Iterator it = arrayList2.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    X2.i iVar = gVar.f3899l;
                    if (!zHasNext) {
                        return kotlin.collections.m.b0(iVar.f1433a.f1426n.getConstructors(gVar), kotlin.collections.m.b0(kotlin.collections.n.z(gVar.getUnsubstitutedPrimaryConstructor()), arrayList3));
                    }
                    C0113m it2 = (C0113m) it.next();
                    X2.o oVar = iVar.i;
                    kotlin.jvm.internal.h.e(it2, "it");
                    arrayList3.add(oVar.d(it2, false));
                }
                break;
            case 4:
                g gVar2 = this.b;
                if (!gVar2.f3898k.a()) {
                    List list2 = gVar2.e.f637p;
                    kotlin.jvm.internal.h.e(list2, "classProto.constructorList");
                    Iterator it3 = list2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            next = it3.next();
                            if (!I2.e.f780m.c(((C0113m) next).d).booleanValue()) {
                            }
                        } else {
                            next = null;
                        }
                    }
                    C0113m c0113m = (C0113m) next;
                    if (c0113m != null) {
                        return gVar2.f3899l.i.d(c0113m, true);
                    }
                    return null;
                }
                SourceElement sourceElement = SourceElement.NO_SOURCE;
                if (sourceElement == null) {
                    N2.q.a(21);
                    throw null;
                }
                Annotations.Companion.getClass();
                N2.e eVar = new N2.e(gVar2, null, o2.f.b, true, EnumC0709a.f4226a, sourceElement);
                List list3 = Collections.EMPTY_LIST;
                int i5 = N2.f.f1135a;
                EnumC0711c enumC0711c = EnumC0711c.c;
                EnumC0711c enumC0711c2 = gVar2.f3898k;
                if (enumC0711c2 == enumC0711c || enumC0711c2.a()) {
                    c0712d = AbstractC0713e.f4232a;
                    if (c0712d == null) {
                        N2.f.a(49);
                        throw null;
                    }
                } else if (N2.f.q(gVar2)) {
                    c0712d = AbstractC0713e.f4232a;
                    if (c0712d == null) {
                        N2.f.a(51);
                        throw null;
                    }
                } else if (N2.f.k(gVar2)) {
                    c0712d = AbstractC0713e.f4237k;
                    if (c0712d == null) {
                        N2.f.a(52);
                        throw null;
                    }
                } else {
                    c0712d = AbstractC0713e.e;
                    if (c0712d == null) {
                        N2.f.a(53);
                        throw null;
                    }
                }
                eVar.t(list3, c0712d);
                eVar.q(gVar2.getDefaultType());
                return eVar;
            case 5:
                EnumC0719k enumC0719k = EnumC0719k.b;
                u uVar = u.f3804a;
                if (gVar.i != enumC0719k) {
                    return uVar;
                }
                List<Integer> fqNames = gVar.e.u;
                kotlin.jvm.internal.h.e(fqNames, "fqNames");
                if (fqNames.isEmpty()) {
                    if (gVar.i != enumC0719k) {
                        return uVar;
                    }
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    DeclarationDescriptor declarationDescriptor = gVar.q;
                    if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                        N2.q.c(gVar, linkedHashSet, ((PackageFragmentDescriptor) declarationDescriptor).getMemberScope(), false);
                    }
                    MemberScope unsubstitutedInnerClassesScope = gVar.getUnsubstitutedInnerClassesScope();
                    kotlin.jvm.internal.h.e(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
                    N2.q.c(gVar, linkedHashSet, unsubstitutedInnerClassesScope, true);
                    return kotlin.collections.m.k0(linkedHashSet, new N2.j(i4));
                }
                ArrayList arrayList4 = new ArrayList();
                for (Integer index : fqNames) {
                    X2.i iVar2 = gVar.f3899l;
                    X2.g gVar3 = iVar2.f1433a;
                    kotlin.jvm.internal.h.e(index, "index");
                    ClassDescriptor classDescriptorB = gVar3.b(kotlin.reflect.l.w(iVar2.b, index.intValue()));
                    if (classDescriptorB != null) {
                        arrayList4.add(classDescriptorB);
                    }
                }
                return arrayList4;
            default:
                if (!gVar.isInline() && !gVar.isValue()) {
                    return null;
                }
                X2.i iVar3 = gVar.f3899l;
                NameResolver nameResolver = iVar3.b;
                C0031m c0031m = new C0031m(i4, i3, iVar3.f1436h);
                C0031m c0031m2 = new C0031m(i4, i, gVar);
                C0111k c0111k2 = gVar.e;
                kotlin.jvm.internal.h.f(c0111k2, "<this>");
                kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
                I2.f fVar = iVar3.d;
                if (c0111k2.f643z.size() > 0) {
                    List<Integer> multiFieldValueClassUnderlyingNameList = c0111k2.f643z;
                    kotlin.jvm.internal.h.e(multiFieldValueClassUnderlyingNameList, "multiFieldValueClassUnderlyingNameList");
                    ArrayList arrayList5 = new ArrayList(kotlin.collections.o.D(multiFieldValueClassUnderlyingNameList));
                    for (Integer it4 : multiFieldValueClassUnderlyingNameList) {
                        kotlin.jvm.internal.h.e(it4, "it");
                        arrayList5.add(kotlin.reflect.l.I(nameResolver, it4.intValue()));
                    }
                    N1.e eVar2 = new N1.e(Integer.valueOf(c0111k2.C.size()), Integer.valueOf(c0111k2.f624B.size()));
                    if (eVar2.equals(new N1.e(Integer.valueOf(arrayList5.size()), 0))) {
                        List<Integer> multiFieldValueClassUnderlyingTypeIdList = c0111k2.C;
                        kotlin.jvm.internal.h.e(multiFieldValueClassUnderlyingTypeIdList, "multiFieldValueClassUnderlyingTypeIdList");
                        arrayList = new ArrayList(kotlin.collections.o.D(multiFieldValueClassUnderlyingTypeIdList));
                        for (Integer it5 : multiFieldValueClassUnderlyingTypeIdList) {
                            kotlin.jvm.internal.h.e(it5, "it");
                            arrayList.add(fVar.a(it5.intValue()));
                        }
                    } else {
                        if (!eVar2.equals(new N1.e(0, Integer.valueOf(arrayList5.size())))) {
                            throw new IllegalStateException(("class " + kotlin.reflect.l.I(nameResolver, c0111k2.e) + " has illegal multi-field value class representation").toString());
                        }
                        arrayList = c0111k2.f624B;
                    }
                    kotlin.jvm.internal.h.e(arrayList, "when (typeIdCount to typ…epresentation\")\n        }");
                    ArrayList arrayList6 = new ArrayList(kotlin.collections.o.D(arrayList));
                    Iterator it6 = arrayList.iterator();
                    while (it6.hasNext()) {
                        arrayList6.add(c0031m.invoke(it6.next()));
                    }
                    c0717i = new C0721m(kotlin.collections.m.u0(arrayList5, arrayList6));
                } else if ((c0111k2.c & 8) == 8) {
                    L2.f fVarI = kotlin.reflect.l.I(nameResolver, c0111k2.f642w);
                    int i6 = c0111k2.c;
                    U uA = (i6 & 16) == 16 ? c0111k2.x : (i6 & 32) == 32 ? fVar.a(c0111k2.y) : null;
                    if ((uA == null || (simpleTypeMarker = (SimpleTypeMarker) c0031m.invoke(uA)) == null) && (simpleTypeMarker = (SimpleTypeMarker) c0031m2.invoke(fVarI)) == null) {
                        throw new IllegalStateException(("cannot determine underlying type for value class " + kotlin.reflect.l.I(nameResolver, c0111k2.e) + " with property " + fVarI).toString());
                    }
                    c0717i = new C0717i(fVarI, simpleTypeMarker);
                } else {
                    c0717i = null;
                }
                if (c0717i != null) {
                    return c0717i;
                }
                if (gVar.f3894f.a(1, 5, 1)) {
                    return null;
                }
                ClassConstructorDescriptor unsubstitutedPrimaryConstructor = gVar.getUnsubstitutedPrimaryConstructor();
                if (unsubstitutedPrimaryConstructor == null) {
                    throw new IllegalStateException(("Inline class has no primary constructor: " + gVar).toString());
                }
                List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
                kotlin.jvm.internal.h.e(valueParameters, "constructor.valueParameters");
                L2.f name = ((ValueParameterDescriptor) kotlin.collections.m.P(valueParameters)).getName();
                kotlin.jvm.internal.h.e(name, "constructor.valueParameters.first().name");
                F f6 = gVar.f(name);
                if (f6 != null) {
                    return new C0717i(name, f6);
                }
                throw new IllegalStateException(("Value class has no underlying property: " + gVar).toString());
        }
    }
}
