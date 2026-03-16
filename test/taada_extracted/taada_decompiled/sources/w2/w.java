package w2;

/* JADX INFO: loaded from: classes2.dex */
public final class w {
    public static final w d = new w(G.STRICT, 6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G f5023a;
    public final N1.c b;
    public final G c;

    public w(G g6, N1.c cVar, G g7) {
        this.f5023a = g6;
        this.b = cVar;
        this.c = g7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f5023a == wVar.f5023a && kotlin.jvm.internal.h.a(this.b, wVar.b) && this.c == wVar.c;
    }

    public final int hashCode() {
        int iHashCode = this.f5023a.hashCode() * 31;
        N1.c cVar = this.b;
        return this.c.hashCode() + ((iHashCode + (cVar == null ? 0 : cVar.d)) * 31);
    }

    public final String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f5023a + ", sinceVersion=" + this.b + ", reportLevelAfter=" + this.c + ')';
    }

    public w(G g6, int i) {
        this(g6, (i & 2) != 0 ? new N1.c(0, 0) : null, g6);
    }
}
