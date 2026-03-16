package J4;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends n {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f892g;

    public k(i iVar) {
        super(iVar);
        this.e = iVar.e;
        this.f891f = iVar.f887f;
        this.f892g = iVar.f888g;
    }

    @Override // J4.n
    public final byte[] a() {
        byte[] bArrA = super.a();
        g5.c.o(bArrA, this.e, 16);
        g5.c.o(bArrA, this.f891f, 20);
        g5.c.o(bArrA, this.f892g, 24);
        return bArrA;
    }
}
