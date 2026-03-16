package I0;

import com.google.crypto.tink.subtle.q;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f749a;

    public a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        this.f749a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i);
    }

    public static a a(byte[] bArr) {
        if (bArr != null) {
            return new a(bArr, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final byte[] b() {
        byte[] bArr = this.f749a;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return Arrays.equals(((a) obj).f749a, this.f749a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f749a);
    }

    public final String toString() {
        return "Bytes(" + q.d(this.f749a) + ")";
    }
}
