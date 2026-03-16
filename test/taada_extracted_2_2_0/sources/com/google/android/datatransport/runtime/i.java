package com.google.android.datatransport.runtime;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1880a;
    public final Integer b;
    public final n c;
    public final long d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f1881f;

    public i(String str, Integer num, n nVar, long j6, long j7, HashMap map) {
        this.f1880a = str;
        this.b = num;
        this.c = nVar;
        this.d = j6;
        this.e = j7;
        this.f1881f = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        i iVar = (i) ((o) obj);
        if (!this.f1880a.equals(iVar.f1880a)) {
            return false;
        }
        Integer num = this.b;
        if (num == null) {
            if (iVar.b != null) {
                return false;
            }
        } else if (!num.equals(iVar.b)) {
            return false;
        }
        return this.c.equals(iVar.c) && this.d == iVar.d && this.e == iVar.e && this.f1881f.equals(iVar.f1881f);
    }

    public final int hashCode() {
        int iHashCode = (this.f1880a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        long j6 = this.d;
        int i = (iHashCode2 ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        long j7 = this.e;
        return ((i ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ this.f1881f.hashCode();
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f1880a + ", code=" + this.b + ", encodedPayload=" + this.c + ", eventMillis=" + this.d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f1881f + "}";
    }
}
