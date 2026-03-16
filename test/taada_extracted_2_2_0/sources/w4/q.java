package w4;

import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5103a;
    public final byte[] b;
    public final Digest c;
    public int d;
    public int e;

    public q(byte[] bArr, byte[] bArr2, Digest digest) {
        this.f5103a = bArr;
        this.b = bArr2;
        this.c = digest;
    }

    public final void a(byte[] bArr, int i, boolean z6) {
        int length = bArr.length - i;
        Digest digest = this.c;
        if (length < digest.getDigestSize()) {
            throw new IllegalArgumentException("target length is less than digest size.");
        }
        byte[] bArr2 = this.f5103a;
        digest.update(bArr2, 0, bArr2.length);
        digest.update((byte) (this.d >>> 24));
        digest.update((byte) (this.d >>> 16));
        digest.update((byte) (this.d >>> 8));
        digest.update((byte) this.d);
        digest.update((byte) (this.e >>> 8));
        digest.update((byte) this.e);
        digest.update((byte) -1);
        byte[] bArr3 = this.b;
        digest.update(bArr3, 0, bArr3.length);
        digest.doFinal(bArr, i);
        if (z6) {
            this.e++;
        }
    }
}
