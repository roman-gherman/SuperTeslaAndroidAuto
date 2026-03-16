package P2;

import a3.AbstractC0162z;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0162z f1221a;

    public o(AbstractC0162z abstractC0162z) {
        this.f1221a = abstractC0162z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o) && kotlin.jvm.internal.h.a(this.f1221a, ((o) obj).f1221a);
    }

    public final int hashCode() {
        return this.f1221a.hashCode();
    }

    public final String toString() {
        return "LocalClass(type=" + this.f1221a + ')';
    }
}
