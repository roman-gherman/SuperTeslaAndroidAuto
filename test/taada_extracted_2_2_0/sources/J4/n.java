package J4;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f895a;
    public long b;
    public int c;
    public int d;

    public n(int i) {
        this.c = 0;
        this.b = 0L;
        this.d = 0;
        this.f895a = i;
    }

    public byte[] a() {
        byte[] bArr = new byte[32];
        g5.c.o(bArr, this.f895a, 0);
        g5.c.t(bArr, 4, this.b);
        g5.c.o(bArr, this.c, 12);
        g5.c.o(bArr, this.d, 28);
        return bArr;
    }

    public n(n nVar) {
        this.f895a = nVar.c;
        this.b = nVar.b;
        this.c = nVar.f895a;
        this.d = nVar.d;
    }
}
