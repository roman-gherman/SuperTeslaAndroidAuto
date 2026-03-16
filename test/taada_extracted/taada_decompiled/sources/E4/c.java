package E4;

import C5.f;
import L3.h;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements CipherParameters {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f322h = new c(3, 1);
    public static final c i = new c(3, 2);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f323j = new c(3, 3);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f324k = new c(5, 1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f325l = new c(5, 2);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f326m = new c(5, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f327a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final N3.b f328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f329g;

    public c(int i3, int i4) {
        if (i3 == 3) {
            this.f327a = 68;
            this.b = 32;
            this.c = 48;
            N3.d dVar = new N3.d();
            h.a(f.D(dVar, 256, L3.c.d));
            dVar.reset();
            this.f328f = dVar;
        } else {
            if (i3 != 5) {
                throw new IllegalArgumentException("No valid version. Please choose one of the following: 3, 5");
            }
            this.f327a = 96;
            this.b = 36;
            this.c = 64;
            this.f328f = new N3.f();
        }
        int i5 = this.f327a;
        int i6 = this.b;
        int i7 = this.c;
        this.d = i5 + i6 + i7;
        this.e = i6 + i7;
        this.f329g = i4;
    }
}
