package t2;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends F implements JavaArrayType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f4807a;
    public final F b;
    public final kotlin.collections.u c;

    /* JADX WARN: Multi-variable type inference failed */
    public j(Type type) {
        F d;
        F d6;
        this.f4807a = type;
        if (!(type instanceof GenericArrayType)) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    kotlin.jvm.internal.h.e(componentType, "getComponentType()");
                    d = componentType.isPrimitive() ? new D(componentType) : ((componentType instanceof GenericArrayType) || componentType.isArray()) ? new j(componentType) : componentType instanceof WildcardType ? new I((WildcardType) componentType) : new u(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + type.getClass() + "): " + type);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        kotlin.jvm.internal.h.e(genericComponentType, "genericComponentType");
        boolean z6 = genericComponentType instanceof Class;
        if (z6) {
            Class cls2 = (Class) genericComponentType;
            if (cls2.isPrimitive()) {
                d6 = new D(cls2);
                this.b = d6;
                this.c = kotlin.collections.u.f3804a;
            }
        }
        d = ((genericComponentType instanceof GenericArrayType) || (z6 && ((Class) genericComponentType).isArray())) ? new j(genericComponentType) : genericComponentType instanceof WildcardType ? new I((WildcardType) genericComponentType) : new u(genericComponentType);
        d6 = d;
        this.b = d6;
        this.c = kotlin.collections.u.f3804a;
    }

    @Override // t2.F
    public final Type a() {
        return this.f4807a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final Collection getAnnotations() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public final JavaType getComponentType() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return false;
    }
}
