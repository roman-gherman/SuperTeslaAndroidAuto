package w3;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class Z extends AbstractC0902u {
    public final /* synthetic */ int c;
    public int d;

    public /* synthetic */ Z(int i) {
        this.c = i;
        switch (i) {
        }
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        switch (this.c) {
            case 0:
                c0898p.p(48, z6);
                X xC = c0898p.c();
                int length = this.f5074a.length;
                int i = 0;
                if (this.d >= 0 || length > 16) {
                    c0898p.k(s());
                    while (i < length) {
                        this.f5074a[i].toASN1Primitive().h().c(xC, true);
                        i++;
                    }
                } else {
                    AbstractC0899q[] abstractC0899qArr = new AbstractC0899q[length];
                    int iE = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        AbstractC0899q abstractC0899qH = this.f5074a[i3].toASN1Primitive().h();
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
                break;
            default:
                c0898p.p(48, z6);
                j0 j0VarD = c0898p.d();
                int length2 = this.f5074a.length;
                int i4 = 0;
                if (this.d >= 0 || length2 > 16) {
                    c0898p.k(t());
                    while (i4 < length2) {
                        j0VarD.q(this.f5074a[i4].toASN1Primitive());
                        i4++;
                    }
                } else {
                    AbstractC0899q[] abstractC0899qArr2 = new AbstractC0899q[length2];
                    int iE2 = 0;
                    for (int i5 = 0; i5 < length2; i5++) {
                        AbstractC0899q abstractC0899qI = this.f5074a[i5].toASN1Primitive().i();
                        abstractC0899qArr2[i5] = abstractC0899qI;
                        iE2 += abstractC0899qI.e(true);
                    }
                    this.d = iE2;
                    c0898p.k(iE2);
                    while (i4 < length2) {
                        j0VarD.q(abstractC0899qArr2[i4]);
                        i4++;
                    }
                }
                break;
        }
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        switch (this.c) {
            case 0:
                return C0898p.f(s(), z6);
            default:
                return C0898p.f(t(), z6);
        }
    }

    @Override // w3.AbstractC0902u, w3.AbstractC0899q
    public AbstractC0899q h() {
        switch (this.c) {
            case 0:
                return this;
            default:
                return super.h();
        }
    }

    @Override // w3.AbstractC0902u, w3.AbstractC0899q
    public final AbstractC0899q i() {
        int i = this.c;
        return this;
    }

    @Override // w3.AbstractC0902u
    public final AbstractC0884b o() {
        switch (this.c) {
            case 0:
                return new M(C0906y.p(j()));
            default:
                return new g0(C0906y.p(j()));
        }
    }

    @Override // w3.AbstractC0902u
    public final N p() {
        switch (this.c) {
            case 0:
                return new N(this, 0);
            default:
                return new N(this, 1);
        }
    }

    @Override // w3.AbstractC0902u
    public final AbstractC0897o q() {
        switch (this.c) {
        }
        return new W(B.k(k()));
    }

    @Override // w3.AbstractC0902u
    public final AbstractC0904w r() {
        switch (this.c) {
        }
        return new k0(this.f5074a);
    }

    public int s() {
        if (this.d < 0) {
            int length = this.f5074a.length;
            int iE = 0;
            for (int i = 0; i < length; i++) {
                iE += this.f5074a[i].toASN1Primitive().h().e(true);
            }
            this.d = iE;
        }
        return this.d;
    }

    public int t() {
        if (this.d < 0) {
            int length = this.f5074a.length;
            int iE = 0;
            for (int i = 0; i < length; i++) {
                iE += this.f5074a[i].toASN1Primitive().i().e(true);
            }
            this.d = iE;
        }
        return this.d;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(C0886d c0886d, int i) {
        super(c0886d);
        this.c = i;
        switch (i) {
            case 1:
                super(c0886d);
                break;
            default:
                this.d = -1;
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Z(C0886d c0886d, boolean z6) {
        super(c0886d);
        this.c = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Z(AbstractC0899q abstractC0899q, int i) {
        super(abstractC0899q);
        this.c = i;
    }

    public Z(ASN1Encodable[] aSN1EncodableArr, int i) {
        this.c = i;
        this.f5074a = aSN1EncodableArr;
    }
}
