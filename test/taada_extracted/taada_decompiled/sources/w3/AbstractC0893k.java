package w3;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.util.Encodable;

/* JADX INFO: renamed from: w3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0893k implements ASN1Encodable, Encodable {
    public final byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new X(byteArrayOutputStream).q(toASN1Primitive());
        return byteArrayOutputStream.toByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ASN1Encodable) {
            return toASN1Primitive().f(((ASN1Encodable) obj).toASN1Primitive());
        }
        return false;
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        toASN1Primitive().c(new C0898p(byteArrayOutputStream), true);
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return toASN1Primitive().hashCode();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public abstract AbstractC0899q toASN1Primitive();
}
