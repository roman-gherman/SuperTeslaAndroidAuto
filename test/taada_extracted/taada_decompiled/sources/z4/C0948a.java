package z4;

import C0.t;

/* JADX INFO: renamed from: z4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0948a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5205a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t f5208h;

    public C0948a(int i) {
        this.b = i;
        if (i == 2) {
            this.d = 3;
        } else {
            if (i != 3 && i != 4) {
                throw new IllegalArgumentException(B2.b.d(i, "K: ", " is not supported for Crystals Kyber"));
            }
            this.d = 2;
        }
        int i3 = i * 384;
        this.c = i3;
        int i4 = i3 + 32;
        this.e = i4;
        this.f5206f = i3;
        this.f5207g = i4;
        this.f5208h = new t(21);
        this.f5205a = new b(this);
    }
}
