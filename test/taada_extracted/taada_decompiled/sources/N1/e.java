package N1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1121a;
    public final Object b;

    public e(Object obj, Object obj2) {
        this.f1121a = obj;
        this.b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return kotlin.jvm.internal.h.a(this.f1121a, eVar.f1121a) && kotlin.jvm.internal.h.a(this.b, eVar.b);
    }

    public final int hashCode() {
        Object obj = this.f1121a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f1121a + ", " + this.b + ')';
    }
}
