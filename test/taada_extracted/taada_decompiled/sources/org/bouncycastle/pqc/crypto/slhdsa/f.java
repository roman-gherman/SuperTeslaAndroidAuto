package org.bouncycastle.pqc.crypto.slhdsa;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends B4.a {
    public final h5.c c;
    public final h5.c d;

    public f(e eVar, byte[] bArr) {
        super((Object) eVar, true);
        int n6 = eVar.f4404a.getN();
        int i = n6 * 4;
        if (bArr.length != i) {
            throw new IllegalArgumentException("private key encoding does not match parameters");
        }
        int i3 = n6 * 2;
        this.c = new h5.c(g5.c.h(bArr, 0, n6), g5.c.h(bArr, n6, i3));
        int i4 = n6 * 3;
        this.d = new h5.c(g5.c.h(bArr, i3, i4), g5.c.h(bArr, i4, i));
    }
}
