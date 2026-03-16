package C4;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends B4.a {
    public final byte[] c;
    public final byte[] d;

    public c(a aVar, byte[] bArr) {
        super((Object) aVar, false);
        byte[] bArrH = g5.c.h(bArr, 0, 32);
        this.c = bArrH;
        this.d = g5.c.h(bArr, bArrH.length, bArr.length);
    }
}
