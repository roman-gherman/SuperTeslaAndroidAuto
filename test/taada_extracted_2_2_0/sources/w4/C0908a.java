package w4;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;

/* JADX INFO: renamed from: w4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0908a implements Digest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExtendedDigest f5079a;
    public final int b;

    public C0908a(int i, ExtendedDigest extendedDigest) {
        this.f5079a = extendedDigest;
        this.b = i;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final int doFinal(byte[] bArr, int i) {
        ExtendedDigest extendedDigest = this.f5079a;
        byte[] bArr2 = new byte[extendedDigest.getDigestSize()];
        extendedDigest.doFinal(bArr2, 0);
        int i3 = this.b;
        System.arraycopy(bArr2, 0, bArr, i, i3);
        return i3;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final String getAlgorithmName() {
        return this.f5079a.getAlgorithmName() + "/" + (this.b * 8);
    }

    @Override // org.bouncycastle.crypto.Digest
    public final int getDigestSize() {
        return this.b;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void reset() {
        this.f5079a.reset();
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void update(byte b) {
        this.f5079a.update(b);
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void update(byte[] bArr, int i, int i3) {
        this.f5079a.update(bArr, i, i3);
    }
}
