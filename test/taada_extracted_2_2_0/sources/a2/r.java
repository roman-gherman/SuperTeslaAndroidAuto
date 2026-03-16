package A2;

import a3.AbstractC0162z;
import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.b0;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import n2.AbstractC0713e;
import n2.EnumC0719k;
import q2.S;
import v2.EnumC0851b;
import w2.AbstractC0871e;
import w2.AbstractC0875i;
import w2.C0874h;
import w2.C0876j;
import x2.C0924k;
import y2.C0931a;
import y2.C0932b;
import z2.C0941a;
import z2.C0944d;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends G {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ClassDescriptor f58m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final JavaClass f59n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f60o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final NotNullLazyValue f61p;
    public final NotNullLazyValue q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final NotNullLazyValue f62r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final NotNullLazyValue f63s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MemoizedFunctionToNullable f64t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(C0946f c, ClassDescriptor ownerDescriptor, JavaClass jClass, boolean z6, r rVar) {
        super(c, rVar);
        kotlin.jvm.internal.h.f(c, "c");
        kotlin.jvm.internal.h.f(ownerDescriptor, "ownerDescriptor");
        kotlin.jvm.internal.h.f(jClass, "jClass");
        this.f58m = ownerDescriptor;
        this.f59n = jClass;
        this.f60o = z6;
        Z2.n nVar = c.f5204a.f5184a;
        this.f61p = nVar.createLazyValue(new C0033o(this, c));
        this.q = nVar.createLazyValue(new C0034p(this, 1));
        this.f62r = nVar.createLazyValue(new C0033o(c, this));
        this.f63s = nVar.createLazyValue(new C0034p(this, 0));
        this.f64t = nVar.createMemoizedFunctionWithNullableValues(new q(this, c));
    }

    public static SimpleFunctionDescriptor A(PropertyDescriptor propertyDescriptor, String str, Function1 function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Iterator it = ((Iterable) function1.invoke(L2.f.e(str))).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                AbstractC0162z returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    public static SimpleFunctionDescriptor C(PropertyDescriptor propertyDescriptor, Function1 function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        AbstractC0162z returnType;
        String strB = propertyDescriptor.getName().b();
        kotlin.jvm.internal.h.e(strB, "name.asString()");
        Iterator it = ((Iterable) function1.invoke(L2.f.e(w2.C.b(strB)))).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null) {
                L2.f fVar = k2.i.f3710f;
                if (k2.i.C(returnType, k2.o.d)) {
                    KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                    List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                    kotlin.jvm.internal.h.e(valueParameters, "descriptor.valueParameters");
                    if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) kotlin.collections.m.g0(valueParameters)).getType(), propertyDescriptor.getType())) {
                        simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    }
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    public static boolean F(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String strO = E1.k.o(simpleFunctionDescriptor, 2);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        kotlin.jvm.internal.h.e(original, "builtinWithErasedParameters.original");
        return strO.equals(E1.k.o(original, 2)) && !y(simpleFunctionDescriptor, functionDescriptor);
    }

    public static final ArrayList o(r rVar, L2.f fVar) {
        Collection<JavaMethod> collectionFindMethodsByName = ((DeclaredMemberIndex) rVar.d.invoke()).findMethodsByName(fVar);
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(collectionFindMethodsByName));
        Iterator<T> it = collectionFindMethodsByName.iterator();
        while (it.hasNext()) {
            arrayList.add(rVar.m((JavaMethod) it.next()));
        }
        return arrayList;
    }

    public static final ArrayList p(r rVar, L2.f fVar) {
        LinkedHashSet linkedHashSetD = rVar.D(fVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedHashSetD) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
            kotlin.jvm.internal.h.f(simpleFunctionDescriptor, "<this>");
            if (b0.p(simpleFunctionDescriptor) == null && C0874h.a(simpleFunctionDescriptor) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static SimpleFunctionDescriptor v(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor, AbstractCollection abstractCollection) {
        if (abstractCollection.isEmpty()) {
            return simpleFunctionDescriptor;
        }
        Iterator it = abstractCollection.iterator();
        while (it.hasNext()) {
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (!simpleFunctionDescriptor.equals(simpleFunctionDescriptor2) && simpleFunctionDescriptor2.getInitialSignatureDescriptor() == null && y(simpleFunctionDescriptor2, functionDescriptor)) {
                FunctionDescriptor functionDescriptorBuild = simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
                kotlin.jvm.internal.h.c(functionDescriptorBuild);
                return (SimpleFunctionDescriptor) functionDescriptorBuild;
            }
        }
        return simpleFunctionDescriptor;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor w(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r5) {
        /*
            java.util.List r0 = r5.getValueParameters()
            java.lang.String r1 = "valueParameters"
            kotlin.jvm.internal.h.e(r0, r1)
            java.lang.Object r0 = kotlin.collections.m.Y(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            r2 = 0
            if (r0 == 0) goto L7b
            a3.z r3 = r0.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r3.c()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = r3.getDeclarationDescriptor()
            if (r3 == 0) goto L33
            L2.e r3 = R2.e.h(r3)
            boolean r4 = r3.d()
            if (r4 == 0) goto L2b
            goto L2c
        L2b:
            r3 = r2
        L2c:
            if (r3 == 0) goto L33
            L2.c r3 = r3.g()
            goto L34
        L33:
            r3 = r2
        L34:
            L2.c r4 = k2.p.f3764f
            boolean r3 = kotlin.jvm.internal.h.a(r3, r4)
            if (r3 == 0) goto L3d
            goto L3e
        L3d:
            r0 = r2
        L3e:
            if (r0 != 0) goto L41
            goto L7b
        L41:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r2 = r5.newCopyBuilder()
            java.util.List r5 = r5.getValueParameters()
            kotlin.jvm.internal.h.e(r5, r1)
            java.util.List r5 = kotlin.collections.m.N(r5)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r5 = r2.setValueParameters(r5)
            a3.z r0 = r0.getType()
            java.util.List r0 = r0.a()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r0
            a3.z r0 = r0.getType()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r5 = r5.setReturnType(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5 = r5.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r5
            r0 = r5
            q2.L r0 = (q2.L) r0
            if (r0 != 0) goto L77
            return r5
        L77:
            r1 = 1
            r0.f4642v = r1
            return r5
        L7b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: A2.r.w(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor");
    }

    public static boolean y(FunctionDescriptor functionDescriptor, FunctionDescriptor functionDescriptor2) {
        int iC = N2.o.c.n(functionDescriptor2, functionDescriptor, true).c();
        com.google.protobuf.a.q(iC, "DEFAULT.isOverridableByW…iptor, this, true).result");
        return iC == 1 && !k1.j.h(functionDescriptor2, functionDescriptor);
    }

    public static boolean z(SimpleFunctionDescriptor simpleFunctionDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor2) {
        int i = AbstractC0871e.f5009l;
        kotlin.jvm.internal.h.f(simpleFunctionDescriptor, "<this>");
        SimpleFunctionDescriptor original = simpleFunctionDescriptor2;
        if (kotlin.jvm.internal.h.a(simpleFunctionDescriptor.getName().b(), "removeAt")) {
            original = simpleFunctionDescriptor2;
            if (kotlin.jvm.internal.h.a(E1.k.p(simpleFunctionDescriptor), w2.N.f4996g.b)) {
                original = simpleFunctionDescriptor2.getOriginal();
            }
        }
        kotlin.jvm.internal.h.e(original, "if (superDescriptor.isRe…iginal else subDescriptor");
        return y(original, simpleFunctionDescriptor);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Map] */
    public final SimpleFunctionDescriptor B(PropertyDescriptor propertyDescriptor, Function1 function1) {
        L2.f fVar;
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        String strB = null;
        PropertyGetterDescriptor propertyGetterDescriptor = getter != null ? (PropertyGetterDescriptor) b0.p(getter) : null;
        if (propertyGetterDescriptor != null) {
            k2.i.y(propertyGetterDescriptor);
            CallableMemberDescriptor callableMemberDescriptorB = R2.e.b(R2.e.k(propertyGetterDescriptor), C0876j.f5014a);
            if (callableMemberDescriptorB != null && (fVar = (L2.f) AbstractC0875i.f5013a.get(R2.e.g(callableMemberDescriptorB))) != null) {
                strB = fVar.b();
            }
        }
        if (strB != null && !b0.t(this.f58m, propertyGetterDescriptor)) {
            return A(propertyDescriptor, strB, function1);
        }
        String strB2 = propertyDescriptor.getName().b();
        kotlin.jvm.internal.h.e(strB2, "name.asString()");
        return A(propertyDescriptor, w2.C.a(strB2), function1);
    }

    public final LinkedHashSet D(L2.f fVar) {
        Collection collectionU = u();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionU.iterator();
        while (it.hasNext()) {
            kotlin.collections.s.F(((AbstractC0162z) it.next()).getMemberScope().getContributedFunctions(fVar, EnumC0851b.e), linkedHashSet);
        }
        return linkedHashSet;
    }

    public final Set E(L2.f fVar) {
        Collection collectionU = u();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionU.iterator();
        while (it.hasNext()) {
            Collection<? extends PropertyDescriptor> contributedVariables = ((AbstractC0162z) it.next()).getMemberScope().getContributedVariables(fVar, EnumC0851b.e);
            ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(contributedVariables));
            Iterator<T> it2 = contributedVariables.iterator();
            while (it2.hasNext()) {
                arrayList2.add((PropertyDescriptor) it2.next());
            }
            kotlin.collections.s.F(arrayList2, arrayList);
        }
        return kotlin.collections.m.s0(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c1 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean G(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r9) {
        /*
            Method dump skipped, instruction units count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A2.r.G(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):boolean");
    }

    @Override // A2.G
    public final Set a(U2.f kindFilter, U2.k kVar) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        return kotlin.collections.E.w((Set) this.q.invoke(), ((Map) this.f63s.invoke()).keySet());
    }

    @Override // A2.G
    public final Set b(U2.f kindFilter, U2.k kVar) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        ClassDescriptor classDescriptor = this.f58m;
        Collection<AbstractC0162z> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
        kotlin.jvm.internal.h.e(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            kotlin.collections.s.F(((AbstractC0162z) it.next()).getMemberScope().getFunctionNames(), linkedHashSet);
        }
        NotNullLazyValue notNullLazyValue = this.d;
        linkedHashSet.addAll(((DeclaredMemberIndex) notNullLazyValue.invoke()).getMethodNames());
        linkedHashSet.addAll(((DeclaredMemberIndex) notNullLazyValue.invoke()).getRecordComponentNames());
        linkedHashSet.addAll(a(kindFilter, kVar));
        C0946f c0946f = this.f11a;
        linkedHashSet.addAll(c0946f.f5204a.x.getMethodNames(c0946f, classDescriptor));
        return linkedHashSet;
    }

    @Override // A2.G
    public final void c(L2.f name, ArrayList arrayList) {
        kotlin.jvm.internal.h.f(name, "name");
        boolean zIsRecord = this.f59n.isRecord();
        ClassDescriptor classDescriptor = this.f58m;
        C0946f c0946f = this.f11a;
        if (zIsRecord) {
            NotNullLazyValue notNullLazyValue = this.d;
            if (((DeclaredMemberIndex) notNullLazyValue.invoke()).findRecordComponentByName(name) != null) {
                if (arrayList.isEmpty()) {
                    JavaRecordComponent javaRecordComponentFindRecordComponentByName = ((DeclaredMemberIndex) notNullLazyValue.invoke()).findRecordComponentByName(name);
                    kotlin.jvm.internal.h.c(javaRecordComponentFindRecordComponentByName);
                    C0944d c0944dZ = b0.z(c0946f, javaRecordComponentFindRecordComponentByName);
                    L2.f name2 = javaRecordComponentFindRecordComponentByName.getName();
                    C0941a c0941a = c0946f.f5204a;
                    y2.e eVarV = y2.e.v(classDescriptor, c0944dZ, name2, c0941a.f5188j.source(javaRecordComponentFindRecordComponentByName), true);
                    B2.a aVarF0 = kotlin.reflect.l.f0(2, false, null, 6);
                    AbstractC0162z abstractC0162zS = c0946f.e.s(javaRecordComponentFindRecordComponentByName.getType(), aVarF0);
                    ReceiverParameterDescriptor receiverParameterDescriptorI = i();
                    kotlin.collections.u uVar = kotlin.collections.u.f3805a;
                    eVarV.u(null, receiverParameterDescriptorI, uVar, uVar, uVar, abstractC0162zS, EnumC0719k.c, AbstractC0713e.e, null);
                    eVarV.E = 1;
                    c0941a.f5186g.recordMethod(javaRecordComponentFindRecordComponentByName, eVarV);
                    arrayList.add(eVarV);
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                            break;
                        }
                    }
                    JavaRecordComponent javaRecordComponentFindRecordComponentByName2 = ((DeclaredMemberIndex) notNullLazyValue.invoke()).findRecordComponentByName(name);
                    kotlin.jvm.internal.h.c(javaRecordComponentFindRecordComponentByName2);
                    C0944d c0944dZ2 = b0.z(c0946f, javaRecordComponentFindRecordComponentByName2);
                    L2.f name22 = javaRecordComponentFindRecordComponentByName2.getName();
                    C0941a c0941a2 = c0946f.f5204a;
                    y2.e eVarV2 = y2.e.v(classDescriptor, c0944dZ2, name22, c0941a2.f5188j.source(javaRecordComponentFindRecordComponentByName2), true);
                    B2.a aVarF02 = kotlin.reflect.l.f0(2, false, null, 6);
                    AbstractC0162z abstractC0162zS2 = c0946f.e.s(javaRecordComponentFindRecordComponentByName2.getType(), aVarF02);
                    ReceiverParameterDescriptor receiverParameterDescriptorI2 = i();
                    kotlin.collections.u uVar2 = kotlin.collections.u.f3805a;
                    eVarV2.u(null, receiverParameterDescriptorI2, uVar2, uVar2, uVar2, abstractC0162zS2, EnumC0719k.c, AbstractC0713e.e, null);
                    eVarV2.E = 1;
                    c0941a2.f5186g.recordMethod(javaRecordComponentFindRecordComponentByName2, eVarV2);
                    arrayList.add(eVarV2);
                }
            }
        }
        c0946f.f5204a.x.generateMethods(c0946f, classDescriptor, name, arrayList);
    }

    @Override // A2.G
    public final DeclaredMemberIndex d() {
        return new C0020b(this.f59n, C0030l.f52a);
    }

    @Override // A2.G
    public final void f(LinkedHashSet linkedHashSet, L2.f name) {
        int i = 1;
        int i3 = 0;
        kotlin.jvm.internal.h.f(name, "name");
        LinkedHashSet linkedHashSetD = D(name);
        ArrayList arrayList = w2.N.f4994a;
        if (!w2.N.f4998j.contains(name)) {
            int i4 = C0874h.f5012l;
            if (!C0874h.b(name)) {
                if (!linkedHashSetD.isEmpty()) {
                    Iterator it = linkedHashSetD.iterator();
                    while (it.hasNext()) {
                        if (((FunctionDescriptor) it.next()).isSuspend()) {
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : linkedHashSetD) {
                    if (G((SimpleFunctionDescriptor) obj)) {
                        arrayList2.add(obj);
                    }
                }
                r(linkedHashSet, name, arrayList2, false);
                return;
            }
        }
        j3.m mVar = new j3.m();
        LinkedHashSet linkedHashSetO = k1.j.o(name, linkedHashSetD, kotlin.collections.u.f3805a, this.f58m, ErrorReporter.DO_NOTHING, this.f11a.f5204a.u.b);
        s(name, linkedHashSet, linkedHashSetO, linkedHashSet, new C0031m(i, i3, this));
        s(name, linkedHashSet, linkedHashSetO, mVar, new C0031m(i, i, this));
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : linkedHashSetD) {
            if (G((SimpleFunctionDescriptor) obj2)) {
                arrayList3.add(obj2);
            }
        }
        r(linkedHashSet, name, kotlin.collections.m.b0(mVar, arrayList3), true);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, kotlin.Lazy] */
    @Override // A2.G
    public final void g(L2.f name, ArrayList arrayList) {
        Set setS0;
        JavaMethod javaMethod;
        kotlin.jvm.internal.h.f(name, "name");
        boolean zIsAnnotationType = this.f59n.isAnnotationType();
        C0946f c0946f = this.f11a;
        if (zIsAnnotationType && (javaMethod = (JavaMethod) kotlin.collections.m.h0(((DeclaredMemberIndex) this.d.invoke()).findMethodsByName(name))) != null) {
            y2.f fVarN = y2.f.n(this.f58m, b0.z(c0946f, javaMethod), w2.O.a(javaMethod.getVisibility()), false, javaMethod.getName(), c0946f.f5204a.f5188j.source(javaMethod), false);
            Annotations.Companion.getClass();
            q2.J jF = N2.q.f(fVarN, o2.f.b);
            fVarN.k(jF, null, null, null);
            kotlin.jvm.internal.h.f(c0946f, "<this>");
            AbstractC0162z abstractC0162zE = G.e(javaMethod, new C0946f(c0946f.f5204a, new Y0.b(c0946f, fVarN, javaMethod, 0), c0946f.c));
            kotlin.collections.u uVar = kotlin.collections.u.f3805a;
            fVarN.m(abstractC0162zE, uVar, i(), null, uVar);
            jF.f4571m = abstractC0162zE;
            arrayList.add(fVarN);
        }
        Set setE = E(name);
        if (setE.isEmpty()) {
            return;
        }
        j3.m mVar = new j3.m();
        j3.m mVar2 = new j3.m();
        t(setE, arrayList, mVar, new C0032n(this, 0));
        if (mVar.isEmpty()) {
            setS0 = kotlin.collections.m.s0(setE);
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Object obj : setE) {
                if (!mVar.contains(obj)) {
                    linkedHashSet.add(obj);
                }
            }
            setS0 = linkedHashSet;
        }
        t(setS0, mVar2, null, new C0032n(this, 1));
        LinkedHashSet linkedHashSetW = kotlin.collections.E.w(setE, mVar2);
        C0941a c0941a = c0946f.f5204a;
        arrayList.addAll(k1.j.o(name, linkedHashSetW, arrayList, this.f58m, c0941a.f5185f, c0941a.u.b));
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        MemoizedFunctionToNullable memoizedFunctionToNullable;
        ClassDescriptor classDescriptor;
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        recordLookup(name, location);
        r rVar = this.b;
        return (rVar == null || (memoizedFunctionToNullable = rVar.f64t) == null || (classDescriptor = (ClassDescriptor) memoizedFunctionToNullable.invoke(name)) == null) ? (ClassifierDescriptor) this.f64t.invoke(name) : classDescriptor;
    }

    @Override // A2.G, U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        recordLookup(name, location);
        return super.getContributedFunctions(name, location);
    }

    @Override // A2.G, U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        recordLookup(name, location);
        return super.getContributedVariables(name, location);
    }

    @Override // A2.G
    public final Set h(U2.f kindFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        if (this.f59n.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((DeclaredMemberIndex) this.d.invoke()).getFieldNames());
        Collection<AbstractC0162z> supertypes = this.f58m.getTypeConstructor().getSupertypes();
        kotlin.jvm.internal.h.e(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            kotlin.collections.s.F(((AbstractC0162z) it.next()).getMemberScope().getVariableNames(), linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // A2.G
    public final ReceiverParameterDescriptor i() {
        ClassDescriptor classDescriptor = this.f58m;
        if (classDescriptor != null) {
            int i = N2.f.f1135a;
            return classDescriptor.getThisAsReceiverParameter();
        }
        N2.f.a(0);
        throw null;
    }

    @Override // A2.G
    public final DeclarationDescriptor j() {
        return this.f58m;
    }

    @Override // A2.G
    public final boolean k(y2.e eVar) {
        if (this.f59n.isAnnotationType()) {
            return false;
        }
        return G(eVar);
    }

    @Override // A2.G
    public final A l(JavaMethod method, ArrayList arrayList, AbstractC0162z abstractC0162z, List list) {
        kotlin.jvm.internal.h.f(method, "method");
        C0941a c0941a = this.f11a.f5204a;
        C0924k c0924kResolvePropagatedSignature = c0941a.e.resolvePropagatedSignature(method, this.f58m, abstractC0162z, null, list, arrayList);
        kotlin.jvm.internal.h.e(c0924kResolvePropagatedSignature, "c.components.signaturePr…dTypeParameters\n        )");
        AbstractC0162z abstractC0162z2 = c0924kResolvePropagatedSignature.f5124a;
        if (abstractC0162z2 == null) {
            C0924k.a(4);
            throw null;
        }
        List list2 = c0924kResolvePropagatedSignature.c;
        if (list2 == null) {
            C0924k.a(5);
            throw null;
        }
        List list3 = c0924kResolvePropagatedSignature.d;
        if (list3 == null) {
            C0924k.a(6);
            throw null;
        }
        List list4 = Collections.EMPTY_LIST;
        if (list4 != null) {
            return new A(abstractC0162z2, c0924kResolvePropagatedSignature.b, list2, list3, list4);
        }
        C0924k.a(7);
        throw null;
    }

    public final void q(ArrayList arrayList, C0931a c0931a, int i, JavaMethod javaMethod, AbstractC0162z abstractC0162z, AbstractC0162z abstractC0162z2) {
        Annotations.Companion.getClass();
        o2.e eVar = o2.f.b;
        L2.f name = javaMethod.getName();
        if (abstractC0162z != null) {
            arrayList.add(new S(c0931a, null, i, eVar, name, a3.b0.h(abstractC0162z, false), javaMethod.getHasAnnotationParameterDefaultValue(), false, false, abstractC0162z2 != null ? a3.b0.h(abstractC0162z2, false) : null, this.f11a.f5204a.f5188j.source(javaMethod)));
        } else {
            a3.b0.a(2);
            throw null;
        }
    }

    public final void r(LinkedHashSet linkedHashSet, L2.f fVar, ArrayList arrayList, boolean z6) {
        C0941a c0941a = this.f11a.f5204a;
        LinkedHashSet<SimpleFunctionDescriptor> linkedHashSetO = k1.j.o(fVar, arrayList, linkedHashSet, this.f58m, c0941a.f5185f, c0941a.u.b);
        if (!z6) {
            linkedHashSet.addAll(linkedHashSetO);
            return;
        }
        ArrayList arrayListB0 = kotlin.collections.m.b0(linkedHashSetO, linkedHashSet);
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(linkedHashSetO));
        for (SimpleFunctionDescriptor simpleFunctionDescriptorV : linkedHashSetO) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) b0.q(simpleFunctionDescriptorV);
            if (simpleFunctionDescriptor != null) {
                simpleFunctionDescriptorV = v(simpleFunctionDescriptorV, simpleFunctionDescriptor, arrayListB0);
            }
            arrayList2.add(simpleFunctionDescriptorV);
        }
        linkedHashSet.addAll(arrayList2);
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final void recordLookup(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        C0941a c0941a = this.f11a.f5204a;
        Z.t(c0941a.f5192n, location, this.f58m, name);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(L2.f r9, java.util.LinkedHashSet r10, java.util.LinkedHashSet r11, java.util.AbstractSet r12, kotlin.jvm.functions.Function1 r13) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A2.r.s(L2.f, java.util.LinkedHashSet, java.util.LinkedHashSet, java.util.AbstractSet, kotlin.jvm.functions.Function1):void");
    }

    public final void t(Set set, AbstractCollection abstractCollection, j3.m mVar, Function1 function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptorC;
        q2.K kM;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) it.next();
            C0932b c0932b = null;
            if (x(propertyDescriptor, function1)) {
                SimpleFunctionDescriptor simpleFunctionDescriptorB = B(propertyDescriptor, function1);
                kotlin.jvm.internal.h.c(simpleFunctionDescriptorB);
                if (propertyDescriptor.isVar()) {
                    simpleFunctionDescriptorC = C(propertyDescriptor, function1);
                    kotlin.jvm.internal.h.c(simpleFunctionDescriptorC);
                } else {
                    simpleFunctionDescriptorC = null;
                }
                if (simpleFunctionDescriptorC != null) {
                    simpleFunctionDescriptorC.getModality();
                    simpleFunctionDescriptorB.getModality();
                }
                C0932b c0932b2 = new C0932b(this.f58m, simpleFunctionDescriptorB, simpleFunctionDescriptorC, propertyDescriptor);
                AbstractC0162z returnType = simpleFunctionDescriptorB.getReturnType();
                kotlin.jvm.internal.h.c(returnType);
                kotlin.collections.u uVar = kotlin.collections.u.f3805a;
                c0932b2.m(returnType, uVar, i(), null, uVar);
                q2.J jL = N2.q.l(c0932b2, simpleFunctionDescriptorB.getAnnotations(), false, simpleFunctionDescriptorB.getSource());
                jL.f4551l = simpleFunctionDescriptorB;
                jL.i(c0932b2.getType());
                if (simpleFunctionDescriptorC != null) {
                    List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptorC.getValueParameters();
                    kotlin.jvm.internal.h.e(valueParameters, "setterMethod.valueParameters");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) kotlin.collections.m.R(valueParameters);
                    if (valueParameterDescriptor == null) {
                        throw new AssertionError("No parameter found for " + simpleFunctionDescriptorC);
                    }
                    kM = N2.q.m(c0932b2, simpleFunctionDescriptorC.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, simpleFunctionDescriptorC.getVisibility(), simpleFunctionDescriptorC.getSource());
                    kM.f4551l = simpleFunctionDescriptorC;
                } else {
                    kM = null;
                }
                c0932b2.k(jL, kM, null, null);
                c0932b = c0932b2;
            }
            if (c0932b != null) {
                abstractCollection.add(c0932b);
                if (mVar != null) {
                    mVar.add(propertyDescriptor);
                    return;
                }
                return;
            }
        }
    }

    @Override // A2.G
    public final String toString() {
        return "Lazy Java member scope for " + this.f59n.getFqName();
    }

    public final Collection u() {
        boolean z6 = this.f60o;
        ClassDescriptor classDescriptor = this.f58m;
        if (z6) {
            Collection<AbstractC0162z> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            kotlin.jvm.internal.h.e(supertypes, "ownerDescriptor.typeConstructor.supertypes");
            return supertypes;
        }
        this.f11a.f5204a.u.getClass();
        kotlin.jvm.internal.h.f(classDescriptor, "classDescriptor");
        Collection<AbstractC0162z> supertypes2 = classDescriptor.getTypeConstructor().getSupertypes();
        kotlin.jvm.internal.h.e(supertypes2, "classDescriptor.typeConstructor.supertypes");
        return supertypes2;
    }

    public final boolean x(PropertyDescriptor propertyDescriptor, Function1 function1) {
        if (AbstractC0246d.Y(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptorB = B(propertyDescriptor, function1);
        SimpleFunctionDescriptor simpleFunctionDescriptorC = C(propertyDescriptor, function1);
        if (simpleFunctionDescriptorB == null) {
            return false;
        }
        if (propertyDescriptor.isVar()) {
            return simpleFunctionDescriptorC != null && simpleFunctionDescriptorC.getModality() == simpleFunctionDescriptorB.getModality();
        }
        return true;
    }
}
