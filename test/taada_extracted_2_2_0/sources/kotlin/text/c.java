package kotlin.text;

import e2.C0430f;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3945a;
    public final C0430f b;

    public c(String str, C0430f c0430f) {
        this.f3945a = str;
        this.b = c0430f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.h.a(this.f3945a, cVar.f3945a) && kotlin.jvm.internal.h.a(this.b, cVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f3945a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f3945a + ", range=" + this.b + ')';
    }
}
