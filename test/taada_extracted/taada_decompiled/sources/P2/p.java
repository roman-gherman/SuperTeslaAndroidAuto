package P2;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1222a;

    public p(f fVar) {
        this.f1222a = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && kotlin.jvm.internal.h.a(this.f1222a, ((p) obj).f1222a);
    }

    public final int hashCode() {
        return this.f1222a.hashCode();
    }

    public final String toString() {
        return "NormalClass(value=" + this.f1222a + ')';
    }
}
