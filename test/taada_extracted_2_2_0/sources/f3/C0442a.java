package f3;

import kotlin.jvm.internal.h;

/* JADX INFO: renamed from: f3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0442a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3193a;
    public final Object b;

    public C0442a(Object obj, Object obj2) {
        this.f3193a = obj;
        this.b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0442a)) {
            return false;
        }
        C0442a c0442a = (C0442a) obj;
        return h.a(this.f3193a, c0442a.f3193a) && h.a(this.b, c0442a.b);
    }

    public final int hashCode() {
        Object obj = this.f3193a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "ApproximationBounds(lower=" + this.f3193a + ", upper=" + this.b + ')';
    }
}
