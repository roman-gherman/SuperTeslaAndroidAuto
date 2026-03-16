package E2;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f311a;

    public p(String str) {
        this.f311a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && kotlin.jvm.internal.h.a(this.f311a, ((p) obj).f311a);
    }

    public final int hashCode() {
        return this.f311a.hashCode();
    }

    public final String toString() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("MemberSignature(signature="), this.f311a, ')');
    }
}
