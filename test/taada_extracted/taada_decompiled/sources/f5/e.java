package f5;

import E1.k;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f3257a;
    public int b;
    public int[] c;

    public e(b bVar, int[] iArr) {
        int[] iArr2;
        this.f3257a = bVar;
        int iB = b(iArr);
        if (iB == -1) {
            iArr2 = new int[1];
        } else {
            int i = iB + 1;
            if (iArr.length == i) {
                iArr2 = new int[iArr.length];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            } else {
                int[] iArr3 = new int[i];
                System.arraycopy(iArr, 0, iArr3, 0, i);
                iArr2 = iArr3;
            }
        }
        this.c = iArr2;
        c();
    }

    public static int b(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    public final int[] a(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            int i = iArr3[length];
            int i3 = iArr[length];
            this.f3257a.getClass();
            iArr3[length] = i ^ i3;
        }
        return iArr3;
    }

    public final void c() {
        int length = this.c.length;
        do {
            this.b = length - 1;
            length = this.b;
            if (length < 0) {
                return;
            }
        } while (this.c[length] == 0);
    }

    public final int d(int i) {
        if (i < 0 || i > this.b) {
            return 0;
        }
        return this.c[i];
    }

    public final int[] e(int i, int[] iArr) {
        int iB = b(iArr);
        if (iB == -1 || i == 0) {
            return new int[1];
        }
        if (i == 1) {
            int[] iArr2 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        int[] iArr3 = new int[iB + 1];
        while (iB >= 0) {
            iArr3[iB] = k.a0(iArr[iB], i, this.f3257a.b);
            iB--;
        }
        return iArr3;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            if (this.f3257a.equals(eVar.f3257a) && this.b == eVar.b) {
                int[] iArr = this.c;
                int[] iArr2 = eVar.c;
                int iB = b(iArr);
                if (iB == b(iArr2)) {
                    for (int i = 0; i <= iB; i++) {
                        if (iArr[i] == iArr2[i]) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f3257a.b;
        int i3 = 0;
        while (true) {
            int[] iArr = this.c;
            if (i3 >= iArr.length) {
                return i;
            }
            i = (i * 31) + iArr[i3];
            i3++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" Polynomial over ");
        b bVar = this.f3257a;
        sb.append(bVar.toString());
        sb.append(": \n");
        String string = sb.toString();
        for (int i = 0; i < this.c.length; i++) {
            StringBuilder sbK = B2.b.k(string);
            int i3 = this.c[i];
            String strP = "";
            for (int i4 = 0; i4 < bVar.f3254a; i4++) {
                strP = androidx.constraintlayout.core.motion.a.p((((byte) i3) & 1) == 0 ? "0" : "1", strP);
                i3 >>>= 1;
            }
            sbK.append(strP);
            sbK.append("Y^");
            sbK.append(i);
            sbK.append(Marker.ANY_NON_NULL_MARKER);
            string = sbK.toString();
        }
        return B2.b.e(string, ";");
    }
}
