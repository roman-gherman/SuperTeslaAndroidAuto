package o4;

import io.ktor.utils.io.internal.t;
import org.bouncycastle.asn1.ASN1Encodable;
import w3.AbstractC0893k;
import w3.AbstractC0897o;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0883a;
import w3.C0886d;
import w3.C0891i;
import w3.H;
import w3.W;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4372a;
    public final long b;
    public final long c;
    public final byte[] d;
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f4373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f4374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f4375h;

    public l(long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f4372a = 0;
        this.b = j6;
        this.d = g5.c.c(bArr);
        this.e = g5.c.c(bArr2);
        this.f4373f = g5.c.c(bArr3);
        this.f4374g = g5.c.c(bArr4);
        this.f4375h = g5.c.c(bArr5);
        this.c = -1L;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        long j6 = this.c;
        c0886d.a(j6 >= 0 ? new C0891i(1L) : new C0891i(0L));
        C0886d c0886d2 = new C0886d();
        c0886d2.a(new C0891i(this.b));
        c0886d2.a(new W(this.d));
        c0886d2.a(new W(this.e));
        c0886d2.a(new W(this.f4373f));
        c0886d2.a(new W(this.f4374g));
        if (j6 >= 0) {
            c0886d2.a(new H(false, 0, (ASN1Encodable) new C0891i(j6), 1));
        }
        Z z6 = new Z(c0886d2, false);
        z6.d = -1;
        c0886d.a(z6);
        c0886d.a(new H(true, 0, (ASN1Encodable) new W(this.f4375h), 1));
        Z z7 = new Z(c0886d, false);
        z7.d = -1;
        return z7;
    }

    public l(long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, long j7) {
        this.f4372a = 1;
        this.b = j6;
        this.d = g5.c.c(bArr);
        this.e = g5.c.c(bArr2);
        this.f4373f = g5.c.c(bArr3);
        this.f4374g = g5.c.c(bArr4);
        this.f4375h = g5.c.c(bArr5);
        this.c = j7;
    }

    public l(AbstractC0902u abstractC0902u) {
        long jO;
        C0891i c0891iJ = C0891i.j(abstractC0902u.m(0));
        if (!c0891iJ.k(0) && !c0891iJ.k(1)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f4372a = c0891iJ.m();
        if (abstractC0902u.size() != 2 && abstractC0902u.size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        AbstractC0902u abstractC0902uL = AbstractC0902u.l(abstractC0902u.m(1));
        this.b = C0891i.j(abstractC0902uL.m(0)).o();
        this.d = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(1)).f5066a);
        this.e = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(2)).f5066a);
        this.f4373f = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(3)).f5066a);
        this.f4374g = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(4)).f5066a);
        if (abstractC0902uL.size() == 6) {
            H hL = H.l(abstractC0902uL.m(5));
            if (hL.c != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            C0883a c0883a = C0891i.c;
            t.e(hL);
            AbstractC0899q abstractC0899qK = hL.k(false, c0883a);
            c0883a.a(abstractC0899qK);
            jO = ((C0891i) abstractC0899qK).o();
        } else {
            if (abstractC0902uL.size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            jO = -1;
        }
        this.c = jO;
        if (abstractC0902u.size() != 3) {
            this.f4375h = null;
        } else {
            this.f4375h = g5.c.c(((AbstractC0897o) AbstractC0897o.b.g(H.l(abstractC0902u.m(2)), true)).f5066a);
        }
    }
}
