package m;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class j extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f4007a;

    public j(ArrayList arrayList) {
        this.f4007a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        return this.f4007a.equals(((j) ((p) obj)).f4007a);
    }

    public final int hashCode() {
        return this.f4007a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f4007a + "}";
    }
}
