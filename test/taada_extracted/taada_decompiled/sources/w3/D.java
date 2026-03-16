package w3;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends AbstractC0902u {
    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        c0898p.n(z6, 48, this.f5073a);
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        int iE = z6 ? 4 : 3;
        int length = this.f5073a.length;
        for (int i = 0; i < length; i++) {
            iE += this.f5073a[i].toASN1Primitive().e(true);
        }
        return iE;
    }

    @Override // w3.AbstractC0902u
    public final AbstractC0884b o() {
        return new C0906y(j());
    }

    @Override // w3.AbstractC0902u
    public final N p() {
        return ((AbstractC0902u) i()).p();
    }

    @Override // w3.AbstractC0902u
    public final AbstractC0897o q() {
        AbstractC0897o[] abstractC0897oArrK = k();
        return new B(B.k(abstractC0897oArrK), abstractC0897oArrK);
    }

    @Override // w3.AbstractC0902u
    public final AbstractC0904w r() {
        return new F(false, this.f5073a);
    }
}
