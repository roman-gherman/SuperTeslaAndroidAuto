package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: loaded from: classes.dex */
public final class c implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f2995a;
    public final Type b;

    public c(Type[] typeArr, Type[] typeArr2) {
        d.b(typeArr2.length <= 1);
        d.b(typeArr.length == 1);
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            d.c(typeArr[0]);
            this.b = null;
            this.f2995a = d.a(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        d.c(typeArr2[0]);
        d.b(typeArr[0] == Object.class);
        this.b = d.a(typeArr2[0]);
        this.f2995a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && d.d(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.b;
        return type != null ? new Type[]{type} : d.f2996a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f2995a};
    }

    public final int hashCode() {
        Type type = this.b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f2995a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.b;
        if (type != null) {
            return "? super " + d.k(type);
        }
        Type type2 = this.f2995a;
        if (type2 == Object.class) {
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
        return "? extends " + d.k(type2);
    }
}
