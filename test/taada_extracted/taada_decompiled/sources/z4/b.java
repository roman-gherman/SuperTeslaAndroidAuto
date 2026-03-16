package z4;

import C0.t;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0948a f5209a;
    public final int b;
    public final int c;
    public final int d;
    public final t e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5210f;

    public b(C0948a c0948a) {
        this.f5209a = c0948a;
        this.b = c0948a.b;
        this.c = c0948a.f5207g;
        this.d = c0948a.c;
        t tVar = c0948a.f5208h;
        this.e = tVar;
        tVar.getClass();
        this.f5210f = 3;
    }

    public static int a(M3.a aVar, int i, int i3, byte[] bArr, int i4) {
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            int i7 = i6 + 3;
            if (i7 > i4) {
                break;
            }
            short s3 = (short) (bArr[i6] & 255);
            short s6 = (short) (bArr[i6 + 1] & 255);
            short s7 = (short) ((s3 | (s6 << 8)) & 4095);
            short s8 = (short) (((((short) (bArr[i6 + 2] & 255)) << 4) | (s6 >> 4)) & 4095);
            if (s7 < 3329) {
                ((short[]) aVar.d)[i + i5] = s7;
                i5++;
            }
            if (i5 < i3 && s8 < 3329) {
                ((short[]) aVar.d)[i + i5] = s8;
                i5++;
            }
            i6 = i7;
        }
        return i5;
    }
}
