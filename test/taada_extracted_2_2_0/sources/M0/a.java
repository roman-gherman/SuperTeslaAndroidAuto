package M0;

import com.google.gson.E;
import com.google.gson.TypeAdapterFactory;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class a implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f990a;

    public /* synthetic */ a(int i) {
        this.f990a = i;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final E create(com.google.gson.m mVar, com.google.gson.reflect.a aVar) {
        switch (this.f990a) {
            case 0:
                Type type = aVar.b;
                boolean z6 = type instanceof GenericArrayType;
                if (!z6 && (!(type instanceof Class) || !((Class) type).isArray())) {
                    return null;
                }
                Type genericComponentType = z6 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
                return new b(mVar, mVar.e(new com.google.gson.reflect.a(genericComponentType)), com.google.gson.internal.d.g(genericComponentType));
            case 1:
                if (aVar.f3041a == Date.class) {
                    return new d();
                }
                return null;
            case 2:
                Class superclass = aVar.f3041a;
                if (!Enum.class.isAssignableFrom(superclass) || superclass == Enum.class) {
                    return null;
                }
                if (!superclass.isEnum()) {
                    superclass = superclass.getSuperclass();
                }
                return new k(superclass);
            case 3:
                if (aVar.f3041a == java.sql.Date.class) {
                    return new P0.a(0);
                }
                return null;
            case 4:
                if (aVar.f3041a == Time.class) {
                    return new P0.a(1);
                }
                return null;
            default:
                if (aVar.f3041a != Timestamp.class) {
                    return null;
                }
                mVar.getClass();
                return new P0.a(mVar.e(new com.google.gson.reflect.a(Date.class)));
        }
    }
}
