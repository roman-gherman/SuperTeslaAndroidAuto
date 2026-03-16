package o4;

import org.bouncycastle.asn1.ASN1Encodable;
import w3.AbstractC0893k;
import w3.AbstractC0897o;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0886d;
import w3.W;
import w3.Z;

/* JADX INFO: renamed from: o4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0749b extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f4362a;

    public C0749b(byte[] bArr) {
        this.f4362a = bArr;
    }

    public static C0749b b(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof C0749b) {
            return (C0749b) aSN1Encodable;
        }
        if (aSN1Encodable == null) {
            return null;
        }
        AbstractC0902u abstractC0902uL = AbstractC0902u.l(aSN1Encodable);
        C0749b c0749b = new C0749b();
        c0749b.f4362a = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(0)).f5067a);
        return c0749b;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(new W(this.f4362a));
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }
}
