package w3;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 extends AbstractC0902u {
    public byte[] c;

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        byte[] bArr;
        synchronized (this) {
            bArr = this.c;
        }
        if (bArr != null) {
            c0898p.m(bArr, 48, z6);
        } else {
            super.i().c(c0898p, z6);
        }
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        byte[] bArr;
        synchronized (this) {
            bArr = this.c;
        }
        return bArr != null ? C0898p.f(bArr.length, z6) : super.i().e(z6);
    }

    @Override // w3.AbstractC0902u, w3.AbstractC0899q
    public final AbstractC0899q h() {
        s();
        return super.h();
    }

    @Override // w3.AbstractC0902u, w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        s();
        return super.hashCode();
    }

    @Override // w3.AbstractC0902u, w3.AbstractC0899q
    public final AbstractC0899q i() {
        s();
        return super.i();
    }

    @Override // w3.AbstractC0902u, org.bouncycastle.util.Iterable, java.lang.Iterable
    public final Iterator iterator() {
        s();
        return super.iterator();
    }

    @Override // w3.AbstractC0902u
    public final ASN1Encodable m(int i) {
        s();
        return this.f5073a[i];
    }

    @Override // w3.AbstractC0902u
    public final Enumeration n() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.c;
        }
        if (bArr == null) {
            return new C0900s(this);
        }
        o0 o0Var = new o0();
        o0Var.f5067a = new C0890h(bArr);
        o0Var.b = o0Var.a();
        return o0Var;
    }

    @Override // w3.AbstractC0902u
    public final AbstractC0884b o() {
        return ((AbstractC0902u) i()).o();
    }

    @Override // w3.AbstractC0902u
    public final N p() {
        return ((AbstractC0902u) i()).p();
    }

    @Override // w3.AbstractC0902u
    public final AbstractC0897o q() {
        return ((AbstractC0902u) i()).q();
    }

    @Override // w3.AbstractC0902u
    public final AbstractC0904w r() {
        return ((AbstractC0902u) i()).r();
    }

    public final synchronized void s() {
        C0886d c0886d;
        if (this.c != null) {
            C0890h c0890h = new C0890h(this.c);
            try {
                AbstractC0899q abstractC0899qF = c0890h.f();
                if (abstractC0899qF == null) {
                    c0886d = new C0886d(0);
                } else {
                    C0886d c0886d2 = new C0886d();
                    do {
                        c0886d2.a(abstractC0899qF);
                        abstractC0899qF = c0890h.f();
                    } while (abstractC0899qF != null);
                    c0886d = c0886d2;
                }
                c0890h.close();
                this.f5073a = c0886d.c();
                this.c = null;
            } catch (IOException e) {
                throw new h5.a("malformed ASN.1: " + e, e);
            }
        }
    }

    @Override // w3.AbstractC0902u
    public final int size() {
        s();
        return this.f5073a.length;
    }
}
