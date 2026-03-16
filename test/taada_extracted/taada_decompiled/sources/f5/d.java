package f5;

import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f3256a;

    public d(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid length");
        }
        this.f3256a = new int[i];
        for (int i3 = i - 1; i3 >= 0; i3--) {
            this.f3256a[i3] = i3;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return l.q(this.f3256a, ((d) obj).f3256a);
        }
        return false;
    }

    public final int hashCode() {
        return g5.c.l(this.f3256a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int[] iArr = this.f3256a;
        sb.append(iArr[0]);
        String string = sb.toString();
        for (int i = 1; i < iArr.length; i++) {
            StringBuilder sbL = B2.b.l(string, ", ");
            sbL.append(iArr[i]);
            string = sbL.toString();
        }
        return B2.b.e(string, "]");
    }
}
