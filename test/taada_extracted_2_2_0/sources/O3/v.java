package o3;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static final u b = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4355a;

    public static final Throwable a(Object obj) {
        t tVar = obj instanceof t ? (t) obj : null;
        if (tVar != null) {
            return tVar.f4354a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof v) {
            return kotlin.jvm.internal.h.a(this.f4355a, ((v) obj).f4355a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f4355a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f4355a;
        if (obj instanceof t) {
            return ((t) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
