package n2;

import java.util.List;

/* JADX INFO: renamed from: n2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0722n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.b f4251a;
    public final List b;

    public C0722n(L2.b classId, List list) {
        kotlin.jvm.internal.h.f(classId, "classId");
        this.f4251a = classId;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0722n)) {
            return false;
        }
        C0722n c0722n = (C0722n) obj;
        return kotlin.jvm.internal.h.a(this.f4251a, c0722n.f4251a) && kotlin.jvm.internal.h.a(this.b, c0722n.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f4251a.hashCode() * 31);
    }

    public final String toString() {
        return "ClassRequest(classId=" + this.f4251a + ", typeParametersCount=" + this.b + ')';
    }
}
