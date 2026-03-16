package N3;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i) {
        super(i, 0);
        if (i != 224 && i != 256 && i != 384 && i != 512) {
            throw new IllegalArgumentException(B2.b.d(i, "'bitLength' ", " not supported for SHA-3"));
        }
    }

    @Override // N3.a, org.bouncycastle.crypto.Digest
    public final int doFinal(byte[] bArr, int i) {
        c(2, 2);
        return super.doFinal(bArr, i);
    }

    @Override // N3.a, org.bouncycastle.crypto.Digest
    public final String getAlgorithmName() {
        return "SHA3-" + this.f1147f;
    }
}
