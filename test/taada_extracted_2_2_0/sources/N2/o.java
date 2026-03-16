package N2;

import a.AbstractC0132a;
import a3.AbstractC0162z;
import a3.C0142e;
import a3.Q;
import f.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;
import k2.C0587f;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import n2.C0712d;
import n2.EnumC0709a;
import n2.EnumC0719k;
import q2.G;
import q2.I;
import q2.v;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final List b = kotlin.collections.m.o0(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    public static final o c;
    public static final k d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KotlinTypeChecker.TypeConstructorEquality f1142a;

    static {
        k kVar = new k();
        d = kVar;
        c = new o(kVar);
    }

    public o(KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (typeConstructorEquality != null) {
            this.f1142a = typeConstructorEquality;
        } else {
            a(5);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r25) {
        /*
            Method dump skipped, instruction units count: 1320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.o.a(int):void");
    }

    public static boolean b(AbstractC0162z abstractC0162z, AbstractC0162z abstractC0162z2, Q q) {
        if (abstractC0162z == null) {
            a(46);
            throw null;
        }
        if (abstractC0162z2 == null) {
            a(47);
            throw null;
        }
        if (kotlin.reflect.l.O(abstractC0162z) && kotlin.reflect.l.O(abstractC0162z2)) {
            return true;
        }
        return C0142e.g(q, abstractC0162z.f(), abstractC0162z2.f());
    }

    public static void c(CallableMemberDescriptor callableMemberDescriptor, LinkedHashSet linkedHashSet) {
        if (callableMemberDescriptor == null) {
            a(17);
            throw null;
        }
        EnumC0709a kind = callableMemberDescriptor.getKind();
        kind.getClass();
        if (kind != EnumC0709a.b) {
            linkedHashSet.add(callableMemberDescriptor);
            return;
        }
        if (callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
        Iterator<? extends CallableMemberDescriptor> it = callableMemberDescriptor.getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            c(it.next(), linkedHashSet);
        }
    }

    public static ArrayList d(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        Iterator<ValueParameterDescriptor> it = callableDescriptor.getValueParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x018b, code lost:
    
        if (r3 == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x018d, code lost:
    
        r0 = n2.AbstractC0713e.f4236h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0191, code lost:
    
        r0 = n2.AbstractC0713e.f4235g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0194, code lost:
    
        r0 = ((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) s(r8, new N2.l(0))).copy(r15, r2, r0, n2.EnumC0709a.b, false);
        r16.p(r0, r8);
        r16.b(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01ae, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0095, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(java.util.Collection r14, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r15, N2.q r16) {
        /*
            Method dump skipped, instruction units count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.o.e(java.util.Collection, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, N2.q):void");
    }

    public static ArrayList g(Object obj, LinkedList linkedList, Function1 function1, Function1 function12) {
        if (obj == null) {
            a(99);
            throw null;
        }
        if (function1 == null) {
            a(101);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        CallableDescriptor callableDescriptor = (CallableDescriptor) function1.invoke(obj);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            CallableDescriptor callableDescriptor2 = (CallableDescriptor) function1.invoke(next);
            if (obj == next) {
                it.remove();
            } else {
                int iJ = j(callableDescriptor, callableDescriptor2);
                if (iJ == 1) {
                    arrayList.add(next);
                    it.remove();
                } else if (iJ == 3) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static n i(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        boolean z6;
        if (callableDescriptor == null) {
            a(40);
            throw null;
        }
        if (callableDescriptor2 == null) {
            a(41);
            throw null;
        }
        boolean z7 = callableDescriptor instanceof FunctionDescriptor;
        if ((z7 && !(callableDescriptor2 instanceof FunctionDescriptor)) || (((z6 = callableDescriptor instanceof PropertyDescriptor)) && !(callableDescriptor2 instanceof PropertyDescriptor))) {
            return n.d("Member kind mismatch");
        }
        if (!z7 && !z6) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
        }
        if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
            return n.d("Name mismatch");
        }
        n nVarD = (callableDescriptor.getExtensionReceiverParameter() == null) != (callableDescriptor2.getExtensionReceiverParameter() == null) ? n.d("Receiver presence mismatch") : callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size() ? n.d("Value parameter number mismatch") : null;
        if (nVarD != null) {
            return nVarD;
        }
        return null;
    }

    public static int j(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        o oVar = c;
        int iC = oVar.l(callableDescriptor2, callableDescriptor, null).c();
        int iC2 = oVar.m(callableDescriptor, callableDescriptor2, null, false).c();
        if (iC == 1 && iC2 == 1) {
            return 1;
        }
        return (iC == 3 || iC2 == 3) ? 3 : 2;
    }

    public static boolean k(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            a(67);
            throw null;
        }
        if (callableDescriptor2 == null) {
            a(68);
            throw null;
        }
        AbstractC0162z returnType = callableDescriptor.getReturnType();
        AbstractC0162z returnType2 = callableDescriptor2.getReturnType();
        if (!p(callableDescriptor, callableDescriptor2)) {
            return false;
        }
        Q qF = c.f(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters());
        if (callableDescriptor instanceof FunctionDescriptor) {
            return o(callableDescriptor, returnType, callableDescriptor2, returnType2, qF);
        }
        if (!(callableDescriptor instanceof PropertyDescriptor)) {
            throw new IllegalArgumentException("Unexpected callable: " + callableDescriptor.getClass());
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
        PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
        PropertySetterDescriptor setter2 = propertyDescriptor2.getSetter();
        if ((setter == null || setter2 == null) ? true : p(setter, setter2)) {
            return (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) ? C0142e.g(qF, returnType.f(), returnType2.f()) : (propertyDescriptor.isVar() || !propertyDescriptor2.isVar()) && o(callableDescriptor, returnType, callableDescriptor2, returnType2, qF);
        }
        return false;
    }

    public static boolean o(CallableDescriptor callableDescriptor, AbstractC0162z abstractC0162z, CallableDescriptor callableDescriptor2, AbstractC0162z abstractC0162z2, Q q) {
        if (callableDescriptor == null) {
            a(73);
            throw null;
        }
        if (abstractC0162z == null) {
            a(74);
            throw null;
        }
        if (callableDescriptor2 == null) {
            a(75);
            throw null;
        }
        if (abstractC0162z2 != null) {
            return C0142e.m(C0142e.f1548a, q, abstractC0162z.f(), abstractC0162z2.f());
        }
        a(76);
        throw null;
    }

    public static boolean p(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            a(69);
            throw null;
        }
        if (callableDescriptor2 != null) {
            Integer numB = AbstractC0713e.b(callableDescriptor.getVisibility(), callableDescriptor2.getVisibility());
            return numB == null || numB.intValue() >= 0;
        }
        a(70);
        throw null;
    }

    public static boolean q(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            a(13);
            throw null;
        }
        if (callableDescriptor2 == null) {
            a(14);
            throw null;
        }
        boolean zEquals = callableDescriptor.equals(callableDescriptor2);
        d dVar = d.f1134a;
        if (!zEquals && dVar.a(callableDescriptor.getOriginal(), callableDescriptor2.getOriginal(), false)) {
            return true;
        }
        CallableDescriptor original = callableDescriptor2.getOriginal();
        int i = f.f1135a;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f.b(callableDescriptor.getOriginal(), linkedHashSet);
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            if (dVar.a(original, (CallableDescriptor) it.next(), false)) {
                return true;
            }
        }
        return false;
    }

    public static void r(CallableMemberDescriptor callableMemberDescriptor, C0587f c0587f) {
        AbstractC0714f abstractC0714f;
        AbstractC0714f abstractC0714fG;
        AbstractC0714f abstractC0714f2;
        if (callableMemberDescriptor == null) {
            a(107);
            throw null;
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor2.getVisibility() == AbstractC0713e.f4235g) {
                r(callableMemberDescriptor2, c0587f);
            }
        }
        if (callableMemberDescriptor.getVisibility() != AbstractC0713e.f4235g) {
            return;
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        if (overriddenDescriptors == null) {
            a(109);
            throw null;
        }
        if (overriddenDescriptors.isEmpty()) {
            abstractC0714fG = AbstractC0713e.f4238k;
        } else {
            Iterator<? extends CallableMemberDescriptor> it = overriddenDescriptors.iterator();
            loop3: while (true) {
                abstractC0714f = null;
                while (it.hasNext()) {
                    AbstractC0714f visibility = it.next().getVisibility();
                    if (abstractC0714f != null) {
                        Integer numB = AbstractC0713e.b(visibility, abstractC0714f);
                        if (numB == null) {
                            break;
                        } else if (numB.intValue() > 0) {
                        }
                    }
                    abstractC0714f = visibility;
                }
            }
            if (abstractC0714f == null) {
                abstractC0714fG = null;
                break;
            }
            Iterator<? extends CallableMemberDescriptor> it2 = overriddenDescriptors.iterator();
            while (it2.hasNext()) {
                Integer numB2 = AbstractC0713e.b(abstractC0714f, it2.next().getVisibility());
                if (numB2 == null || numB2.intValue() < 0) {
                    abstractC0714fG = null;
                    break;
                }
            }
            abstractC0714fG = abstractC0714f;
        }
        if (abstractC0714fG == null) {
            abstractC0714fG = null;
            break;
        }
        if (callableMemberDescriptor.getKind() == EnumC0709a.b) {
            for (CallableMemberDescriptor callableMemberDescriptor3 : overriddenDescriptors) {
                if (callableMemberDescriptor3.getModality() != EnumC0719k.d && !callableMemberDescriptor3.getVisibility().equals(abstractC0714fG)) {
                    abstractC0714fG = null;
                    break;
                }
            }
        } else {
            abstractC0714fG = AbstractC0713e.g(((C0712d) abstractC0714fG).f4232a.c());
        }
        if (abstractC0714fG == null) {
            if (c0587f != null) {
                c0587f.invoke(callableMemberDescriptor);
            }
            abstractC0714f2 = AbstractC0713e.e;
        } else {
            abstractC0714f2 = abstractC0714fG;
        }
        if (callableMemberDescriptor instanceof I) {
            I i = (I) callableMemberDescriptor;
            if (abstractC0714f2 == null) {
                I.a(20);
                throw null;
            }
            i.f4558j = abstractC0714f2;
            Iterator<PropertyAccessorDescriptor> it3 = ((PropertyDescriptor) callableMemberDescriptor).getAccessors().iterator();
            while (it3.hasNext()) {
                r(it3.next(), abstractC0714fG == null ? null : c0587f);
            }
            return;
        }
        if (callableMemberDescriptor instanceof v) {
            v vVar = (v) callableMemberDescriptor;
            if (abstractC0714f2 != null) {
                vVar.f4634l = abstractC0714f2;
                return;
            } else {
                v.a(10);
                throw null;
            }
        }
        G g6 = (G) callableMemberDescriptor;
        g6.f4550k = abstractC0714f2;
        if (abstractC0714f2 != g6.getCorrespondingProperty().getVisibility()) {
            g6.e = false;
        }
    }

    public static Object s(Collection collection, Function1 function1) {
        Object next;
        if (function1 == null) {
            a(79);
            throw null;
        }
        if (collection.size() == 1) {
            Object objO = kotlin.collections.m.O(collection);
            if (objO != null) {
                return objO;
            }
            a(80);
            throw null;
        }
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(collection));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList2.add(function1.invoke(it.next()));
        }
        Object objO2 = kotlin.collections.m.O(collection);
        CallableDescriptor callableDescriptor = (CallableDescriptor) function1.invoke(objO2);
        for (Object obj : collection) {
            CallableDescriptor callableDescriptor2 = (CallableDescriptor) function1.invoke(obj);
            if (callableDescriptor2 == null) {
                a(71);
                throw null;
            }
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    arrayList.add(obj);
                    break;
                }
                if (!k(callableDescriptor2, (CallableDescriptor) it2.next())) {
                    break;
                }
            }
            if (k(callableDescriptor2, callableDescriptor) && !k(callableDescriptor, callableDescriptor2)) {
                objO2 = obj;
            }
        }
        if (arrayList.isEmpty()) {
            if (objO2 != null) {
                return objO2;
            }
            a(81);
            throw null;
        }
        if (arrayList.size() == 1) {
            Object objO3 = kotlin.collections.m.O(arrayList);
            if (objO3 != null) {
                return objO3;
            }
            a(82);
            throw null;
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next = null;
                break;
            }
            next = it3.next();
            if (!AbstractC0132a.I(((CallableDescriptor) function1.invoke(next)).getReturnType())) {
                break;
            }
        }
        if (next != null) {
            return next;
        }
        Object objO4 = kotlin.collections.m.O(arrayList);
        if (objO4 != null) {
            return objO4;
        }
        a(84);
        throw null;
    }

    public final Q f(List list, List list2) {
        if (list == null) {
            a(42);
            throw null;
        }
        if (list2 == null) {
            a(43);
            throw null;
        }
        boolean zIsEmpty = list.isEmpty();
        b3.b bVar = b3.b.f1698a;
        b3.c cVar = b3.c.f1699a;
        KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality = this.f1142a;
        if (zIsEmpty) {
            return new Q(true, true, new p(null, typeConstructorEquality), bVar, cVar);
        }
        HashMap map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            map.put(((TypeParameterDescriptor) list.get(i)).getTypeConstructor(), ((TypeParameterDescriptor) list2.get(i)).getTypeConstructor());
        }
        return new Q(true, true, new p(map, typeConstructorEquality), bVar, cVar);
    }

    public final void h(L2.f fVar, Collection collection, Collection collection2, ClassDescriptor classDescriptor, q qVar) {
        Integer numB;
        if (fVar == null) {
            a(52);
            throw null;
        }
        if (collection == null) {
            a(53);
            throw null;
        }
        if (collection2 == null) {
            a(54);
            throw null;
        }
        if (classDescriptor == null) {
            a(55);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) it.next();
            if (callableMemberDescriptor == null) {
                a(59);
                throw null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            j3.m mVar = new j3.m();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                CallableMemberDescriptor callableMemberDescriptor2 = (CallableMemberDescriptor) it2.next();
                int iC = l(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).c();
                boolean z6 = !AbstractC0713e.e(callableMemberDescriptor2.getVisibility()) && AbstractC0713e.c(AbstractC0713e.f4240m, callableMemberDescriptor2, callableMemberDescriptor) == null;
                int iB = s.b(iC);
                if (iB == 0) {
                    if (z6) {
                        mVar.add(callableMemberDescriptor2);
                    }
                    arrayList.add(callableMemberDescriptor2);
                } else if (iB == 2) {
                    if (z6) {
                        qVar.d(callableMemberDescriptor2, callableMemberDescriptor);
                    }
                    arrayList.add(callableMemberDescriptor2);
                }
            }
            qVar.p(callableMemberDescriptor, mVar);
            linkedHashSet.removeAll(arrayList);
        }
        if (linkedHashSet.size() >= 2) {
            DeclarationDescriptor containingDeclaration = ((CallableMemberDescriptor) linkedHashSet.iterator().next()).getContainingDeclaration();
            if (!linkedHashSet.isEmpty()) {
                Iterator it3 = linkedHashSet.iterator();
                while (it3.hasNext()) {
                    if (((CallableMemberDescriptor) it3.next()).getContainingDeclaration() != containingDeclaration) {
                        LinkedList<CallableMemberDescriptor> linkedList = new LinkedList(linkedHashSet);
                        while (!linkedList.isEmpty()) {
                            linkedList.isEmpty();
                            CallableMemberDescriptor callableMemberDescriptor3 = null;
                            for (CallableMemberDescriptor callableMemberDescriptor4 : linkedList) {
                                if (callableMemberDescriptor3 == null || ((numB = AbstractC0713e.b(callableMemberDescriptor3.getVisibility(), callableMemberDescriptor4.getVisibility())) != null && numB.intValue() < 0)) {
                                    callableMemberDescriptor3 = callableMemberDescriptor4;
                                }
                            }
                            kotlin.jvm.internal.h.c(callableMemberDescriptor3);
                            e(g(callableMemberDescriptor3, linkedList, new l(1), new m(qVar, callableMemberDescriptor3)), classDescriptor, qVar);
                        }
                        return;
                    }
                }
            }
        }
        Iterator it4 = linkedHashSet.iterator();
        while (it4.hasNext()) {
            e(Collections.singleton((CallableMemberDescriptor) it4.next()), classDescriptor, qVar);
        }
    }

    public final n l(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            a(19);
            throw null;
        }
        if (callableDescriptor2 != null) {
            return m(callableDescriptor, callableDescriptor2, classDescriptor, false);
        }
        a(20);
        throw null;
    }

    public final n m(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor, boolean z6) {
        if (callableDescriptor == null) {
            a(22);
            throw null;
        }
        if (callableDescriptor2 == null) {
            a(23);
            throw null;
        }
        n nVarN = n(callableDescriptor, callableDescriptor2, z6);
        boolean z7 = nVarN.c() == 1;
        List<ExternalOverridabilityCondition> list = b;
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            g gVar = g.f1136a;
            if (!zHasNext) {
                if (!z7) {
                    return nVarN;
                }
                for (ExternalOverridabilityCondition externalOverridabilityCondition : list) {
                    if (externalOverridabilityCondition.getContract() == gVar) {
                        int iOrdinal = externalOverridabilityCondition.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal();
                        if (iOrdinal == 0) {
                            throw new IllegalStateException("Contract violation in " + externalOverridabilityCondition.getClass().getName() + " condition. It's not supposed to end with success");
                        }
                        if (iOrdinal == 1) {
                            return n.b("External condition failed");
                        }
                        if (iOrdinal == 2) {
                            return n.d("External condition");
                        }
                    }
                }
                n nVar = n.b;
                if (nVar != null) {
                    return nVar;
                }
                n.a(0);
                throw null;
            }
            ExternalOverridabilityCondition externalOverridabilityCondition2 = (ExternalOverridabilityCondition) it.next();
            if (externalOverridabilityCondition2.getContract() != gVar && (!z7 || externalOverridabilityCondition2.getContract() != g.b)) {
                int iOrdinal2 = externalOverridabilityCondition2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal();
                if (iOrdinal2 == 0) {
                    z7 = true;
                } else {
                    if (iOrdinal2 == 1) {
                        return n.b("External condition failed");
                    }
                    if (iOrdinal2 == 2) {
                        return n.d("External condition");
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
    
        r14.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final N2.n n(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r17, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.o.n(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, boolean):N2.n");
    }
}
