package y4;

import N3.g;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.reflect.jvm.internal.impl.protobuf.v;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends B4.a {
    public final byte[] c;
    public final byte[] d;
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f5151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f5152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f5153h;
    public final byte[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f5154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f5155k;

    public c(C0938b c0938b, byte[] bArr, d dVar) {
        c cVar;
        int i;
        B2.d[] dVarArr;
        B2.d[] dVarArr2;
        int i3;
        B2.d[] dVarArr3;
        B2.d[] dVarArr4;
        super((Object) c0938b, true);
        C0937a c0937a = new C0937a(c0938b.f5150a);
        int length = bArr.length;
        int i4 = c0937a.d;
        int i5 = c0937a.b;
        int i6 = c0937a.c;
        if (length == 32) {
            byte[] bArr2 = new byte[128];
            i = 2;
            byte[] bArr3 = new byte[64];
            byte[] bArr4 = new byte[32];
            byte[] bArr5 = new byte[64];
            byte[] bArr6 = new byte[32];
            v vVar = new v(c0937a);
            f fVar = new f(c0937a, 1);
            f fVar2 = new f(c0937a, 0);
            f fVar3 = new f(c0937a, 0);
            f fVar4 = new f(c0937a, 0);
            g gVar = c0937a.f5143a;
            gVar.update(bArr, 0, 32);
            gVar.update((byte) i6);
            gVar.update((byte) i4);
            gVar.doFinal(bArr2, 0, 128);
            System.arraycopy(bArr2, 0, bArr4, 0, 32);
            System.arraycopy(bArr2, 32, bArr5, 0, 64);
            System.arraycopy(bArr2, 96, bArr6, 0, 32);
            vVar.b(bArr4);
            int i7 = 0;
            short s3 = 0;
            while (true) {
                dVarArr3 = fVar.b;
                if (i7 >= dVarArr3.length) {
                    break;
                }
                dVarArr3[i7].t(bArr5, s3);
                i7++;
                s3 = (short) (s3 + 1);
            }
            short s6 = (short) i4;
            int i8 = 0;
            while (true) {
                dVarArr4 = fVar2.b;
                if (i8 >= dVarArr4.length) {
                    break;
                }
                dVarArr4[i8].t(bArr5, s6);
                i8++;
                s6 = (short) (s6 + 1);
            }
            f fVar5 = new f(c0937a, 1);
            for (int i9 = 0; i9 < dVarArr3.length; i9++) {
                System.arraycopy((int[]) dVarArr3[i9].b, 0, (int[]) fVar5.b[i9].b, 0, 256);
            }
            fVar5.c();
            vVar.c(fVar3, fVar5);
            fVar3.e();
            fVar3.b();
            int i10 = 0;
            while (true) {
                B2.d[] dVarArr5 = fVar3.b;
                if (i10 >= dVarArr5.length) {
                    break;
                }
                B2.d dVar2 = dVarArr5[i10];
                B2.d dVar3 = dVarArr4[i10];
                int i11 = 0;
                while (i11 < 256) {
                    int[] iArr = (int[]) dVar2.b;
                    iArr[i11] = iArr[i11] + ((int[]) dVar3.b)[i11];
                    i11++;
                    i10 = i10;
                }
                dVar2.getClass();
                i10++;
            }
            fVar3.a();
            fVar3.d(fVar4);
            byte[] bArrB = e.b(fVar3, c0937a);
            gVar.update(bArr4, 0, 32);
            gVar.update(bArrB, 0, bArrB.length);
            gVar.doFinal(bArr3, 0, 64);
            char c = 6;
            byte[][] bArr7 = new byte[6][];
            bArr7[0] = bArr4;
            bArr7[1] = bArr6;
            bArr7[2] = bArr3;
            bArr7[3] = new byte[i4 * i5];
            for (int i12 = 0; i12 < i4; i12++) {
                dVarArr3[i12].k(i12 * i5, bArr7[3]);
            }
            bArr7[4] = new byte[i6 * i5];
            for (int i13 = 0; i13 < i6; i13++) {
                dVarArr4[i13].k(i13 * i5, bArr7[4]);
            }
            bArr7[5] = new byte[i6 * TypedValues.CycleType.TYPE_PATH_ROTATE];
            int i14 = 0;
            while (i14 < i6) {
                B2.d dVar4 = fVar4.b[i14];
                byte[] bArr8 = bArr7[5];
                int i15 = i14 * TypedValues.CycleType.TYPE_PATH_ROTATE;
                int i16 = 0;
                while (i16 < 32) {
                    int i17 = i16 * 8;
                    int[] iArr2 = (int[]) dVar4.b;
                    char c6 = c;
                    byte[] bArr9 = bArrB;
                    int[] iArr3 = {4096 - iArr2[i17], 4096 - iArr2[i17 + 1], 4096 - iArr2[i17 + 2], 4096 - iArr2[i17 + 3], 4096 - iArr2[i17 + 4], 4096 - iArr2[i17 + 5], 4096 - iArr2[i17 + 6], 4096 - iArr2[i17 + 7]};
                    int i18 = (i16 * 13) + i15;
                    int i19 = iArr3[0];
                    bArr8[i18] = (byte) i19;
                    int i20 = i18 + 1;
                    byte b = (byte) (i19 >> 8);
                    bArr8[i20] = b;
                    int i21 = iArr3[1];
                    bArr8[i20] = (byte) (b | ((byte) (i21 << 5)));
                    bArr8[i18 + 2] = (byte) (i21 >> 3);
                    int i22 = i18 + 3;
                    byte b2 = (byte) (i21 >> 11);
                    bArr8[i22] = b2;
                    int i23 = iArr3[2];
                    bArr8[i22] = (byte) (b2 | ((byte) (i23 << 2)));
                    int i24 = i18 + 4;
                    byte b6 = (byte) (i23 >> 6);
                    bArr8[i24] = b6;
                    int i25 = iArr3[3];
                    bArr8[i24] = (byte) (b6 | ((byte) (i25 << 7)));
                    bArr8[i18 + 5] = (byte) (i25 >> 1);
                    int i26 = i18 + 6;
                    byte b7 = (byte) (i25 >> 9);
                    bArr8[i26] = b7;
                    int i27 = iArr3[4];
                    bArr8[i26] = (byte) (b7 | ((byte) (i27 << 4)));
                    bArr8[i18 + 7] = (byte) (i27 >> 4);
                    int i28 = i18 + 8;
                    byte b8 = (byte) (i27 >> 12);
                    bArr8[i28] = b8;
                    int i29 = iArr3[5];
                    bArr8[i28] = (byte) (b8 | ((byte) (i29 << 1)));
                    int i30 = i18 + 9;
                    byte b9 = (byte) (i29 >> 7);
                    bArr8[i30] = b9;
                    int i31 = iArr3[c6];
                    bArr8[i30] = (byte) (b9 | ((byte) (i31 << 6)));
                    bArr8[i18 + 10] = (byte) (i31 >> 2);
                    int i32 = i18 + 11;
                    byte b10 = (byte) (i31 >> 10);
                    bArr8[i32] = b10;
                    int i33 = iArr3[7];
                    bArr8[i32] = (byte) (b10 | ((byte) (i33 << 3)));
                    bArr8[i18 + 12] = (byte) (i33 >> 5);
                    i16++;
                    c = c6;
                    bArrB = bArr9;
                }
                dVar4.getClass();
                i14++;
                c = c;
                bArrB = bArrB;
            }
            byte[][] bArr10 = {bArr7[0], bArr7[1], bArr7[2], bArr7[3], bArr7[4], bArr7[5], bArrB, bArr};
            cVar = this;
            cVar.c = bArr10[0];
            cVar.d = bArr10[1];
            cVar.e = bArr10[2];
            cVar.f5151f = bArr10[3];
            cVar.f5152g = bArr10[4];
            cVar.f5153h = bArr10[5];
            cVar.i = bArr10[c];
            cVar.f5154j = bArr10[7];
            i3 = 0;
        } else {
            cVar = this;
            i = 2;
            byte[] bArrH = g5.c.h(bArr, 0, 32);
            cVar.c = bArrH;
            cVar.d = g5.c.h(bArr, 32, 64);
            cVar.e = g5.c.h(bArr, 64, 128);
            int i34 = (i4 * i5) + 128;
            byte[] bArrH2 = g5.c.h(bArr, 128, i34);
            cVar.f5151f = bArrH2;
            int i35 = (i6 * i5) + i34;
            byte[] bArrH3 = g5.c.h(bArr, i34, i35);
            cVar.f5152g = bArrH3;
            byte[] bArrH4 = g5.c.h(bArr, i35, (i6 * TypedValues.CycleType.TYPE_PATH_ROTATE) + i35);
            cVar.f5153h = bArrH4;
            v vVar2 = new v(c0937a);
            f fVar6 = new f(c0937a, 1);
            f fVar7 = new f(c0937a, 0);
            f fVar8 = new f(c0937a, 0);
            f fVar9 = new f(c0937a, 0);
            int i36 = 0;
            while (true) {
                dVarArr = fVar6.b;
                if (i36 >= i4) {
                    break;
                }
                dVarArr[i36].l(i36 * i5, bArrH2);
                i36++;
            }
            int i37 = 0;
            while (true) {
                dVarArr2 = fVar7.b;
                if (i37 >= i6) {
                    break;
                }
                dVarArr2[i37].l(i37 * i5, bArrH3);
                i37++;
            }
            int i38 = 0;
            while (i38 < i6) {
                B2.d dVar5 = fVar9.b[i38];
                int i39 = i38 * TypedValues.CycleType.TYPE_PATH_ROTATE;
                dVar5.getClass();
                int i40 = 0;
                while (i40 < 32) {
                    int i41 = (i40 * 13) + i39;
                    int i42 = i40 * 8;
                    int i43 = bArrH4[i41] & 255;
                    int i44 = i38;
                    int i45 = bArrH4[i41 + 1] & 255;
                    int i46 = (i43 | (i45 << 8)) & 8191;
                    int[] iArr4 = (int[]) dVar5.b;
                    iArr4[i42] = i46;
                    int i47 = i42 + 1;
                    int i48 = (i45 >> 5) | ((bArrH4[i41 + 2] & 255) << 3);
                    int i49 = bArrH4[i41 + 3] & 255;
                    iArr4[i47] = (i48 | (i49 << 11)) & 8191;
                    int i50 = i42 + 2;
                    int i51 = i49 >> 2;
                    int i52 = bArrH4[i41 + 4] & 255;
                    iArr4[i50] = (i51 | (i52 << 6)) & 8191;
                    int i53 = i42 + 3;
                    int i54 = (i52 >> 7) | ((bArrH4[i41 + 5] & 255) << 1);
                    int i55 = bArrH4[i41 + 6] & 255;
                    iArr4[i53] = (i54 | (i55 << 9)) & 8191;
                    int i56 = i42 + 4;
                    int i57 = (i55 >> 4) | ((bArrH4[i41 + 7] & 255) << 4);
                    int i58 = bArrH4[i41 + 8] & 255;
                    iArr4[i56] = (i57 | (i58 << 12)) & 8191;
                    int i59 = i42 + 5;
                    int i60 = i58 >> 1;
                    int i61 = bArrH4[i41 + 9] & 255;
                    iArr4[i59] = (i60 | (i61 << 7)) & 8191;
                    int i62 = i42 + 6;
                    int i63 = (i61 >> 6) | ((bArrH4[i41 + 10] & 255) << 2);
                    int i64 = bArrH4[i41 + 11] & 255;
                    iArr4[i62] = (i63 | (i64 << 10)) & 8191;
                    int i65 = i42 + 7;
                    iArr4[i65] = ((i64 >> 3) | ((bArrH4[i41 + 12] & 255) << 5)) & 8191;
                    iArr4[i42] = 4096 - iArr4[i42];
                    iArr4[i47] = 4096 - iArr4[i47];
                    iArr4[i50] = 4096 - iArr4[i50];
                    iArr4[i53] = 4096 - iArr4[i53];
                    iArr4[i56] = 4096 - iArr4[i56];
                    iArr4[i59] = 4096 - iArr4[i59];
                    iArr4[i62] = 4096 - iArr4[i62];
                    iArr4[i65] = 4096 - iArr4[i65];
                    i40++;
                    i38 = i44;
                }
                i38++;
            }
            vVar2.b(bArrH);
            f fVar10 = new f(c0937a, 1);
            for (int i66 = 0; i66 < dVarArr.length; i66++) {
                System.arraycopy((int[]) dVarArr[i66].b, 0, (int[]) fVar10.b[i66].b, 0, 256);
            }
            i3 = 0;
            fVar10.c();
            vVar2.c(fVar8, fVar10);
            fVar8.e();
            fVar8.b();
            int i67 = 0;
            while (true) {
                B2.d[] dVarArr6 = fVar8.b;
                if (i67 >= dVarArr6.length) {
                    break;
                }
                B2.d dVar6 = dVarArr6[i67];
                B2.d dVar7 = dVarArr2[i67];
                for (int i68 = 0; i68 < 256; i68++) {
                    int[] iArr5 = (int[]) dVar6.b;
                    iArr5[i68] = iArr5[i68] + ((int[]) dVar7.b)[i68];
                }
                dVar6.getClass();
                i67++;
            }
            fVar8.a();
            fVar8.d(fVar9);
            cVar.i = e.b(fVar8, c0937a);
            cVar.f5154j = null;
        }
        if (dVar != null && !g5.c.g(cVar.i, g5.c.c(dVar.d))) {
            throw new IllegalArgumentException("passed in public key does not match private values");
        }
        cVar.f5155k = cVar.f5154j != null ? i3 : i;
    }

    public final byte[] getEncoded() {
        return g5.c.f(new byte[][]{this.c, this.d, this.e, this.f5151f, this.f5152g, this.f5153h});
    }
}
