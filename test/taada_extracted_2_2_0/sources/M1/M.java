package m1;

/* JADX INFO: loaded from: classes2.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f4044a;
    public Long b;
    public Long c;

    public M() {
        this.f4044a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.f4044a = null;
        this.b = null;
        this.c = null;
    }

    public static void a(Long l6) {
        if (l6 != null && l6.longValue() <= 0) {
            throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || M.class != obj.getClass()) {
            return false;
        }
        M m6 = (M) obj;
        return kotlin.jvm.internal.h.a(this.f4044a, m6.f4044a) && kotlin.jvm.internal.h.a(this.b, m6.b) && kotlin.jvm.internal.h.a(this.c, m6.c);
    }

    public final int hashCode() {
        Long l6 = this.f4044a;
        int iHashCode = (l6 != null ? l6.hashCode() : 0) * 31;
        Long l7 = this.b;
        int iHashCode2 = (iHashCode + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.c;
        return iHashCode2 + (l8 != null ? l8.hashCode() : 0);
    }
}
