package w3;

import fr.sd.taada.proto.KeyCode;
import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

/* JADX INFO: loaded from: classes2.dex */
public final class H extends AbstractC0899q implements ASN1TaggedObjectParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5032a;
    public final int b;
    public final int c;
    public final ASN1Encodable d;
    public final /* synthetic */ int e;

    public H(int i, int i3, int i4, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null) {
            throw new NullPointerException("'obj' cannot be null");
        }
        if (i3 == 0 || (i3 & 192) != i3) {
            throw new IllegalArgumentException(B2.b.c(i3, "invalid tag class: "));
        }
        this.f5032a = aSN1Encodable instanceof ASN1Choice ? 1 : i;
        this.b = i3;
        this.c = i4;
        this.d = aSN1Encodable;
    }

    public static H j(AbstractC0899q abstractC0899q) {
        if (abstractC0899q instanceof H) {
            return (H) abstractC0899q;
        }
        throw new IllegalStateException("unexpected object: ".concat(abstractC0899q.getClass().getName()));
    }

    public static H l(Object obj) {
        if (obj == null || (obj instanceof H)) {
            return (H) obj;
        }
        if (obj instanceof ASN1Encodable) {
            AbstractC0899q aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof H) {
                return (H) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return j(AbstractC0899q.g((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(obj.getClass().getName()));
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof H)) {
            return false;
        }
        H h3 = (H) abstractC0899q;
        if (this.c != h3.c || this.b != h3.b) {
            return false;
        }
        if (this.f5032a != h3.f5032a && m() != h3.m()) {
            return false;
        }
        AbstractC0899q aSN1Primitive = this.d.toASN1Primitive();
        AbstractC0899q aSN1Primitive2 = h3.d.toASN1Primitive();
        if (aSN1Primitive == aSN1Primitive2) {
            return true;
        }
        if (m()) {
            return aSN1Primitive.b(aSN1Primitive2);
        }
        try {
            return Arrays.equals(getEncoded(), h3.getEncoded());
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        switch (this.e) {
            case 0:
                AbstractC0899q aSN1Primitive = this.d.toASN1Primitive();
                boolean zM = m();
                if (z6) {
                    int i = this.b;
                    if (zM || aSN1Primitive.d()) {
                        i |= 32;
                    }
                    c0898p.o(i, this.c);
                }
                if (!zM) {
                    aSN1Primitive.c(c0898p, false);
                } else {
                    c0898p.i(128);
                    aSN1Primitive.c(c0898p, true);
                    c0898p.i(0);
                    c0898p.i(0);
                }
                break;
            case 1:
                AbstractC0899q abstractC0899qH = this.d.toASN1Primitive().h();
                boolean zM2 = m();
                if (z6) {
                    int i3 = this.b;
                    if (zM2 || abstractC0899qH.d()) {
                        i3 |= 32;
                    }
                    c0898p.o(i3, this.c);
                }
                if (zM2) {
                    c0898p.k(abstractC0899qH.e(true));
                }
                abstractC0899qH.c(c0898p.c(), zM2);
                break;
            default:
                AbstractC0899q abstractC0899qI = this.d.toASN1Primitive().i();
                boolean zM3 = m();
                if (z6) {
                    int i4 = this.b;
                    if (zM3 || abstractC0899qI.d()) {
                        i4 |= 32;
                    }
                    c0898p.o(i4, this.c);
                }
                if (zM3) {
                    c0898p.k(abstractC0899qI.e(true));
                }
                abstractC0899qI.c(c0898p.d(), zM3);
                break;
        }
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        switch (this.e) {
            case 0:
                if (m() || this.d.toASN1Primitive().d()) {
                }
                break;
            case 1:
                if (m() || this.d.toASN1Primitive().h().d()) {
                }
                break;
            default:
                if (m() || this.d.toASN1Primitive().i().d()) {
                }
                break;
        }
        return true;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        switch (this.e) {
            case 0:
                AbstractC0899q aSN1Primitive = this.d.toASN1Primitive();
                boolean zM = m();
                int iE = aSN1Primitive.e(zM);
                if (zM) {
                    iE += 3;
                }
                return iE + (z6 ? C0898p.g(this.c) : 0);
            case 1:
                AbstractC0899q abstractC0899qH = this.d.toASN1Primitive().h();
                boolean zM2 = m();
                int iE2 = abstractC0899qH.e(zM2);
                if (zM2) {
                    iE2 += C0898p.e(iE2);
                }
                return iE2 + (z6 ? C0898p.g(this.c) : 0);
            default:
                AbstractC0899q abstractC0899qI = this.d.toASN1Primitive().i();
                boolean zM3 = m();
                int iE3 = abstractC0899qI.e(zM3);
                if (zM3) {
                    iE3 += C0898p.e(iE3);
                }
                return iE3 + (z6 ? C0898p.g(this.c) : 0);
        }
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final int getTagClass() {
        return this.b;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final int getTagNo() {
        return this.c;
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q h() {
        switch (this.e) {
            case 1:
                return this;
            default:
                return new H(this.f5032a, this.b, this.c, this.d, 1);
        }
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final boolean hasContextTag() {
        return this.b == 128;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final boolean hasTag(int i, int i3) {
        return this.b == i && this.c == i3;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final boolean hasTagClass(int i) {
        return this.b == i;
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return (((this.b * 7919) ^ this.c) ^ (m() ? 15 : KeyCode.KEYCODE_TV_SATELLITE_SERVICE_VALUE)) ^ this.d.toASN1Primitive().hashCode();
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q i() {
        switch (this.e) {
            case 1:
            case 2:
                return this;
            default:
                return new H(this.f5032a, this.b, this.c, this.d, 2);
        }
    }

    public final AbstractC0899q k(boolean z6, C0.d dVar) {
        AbstractC0902u d;
        ASN1Encodable aSN1Encodable = this.d;
        if (z6) {
            if (!m()) {
                throw new IllegalStateException("object implicit - explicit expected.");
            }
            AbstractC0899q aSN1Primitive = aSN1Encodable.toASN1Primitive();
            dVar.a(aSN1Primitive);
            return aSN1Primitive;
        }
        int i = this.f5032a;
        if (1 == i) {
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        AbstractC0899q aSN1Primitive2 = aSN1Encodable.toASN1Primitive();
        if (i != 3) {
            if (i == 4) {
                return aSN1Primitive2 instanceof AbstractC0902u ? dVar.e((AbstractC0902u) aSN1Primitive2) : dVar.f((W) aSN1Primitive2);
            }
            dVar.a(aSN1Primitive2);
            return aSN1Primitive2;
        }
        switch (this.e) {
            case 0:
                d = new D(aSN1Primitive2);
                break;
            case 1:
                Z z7 = new Z(aSN1Primitive2, 0);
                z7.d = -1;
                d = z7;
                break;
            default:
                Z z8 = new Z(aSN1Primitive2, 1);
                z8.d = -1;
                d = z8;
                break;
        }
        return dVar.e(d);
    }

    public final boolean m() {
        int i = this.f5032a;
        return i == 1 || i == 3;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final ASN1Encodable parseBaseUniversal(boolean z6, int i) {
        C0883a c0883a;
        switch (i) {
            case 1:
                c0883a = C0885c.b;
                break;
            case 2:
                c0883a = C0891i.c;
                break;
            case 3:
                c0883a = AbstractC0884b.b;
                break;
            case 4:
                c0883a = AbstractC0897o.b;
                break;
            case 5:
                c0883a = AbstractC0892j.f5062a;
                break;
            case 6:
                c0883a = C0896n.c;
                break;
            case 7:
                c0883a = C0894l.b;
                break;
            case 8:
                c0883a = N.f5038g;
                break;
            case 9:
            case 11:
            case 14:
            case 15:
            case 29:
            default:
                c0883a = null;
                break;
            case 10:
                c0883a = C0887e.b;
                break;
            case 12:
                c0883a = c0.b;
                break;
            case 13:
                c0883a = r.c;
                break;
            case 16:
                c0883a = AbstractC0902u.b;
                break;
            case 17:
                c0883a = AbstractC0904w.c;
                break;
            case 18:
                c0883a = V.b;
                break;
            case 19:
                c0883a = Y.b;
                break;
            case 20:
                c0883a = b0.b;
                break;
            case 21:
                c0883a = e0.b;
                break;
            case 22:
                c0883a = T.b;
                break;
            case 23:
                c0883a = C0905x.b;
                break;
            case 24:
                c0883a = C0889g.b;
                break;
            case 25:
                c0883a = S.b;
                break;
            case 26:
                c0883a = f0.b;
                break;
            case 27:
                c0883a = P.b;
                break;
            case 28:
                c0883a = d0.b;
                break;
            case 30:
                c0883a = L.b;
                break;
        }
        if (c0883a == null) {
            throw new IllegalArgumentException(B2.b.c(i, "unsupported UNIVERSAL tag number: "));
        }
        AbstractC0899q abstractC0899qK = k(z6, c0883a);
        if (i == 3) {
            AbstractC0884b abstractC0884b = (AbstractC0884b) abstractC0899qK;
            abstractC0884b.getClass();
            return abstractC0884b;
        }
        if (i == 4) {
            AbstractC0897o abstractC0897o = (AbstractC0897o) abstractC0899qK;
            abstractC0897o.getClass();
            return abstractC0897o;
        }
        if (i == 16) {
            AbstractC0902u abstractC0902u = (AbstractC0902u) abstractC0899qK;
            return new C0901t(abstractC0902u, abstractC0902u.size());
        }
        if (i != 17) {
            return abstractC0899qK;
        }
        AbstractC0904w abstractC0904w = (AbstractC0904w) abstractC0899qK;
        return new C0903v(abstractC0904w, abstractC0904w.f5076a.length);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final ASN1Encodable parseExplicitBaseObject() {
        if (!m()) {
            throw new IllegalStateException("object implicit - explicit expected.");
        }
        ASN1Encodable aSN1Encodable = this.d;
        return aSN1Encodable instanceof AbstractC0893k ? (AbstractC0893k) aSN1Encodable : aSN1Encodable.toASN1Primitive();
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final ASN1TaggedObjectParser parseExplicitBaseTagged() {
        if (m()) {
            return j(this.d.toASN1Primitive());
        }
        throw new IllegalStateException("object implicit - explicit expected.");
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final ASN1TaggedObjectParser parseImplicitBaseTagged(int i, int i3) {
        H h3;
        if (i == 0 || (i & 192) != i) {
            throw new IllegalArgumentException(B2.b.c(i, "invalid base tag class: "));
        }
        int i4 = this.f5032a;
        if (i4 == 1) {
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        if (i4 == 2) {
            H hJ = j(this.d.toASN1Primitive());
            if (hJ.hasTag(i, i3)) {
                return hJ;
            }
            throw new IllegalStateException(androidx.constraintlayout.core.motion.a.r("Expected ", io.ktor.utils.io.internal.t.k(i, i3), " tag but found ", io.ktor.utils.io.internal.t.k(hJ.b, hJ.c)));
        }
        switch (this.e) {
            case 0:
                h3 = new H(this.f5032a, i, i3, this.d, 0);
                break;
            case 1:
                h3 = new H(this.f5032a, i, i3, this.d, 1);
                break;
            default:
                return new H(this.f5032a, i, i3, this.d, 2);
        }
        return h3;
    }

    public final String toString() {
        return io.ktor.utils.io.internal.t.k(this.b, this.c) + this.d;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final boolean hasContextTag(int i) {
        return this.b == 128 && this.c == i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ H(int i, int i3, int i4, ASN1Encodable aSN1Encodable, int i5) {
        this(i, i3, i4, aSN1Encodable);
        this.e = i5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public H(W w5) {
        this(2, 128, 0, w5);
        this.e = 1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public H(boolean z6, int i, ASN1Encodable aSN1Encodable, int i3) {
        this(z6 ? 1 : 2, 128, i, aSN1Encodable);
        this.e = i3;
    }
}
