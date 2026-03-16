package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Transformer;
import k.AbstractC0570c;
import k.C0569b;

/* JADX INFO: loaded from: classes.dex */
public final class j extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f1882a;
    public final String b;
    public final AbstractC0570c c;
    public final Transformer d;
    public final C0569b e;

    public j(k kVar, String str, AbstractC0570c abstractC0570c, Transformer transformer, C0569b c0569b) {
        this.f1882a = kVar;
        this.b = str;
        this.c = abstractC0570c;
        this.d = transformer;
        this.e = c0569b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        j jVar = (j) ((t) obj);
        if (this.f1882a.equals(jVar.f1882a)) {
            return this.b.equals(jVar.b) && this.c.equals(jVar.c) && this.d.equals(jVar.d) && this.e.equals(jVar.e);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.f1882a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode();
    }

    public final String toString() {
        return "SendRequest{transportContext=" + this.f1882a + ", transportName=" + this.b + ", event=" + this.c + ", transformer=" + this.d + ", encoding=" + this.e + "}";
    }
}
