package com.google.gson.reflect;

import com.google.gson.internal.d;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3041a;
    public final Type b;
    public final int c;

    public a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == a.class) {
                Type typeA = d.a(parameterizedType.getActualTypeArguments()[0]);
                this.b = typeA;
                this.f3041a = d.g(typeA);
                this.c = typeA.hashCode();
                return;
            }
        } else if (genericSuperclass == a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return d.d(this.b, ((a) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return d.k(this.b);
    }

    public a(Type type) {
        Objects.requireNonNull(type);
        Type typeA = d.a(type);
        this.b = typeA;
        this.f3041a = d.g(typeA);
        this.c = typeA.hashCode();
    }
}
