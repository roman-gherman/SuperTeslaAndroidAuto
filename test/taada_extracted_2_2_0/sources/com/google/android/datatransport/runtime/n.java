package com.google.android.datatransport.runtime;

import java.util.Arrays;
import k.C0569b;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0569b f1888a;
    public final byte[] b;

    public n(C0569b c0569b, byte[] bArr) {
        if (c0569b == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f1888a = c0569b;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f1888a.equals(nVar.f1888a)) {
            return Arrays.equals(this.b, nVar.b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f1888a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f1888a + ", bytes=[...]}";
    }
}
