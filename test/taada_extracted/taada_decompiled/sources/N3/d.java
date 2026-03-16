package N3;

import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b {
    @Override // org.bouncycastle.util.Memoable
    public final Memoable copy() {
        d dVar = new d(this);
        L3.h.a(C5.f.D(dVar, 256, dVar.f1150a));
        return dVar;
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
        reset();
        return 48;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final String getAlgorithmName() {
        return "SHA-384";
    }

    @Override // org.bouncycastle.crypto.Digest
    public final int getDigestSize() {
        return 48;
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
        this.f1151f = -3766243637369397544L;
        this.f1152g = 7105036623409894663L;
        this.f1153h = -7973340178411365097L;
        this.i = 1526699215303891257L;
        this.f1154j = 7436329637833083697L;
        this.f1155k = -8163818279084223215L;
        this.f1156l = -2662702644619276377L;
        this.f1157m = 5167115440072839076L;
    }

    @Override // org.bouncycastle.util.Memoable
    public final void reset(Memoable memoable) {
        e((d) memoable);
    }
}
