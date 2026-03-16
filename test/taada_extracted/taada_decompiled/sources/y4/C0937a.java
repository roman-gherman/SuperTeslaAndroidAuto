package y4;

import B.h;
import N3.g;

/* JADX INFO: renamed from: y4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0937a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f5142a = new g(256);
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f5145h;

    public C0937a(int i) {
        int i3;
        if (i == 2) {
            this.c = 4;
            this.d = 4;
            this.e = 2;
            this.f5143f = 131072;
        } else {
            if (i == 3) {
                this.c = 6;
                this.d = 5;
                this.e = 4;
                this.f5143f = 524288;
                this.b = 128;
                this.f5145h = new h(29);
                this.f5144g = (this.c * 320) + 32;
                i3 = this.f5143f;
                if (i3 != 131072 && i3 != 524288) {
                    throw new RuntimeException("Wrong Dilithium Gamma1!");
                }
                return;
            }
            if (i != 5) {
                throw new IllegalArgumentException(B2.b.d(i, "The mode ", "is not supported by Crystals Dilithium!"));
            }
            this.c = 8;
            this.d = 7;
            this.e = 2;
            this.f5143f = 524288;
        }
        this.b = 96;
        this.f5145h = new h(29);
        this.f5144g = (this.c * 320) + 32;
        i3 = this.f5143f;
        if (i3 != 131072) {
            throw new RuntimeException("Wrong Dilithium Gamma1!");
        }
    }
}
