package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class r extends AbstractC0388s {
    public final ByteBuffer c;
    public final long d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f2910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2911h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2912j = Integer.MAX_VALUE;

    public r(ByteBuffer byteBuffer, boolean z6) {
        this.c = byteBuffer;
        long j6 = S0.c.j(byteBuffer, S0.f2847g);
        this.d = j6;
        this.e = ((long) byteBuffer.limit()) + j6;
        long jPosition = j6 + ((long) byteBuffer.position());
        this.f2909f = jPosition;
        this.f2910g = jPosition;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int A() throws V {
        if (e()) {
            this.i = 0;
            return 0;
        }
        int iG = G();
        this.i = iG;
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
            if (((int) (this.e - this.f2909f)) >= 10) {
                while (i4 < 10) {
                    long j6 = this.f2909f;
                    this.f2909f = j6 + 1;
                    if (S0.c.e(j6) < 0) {
                        i4++;
                    }
                }
                throw V.d();
            }
            while (i4 < 10) {
                long j7 = this.f2909f;
                if (j7 == this.e) {
                    throw V.g();
                }
                this.f2909f = j7 + 1;
                if (S0.c.e(j7) < 0) {
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
        long j6 = this.f2909f;
        if (this.e - j6 < 4) {
            throw V.g();
        }
        this.f2909f = 4 + j6;
        R0 r02 = S0.c;
        return ((r02.e(j6 + 3) & 255) << 24) | (r02.e(j6) & 255) | ((r02.e(1 + j6) & 255) << 8) | ((r02.e(2 + j6) & 255) << 16);
    }

    public final long F() throws V {
        long j6 = this.f2909f;
        if (this.e - j6 < 8) {
            throw V.g();
        }
        this.f2909f = 8 + j6;
        R0 r02 = S0.c;
        return ((((long) r02.e(j6 + 7)) & 255) << 56) | (((long) r02.e(j6)) & 255) | ((((long) r02.e(1 + j6)) & 255) << 8) | ((((long) r02.e(2 + j6)) & 255) << 16) | ((((long) r02.e(3 + j6)) & 255) << 24) | ((((long) r02.e(4 + j6)) & 255) << 32) | ((((long) r02.e(5 + j6)) & 255) << 40) | ((((long) r02.e(6 + j6)) & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
    
        if (r4.e(r8) < 0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099 A[PHI: r6
      0x0099: PHI (r6v7 long) = (r6v6 long), (r6v8 long), (r6v10 long) binds: [B:25:0x006d, B:29:0x0080, B:33:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int G() {
        /*
            r12 = this;
            long r0 = r12.f2909f
            long r2 = r12.e
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto La
            goto L93
        La:
            r2 = 1
            long r2 = r2 + r0
            com.google.crypto.tink.shaded.protobuf.R0 r4 = com.google.crypto.tink.shaded.protobuf.S0.c
            byte r5 = r4.e(r0)
            if (r5 < 0) goto L18
            r12.f2909f = r2
            return r5
        L18:
            long r6 = r12.e
            long r6 = r6 - r2
            r8 = 9
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L23
            goto L93
        L23:
            r6 = 2
            long r6 = r6 + r0
            byte r2 = r4.e(r2)
            int r2 = r2 << 7
            r2 = r2 ^ r5
            if (r2 >= 0) goto L33
            r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
            goto La0
        L33:
            r10 = 3
            long r10 = r10 + r0
            byte r3 = r4.e(r6)
            int r3 = r3 << 14
            r2 = r2 ^ r3
            if (r2 < 0) goto L43
            r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
        L41:
            r6 = r10
            goto La0
        L43:
            r5 = 4
            long r6 = r0 + r5
            byte r3 = r4.e(r10)
            int r3 = r3 << 21
            r2 = r2 ^ r3
            if (r2 >= 0) goto L55
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto La0
        L55:
            r10 = 5
            long r10 = r10 + r0
            byte r3 = r4.e(r6)
            int r5 = r3 << 28
            r2 = r2 ^ r5
            r5 = 266354560(0xfe03f80, float:2.2112565E-29)
            r2 = r2 ^ r5
            if (r3 >= 0) goto L9e
            r5 = 6
            long r6 = r0 + r5
            byte r3 = r4.e(r10)
            if (r3 >= 0) goto L99
            r10 = 7
            long r10 = r10 + r0
            byte r3 = r4.e(r6)
            if (r3 >= 0) goto L9e
            r5 = 8
            long r6 = r0 + r5
            byte r3 = r4.e(r10)
            if (r3 >= 0) goto L99
            long r8 = r8 + r0
            byte r3 = r4.e(r6)
            if (r3 >= 0) goto L9b
            r5 = 10
            long r6 = r0 + r5
            byte r0 = r4.e(r8)
            if (r0 >= 0) goto L99
        L93:
            long r0 = r12.I()
            int r0 = (int) r0
            return r0
        L99:
            r0 = r2
            goto La0
        L9b:
            r0 = r2
            r6 = r8
            goto La0
        L9e:
            r0 = r2
            goto L41
        La0:
            r12.f2909f = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.r.G():int");
    }

    public final long H() {
        long j6;
        long j7;
        long j8;
        int i;
        long j9 = this.f2909f;
        if (this.e != j9) {
            long j10 = 1 + j9;
            R0 r02 = S0.c;
            byte bE = r02.e(j9);
            if (bE >= 0) {
                this.f2909f = j10;
                return bE;
            }
            if (this.e - j10 >= 9) {
                long j11 = 2 + j9;
                int iE = (r02.e(j10) << 7) ^ bE;
                if (iE >= 0) {
                    long j12 = 3 + j9;
                    int iE2 = iE ^ (r02.e(j11) << 14);
                    if (iE2 >= 0) {
                        j6 = iE2 ^ 16256;
                    } else {
                        j11 = j9 + 4;
                        int iE3 = iE2 ^ (r02.e(j12) << 21);
                        if (iE3 < 0) {
                            i = (-2080896) ^ iE3;
                        } else {
                            j12 = 5 + j9;
                            long jE = ((long) iE3) ^ (((long) r02.e(j11)) << 28);
                            if (jE < 0) {
                                long j13 = 6 + j9;
                                long jE2 = jE ^ (((long) r02.e(j12)) << 35);
                                if (jE2 < 0) {
                                    j7 = -34093383808L;
                                } else {
                                    j12 = 7 + j9;
                                    jE = jE2 ^ (((long) r02.e(j13)) << 42);
                                    if (jE >= 0) {
                                        j8 = 4363953127296L;
                                    } else {
                                        j13 = 8 + j9;
                                        jE2 = jE ^ (((long) r02.e(j12)) << 49);
                                        if (jE2 >= 0) {
                                            long j14 = j9 + 9;
                                            long jE3 = (jE2 ^ (((long) r02.e(j13)) << 56)) ^ 71499008037633920L;
                                            if (jE3 < 0) {
                                                long j15 = j9 + 10;
                                                if (r02.e(j14) >= 0) {
                                                    j11 = j15;
                                                    j6 = jE3;
                                                }
                                            } else {
                                                j6 = jE3;
                                                j11 = j14;
                                            }
                                            this.f2909f = j11;
                                            return j6;
                                        }
                                        j7 = -558586000294016L;
                                    }
                                }
                                j6 = j7 ^ jE2;
                                j11 = j13;
                                this.f2909f = j11;
                                return j6;
                            }
                            j8 = 266354560;
                            j6 = j8 ^ jE;
                        }
                    }
                    j11 = j12;
                    this.f2909f = j11;
                    return j6;
                }
                i = iE ^ (-128);
                j6 = i;
                this.f2909f = j11;
                return j6;
            }
        }
        return I();
    }

    public final long I() throws V {
        long j6 = 0;
        for (int i = 0; i < 64; i += 7) {
            long j7 = this.f2909f;
            if (j7 == this.e) {
                throw V.g();
            }
            this.f2909f = 1 + j7;
            byte bE = S0.c.e(j7);
            j6 |= ((long) (bE & 127)) << i;
            if ((bE & 128) == 0) {
                return j6;
            }
        }
        throw V.d();
    }

    public final void J() {
        long j6 = this.e + ((long) this.f2911h);
        this.e = j6;
        int i = (int) (j6 - this.f2910g);
        int i3 = this.f2912j;
        if (i <= i3) {
            this.f2911h = 0;
            return;
        }
        int i4 = i - i3;
        this.f2911h = i4;
        this.e = j6 - ((long) i4);
    }

    public final void K(int i) throws V {
        if (i >= 0) {
            long j6 = this.e;
            long j7 = this.f2909f;
            if (i <= ((int) (j6 - j7))) {
                this.f2909f = j7 + ((long) i);
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
        if (this.i != i) {
            throw new V("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int d() {
        return (int) (this.f2909f - this.f2910g);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final boolean e() {
        return this.f2909f == this.e;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final void i(int i) {
        this.f2912j = i;
        J();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final int j(int i) throws V {
        if (i < 0) {
            throw V.e();
        }
        int iD = d() + i;
        int i3 = this.f2912j;
        if (iD > i3) {
            throw V.g();
        }
        this.f2912j = iD;
        J();
        return i3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final boolean k() {
        return H() != 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0388s
    public final C0379n l() throws V {
        int iG = G();
        if (iG > 0) {
            long j6 = this.e;
            long j7 = this.f2909f;
            if (iG <= ((int) (j6 - j7))) {
                byte[] bArr = new byte[iG];
                long j8 = iG;
                S0.c.c(j7, bArr, j8);
                this.f2909f += j8;
                C0379n c0379n = AbstractC0381o.b;
                return new C0379n(bArr);
            }
        }
        if (iG == 0) {
            return AbstractC0381o.b;
        }
        if (iG < 0) {
            throw V.e();
        }
        throw V.g();
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
            long j6 = this.e;
            long j7 = this.f2909f;
            if (iG <= ((int) (j6 - j7))) {
                byte[] bArr = new byte[iG];
                long j8 = iG;
                S0.c.c(j7, bArr, j8);
                String str = new String(bArr, T.f2849a);
                this.f2909f += j8;
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
            long j6 = this.e;
            long j7 = this.f2909f;
            if (iG <= ((int) (j6 - j7))) {
                int i = (int) (j7 - this.d);
                AbstractC0369i abstractC0369i = V0.f2851a;
                abstractC0369i.getClass();
                ByteBuffer byteBuffer = this.c;
                String strK = byteBuffer.hasArray() ? abstractC0369i.k(byteBuffer.array(), byteBuffer.arrayOffset() + i, iG) : byteBuffer.isDirect() ? abstractC0369i.m(byteBuffer, i, iG) : AbstractC0369i.l(byteBuffer, i, iG);
                this.f2909f += (long) iG;
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
