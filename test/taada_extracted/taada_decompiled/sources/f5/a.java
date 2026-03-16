package f5;

import C5.f;
import java.lang.reflect.Array;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3253a;
    public int b;
    public int[][] c;
    public int d;

    public a(byte[] bArr) {
        if (bArr.length < 9) {
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        int iC = f.c(0, bArr);
        this.f3253a = iC;
        int iC2 = f.c(4, bArr);
        this.b = iC2;
        int i = ((iC2 + 7) >>> 3) * iC;
        if (iC > 0) {
            int i3 = 8;
            if (i == bArr.length - 8) {
                int i4 = (iC2 + 31) >>> 5;
                this.d = i4;
                this.c = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iC, i4);
                int i5 = iC2 >> 5;
                int i6 = iC2 & 31;
                for (int i7 = 0; i7 < this.f3253a; i7++) {
                    int i8 = 0;
                    while (i8 < i5) {
                        this.c[i7][i8] = f.c(i3, bArr);
                        i8++;
                        i3 += 4;
                    }
                    int i9 = 0;
                    while (i9 < i6) {
                        int[] iArr = this.c[i7];
                        iArr[i5] = ((bArr[i3] & 255) << i9) ^ iArr[i5];
                        i9 += 8;
                        i3++;
                    }
                }
                return;
            }
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public final byte[] a() {
        int[][] iArr;
        int i = this.b;
        int i3 = this.f3253a;
        int i4 = 8;
        byte[] bArr = new byte[(((i + 7) >>> 3) * i3) + 8];
        f.a(bArr, i3, 0);
        f.a(bArr, i, 4);
        int i5 = i >>> 5;
        int i6 = i & 31;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            while (true) {
                iArr = this.c;
                if (i8 >= i5) {
                    break;
                }
                f.a(bArr, iArr[i7][i8], i4);
                i8++;
                i4 += 4;
            }
            int i9 = 0;
            while (i9 < i6) {
                bArr[i4] = (byte) ((iArr[i7][i5] >>> i9) & 255);
                i9 += 8;
                i4++;
            }
        }
        return bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        int i = aVar.f3253a;
        int i3 = this.f3253a;
        if (i3 != i || this.b != aVar.b || this.d != aVar.d) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!l.q(this.c[i4], aVar.c[i4])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = this.f3253a;
        int iL = (((i * 31) + this.b) * 31) + this.d;
        for (int i3 = 0; i3 < i; i3++) {
            iL = (iL * 31) + g5.c.l(this.c[i3]);
        }
        return iL;
    }

    public final String toString() {
        int[][] iArr;
        int i = this.b & 31;
        int i3 = this.d;
        int i4 = i == 0 ? i3 : i3 - 1;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i5 = 0; i5 < this.f3253a; i5++) {
            stringBuffer.append(i5 + ": ");
            int i6 = 0;
            while (true) {
                iArr = this.c;
                if (i6 >= i4) {
                    break;
                }
                int i7 = iArr[i5][i6];
                for (int i8 = 0; i8 < 32; i8++) {
                    if (((i7 >>> i8) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
                i6++;
            }
            int i9 = iArr[i5][i3 - 1];
            for (int i10 = 0; i10 < i; i10++) {
                if (((i9 >>> i10) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
