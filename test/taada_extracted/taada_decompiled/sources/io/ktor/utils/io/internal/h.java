package io.ktor.utils.io.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3584a;
    public static final K1.f b;
    public static final g c;
    public static final f d;

    static {
        int iJ = t.j(4096, "BufferSize");
        f3584a = iJ;
        int iJ2 = t.j(2048, "BufferPoolSize");
        int iJ3 = t.j(1024, "BufferObjectPoolSize");
        b = new K1.f(iJ2, iJ);
        c = new g(iJ3);
        d = new f();
    }
}
