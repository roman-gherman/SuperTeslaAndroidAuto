package F4;

import L3.h;
import N3.e;
import N3.f;
import N3.g;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.KEMParameters;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements KEMParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f364a = new a(false);
    public static final a b = new a(false);
    public static final a c = new a(false);
    public static final a d = new a(false);
    public static final a e = new a(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f365f = new a(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f366g = new a(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f367h = new a(false);
    public static final a i = new a(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f368j = new a(true);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f369k = new a(true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f370l = new a(true);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f371m = new a(false);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f372n = new a(false);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f373o = new a(false);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f374p = new a(true);
    public static final a q = new a(true);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f375r = new a(true);

    public a(boolean z6) {
        if (z6) {
            new N3.c();
            new f();
            h.a(new M3.a(256, (CipherParameters) null, L3.c.d));
        } else {
            new g(128);
            new e(256);
            new e(512);
        }
    }
}
