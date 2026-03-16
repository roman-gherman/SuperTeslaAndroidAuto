package w3;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class F extends AbstractC0904w {
    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        c0898p.n(z6, 49, this.f5075a);
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        int iE = z6 ? 4 : 3;
        for (ASN1Encodable aSN1Encodable : this.f5075a) {
            iE += aSN1Encodable.toASN1Primitive().e(true);
        }
        return iE;
    }
}
