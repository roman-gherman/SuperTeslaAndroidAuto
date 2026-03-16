package m;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4012a;
    public final long b;
    public final k c;
    public final Integer d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f4013f;

    public m(long j6, long j7, k kVar, Integer num, String str, ArrayList arrayList) {
        x xVar = x.f4019a;
        this.f4012a = j6;
        this.b = j7;
        this.c = kVar;
        this.d = num;
        this.e = str;
        this.f4013f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        m mVar = (m) ((t) obj);
        if (this.f4012a != mVar.f4012a) {
            return false;
        }
        if (this.b != mVar.b) {
            return false;
        }
        if (!this.c.equals(mVar.c)) {
            return false;
        }
        Integer num = mVar.d;
        Integer num2 = this.d;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str = mVar.e;
        String str2 = this.e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (!this.f4013f.equals(mVar.f4013f)) {
            return false;
        }
        Object obj2 = x.f4019a;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        long j6 = this.f4012a;
        long j7 = this.b;
        int iHashCode = (((((((int) (j6 ^ (j6 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j7 >>> 32) ^ j7))) * 1000003) ^ this.c.hashCode()) * 1000003;
        Integer num = this.d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        return ((((iHashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.f4013f.hashCode()) * 1000003) ^ x.f4019a.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f4012a + ", requestUptimeMs=" + this.b + ", clientInfo=" + this.c + ", logSource=" + this.d + ", logSourceName=" + this.e + ", logEvents=" + this.f4013f + ", qosTier=" + x.f4019a + "}";
    }
}
