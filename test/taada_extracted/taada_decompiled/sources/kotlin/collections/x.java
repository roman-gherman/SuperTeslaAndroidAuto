package kotlin.collections;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3807a;
    public final Object b;

    public x(int i, Object obj) {
        this.f3807a = i;
        this.b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f3807a == xVar.f3807a && kotlin.jvm.internal.h.a(this.b, xVar.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f3807a) * 31;
        Object obj = this.b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f3807a + ", value=" + this.b + ')';
    }
}
