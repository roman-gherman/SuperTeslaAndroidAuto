package m;

/* JADX INFO: loaded from: classes.dex */
public final class k extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f4007a;

    public k(i iVar) {
        this.f4007a = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        Object obj2 = q.f4015a;
        ((k) rVar).getClass();
        return obj2.equals(obj2) && this.f4007a.equals(((k) rVar).f4007a);
    }

    public final int hashCode() {
        return ((q.f4015a.hashCode() ^ 1000003) * 1000003) ^ this.f4007a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + q.f4015a + ", androidClientInfo=" + this.f4007a + "}";
    }
}
