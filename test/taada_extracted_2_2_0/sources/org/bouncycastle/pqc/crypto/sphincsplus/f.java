package org.bouncycastle.pqc.crypto.sphincsplus;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends B4.a {
    public final h5.c c;
    public final h5.c d;

    public f(e eVar, byte[] bArr) {
        super((Object) eVar, true);
        int n6 = eVar.c.getN();
        int i = n6 * 4;
        if (bArr.length != i) {
            throw new IllegalArgumentException("private key encoding does not match parameters");
        }
        int i3 = n6 * 2;
        this.c = new h5.c(g5.c.h(bArr, 0, n6), g5.c.h(bArr, n6, i3));
        int i4 = n6 * 3;
        this.d = new h5.c(g5.c.h(bArr, i3, i4), g5.c.h(bArr, i4, i));
    }

    public final byte[] getEncoded() {
        h5.c cVar = this.c;
        byte[] bArr = cVar.f3461a;
        byte[] bArr2 = cVar.b;
        h5.c cVar2 = this.d;
        return g5.c.f(new byte[][]{bArr, bArr2, cVar2.f3461a, cVar2.b});
    }

    public f(e eVar, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super((Object) eVar, true);
        this.c = new h5.c(bArr, bArr2);
        this.d = new h5.c(bArr3, bArr4);
    }
}
