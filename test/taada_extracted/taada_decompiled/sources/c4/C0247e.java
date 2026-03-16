package c4;

import java.math.BigInteger;
import java.util.Arrays;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: c4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0247e extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1791h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f1792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k f1793k;

    public C0247e(int i, int[] iArr, k kVar) {
        this.i = i;
        this.f1791h = iArr.length == 1 ? 2 : 3;
        this.f1792j = iArr;
        this.f1793k = kVar;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        k kVar = this.f1793k;
        int iJ = kVar.j();
        int i = this.i;
        int[] iArr = this.f1792j;
        if (iJ != 0) {
            int i3 = iJ << 1;
            long[] jArr = new long[i3];
            int i4 = 0;
            while (i4 < i3) {
                long j6 = kVar.f1799a[i4 >>> 1];
                int i5 = i4 + 1;
                jArr[i4] = k.k((int) j6);
                i4 += 2;
                jArr[i5] = k.k((int) (j6 >>> 32));
            }
            kVar = new k(jArr, k.l(jArr, i3, i, iArr));
        }
        return new C0247e(i, iArr, kVar);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return h0(abstractC0246d.W());
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        k kVar = this.f1793k;
        int iJ = kVar.j();
        if (iJ == 0) {
            return ECConstants.ZERO;
        }
        int i = iJ - 1;
        long j6 = kVar.f1799a[i];
        byte[] bArr = new byte[8];
        int i3 = 0;
        boolean z6 = false;
        for (int i4 = 7; i4 >= 0; i4--) {
            byte b = (byte) (j6 >>> (i4 * 8));
            if (z6 || b != 0) {
                bArr[i3] = b;
                i3++;
                z6 = true;
            }
        }
        byte[] bArr2 = new byte[(i * 8) + i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i5] = bArr[i5];
        }
        for (int i6 = iJ - 2; i6 >= 0; i6--) {
            long j7 = kVar.f1799a[i6];
            int i7 = 7;
            while (i7 >= 0) {
                bArr2[i3] = (byte) (j7 >>> (i7 * 8));
                i7--;
                i3++;
            }
        }
        return new BigInteger(1, bArr2);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int i;
        k kVar = this.f1793k;
        int iE = kVar.e();
        if (iE == 0) {
            throw new IllegalStateException();
        }
        int i3 = this.i;
        int[] iArr = this.f1792j;
        int i4 = 1;
        if (iE != 1) {
            k kVar2 = (k) kVar.clone();
            int i5 = (i3 + 63) >>> 6;
            k kVar3 = new k(i5);
            long[] jArr = kVar3.f1799a;
            k.g(jArr, i3);
            int length = iArr.length;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                k.g(jArr, iArr[length]);
            }
            int iF = 0;
            k.g(jArr, 0);
            k kVar4 = new k(i5);
            kVar4.f1799a[0] = 1;
            k kVar5 = new k(i5);
            int[] iArr2 = new int[2];
            iArr2[0] = iE;
            iArr2[1] = i3 + 1;
            k[] kVarArr = {kVar2, kVar3};
            int[] iArr3 = new int[2];
            iArr3[0] = 1;
            iArr3[1] = 0;
            k[] kVarArr2 = {kVar4, kVar5};
            int i6 = iArr2[1];
            int i7 = i6 - iArr2[0];
            while (true) {
                if (i7 < 0) {
                    i7 = -i7;
                    iArr2[i4] = i6;
                    iArr3[i4] = iF;
                    i4 = 1 - i4;
                    i6 = iArr2[i4];
                    iF = iArr3[i4];
                }
                i = 1 - i4;
                kVarArr[i4].b(kVarArr[i], iArr2[i], i7);
                int iF2 = kVarArr[i4].f(i6);
                if (iF2 == 0) {
                    break;
                }
                int i8 = iArr3[i];
                kVarArr2[i4].b(kVarArr2[i], i8, i7);
                int i9 = i8 + i7;
                if (i9 > iF) {
                    iF = i9;
                } else if (i9 == iF) {
                    iF = kVarArr2[i4].f(iF);
                }
                i7 += iF2 - i6;
                i6 = iF2;
            }
            kVar = kVarArr2[i];
        }
        return new C0247e(i3, iArr, kVar);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        long[] jArr = this.f1793k.f1799a;
        if (jArr[0] == 1) {
            for (int i = 1; i < jArr.length; i++) {
                if (jArr[i] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        k kVar = (k) this.f1793k.clone();
        k kVar2 = ((C0247e) abstractC0246d).f1793k;
        int iJ = kVar2.j();
        if (iJ != 0) {
            long[] jArr = kVar.f1799a;
            if (iJ > jArr.length) {
                long[] jArr2 = new long[iJ];
                System.arraycopy(jArr, 0, jArr2, 0, Math.min(jArr.length, iJ));
                kVar.f1799a = jArr2;
            }
            k.a(0, 0, iJ, kVar.f1799a, kVar2.f1799a);
        }
        return new C0247e(this.i, this.f1792j, kVar);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        for (long j6 : this.f1793k.f1799a) {
            if (j6 != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0247e)) {
            return false;
        }
        C0247e c0247e = (C0247e) obj;
        return this.i == c0247e.i && this.f1791h == c0247e.f1791h && Arrays.equals(this.f1792j, c0247e.f1792j) && this.f1793k.equals(c0247e.f1793k);
    }

    @Override // c4.AbstractC0246d
    public final int g() {
        return this.f1793k.e();
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        long[] jArr;
        int i;
        long[] jArr2;
        long[] jArr3;
        k kVar = ((C0247e) abstractC0246d).f1793k;
        k kVar2 = this.f1793k;
        int iE = kVar2.e();
        int i3 = this.i;
        int[] iArr = this.f1792j;
        if (iE != 0) {
            int iE2 = kVar.e();
            if (iE2 != 0) {
                if (iE > iE2) {
                    kVar2 = kVar;
                    kVar = kVar2;
                    iE2 = iE;
                    iE = iE2;
                }
                int i4 = (iE + 63) >>> 6;
                int i5 = (iE2 + 63) >>> 6;
                int i6 = ((iE + iE2) + 62) >>> 6;
                if (i4 == 1) {
                    long j6 = kVar2.f1799a[0];
                    if (j6 != 1) {
                        long[] jArr4 = new long[i6];
                        long[] jArr5 = kVar.f1799a;
                        if ((j6 & 1) != 0) {
                            k.a(0, 0, i5, jArr4, jArr5);
                        }
                        int i7 = 1;
                        while (true) {
                            j6 >>>= 1;
                            if (j6 == 0) {
                                break;
                            }
                            if ((j6 & 1) != 0) {
                                jArr3 = jArr4;
                                long jC = k.c(jArr3, 0, jArr5, 0, i5, i7);
                                if (jC != 0) {
                                    jArr3[i5] = jArr3[i5] ^ jC;
                                }
                            } else {
                                jArr3 = jArr4;
                            }
                            i7++;
                            jArr4 = jArr3;
                        }
                        long[] jArr6 = jArr4;
                        kVar2 = new k(jArr6, k.l(jArr6, i6, i3, iArr));
                    }
                } else {
                    int i8 = (iE2 + 70) >>> 6;
                    int[] iArr2 = new int[16];
                    int i9 = i8 << 4;
                    long[] jArr7 = new long[i9];
                    iArr2[1] = i8;
                    System.arraycopy(kVar.f1799a, 0, jArr7, i8, i5);
                    int i10 = 2;
                    int i11 = i8;
                    while (i10 < 16) {
                        int i12 = i11 + i8;
                        iArr2[i10] = i12;
                        if ((i10 & 1) == 0) {
                            jArr2 = jArr7;
                            k.m(jArr2, i12 >>> 1, jArr7, i12, i8, 1);
                        } else {
                            jArr2 = jArr7;
                            int i13 = i12 - i8;
                            for (int i14 = 0; i14 < i8; i14++) {
                                jArr2[i12 + i14] = jArr2[i8 + i14] ^ jArr2[i13 + i14];
                            }
                        }
                        i10++;
                        jArr7 = jArr2;
                        i11 = i12;
                    }
                    long[] jArr8 = jArr7;
                    long[] jArr9 = new long[i9];
                    k.m(jArr8, 0, jArr9, 0, i9, 4);
                    long[] jArr10 = kVar2.f1799a;
                    int i15 = i6 << 3;
                    long[] jArr11 = new long[i15];
                    int i16 = 0;
                    while (i16 < i4) {
                        long j7 = jArr10[i16];
                        int i17 = i16;
                        while (true) {
                            jArr = jArr10;
                            i = i15;
                            int i18 = iArr2[((int) j7) & 15];
                            int i19 = iArr2[((int) (j7 >>> 4)) & 15];
                            for (int i20 = 0; i20 < i8; i20++) {
                                int i21 = i17 + i20;
                                jArr11[i21] = jArr11[i21] ^ (jArr8[i18 + i20] ^ jArr9[i19 + i20]);
                            }
                            j7 >>>= 8;
                            if (j7 == 0) {
                                break;
                            }
                            i17 += i6;
                            jArr10 = jArr;
                            i15 = i;
                        }
                        i16++;
                        jArr10 = jArr;
                        i15 = i;
                    }
                    while (true) {
                        int i22 = i15 - i6;
                        if (i22 == 0) {
                            break;
                        }
                        k.c(jArr11, i22 - i6, jArr11, i22, i6, 8);
                        i15 = i22;
                    }
                    kVar2 = new k(jArr11, k.l(jArr11, i6, i3, iArr));
                }
                kVar = kVar2;
            }
        } else {
            kVar = kVar2;
        }
        return new C0247e(i3, iArr, kVar);
    }

    public final int hashCode() {
        return (this.f1793k.hashCode() ^ this.i) ^ g5.c.l(this.f1792j);
    }
}
