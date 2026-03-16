package h2;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f3419a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(n0 n0Var, int i, Lazy lazy) {
        super(0);
        this.f3419a = n0Var;
        this.b = i;
        this.c = lazy;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        n0 n0Var = this.f3419a;
        Type javaType = n0Var.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            kotlin.jvm.internal.h.e(componentType, "{\n                      …                        }");
            return componentType;
        }
        boolean z6 = javaType instanceof GenericArrayType;
        int i = this.b;
        if (z6) {
            if (i == 0) {
                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                kotlin.jvm.internal.h.e(genericComponentType, "{\n                      …                        }");
                return genericComponentType;
            }
            throw new N1.d("Array type has been queried for a non-0th argument: " + n0Var, 2);
        }
        if (!(javaType instanceof ParameterizedType)) {
            throw new N1.d("Non-generic type has been queried for arguments: " + n0Var, 2);
        }
        Type type = (Type) ((List) this.c.getValue()).get(i);
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            kotlin.jvm.internal.h.e(lowerBounds, "argument.lowerBounds");
            Type type2 = lowerBounds.length == 0 ? null : lowerBounds[0];
            if (type2 == null) {
                Type[] upperBounds = wildcardType.getUpperBounds();
                kotlin.jvm.internal.h.e(upperBounds, "argument.upperBounds");
                type = (Type) kotlin.collections.j.A(upperBounds);
            } else {
                type = type2;
            }
        }
        kotlin.jvm.internal.h.e(type, "{\n                      …                        }");
        return type;
    }
}
