package N3;

import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.Xof;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a implements Xof {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i) {
        super(i, 0);
        if (i != 128 && i != 256) {
            throw new IllegalArgumentException(B2.b.d(i, "'bitStrength' ", " not supported for SHAKE"));
        }
    }

    @Override // N3.a
    public final CryptoServiceProperties d() {
        return new M3.a(getDigestSize() * 4, getAlgorithmName(), this.f1146a);
    }

    @Override // N3.a, org.bouncycastle.crypto.Digest
    public final int doFinal(byte[] bArr, int i) {
        int i3 = this.f1147f / 4;
        doFinal(bArr, i, i3);
        return i3;
    }

    @Override // org.bouncycastle.crypto.Xof
    public final int doOutput(byte[] bArr, int i, int i3) {
        if (!this.f1148g) {
            c(15, 4);
        }
        f(bArr, i, ((long) i3) * 8);
        return i3;
    }

    @Override // N3.a, org.bouncycastle.crypto.Digest
    public final String getAlgorithmName() {
        return "SHAKE" + this.f1147f;
    }

    @Override // N3.a, org.bouncycastle.crypto.Digest
    public final int getDigestSize() {
        return this.f1147f / 4;
    }

    @Override // org.bouncycastle.crypto.Xof
    public final int doFinal(byte[] bArr, int i, int i3) {
        doOutput(bArr, i, i3);
        reset();
        return i3;
    }
}
