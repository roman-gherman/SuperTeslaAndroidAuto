package N3;

import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends b {
    public f() {
        L3.h.a(C5.f.D(this, 256, L3.c.d));
        reset();
    }

    @Override // org.bouncycastle.util.Memoable
    public final Memoable copy() {
        f fVar = new f(this);
        L3.h.a(C5.f.D(fVar, 256, fVar.f1150a));
        return fVar;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final int doFinal(byte[] bArr, int i) {
        f();
        g5.c.t(bArr, i, this.f1151f);
        g5.c.t(bArr, i + 8, this.f1152g);
        g5.c.t(bArr, i + 16, this.f1153h);
        g5.c.t(bArr, i + 24, this.i);
        g5.c.t(bArr, i + 32, this.f1154j);
        g5.c.t(bArr, i + 40, this.f1155k);
        g5.c.t(bArr, i + 48, this.f1156l);
        g5.c.t(bArr, i + 56, this.f1157m);
        reset();
        return 64;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final String getAlgorithmName() {
        return "SHA-512";
    }

    @Override // org.bouncycastle.crypto.Digest
    public final int getDigestSize() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest
    public final byte[] getEncodedState() {
        int i = this.f1159o * 8;
        int i3 = i + 96;
        byte[] bArr = new byte[i + 97];
        g(bArr);
        bArr[i3] = (byte) this.f1150a.ordinal();
        return bArr;
    }

    @Override // N3.b, org.bouncycastle.crypto.Digest
    public final void reset() {
        super.reset();
        this.f1151f = 7640891576956012808L;
        this.f1152g = -4942790177534073029L;
        this.f1153h = 4354685564936845355L;
        this.i = -6534734903238641935L;
        this.f1154j = 5840696475078001361L;
        this.f1155k = -7276294671716946913L;
        this.f1156l = 2270897969802886507L;
        this.f1157m = 6620516959819538809L;
    }

    @Override // org.bouncycastle.util.Memoable
    public final void reset(Memoable memoable) {
        e((f) memoable);
    }
}
