package a3;

import a.AbstractC0132a;
import d3.EnumC0418b;
import e3.C0431a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;

/* JADX INFO: renamed from: a3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0142e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0142e f1548a = new C0142e();

    public static final boolean b(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        if (classicTypeSystemContext.isIntegerLiteralType(simpleTypeMarker)) {
            return true;
        }
        if (!(simpleTypeMarker instanceof CapturedTypeMarker)) {
            return false;
        }
        TypeArgumentMarker typeArgumentMarkerProjection = classicTypeSystemContext.projection(classicTypeSystemContext.typeConstructor((CapturedTypeMarker) simpleTypeMarker));
        return !classicTypeSystemContext.isStarProjection(typeArgumentMarkerProjection) && classicTypeSystemContext.isIntegerLiteralType(classicTypeSystemContext.upperBoundIfFlexible(classicTypeSystemContext.getType(typeArgumentMarkerProjection)));
    }

    public static final boolean c(ClassicTypeSystemContext classicTypeSystemContext, Q q, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, boolean z6) {
        Collection<KotlinTypeMarker> collectionPossibleIntegerTypes = classicTypeSystemContext.possibleIntegerTypes(simpleTypeMarker);
        if (collectionPossibleIntegerTypes != null && collectionPossibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (KotlinTypeMarker kotlinTypeMarker : collectionPossibleIntegerTypes) {
            if (kotlin.jvm.internal.h.a(classicTypeSystemContext.typeConstructor(kotlinTypeMarker), classicTypeSystemContext.typeConstructor(simpleTypeMarker2))) {
                return true;
            }
            if (z6 && m(f1548a, q, simpleTypeMarker2, kotlinTypeMarker)) {
                return true;
            }
        }
        return false;
    }

    public static List d(Q q, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        P pSubstitutionSupertypePolicy;
        ClassicTypeSystemContext classicTypeSystemContext = q.c;
        List<SimpleTypeMarker> listFastCorrespondingSupertypes = classicTypeSystemContext.fastCorrespondingSupertypes(simpleTypeMarker, typeConstructorMarker);
        if (listFastCorrespondingSupertypes != null) {
            return listFastCorrespondingSupertypes;
        }
        boolean zIsClassTypeConstructor = classicTypeSystemContext.isClassTypeConstructor(typeConstructorMarker);
        kotlin.collections.u uVar = kotlin.collections.u.f3804a;
        if (zIsClassTypeConstructor || !classicTypeSystemContext.isClassType(simpleTypeMarker)) {
            boolean zIsCommonFinalClassConstructor = classicTypeSystemContext.isCommonFinalClassConstructor(typeConstructorMarker);
            EnumC0418b enumC0418b = EnumC0418b.f3119a;
            if (!zIsCommonFinalClassConstructor) {
                j3.j jVar = new j3.j();
                q.b();
                ArrayDeque arrayDeque = q.f1538g;
                kotlin.jvm.internal.h.c(arrayDeque);
                j3.m mVar = q.f1539h;
                kotlin.jvm.internal.h.c(mVar);
                arrayDeque.push(simpleTypeMarker);
                while (!arrayDeque.isEmpty()) {
                    if (mVar.b > 1000) {
                        StringBuilder sbN = B2.b.n("Too many supertypes for type: ", simpleTypeMarker, ". Supertypes = ");
                        sbN.append(kotlin.collections.m.V(mVar, null, null, null, null, 63));
                        throw new IllegalStateException(sbN.toString().toString());
                    }
                    SimpleTypeMarker current = (SimpleTypeMarker) arrayDeque.pop();
                    kotlin.jvm.internal.h.e(current, "current");
                    if (mVar.add(current)) {
                        SimpleTypeMarker simpleTypeMarkerCaptureFromArguments = classicTypeSystemContext.captureFromArguments(current, enumC0418b);
                        if (simpleTypeMarkerCaptureFromArguments == null) {
                            simpleTypeMarkerCaptureFromArguments = current;
                        }
                        boolean zAreEqualTypeConstructors = classicTypeSystemContext.areEqualTypeConstructors(classicTypeSystemContext.typeConstructor(simpleTypeMarkerCaptureFromArguments), typeConstructorMarker);
                        O o6 = O.c;
                        if (zAreEqualTypeConstructors) {
                            jVar.add(simpleTypeMarkerCaptureFromArguments);
                            pSubstitutionSupertypePolicy = o6;
                        } else {
                            pSubstitutionSupertypePolicy = classicTypeSystemContext.argumentsCount(simpleTypeMarkerCaptureFromArguments) == 0 ? O.b : classicTypeSystemContext.substitutionSupertypePolicy(simpleTypeMarkerCaptureFromArguments);
                        }
                        if (kotlin.jvm.internal.h.a(pSubstitutionSupertypePolicy, o6)) {
                            pSubstitutionSupertypePolicy = null;
                        }
                        if (pSubstitutionSupertypePolicy != null) {
                            Iterator<KotlinTypeMarker> it = classicTypeSystemContext.supertypes(classicTypeSystemContext.typeConstructor(current)).iterator();
                            while (it.hasNext()) {
                                arrayDeque.add(pSubstitutionSupertypePolicy.a(q, it.next()));
                            }
                        }
                    }
                }
                q.a();
                return jVar;
            }
            if (classicTypeSystemContext.areEqualTypeConstructors(classicTypeSystemContext.typeConstructor(simpleTypeMarker), typeConstructorMarker)) {
                SimpleTypeMarker simpleTypeMarkerCaptureFromArguments2 = classicTypeSystemContext.captureFromArguments(simpleTypeMarker, enumC0418b);
                if (simpleTypeMarkerCaptureFromArguments2 != null) {
                    simpleTypeMarker = simpleTypeMarkerCaptureFromArguments2;
                }
                return io.ktor.utils.io.Z.p(simpleTypeMarker);
            }
        }
        return uVar;
    }

    public static List e(Q q, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        int i;
        List listD = d(q, simpleTypeMarker, typeConstructorMarker);
        if (listD.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD) {
                ClassicTypeSystemContext classicTypeSystemContext = q.c;
                TypeArgumentListMarker typeArgumentListMarkerAsArgumentList = classicTypeSystemContext.asArgumentList((SimpleTypeMarker) obj);
                int size = classicTypeSystemContext.size(typeArgumentListMarkerAsArgumentList);
                while (true) {
                    if (i >= size) {
                        arrayList.add(obj);
                        break;
                    }
                    i = classicTypeSystemContext.asFlexibleType(classicTypeSystemContext.getType(classicTypeSystemContext.get(typeArgumentListMarkerAsArgumentList, i))) == null ? i + 1 : 0;
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return listD;
    }

    public static boolean g(Q q, KotlinTypeMarker a6, KotlinTypeMarker b) {
        kotlin.jvm.internal.h.f(a6, "a");
        kotlin.jvm.internal.h.f(b, "b");
        if (a6 == b) {
            return true;
        }
        C0142e c0142e = f1548a;
        ClassicTypeSystemContext classicTypeSystemContext = q.c;
        if (k(classicTypeSystemContext, a6) && k(classicTypeSystemContext, b)) {
            c0 c0VarC = q.c(q.d(a6));
            c0 c0VarC2 = q.c(q.d(b));
            SimpleTypeMarker simpleTypeMarkerLowerBoundIfFlexible = classicTypeSystemContext.lowerBoundIfFlexible(c0VarC);
            if (!classicTypeSystemContext.areEqualTypeConstructors(classicTypeSystemContext.typeConstructor(c0VarC), classicTypeSystemContext.typeConstructor(c0VarC2))) {
                return false;
            }
            if (classicTypeSystemContext.argumentsCount(simpleTypeMarkerLowerBoundIfFlexible) == 0) {
                return classicTypeSystemContext.hasFlexibleNullability(c0VarC) || classicTypeSystemContext.hasFlexibleNullability(c0VarC2) || classicTypeSystemContext.isMarkedNullable(simpleTypeMarkerLowerBoundIfFlexible) == classicTypeSystemContext.isMarkedNullable(classicTypeSystemContext.lowerBoundIfFlexible(c0VarC2));
            }
        }
        return m(c0142e, q, a6, b) && m(c0142e, q, b, a6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        return r6.getParameter(r6.typeConstructor(r7), r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker j(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext r6, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r7, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r8) {
        /*
            int r0 = r6.argumentsCount(r7)
            r1 = 0
            r2 = r1
        L6:
            r3 = 0
            if (r2 >= r0) goto L66
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker r4 = r6.getArgument(r7, r2)
            boolean r5 = r6.isStarProjection(r4)
            if (r5 != 0) goto L14
            r3 = r4
        L14:
            if (r3 == 0) goto L63
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = r6.getType(r3)
            if (r3 != 0) goto L1d
            goto L63
        L1d:
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r4 = r6.lowerBoundIfFlexible(r3)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r4 = r6.originalIfDefinitelyNotNullable(r4)
            boolean r4 = r6.isCapturedType(r4)
            if (r4 == 0) goto L3b
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r4 = r6.lowerBoundIfFlexible(r8)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r4 = r6.originalIfDefinitelyNotNullable(r4)
            boolean r4 = r6.isCapturedType(r4)
            if (r4 == 0) goto L3b
            r4 = 1
            goto L3c
        L3b:
            r4 = r1
        L3c:
            boolean r5 = r3.equals(r8)
            if (r5 != 0) goto L5a
            if (r4 == 0) goto L53
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r4 = r6.typeConstructor(r3)
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r5 = r6.typeConstructor(r8)
            boolean r4 = kotlin.jvm.internal.h.a(r4, r5)
            if (r4 == 0) goto L53
            goto L5a
        L53:
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r3 = j(r6, r3, r8)
            if (r3 == 0) goto L63
            return r3
        L5a:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r7 = r6.typeConstructor(r7)
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r6 = r6.getParameter(r7, r2)
            return r6
        L63:
            int r2 = r2 + 1
            goto L6
        L66:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0142e.j(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker");
    }

    public static boolean k(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        return (!classicTypeSystemContext.isDenotable(classicTypeSystemContext.typeConstructor(kotlinTypeMarker)) || classicTypeSystemContext.isDynamic(kotlinTypeMarker) || classicTypeSystemContext.isDefinitelyNotNullType(kotlinTypeMarker) || classicTypeSystemContext.isNotNullTypeParameter(kotlinTypeMarker) || !kotlin.jvm.internal.h.a(classicTypeSystemContext.typeConstructor(classicTypeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker)), classicTypeSystemContext.typeConstructor(classicTypeSystemContext.upperBoundIfFlexible(kotlinTypeMarker)))) ? false : true;
    }

    public static boolean l(Q q, TypeArgumentListMarker capturedSubArguments, SimpleTypeMarker simpleTypeMarker) {
        boolean zM;
        kotlin.jvm.internal.h.f(capturedSubArguments, "capturedSubArguments");
        ClassicTypeSystemContext classicTypeSystemContext = q.c;
        TypeConstructorMarker typeConstructorMarkerTypeConstructor = classicTypeSystemContext.typeConstructor(simpleTypeMarker);
        int size = classicTypeSystemContext.size(capturedSubArguments);
        int iParametersCount = classicTypeSystemContext.parametersCount(typeConstructorMarkerTypeConstructor);
        if (size == iParametersCount && size == classicTypeSystemContext.argumentsCount(simpleTypeMarker)) {
            for (int i = 0; i < iParametersCount; i++) {
                TypeArgumentMarker argument = classicTypeSystemContext.getArgument(simpleTypeMarker, i);
                if (!classicTypeSystemContext.isStarProjection(argument)) {
                    KotlinTypeMarker type = classicTypeSystemContext.getType(argument);
                    TypeArgumentMarker typeArgumentMarker = classicTypeSystemContext.get(capturedSubArguments, i);
                    classicTypeSystemContext.getVariance(typeArgumentMarker);
                    KotlinTypeMarker type2 = classicTypeSystemContext.getType(typeArgumentMarker);
                    d3.c declared = classicTypeSystemContext.getVariance(classicTypeSystemContext.getParameter(typeConstructorMarkerTypeConstructor, i));
                    d3.c useSite = classicTypeSystemContext.getVariance(argument);
                    kotlin.jvm.internal.h.f(declared, "declared");
                    kotlin.jvm.internal.h.f(useSite, "useSite");
                    d3.c cVar = d3.c.INV;
                    if (declared == cVar) {
                        declared = useSite;
                    } else if (useSite != cVar && declared != useSite) {
                        declared = null;
                    }
                    if (declared == null) {
                        return q.f1536a;
                    }
                    C0142e c0142e = f1548a;
                    if (declared != cVar || (!n(classicTypeSystemContext, type2, type, typeConstructorMarkerTypeConstructor) && !n(classicTypeSystemContext, type, type2, typeConstructorMarkerTypeConstructor))) {
                        int i3 = q.f1537f;
                        if (i3 > 100) {
                            throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + type2).toString());
                        }
                        q.f1537f = i3 + 1;
                        int iOrdinal = declared.ordinal();
                        if (iOrdinal == 0) {
                            zM = m(c0142e, q, type, type2);
                        } else if (iOrdinal == 1) {
                            zM = m(c0142e, q, type2, type);
                        } else {
                            if (iOrdinal != 2) {
                                throw new C0.x();
                            }
                            zM = g(q, type2, type);
                        }
                        q.f1537f--;
                        if (!zM) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x032a A[EDGE_INSN: B:376:0x032a->B:205:0x032a BREAK  A[LOOP:10: B:195:0x0307->B:378:0x0307]] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0155  */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext] */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v9, types: [int] */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m(a3.C0142e r25, a3.Q r26, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r27, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r28) {
        /*
            Method dump skipped, instruction units count: 1499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0142e.m(a3.e, a3.Q, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker):boolean");
    }

    public static boolean n(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, TypeConstructorMarker typeConstructorMarker) {
        TypeParameterMarker typeParameter;
        SimpleTypeMarker simpleTypeMarkerAsSimpleType = classicTypeSystemContext.asSimpleType(kotlinTypeMarker);
        if (!(simpleTypeMarkerAsSimpleType instanceof CapturedTypeMarker)) {
            return false;
        }
        CapturedTypeMarker capturedTypeMarker = (CapturedTypeMarker) simpleTypeMarkerAsSimpleType;
        if (classicTypeSystemContext.isOldCapturedType(capturedTypeMarker) || !classicTypeSystemContext.isStarProjection(classicTypeSystemContext.projection(classicTypeSystemContext.typeConstructor(capturedTypeMarker))) || classicTypeSystemContext.captureStatus(capturedTypeMarker) != EnumC0418b.f3119a) {
            return false;
        }
        TypeConstructorMarker typeConstructorMarkerTypeConstructor = classicTypeSystemContext.typeConstructor(kotlinTypeMarker2);
        TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker = typeConstructorMarkerTypeConstructor instanceof TypeVariableTypeConstructorMarker ? (TypeVariableTypeConstructorMarker) typeConstructorMarkerTypeConstructor : null;
        return (typeVariableTypeConstructorMarker == null || (typeParameter = classicTypeSystemContext.getTypeParameter(typeVariableTypeConstructorMarker)) == null || !classicTypeSystemContext.hasRecursiveBounds(typeParameter, typeConstructorMarker)) ? false : true;
    }

    public static C0152o o(c0 type, boolean z6) {
        boolean zF;
        kotlin.jvm.internal.h.f(type, "type");
        if (type instanceof C0152o) {
            return (C0152o) type;
        }
        if ((type.c() instanceof NewTypeVariableConstructor) || (type.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor) || (type instanceof b3.f)) {
            ClassifierDescriptor declarationDescriptor = type.c().getDeclarationDescriptor();
            q2.P p5 = declarationDescriptor instanceof q2.P ? (q2.P) declarationDescriptor : null;
            zF = true;
            if (p5 == null || p5.f4578l) {
                zF = (z6 && (type.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) ? b0.f(type) : true ^ kotlin.reflect.l.L(b3.e.n(false, null, 24), AbstractC0132a.Q(type), O.b);
            }
        } else {
            zF = false;
        }
        if (!zF) {
            return null;
        }
        if (type instanceof AbstractC0155s) {
            AbstractC0155s abstractC0155s = (AbstractC0155s) type;
            kotlin.jvm.internal.h.a(abstractC0155s.b.c(), abstractC0155s.c.c());
        }
        return new C0152o(AbstractC0132a.Q(type).g(false), z6);
    }

    public void a(Annotations annotations, Annotations annotations2) {
        HashSet hashSet = new HashSet();
        Iterator<AnnotationDescriptor> it = annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getFqName());
        }
        Iterator<AnnotationDescriptor> it2 = annotations2.iterator();
        while (it2.hasNext()) {
            hashSet.contains(it2.next().getFqName());
        }
    }

    public W f(TypeConstructor typeConstructor, List arguments) {
        kotlin.jvm.internal.h.f(typeConstructor, "typeConstructor");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        kotlin.jvm.internal.h.e(parameters, "typeConstructor.parameters");
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) kotlin.collections.m.Y(parameters);
        if (typeParameterDescriptor == null || !typeParameterDescriptor.isCapturedFromOuterDeclaration()) {
            return new C0158v((TypeParameterDescriptor[]) parameters.toArray(new TypeParameterDescriptor[0]), (TypeProjection[]) arguments.toArray(new TypeProjection[0]), false);
        }
        List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
        kotlin.jvm.internal.h.e(parameters2, "typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(parameters2));
        Iterator<T> it = parameters2.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeParameterDescriptor) it.next()).getTypeConstructor());
        }
        return new L(kotlin.collections.A.L(kotlin.collections.m.u0(arrayList, arguments)), 1);
    }

    public F h(C0.t tVar, M m6, boolean z6, int i, boolean z7) {
        M mB;
        d0 d0Var = d0.INVARIANT;
        TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) tVar.c;
        TypeProjection typeProjectionI = i(new K(typeAliasDescriptor.getUnderlyingType(), d0Var), tVar, null, i);
        AbstractC0162z type = typeProjectionI.getType();
        kotlin.jvm.internal.h.e(type, "expandedProjection.type");
        F fH = AbstractC0132a.h(type);
        if (kotlin.reflect.l.O(fH)) {
            return fH;
        }
        typeProjectionI.getProjectionKind();
        a(fH.getAnnotations(), AbstractC0149l.a(m6));
        if (!kotlin.reflect.l.O(fH)) {
            if (kotlin.reflect.l.O(fH)) {
                mB = fH.b();
            } else {
                M other = fH.b();
                kotlin.jvm.internal.h.f(other, "other");
                if (m6.isEmpty() && other.isEmpty()) {
                    mB = m6;
                } else {
                    ArrayList arrayList = new ArrayList();
                    Collection collectionValues = ((ConcurrentHashMap) M.b.b).values();
                    kotlin.jvm.internal.h.e(collectionValues, "idPerType.values");
                    Iterator it = collectionValues.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Number) it.next()).intValue();
                        C0148k c0148k = (C0148k) m6.f3308a.get(iIntValue);
                        C0148k c0148k2 = (C0148k) other.f3308a.get(iIntValue);
                        if (c0148k != null) {
                            if (c0148k2 != null) {
                                c0148k = new C0148k(io.ktor.utils.io.b0.d(c0148k.f1554a, c0148k2.f1554a));
                            }
                            c0148k2 = c0148k;
                        } else if (c0148k2 == null) {
                            c0148k2 = null;
                        } else if (c0148k != null) {
                            c0148k2 = new C0148k(io.ktor.utils.io.b0.d(c0148k2.f1554a, c0148k.f1554a));
                        }
                        if (c0148k2 != null) {
                            arrayList.add(c0148k2);
                        }
                    }
                    mB = B.h.b(arrayList);
                }
            }
            fH = AbstractC0132a.Z(fH, null, mB, 1);
        }
        F fJ = b0.j(fH, z6);
        if (!z7) {
            return fJ;
        }
        TypeConstructor typeConstructor = typeAliasDescriptor.getTypeConstructor();
        kotlin.jvm.internal.h.e(typeConstructor, "descriptor.typeConstructor");
        return C5.f.n0(fJ, C.d(m6, (List) tVar.d, U2.m.f1338a, typeConstructor, z6));
    }

    public TypeProjection i(TypeProjection typeProjection, C0.t tVar, TypeParameterDescriptor typeParameterDescriptor, int i) {
        d0 variance;
        TypeAliasDescriptor typeAlias = (TypeAliasDescriptor) tVar.c;
        if (i > 100) {
            throw new AssertionError("Too deep recursion while expanding type alias " + typeAlias.getName());
        }
        if (typeProjection.isStarProjection()) {
            kotlin.jvm.internal.h.c(typeParameterDescriptor);
            return b0.k(typeParameterDescriptor);
        }
        AbstractC0162z type = typeProjection.getType();
        kotlin.jvm.internal.h.e(type, "underlyingProjection.type");
        TypeConstructor constructor = type.c();
        kotlin.jvm.internal.h.f(constructor, "constructor");
        ClassifierDescriptor declarationDescriptor = constructor.getDeclarationDescriptor();
        TypeProjection typeProjection2 = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeProjection) ((Map) tVar.e).get(declarationDescriptor) : null;
        d0 d0Var = d0.INVARIANT;
        if (typeProjection2 != null) {
            if (typeProjection2.isStarProjection()) {
                kotlin.jvm.internal.h.c(typeParameterDescriptor);
                return b0.k(typeParameterDescriptor);
            }
            c0 c0VarF = typeProjection2.getType().f();
            d0 projectionKind = typeProjection2.getProjectionKind();
            kotlin.jvm.internal.h.e(projectionKind, "argument.projectionKind");
            d0 projectionKind2 = typeProjection.getProjectionKind();
            kotlin.jvm.internal.h.e(projectionKind2, "underlyingProjection.projectionKind");
            if (projectionKind2 != projectionKind && projectionKind2 != d0Var) {
                if (projectionKind == d0Var) {
                    projectionKind = projectionKind2;
                } else {
                    kotlin.jvm.internal.h.f(typeAlias, "typeAlias");
                }
            }
            if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null) {
                variance = d0Var;
            }
            if (variance == projectionKind || variance == d0Var) {
                d0Var = projectionKind;
            } else if (projectionKind != d0Var) {
                kotlin.jvm.internal.h.f(typeAlias, "typeAlias");
                d0Var = projectionKind;
            }
            a(type.getAnnotations(), c0VarF.getAnnotations());
            F fJ = b0.j(AbstractC0132a.h(c0VarF), type.d());
            M mB = type.b();
            if (!kotlin.reflect.l.O(fJ)) {
                if (kotlin.reflect.l.O(fJ)) {
                    mB = fJ.b();
                } else {
                    M other = fJ.b();
                    mB.getClass();
                    kotlin.jvm.internal.h.f(other, "other");
                    if (!mB.isEmpty() || !other.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        Collection collectionValues = ((ConcurrentHashMap) M.b.b).values();
                        kotlin.jvm.internal.h.e(collectionValues, "idPerType.values");
                        Iterator it = collectionValues.iterator();
                        while (it.hasNext()) {
                            int iIntValue = ((Number) it.next()).intValue();
                            C0148k c0148k = (C0148k) mB.f3308a.get(iIntValue);
                            C0148k c0148k2 = (C0148k) other.f3308a.get(iIntValue);
                            if (c0148k != null) {
                                if (c0148k2 != null) {
                                    c0148k = new C0148k(io.ktor.utils.io.b0.d(c0148k.f1554a, c0148k2.f1554a));
                                }
                                c0148k2 = c0148k;
                            } else if (c0148k2 == null) {
                                c0148k2 = null;
                            } else if (c0148k != null) {
                                c0148k2 = new C0148k(io.ktor.utils.io.b0.d(c0148k2.f1554a, c0148k.f1554a));
                            }
                            if (c0148k2 != null) {
                                arrayList.add(c0148k2);
                            }
                        }
                        mB = B.h.b(arrayList);
                    }
                }
                fJ = AbstractC0132a.Z(fJ, null, mB, 1);
            }
            return new K(fJ, d0Var);
        }
        F fH = AbstractC0132a.h(typeProjection.getType().f());
        if (!kotlin.reflect.l.O(fH)) {
            e3.b predicate = e3.b.f3135a;
            kotlin.jvm.internal.h.f(predicate, "predicate");
            if (b0.d(fH, predicate, null)) {
                TypeConstructor typeConstructorC = fH.c();
                ClassifierDescriptor declarationDescriptor2 = typeConstructorC.getDeclarationDescriptor();
                typeConstructorC.getParameters().size();
                fH.a().size();
                if (!(declarationDescriptor2 instanceof TypeParameterDescriptor)) {
                    int i3 = 0;
                    if (!(declarationDescriptor2 instanceof TypeAliasDescriptor)) {
                        F fP = p(fH, tVar, i);
                        Z.d(fP);
                        for (Object obj : fP.a()) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                kotlin.collections.n.C();
                                throw null;
                            }
                            TypeProjection typeProjection3 = (TypeProjection) obj;
                            if (!typeProjection3.isStarProjection()) {
                                AbstractC0162z type2 = typeProjection3.getType();
                                kotlin.jvm.internal.h.e(type2, "substitutedArgument.type");
                                C0431a predicate2 = C0431a.f3134a;
                                kotlin.jvm.internal.h.f(predicate2, "predicate");
                                if (!b0.d(type2, predicate2, null)) {
                                    fH.c().getParameters().get(i3);
                                }
                            }
                            i3 = i4;
                        }
                        return new K(fP, typeProjection.getProjectionKind());
                    }
                    TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) declarationDescriptor2;
                    if (tVar.k(typeAliasDescriptor)) {
                        c3.i iVar = c3.i.RECURSIVE_TYPE_ALIAS;
                        String str = typeAliasDescriptor.getName().f962a;
                        kotlin.jvm.internal.h.e(str, "typeDescriptor.name.toString()");
                        return new K(c3.j.c(iVar, str), d0Var);
                    }
                    List listA = fH.a();
                    ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(listA));
                    for (Object obj2 : listA) {
                        int i5 = i3 + 1;
                        if (i3 < 0) {
                            kotlin.collections.n.C();
                            throw null;
                        }
                        arrayList2.add(i((TypeProjection) obj2, tVar, typeConstructorC.getParameters().get(i3), i + 1));
                        i3 = i5;
                    }
                    List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
                    kotlin.jvm.internal.h.e(parameters, "typeAliasDescriptor.typeConstructor.parameters");
                    ArrayList arrayList3 = new ArrayList(kotlin.collections.o.D(parameters));
                    Iterator<T> it2 = parameters.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((TypeParameterDescriptor) it2.next()).getOriginal());
                    }
                    return new K(C5.f.n0(h(new C0.t(tVar, typeAliasDescriptor, arrayList2, kotlin.collections.A.L(kotlin.collections.m.u0(arrayList3, arrayList2)), 10), fH.b(), fH.d(), i + 1, false), p(fH, tVar, i)), typeProjection.getProjectionKind());
                }
            }
        }
        return typeProjection;
    }

    public F p(F f6, C0.t tVar, int i) {
        TypeConstructor typeConstructorC = f6.c();
        List listA = f6.a();
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(listA));
        int i3 = 0;
        for (Object obj : listA) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                kotlin.collections.n.C();
                throw null;
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            TypeProjection typeProjectionI = i(typeProjection, tVar, typeConstructorC.getParameters().get(i3), i + 1);
            if (!typeProjectionI.isStarProjection()) {
                typeProjectionI = new K(b0.i(typeProjectionI.getType(), typeProjection.getType().d()), typeProjectionI.getProjectionKind());
            }
            arrayList.add(typeProjectionI);
            i3 = i4;
        }
        return AbstractC0132a.Z(f6, arrayList, null, 2);
    }
}
