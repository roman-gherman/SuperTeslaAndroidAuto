package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements ParameterizedType, TypeImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3826a;
    public final Type b;
    public final Type[] c;

    public h(Class cls, Type type, ArrayList arrayList) {
        this.f3826a = cls;
        this.b = type;
        this.c = (Type[]) arrayList.toArray(new Type[0]);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        if (kotlin.jvm.internal.h.a(this.f3826a, parameterizedType.getRawType()) && kotlin.jvm.internal.h.a(this.b, parameterizedType.getOwnerType())) {
            return Arrays.equals(this.c, parameterizedType.getActualTypeArguments());
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f3826a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public final String getTypeName() {
        StringBuilder sb = new StringBuilder();
        Class cls = this.f3826a;
        Type type = this.b;
        if (type != null) {
            sb.append(l.c(type));
            sb.append("$");
            sb.append(cls.getSimpleName());
        } else {
            sb.append(l.c(cls));
        }
        Type[] typeArr = this.c;
        if (typeArr.length != 0) {
            kotlin.collections.j.F(typeArr, sb, ", ", "<", ">", "...", g.f3825a);
        }
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final int hashCode() {
        int iHashCode = this.f3826a.hashCode();
        Type type = this.b;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(this.c);
    }

    public final String toString() {
        return getTypeName();
    }
}
