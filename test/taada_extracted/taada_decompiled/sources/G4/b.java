package G4;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Q3.a {
    public final byte[] b;
    public final a c;

    public b(a aVar, byte[] bArr) {
        super(true);
        this.b = g5.c.c(bArr);
        this.c = aVar;
    }

    public final a a() {
        return this.c;
    }

    public final byte[] getEncoded() {
        return g5.c.c(this.b);
    }
}
