package com.google.android.play.core.review;

import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
final class zza extends ReviewInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f2767a;
    public final boolean b;

    public zza(PendingIntent pendingIntent, boolean z6) {
        if (pendingIntent == null) {
            throw new NullPointerException("Null pendingIntent");
        }
        this.f2767a = pendingIntent;
        this.b = z6;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    public final PendingIntent b() {
        return this.f2767a;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    public final boolean c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReviewInfo)) {
            return false;
        }
        ReviewInfo reviewInfo = (ReviewInfo) obj;
        return this.f2767a.equals(reviewInfo.b()) && this.b == reviewInfo.c();
    }

    public final int hashCode() {
        return ((this.f2767a.hashCode() ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231);
    }

    public final String toString() {
        StringBuilder sbM = B2.b.m("ReviewInfo{pendingIntent=", this.f2767a.toString(), ", isNoOp=");
        sbM.append(this.b);
        sbM.append("}");
        return sbM.toString();
    }
}
