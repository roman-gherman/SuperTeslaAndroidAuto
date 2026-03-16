package B3;

import java.util.Hashtable;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f127a = new Hashtable();
    public static final Hashtable b = new Hashtable();

    static {
        a(SECObjectIdentifiers.sect571r1, "B-571");
        a(SECObjectIdentifiers.sect409r1, "B-409");
        a(SECObjectIdentifiers.sect283r1, "B-283");
        a(SECObjectIdentifiers.sect233r1, "B-233");
        a(SECObjectIdentifiers.sect163r2, "B-163");
        a(SECObjectIdentifiers.sect571k1, "K-571");
        a(SECObjectIdentifiers.sect409k1, "K-409");
        a(SECObjectIdentifiers.sect283k1, "K-283");
        a(SECObjectIdentifiers.sect233k1, "K-233");
        a(SECObjectIdentifiers.sect163k1, "K-163");
        a(SECObjectIdentifiers.secp521r1, "P-521");
        a(SECObjectIdentifiers.secp384r1, "P-384");
        a(SECObjectIdentifiers.secp256r1, "P-256");
        a(SECObjectIdentifiers.secp224r1, "P-224");
        a(SECObjectIdentifiers.secp192r1, "P-192");
    }

    public static void a(C0896n c0896n, String str) {
        f127a.put(str, c0896n);
        b.put(c0896n, str);
    }
}
