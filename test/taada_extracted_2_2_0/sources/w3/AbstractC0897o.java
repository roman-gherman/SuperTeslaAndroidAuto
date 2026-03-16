package w3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetStringParser;

/* JADX INFO: renamed from: w3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0897o extends AbstractC0899q implements ASN1OctetStringParser {
    public static final C0883a b = new C0883a(AbstractC0897o.class, 14);
    public static final byte[] c = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5067a;

    public AbstractC0897o(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'string' cannot be null");
        }
        this.f5067a = bArr;
    }

    public static AbstractC0897o j(Object obj) {
        if (obj == null || (obj instanceof AbstractC0897o)) {
            return (AbstractC0897o) obj;
        }
        if (obj instanceof ASN1Encodable) {
            AbstractC0899q aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof AbstractC0897o) {
                return (AbstractC0897o) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (AbstractC0897o) b.d((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(obj.getClass().getName()));
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof AbstractC0897o)) {
            return false;
        }
        return Arrays.equals(this.f5067a, ((AbstractC0897o) abstractC0899q).f5067a);
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1OctetStringParser
    public final InputStream getOctetStream() {
        return new ByteArrayInputStream(this.f5067a);
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q h() {
        return new W(this.f5067a);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5067a);
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q i() {
        return new W(this.f5067a);
    }

    public final String toString() {
        h5.c cVar = h5.b.f3460a;
        byte[] bArr = this.f5067a;
        return "#".concat(g5.e.a(h5.b.b(bArr.length, bArr)));
    }
}
