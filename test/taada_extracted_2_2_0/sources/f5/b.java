package f5;

import E1.k;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3254a;
    public int b;

    public b(int i) {
        PrintStream printStream;
        String str;
        int i3 = 0;
        this.f3254a = 0;
        if (i >= 32) {
            throw new IllegalArgumentException(" Error: the degree of field is too large ");
        }
        if (i < 1) {
            throw new IllegalArgumentException(" Error: the degree of field is non-positive ");
        }
        this.f3254a = i;
        if (i < 0) {
            printStream = System.err;
            str = "The Degree is negative";
        } else {
            if (i <= 31) {
                if (i == 0) {
                    i3 = 1;
                } else {
                    int i4 = (1 << i) + 1;
                    int i5 = 1 << (i + 1);
                    while (true) {
                        if (i4 >= i5) {
                            break;
                        }
                        if (k.V(i4)) {
                            i3 = i4;
                            break;
                        }
                        i4 += 2;
                    }
                }
                this.b = i3;
            }
            printStream = System.err;
            str = "The Degree is more then 31";
        }
        printStream.println(str);
        this.b = i3;
    }

    public final int a(int i) {
        int i3 = (1 << this.f3254a) - 2;
        if (i3 != 0) {
            if (i == 0) {
                return 0;
            }
            if (i != 1) {
                if (i3 < 0) {
                    i = a(i);
                    i3 = -i3;
                }
                int iA0 = 1;
                while (i3 != 0) {
                    int i4 = i3 & 1;
                    int i5 = this.b;
                    if (i4 == 1) {
                        iA0 = k.a0(iA0, i, i5);
                    }
                    i = k.a0(i, i, i5);
                    i3 >>>= 1;
                }
                return iA0;
            }
        }
        return 1;
    }

    public final boolean b(int i) {
        int i3 = this.f3254a;
        return i3 == 31 ? i >= 0 : i >= 0 && i < (1 << i3);
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (this.f3254a == bVar.f3254a && this.b == bVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Finite Field GF(2^");
        sb.append(this.f3254a);
        sb.append(") = GF(2)[X]/<");
        int i = this.b;
        if (i == 0) {
            str = "0";
        } else {
            String str2 = ((byte) (i & 1)) == 1 ? "1" : "";
            int i3 = i >>> 1;
            int i4 = 1;
            while (i3 != 0) {
                if (((byte) (i3 & 1)) == 1) {
                    str2 = str2 + "+x^" + i4;
                }
                i3 >>>= 1;
                i4++;
            }
            str = str2;
        }
        return B2.b.h(sb, str, "> ");
    }
}
