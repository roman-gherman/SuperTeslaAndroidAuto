package M0;

import com.google.gson.E;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public final class c implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f992a;
    public final B.w b;

    public /* synthetic */ c(B.w wVar, int i) {
        this.f992a = i;
        this.b = wVar;
    }

    public static E a(B.w wVar, com.google.gson.m mVar, com.google.gson.reflect.a aVar, JsonAdapter jsonAdapter) {
        E eCreate;
        Object objConstruct = wVar.b(new com.google.gson.reflect.a(jsonAdapter.value())).construct();
        boolean zNullSafe = jsonAdapter.nullSafe();
        if (objConstruct instanceof E) {
            eCreate = (E) objConstruct;
        } else if (objConstruct instanceof TypeAdapterFactory) {
            eCreate = ((TypeAdapterFactory) objConstruct).create(mVar, aVar);
        } else {
            boolean z6 = objConstruct instanceof JsonSerializer;
            if (!z6 && !(objConstruct instanceof JsonDeserializer)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objConstruct.getClass().getName() + " as a @JsonAdapter for " + com.google.gson.internal.d.k(aVar.b) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            t tVar = new t(z6 ? (JsonSerializer) objConstruct : null, objConstruct instanceof JsonDeserializer ? (JsonDeserializer) objConstruct : null, mVar, aVar, zNullSafe);
            zNullSafe = false;
            eCreate = tVar;
        }
        return (eCreate == null || !zNullSafe) ? eCreate : new com.google.gson.k(eCreate, 2);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final E create(com.google.gson.m mVar, com.google.gson.reflect.a aVar) {
        Class cls;
        Type[] actualTypeArguments;
        cls = Object.class;
        B.w wVar = this.b;
        switch (this.f992a) {
            case 0:
                Type type = aVar.b;
                Class cls2 = aVar.f3041a;
                if (!Collection.class.isAssignableFrom(cls2)) {
                    return null;
                }
                if (type instanceof WildcardType) {
                    type = ((WildcardType) type).getUpperBounds()[0];
                }
                com.google.gson.internal.d.b(Collection.class.isAssignableFrom(cls2));
                Type typeJ = com.google.gson.internal.d.j(type, cls2, com.google.gson.internal.d.f(type, cls2, Collection.class), new HashMap());
                cls = typeJ instanceof ParameterizedType ? ((ParameterizedType) typeJ).getActualTypeArguments()[0] : Object.class;
                return new b(mVar, cls, mVar.e(new com.google.gson.reflect.a(cls)), wVar.b(aVar));
            case 1:
                JsonAdapter jsonAdapter = (JsonAdapter) aVar.f3041a.getAnnotation(JsonAdapter.class);
                if (jsonAdapter == null) {
                    return null;
                }
                return a(wVar, mVar, aVar, jsonAdapter);
            default:
                Type type2 = aVar.b;
                Class cls3 = aVar.f3041a;
                if (!Map.class.isAssignableFrom(cls3)) {
                    return null;
                }
                if (type2 == Properties.class) {
                    actualTypeArguments = new Type[]{String.class, String.class};
                } else {
                    if (type2 instanceof WildcardType) {
                        type2 = ((WildcardType) type2).getUpperBounds()[0];
                    }
                    com.google.gson.internal.d.b(Map.class.isAssignableFrom(cls3));
                    Type typeJ2 = com.google.gson.internal.d.j(type2, cls3, com.google.gson.internal.d.f(type2, cls3, Map.class), new HashMap());
                    actualTypeArguments = typeJ2 instanceof ParameterizedType ? ((ParameterizedType) typeJ2).getActualTypeArguments() : new Type[]{cls, cls};
                }
                Type type3 = actualTypeArguments[0];
                E e = (type3 == Boolean.TYPE || type3 == Boolean.class) ? y.c : mVar.e(new com.google.gson.reflect.a(type3));
                E e6 = mVar.e(new com.google.gson.reflect.a(actualTypeArguments[1]));
                ObjectConstructor objectConstructorB = wVar.b(aVar);
                Type[] typeArr = actualTypeArguments;
                return new k(this, mVar, typeArr[0], e, typeArr[1], e6, objectConstructorB);
        }
    }
}
