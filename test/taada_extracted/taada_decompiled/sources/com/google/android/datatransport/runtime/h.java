package com.google.android.datatransport.runtime;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1878a;
    public Integer b;
    public n c;
    public Long d;
    public Long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap f1879f;

    public final void a(String str, String str2) {
        HashMap map = this.f1879f;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put(str, str2);
    }

    public final i b() {
        String strE = this.f1878a == null ? " transportName" : "";
        if (this.c == null) {
            strE = strE.concat(" encodedPayload");
        }
        if (this.d == null) {
            strE = B2.b.e(strE, " eventMillis");
        }
        if (this.e == null) {
            strE = B2.b.e(strE, " uptimeMillis");
        }
        if (this.f1879f == null) {
            strE = B2.b.e(strE, " autoMetadata");
        }
        if (strE.isEmpty()) {
            return new i(this.f1878a, this.b, this.c, this.d.longValue(), this.e.longValue(), this.f1879f);
        }
        throw new IllegalStateException("Missing required properties:".concat(strE));
    }
}
