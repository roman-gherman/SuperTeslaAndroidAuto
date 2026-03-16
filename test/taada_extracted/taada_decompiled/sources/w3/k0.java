package w3;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 extends AbstractC0904w {
    public int d;

    public k0(ASN1Encodable[] aSN1EncodableArr) {
        super(false, aSN1EncodableArr);
        this.d = -1;
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        c0898p.p(49, z6);
        j0 j0VarD = c0898p.d();
        ASN1Encodable[] aSN1EncodableArr = this.f5075a;
        int length = aSN1EncodableArr.length;
        int i = 0;
        if (this.d >= 0 || length > 16) {
            c0898p.k(l());
            while (i < length) {
                j0VarD.q(aSN1EncodableArr[i].toASN1Primitive());
                i++;
            }
            return;
        }
        AbstractC0899q[] abstractC0899qArr = new AbstractC0899q[length];
        int iE = 0;
        for (int i3 = 0; i3 < length; i3++) {
            AbstractC0899q abstractC0899qI = aSN1EncodableArr[i3].toASN1Primitive().i();
            abstractC0899qArr[i3] = abstractC0899qI;
            iE += abstractC0899qI.e(true);
        }
        this.d = iE;
        c0898p.k(iE);
        while (i < length) {
            j0VarD.q(abstractC0899qArr[i]);
            i++;
        }
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(l(), z6);
    }

    @Override // w3.AbstractC0904w, w3.AbstractC0899q
    public final AbstractC0899q i() {
        return this;
    }

    public final int l() {
        if (this.d < 0) {
            int iE = 0;
            for (ASN1Encodable aSN1Encodable : this.f5075a) {
                iE += aSN1Encodable.toASN1Primitive().i().e(true);
            }
            this.d = iE;
        }
        return this.d;
    }
}
