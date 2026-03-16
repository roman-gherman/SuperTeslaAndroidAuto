package P2;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.b f1216a;
    public final int b;

    public f(L2.b bVar, int i) {
        this.f1216a = bVar;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.h.a(this.f1216a, fVar.f1216a) && this.b == fVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f1216a.hashCode() * 31);
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            i = this.b;
            if (i3 >= i) {
                break;
            }
            sb.append("kotlin/Array<");
            i3++;
        }
        sb.append(this.f1216a);
        for (int i4 = 0; i4 < i; i4++) {
            sb.append(">");
        }
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
