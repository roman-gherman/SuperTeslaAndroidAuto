package s;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4741a;
    public final long b;
    public final Set c;

    public b(long j6, long j7, Set set) {
        this.f4741a = j6;
        this.b = j7;
        this.c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f4741a == bVar.f4741a && this.b == bVar.b && this.c.equals(bVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j6 = this.f4741a;
        int i = (((int) (j6 ^ (j6 >>> 32))) ^ 1000003) * 1000003;
        long j7 = this.b;
        return ((i ^ ((int) ((j7 >>> 32) ^ j7))) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f4741a + ", maxAllowedDelay=" + this.b + ", flags=" + this.c + "}";
    }
}
