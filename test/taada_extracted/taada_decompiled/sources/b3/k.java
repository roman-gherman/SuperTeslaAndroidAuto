package b3;

import C0.x;
import a.AbstractC0132a;
import a3.AbstractC0155s;
import a3.C;
import a3.C0152o;
import a3.F;
import a3.P;
import a3.c0;
import d3.C0417a;
import d3.EnumC0418b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RawTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements ClassicTypeSystemContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f1707a = new k();

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean areEqualTypeConstructors(TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2) {
        return e.b(typeConstructorMarker, typeConstructorMarker2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final int argumentsCount(KotlinTypeMarker kotlinTypeMarker) {
        return e.c(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeArgumentListMarker asArgumentList(SimpleTypeMarker simpleTypeMarker) {
        return e.d(simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final CapturedTypeMarker asCapturedType(SimpleTypeMarker simpleTypeMarker) {
        return e.e(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker simpleTypeMarker) {
        return e.f(simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final DynamicTypeMarker asDynamicType(FlexibleTypeMarker flexibleTypeMarker) {
        e.g(flexibleTypeMarker);
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final FlexibleTypeMarker asFlexibleType(KotlinTypeMarker kotlinTypeMarker) {
        return e.h(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final RawTypeMarker asRawType(FlexibleTypeMarker flexibleTypeMarker) {
        return e.i(flexibleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final SimpleTypeMarker asSimpleType(KotlinTypeMarker kotlinTypeMarker) {
        return e.j(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeArgumentMarker asTypeArgument(KotlinTypeMarker kotlinTypeMarker) {
        return e.k(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final SimpleTypeMarker captureFromArguments(SimpleTypeMarker simpleTypeMarker, EnumC0418b enumC0418b) {
        return e.l(simpleTypeMarker, enumC0418b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final EnumC0418b captureStatus(CapturedTypeMarker capturedTypeMarker) {
        return e.m(capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
    public final KotlinTypeMarker createFlexibleType(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        return e.o(this, simpleTypeMarker, simpleTypeMarker2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final List fastCorrespondingSupertypes(SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker constructor) {
        kotlin.jvm.internal.h.f(simpleTypeMarker, "<this>");
        kotlin.jvm.internal.h.f(constructor, "constructor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeArgumentMarker get(TypeArgumentListMarker typeArgumentListMarker, int i) {
        kotlin.jvm.internal.h.f(typeArgumentListMarker, "<this>");
        if (typeArgumentListMarker instanceof SimpleTypeMarker) {
            return e.r((KotlinTypeMarker) typeArgumentListMarker, i);
        }
        if (typeArgumentListMarker instanceof C0417a) {
            E e = ((C0417a) typeArgumentListMarker).get(i);
            kotlin.jvm.internal.h.e(e, "get(index)");
            return (TypeArgumentMarker) e;
        }
        throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + ", " + w.f3817a.b(typeArgumentListMarker.getClass())).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeArgumentMarker getArgument(KotlinTypeMarker kotlinTypeMarker, int i) {
        return e.r(kotlinTypeMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker simpleTypeMarker, int i) {
        kotlin.jvm.internal.h.f(simpleTypeMarker, "<this>");
        if (i < 0 || i >= e.c(simpleTypeMarker)) {
            return null;
        }
        return e.r(simpleTypeMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final List getArguments(KotlinTypeMarker kotlinTypeMarker) {
        return e.s(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public final L2.e getClassFqNameUnsafe(TypeConstructorMarker typeConstructorMarker) {
        return e.t(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeParameterMarker getParameter(TypeConstructorMarker typeConstructorMarker, int i) {
        return e.u(typeConstructorMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final List getParameters(TypeConstructorMarker typeConstructorMarker) {
        return e.v(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public final k2.k getPrimitiveArrayType(TypeConstructorMarker typeConstructorMarker) {
        return e.w(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public final k2.k getPrimitiveType(TypeConstructorMarker typeConstructorMarker) {
        return e.x(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public final KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker typeParameterMarker) {
        return e.y(typeParameterMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final KotlinTypeMarker getType(TypeArgumentMarker typeArgumentMarker) {
        return e.z(typeArgumentMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker) {
        return e.A(typeVariableTypeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker typeConstructorMarker) {
        return e.B(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public final KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker kotlinTypeMarker) {
        return e.C(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final List getUpperBounds(TypeParameterMarker typeParameterMarker) {
        return e.D(typeParameterMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final d3.c getVariance(TypeArgumentMarker typeArgumentMarker) {
        return e.E(typeArgumentMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public final boolean hasAnnotation(KotlinTypeMarker kotlinTypeMarker, L2.c cVar) {
        return e.G(kotlinTypeMarker, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean hasFlexibleNullability(KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        return e.R(lowerBoundIfFlexible(kotlinTypeMarker)) != e.R(upperBoundIfFlexible(kotlinTypeMarker));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean hasRecursiveBounds(TypeParameterMarker typeParameterMarker, TypeConstructorMarker typeConstructorMarker) {
        return e.H(typeParameterMarker, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
    public final boolean identicalArguments(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        return e.I(simpleTypeMarker, simpleTypeMarker2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final KotlinTypeMarker intersectTypes(List types) {
        F f6;
        kotlin.jvm.internal.h.f(types, "types");
        int size = types.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types");
        }
        if (size == 1) {
            return (c0) kotlin.collections.m.g0(types);
        }
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(types));
        Iterator it = types.iterator();
        boolean z6 = false;
        boolean z7 = false;
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            z6 = z6 || kotlin.reflect.l.O(c0Var);
            if (c0Var instanceof F) {
                f6 = (F) c0Var;
            } else {
                if (!(c0Var instanceof AbstractC0155s)) {
                    throw new x();
                }
                kotlin.jvm.internal.h.f(c0Var, "<this>");
                f6 = ((AbstractC0155s) c0Var).b;
                z7 = true;
            }
            arrayList.add(f6);
        }
        if (z6) {
            return c3.j.c(c3.i.INTERSECTION_OF_ERROR_TYPES, types.toString());
        }
        s sVar = s.f1711a;
        if (!z7) {
            return sVar.b(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(types));
        Iterator it2 = types.iterator();
        while (it2.hasNext()) {
            arrayList2.add(AbstractC0132a.j0((c0) it2.next()));
        }
        return C.a(sVar.b(arrayList), sVar.b(arrayList2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isAnyConstructor(TypeConstructorMarker typeConstructorMarker) {
        return e.J(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isCapturedType(KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        F fJ = e.j(kotlinTypeMarker);
        return (fJ != null ? e.e(this, fJ) : null) != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isClassType(SimpleTypeMarker simpleTypeMarker) {
        kotlin.jvm.internal.h.f(simpleTypeMarker, "<this>");
        return e.K(e.l0(simpleTypeMarker));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isClassTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
        return e.K(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isCommonFinalClassConstructor(TypeConstructorMarker typeConstructorMarker) {
        return e.L(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isDefinitelyNotNullType(KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        F fJ = e.j(kotlinTypeMarker);
        return (fJ != null ? e.f(fJ) : null) != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isDenotable(TypeConstructorMarker typeConstructorMarker) {
        return e.M(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isDynamic(KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        AbstractC0155s abstractC0155sH = e.h(kotlinTypeMarker);
        if (abstractC0155sH == null) {
            return false;
        }
        e.g(abstractC0155sH);
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isError(KotlinTypeMarker kotlinTypeMarker) {
        return e.N(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public final boolean isInlineClass(TypeConstructorMarker typeConstructorMarker) {
        return e.O(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isIntegerLiteralType(SimpleTypeMarker simpleTypeMarker) {
        kotlin.jvm.internal.h.f(simpleTypeMarker, "<this>");
        return e.P(e.l0(simpleTypeMarker));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
        return e.P(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isIntersection(TypeConstructorMarker typeConstructorMarker) {
        return e.Q(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isMarkedNullable(SimpleTypeMarker simpleTypeMarker) {
        return e.R(simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isNotNullTypeParameter(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        return receiver instanceof NotNullTypeParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isNothing(KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        return e.S(typeConstructor(kotlinTypeMarker)) && !e.T(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isNothingConstructor(TypeConstructorMarker typeConstructorMarker) {
        return e.S(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isNullableType(KotlinTypeMarker kotlinTypeMarker) {
        return e.T(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isOldCapturedType(CapturedTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        return receiver instanceof O2.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isPrimitiveType(SimpleTypeMarker simpleTypeMarker) {
        return e.U(simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isProjectionNotNull(CapturedTypeMarker capturedTypeMarker) {
        return e.V(capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isSingleClassifierType(SimpleTypeMarker simpleTypeMarker) {
        return e.W(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isStarProjection(TypeArgumentMarker typeArgumentMarker) {
        return e.X(typeArgumentMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isStubType(SimpleTypeMarker simpleTypeMarker) {
        e.Y(simpleTypeMarker);
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isStubTypeForBuilderInference(SimpleTypeMarker simpleTypeMarker) {
        e.Z(simpleTypeMarker);
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isTypeVariableType(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        return (receiver instanceof c0) && (((c0) receiver).c() instanceof NewTypeVariableConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public final boolean isUnderKotlinPackage(TypeConstructorMarker typeConstructorMarker) {
        return e.a0(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final SimpleTypeMarker lowerBound(FlexibleTypeMarker flexibleTypeMarker) {
        return e.b0(flexibleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        F fB0;
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        AbstractC0155s abstractC0155sH = e.h(kotlinTypeMarker);
        if (abstractC0155sH != null && (fB0 = e.b0(abstractC0155sH)) != null) {
            return fB0;
        }
        F fJ = e.j(kotlinTypeMarker);
        kotlin.jvm.internal.h.c(fJ);
        return fJ;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final KotlinTypeMarker lowerType(CapturedTypeMarker capturedTypeMarker) {
        return e.c0(capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker kotlinTypeMarker) {
        return e.d0(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public final KotlinTypeMarker makeNullable(KotlinTypeMarker kotlinTypeMarker) {
        F fN0;
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        F fJ = e.j(kotlinTypeMarker);
        return (fJ == null || (fN0 = e.n0(fJ, true)) == null) ? kotlinTypeMarker : fN0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final SimpleTypeMarker original(DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
        return e.e0(definitelyNotNullTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final SimpleTypeMarker originalIfDefinitelyNotNullable(SimpleTypeMarker simpleTypeMarker) {
        F fE0;
        kotlin.jvm.internal.h.f(simpleTypeMarker, "<this>");
        C0152o c0152oF = e.f(simpleTypeMarker);
        return (c0152oF == null || (fE0 = e.e0(c0152oF)) == null) ? simpleTypeMarker : fE0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final int parametersCount(TypeConstructorMarker typeConstructorMarker) {
        return e.f0(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final Collection possibleIntegerTypes(SimpleTypeMarker simpleTypeMarker) {
        return e.g0(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeArgumentMarker projection(CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
        return e.h0(capturedTypeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final int size(TypeArgumentListMarker typeArgumentListMarker) {
        kotlin.jvm.internal.h.f(typeArgumentListMarker, "<this>");
        if (typeArgumentListMarker instanceof SimpleTypeMarker) {
            return e.c((KotlinTypeMarker) typeArgumentListMarker);
        }
        if (typeArgumentListMarker instanceof C0417a) {
            return ((C0417a) typeArgumentListMarker).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + ", " + w.f3817a.b(typeArgumentListMarker.getClass())).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final P substitutionSupertypePolicy(SimpleTypeMarker simpleTypeMarker) {
        return e.i0(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final Collection supertypes(TypeConstructorMarker typeConstructorMarker) {
        return e.j0(typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker capturedTypeMarker) {
        return e.k0(capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final SimpleTypeMarker upperBound(FlexibleTypeMarker flexibleTypeMarker) {
        return e.m0(flexibleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        F fM0;
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        AbstractC0155s abstractC0155sH = e.h(kotlinTypeMarker);
        if (abstractC0155sH != null && (fM0 = e.m0(abstractC0155sH)) != null) {
            return fM0;
        }
        F fJ = e.j(kotlinTypeMarker);
        kotlin.jvm.internal.h.c(fJ);
        return fJ;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final KotlinTypeMarker withNullability(KotlinTypeMarker kotlinTypeMarker, boolean z6) {
        return e.o0(this, kotlinTypeMarker, z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final d3.c getVariance(TypeParameterMarker typeParameterMarker) {
        return e.F(typeParameterMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final boolean isMarkedNullable(KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        return (kotlinTypeMarker instanceof SimpleTypeMarker) && e.R((SimpleTypeMarker) kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeConstructorMarker typeConstructor(KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        SimpleTypeMarker simpleTypeMarkerJ = e.j(kotlinTypeMarker);
        if (simpleTypeMarkerJ == null) {
            simpleTypeMarkerJ = lowerBoundIfFlexible(kotlinTypeMarker);
        }
        return e.l0(simpleTypeMarkerJ);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final SimpleTypeMarker withNullability(SimpleTypeMarker simpleTypeMarker, boolean z6) {
        return e.n0(simpleTypeMarker, z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public final TypeConstructorMarker typeConstructor(SimpleTypeMarker simpleTypeMarker) {
        return e.l0(simpleTypeMarker);
    }
}
