package Q3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1238a;
    public final int b;

    public d(byte[] bArr, int i) {
        this.f1238a = g5.c.c(bArr);
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (dVar.b != this.b) {
            return false;
        }
        return Arrays.equals(this.f1238a, dVar.f1238a);
    }

    public final int hashCode() {
        return g5.c.k(this.f1238a) ^ this.b;
    }
}
