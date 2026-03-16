package h2;

import a3.AbstractC0162z;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.KTypeBase;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import t2.AbstractC0823e;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements KTypeBase {
    public static final /* synthetic */ KProperty[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0162z f3422a;
    public final q0 b;
    public final q0 c;
    public final q0 d;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3817a;
        e = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(n0.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(n0.class), "arguments", "getArguments()Ljava/util/List;"))};
    }

    public n0(AbstractC0162z type, Function0 function0) {
        kotlin.jvm.internal.h.f(type, "type");
        this.f3422a = type;
        q0 q0Var = function0 instanceof q0 ? (q0) function0 : null;
        this.b = q0Var == null ? function0 != null ? s0.g(null, function0) : null : q0Var;
        this.c = s0.g(null, new m0(this, 1));
        this.d = s0.g(null, new A2.y(this, function0));
    }

    public final KClassifier a(AbstractC0162z abstractC0162z) {
        AbstractC0162z type;
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            Class clsJ = x0.j((ClassDescriptor) declarationDescriptor);
            if (clsJ != null) {
                if (!clsJ.isArray()) {
                    if (a3.b0.f(abstractC0162z)) {
                        return new C0522z(clsJ);
                    }
                    Class cls = (Class) AbstractC0823e.b.get(clsJ);
                    if (cls != null) {
                        clsJ = cls;
                    }
                    return new C0522z(clsJ);
                }
                TypeProjection typeProjection = (TypeProjection) kotlin.collections.m.i0(abstractC0162z.a());
                if (typeProjection == null || (type = typeProjection.getType()) == null) {
                    return new C0522z(clsJ);
                }
                KClassifier kClassifierA = a(type);
                if (kClassifierA != null) {
                    return new C0522z(Array.newInstance((Class<?>) E1.k.H(C5.f.F(kClassifierA)), 0).getClass());
                }
                throw new N1.d("Cannot determine classifier for array element type: " + this, 2);
            }
        } else {
            if (declarationDescriptor instanceof TypeParameterDescriptor) {
                return new o0(null, (TypeParameterDescriptor) declarationDescriptor);
            }
            if (declarationDescriptor instanceof TypeAliasDescriptor) {
                throw new N1.d("An operation is not implemented: Type alias classifiers are not yet supported");
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return kotlin.jvm.internal.h.a(this.f3422a, n0Var.f3422a) && kotlin.jvm.internal.h.a(getClassifier(), n0Var.getClassifier()) && getArguments().equals(n0Var.getArguments());
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public final List getAnnotations() {
        return x0.d(this.f3422a);
    }

    @Override // kotlin.reflect.KType
    public final List getArguments() {
        KProperty kProperty = e[1];
        Object objInvoke = this.d.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-arguments>(...)");
        return (List) objInvoke;
    }

    @Override // kotlin.reflect.KType
    public final KClassifier getClassifier() {
        KProperty kProperty = e[0];
        return (KClassifier) this.c.invoke();
    }

    @Override // kotlin.jvm.internal.KTypeBase
    public final Type getJavaType() {
        q0 q0Var = this.b;
        if (q0Var != null) {
            return (Type) q0Var.invoke();
        }
        return null;
    }

    public final int hashCode() {
        int iHashCode = this.f3422a.hashCode() * 31;
        KClassifier classifier = getClassifier();
        return getArguments().hashCode() + ((iHashCode + (classifier != null ? classifier.hashCode() : 0)) * 31);
    }

    @Override // kotlin.reflect.KType
    public final boolean isMarkedNullable() {
        return this.f3422a.d();
    }

    public final String toString() {
        M2.s sVar = u0.f3433a;
        return u0.d(this.f3422a);
    }
}
