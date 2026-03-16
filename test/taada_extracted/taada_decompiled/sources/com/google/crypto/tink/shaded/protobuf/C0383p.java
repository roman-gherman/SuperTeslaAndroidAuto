package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0383p extends AbstractC0388s {
    public final byte[] c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2903h;
    public int i = Integer.MAX_VALUE;

    public C0383p(byte[] bArr, int i, int i3, boolean z6) {
        this.c = bArr;
        this.d = i3 + i;
        this.f2901f = i;
        this.f2902g = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int A() throws V {
        if (e()) {
            this.f2903h = 0;
            return 0;
        }
        int iG = G();
        this.f2903h = iG;
        if ((iG >>> 3) != 0) {
            return iG;
        }
        throw V.a();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int B() {
        return G();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final long C() {
        return H();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final boolean D(int i) throws V {
        int iA;
        int i3 = i & 7;
        int i4 = 0;
        if (i3 == 0) {
            int i5 = this.d - this.f2901f;
            byte[] bArr = this.c;
            if (i5 >= 10) {
                while (i4 < 10) {
                    int i6 = this.f2901f;
                    this.f2901f = i6 + 1;
                    if (bArr[i6] < 0) {
                        i4++;
                    }
                }
                throw V.d();
            }
            while (i4 < 10) {
                int i7 = this.f2901f;
                if (i7 == this.d) {
                    throw V.g();
                }
                this.f2901f = i7 + 1;
                if (bArr[i7] < 0) {
                    i4++;
                }
            }
            throw V.d();
            return true;
        }
        if (i3 == 1) {
            K(8);
            return true;
        }
        if (i3 == 2) {
            K(G());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw V.c();
            }
            K(4);
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

    public final int E() throws V {
        int i = this.f2901f;
        if (this.d - i < 4) {
            throw V.g();
        }
        this.f2901f = i + 4;
        byte[] bArr = this.c;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long F() throws V {
        int i = this.f2901f;
        if (this.d - i < 8) {
            throw V.g();
        }
        this.f2901f = i + 8;
        byte[] bArr = this.c;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int G() {
        int i;
        int i3 = this.f2901f;
        int i4 = this.d;
        if (i4 != i3) {
            int i5 = i3 + 1;
            byte[] bArr = this.c;
            byte b = bArr[i3];
            if (b >= 0) {
                this.f2901f = i5;
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
                this.f2901f = i6;
                return i;
            }
        }
        return (int) I();
    }

    public final long H() {
        long j6;
        long j7;
        long j8;
        long j9;
        int i = this.f2901f;
        int i3 = this.d;
        if (i3 != i) {
            int i4 = i + 1;
            byte[] bArr = this.c;
            byte b = bArr[i];
            if (b >= 0) {
                this.f2901f = i4;
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
                this.f2901f = i5;
                return j6;
            }
        }
        return I();
    }

    public final long I() throws V {
        long j6 = 0;
        for (int i = 0; i < 64; i += 7) {
            int i3 = this.f2901f;
            if (i3 == this.d) {
                throw V.g();
            }
            this.f2901f = i3 + 1;
            byte b = this.c[i3];
            j6 |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j6;
            }
        }
        throw V.d();
    }

    public final void J() {
        int i = this.d + this.e;
        this.d = i;
        int i3 = i - this.f2902g;
        int i4 = this.i;
        if (i3 <= i4) {
            this.e = 0;
            return;
        }
        int i5 = i3 - i4;
        this.e = i5;
        this.d = i - i5;
    }

    public final void K(int i) throws V {
        if (i >= 0) {
            int i3 = this.d;
            int i4 = this.f2901f;
            if (i <= i3 - i4) {
                this.f2901f = i4 + i;
                return;
            }
        }
        if (i >= 0) {
            throw V.g();
        }
        throw V.e();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final void a(int i) throws V {
        if (this.f2903h != i) {
            throw new V("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int d() {
        return this.f2901f - this.f2902g;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final boolean e() {
        return this.f2901f == this.d;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final void i(int i) {
        this.i = i;
        J();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int j(int i) throws V {
        if (i < 0) {
            throw V.e();
        }
        int iD = d() + i;
        if (iD < 0) {
            throw V.f();
        }
        int i3 = this.i;
        if (iD > i3) {
            throw V.g();
        }
        this.i = iD;
        J();
        return i3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final boolean k() {
        return H() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.crypto.tink.shaded.protobuf.C0379n l() throws com.google.crypto.tink.shaded.protobuf.V {
        /*
            r4 = this;
            int r0 = r4.G()
            byte[] r1 = r4.c
            if (r0 <= 0) goto L19
            int r2 = r4.d
            int r3 = r4.f2901f
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            com.google.crypto.tink.shaded.protobuf.n r1 = com.google.crypto.tink.shaded.protobuf.AbstractC0381o.c(r1, r3, r0)
            int r2 = r4.f2901f
            int r2 = r2 + r0
            r4.f2901f = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.crypto.tink.shaded.protobuf.n r0 = com.google.crypto.tink.shaded.protobuf.AbstractC0381o.b
            return r0
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.d
            int r3 = r4.f2901f
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.f2901f = r0
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L42
            if (r0 != 0) goto L3d
            byte[] r0 = com.google.crypto.tink.shaded.protobuf.T.b
        L35:
            com.google.crypto.tink.shaded.protobuf.n r1 = com.google.crypto.tink.shaded.protobuf.AbstractC0381o.b
            com.google.crypto.tink.shaded.protobuf.n r1 = new com.google.crypto.tink.shaded.protobuf.n
            r1.<init>(r0)
            return r1
        L3d:
            com.google.crypto.tink.shaded.protobuf.V r0 = com.google.crypto.tink.shaded.protobuf.V.e()
            throw r0
        L42:
            com.google.crypto.tink.shaded.protobuf.V r0 = com.google.crypto.tink.shaded.protobuf.V.g()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C0383p.l():com.google.crypto.tink.shaded.protobuf.n");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final double m() {
        return Double.longBitsToDouble(F());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int n() {
        return G();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int o() {
        return E();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final long p() {
        return F();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final float q() {
        return Float.intBitsToFloat(E());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int r() {
        return G();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final long s() {
        return H();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int u() {
        return E();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final long v() {
        return F();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int w() {
        return AbstractC0388s.b(G());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final long x() {
        return AbstractC0388s.c(H());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final String y() throws V {
        int iG = G();
        if (iG > 0) {
            int i = this.d;
            int i3 = this.f2901f;
            if (iG <= i - i3) {
                String str = new String(this.c, i3, iG, T.f2849a);
                this.f2901f += iG;
                return str;
            }
        }
        if (iG == 0) {
            return "";
        }
        if (iG < 0) {
            throw V.e();
        }
        throw V.g();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final String z() throws V {
        int iG = G();
        if (iG > 0) {
            int i = this.d;
            int i3 = this.f2901f;
            if (iG <= i - i3) {
                String strK = V0.f2851a.k(this.c, i3, iG);
                this.f2901f += iG;
                return strK;
            }
        }
        if (iG == 0) {
            return "";
        }
        if (iG <= 0) {
            throw V.e();
        }
        throw V.g();
    }
}
