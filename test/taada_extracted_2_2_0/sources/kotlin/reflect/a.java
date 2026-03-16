package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements GenericArrayType, TypeImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f3820a;

    public a(Type elementType) {
        kotlin.jvm.internal.h.f(elementType, "elementType");
        this.f3820a = elementType;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            return kotlin.jvm.internal.h.a(this.f3820a, ((GenericArrayType) obj).getGenericComponentType());
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f3820a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public final String getTypeName() {
        return l.c(this.f3820a) + "[]";
    }

    public final int hashCode() {
        return this.f3820a.hashCode();
    }

    public final String toString() {
        return getTypeName();
    }
}
