package v0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class g extends D0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4908a;
    public final int b;
    public final int c;
    public final f d;

    public g(int i, int i3, int i4, f fVar) {
        this.f4908a = i;
        this.b = i3;
        this.c = i4;
        this.d = fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return gVar.f4908a == this.f4908a && gVar.b == this.b && gVar.c == this.c && gVar.d == this.d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f4908a), Integer.valueOf(this.b), Integer.valueOf(this.c), this.d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesEax Parameters (variant: ");
        sb.append(this.d);
        sb.append(", ");
        sb.append(this.b);
        sb.append("-byte IV, ");
        sb.append(this.c);
        sb.append("-byte tag, and ");
        return B2.b.g(sb, "-byte key)", this.f4908a);
    }
}
