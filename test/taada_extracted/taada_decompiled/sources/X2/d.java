package X2;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.b f1415a;
    public final c b;

    public d(L2.b classId, c cVar) {
        kotlin.jvm.internal.h.f(classId, "classId");
        this.f1415a = classId;
        this.b = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return kotlin.jvm.internal.h.a(this.f1415a, ((d) obj).f1415a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1415a.hashCode();
    }
}
