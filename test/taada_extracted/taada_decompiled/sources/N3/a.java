package N3;

import java.util.Arrays;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.ExtendedDigest;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ExtendedDigest {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long[] f1145h = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L3.c f1146a;
    public final long[] b;
    public final byte[] c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1148g;

    public a(int i) {
        this(i, 0);
    }

    public final void a(int i, byte[] bArr) {
        int i3 = this.d >>> 6;
        for (int i4 = 0; i4 < i3; i4++) {
            long[] jArr = this.b;
            jArr[i4] = jArr[i4] ^ g5.c.s(i, bArr);
            i += 8;
        }
        b();
    }

    public final void b() {
        long[] jArr = this.b;
        long j6 = jArr[0];
        long j7 = jArr[1];
        char c = 2;
        long j8 = jArr[2];
        char c6 = 3;
        long j9 = jArr[3];
        char c7 = 4;
        long j10 = jArr[4];
        long j11 = jArr[5];
        long j12 = jArr[6];
        long j13 = jArr[7];
        long j14 = jArr[8];
        long j15 = jArr[9];
        long j16 = jArr[10];
        long j17 = jArr[11];
        long j18 = jArr[12];
        long j19 = jArr[13];
        long j20 = jArr[14];
        long j21 = jArr[15];
        long j22 = jArr[16];
        long j23 = jArr[17];
        long j24 = jArr[18];
        long j25 = jArr[19];
        long j26 = jArr[20];
        long j27 = jArr[21];
        long j28 = jArr[22];
        long j29 = jArr[23];
        int i = 24;
        long j30 = jArr[24];
        int i3 = 0;
        while (i3 < i) {
            long j31 = (((j6 ^ j11) ^ j16) ^ j21) ^ j26;
            long j32 = (((j7 ^ j12) ^ j17) ^ j22) ^ j27;
            long j33 = (((j8 ^ j13) ^ j18) ^ j23) ^ j28;
            long j34 = (((j9 ^ j14) ^ j19) ^ j24) ^ j29;
            long j35 = (((j10 ^ j15) ^ j20) ^ j25) ^ j30;
            long j36 = ((j32 << 1) | (j32 >>> (-1))) ^ j35;
            long j37 = ((j33 << 1) | (j33 >>> (-1))) ^ j31;
            long j38 = ((j34 << 1) | (j34 >>> (-1))) ^ j32;
            long j39 = ((j35 << 1) | (j35 >>> (-1))) ^ j33;
            long j40 = ((j31 << 1) | (j31 >>> (-1))) ^ j34;
            long j41 = j6 ^ j36;
            long j42 = j11 ^ j36;
            long j43 = j16 ^ j36;
            long j44 = j21 ^ j36;
            long j45 = j26 ^ j36;
            long j46 = j7 ^ j37;
            long j47 = j12 ^ j37;
            long j48 = j17 ^ j37;
            long j49 = j22 ^ j37;
            long j50 = j27 ^ j37;
            long j51 = j8 ^ j38;
            long j52 = j13 ^ j38;
            long j53 = j18 ^ j38;
            long j54 = j23 ^ j38;
            long j55 = j28 ^ j38;
            long j56 = j9 ^ j39;
            long j57 = j14 ^ j39;
            long j58 = j19 ^ j39;
            long j59 = j24 ^ j39;
            long j60 = j29 ^ j39;
            long j61 = j10 ^ j40;
            long j62 = j15 ^ j40;
            long j63 = j20 ^ j40;
            long j64 = j25 ^ j40;
            long j65 = j30 ^ j40;
            long j66 = (j46 << 1) | (j46 >>> 63);
            char c8 = c;
            long j67 = (j47 << 44) | (j47 >>> 20);
            char c9 = c6;
            long j68 = (j62 << 20) | (j62 >>> 44);
            char c10 = c7;
            long j69 = (j55 << 61) | (j55 >>> c9);
            int i4 = i;
            long j70 = (j63 << 39) | (j63 >>> 25);
            long j71 = (j45 << 18) | (j45 >>> 46);
            int i5 = i3;
            long j72 = (j51 << 62) | (j51 >>> c8);
            long j73 = (j53 << 43) | (j53 >>> 21);
            long j74 = (j58 << 25) | (j58 >>> 39);
            long j75 = (j64 << 8) | (j64 >>> 56);
            long j76 = (j60 << 56) | (j60 >>> 8);
            long j77 = (j44 << 41) | (j44 >>> 23);
            long j78 = (j61 << 27) | (j61 >>> 37);
            long j79 = (j65 << 14) | (j65 >>> 50);
            long j80 = (j50 << c8) | (j50 >>> 62);
            long j81 = (j57 << 55) | (j57 >>> 9);
            long j82 = (j49 << 45) | (j49 >>> 19);
            long j83 = (j42 << 36) | (j42 >>> 28);
            long j84 = (j56 << 28) | (j56 >>> 36);
            long j85 = (j59 << 21) | (j59 >>> 43);
            long j86 = (j54 << 15) | (j54 >>> 49);
            long j87 = (j48 << 10) | (j48 >>> 54);
            long j88 = (j52 << 6) | (j52 >>> 58);
            long j89 = (j43 << c9) | (j43 >>> 61);
            long j90 = j41 ^ ((~j67) & j73);
            j7 = ((~j73) & j85) ^ j67;
            long j91 = j73 ^ ((~j85) & j79);
            long j92 = j85 ^ ((~j79) & j41);
            long j93 = j79 ^ ((~j41) & j67);
            long j94 = j84 ^ ((~j68) & j89);
            long j95 = ((~j89) & j82) ^ j68;
            long j96 = ((~j82) & j69) ^ j89;
            long j97 = j82 ^ ((~j69) & j84);
            long j98 = ((~j84) & j68) ^ j69;
            j16 = j66 ^ ((~j88) & j74);
            long j99 = ((~j74) & j75) ^ j88;
            long j100 = ((~j75) & j71) ^ j74;
            long j101 = j75 ^ ((~j71) & j66);
            j20 = j71 ^ ((~j66) & j88);
            long j102 = j78 ^ ((~j83) & j87);
            long j103 = j83 ^ ((~j87) & j86);
            long j104 = ((~j86) & j76) ^ j87;
            long j105 = j86 ^ ((~j76) & j78);
            long j106 = ((~j78) & j83) ^ j76;
            long j107 = j72 ^ ((~j81) & j70);
            long j108 = ((~j70) & j77) ^ j81;
            long j109 = j70 ^ ((~j77) & j80);
            j29 = j77 ^ ((~j80) & j72);
            j22 = j103;
            j13 = j96;
            j27 = j108;
            j26 = j107;
            j28 = j109;
            j15 = j98;
            j14 = j97;
            j23 = j104;
            j19 = j101;
            j25 = j106;
            j11 = j94;
            j18 = j100;
            j12 = j95;
            c7 = c10;
            c = c8;
            j30 = j80 ^ ((~j72) & j81);
            jArr = jArr;
            i3 = i5 + 1;
            j6 = j90 ^ f1145h[i5];
            j9 = j92;
            j10 = j93;
            j17 = j99;
            i = i4;
            j24 = j105;
            j21 = j102;
            c6 = c9;
            j8 = j91;
        }
        long[] jArr2 = jArr;
        jArr2[0] = j6;
        jArr2[1] = j7;
        jArr2[c] = j8;
        jArr2[c6] = j9;
        jArr2[c7] = j10;
        jArr2[5] = j11;
        jArr2[6] = j12;
        jArr2[7] = j13;
        jArr2[8] = j14;
        jArr2[9] = j15;
        jArr2[10] = j16;
        jArr2[11] = j17;
        jArr2[12] = j18;
        jArr2[13] = j19;
        jArr2[14] = j20;
        jArr2[15] = j21;
        jArr2[16] = j22;
        jArr2[17] = j23;
        jArr2[18] = j24;
        jArr2[19] = j25;
        jArr2[20] = j26;
        jArr2[21] = j27;
        jArr2[22] = j28;
        jArr2[23] = j29;
        jArr2[i] = j30;
    }

    public final void c(int i, int i3) {
        if (i3 < 1 || i3 > 7) {
            throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
        }
        int i4 = this.e;
        if (i4 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.f1148g) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        byte[] bArr = this.c;
        bArr[i4 >>> 3] = (byte) (i & ((1 << i3) - 1));
        this.e = i4 + i3;
    }

    public CryptoServiceProperties d() {
        return C5.f.D(this, getDigestSize() * 8, this.f1146a);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        f(bArr, i, this.f1147f);
        reset();
        return getDigestSize();
    }

    public final void e(int i) {
        if (i != 128 && i != 224 && i != 256 && i != 288 && i != 384 && i != 512) {
            throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
        }
        int i3 = 1600 - (i << 1);
        if (i3 <= 0 || i3 >= 1600 || i3 % 64 != 0) {
            throw new IllegalStateException("invalid rate value");
        }
        this.d = i3;
        int i4 = 0;
        while (true) {
            long[] jArr = this.b;
            if (i4 >= jArr.length) {
                Arrays.fill(this.c, (byte) 0);
                this.e = 0;
                this.f1148g = false;
                this.f1147f = (1600 - i3) / 2;
                return;
            }
            jArr[i4] = 0;
            i4++;
        }
    }

    public final void f(byte[] bArr, int i, long j6) {
        boolean z6 = this.f1148g;
        long[] jArr = this.b;
        byte[] bArr2 = this.c;
        if (!z6) {
            int i3 = this.e;
            int i4 = i3 >>> 3;
            bArr2[i4] = (byte) (bArr2[i4] | ((byte) (1 << (i3 & 7))));
            int i5 = i3 + 1;
            this.e = i5;
            if (i5 == this.d) {
                a(0, bArr2);
            } else {
                int i6 = i5 >>> 6;
                int i7 = i5 & 63;
                int i8 = 0;
                for (int i9 = 0; i9 < i6; i9++) {
                    jArr[i9] = jArr[i9] ^ g5.c.s(i8, bArr2);
                    i8 += 8;
                }
                if (i7 > 0) {
                    jArr[i6] = (g5.c.s(i8, bArr2) & ((1 << i7) - 1)) ^ jArr[i6];
                }
            }
            int i10 = (this.d - 1) >>> 6;
            jArr[i10] = jArr[i10] ^ Long.MIN_VALUE;
            this.e = 0;
            this.f1148g = true;
        }
        long j7 = 0;
        if (j6 % 8 != 0) {
            throw new IllegalStateException("outputLength not a multiple of 8");
        }
        while (j7 < j6) {
            if (this.e == 0) {
                b();
                int i11 = this.d >>> 6;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    g5.c.u(bArr2, i12, jArr[i13]);
                    i12 += 8;
                }
                this.e = this.d;
            }
            int iMin = (int) Math.min(this.e, j6 - j7);
            System.arraycopy(bArr2, (this.d - this.e) / 8, bArr, ((int) (j7 / 8)) + i, iMin / 8);
            this.e -= iMin;
            j7 += (long) iMin;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "Keccak-" + this.f1147f;
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public final int getByteLength() {
        return this.d / 8;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.f1147f / 8;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void reset() {
        e(this.f1147f);
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void update(byte b) {
        int i = this.e;
        if (i % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.f1148g) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        byte[] bArr = this.c;
        bArr[i >>> 3] = b;
        int i3 = i + 8;
        this.e = i3;
        if (i3 == this.d) {
            a(0, bArr);
            this.e = 0;
        }
    }

    public a(int i, int i3) {
        L3.c cVar = L3.c.d;
        this.b = new long[25];
        this.c = new byte[192];
        this.f1146a = cVar;
        e(i);
        L3.h.a(d());
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void update(byte[] bArr, int i, int i3) {
        int i4;
        int i5;
        int i6 = this.e;
        if (i6 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.f1148g) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        int i7 = i6 >>> 3;
        int i8 = this.d >>> 3;
        int i9 = i8 - i7;
        byte[] bArr2 = this.c;
        if (i3 < i9) {
            System.arraycopy(bArr, i, bArr2, i7, i3);
            i5 = this.e + (i3 << 3);
        } else {
            if (i7 > 0) {
                System.arraycopy(bArr, i, bArr2, i7, i9);
                a(0, bArr2);
            } else {
                i9 = 0;
            }
            while (true) {
                i4 = i3 - i9;
                if (i4 < i8) {
                    break;
                }
                a(i + i9, bArr);
                i9 += i8;
            }
            System.arraycopy(bArr, i + i9, bArr2, 0, i4);
            i5 = i4 << 3;
        }
        this.e = i5;
    }
}
