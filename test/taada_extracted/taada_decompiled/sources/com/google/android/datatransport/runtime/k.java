package com.google.android.datatransport.runtime;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class k extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1883a;
    public final byte[] b;
    public final k.d c;

    public k(String str, byte[] bArr, k.d dVar) {
        this.f1883a = str;
        this.b = bArr;
        this.c = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f1883a.equals(((k) uVar).f1883a)) {
                if (Arrays.equals(this.b, (uVar instanceof k ? (k) uVar : (k) uVar).b) && this.c.equals(((k) uVar).c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f1883a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b)) * 1000003) ^ this.c.hashCode();
    }
}
