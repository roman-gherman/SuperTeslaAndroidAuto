package z4;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends B4.a {
    public final byte[] c;
    public final byte[] d;

    public e(c cVar, byte[] bArr) {
        super((Object) cVar, false);
        this.c = g5.c.h(bArr, 0, bArr.length - 32);
        this.d = g5.c.h(bArr, bArr.length - 32, bArr.length);
    }

    public final byte[] getEncoded() {
        return g5.c.e(this.c, this.d);
    }

    public e(c cVar, byte[] bArr, byte[] bArr2) {
        super((Object) cVar, false);
        this.c = g5.c.c(bArr);
        this.d = g5.c.c(bArr2);
    }
}
