package N1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1127a;
    public final Object b;
    public final Object c;

    public k(Object obj, Object obj2, Object obj3) {
        this.f1127a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kotlin.jvm.internal.h.a(this.f1127a, kVar.f1127a) && kotlin.jvm.internal.h.a(this.b, kVar.b) && kotlin.jvm.internal.h.a(this.c, kVar.c);
    }

    public final int hashCode() {
        Object obj = this.f1127a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f1127a + ", " + this.b + ", " + this.c + ')';
    }
}
