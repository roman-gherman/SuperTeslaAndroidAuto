package J4;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f897a;
    public long b = 0;
    public long c = -1;
    public byte[] d = null;
    public byte[] e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f898f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f899g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f900h = null;

    public p(o oVar) {
        this.f897a = oVar;
    }

    public final void a(b bVar) {
        if (bVar.b == 0) {
            this.f900h = new b(bVar, (1 << this.f897a.c) - 1);
        } else {
            this.f900h = bVar;
        }
    }
}
