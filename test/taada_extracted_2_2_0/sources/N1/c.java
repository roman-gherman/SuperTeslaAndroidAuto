package N1;

import e2.C0430f;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Comparable {
    public static final c e = new c(8, 22);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1120a = 1;
    public final int b;
    public final int c;
    public final int d;

    public c(int i, int i3) {
        this.b = i;
        this.c = i3;
        if (new C0430f(0, 255, 1).b(1) && new C0430f(0, 255, 1).b(i) && new C0430f(0, 255, 1).b(i3)) {
            this.d = 65536 + (i << 8) + i3;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: 1." + i + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + i3).toString());
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        c other = (c) obj;
        kotlin.jvm.internal.h.f(other, "other");
        return this.d - other.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        c cVar = obj instanceof c ? (c) obj : null;
        return cVar != null && this.d == cVar.d;
    }

    public final int hashCode() {
        return this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1120a);
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        sb.append(this.b);
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        sb.append(this.c);
        return sb.toString();
    }
}
