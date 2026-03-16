package f;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3162a;

    public p(byte[] bArr) {
        this.f3162a = bArr;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(p pVar) {
        int length;
        int length2;
        byte[] bArr = this.f3162a;
        int iMin = Math.min(bArr.length, pVar.f3162a.length);
        int i = 0;
        while (true) {
            byte[] bArr2 = pVar.f3162a;
            if (i >= iMin) {
                length = bArr.length;
                length2 = bArr2.length;
                break;
            }
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b != b2) {
                length = b & 255;
                length2 = b2 & 255;
                break;
            }
            i++;
        }
        return length - length2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        byte[] bArr = this.f3162a;
        androidx.constraintlayout.core.motion.a.w(sb, "...(", bArr[0] & 255);
        return B2.b.g(sb, ")", bArr.length);
    }
}
