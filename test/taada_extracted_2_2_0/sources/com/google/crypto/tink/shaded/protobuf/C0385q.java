package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0385q extends AbstractC0388s {
    public final InputStream c;
    public final byte[] d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2906h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2907j = Integer.MAX_VALUE;

    public C0385q(InputStream inputStream) {
        T.a(inputStream, "input");
        this.c = inputStream;
        this.d = new byte[4096];
        this.e = 0;
        this.f2905g = 0;
        this.i = 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int A() throws V {
        if (e()) {
            this.f2906h = 0;
            return 0;
        }
        int iJ = J();
        this.f2906h = iJ;
        if ((iJ >>> 3) != 0) {
            return iJ;
        }
        throw V.a();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int B() {
        return J();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final long C() {
        return K();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final boolean D(int i) throws V {
        int iA;
        int i3 = i & 7;
        int i4 = 0;
        if (i3 == 0) {
            int i5 = this.e - this.f2905g;
            byte[] bArr = this.d;
            if (i5 >= 10) {
                while (i4 < 10) {
                    int i6 = this.f2905g;
                    this.f2905g = i6 + 1;
                    if (bArr[i6] < 0) {
                        i4++;
                    }
                }
                throw V.d();
            }
            while (i4 < 10) {
                if (this.f2905g == this.e) {
                    N(1);
                }
                int i7 = this.f2905g;
                this.f2905g = i7 + 1;
                if (bArr[i7] < 0) {
                    i4++;
                }
            }
            throw V.d();
            return true;
        }
        if (i3 == 1) {
            O(8);
            return true;
        }
        if (i3 == 2) {
            O(J());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw V.c();
            }
            O(4);
            return true;
        }
        do {
            iA = A();
            if (iA == 0) {
                break;
            }
        } while (D(iA));
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    public final byte[] E(int i) throws IOException {
        byte[] bArrF = F(i);
        if (bArrF != null) {
            return bArrF;
        }
        int i3 = this.f2905g;
        int i4 = this.e;
        int length = i4 - i3;
        this.i += i4;
        this.f2905g = 0;
        this.e = 0;
        ArrayList<byte[]> arrayListG = G(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.d, i3, bArr, 0, length);
        for (byte[] bArr2 : arrayListG) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] F(int i) throws IOException {
        if (i == 0) {
            return T.b;
        }
        if (i < 0) {
            throw V.e();
        }
        int i3 = this.i;
        int i4 = this.f2905g;
        int i5 = i3 + i4 + i;
        if (i5 - Integer.MAX_VALUE > 0) {
            throw new V("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i6 = this.f2907j;
        if (i5 > i6) {
            O((i6 - i3) - i4);
            throw V.g();
        }
        int i7 = this.e - i4;
        int i8 = i - i7;
        InputStream inputStream = this.c;
        if (i8 >= 4096) {
            try {
                if (i8 > inputStream.available()) {
                    return null;
                }
            } catch (V e) {
                e.f2850a = true;
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.d, this.f2905g, bArr, 0, i7);
        this.i += this.e;
        this.f2905g = 0;
        this.e = 0;
        while (i7 < i) {
            try {
                int i9 = inputStream.read(bArr, i7, i - i7);
                if (i9 == -1) {
                    throw V.g();
                }
                this.i += i9;
                i7 += i9;
            } catch (V e6) {
                e6.f2850a = true;
                throw e6;
            }
        }
        return bArr;
    }

    public final ArrayList G(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i3 = 0;
            while (i3 < iMin) {
                int i4 = this.c.read(bArr, i3, iMin - i3);
                if (i4 == -1) {
                    throw V.g();
                }
                this.i += i4;
                i3 += i4;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int H() throws V {
        int i = this.f2905g;
        if (this.e - i < 4) {
            N(4);
            i = this.f2905g;
        }
        this.f2905g = i + 4;
        byte[] bArr = this.d;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long I() throws V {
        int i = this.f2905g;
        if (this.e - i < 8) {
            N(8);
            i = this.f2905g;
        }
        this.f2905g = i + 8;
        byte[] bArr = this.d;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int J() {
        int i;
        int i3 = this.f2905g;
        int i4 = this.e;
        if (i4 != i3) {
            int i5 = i3 + 1;
            byte[] bArr = this.d;
            byte b = bArr[i3];
            if (b >= 0) {
                this.f2905g = i5;
                return b;
            }
            if (i4 - i5 >= 9) {
                int i6 = i3 + 2;
                int i7 = (bArr[i5] << 7) ^ b;
                if (i7 < 0) {
                    i = i7 ^ (-128);
                } else {
                    int i8 = i3 + 3;
                    int i9 = (bArr[i6] << 14) ^ i7;
                    if (i9 >= 0) {
                        i = i9 ^ 16256;
                    } else {
                        int i10 = i3 + 4;
                        int i11 = i9 ^ (bArr[i8] << 21);
                        if (i11 < 0) {
                            i = (-2080896) ^ i11;
                        } else {
                            i8 = i3 + 5;
                            byte b2 = bArr[i10];
                            int i12 = (i11 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i10 = i3 + 6;
                                if (bArr[i8] < 0) {
                                    i8 = i3 + 7;
                                    if (bArr[i10] < 0) {
                                        i10 = i3 + 8;
                                        if (bArr[i8] < 0) {
                                            i8 = i3 + 9;
                                            if (bArr[i10] < 0) {
                                                int i13 = i3 + 10;
                                                if (bArr[i8] >= 0) {
                                                    i6 = i13;
                                                    i = i12;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i12;
                            }
                            i = i12;
                        }
                        i6 = i10;
                    }
                    i6 = i8;
                }
                this.f2905g = i6;
                return i;
            }
        }
        return (int) L();
    }

    public final long K() {
        long j6;
        long j7;
        long j8;
        long j9;
        int i = this.f2905g;
        int i3 = this.e;
        if (i3 != i) {
            int i4 = i + 1;
            byte[] bArr = this.d;
            byte b = bArr[i];
            if (b >= 0) {
                this.f2905g = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    j6 = i6 ^ (-128);
                } else {
                    int i7 = i + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        j6 = i8 ^ 16256;
                        i5 = i7;
                    } else {
                        int i9 = i + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            j9 = (-2080896) ^ i10;
                        } else {
                            long j10 = i10;
                            i5 = i + 5;
                            long j11 = j10 ^ (((long) bArr[i9]) << 28);
                            if (j11 >= 0) {
                                j8 = 266354560;
                            } else {
                                i9 = i + 6;
                                long j12 = j11 ^ (((long) bArr[i5]) << 35);
                                if (j12 < 0) {
                                    j7 = -34093383808L;
                                } else {
                                    i5 = i + 7;
                                    j11 = j12 ^ (((long) bArr[i9]) << 42);
                                    if (j11 >= 0) {
                                        j8 = 4363953127296L;
                                    } else {
                                        i9 = i + 8;
                                        j12 = j11 ^ (((long) bArr[i5]) << 49);
                                        if (j12 < 0) {
                                            j7 = -558586000294016L;
                                        } else {
                                            i5 = i + 9;
                                            long j13 = (j12 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                            if (j13 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i5] >= 0) {
                                                    i5 = i11;
                                                }
                                            }
                                            j6 = j13;
                                        }
                                    }
                                }
                                j9 = j7 ^ j12;
                            }
                            j6 = j8 ^ j11;
                        }
                        i5 = i9;
                        j6 = j9;
                    }
                }
                this.f2905g = i5;
                return j6;
            }
        }
        return L();
    }

    public final long L() throws V {
        long j6 = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.f2905g == this.e) {
                N(1);
            }
            int i3 = this.f2905g;
            this.f2905g = i3 + 1;
            byte b = this.d[i3];
            j6 |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j6;
            }
        }
        throw V.d();
    }

    public final void M() {
        int i = this.e + this.f2904f;
        this.e = i;
        int i3 = this.i + i;
        int i4 = this.f2907j;
        if (i3 <= i4) {
            this.f2904f = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f2904f = i5;
        this.e = i - i5;
    }

    public final void N(int i) throws V {
        if (P(i)) {
            return;
        }
        if (i <= (Integer.MAX_VALUE - this.i) - this.f2905g) {
            throw V.g();
        }
        throw new V("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void O(int i) throws V {
        int i3 = this.e;
        int i4 = this.f2905g;
        if (i <= i3 - i4 && i >= 0) {
            this.f2905g = i4 + i;
            return;
        }
        InputStream inputStream = this.c;
        if (i < 0) {
            throw V.e();
        }
        int i5 = this.i;
        int i6 = i5 + i4;
        int i7 = i6 + i;
        int i8 = this.f2907j;
        if (i7 > i8) {
            O((i8 - i5) - i4);
            throw V.g();
        }
        this.i = i6;
        int i9 = i3 - i4;
        this.e = 0;
        this.f2905g = 0;
        while (i9 < i) {
            long j6 = i - i9;
            try {
                try {
                    long jSkip = inputStream.skip(j6);
                    if (jSkip < 0 || jSkip > j6) {
                        throw new IllegalStateException(inputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i9 += (int) jSkip;
                    }
                } catch (V e) {
                    e.f2850a = true;
                    throw e;
                }
            } catch (Throwable th) {
                this.i += i9;
                M();
                throw th;
            }
        }
        this.i += i9;
        M();
        if (i9 >= i) {
            return;
        }
        int i10 = this.e;
        int i11 = i10 - this.f2905g;
        this.f2905g = i10;
        N(1);
        while (true) {
            int i12 = i - i11;
            int i13 = this.e;
            if (i12 <= i13) {
                this.f2905g = i12;
                return;
            } else {
                i11 += i13;
                this.f2905g = i13;
                N(1);
            }
        }
    }

    public final boolean P(int i) throws IOException {
        int i3 = this.f2905g;
        int i4 = i3 + i;
        int i5 = this.e;
        if (i4 <= i5) {
            throw new IllegalStateException(B2.b.d(i, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i6 = this.i;
        if (i <= (Integer.MAX_VALUE - i6) - i3 && i6 + i3 + i <= this.f2907j) {
            byte[] bArr = this.d;
            if (i3 > 0) {
                if (i5 > i3) {
                    System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                }
                this.i += i3;
                this.e -= i3;
                this.f2905g = 0;
            }
            int i7 = this.e;
            int iMin = Math.min(bArr.length - i7, (Integer.MAX_VALUE - this.i) - i7);
            InputStream inputStream = this.c;
            try {
                int i8 = inputStream.read(bArr, i7, iMin);
                if (i8 == 0 || i8 < -1 || i8 > bArr.length) {
                    throw new IllegalStateException(inputStream.getClass() + "#read(byte[]) returned invalid result: " + i8 + "\nThe InputStream implementation is buggy.");
                }
                if (i8 > 0) {
                    this.e += i8;
                    M();
                    if (this.e >= i) {
                        return true;
                    }
                    return P(i);
                }
            } catch (V e) {
                e.f2850a = true;
                throw e;
            }
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final void a(int i) throws V {
        if (this.f2906h != i) {
            throw new V("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int d() {
        return this.i + this.f2905g;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final boolean e() {
        return this.f2905g == this.e && !P(1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final void i(int i) {
        this.f2907j = i;
        M();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int j(int i) throws V {
        if (i < 0) {
            throw V.e();
        }
        int i3 = this.i + this.f2905g + i;
        int i4 = this.f2907j;
        if (i3 > i4) {
            throw V.g();
        }
        this.f2907j = i3;
        M();
        return i4;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final boolean k() {
        return K() != 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final C0379n l() throws IOException {
        int iJ = J();
        int i = this.e;
        int i3 = this.f2905g;
        int i4 = i - i3;
        byte[] bArr = this.d;
        if (iJ <= i4 && iJ > 0) {
            C0379n c0379nC = AbstractC0381o.c(bArr, i3, iJ);
            this.f2905g += iJ;
            return c0379nC;
        }
        if (iJ == 0) {
            return AbstractC0381o.b;
        }
        byte[] bArrF = F(iJ);
        if (bArrF != null) {
            return AbstractC0381o.c(bArrF, 0, bArrF.length);
        }
        int i5 = this.f2905g;
        int i6 = this.e;
        int length = i6 - i5;
        this.i += i6;
        this.f2905g = 0;
        this.e = 0;
        ArrayList<byte[]> arrayListG = G(iJ - length);
        byte[] bArr2 = new byte[iJ];
        System.arraycopy(bArr, i5, bArr2, 0, length);
        for (byte[] bArr3 : arrayListG) {
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        C0379n c0379n = AbstractC0381o.b;
        return new C0379n(bArr2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final double m() {
        return Double.longBitsToDouble(I());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int n() {
        return J();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int o() {
        return H();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final long p() {
        return I();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final float q() {
        return Float.intBitsToFloat(H());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int r() {
        return J();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final long s() {
        return K();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int u() {
        return H();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final long v() {
        return I();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int w() {
        return AbstractC0388s.b(J());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final long x() {
        return AbstractC0388s.c(K());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final String y() throws V {
        int iJ = J();
        byte[] bArr = this.d;
        if (iJ > 0) {
            int i = this.e;
            int i3 = this.f2905g;
            if (iJ <= i - i3) {
                String str = new String(bArr, i3, iJ, T.f2849a);
                this.f2905g += iJ;
                return str;
            }
        }
        if (iJ == 0) {
            return "";
        }
        if (iJ > this.e) {
            return new String(E(iJ), T.f2849a);
        }
        N(iJ);
        String str2 = new String(bArr, this.f2905g, iJ, T.f2849a);
        this.f2905g += iJ;
        return str2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final String z() throws IOException {
        int iJ = J();
        int i = this.f2905g;
        int i3 = this.e;
        int i4 = i3 - i;
        byte[] bArrE = this.d;
        if (iJ <= i4 && iJ > 0) {
            this.f2905g = i + iJ;
        } else {
            if (iJ == 0) {
                return "";
            }
            i = 0;
            if (iJ <= i3) {
                N(iJ);
                this.f2905g = iJ;
            } else {
                bArrE = E(iJ);
            }
        }
        return V0.f2851a.k(bArrE, i, iJ);
    }
}
