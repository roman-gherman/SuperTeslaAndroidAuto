package b3;

import a3.AbstractC0155s;
import a3.AbstractC0162z;
import a3.C;
import a3.C0152o;
import a3.C0161y;
import a3.F;
import a3.I;
import a3.K;
import a3.M;
import a3.Q;
import a3.S;
import a3.Z;
import a3.b0;
import a3.c0;
import a3.d0;
import c4.AbstractC0246d;
import d3.EnumC0418b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import n2.C0717i;
import n2.C0720l;
import n2.EnumC0711c;
import n2.EnumC0719k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements TypeCheckingProcedureCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0720l f1700a = new C0720l("KotlinTypeRefiner");

    public static TypeParameterDescriptor A(TypeVariableTypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof NewTypeVariableConstructor) {
            return ((NewTypeVariableConstructor) receiver).getOriginalTypeParameter();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static TypeParameterDescriptor B(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) receiver).getDeclarationDescriptor();
            if (declarationDescriptor instanceof TypeParameterDescriptor) {
                return (TypeParameterDescriptor) declarationDescriptor;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static F C(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0162z) {
            return N2.i.f((AbstractC0162z) receiver);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static List D(TypeParameterMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeParameterDescriptor) {
            List<AbstractC0162z> upperBounds = ((TypeParameterDescriptor) receiver).getUpperBounds();
            kotlin.jvm.internal.h.e(upperBounds, "this.upperBounds");
            return upperBounds;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static d3.c E(TypeArgumentMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeProjection) {
            d0 projectionKind = ((TypeProjection) receiver).getProjectionKind();
            kotlin.jvm.internal.h.e(projectionKind, "this.projectionKind");
            return C5.f.m(projectionKind);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static d3.c F(TypeParameterMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeParameterDescriptor) {
            d0 variance = ((TypeParameterDescriptor) receiver).getVariance();
            kotlin.jvm.internal.h.e(variance, "this.variance");
            return C5.f.m(variance);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean G(KotlinTypeMarker receiver, L2.c fqName) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        kotlin.jvm.internal.h.f(fqName, "fqName");
        if (receiver instanceof AbstractC0162z) {
            return ((AbstractC0162z) receiver).getAnnotations().hasAnnotation(fqName);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean H(TypeParameterMarker receiver, TypeConstructorMarker typeConstructorMarker) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (!(receiver instanceof TypeParameterDescriptor)) {
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(receiver);
            sb.append(", ");
            throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
        }
        if (typeConstructorMarker == null ? true : typeConstructorMarker instanceof TypeConstructor) {
            return AbstractC0246d.V((TypeParameterDescriptor) receiver, (TypeConstructor) typeConstructorMarker, null);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(receiver);
        sb2.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb2).toString());
    }

    public static boolean I(SimpleTypeMarker a6, SimpleTypeMarker b) {
        kotlin.jvm.internal.h.f(a6, "a");
        kotlin.jvm.internal.h.f(b, "b");
        if (!(a6 instanceof F)) {
            throw new IllegalArgumentException(B2.b.i(w.f3818a, a6.getClass(), B2.b.n("ClassicTypeSystemContext couldn't handle: ", a6, ", ")).toString());
        }
        if (b instanceof F) {
            return ((F) a6).a() == ((F) b).a();
        }
        throw new IllegalArgumentException(B2.b.i(w.f3818a, b.getClass(), B2.b.n("ClassicTypeSystemContext couldn't handle: ", b, ", ")).toString());
    }

    public static boolean J(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            return k2.i.H((TypeConstructor) receiver, k2.o.f3743a);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean K(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            return ((TypeConstructor) receiver).getDeclarationDescriptor() instanceof ClassDescriptor;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean L(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) receiver).getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            return (classDescriptor == null || classDescriptor.getModality() != EnumC0719k.f4248a || classDescriptor.getKind() == EnumC0711c.c || classDescriptor.getKind() == EnumC0711c.d || classDescriptor.getKind() == EnumC0711c.e) ? false : true;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean M(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            return ((TypeConstructor) receiver).isDenotable();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean N(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0162z) {
            return kotlin.reflect.l.O((AbstractC0162z) receiver);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean O(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) receiver).getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            return (classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null) instanceof C0717i;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean P(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            return receiver instanceof P2.m;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean Q(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            return receiver instanceof C0161y;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean R(SimpleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof F) {
            return ((F) receiver).d();
        }
        StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sbN).toString());
    }

    public static boolean S(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            return k2.i.H((TypeConstructor) receiver, k2.o.b);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean T(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0162z) {
            return b0.f((AbstractC0162z) receiver);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean U(SimpleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0162z) {
            return k2.i.F((AbstractC0162z) receiver);
        }
        StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sbN).toString());
    }

    public static boolean V(CapturedTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof f) {
            return ((f) receiver).f1702g;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean W(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (!(receiver instanceof F)) {
            throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ")).toString());
        }
        if (kotlin.reflect.l.O((AbstractC0162z) receiver)) {
            return false;
        }
        F f6 = (F) receiver;
        if (f6.c().getDeclarationDescriptor() instanceof TypeAliasDescriptor) {
            return false;
        }
        if (f6.c().getDeclarationDescriptor() != null || (receiver instanceof O2.a) || (receiver instanceof f) || (receiver instanceof C0152o) || (f6.c() instanceof P2.m)) {
            return true;
        }
        return (receiver instanceof I) && classicTypeSystemContext.isSingleClassifierType(((I) receiver).b);
    }

    public static boolean X(TypeArgumentMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeProjection) {
            return ((TypeProjection) receiver).isStarProjection();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void Y(SimpleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof F) {
            boolean z6 = ((AbstractC0162z) receiver) instanceof C0152o;
        } else {
            StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ");
            throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sbN).toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void Z(SimpleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof F) {
            boolean z6 = ((AbstractC0162z) receiver) instanceof C0152o;
        } else {
            StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ");
            throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sbN).toString());
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 3:
            default:
                objArr[0] = "a";
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = "capture";
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean a0(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) receiver).getDeclarationDescriptor();
            return declarationDescriptor != null && k2.i.I(declarationDescriptor);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static boolean b(TypeConstructorMarker c12, TypeConstructorMarker c22) {
        kotlin.jvm.internal.h.f(c12, "c1");
        kotlin.jvm.internal.h.f(c22, "c2");
        if (!(c12 instanceof TypeConstructor)) {
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(c12);
            sb.append(", ");
            throw new IllegalArgumentException(B2.b.i(w.f3818a, c12.getClass(), sb).toString());
        }
        if (c22 instanceof TypeConstructor) {
            return c12.equals(c22);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(c22);
        sb2.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, c22.getClass(), sb2).toString());
    }

    public static F b0(FlexibleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0155s) {
            return ((AbstractC0155s) receiver).b;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static int c(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0162z) {
            return ((AbstractC0162z) receiver).a().size();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static c0 c0(CapturedTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof f) {
            return ((f) receiver).d;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static TypeArgumentListMarker d(SimpleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof F) {
            return (TypeArgumentListMarker) receiver;
        }
        StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sbN).toString());
    }

    public static c0 d0(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof c0) {
            return C5.f.S((c0) receiver, false);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static CapturedTypeMarker e(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (!(receiver instanceof F)) {
            StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ");
            throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sbN).toString());
        }
        if (receiver instanceof I) {
            return classicTypeSystemContext.asCapturedType(((I) receiver).b);
        }
        if (receiver instanceof f) {
            return (f) receiver;
        }
        return null;
    }

    public static F e0(DefinitelyNotNullTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof C0152o) {
            return ((C0152o) receiver).b;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static C0152o f(SimpleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof F) {
            if (receiver instanceof C0152o) {
                return (C0152o) receiver;
            }
            return null;
        }
        StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sbN).toString());
    }

    public static int f0(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            return ((TypeConstructor) receiver).getParameters().size();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static void g(FlexibleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0155s) {
            return;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static Set g0(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        TypeConstructorMarker typeConstructorMarkerTypeConstructor = classicTypeSystemContext.typeConstructor(receiver);
        if (typeConstructorMarkerTypeConstructor instanceof P2.m) {
            return ((P2.m) typeConstructorMarkerTypeConstructor).f1220a;
        }
        StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sbN).toString());
    }

    public static AbstractC0155s h(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0162z) {
            c0 c0VarF = ((AbstractC0162z) receiver).f();
            if (c0VarF instanceof AbstractC0155s) {
                return (AbstractC0155s) c0VarF;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static TypeProjection h0(CapturedTypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof h) {
            return ((h) receiver).f1704a;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static RawType i(FlexibleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0155s) {
            if (receiver instanceof RawType) {
                return (RawType) receiver;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C0232a i0(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker type) {
        kotlin.jvm.internal.h.f(type, "type");
        if (type instanceof F) {
            AbstractC0162z abstractC0162z = (AbstractC0162z) type;
            return new C0232a(classicTypeSystemContext, Z.e(S.b.f(abstractC0162z.c(), abstractC0162z.a())));
        }
        StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", type, ", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, type.getClass(), sbN).toString());
    }

    public static F j(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0162z) {
            c0 c0VarF = ((AbstractC0162z) receiver).f();
            if (c0VarF instanceof F) {
                return (F) c0VarF;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static Collection j0(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            Collection<AbstractC0162z> supertypes = ((TypeConstructor) receiver).getSupertypes();
            kotlin.jvm.internal.h.e(supertypes, "this.supertypes");
            return supertypes;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static K k(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0162z) {
            return AbstractC0246d.f((AbstractC0162z) receiver);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static h k0(CapturedTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof f) {
            return ((f) receiver).c;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static F l(SimpleTypeMarker type, EnumC0418b status) {
        List listA;
        ArrayList arrayList;
        b bVar;
        kotlin.jvm.internal.h.f(type, "type");
        kotlin.jvm.internal.h.f(status, "status");
        if (!(type instanceof F)) {
            throw new IllegalArgumentException(B2.b.i(w.f3818a, type.getClass(), B2.b.n("ClassicTypeSystemContext couldn't handle: ", type, ", ")).toString());
        }
        F f6 = (F) type;
        g gVar = null;
        if (f6.a().size() == f6.c().getParameters().size() && ((listA = f6.a()) == null || !listA.isEmpty())) {
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                d0 projectionKind = ((TypeProjection) it.next()).getProjectionKind();
                d0 d0Var = d0.INVARIANT;
                if (projectionKind != d0Var) {
                    List<TypeParameterDescriptor> parameters = f6.c().getParameters();
                    kotlin.jvm.internal.h.e(parameters, "type.constructor.parameters");
                    ArrayList<N1.e> arrayListU0 = kotlin.collections.m.u0(listA, parameters);
                    arrayList = new ArrayList(kotlin.collections.o.D(arrayListU0));
                    for (N1.e eVar : arrayListU0) {
                        TypeProjection typeProjectionF = (TypeProjection) eVar.f1121a;
                        TypeParameterDescriptor parameter = (TypeParameterDescriptor) eVar.b;
                        if (typeProjectionF.getProjectionKind() != d0Var) {
                            c0 c0VarF = (typeProjectionF.isStarProjection() || typeProjectionF.getProjectionKind() != d0.IN_VARIANCE) ? null : typeProjectionF.getType().f();
                            kotlin.jvm.internal.h.e(parameter, "parameter");
                            typeProjectionF = AbstractC0246d.f(new f(status, new h(typeProjectionF, gVar, parameter, 6), c0VarF, (M) null, false, 56));
                        }
                        arrayList.add(typeProjectionF);
                    }
                    Z zE = Z.e(S.b.f(f6.c(), arrayList));
                    int size = listA.size();
                    for (int i = 0; i < size; i++) {
                        TypeProjection typeProjection = (TypeProjection) listA.get(i);
                        TypeProjection typeProjection2 = (TypeProjection) arrayList.get(i);
                        if (typeProjection.getProjectionKind() != d0Var) {
                            List<AbstractC0162z> upperBounds = f6.c().getParameters().get(i).getUpperBounds();
                            kotlin.jvm.internal.h.e(upperBounds, "type.constructor.parameters[index].upperBounds");
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<T> it2 = upperBounds.iterator();
                            while (true) {
                                boolean zHasNext = it2.hasNext();
                                bVar = b.f1698a;
                                if (!zHasNext) {
                                    break;
                                }
                                arrayList2.add(bVar.a(zE.h((AbstractC0162z) it2.next(), d0Var).f()));
                            }
                            if (!typeProjection.isStarProjection() && typeProjection.getProjectionKind() == d0.OUT_VARIANCE) {
                                arrayList2.add(bVar.a(typeProjection.getType().f()));
                            }
                            AbstractC0162z type2 = typeProjection2.getType();
                            kotlin.jvm.internal.h.d(type2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                            h hVar = ((f) type2).c;
                            hVar.getClass();
                            hVar.b = new g(1, arrayList2);
                        }
                    }
                }
            }
            arrayList = null;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            return C.c(f6.b(), arrayList, f6.c(), f6.d());
        }
        return null;
    }

    public static TypeConstructor l0(SimpleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof F) {
            return ((F) receiver).c();
        }
        StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sbN).toString());
    }

    public static EnumC0418b m(CapturedTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof f) {
            return ((f) receiver).b;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static F m0(FlexibleTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0155s) {
            return ((AbstractC0155s) receiver).c;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static Q n(boolean z6, b bVar, int i) {
        c cVar = c.f1699a;
        k kVar = k.f1707a;
        if ((i & 8) != 0) {
            bVar = b.f1698a;
        }
        return new Q(z6, true, kVar, bVar, cVar);
    }

    public static F n0(SimpleTypeMarker receiver, boolean z6) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof F) {
            return ((F) receiver).g(z6);
        }
        StringBuilder sbN = B2.b.n("ClassicTypeSystemContext couldn't handle: ", receiver, ", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sbN).toString());
    }

    public static c0 o(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker lowerBound, SimpleTypeMarker upperBound) {
        kotlin.jvm.internal.h.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.h.f(upperBound, "upperBound");
        if (!(lowerBound instanceof F)) {
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(classicTypeSystemContext);
            sb.append(", ");
            throw new IllegalArgumentException(B2.b.i(w.f3818a, classicTypeSystemContext.getClass(), sb).toString());
        }
        if (upperBound instanceof F) {
            return C.a((F) lowerBound, (F) upperBound);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(classicTypeSystemContext);
        sb2.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, classicTypeSystemContext.getClass(), sb2).toString());
    }

    public static KotlinTypeMarker o0(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker receiver, boolean z6) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof SimpleTypeMarker) {
            return classicTypeSystemContext.withNullability((SimpleTypeMarker) receiver, z6);
        }
        if (!(receiver instanceof FlexibleTypeMarker)) {
            throw new IllegalStateException("sealed");
        }
        FlexibleTypeMarker flexibleTypeMarker = (FlexibleTypeMarker) receiver;
        return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability(classicTypeSystemContext.lowerBound(flexibleTypeMarker), z6), classicTypeSystemContext.withNullability(classicTypeSystemContext.upperBound(flexibleTypeMarker), z6));
    }

    public static final String p(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        q("type: " + typeConstructor, sb);
        q("hashCode: " + typeConstructor.hashCode(), sb);
        q("javaClass: " + typeConstructor.getClass().getCanonicalName(), sb);
        for (DeclarationDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            q("fqName: ".concat(M2.n.f1060a.k(declarationDescriptor)), sb);
            q("javaClass: " + declarationDescriptor.getClass().getCanonicalName(), sb);
        }
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final void q(String str, StringBuilder sb) {
        kotlin.jvm.internal.h.f(str, "<this>");
        sb.append(str);
        sb.append('\n');
    }

    public static TypeArgumentMarker r(KotlinTypeMarker receiver, int i) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0162z) {
            return (TypeArgumentMarker) ((AbstractC0162z) receiver).a().get(i);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static List s(KotlinTypeMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof AbstractC0162z) {
            return ((AbstractC0162z) receiver).a();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static L2.e t(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) receiver).getDeclarationDescriptor();
            kotlin.jvm.internal.h.d(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return R2.e.h((ClassDescriptor) declarationDescriptor);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static TypeParameterMarker u(TypeConstructorMarker receiver, int i) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) receiver).getParameters().get(i);
            kotlin.jvm.internal.h.e(typeParameterDescriptor, "this.parameters[index]");
            return typeParameterDescriptor;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static List v(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            List<TypeParameterDescriptor> parameters = ((TypeConstructor) receiver).getParameters();
            kotlin.jvm.internal.h.e(parameters, "this.parameters");
            return parameters;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static k2.k w(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) receiver).getDeclarationDescriptor();
            kotlin.jvm.internal.h.d(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return k2.i.q((ClassDescriptor) declarationDescriptor);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static k2.k x(TypeConstructorMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeConstructor) {
            ClassifierDescriptor declarationDescriptor = ((TypeConstructor) receiver).getDeclarationDescriptor();
            kotlin.jvm.internal.h.d(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return k2.i.s((ClassDescriptor) declarationDescriptor);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static AbstractC0162z y(TypeParameterMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeParameterDescriptor) {
            return AbstractC0246d.R((TypeParameterDescriptor) receiver);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }

    public static c0 z(TypeArgumentMarker receiver) {
        kotlin.jvm.internal.h.f(receiver, "$receiver");
        if (receiver instanceof TypeProjection) {
            return ((TypeProjection) receiver).getType().f();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B2.b.i(w.f3818a, receiver.getClass(), sb).toString());
    }
}
