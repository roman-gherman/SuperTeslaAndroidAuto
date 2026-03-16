package z4;

import C0.t;
import N3.g;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends B4.a {
    public final byte[] c;
    public final byte[] d;
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f5213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f5214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f5215h;
    public final int i;

    public d(c cVar, byte[] bArr, e eVar) {
        d dVar;
        int i;
        int i3;
        super((Object) cVar, true);
        C0948a c0948a = new C0948a(cVar.b);
        int length = bArr.length;
        int i4 = c0948a.e;
        int i5 = c0948a.f5207f;
        if (length == 64) {
            byte[] bArrH = g5.c.h(bArr, 0, 32);
            byte[] bArrH2 = g5.c.h(bArr, 32, bArr.length);
            b bVar = c0948a.f5206a;
            C0948a c0948a2 = bVar.f5210a;
            X.e eVar2 = new X.e(c0948a2);
            X.e eVar3 = new X.e(c0948a2);
            X.e eVar4 = new X.e(c0948a2);
            byte[] bArr2 = new byte[64];
            i = 2;
            int i6 = bVar.b;
            int length2 = bArrH.length;
            byte[] bArr3 = new byte[length2 + 1];
            System.arraycopy(bArrH, 0, bArr3, 0, length2);
            bArr3[length2] = (byte) i6;
            t tVar = bVar.e;
            tVar.getClass();
            int length3 = bArr3.length;
            N3.e eVar5 = (N3.e) tVar.c;
            eVar5.update(bArr3, 0, length3);
            eVar5.doFinal(bArr2, 0);
            byte[] bArr4 = new byte[32];
            byte[] bArr5 = new byte[32];
            System.arraycopy(bArr2, 0, bArr4, 0, 32);
            System.arraycopy(bArr2, 32, bArr5, 0, 32);
            X.e[] eVarArr = new X.e[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                eVarArr[i7] = new X.e(c0948a2);
            }
            int i8 = bVar.f5211f * 168;
            byte[] bArr6 = new byte[i8 + 2];
            int i9 = 0;
            while (i9 < i6) {
                int i10 = 0;
                while (i10 < i6) {
                    int i11 = i4;
                    byte b = (byte) i10;
                    int i12 = i10;
                    byte b2 = (byte) i9;
                    int i13 = i9;
                    g gVar = (g) tVar.b;
                    gVar.reset();
                    t tVar2 = tVar;
                    byte[] bArr7 = new byte[34];
                    System.arraycopy(bArr4, 0, bArr7, 0, 32);
                    bArr7[32] = b;
                    bArr7[33] = b2;
                    gVar.update(bArr7, 0, 34);
                    gVar.doOutput(bArr6, 0, i8);
                    int iA = b.a(((M3.a[]) eVarArr[i13].d)[i12], 0, 256, bArr6, i8);
                    int i14 = i8;
                    for (int i15 = 256; iA < i15; i15 = 256) {
                        int i16 = i14 % 3;
                        int i17 = i8;
                        for (int i18 = 0; i18 < i16; i18++) {
                            bArr6[i18] = bArr6[(i14 - i16) + i18];
                        }
                        gVar.doOutput(bArr6, i16, 336);
                        i14 = i16 + 168;
                        iA += b.a(((M3.a[]) eVarArr[i13].d)[i12], iA, 256 - iA, bArr6, i14);
                        i8 = i17;
                    }
                    i10 = i12 + 1;
                    i4 = i11;
                    i9 = i13;
                    tVar = tVar2;
                }
                i9++;
            }
            int i19 = i4;
            byte b6 = 0;
            for (int i20 = 0; i20 < i6; i20++) {
                ((M3.a[]) eVar2.d)[i20].d(bArr5, b6);
                b6 = (byte) (b6 + 1);
            }
            for (int i21 = 0; i21 < i6; i21++) {
                ((M3.a[]) eVar4.d)[i21].d(bArr5, b6);
                b6 = (byte) (b6 + 1);
            }
            eVar2.a();
            eVar4.a();
            int i22 = 0;
            while (i22 < i6) {
                M3.a aVar = ((M3.a[]) eVar3.d)[i22];
                X.e eVar6 = eVarArr[i22];
                M3.a aVar2 = new M3.a(c0948a2);
                M3.a.a(aVar, ((M3.a[]) eVar6.d)[0], ((M3.a[]) eVar2.d)[0]);
                int i23 = 1;
                while (i23 < c0948a2.b) {
                    M3.a.a(aVar2, ((M3.a[]) eVar6.d)[i23], ((M3.a[]) eVar2.d)[i23]);
                    int i24 = 0;
                    while (i24 < 256) {
                        short[] sArr = (short[]) aVar.d;
                        sArr[i24] = (short) (sArr[i24] + ((short[]) aVar2.d)[i24]);
                        i24++;
                        i22 = i22;
                    }
                    aVar.getClass();
                    i23++;
                    i22 = i22;
                }
                int i25 = i22;
                aVar.n();
                M3.a aVar3 = ((M3.a[]) eVar3.d)[i25];
                for (int i26 = 0; i26 < 256; i26++) {
                    ((short[]) aVar3.d)[i26] = f.b(((short[]) aVar3.d)[i26] * 1353);
                }
                aVar3.getClass();
                i22 = i25 + 1;
            }
            for (int i27 = 0; i27 < eVar3.b; i27++) {
                M3.a aVar4 = ((M3.a[]) eVar3.d)[i27];
                M3.a aVar5 = ((M3.a[]) eVar4.d)[i27];
                for (int i28 = 0; i28 < 256; i28++) {
                    short[] sArr2 = (short[]) aVar4.d;
                    sArr2[i28] = (short) (sArr2[i28] + ((short[]) aVar5.d)[i28]);
                }
                aVar4.getClass();
            }
            for (int i29 = 0; i29 < eVar3.b; i29++) {
                ((M3.a[]) eVar3.d)[i29].n();
            }
            byte[] bArr8 = new byte[bVar.c];
            byte[] bArrB = eVar3.b();
            int i30 = bVar.d;
            System.arraycopy(bArrB, 0, bArr8, 0, i30);
            System.arraycopy(bArr4, 0, bArr8, i30, 32);
            byte[][] bArr9 = {bArr8, eVar2.b()};
            byte[] bArr10 = new byte[i5];
            System.arraycopy(bArr9[1], 0, bArr10, 0, i5);
            byte[] bArr11 = new byte[32];
            byte[] bArr12 = bArr9[0];
            t tVar3 = c0948a.f5209h;
            tVar3.getClass();
            int length4 = bArr12.length;
            N3.e eVar7 = (N3.e) tVar3.d;
            eVar7.update(bArr12, 0, length4);
            eVar7.doFinal(bArr11, 0);
            byte[] bArr13 = new byte[i19];
            System.arraycopy(bArr9[0], 0, bArr13, 0, i19);
            int i31 = i19 - 32;
            byte[][] bArr14 = {g5.c.h(bArr13, 0, i31), g5.c.h(bArr13, i31, i19), bArr10, bArr11, bArrH2, g5.c.e(bArrH, bArrH2)};
            dVar = this;
            dVar.c = bArr14[2];
            dVar.d = bArr14[3];
            dVar.e = bArr14[4];
            i3 = 0;
            dVar.f5213f = bArr14[0];
            dVar.f5214g = bArr14[1];
            dVar.f5215h = bArr14[5];
        } else {
            dVar = this;
            i = 2;
            i3 = 0;
            dVar.c = g5.c.h(bArr, 0, i5);
            dVar.f5213f = g5.c.h(bArr, i5, (i5 + i4) - 32);
            int i32 = (i4 - 32) + i5;
            int i33 = i32 + 32;
            dVar.f5214g = g5.c.h(bArr, i32, i33);
            int i34 = i32 + 64;
            dVar.d = g5.c.h(bArr, i33, i34);
            dVar.e = g5.c.h(bArr, i34, i32 + 96);
            dVar.f5215h = null;
        }
        if (eVar != null && (!g5.c.g(dVar.f5213f, eVar.c) || !g5.c.g(dVar.f5214g, eVar.d))) {
            throw new IllegalArgumentException("passed in public key does not match private values");
        }
        dVar.i = dVar.f5215h == null ? i : i3;
    }

    public final byte[] getEncoded() {
        return g5.c.f(new byte[][]{this.c, this.f5213f, this.f5214g, this.d, this.e});
    }

    public final d n(int i) {
        if (this.i == i) {
            return this;
        }
        if (i == 0 || i == 1) {
            if (this.f5215h == null) {
                throw new IllegalStateException("no seed available");
            }
        } else if (i != 2) {
            throw new IllegalArgumentException("unknown format");
        }
        return new d(this, i);
    }

    public d(d dVar, int i) {
        super(dVar.b, true);
        this.c = dVar.c;
        this.f5213f = dVar.f5213f;
        this.f5214g = dVar.f5214g;
        this.d = dVar.d;
        this.e = dVar.e;
        this.f5215h = dVar.f5215h;
        this.i = i;
    }
}
