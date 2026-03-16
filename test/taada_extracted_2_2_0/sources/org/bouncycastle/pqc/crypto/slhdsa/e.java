package org.bouncycastle.pqc.crypto.slhdsa;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final e b = new e(new d(16, 22, 6, 33, 66, 0));
    public static final e c = new e(new d(16, 7, 12, 14, 63, 0));
    public static final e d = new e(new d(24, 22, 8, 33, 66, 0));
    public static final e e = new e(new d(24, 7, 14, 17, 63, 0));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f4390f = new e(new d(32, 17, 9, 35, 68, 0));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f4391g = new e(new d(32, 8, 14, 22, 64, 0));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f4392h = new e(new d(16, 22, 6, 33, 66, 1));
    public static final e i = new e(new d(16, 7, 12, 14, 63, 1));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f4393j = new e(new d(24, 22, 8, 33, 66, 1));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f4394k = new e(new d(24, 7, 14, 17, 63, 1));

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f4395l = new e(new d(32, 17, 9, 35, 68, 1));

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f4396m = new e(new d(32, 8, 14, 22, 64, 1));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f4397n = new e(new d(16, 22, 6, 33, 66, 0));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e f4398o = new e(new d(16, 7, 12, 14, 63, 0));

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e f4399p = new e(new d(24, 22, 8, 33, 66, 0));
    public static final e q = new e(new d(24, 7, 14, 17, 63, 0));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e f4400r = new e(new d(32, 17, 9, 35, 68, 0));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e f4401s = new e(new d(32, 8, 14, 22, 64, 0));

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e f4402t = new e(new d(16, 22, 6, 33, 66, 1));
    public static final e u = new e(new d(16, 7, 12, 14, 63, 1));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e f4403v = new e(new d(24, 22, 8, 33, 66, 1));

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final e f4404w = new e(new d(24, 7, 14, 17, 63, 1));
    public static final e x = new e(new d(32, 17, 9, 35, 68, 1));
    public static final e y = new e(new d(32, 8, 14, 22, 64, 1));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SLHDSAEngineProvider f4405a;

    public e(SLHDSAEngineProvider sLHDSAEngineProvider) {
        this.f4405a = sLHDSAEngineProvider;
    }

    public final int a() {
        return this.f4405a.getN();
    }
}
