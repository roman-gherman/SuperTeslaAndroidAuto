package o4;

import w3.AbstractC0893k;
import w3.AbstractC0899q;
import w3.C0886d;
import w3.C0891i;
import w3.W;
import w3.Z;

/* JADX INFO: renamed from: o4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0748a extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4358a;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f4359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C0749b f4360g;

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(new C0891i(this.f4358a));
        c0886d.a(new W(this.b));
        c0886d.a(new W(this.c));
        c0886d.a(new W(this.d));
        c0886d.a(new W(this.e));
        c0886d.a(new W(this.f4359f));
        C0749b c0749b = this.f4360g;
        if (c0749b != null) {
            c0886d.a(new C0749b(g5.c.c(c0749b.f4361a)));
        }
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }
}
