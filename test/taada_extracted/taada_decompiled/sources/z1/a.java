package z1;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5170a;

    public a(String str) {
        this.f5170a = str;
        if (str.length() == 0) {
            throw new IllegalStateException("Name can't be blank");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && a.class == obj.getClass() && kotlin.jvm.internal.h.a(this.f5170a, ((a) obj).f5170a);
    }

    public final int hashCode() {
        return this.f5170a.hashCode();
    }

    public final String toString() {
        return "AttributeKey: " + this.f5170a;
    }
}
