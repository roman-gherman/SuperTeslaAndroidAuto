package w3;

import java.util.Arrays;

/* JADX INFO: renamed from: w3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0895m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5064a;
    public final byte[] b;

    public C0895m(byte[] bArr) {
        this.f5064a = g5.c.k(bArr);
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0895m)) {
            return false;
        }
        return Arrays.equals(this.b, ((C0895m) obj).b);
    }

    public final int hashCode() {
        return this.f5064a;
    }
}
