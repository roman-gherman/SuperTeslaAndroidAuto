package E4;

import a.AbstractC0132a;
import c4.AbstractC0246d;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends B4.a {
    public final byte[] c;
    public final short[][] d;
    public final short[][] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final short[][] f330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final short[][] f331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final short[][][] f332h;
    public final short[][][] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final short[][][] f333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final short[][][] f334k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final short[][][] f335l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final short[][][] f336m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final short[][][] f337n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final byte[] f338o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final byte[] f339p;

    public d(c cVar, byte[] bArr) {
        super(true, cVar);
        int i = cVar.f329g;
        Class cls = Short.TYPE;
        int i3 = cVar.c;
        int i4 = cVar.b;
        int i5 = cVar.f327a;
        if (i != 3) {
            short[][] sArr = (short[][]) Array.newInstance((Class<?>) cls, i4, i3);
            this.d = sArr;
            short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) cls, i5, i4);
            this.e = sArr2;
            short[][] sArr3 = (short[][]) Array.newInstance((Class<?>) cls, i5, i3);
            this.f331g = sArr3;
            short[][] sArr4 = (short[][]) Array.newInstance((Class<?>) cls, i4, i3);
            this.f330f = sArr4;
            short[][][] sArr5 = (short[][][]) Array.newInstance((Class<?>) cls, i4, i5, i5);
            this.f332h = sArr5;
            short[][][] sArr6 = (short[][][]) Array.newInstance((Class<?>) cls, i4, i5, i4);
            this.i = sArr6;
            short[][][] sArr7 = (short[][][]) Array.newInstance((Class<?>) cls, i3, i5, i5);
            this.f333j = sArr7;
            short[][][] sArr8 = (short[][][]) Array.newInstance((Class<?>) cls, i3, i5, i4);
            this.f334k = sArr8;
            short[][][] sArr9 = (short[][][]) Array.newInstance((Class<?>) cls, i3, i5, i3);
            this.f335l = sArr9;
            short[][][] sArr10 = (short[][][]) Array.newInstance((Class<?>) cls, i3, i4, i4);
            this.f336m = sArr10;
            short[][][] sArr11 = (short[][][]) Array.newInstance((Class<?>) cls, i3, i4, i3);
            this.f337n = sArr11;
            this.f338o = null;
            byte[] bArrH = g5.c.h(bArr, 0, 32);
            this.c = bArrH;
            int length = bArrH.length;
            int iO = AbstractC0132a.O(sArr, bArr, length) + length;
            int iO2 = AbstractC0132a.O(sArr2, bArr, iO) + iO;
            int iO3 = AbstractC0132a.O(sArr3, bArr, iO2) + iO2;
            int iO4 = AbstractC0132a.O(sArr4, bArr, iO3) + iO3;
            int iP = AbstractC0132a.P(sArr5, bArr, iO4, true) + iO4;
            int iP2 = AbstractC0132a.P(sArr6, bArr, iP, false) + iP;
            int iP3 = AbstractC0132a.P(sArr7, bArr, iP2, true) + iP2;
            int iP4 = AbstractC0132a.P(sArr8, bArr, iP3, false) + iP3;
            int iP5 = AbstractC0132a.P(sArr9, bArr, iP4, false) + iP4;
            int iP6 = AbstractC0132a.P(sArr10, bArr, iP5, true) + iP5;
            this.f339p = g5.c.h(bArr, AbstractC0132a.P(sArr11, bArr, iP6, false) + iP6, bArr.length);
            return;
        }
        byte[] bArrH2 = g5.c.h(bArr, 0, 32);
        this.f338o = bArrH2;
        byte[] bArrH3 = g5.c.h(bArr, 32, 64);
        this.c = bArrH3;
        byte[] bArrC = g5.c.c(bArrH3);
        byte[] bArrC2 = g5.c.c(bArrH2);
        N3.b bVar = cVar.f328f;
        b bVar2 = new b(bArrC, bVar);
        b bVar3 = new b(bArrC2, bVar);
        short[][] sArrX = AbstractC0132a.x(bVar2, i4, i3);
        short[][] sArrX2 = AbstractC0132a.x(bVar2, i5, i4);
        short[][] sArrX3 = AbstractC0132a.x(bVar2, i5, i3);
        short[][] sArrX4 = AbstractC0132a.x(bVar2, i4, i3);
        short[][] sArrC = AbstractC0246d.c(AbstractC0246d.i0(sArrX2, sArrX4), sArrX3);
        short[][][] sArrW = AbstractC0132a.w(bVar3, i4, i5, i5, true);
        short[][][] sArrW2 = AbstractC0132a.w(bVar3, i4, i5, i4, false);
        short[][][] sArrW3 = AbstractC0132a.w(bVar3, i3, i5, i5, true);
        short[][][] sArrW4 = AbstractC0132a.w(bVar3, i3, i5, i4, false);
        short[][][] sArrW5 = AbstractC0132a.w(bVar3, i3, i5, i3, false);
        short[][][] sArrW6 = AbstractC0132a.w(bVar3, i3, i4, i4, true);
        short[][][] sArrW7 = AbstractC0132a.w(bVar3, i3, i4, i3, false);
        short[][][] sArrJ0 = AbstractC0246d.j0(sArrX, sArrW3, sArrW);
        short[][][] sArrJ02 = AbstractC0246d.j0(sArrX, sArrW4, sArrW2);
        short[][][] sArrO = AbstractC0132a.o(sArrJ0);
        int i6 = 0;
        short[][][] sArr12 = new short[i4][][];
        while (i6 < i4) {
            short[][][] sArr13 = sArrW3;
            short[][] sArrD = AbstractC0246d.d(sArrJ0[i6]);
            sArr12[i6] = sArrD;
            short[][] sArrI0 = AbstractC0246d.i0(sArrD, sArrX2);
            sArr12[i6] = sArrI0;
            sArr12[i6] = AbstractC0246d.c(sArrI0, sArrJ02[i6]);
            i6++;
            sArrW4 = sArrW4;
            sArrW3 = sArr13;
        }
        short[][][] sArr14 = sArrW3;
        short[][][] sArr15 = sArrW4;
        short[][][] sArr16 = new short[i3][][];
        short[][][] sArr17 = new short[i3][][];
        short[][][] sArr18 = sArrW7;
        short[][][] sArr19 = new short[i3][][];
        short[][][] sArr20 = new short[i3][][];
        short[][][] sArrO2 = AbstractC0132a.o(sArr14);
        int i7 = 0;
        while (i7 < i3) {
            int i8 = i7;
            short[][] sArrD2 = AbstractC0246d.d(sArr14[i7]);
            short[][][] sArr21 = sArr18;
            short[][] sArrI02 = AbstractC0246d.i0(sArrD2, sArrX2);
            sArr16[i8] = sArrI02;
            short[][][] sArr22 = sArr20;
            sArr16[i8] = AbstractC0246d.c(sArrI02, sArr15[i8]);
            sArr17[i8] = AbstractC0246d.i0(sArrD2, sArrC);
            short[][] sArrC2 = AbstractC0246d.c(sArr17[i8], AbstractC0246d.i0(sArr15[i8], sArrX4));
            sArr17[i8] = sArrC2;
            sArr17[i8] = AbstractC0246d.c(sArrC2, sArrW5[i8]);
            short[][] sArrC3 = AbstractC0246d.c(AbstractC0246d.i0(sArr14[i8], sArrX2), sArr15[i8]);
            short[][] sArrL0 = AbstractC0246d.L0(sArrX2);
            short[][] sArrI03 = AbstractC0246d.i0(sArrL0, sArrC3);
            sArr19[i8] = sArrI03;
            short[][] sArrC4 = AbstractC0246d.c(sArrI03, sArrW6[i8]);
            sArr19[i8] = sArrC4;
            short[][] sArr23 = sArrX;
            if (sArrC4.length != sArrC4[0].length) {
                throw new RuntimeException("Computation to upper triangular matrix is not possible!");
            }
            short[][] sArr24 = (short[][]) Array.newInstance((Class<?>) cls, sArrC4.length, sArrC4.length);
            int i9 = 0;
            while (i9 < sArrC4.length) {
                sArr24[i9][i9] = sArrC4[i9][i9];
                short[][] sArr25 = sArrC4;
                int i10 = i9 + 1;
                while (i10 < sArr25[0].length) {
                    short[] sArr26 = sArr24[i9];
                    short s3 = sArr25[i9][i10];
                    short s6 = sArr25[i10][i9];
                    byte[][] bArr2 = a.f320a;
                    int i11 = i10;
                    sArr26[i11] = (short) (s3 ^ s6);
                    i10 = i11 + 1;
                }
                sArrC4 = sArr25;
                i9 = i10;
            }
            sArr19[i8] = sArr24;
            sArr22[i8] = AbstractC0246d.i0(sArrL0, sArr17[i8]);
            sArr22[i8] = AbstractC0246d.c(sArr22[i8], AbstractC0246d.i0(AbstractC0246d.L0(sArr15[i8]), sArrC));
            short[][] sArrC5 = AbstractC0246d.c(sArr22[i8], AbstractC0246d.i0(AbstractC0246d.d(sArrW6[i8]), sArrX4));
            sArr22[i8] = sArrC5;
            sArr22[i8] = AbstractC0246d.c(sArrC5, sArr21[i8]);
            i7 = i8 + 1;
            sArr18 = sArr21;
            sArr20 = sArr22;
            sArrX = sArr23;
        }
        d dVar = new d(cVar, bArrC, sArrX, sArrX2, sArrX4, sArrC, sArrO, sArr12, sArrO2, sArr16, sArr17, sArr19, sArr20);
        this.f339p = dVar.f339p;
        this.d = dVar.d;
        this.e = dVar.e;
        this.f330f = dVar.f330f;
        this.f331g = dVar.f331g;
        this.f332h = dVar.f332h;
        this.i = dVar.i;
        this.f333j = dVar.f333j;
        this.f334k = dVar.f334k;
        this.f335l = dVar.f335l;
        this.f336m = dVar.f336m;
        this.f337n = dVar.f337n;
    }

    public final byte[] getEncoded() {
        int i = ((c) this.b).f329g;
        byte[] bArr = this.c;
        byte[] bArr2 = this.f338o;
        if (i == 3) {
            return g5.c.e(bArr2, bArr);
        }
        return g5.c.e(i == 3 ? g5.c.e(bArr2, bArr) : g5.c.e(g5.c.e(g5.c.e(g5.c.e(g5.c.e(g5.c.e(g5.c.e(g5.c.e(g5.c.e(g5.c.e(g5.c.e(bArr, AbstractC0132a.z(this.d)), AbstractC0132a.z(this.e)), AbstractC0132a.z(this.f331g)), AbstractC0132a.z(this.f330f)), AbstractC0132a.A(this.f332h, true)), AbstractC0132a.A(this.i, false)), AbstractC0132a.A(this.f333j, true)), AbstractC0132a.A(this.f334k, false)), AbstractC0132a.A(this.f335l, false)), AbstractC0132a.A(this.f336m, true)), AbstractC0132a.A(this.f337n, false)), this.f339p);
    }

    public d(c cVar, byte[] bArr, short[][] sArr, short[][] sArr2, short[][] sArr3, short[][] sArr4, short[][][] sArr5, short[][][] sArr6, short[][][] sArr7, short[][][] sArr8, short[][][] sArr9, short[][][] sArr10, short[][][] sArr11) {
        super(true, cVar);
        this.f338o = null;
        this.f339p = null;
        this.c = (byte[]) bArr.clone();
        this.d = AbstractC0132a.n(sArr);
        this.e = AbstractC0132a.n(sArr2);
        this.f330f = AbstractC0132a.n(sArr3);
        this.f331g = AbstractC0132a.n(sArr4);
        this.f332h = AbstractC0132a.o(sArr5);
        this.i = AbstractC0132a.o(sArr6);
        this.f333j = AbstractC0132a.o(sArr7);
        this.f334k = AbstractC0132a.o(sArr8);
        this.f335l = AbstractC0132a.o(sArr9);
        this.f336m = AbstractC0132a.o(sArr10);
        this.f337n = AbstractC0132a.o(sArr11);
    }
}
