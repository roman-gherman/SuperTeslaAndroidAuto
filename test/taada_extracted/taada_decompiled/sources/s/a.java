package s;

import com.google.android.datatransport.runtime.time.Clock;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Clock f4739a;
    public final HashMap b;

    public a(Clock clock, HashMap map) {
        this.f4739a = clock;
        this.b = map;
    }

    public final long a(k.d dVar, long j6, int i) {
        long time = j6 - this.f4739a.getTime();
        b bVar = (b) this.b.get(dVar);
        long j7 = bVar.f4740a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i - 1) * j7 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j7 > 1 ? j7 : 2L) * ((long) r12)))), time), bVar.b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f4739a.equals(aVar.f4739a) && this.b.equals(aVar.b);
    }

    public final int hashCode() {
        return ((this.f4739a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f4739a + ", values=" + this.b + "}";
    }
}
