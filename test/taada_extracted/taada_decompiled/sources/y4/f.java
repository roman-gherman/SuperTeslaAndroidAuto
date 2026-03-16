package y4;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5156a;
    public final B2.d[] b;

    public f(C0937a c0937a, int i) {
        this.f5156a = i;
        switch (i) {
            case 1:
                int i3 = c0937a.d;
                this.b = new B2.d[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    this.b[i4] = new B2.d(c0937a);
                }
                break;
            default:
                int i5 = c0937a.c;
                this.b = new B2.d[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    this.b[i6] = new B2.d(c0937a);
                }
                break;
        }
    }

    public void a() {
        int i = 0;
        while (true) {
            B2.d[] dVarArr = this.b;
            if (i >= dVarArr.length) {
                return;
            }
            B2.d dVar = dVarArr[i];
            for (int i3 = 0; i3 < 256; i3++) {
                int[] iArr = (int[]) dVar.b;
                int i4 = iArr[i3];
                iArr[i3] = i4 + ((i4 >> 31) & 8380417);
            }
            dVar.getClass();
            i++;
        }
    }

    public void b() {
        int i;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            B2.d[] dVarArr = this.b;
            if (i4 >= dVarArr.length) {
                return;
            }
            B2.d dVar = dVarArr[i4];
            int[] iArr = (int[]) dVar.b;
            int i5 = g5.c.i(i3, iArr.length);
            int[] iArr2 = new int[i5];
            System.arraycopy(iArr, i3, iArr2, i3, Math.min(iArr.length, i5));
            int i6 = 1;
            int i7 = 256;
            while (i6 < 256) {
                for (int i8 = i3; i8 < 256; i8 = i + i6) {
                    i7--;
                    int i9 = e.f5155a[i7] * (-1);
                    i = i8;
                    while (i < i8 + i6) {
                        int i10 = iArr2[i];
                        int i11 = i + i6;
                        iArr2[i] = iArr2[i11] + i10;
                        int i12 = i10 - iArr2[i11];
                        iArr2[i11] = i12;
                        iArr2[i11] = e.a(((long) i9) * ((long) i12));
                        i++;
                    }
                }
                i6 <<= 1;
                i3 = 0;
            }
            for (int i13 = 0; i13 < 256; i13++) {
                iArr2[i13] = e.a(((long) iArr2[i13]) * 41978);
            }
            dVar.b = iArr2;
            i4++;
            i3 = 0;
        }
    }

    public void c() {
        int i;
        int i3 = 0;
        while (true) {
            B2.d[] dVarArr = this.b;
            if (i3 >= dVarArr.length) {
                return;
            }
            B2.d dVar = dVarArr[i3];
            int[] iArr = (int[]) dVar.b;
            int i4 = g5.c.i(0, iArr.length);
            int[] iArr2 = new int[i4];
            System.arraycopy(iArr, 0, iArr2, 0, Math.min(iArr.length, i4));
            int i5 = 0;
            for (int i6 = 128; i6 > 0; i6 >>>= 1) {
                for (int i7 = 0; i7 < 256; i7 = i + i6) {
                    i5++;
                    int i8 = e.f5155a[i5];
                    i = i7;
                    while (i < i7 + i6) {
                        int i9 = i + i6;
                        int iA = e.a(((long) i8) * ((long) iArr2[i9]));
                        iArr2[i9] = iArr2[i] - iA;
                        iArr2[i] = iArr2[i] + iA;
                        i++;
                    }
                }
            }
            dVar.b = iArr2;
            i3++;
        }
    }

    public void d(f fVar) {
        int i = 0;
        while (true) {
            B2.d[] dVarArr = this.b;
            if (i >= dVarArr.length) {
                return;
            }
            B2.d dVar = dVarArr[i];
            B2.d dVar2 = fVar.b[i];
            for (int i3 = 0; i3 < 256; i3++) {
                int[] iArr = (int[]) dVar.b;
                int i4 = iArr[i3];
                int i5 = (i4 + 4095) >> 13;
                int[] iArr2 = {i5, i4 - (i5 << 13)};
                iArr[i3] = iArr2[0];
                ((int[]) dVar2.b)[i3] = iArr2[1];
            }
            dVar.getClass();
            i++;
        }
    }

    public void e() {
        int i = 0;
        while (true) {
            B2.d[] dVarArr = this.b;
            if (i >= dVarArr.length) {
                return;
            }
            B2.d dVar = dVarArr[i];
            for (int i3 = 0; i3 < 256; i3++) {
                int[] iArr = (int[]) dVar.b;
                int i4 = iArr[i3];
                iArr[i3] = i4 - (((4194304 + i4) >> 23) * 8380417);
            }
            dVar.getClass();
            i++;
        }
    }

    public final String toString() {
        switch (this.f5156a) {
            case 0:
                String strE = "[";
                int i = 0;
                while (true) {
                    B2.d[] dVarArr = this.b;
                    if (i >= dVarArr.length) {
                        return B2.b.e(strE, "]");
                    }
                    strE = strE + i + " " + dVarArr[i].toString();
                    if (i != dVarArr.length - 1) {
                        strE = B2.b.e(strE, ",\n");
                    }
                    i++;
                }
                break;
            default:
                String strE2 = "\n[";
                int i3 = 0;
                while (true) {
                    B2.d[] dVarArr2 = this.b;
                    if (i3 >= dVarArr2.length) {
                        return B2.b.e(strE2, "]");
                    }
                    strE2 = strE2 + "Inner Matrix " + i3 + " " + dVarArr2[i3].toString();
                    if (i3 != dVarArr2.length - 1) {
                        strE2 = B2.b.e(strE2, ",\n");
                    }
                    i3++;
                }
                break;
        }
    }
}
