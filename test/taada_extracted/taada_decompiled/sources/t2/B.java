package t2;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: loaded from: classes2.dex */
public final class B extends A implements JavaMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f4793a;

    public B(Method member) {
        kotlin.jvm.internal.h.f(member, "member");
        this.f4793a = member;
    }

    @Override // t2.A
    public final Member a() {
        return this.f4793a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public final JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        Object defaultValue = this.f4793a.getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        Class<?> cls = defaultValue.getClass();
        List list = AbstractC0823e.f4804a;
        return Enum.class.isAssignableFrom(cls) ? new x(null, (Enum) defaultValue) : defaultValue instanceof Annotation ? new C0826h(null, (Annotation) defaultValue) : defaultValue instanceof Object[] ? new C0827i(null, (Object[]) defaultValue) : defaultValue instanceof Class ? new t(null, (Class) defaultValue) : new z(null, defaultValue);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public final boolean getHasAnnotationParameterDefaultValue() {
        return getAnnotationParameterDefaultValue() != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public final JavaType getReturnType() {
        Type genericReturnType = this.f4793a.getGenericReturnType();
        kotlin.jvm.internal.h.e(genericReturnType, "member.genericReturnType");
        boolean z6 = genericReturnType instanceof Class;
        if (z6) {
            Class cls = (Class) genericReturnType;
            if (cls.isPrimitive()) {
                return new D(cls);
            }
        }
        return ((genericReturnType instanceof GenericArrayType) || (z6 && ((Class) genericReturnType).isArray())) ? new j(genericReturnType) : genericReturnType instanceof WildcardType ? new I((WildcardType) genericReturnType) : new u(genericReturnType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public final List getTypeParameters() {
        TypeVariable<Method>[] typeParameters = this.f4793a.getTypeParameters();
        kotlin.jvm.internal.h.e(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new G(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public final List getValueParameters() {
        Method method = this.f4793a;
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        kotlin.jvm.internal.h.e(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        kotlin.jvm.internal.h.e(parameterAnnotations, "member.parameterAnnotations");
        return b(genericParameterTypes, parameterAnnotations, method.isVarArgs());
    }
}
