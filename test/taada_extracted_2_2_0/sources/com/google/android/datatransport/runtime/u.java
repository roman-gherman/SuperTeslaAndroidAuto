package com.google.android.datatransport.runtime;

import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public final String toString() {
        k kVar = (k) this;
        byte[] bArr = kVar.b;
        return "TransportContext(" + kVar.f1883a + ", " + kVar.c + ", " + (bArr == null ? "" : Base64.encodeToString(bArr, 2)) + ")";
    }
}
