package w2;

/* JADX INFO: loaded from: classes2.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.f f4991a;
    public final String b;

    public K(L2.f fVar, String signature) {
        kotlin.jvm.internal.h.f(signature, "signature");
        this.f4991a = fVar;
        this.b = signature;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K)) {
            return false;
        }
        K k6 = (K) obj;
        return kotlin.jvm.internal.h.a(this.f4991a, k6.f4991a) && kotlin.jvm.internal.h.a(this.b, k6.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f4991a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NameAndSignature(name=");
        sb.append(this.f4991a);
        sb.append(", signature=");
        return androidx.constraintlayout.core.motion.a.s(sb, this.b, ')');
    }
}
