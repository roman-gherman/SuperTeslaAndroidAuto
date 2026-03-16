package N3;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.SavableDigest;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements SavableDigest, ExtendedDigest, Memoable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f1160o = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L3.c f1161a;
    public final byte[] b;
    public int c;
    public long d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1164h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f1168m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1169n;

    public c() {
        L3.c cVar = L3.c.d;
        L3.c cVar2 = L3.c.d;
        this.b = new byte[4];
        this.f1161a = cVar2;
        this.c = 0;
        this.f1168m = new int[64];
        L3.h.a(C5.f.D(this, 256, cVar));
        reset();
    }

    public static int a(int i, int i3, int i4) {
        return ((~i) & i4) ^ (i3 & i);
    }

    public static int b(int i, int i3, int i4) {
        return ((i ^ i3) & i4) | (i & i3);
    }

    public static int c(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    public static int d(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    @Override // org.bouncycastle.util.Memoable
    public final Memoable copy() {
        c cVar = new c(this);
        cVar.f1168m = new int[64];
        cVar.e(this);
        return cVar;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final int doFinal(byte[] bArr, int i) {
        long j6 = this.d << 3;
        byte b = -128;
        while (true) {
            update(b);
            if (this.c == 0) {
                break;
            }
            b = 0;
        }
        if (this.f1169n > 14) {
            f();
        }
        int[] iArr = this.f1168m;
        iArr[14] = (int) (j6 >>> 32);
        iArr[15] = (int) j6;
        f();
        g5.c.o(bArr, this.e, i);
        g5.c.o(bArr, this.f1162f, i + 4);
        g5.c.o(bArr, this.f1163g, i + 8);
        g5.c.o(bArr, this.f1164h, i + 12);
        g5.c.o(bArr, this.i, i + 16);
        g5.c.o(bArr, this.f1165j, i + 20);
        g5.c.o(bArr, this.f1166k, i + 24);
        g5.c.o(bArr, this.f1167l, i + 28);
        reset();
        return 32;
    }

    public final void e(c cVar) {
        byte[] bArr = cVar.b;
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f1162f = cVar.f1162f;
        this.f1163g = cVar.f1163g;
        this.f1164h = cVar.f1164h;
        this.i = cVar.i;
        this.f1165j = cVar.f1165j;
        this.f1166k = cVar.f1166k;
        this.f1167l = cVar.f1167l;
        int[] iArr = this.f1168m;
        int[] iArr2 = cVar.f1168m;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.f1169n = cVar.f1169n;
    }

    public final void f() {
        int[] iArr;
        int i = 16;
        while (true) {
            iArr = this.f1168m;
            if (i > 63) {
                break;
            }
            int i3 = iArr[i - 2];
            int i4 = ((i3 >>> 10) ^ (((i3 >>> 17) | (i3 << 15)) ^ ((i3 >>> 19) | (i3 << 13)))) + iArr[i - 7];
            int i5 = iArr[i - 15];
            iArr[i] = i4 + ((i5 >>> 3) ^ (((i5 >>> 7) | (i5 << 25)) ^ ((i5 >>> 18) | (i5 << 14)))) + iArr[i - 16];
            i++;
        }
        int iB = this.e;
        int iB2 = this.f1162f;
        int iB3 = this.f1163g;
        int iB4 = this.f1164h;
        int i6 = this.i;
        int i7 = this.f1165j;
        int i8 = this.f1166k;
        int i9 = this.f1167l;
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int iA = a(i6, i7, i8) + d(i6);
            int[] iArr2 = f1160o;
            int i12 = iA + iArr2[i10] + iArr[i10] + i9;
            int i13 = iB4 + i12;
            int iB5 = b(iB, iB2, iB3) + c(iB) + i12;
            int i14 = i10 + 1;
            int iA2 = a(i13, i6, i7) + d(i13) + iArr2[i14] + iArr[i14] + i8;
            int i15 = iB3 + iA2;
            int iB6 = b(iB5, iB, iB2) + c(iB5) + iA2;
            int i16 = i10 + 2;
            int iA3 = a(i15, i13, i6) + d(i15) + iArr2[i16] + iArr[i16] + i7;
            int i17 = iB2 + iA3;
            int iB7 = b(iB6, iB5, iB) + c(iB6) + iA3;
            int i18 = i10 + 3;
            int iA4 = a(i17, i15, i13) + d(i17) + iArr2[i18] + iArr[i18] + i6;
            int i19 = iB + iA4;
            int iB8 = b(iB7, iB6, iB5) + c(iB7) + iA4;
            int i20 = i10 + 4;
            int iA5 = a(i19, i17, i15) + d(i19) + iArr2[i20] + iArr[i20] + i13;
            i9 = iB5 + iA5;
            iB4 = b(iB8, iB7, iB6) + c(iB8) + iA5;
            int i21 = i10 + 5;
            int iA6 = a(i9, i19, i17) + d(i9) + iArr2[i21] + iArr[i21] + i15;
            i8 = iB6 + iA6;
            iB3 = b(iB4, iB8, iB7) + c(iB4) + iA6;
            int i22 = i10 + 6;
            int iA7 = a(i8, i9, i19) + d(i8) + iArr2[i22] + iArr[i22] + i17;
            i7 = iB7 + iA7;
            iB2 = b(iB3, iB4, iB8) + c(iB3) + iA7;
            int i23 = i10 + 7;
            int iA8 = a(i7, i8, i9) + d(i7) + iArr2[i23] + iArr[i23] + i19;
            i6 = iB8 + iA8;
            iB = b(iB2, iB3, iB4) + c(iB2) + iA8;
            i10 += 8;
        }
        this.e += iB;
        this.f1162f += iB2;
        this.f1163g += iB3;
        this.f1164h += iB4;
        this.i += i6;
        this.f1165j += i7;
        this.f1166k += i8;
        this.f1167l += i9;
        this.f1169n = 0;
        for (int i24 = 0; i24 < 16; i24++) {
            iArr[i24] = 0;
        }
    }

    public final void g(int i, byte[] bArr) {
        this.f1168m[this.f1169n] = g5.c.b(i, bArr);
        int i3 = this.f1169n + 1;
        this.f1169n = i3;
        if (i3 == 16) {
            f();
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public final String getAlgorithmName() {
        return "SHA-256";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public final int getByteLength() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest
    public final byte[] getEncodedState() {
        int i = this.f1169n * 4;
        byte[] bArr = new byte[i + 53];
        System.arraycopy(this.b, 0, bArr, 0, this.c);
        g5.c.o(bArr, this.c, 4);
        g5.c.t(bArr, 8, this.d);
        g5.c.o(bArr, this.e, 16);
        g5.c.o(bArr, this.f1162f, 20);
        g5.c.o(bArr, this.f1163g, 24);
        g5.c.o(bArr, this.f1164h, 28);
        g5.c.o(bArr, this.i, 32);
        g5.c.o(bArr, this.f1165j, 36);
        g5.c.o(bArr, this.f1166k, 40);
        g5.c.o(bArr, this.f1167l, 44);
        g5.c.o(bArr, this.f1169n, 48);
        for (int i3 = 0; i3 != this.f1169n; i3++) {
            g5.c.o(bArr, this.f1168m[i3], (i3 * 4) + 52);
        }
        bArr[i + 52] = (byte) this.f1161a.ordinal();
        return bArr;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void reset() {
        this.d = 0L;
        this.c = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i >= bArr.length) {
                break;
            }
            bArr[i] = 0;
            i++;
        }
        this.e = 1779033703;
        this.f1162f = -1150833019;
        this.f1163g = 1013904242;
        this.f1164h = -1521486534;
        this.i = 1359893119;
        this.f1165j = -1694144372;
        this.f1166k = 528734635;
        this.f1167l = 1541459225;
        this.f1169n = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.f1168m;
            if (i3 == iArr.length) {
                return;
            }
            iArr[i3] = 0;
            i3++;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void update(byte b) {
        int i = this.c;
        int i3 = i + 1;
        this.c = i3;
        byte[] bArr = this.b;
        bArr[i] = b;
        if (i3 == bArr.length) {
            g(0, bArr);
            this.c = 0;
        }
        this.d++;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void update(byte[] bArr, int i, int i3) {
        int i4 = 0;
        int iMax = Math.max(0, i3);
        int i5 = this.c;
        byte[] bArr2 = this.b;
        if (i5 != 0) {
            int i6 = 0;
            while (true) {
                if (i6 >= iMax) {
                    i4 = i6;
                    break;
                }
                int i7 = this.c;
                int i8 = i7 + 1;
                this.c = i8;
                int i9 = i6 + 1;
                bArr2[i7] = bArr[i6 + i];
                if (i8 == 4) {
                    g(0, bArr2);
                    this.c = 0;
                    i4 = i9;
                    break;
                }
                i6 = i9;
            }
        }
        int i10 = iMax - 3;
        while (i4 < i10) {
            g(i + i4, bArr);
            i4 += 4;
        }
        while (i4 < iMax) {
            int i11 = this.c;
            this.c = i11 + 1;
            bArr2[i11] = bArr[i4 + i];
            i4++;
        }
        this.d += (long) iMax;
    }

    @Override // org.bouncycastle.util.Memoable
    public final void reset(Memoable memoable) {
        e((c) memoable);
    }

    public c(c cVar) {
        byte[] bArr = new byte[4];
        this.b = bArr;
        this.f1161a = cVar.f1161a;
        byte[] bArr2 = cVar.b;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        this.c = cVar.c;
        this.d = cVar.d;
    }
}
