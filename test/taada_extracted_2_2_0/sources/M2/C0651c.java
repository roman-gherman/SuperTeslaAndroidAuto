package m2;

/* JADX INFO: renamed from: m2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0651c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.b f4074a;
    public final L2.b b;
    public final L2.b c;

    public C0651c(L2.b bVar, L2.b bVar2, L2.b bVar3) {
        this.f4074a = bVar;
        this.b = bVar2;
        this.c = bVar3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0651c)) {
            return false;
        }
        C0651c c0651c = (C0651c) obj;
        return kotlin.jvm.internal.h.a(this.f4074a, c0651c.f4074a) && kotlin.jvm.internal.h.a(this.b, c0651c.b) && kotlin.jvm.internal.h.a(this.c, c0651c.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f4074a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PlatformMutabilityMapping(javaClass=" + this.f4074a + ", kotlinReadOnly=" + this.b + ", kotlinMutable=" + this.c + ')';
    }
}
