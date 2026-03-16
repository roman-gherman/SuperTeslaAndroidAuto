package com.google.android.datatransport.runtime.scheduling.persistence;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f1895f = new a(200, 10000, 81920, 10485760, 604800000);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1896a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;

    public a(int i, int i3, int i4, long j6, long j7) {
        this.f1896a = j6;
        this.b = i;
        this.c = i3;
        this.d = j7;
        this.e = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f1896a == aVar.f1896a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j6 = this.f1896a;
        int i = (((((((int) (j6 ^ (j6 >>> 32))) ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003;
        long j7 = this.d;
        return ((i ^ ((int) ((j7 >>> 32) ^ j7))) * 1000003) ^ this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.f1896a);
        sb.append(", loadBatchSize=");
        sb.append(this.b);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.c);
        sb.append(", eventCleanUpAge=");
        sb.append(this.d);
        sb.append(", maxBlobByteSizePerRow=");
        return B2.b.g(sb, "}", this.e);
    }
}
