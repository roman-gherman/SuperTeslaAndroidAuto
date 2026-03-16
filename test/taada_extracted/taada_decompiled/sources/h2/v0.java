package h2;

import G2.C0113m;
import G2.C0125z;
import a.AbstractC0132a;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import m2.C0649a;
import y2.C0931a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L2.b f3435a = L2.b.j(new L2.c("java.lang.Void"));

    public static C0506i a(FunctionDescriptor functionDescriptor) {
        String strO = io.ktor.utils.io.b0.o(functionDescriptor);
        if (strO == null) {
            if (functionDescriptor instanceof PropertyGetterDescriptor) {
                String strB = R2.e.k(functionDescriptor).getName().b();
                kotlin.jvm.internal.h.e(strB, "descriptor.propertyIfAccessor.name.asString()");
                strO = w2.C.a(strB);
            } else if (functionDescriptor instanceof PropertySetterDescriptor) {
                String strB2 = R2.e.k(functionDescriptor).getName().b();
                kotlin.jvm.internal.h.e(strB2, "descriptor.propertyIfAccessor.name.asString()");
                strO = w2.C.b(strB2);
            } else {
                strO = functionDescriptor.getName().b();
                kotlin.jvm.internal.h.e(strO, "descriptor.name.asString()");
            }
        }
        return new C0506i(new K2.e(strO, E1.k.o(functionDescriptor, 1)));
    }

    public static s0 b(PropertyDescriptor possiblyOverriddenProperty) {
        kotlin.jvm.internal.h.f(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        PropertyDescriptor original = ((PropertyDescriptor) N2.f.t(possiblyOverriddenProperty)).getOriginal();
        kotlin.jvm.internal.h.e(original, "unwrapFakeOverride(possi…rriddenProperty).original");
        if (original instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n nVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) original;
            kotlin.reflect.jvm.internal.impl.protobuf.o propertySignature = J2.l.d;
            kotlin.jvm.internal.h.e(propertySignature, "propertySignature");
            G2.H h3 = nVar.f3921A;
            J2.f fVar = (J2.f) AbstractC0132a.D(h3, propertySignature);
            if (fVar != null) {
                return new C0509l(original, h3, fVar, nVar.f3922B, nVar.C);
            }
        } else if (original instanceof y2.f) {
            SourceElement source = ((y2.f) original).getSource();
            JavaSourceElement javaSourceElement = source instanceof JavaSourceElement ? (JavaSourceElement) source : null;
            JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (javaElement instanceof t2.y) {
                return new C0507j(((t2.y) javaElement).f4819a);
            }
            if (!(javaElement instanceof t2.B)) {
                throw new N1.d("Incorrect resolution sequence for Java field " + original + " (source = " + javaElement + ')', 2);
            }
            Method method = ((t2.B) javaElement).f4793a;
            PropertySetterDescriptor setter = original.getSetter();
            SourceElement source2 = setter != null ? setter.getSource() : null;
            JavaSourceElement javaSourceElement2 = source2 instanceof JavaSourceElement ? (JavaSourceElement) source2 : null;
            JavaElement javaElement2 = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
            t2.B b = javaElement2 instanceof t2.B ? (t2.B) javaElement2 : null;
            return new C0508k(method, b != null ? b.f4793a : null);
        }
        PropertyGetterDescriptor getter = original.getGetter();
        kotlin.jvm.internal.h.c(getter);
        C0506i c0506iA = a(getter);
        PropertySetterDescriptor setter2 = original.getSetter();
        return new C0510m(c0506iA, setter2 != null ? a(setter2) : null);
    }

    public static s0 c(FunctionDescriptor possiblySubstitutedFunction) {
        Method method;
        kotlin.jvm.internal.h.f(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        FunctionDescriptor original = ((FunctionDescriptor) N2.f.t(possiblySubstitutedFunction)).getOriginal();
        kotlin.jvm.internal.h.e(original, "unwrapFakeOverride(possi…titutedFunction).original");
        if (original instanceof DeserializedCallableMemberDescriptor) {
            DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor = (DeserializedCallableMemberDescriptor) original;
            MessageLite proto = deserializedCallableMemberDescriptor.getProto();
            if (proto instanceof C0125z) {
                C0608i c0608i = K2.h.f942a;
                K2.e eVarC = K2.h.c((C0125z) proto, deserializedCallableMemberDescriptor.getNameResolver(), deserializedCallableMemberDescriptor.getTypeTable());
                if (eVarC != null) {
                    return new C0506i(eVarC);
                }
            }
            if (proto instanceof C0113m) {
                C0608i c0608i2 = K2.h.f942a;
                K2.e eVarA = K2.h.a((C0113m) proto, deserializedCallableMemberDescriptor.getNameResolver(), deserializedCallableMemberDescriptor.getTypeTable());
                if (eVarA != null) {
                    DeclarationDescriptor containingDeclaration = possiblySubstitutedFunction.getContainingDeclaration();
                    kotlin.jvm.internal.h.e(containingDeclaration, "possiblySubstitutedFunction.containingDeclaration");
                    return N2.i.b(containingDeclaration) ? new C0506i(eVarA) : new C0505h(eVarA);
                }
            }
            return a(original);
        }
        if (original instanceof y2.e) {
            SourceElement source = ((y2.e) original).getSource();
            JavaSourceElement javaSourceElement = source instanceof JavaSourceElement ? (JavaSourceElement) source : null;
            JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            t2.B b = javaElement instanceof t2.B ? (t2.B) javaElement : null;
            if (b != null && (method = b.f4793a) != null) {
                return new C0504g(method);
            }
            throw new N1.d("Incorrect resolution sequence for Java method " + original, 2);
        }
        if (!(original instanceof C0931a)) {
            if ((original.getName().equals(k2.p.c) && N2.q.n(original)) || ((original.getName().equals(k2.p.f3762a) && N2.q.n(original)) || (kotlin.jvm.internal.h.a(original.getName(), C0649a.d) && original.getValueParameters().isEmpty()))) {
                return a(original);
            }
            throw new N1.d("Unknown origin of " + original + " (" + original.getClass() + ')', 2);
        }
        SourceElement source2 = ((C0931a) original).getSource();
        JavaSourceElement javaSourceElement2 = source2 instanceof JavaSourceElement ? (JavaSourceElement) source2 : null;
        JavaElement javaElement2 = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
        if (javaElement2 instanceof t2.v) {
            return new C0503f(((t2.v) javaElement2).f4818a);
        }
        if (javaElement2 instanceof t2.s) {
            t2.s sVar = (t2.s) javaElement2;
            if (sVar.f4816a.isAnnotation()) {
                return new C0502e(sVar.f4816a);
            }
        }
        throw new N1.d("Incorrect resolution sequence for Java constructor " + original + " (" + javaElement2 + ')', 2);
    }
}
