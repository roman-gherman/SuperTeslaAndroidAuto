package t2;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;

/* JADX INFO: loaded from: classes2.dex */
public final class I extends F implements JavaWildcardType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WildcardType f4800a;

    public I(WildcardType wildcardType) {
        this.f4800a = wildcardType;
    }

    @Override // t2.F
    public final Type a() {
        return this.f4800a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final Collection getAnnotations() {
        return kotlin.collections.u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public final JavaType getBound() {
        WildcardType wildcardType = this.f4800a;
        Type[] upperBounds = wildcardType.getUpperBounds();
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + wildcardType);
        }
        if (lowerBounds.length == 1) {
            Object objI = kotlin.collections.j.I(lowerBounds);
            kotlin.jvm.internal.h.e(objI, "lowerBounds.single()");
            Type type = (Type) objI;
            boolean z6 = type instanceof Class;
            if (z6) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new D(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z6 && ((Class) type).isArray())) ? new j(type) : type instanceof WildcardType ? new I((WildcardType) type) : new u(type);
        }
        if (upperBounds.length != 1) {
            return null;
        }
        Type ub = (Type) kotlin.collections.j.I(upperBounds);
        if (kotlin.jvm.internal.h.a(ub, Object.class)) {
            return null;
        }
        kotlin.jvm.internal.h.e(ub, "ub");
        boolean z7 = ub instanceof Class;
        if (z7) {
            Class cls2 = (Class) ub;
            if (cls2.isPrimitive()) {
                return new D(cls2);
            }
        }
        return ((ub instanceof GenericArrayType) || (z7 && ((Class) ub).isArray())) ? new j(ub) : ub instanceof WildcardType ? new I((WildcardType) ub) : new u(ub);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public final boolean isExtends() {
        kotlin.jvm.internal.h.e(this.f4800a.getUpperBounds(), "reflectType.upperBounds");
        return !kotlin.jvm.internal.h.a(kotlin.collections.j.B(r0), Object.class);
    }
}
