package o3;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f4354a;

    public t(Throwable th) {
        this.f4354a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof t) {
            return kotlin.jvm.internal.h.a(this.f4354a, ((t) obj).f4354a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f4354a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // o3.u
    public final String toString() {
        return "Closed(" + this.f4354a + ')';
    }
}
