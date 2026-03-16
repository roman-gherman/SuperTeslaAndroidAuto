package w4;

import com.android.billingclient.api.A;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Digest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5088a;
    public final A b;
    public final p c;
    public final byte[][] d;
    public final g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f5089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o[] f5090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Digest f5091h;

    public i(A a6, p pVar, Digest digest, byte[] bArr, byte[][] bArr2) {
        this.b = a6;
        this.c = pVar;
        this.f5091h = digest;
        this.f5088a = bArr;
        this.d = bArr2;
        this.e = null;
        this.f5089f = null;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final int doFinal(byte[] bArr, int i) {
        return this.f5091h.doFinal(bArr, i);
    }

    @Override // org.bouncycastle.crypto.Digest
    public final String getAlgorithmName() {
        return this.f5091h.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.Digest
    public final int getDigestSize() {
        return this.f5091h.getDigestSize();
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void reset() {
        this.f5091h.reset();
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void update(byte b) {
        this.f5091h.update(b);
    }

    public i(g gVar, n nVar, Digest digest) {
        this.e = gVar;
        this.f5089f = nVar;
        this.f5091h = digest;
        this.f5088a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    @Override // org.bouncycastle.crypto.Digest
    public final void update(byte[] bArr, int i, int i3) {
        this.f5091h.update(bArr, i, i3);
    }
}
