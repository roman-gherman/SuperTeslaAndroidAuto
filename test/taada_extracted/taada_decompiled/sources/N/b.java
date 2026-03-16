package n;

import f.s;

/* JADX INFO: loaded from: classes.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4158a;
    public final long b;

    public b(int i, long j6) {
        if (i == 0) {
            throw new NullPointerException("Null status");
        }
        this.f4158a = i;
        this.b = j6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        b bVar = (b) ((e) obj);
        int i = bVar.f4158a;
        int i3 = this.f4158a;
        if (i3 != 0) {
            return (i3 == i) && this.b == bVar.b;
        }
        throw null;
    }

    public final int hashCode() {
        int iB = (s.b(this.f4158a) ^ 1000003) * 1000003;
        long j6 = this.b;
        return iB ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i = this.f4158a;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVALID_PAYLOAD" : "FATAL_ERROR" : "TRANSIENT_ERROR" : "OK");
        sb.append(", nextRequestWaitMillis=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
}
