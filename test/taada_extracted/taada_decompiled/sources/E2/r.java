package E2;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final r f313k = new r(false, false, false, false, false, new r(false, false, false, false, false, null, false, null, null, 1023), false, null, null, 988);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f314a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r f317h;
    public final r i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f318j;

    public r(boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, r rVar, boolean z11, r rVar2, r rVar3, int i) {
        z6 = (i & 1) != 0 ? true : z6;
        z7 = (i & 2) != 0 ? true : z7;
        z8 = (i & 4) != 0 ? false : z8;
        z9 = (i & 8) != 0 ? false : z9;
        z10 = (i & 16) != 0 ? false : z10;
        rVar = (i & 32) != 0 ? null : rVar;
        z11 = (i & 64) != 0 ? true : z11;
        rVar2 = (i & 128) != 0 ? rVar : rVar2;
        rVar3 = (i & 256) != 0 ? rVar : rVar3;
        boolean z12 = (i & 512) == 0;
        this.f314a = z6;
        this.b = z7;
        this.c = z8;
        this.d = z9;
        this.e = z10;
        this.f315f = rVar;
        this.f316g = z11;
        this.f317h = rVar2;
        this.i = rVar3;
        this.f318j = z12;
    }
}
