package D0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class g extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f238a;
    public final int b;
    public final f c;

    public g(int i, int i3, f fVar) {
        this.f238a = i;
        this.b = i3;
        this.c = fVar;
    }

    public final int a() {
        f fVar = f.f228f;
        int i = this.b;
        f fVar2 = this.c;
        if (fVar2 == fVar) {
            return i;
        }
        if (fVar2 != f.c && fVar2 != f.d && fVar2 != f.e) {
            throw new IllegalStateException("Unknown variant");
        }
        return i + 5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return gVar.f238a == this.f238a && gVar.a() == a() && gVar.c == this.c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f238a), Integer.valueOf(this.b), this.c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AES-CMAC Parameters (variant: ");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.b);
        sb.append("-byte tags, and ");
        return B2.b.g(sb, "-byte key)", this.f238a);
    }
}
