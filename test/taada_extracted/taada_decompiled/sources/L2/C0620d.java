package l2;

/* JADX INFO: renamed from: l2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0620d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0621e f3969a;
    public final int b;

    public C0620d(EnumC0621e enumC0621e, int i) {
        this.f3969a = enumC0621e;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0620d)) {
            return false;
        }
        C0620d c0620d = (C0620d) obj;
        return this.f3969a == c0620d.f3969a && this.b == c0620d.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f3969a.hashCode() * 31);
    }

    public final String toString() {
        return "KindWithArity(kind=" + this.f3969a + ", arity=" + this.b + ')';
    }
}
