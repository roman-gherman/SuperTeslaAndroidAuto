package F1;

import java.lang.reflect.Type;
import kotlin.jvm.internal.h;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass f347a;
    public final Type b;
    public final KType c;

    public a(Type type, KClass type2, KType kType) {
        h.f(type2, "type");
        this.f347a = type2;
        this.b = type;
        this.c = kType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return h.a(this.f347a, aVar.f347a) && h.a(this.b, aVar.b) && h.a(this.c, aVar.c);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.f347a.hashCode() * 31)) * 31;
        KType kType = this.c;
        return iHashCode + (kType == null ? 0 : kType.hashCode());
    }

    public final String toString() {
        return "TypeInfo(type=" + this.f347a + ", reifiedType=" + this.b + ", kotlinType=" + this.c + ')';
    }
}
