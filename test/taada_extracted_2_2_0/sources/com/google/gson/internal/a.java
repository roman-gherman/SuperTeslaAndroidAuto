package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class a implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f2993a;

    public a(Type type) {
        Objects.requireNonNull(type);
        this.f2993a = d.a(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && d.d(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f2993a;
    }

    public final int hashCode() {
        return this.f2993a.hashCode();
    }

    public final String toString() {
        return d.k(this.f2993a) + "[]";
    }
}
