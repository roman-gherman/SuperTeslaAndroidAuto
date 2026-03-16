package u1;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public static final r b;
    public static final r c;
    public static final r d;
    public static final List e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4871a;

    static {
        r rVar = new r("GET");
        b = rVar;
        r rVar2 = new r("POST");
        c = rVar2;
        r rVar3 = new r("PUT");
        r rVar4 = new r("PATCH");
        r rVar5 = new r("DELETE");
        r rVar6 = new r("HEAD");
        d = rVar6;
        e = kotlin.collections.n.y(rVar, rVar2, rVar3, rVar4, rVar5, rVar6, new r("OPTIONS"));
    }

    public r(String str) {
        this.f4871a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && kotlin.jvm.internal.h.a(this.f4871a, ((r) obj).f4871a);
    }

    public final int hashCode() {
        return this.f4871a.hashCode();
    }

    public final String toString() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("HttpMethod(value="), this.f4871a, ')');
    }
}
