package kotlin.reflect.jvm.internal.impl.protobuf;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0605f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3861a;
    public int b;
    public int c;
    public int d;
    public final InputStream e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3864h;
    public int i;

    public C0605f(InputStream inputStream) {
        this.f3864h = Integer.MAX_VALUE;
        this.f3861a = new byte[4096];
        this.b = 0;
        this.d = 0;
        this.f3863g = 0;
        this.e = inputStream;
    }

    public final void a(int i) {
        if (this.f3862f != i) {
            throw new r("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final int b() {
        int i = this.f3864h;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.f3863g + this.d);
    }

    public final void c(int i) {
        this.f3864h = i;
        o();
    }

    public final int d(int i) {
        if (i < 0) {
            throw new r("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i3 = this.f3863g + this.d + i;
        int i4 = this.f3864h;
        if (i3 > i4) {
            throw r.a();
        }
        this.f3864h = i3;
        o();
        return i4;
    }

    public final u e() {
        int iK = k();
        int i = this.b;
        int i3 = this.d;
        if (iK > i - i3 || iK <= 0) {
            return iK == 0 ? AbstractC0604e.f3860a : new u(h(iK));
        }
        byte[] bArr = new byte[iK];
        System.arraycopy(this.f3861a, i3, bArr, 0, iK);
        u uVar = new u(bArr);
        this.d += iK;
        return uVar;
    }

    public final int f() {
        return k();
    }

    public final MessageLite g(Parser parser, C0608i c0608i) throws r {
        int iK = k();
        if (this.i >= 64) {
            throw new r("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iD = d(iK);
        this.i++;
        MessageLite messageLite = (MessageLite) parser.parsePartialFrom(this, c0608i);
        a(0);
        this.i--;
        c(iD);
        return messageLite;
    }

    public final byte[] h(int i) throws r {
        if (i <= 0) {
            if (i == 0) {
                return q.f3873a;
            }
            throw new r("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i3 = this.f3863g;
        int i4 = this.d;
        int i5 = i3 + i4 + i;
        int i6 = this.f3864h;
        if (i5 > i6) {
            r((i6 - i3) - i4);
            throw r.a();
        }
        byte[] bArr = this.f3861a;
        if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i7 = this.b - i4;
            System.arraycopy(bArr, i4, bArr2, 0, i7);
            this.d = this.b;
            int i8 = i - i7;
            if (i8 > 0) {
                p(i8);
            }
            System.arraycopy(bArr, 0, bArr2, i7, i8);
            this.d = i8;
            return bArr2;
        }
        int i9 = this.b;
        this.f3863g = i3 + i9;
        this.d = 0;
        this.b = 0;
        int length = i9 - i4;
        int i10 = i - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i10 > 0) {
            int iMin = Math.min(i10, 4096);
            byte[] bArr3 = new byte[iMin];
            int i11 = 0;
            while (i11 < iMin) {
                InputStream inputStream = this.e;
                int i12 = inputStream == null ? -1 : inputStream.read(bArr3, i11, iMin - i11);
                if (i12 == -1) {
                    throw r.a();
                }
                this.f3863g += i12;
                i11 += i12;
            }
            i10 -= iMin;
            arrayList.add(bArr3);
        }
        byte[] bArr4 = new byte[i];
        System.arraycopy(bArr, i4, bArr4, 0, length);
        for (byte[] bArr5 : arrayList) {
            System.arraycopy(bArr5, 0, bArr4, length, bArr5.length);
            length += bArr5.length;
        }
        return bArr4;
    }

    public final int i() throws r {
        int i = this.d;
        if (this.b - i < 4) {
            p(4);
            i = this.d;
        }
        this.d = i + 4;
        byte[] bArr = this.f3861a;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long j() throws r {
        int i = this.d;
        if (this.b - i < 8) {
            p(8);
            i = this.d;
        }
        this.d = i + 8;
        byte[] bArr = this.f3861a;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int k() {
        int i;
        int i3 = this.d;
        int i4 = this.b;
        if (i4 != i3) {
            int i5 = i3 + 1;
            byte[] bArr = this.f3861a;
            byte b = bArr[i3];
            if (b >= 0) {
                this.d = i5;
                return b;
            }
            if (i4 - i5 >= 9) {
                int i6 = i3 + 2;
                int i7 = (bArr[i5] << 7) ^ b;
                long j6 = i7;
                if (j6 < 0) {
                    i = (int) ((-128) ^ j6);
                } else {
                    int i8 = i3 + 3;
                    int i9 = (bArr[i6] << 14) ^ i7;
                    long j7 = i9;
                    if (j7 >= 0) {
                        i = (int) (16256 ^ j7);
                    } else {
                        int i10 = i3 + 4;
                        int i11 = i9 ^ (bArr[i8] << 21);
                        long j8 = i11;
                        if (j8 < 0) {
                            i = (int) ((-2080896) ^ j8);
                        } else {
                            i8 = i3 + 5;
                            byte b2 = bArr[i10];
                            int i12 = (int) (((long) (i11 ^ (b2 << 28))) ^ 266354560);
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
                this.d = i6;
                return i;
            }
        }
        return (int) m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
    
        if (r3[r2] < 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l() {
        /*
            r12 = this;
            int r0 = r12.d
            int r1 = r12.b
            if (r1 != r0) goto L8
            goto Lb8
        L8:
            int r2 = r0 + 1
            byte[] r3 = r12.f3861a
            r4 = r3[r0]
            if (r4 < 0) goto L14
            r12.d = r2
            long r0 = (long) r4
            return r0
        L14:
            int r1 = r1 - r2
            r5 = 9
            if (r1 >= r5) goto L1b
            goto Lb8
        L1b:
            int r1 = r0 + 2
            r2 = r3[r2]
            int r2 = r2 << 7
            r2 = r2 ^ r4
            long r4 = (long) r2
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L2e
            r2 = -128(0xffffffffffffff80, double:NaN)
        L2b:
            long r2 = r2 ^ r4
            goto Lc1
        L2e:
            int r2 = r0 + 3
            r1 = r3[r1]
            int r1 = r1 << 14
            long r8 = (long) r1
            long r4 = r4 ^ r8
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 < 0) goto L42
            r0 = 16256(0x3f80, double:8.0315E-320)
        L3c:
            long r0 = r0 ^ r4
            r10 = r0
            r1 = r2
            r2 = r10
            goto Lc1
        L42:
            int r1 = r0 + 4
            r2 = r3[r2]
            int r2 = r2 << 21
            long r8 = (long) r2
            long r4 = r4 ^ r8
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L52
            r2 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L2b
        L52:
            int r2 = r0 + 5
            r1 = r3[r1]
            long r8 = (long) r1
            r1 = 28
            long r8 = r8 << r1
            long r4 = r4 ^ r8
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 < 0) goto L63
            r0 = 266354560(0xfe03f80, double:1.315966377E-315)
            goto L3c
        L63:
            int r1 = r0 + 6
            r2 = r3[r2]
            long r8 = (long) r2
            r2 = 35
            long r8 = r8 << r2
            long r4 = r4 ^ r8
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L76
            r2 = -34093383808(0xfffffff80fe03f80, double:NaN)
            goto L2b
        L76:
            int r2 = r0 + 7
            r1 = r3[r1]
            long r8 = (long) r1
            r1 = 42
            long r8 = r8 << r1
            long r4 = r4 ^ r8
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 < 0) goto L89
            r0 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L3c
        L89:
            int r1 = r0 + 8
            r2 = r3[r2]
            long r8 = (long) r2
            r2 = 49
            long r8 = r8 << r2
            long r4 = r4 ^ r8
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L9c
            r2 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L2b
        L9c:
            int r2 = r0 + 9
            r1 = r3[r1]
            long r8 = (long) r1
            r1 = 56
            long r8 = r8 << r1
            long r4 = r4 ^ r8
            r8 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r4 = r4 ^ r8
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 >= 0) goto Lbf
            int r1 = r0 + 10
            r0 = r3[r2]
            long r2 = (long) r0
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 >= 0) goto Lbd
        Lb8:
            long r0 = r12.m()
            return r0
        Lbd:
            r2 = r4
            goto Lc1
        Lbf:
            r1 = r2
            goto Lbd
        Lc1:
            r12.d = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.C0605f.l():long");
    }

    public final long m() throws r {
        long j6 = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.d == this.b) {
                p(1);
            }
            int i3 = this.d;
            this.d = i3 + 1;
            byte b = this.f3861a[i3];
            j6 |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j6;
            }
        }
        throw new r("CodedInputStream encountered a malformed varint.");
    }

    public final int n() throws r {
        if (this.d == this.b && !s(1)) {
            this.f3862f = 0;
            return 0;
        }
        int iK = k();
        this.f3862f = iK;
        if ((iK >>> 3) != 0) {
            return iK;
        }
        throw new r("Protocol message contained an invalid tag (zero).");
    }

    public final void o() {
        int i = this.b + this.c;
        this.b = i;
        int i3 = this.f3863g + i;
        int i4 = this.f3864h;
        if (i3 <= i4) {
            this.c = 0;
            return;
        }
        int i5 = i3 - i4;
        this.c = i5;
        this.b = i - i5;
    }

    public final void p(int i) throws r {
        if (!s(i)) {
            throw r.a();
        }
    }

    public final boolean q(int i, C0606g c0606g) throws r {
        int iN;
        int i3 = i & 7;
        if (i3 == 0) {
            long jL = l();
            c0606g.v(i);
            c0606g.w(jL);
            return true;
        }
        if (i3 == 1) {
            long j6 = j();
            c0606g.v(i);
            c0606g.u(j6);
            return true;
        }
        if (i3 == 2) {
            u uVarE = e();
            c0606g.v(i);
            c0606g.v(uVarE.size());
            c0606g.r(uVarE);
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw new r("Protocol message tag had invalid wire type.");
            }
            int i4 = i();
            c0606g.v(i);
            c0606g.t(i4);
            return true;
        }
        c0606g.v(i);
        do {
            iN = n();
            if (iN == 0) {
                break;
            }
        } while (q(iN, c0606g));
        int i5 = ((i >>> 3) << 3) | 4;
        a(i5);
        c0606g.v(i5);
        return true;
    }

    public final void r(int i) throws r {
        int i3 = this.b;
        int i4 = this.d;
        int i5 = i3 - i4;
        if (i <= i5 && i >= 0) {
            this.d = i4 + i;
            return;
        }
        if (i < 0) {
            throw new r("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i6 = this.f3863g;
        int i7 = i6 + i4 + i;
        int i8 = this.f3864h;
        if (i7 > i8) {
            r((i8 - i6) - i4);
            throw r.a();
        }
        this.d = i3;
        p(1);
        while (true) {
            int i9 = i - i5;
            int i10 = this.b;
            if (i9 <= i10) {
                this.d = i9;
                return;
            } else {
                i5 += i10;
                this.d = i10;
                p(1);
            }
        }
    }

    public final boolean s(int i) throws IOException {
        InputStream inputStream;
        int i3 = this.d;
        int i4 = i3 + i;
        int i5 = this.b;
        if (i4 <= i5) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        if (this.f3863g + i3 + i <= this.f3864h && (inputStream = this.e) != null) {
            byte[] bArr = this.f3861a;
            if (i3 > 0) {
                if (i5 > i3) {
                    System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                }
                this.f3863g += i3;
                this.b -= i3;
                this.d = 0;
            }
            int i6 = this.b;
            int i7 = inputStream.read(bArr, i6, bArr.length - i6);
            if (i7 == 0 || i7 < -1 || i7 > bArr.length) {
                StringBuilder sb2 = new StringBuilder(102);
                sb2.append("InputStream#read(byte[]) returned invalid result: ");
                sb2.append(i7);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (i7 > 0) {
                this.b += i7;
                if ((this.f3863g + i) - AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL > 0) {
                    throw new r("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
                }
                o();
                if (this.b >= i) {
                    return true;
                }
                return s(i);
            }
        }
        return false;
    }

    public C0605f(u uVar) {
        this.f3864h = Integer.MAX_VALUE;
        byte[] bArr = uVar.b;
        this.f3861a = bArr;
        this.d = 0;
        this.b = bArr.length;
        this.f3863g = -0;
        this.e = null;
    }
}
