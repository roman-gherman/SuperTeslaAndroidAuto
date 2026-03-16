package h2;

import A2.C0022d;
import java.util.List;
import kotlin.reflect.KProperty;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 implements KTypeParameter, KClassifierImpl {
    public static final /* synthetic */ KProperty[] d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeParameterDescriptor f3425a;
    public final q0 b;
    public final KTypeParameterOwnerImpl c;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3818a;
        d = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(o0.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    }

    public o0(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, TypeParameterDescriptor descriptor) {
        Class cls;
        C0522z c0522zA;
        Object objAccept;
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        this.f3425a = descriptor;
        this.b = s0.g(null, new C0022d(this, 19));
        if (kTypeParameterOwnerImpl == null) {
            DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            kotlin.jvm.internal.h.e(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                objAccept = a((ClassDescriptor) containingDeclaration);
            } else {
                if (!(containingDeclaration instanceof CallableMemberDescriptor)) {
                    throw new N1.d("Unknown type parameter container: " + containingDeclaration, 2);
                }
                DeclarationDescriptor containingDeclaration2 = ((CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                kotlin.jvm.internal.h.e(containingDeclaration2, "declaration.containingDeclaration");
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    c0522zA = a((ClassDescriptor) containingDeclaration2);
                } else {
                    DeserializedMemberDescriptor deserializedMemberDescriptor = containingDeclaration instanceof DeserializedMemberDescriptor ? (DeserializedMemberDescriptor) containingDeclaration : null;
                    if (deserializedMemberDescriptor == null) {
                        throw new N1.d("Non-class callable descriptor must be deserialized: " + containingDeclaration, 2);
                    }
                    DeserializedContainerSource containerSource = deserializedMemberDescriptor.getContainerSource();
                    E2.g gVar = containerSource instanceof E2.g ? (E2.g) containerSource : null;
                    KotlinJvmBinaryClass kotlinJvmBinaryClass = gVar != null ? gVar.c : null;
                    s2.e eVar = kotlinJvmBinaryClass instanceof s2.e ? (s2.e) kotlinJvmBinaryClass : null;
                    if (eVar == null || (cls = eVar.f4769a) == null) {
                        throw new N1.d("Container of deserialized member is not resolved: " + deserializedMemberDescriptor, 2);
                    }
                    c0522zA = (C0522z) E1.k.K(cls);
                }
                objAccept = containingDeclaration.accept(new B.g(c0522zA), N1.m.f1129a);
            }
            kotlin.jvm.internal.h.e(objAccept, "when (val declaration = … $declaration\")\n        }");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) objAccept;
        }
        this.c = kTypeParameterOwnerImpl;
    }

    public static C0522z a(ClassDescriptor classDescriptor) {
        Class clsJ = x0.j(classDescriptor);
        C0522z c0522z = (C0522z) (clsJ != null ? E1.k.K(clsJ) : null);
        if (c0522z != null) {
            return c0522z;
        }
        throw new N1.d("Type parameter container is not resolved: " + classDescriptor.getContainingDeclaration(), 2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return kotlin.jvm.internal.h.a(this.c, o0Var.c) && getName().equals(o0Var.getName());
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public final ClassifierDescriptor getDescriptor() {
        return this.f3425a;
    }

    @Override // kotlin.reflect.KTypeParameter
    public final String getName() {
        String strB = this.f3425a.getName().b();
        kotlin.jvm.internal.h.e(strB, "descriptor.name.asString()");
        return strB;
    }

    @Override // kotlin.reflect.KTypeParameter
    public final List getUpperBounds() {
        KProperty kProperty = d[0];
        Object objInvoke = this.b.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-upperBounds>(...)");
        return (List) objInvoke;
    }

    @Override // kotlin.reflect.KTypeParameter
    public final kotlin.reflect.e getVariance() {
        int iOrdinal = this.f3425a.getVariance().ordinal();
        if (iOrdinal == 0) {
            return kotlin.reflect.e.f3824a;
        }
        if (iOrdinal == 1) {
            return kotlin.reflect.e.b;
        }
        if (iOrdinal == 2) {
            return kotlin.reflect.e.c;
        }
        throw new C0.x();
    }

    public final int hashCode() {
        return getName().hashCode() + (this.c.hashCode() * 31);
    }

    @Override // kotlin.reflect.KTypeParameter
    public final boolean isReified() {
        return this.f3425a.isReified();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int iOrdinal = getVariance().ordinal();
        if (iOrdinal == 1) {
            sb.append("in ");
        } else if (iOrdinal == 2) {
            sb.append("out ");
        }
        sb.append(getName());
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
