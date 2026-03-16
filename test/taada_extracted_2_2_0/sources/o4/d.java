package o4;

import w3.AbstractC0893k;
import w3.AbstractC0899q;
import w3.C0886d;
import w3.W;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f4364a;

    public d(byte[] bArr) {
        this.f4364a = bArr;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(new W(this.f4364a));
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }
}
