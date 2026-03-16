package v0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class j extends D0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4912a;
    public final int b;
    public final int c;
    public final f d;

    public j(int i, int i3, int i4, f fVar) {
        this.f4912a = i;
        this.b = i3;
        this.c = i4;
        this.d = fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f4912a == this.f4912a && jVar.b == this.b && jVar.c == this.c && jVar.d == this.d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f4912a), Integer.valueOf(this.b), Integer.valueOf(this.c), this.d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesGcm Parameters (variant: ");
        sb.append(this.d);
        sb.append(", ");
        sb.append(this.b);
        sb.append("-byte IV, ");
        sb.append(this.c);
        sb.append("-byte tag, and ");
        return B2.b.g(sb, "-byte key)", this.f4912a);
    }
}
