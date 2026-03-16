package J4;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends n {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f886f;

    public h(g gVar) {
        super(gVar);
        this.e = gVar.e;
        this.f886f = gVar.f885f;
    }

    @Override // J4.n
    public final byte[] a() {
        byte[] bArrA = super.a();
        g5.c.o(bArrA, 0, 16);
        g5.c.o(bArrA, this.e, 20);
        g5.c.o(bArrA, this.f886f, 24);
        return bArrA;
    }
}
