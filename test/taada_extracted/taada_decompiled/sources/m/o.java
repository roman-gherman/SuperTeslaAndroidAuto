package m;

/* JADX INFO: loaded from: classes.dex */
public final class o extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f4014a;
    public final u b;

    public o(v vVar, u uVar) {
        this.f4014a = vVar;
        this.b = uVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            v vVar = this.f4014a;
            if (vVar != null ? vVar.equals(((o) wVar).f4014a) : ((o) wVar).f4014a == null) {
                u uVar = this.b;
                if (uVar != null ? uVar.equals(((o) wVar).b) : ((o) wVar).b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        v vVar = this.f4014a;
        int iHashCode = ((vVar == null ? 0 : vVar.hashCode()) ^ 1000003) * 1000003;
        u uVar = this.b;
        return (uVar != null ? uVar.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f4014a + ", mobileSubtype=" + this.b + "}";
    }
}
