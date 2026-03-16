package v0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class n extends D0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4916a;
    public final f b;

    public n(int i, f fVar) {
        this.f4916a = i;
        this.b = fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.f4916a == this.f4916a && nVar.b == this.b;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f4916a), this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesGcmSiv Parameters (variant: ");
        sb.append(this.b);
        sb.append(", ");
        return B2.b.g(sb, "-byte key)", this.f4916a);
    }
}
