package m;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class l extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4009a;
    public final Integer b;
    public final long c;
    public final byte[] d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f4011g;

    public l(long j6, Integer num, long j7, byte[] bArr, String str, long j8, o oVar) {
        this.f4009a = j6;
        this.b = num;
        this.c = j7;
        this.d = bArr;
        this.e = str;
        this.f4010f = j8;
        this.f4011g = oVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        l lVar = (l) sVar;
        if (this.f4009a != lVar.f4009a) {
            return false;
        }
        Integer num = this.b;
        if (num == null) {
            if (lVar.b != null) {
                return false;
            }
        } else if (!num.equals(lVar.b)) {
            return false;
        }
        if (this.c != lVar.c) {
            return false;
        }
        if (!Arrays.equals(this.d, sVar instanceof l ? ((l) sVar).d : lVar.d)) {
            return false;
        }
        String str = lVar.e;
        String str2 = this.e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (this.f4010f != lVar.f4010f) {
            return false;
        }
        o oVar = lVar.f4011g;
        o oVar2 = this.f4011g;
        return oVar2 == null ? oVar == null : oVar2.equals(oVar);
    }

    public final int hashCode() {
        long j6 = this.f4009a;
        int i = (((int) (j6 ^ (j6 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.b;
        int iHashCode = (i ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j7 = this.c;
        int iHashCode2 = (((iHashCode ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.d)) * 1000003;
        String str = this.e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j8 = this.f4010f;
        int i3 = (iHashCode3 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        o oVar = this.f4011g;
        return i3 ^ (oVar != null ? oVar.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f4009a + ", eventCode=" + this.b + ", eventUptimeMs=" + this.c + ", sourceExtension=" + Arrays.toString(this.d) + ", sourceExtensionJsonProto3=" + this.e + ", timezoneOffsetSeconds=" + this.f4010f + ", networkConnectionInfo=" + this.f4011g + "}";
    }
}
