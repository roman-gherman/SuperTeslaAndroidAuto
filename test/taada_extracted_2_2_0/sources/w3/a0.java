package w3;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends AbstractC0904w {
    public int d;

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        c0898p.p(49, z6);
        X xC = c0898p.c();
        ASN1Encodable[] aSN1EncodableArr = this.f5076a;
        int length = aSN1EncodableArr.length;
        int i = 0;
        if (this.d >= 0 || length > 16) {
            c0898p.k(l());
            while (i < length) {
                aSN1EncodableArr[i].toASN1Primitive().h().c(xC, true);
                i++;
            }
            return;
        }
        AbstractC0899q[] abstractC0899qArr = new AbstractC0899q[length];
        int iE = 0;
        for (int i3 = 0; i3 < length; i3++) {
            AbstractC0899q abstractC0899qH = aSN1EncodableArr[i3].toASN1Primitive().h();
            abstractC0899qArr[i3] = abstractC0899qH;
            iE += abstractC0899qH.e(true);
        }
        this.d = iE;
        c0898p.k(iE);
        while (i < length) {
            abstractC0899qArr[i].c(xC, true);
            i++;
        }
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(l(), z6);
    }

    @Override // w3.AbstractC0904w, w3.AbstractC0899q
    public final AbstractC0899q h() {
        return this.b != null ? this : super.h();
    }

    @Override // w3.AbstractC0904w, w3.AbstractC0899q
    public final AbstractC0899q i() {
        return this;
    }

    public final int l() {
        if (this.d < 0) {
            int iE = 0;
            for (ASN1Encodable aSN1Encodable : this.f5076a) {
                iE += aSN1Encodable.toASN1Primitive().h().e(true);
            }
            this.d = iE;
        }
        return this.d;
    }
}
