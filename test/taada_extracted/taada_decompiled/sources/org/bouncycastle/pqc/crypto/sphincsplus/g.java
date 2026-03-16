package org.bouncycastle.pqc.crypto.sphincsplus;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends B4.a {
    public final h5.c c;

    public g(e eVar, byte[] bArr) {
        super((Object) eVar, false);
        int n6 = eVar.c.getN();
        int i = n6 * 2;
        if (bArr.length != i) {
            throw new IllegalArgumentException("public key encoding does not match parameters");
        }
        this.c = new h5.c(g5.c.h(bArr, 0, n6), g5.c.h(bArr, n6, i));
    }
}
