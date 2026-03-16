package N3;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.digests.EncodableDigest;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements ExtendedDigest, Memoable, EncodableDigest {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long[] f1149p = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L3.c f1150a;
    public final byte[] b;
    public int c;
    public long d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f1153h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f1154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1155k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1156l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f1157m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long[] f1158n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1159o;

    public b() {
        L3.c cVar = L3.c.d;
        this.b = new byte[8];
        this.f1158n = new long[80];
        this.f1150a = cVar;
        this.c = 0;
        reset();
    }

    public static long a(long j6, long j7, long j8) {
        return ((~j6) & j8) ^ (j7 & j6);
    }

    public static long b(long j6, long j7, long j8) {
        return ((j6 & j8) ^ (j6 & j7)) ^ (j7 & j8);
    }

    public static long c(long j6) {
        return ((j6 >>> 39) | (j6 << 25)) ^ (((j6 << 36) | (j6 >>> 28)) ^ ((j6 << 30) | (j6 >>> 34)));
    }

    public static long d(long j6) {
        return ((j6 >>> 41) | (j6 << 23)) ^ (((j6 << 50) | (j6 >>> 14)) ^ ((j6 << 46) | (j6 >>> 18)));
    }

    public final void e(b bVar) {
        byte[] bArr = bVar.b;
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f1151f = bVar.f1151f;
        this.f1152g = bVar.f1152g;
        this.f1153h = bVar.f1153h;
        this.i = bVar.i;
        this.f1154j = bVar.f1154j;
        this.f1155k = bVar.f1155k;
        this.f1156l = bVar.f1156l;
        this.f1157m = bVar.f1157m;
        long[] jArr = this.f1158n;
        long[] jArr2 = bVar.f1158n;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        this.f1159o = bVar.f1159o;
    }

    public final void f() {
        long j6 = this.d;
        if (j6 > 2305843009213693951L) {
            this.e += j6 >>> 61;
            this.d = j6 & 2305843009213693951L;
        }
        long j7 = this.d << 3;
        long j8 = this.e;
        byte b = -128;
        while (true) {
            update(b);
            if (this.c == 0) {
                break;
            } else {
                b = 0;
            }
        }
        if (this.f1159o > 14) {
            h();
        }
        long[] jArr = this.f1158n;
        jArr[14] = j8;
        jArr[15] = j7;
        h();
    }

    public final void g(byte[] bArr) {
        System.arraycopy(this.b, 0, bArr, 0, this.c);
        g5.c.o(bArr, this.c, 8);
        g5.c.t(bArr, 12, this.d);
        g5.c.t(bArr, 20, this.e);
        g5.c.t(bArr, 28, this.f1151f);
        g5.c.t(bArr, 36, this.f1152g);
        g5.c.t(bArr, 44, this.f1153h);
        g5.c.t(bArr, 52, this.i);
        g5.c.t(bArr, 60, this.f1154j);
        g5.c.t(bArr, 68, this.f1155k);
        g5.c.t(bArr, 76, this.f1156l);
        g5.c.t(bArr, 84, this.f1157m);
        g5.c.o(bArr, this.f1159o, 92);
        for (int i = 0; i < this.f1159o; i++) {
            g5.c.t(bArr, (i * 8) + 96, this.f1158n[i]);
        }
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public final int getByteLength() {
        return 128;
    }

    public final void h() {
        long[] jArr;
        long j6 = this.d;
        if (j6 > 2305843009213693951L) {
            this.e += j6 >>> 61;
            this.d = j6 & 2305843009213693951L;
        }
        int i = 16;
        while (true) {
            jArr = this.f1158n;
            if (i > 79) {
                break;
            }
            long j7 = jArr[i - 2];
            long j8 = ((j7 >>> 6) ^ (((j7 << 45) | (j7 >>> 19)) ^ ((j7 << 3) | (j7 >>> 61)))) + jArr[i - 7];
            long j9 = jArr[i - 15];
            jArr[i] = j8 + ((((j9 >>> 8) | (j9 << 56)) ^ ((j9 << 63) | (j9 >>> 1))) ^ (j9 >>> 7)) + jArr[i - 16];
            i++;
        }
        long j10 = this.f1151f;
        long j11 = this.f1152g;
        long j12 = this.f1153h;
        long j13 = this.i;
        long j14 = this.f1154j;
        long j15 = this.f1155k;
        long j16 = this.f1156l;
        long j17 = this.f1157m;
        long j18 = j16;
        long j19 = j15;
        int i3 = 0;
        int i4 = 0;
        long j20 = j13;
        long j21 = j14;
        long j22 = j11;
        long j23 = j12;
        long jC = j10;
        while (i3 < 10) {
            long jD = d(j21) + a(j21, j19, j18);
            long[] jArr2 = f1149p;
            int i5 = i4 + 1;
            long j24 = jD + jArr2[i4] + jArr[i4] + j17;
            long j25 = j20 + j24;
            long j26 = jC;
            long j27 = j22;
            long jC2 = c(jC) + b(jC, j22, j23) + j24;
            int i6 = i4 + 2;
            long jD2 = d(j25) + a(j25, j21, j19) + jArr2[i5] + jArr[i5] + j18;
            long j28 = j23 + jD2;
            long jC3 = c(jC2) + b(jC2, j26, j27) + jD2;
            int i7 = i4 + 3;
            long jD3 = d(j28) + a(j28, j25, j21) + jArr2[i6] + jArr[i6] + j19;
            long j29 = j27 + jD3;
            long jC4 = c(jC3) + b(jC3, jC2, j26) + jD3;
            int i8 = i4 + 4;
            long jD4 = d(j29) + a(j29, j28, j25) + jArr2[i7] + jArr[i7] + j21;
            long j30 = j26 + jD4;
            long jC5 = c(jC4) + b(jC4, jC3, jC2) + jD4;
            int i9 = i4 + 5;
            long jD5 = d(j30) + a(j30, j29, j28) + jArr2[i8] + jArr[i8] + j25;
            long j31 = jC2 + jD5;
            long jC6 = c(jC5) + b(jC5, jC4, jC3) + jD5;
            int i10 = i4 + 6;
            long jD6 = d(j31) + a(j31, j30, j29) + jArr2[i9] + jArr[i9] + j28;
            long j32 = jC3 + jD6;
            long jC7 = c(jC6) + b(jC6, jC5, jC4) + jD6;
            int i11 = i4 + 7;
            long jD7 = d(j32) + a(j32, j31, j30) + jArr2[i10] + jArr[i10] + j29;
            long j33 = jC4 + jD7;
            long jC8 = c(jC7) + b(jC7, jC6, jC5) + jD7;
            i4 += 8;
            long jD8 = d(j33) + a(j33, j32, j31) + jArr2[i11] + jArr[i11] + j30;
            j21 = jC5 + jD8;
            j23 = jC7;
            jC = c(jC8) + b(jC8, jC7, jC6) + jD8;
            i3++;
            j22 = jC8;
            j20 = jC6;
            j19 = j33;
            j18 = j32;
            j17 = j31;
        }
        this.f1151f += jC;
        this.f1152g += j22;
        this.f1153h += j23;
        this.i += j20;
        this.f1154j += j21;
        this.f1155k += j19;
        this.f1156l += j18;
        this.f1157m += j17;
        this.f1159o = 0;
        for (int i12 = 0; i12 < 16; i12++) {
            jArr[i12] = 0;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.d = 0L;
        this.e = 0L;
        int i = 0;
        this.c = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = 0;
            i3++;
        }
        this.f1159o = 0;
        while (true) {
            long[] jArr = this.f1158n;
            if (i == jArr.length) {
                return;
            }
            jArr[i] = 0;
            i++;
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
            this.f1158n[this.f1159o] = (((long) g5.c.b(4, bArr)) & 4294967295L) | ((((long) g5.c.b(0, bArr)) & 4294967295L) << 32);
            int i4 = this.f1159o + 1;
            this.f1159o = i4;
            if (i4 == 16) {
                h();
            }
            this.c = 0;
        }
        this.d++;
    }

    public b(b bVar) {
        this.b = new byte[8];
        this.f1158n = new long[80];
        this.f1150a = bVar.f1150a;
        e(bVar);
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void update(byte[] bArr, int i, int i3) {
        while (this.c != 0 && i3 > 0) {
            update(bArr[i]);
            i++;
            i3--;
        }
        while (true) {
            byte[] bArr2 = this.b;
            if (i3 < bArr2.length) {
                break;
            }
            this.f1158n[this.f1159o] = (((long) g5.c.b(i + 4, bArr)) & 4294967295L) | ((((long) g5.c.b(i, bArr)) & 4294967295L) << 32);
            int i4 = this.f1159o + 1;
            this.f1159o = i4;
            if (i4 == 16) {
                h();
            }
            i += bArr2.length;
            i3 -= bArr2.length;
            this.d += (long) bArr2.length;
        }
        while (i3 > 0) {
            update(bArr[i]);
            i++;
            i3--;
        }
    }
}
