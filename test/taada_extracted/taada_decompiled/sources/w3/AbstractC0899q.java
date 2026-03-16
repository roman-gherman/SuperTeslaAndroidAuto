package w3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: renamed from: w3.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0899q extends AbstractC0893k {
    public static AbstractC0899q g(byte[] bArr) throws IOException {
        C0890h c0890h = new C0890h(new ByteArrayInputStream(bArr), bArr.length, false);
        try {
            AbstractC0899q abstractC0899qF = c0890h.f();
            if (c0890h.available() == 0) {
                return abstractC0899qF;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public abstract boolean b(AbstractC0899q abstractC0899q);

    public abstract void c(C0898p c0898p, boolean z6);

    public abstract boolean d();

    public abstract int e(boolean z6);

    @Override // w3.AbstractC0893k
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ASN1Encodable) && b(((ASN1Encodable) obj).toASN1Primitive());
    }

    public final boolean f(AbstractC0899q abstractC0899q) {
        return this == abstractC0899q || b(abstractC0899q);
    }

    public AbstractC0899q h() {
        return this;
    }

    @Override // w3.AbstractC0893k
    public abstract int hashCode();

    public AbstractC0899q i() {
        return this;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        return this;
    }
}
