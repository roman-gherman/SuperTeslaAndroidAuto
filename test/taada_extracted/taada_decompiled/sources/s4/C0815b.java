package s4;

import N3.g;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: renamed from: s4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0815b extends B4.a {
    public final byte[] c;
    public final byte[] d;
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f4774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f4775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f4776h;
    public final byte[] i;

    public C0815b(C0814a c0814a, byte[] bArr, C0816c c0816c) {
        int i;
        char c;
        int i3;
        super((Object) c0814a, true);
        int i4 = c0814a.f4773a;
        new g(256);
        int i5 = 96;
        if (i4 != 2) {
            i = 5;
            if (i4 == 3) {
                i3 = 6;
                i5 = 128;
            } else {
                if (i4 != 5) {
                    throw new IllegalArgumentException(B2.b.d(i4, "The mode ", "is not supported by Crystals Dilithium!"));
                }
                i3 = 8;
                i = 7;
            }
            c = 0;
        } else {
            i = 4;
            c = 0;
            i3 = 4;
        }
        new g(128);
        new g(256);
        if (c != 0 && c != 0) {
            throw new RuntimeException("Wrong Dilithium Gamma1!");
        }
        this.c = g5.c.h(bArr, 0, 32);
        this.d = g5.c.h(bArr, 32, 64);
        this.e = g5.c.h(bArr, 64, 128);
        int i6 = (i * i5) + 128;
        this.f4774f = g5.c.h(bArr, 128, i6);
        int i7 = (i5 * i3) + i6;
        this.f4775g = g5.c.h(bArr, i6, i7);
        this.f4776h = g5.c.h(bArr, i7, (i3 * TypedValues.CycleType.TYPE_PATH_ROTATE) + i7);
        if (c0816c != null) {
            this.i = g5.c.c(c0816c.d);
        } else {
            this.i = null;
        }
    }

    public final byte[] getEncoded() {
        return g5.c.f(new byte[][]{this.c, this.d, this.e, this.f4774f, this.f4775g, this.f4776h});
    }

    public C0815b(C0814a c0814a, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        super((Object) c0814a, true);
        this.c = g5.c.c(bArr);
        this.d = g5.c.c(bArr2);
        this.e = g5.c.c(bArr3);
        this.f4774f = g5.c.c(bArr4);
        this.f4775g = g5.c.c(bArr5);
        this.f4776h = g5.c.c(bArr6);
        this.i = g5.c.c(bArr7);
    }
}
