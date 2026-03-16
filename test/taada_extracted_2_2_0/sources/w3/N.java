package w3;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class N extends AbstractC0899q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0883a f5038g = new C0883a(N.class, 4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0896n f5039a;
    public C0891i b;
    public AbstractC0899q c;
    public int d;
    public AbstractC0899q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5040f;

    public /* synthetic */ N() {
        this.f5040f = 0;
    }

    public static AbstractC0899q k(AbstractC0902u abstractC0902u, int i) {
        if (abstractC0902u.size() > i) {
            return abstractC0902u.m(i).toASN1Primitive();
        }
        throw new IllegalArgumentException("too few objects in input sequence");
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (this == abstractC0899q) {
            return true;
        }
        if (!(abstractC0899q instanceof N)) {
            return false;
        }
        N n6 = (N) abstractC0899q;
        return g5.c.a(this.f5039a, n6.f5039a) && g5.c.a(this.b, n6.b) && g5.c.a(this.c, n6.c) && this.d == n6.d && this.e.f(n6.e);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        c0898p.p(40, z6);
        j().c(c0898p, false);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return true;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return j().e(z6);
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q h() {
        switch (this.f5040f) {
            case 0:
                return this;
            default:
                N n6 = new N();
                n6.f5039a = this.f5039a;
                n6.b = this.b;
                n6.c = this.c;
                int i = this.d;
                if (i < 0 || i > 2) {
                    throw new IllegalArgumentException(B2.b.c(i, "invalid encoding value: "));
                }
                n6.d = i;
                AbstractC0899q abstractC0899q = this.e;
                if (i != 1) {
                    if (i == 2 && !AbstractC0884b.class.isInstance(abstractC0899q)) {
                        throw new IllegalStateException("unexpected object: ".concat(abstractC0899q.getClass().getName()));
                    }
                } else if (!AbstractC0897o.class.isInstance(abstractC0899q)) {
                    throw new IllegalStateException("unexpected object: ".concat(abstractC0899q.getClass().getName()));
                }
                n6.e = abstractC0899q;
                return n6;
        }
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return (((g5.c.j(this.f5039a) ^ g5.c.j(this.b)) ^ g5.c.j(this.c)) ^ this.d) ^ this.e.hashCode();
    }

    @Override // w3.AbstractC0899q
    public final AbstractC0899q i() {
        int i = this.f5040f;
        return this;
    }

    public final AbstractC0902u j() {
        switch (this.f5040f) {
            case 0:
                C0886d c0886d = new C0886d(4);
                C0896n c0896n = this.f5039a;
                if (c0896n != null) {
                    c0886d.a(c0896n);
                }
                C0891i c0891i = this.b;
                if (c0891i != null) {
                    c0886d.a(c0891i);
                }
                AbstractC0899q abstractC0899q = this.c;
                if (abstractC0899q != null) {
                    c0886d.a(abstractC0899q.h());
                }
                int i = this.d;
                c0886d.a(new H(i == 0, i, this.e, 1));
                Z z6 = new Z(c0886d, false);
                z6.d = -1;
                return z6;
            default:
                C0886d c0886d2 = new C0886d(4);
                C0896n c0896n2 = this.f5039a;
                if (c0896n2 != null) {
                    c0886d2.a(c0896n2);
                }
                C0891i c0891i2 = this.b;
                if (c0891i2 != null) {
                    c0886d2.a(c0891i2);
                }
                AbstractC0899q abstractC0899q2 = this.c;
                if (abstractC0899q2 != null) {
                    c0886d2.a(abstractC0899q2.i());
                }
                int i3 = this.d;
                c0886d2.a(new H(i3 == 0, i3, this.e, 2));
                Z z7 = new Z(c0886d2, 1);
                z7.d = -1;
                return z7;
        }
    }

    public N(AbstractC0902u abstractC0902u, int i) {
        int i3;
        AbstractC0899q aSN1Primitive;
        this.f5040f = i;
        AbstractC0899q abstractC0899qK = k(abstractC0902u, 0);
        if (abstractC0899qK instanceof C0896n) {
            this.f5039a = (C0896n) abstractC0899qK;
            abstractC0899qK = k(abstractC0902u, 1);
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (abstractC0899qK instanceof C0891i) {
            this.b = (C0891i) abstractC0899qK;
            i3++;
            abstractC0899qK = k(abstractC0902u, i3);
        }
        if (!(abstractC0899qK instanceof H)) {
            this.c = abstractC0899qK;
            i3++;
            abstractC0899qK = k(abstractC0902u, i3);
        }
        if (abstractC0902u.size() != i3 + 1) {
            throw new IllegalArgumentException("input sequence too large");
        }
        if (!(abstractC0899qK instanceof H)) {
            throw new IllegalArgumentException("No tagged object found in sequence. Structure doesn't seem to be of type External");
        }
        H h3 = (H) abstractC0899qK;
        int i4 = h3.c;
        if (i4 < 0 || i4 > 2) {
            throw new IllegalArgumentException(B2.b.c(i4, "invalid encoding value: "));
        }
        this.d = i4;
        io.ktor.utils.io.internal.t.e(h3);
        int i5 = h3.c;
        if (i5 != 0) {
            if (i5 == 1) {
                C0883a c0883a = AbstractC0897o.b;
                io.ktor.utils.io.internal.t.e(h3);
                AbstractC0899q abstractC0899qK2 = h3.k(false, c0883a);
                c0883a.a(abstractC0899qK2);
                aSN1Primitive = (AbstractC0897o) abstractC0899qK2;
            } else {
                if (i5 != 2) {
                    throw new IllegalArgumentException("invalid tag: " + io.ktor.utils.io.internal.t.k(h3.b, i5));
                }
                C0883a c0883a2 = AbstractC0884b.b;
                io.ktor.utils.io.internal.t.e(h3);
                AbstractC0899q abstractC0899qK3 = h3.k(false, c0883a2);
                c0883a2.a(abstractC0899qK3);
                aSN1Primitive = (AbstractC0884b) abstractC0899qK3;
            }
        } else {
            if (!h3.m()) {
                throw new IllegalStateException("object implicit - explicit expected.");
            }
            ASN1Encodable aSN1Encodable = h3.d;
            aSN1Primitive = (aSN1Encodable instanceof AbstractC0893k ? (AbstractC0893k) aSN1Encodable : aSN1Encodable.toASN1Primitive()).toASN1Primitive();
        }
        this.e = aSN1Primitive;
    }
}
