package k;

/* JADX INFO: renamed from: k.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0569b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3677a;

    public C0569b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f3677a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0569b)) {
            return false;
        }
        return this.f3677a.equals(((C0569b) obj).f3677a);
    }

    public final int hashCode() {
        return this.f3677a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return B2.b.h(new StringBuilder("Encoding{name=\""), this.f3677a, "\"}");
    }
}
