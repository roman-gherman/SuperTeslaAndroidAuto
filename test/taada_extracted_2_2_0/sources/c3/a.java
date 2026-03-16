package C3;

import g5.b;
import io.ktor.utils.io.internal.t;
import java.util.Enumeration;
import o4.e;
import org.bouncycastle.asn1.ASN1Encodable;
import w3.AbstractC0884b;
import w3.AbstractC0893k;
import w3.AbstractC0897o;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.AbstractC0904w;
import w3.C0883a;
import w3.C0886d;
import w3.C0891i;
import w3.H;
import w3.M;
import w3.W;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0891i f167a;
    public H3.a b;
    public AbstractC0897o c;
    public AbstractC0904w d;
    public AbstractC0884b e;

    public a(H3.a aVar, e eVar) {
        this(aVar, eVar, (AbstractC0904w) null, (byte[]) null);
    }

    public static a b(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj == null) {
            return null;
        }
        AbstractC0902u abstractC0902uL = AbstractC0902u.l(obj);
        a aVar = new a();
        Enumeration enumerationN = abstractC0902uL.n();
        C0891i c0891iJ = C0891i.j(enumerationN.nextElement());
        aVar.f167a = c0891iJ;
        int iM = c0891iJ.m();
        if (iM < 0 || iM > 1) {
            throw new IllegalArgumentException("invalid version for private key info");
        }
        aVar.b = H3.a.b(enumerationN.nextElement());
        aVar.c = AbstractC0897o.j(enumerationN.nextElement());
        int i = -1;
        while (enumerationN.hasMoreElements()) {
            H h3 = (H) enumerationN.nextElement();
            int i3 = h3.c;
            if (i3 <= i) {
                throw new IllegalArgumentException("invalid optional field in private key info");
            }
            if (i3 == 0) {
                C0883a c0883a = AbstractC0904w.c;
                t.e(h3);
                AbstractC0899q abstractC0899qK = h3.k(false, c0883a);
                c0883a.a(abstractC0899qK);
                aVar.d = (AbstractC0904w) abstractC0899qK;
            } else {
                if (i3 != 1) {
                    throw new IllegalArgumentException("unknown optional field in private key info");
                }
                if (iM < 1) {
                    throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
                }
                C0883a c0883a2 = AbstractC0884b.b;
                t.e(h3);
                AbstractC0899q abstractC0899qK2 = h3.k(false, c0883a2);
                c0883a2.a(abstractC0899qK2);
                aVar.e = (AbstractC0884b) abstractC0899qK2;
            }
            i = i3;
        }
        return aVar;
    }

    public final AbstractC0899q c() {
        return AbstractC0899q.g(this.c.f5067a);
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d(5);
        c0886d.a(this.f167a);
        c0886d.a(this.b);
        c0886d.a(this.c);
        AbstractC0904w abstractC0904w = this.d;
        if (abstractC0904w != null) {
            c0886d.a(new H(false, 0, (ASN1Encodable) abstractC0904w, 1));
        }
        AbstractC0884b abstractC0884b = this.e;
        if (abstractC0884b != null) {
            c0886d.a(new H(false, 1, (ASN1Encodable) abstractC0884b, 1));
        }
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }

    public a(H3.a aVar, AbstractC0893k abstractC0893k, AbstractC0904w abstractC0904w) {
        this(aVar, abstractC0893k, abstractC0904w, (byte[]) null);
    }

    public a(H3.a aVar, AbstractC0893k abstractC0893k, AbstractC0904w abstractC0904w, byte[] bArr) {
        this(aVar, abstractC0893k.toASN1Primitive().a(), abstractC0904w, bArr);
    }

    public a(H3.a aVar, byte[] bArr, AbstractC0904w abstractC0904w, byte[] bArr2) {
        this.f167a = new C0891i(bArr2 != null ? b.b : b.f3344a);
        this.b = aVar;
        this.c = new W(bArr);
        this.d = abstractC0904w;
        this.e = bArr2 == null ? null : new M(bArr2, 0);
    }
}
