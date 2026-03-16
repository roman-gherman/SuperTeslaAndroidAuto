package m;

/* JADX INFO: loaded from: classes.dex */
public final class k extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f4008a;

    public k(i iVar) {
        this.f4008a = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        Object obj2 = q.f4016a;
        ((k) rVar).getClass();
        return obj2.equals(obj2) && this.f4008a.equals(((k) rVar).f4008a);
    }

    public final int hashCode() {
        return ((q.f4016a.hashCode() ^ 1000003) * 1000003) ^ this.f4008a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + q.f4016a + ", androidClientInfo=" + this.f4008a + "}";
    }
}
