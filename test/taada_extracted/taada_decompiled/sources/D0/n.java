package D0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class n extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f244a;
    public final int b;
    public final f c;
    public final f d;

    public n(int i, int i3, f fVar, f fVar2) {
        this.f244a = i;
        this.b = i3;
        this.c = fVar;
        this.d = fVar2;
    }

    public final int a() {
        f fVar = f.f236o;
        int i = this.b;
        f fVar2 = this.c;
        if (fVar2 == fVar) {
            return i;
        }
        if (fVar2 != f.f233l && fVar2 != f.f234m && fVar2 != f.f235n) {
            throw new IllegalStateException("Unknown variant");
        }
        return i + 5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.f244a == this.f244a && nVar.a() == a() && nVar.c == this.c && nVar.d == this.d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f244a), Integer.valueOf(this.b), this.c, this.d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HMAC Parameters (variant: ");
        sb.append(this.c);
        sb.append(", hashType: ");
        sb.append(this.d);
        sb.append(", ");
        sb.append(this.b);
        sb.append("-byte tags, and ");
        return B2.b.g(sb, "-byte key)", this.f244a);
    }
}
