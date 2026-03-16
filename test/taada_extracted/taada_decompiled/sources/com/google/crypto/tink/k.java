package com.google.crypto.tink;

import com.google.crypto.tink.subtle.q;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f2802a;

    public k(byte[] bArr) {
        this.f2802a = Arrays.copyOf(bArr, bArr.length);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        k kVar = (k) obj;
        byte[] bArr = this.f2802a;
        int length = bArr.length;
        byte[] bArr2 = kVar.f2802a;
        if (length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = kVar.f2802a[i];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return Arrays.equals(this.f2802a, ((k) obj).f2802a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2802a);
    }

    public final String toString() {
        return q.d(this.f2802a);
    }
}
