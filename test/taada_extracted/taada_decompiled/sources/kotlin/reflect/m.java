package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements WildcardType, TypeImpl {
    public static final m c = new m(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f3941a;
    public final Type b;

    public m(Type type, Type type2) {
        this.f3941a = type;
        this.b = type2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType = (WildcardType) obj;
        return Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds());
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.b;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public final String getTypeName() {
        Type type = this.b;
        if (type != null) {
            return "? super " + l.c(type);
        }
        Type type2 = this.f3941a;
        if (type2 == null || kotlin.jvm.internal.h.a(type2, Object.class)) {
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
        return "? extends " + l.c(type2);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        Type type = this.f3941a;
        if (type == null) {
            type = Object.class;
        }
        return new Type[]{type};
    }

    public final int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public final String toString() {
        return getTypeName();
    }
}
