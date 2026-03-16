package O3;

import B.h;
import c4.AbstractC0243a;
import g5.e;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f1191a;
    public static final Hashtable b;
    public static final Hashtable c;
    public static final Hashtable d;
    public static final Vector e;

    static {
        I3.a aVar = new I3.a(22);
        a aVar2 = new a(3);
        a aVar3 = new a(7);
        a aVar4 = new a(8);
        a aVar5 = new a(9);
        a aVar6 = new a(10);
        a aVar7 = new a(11);
        a aVar8 = new a(12);
        a aVar9 = new a(13);
        I3.a aVar10 = new I3.a(12);
        I3.a aVar11 = new I3.a(13);
        I3.a aVar12 = new I3.a(14);
        I3.a aVar13 = new I3.a(15);
        I3.a aVar14 = new I3.a(16);
        I3.a aVar15 = new I3.a(17);
        I3.a aVar16 = new I3.a(18);
        I3.a aVar17 = new I3.a(19);
        I3.a aVar18 = new I3.a(20);
        I3.a aVar19 = new I3.a(21);
        I3.a aVar20 = new I3.a(23);
        I3.a aVar21 = new I3.a(24);
        I3.a aVar22 = new I3.a(25);
        I3.a aVar23 = new I3.a(26);
        I3.a aVar24 = new I3.a(27);
        I3.a aVar25 = new I3.a(28);
        I3.a aVar26 = new I3.a(29);
        a aVar27 = new a(0);
        a aVar28 = new a(1);
        a aVar29 = new a(2);
        a aVar30 = new a(4);
        a aVar31 = new a(5);
        a aVar32 = new a(6);
        f1191a = new Hashtable();
        b = new Hashtable();
        c = new Hashtable();
        d = new Hashtable();
        e = new Vector();
        c("curve25519", S3.a.f1296a, aVar);
        c("secp128r1", SECObjectIdentifiers.secp128r1, aVar2);
        c("secp160k1", SECObjectIdentifiers.secp160k1, aVar3);
        c("secp160r1", SECObjectIdentifiers.secp160r1, aVar4);
        c("secp160r2", SECObjectIdentifiers.secp160r2, aVar5);
        c("secp192k1", SECObjectIdentifiers.secp192k1, aVar6);
        C0896n c0896n = SECObjectIdentifiers.secp192r1;
        c("secp192r1", c0896n, aVar7);
        c("secp224k1", SECObjectIdentifiers.secp224k1, aVar8);
        C0896n c0896n2 = SECObjectIdentifiers.secp224r1;
        c("secp224r1", c0896n2, aVar9);
        c("secp256k1", SECObjectIdentifiers.secp256k1, aVar10);
        C0896n c0896n3 = SECObjectIdentifiers.secp256r1;
        c("secp256r1", c0896n3, aVar11);
        C0896n c0896n4 = SECObjectIdentifiers.secp384r1;
        c("secp384r1", c0896n4, aVar12);
        C0896n c0896n5 = SECObjectIdentifiers.secp521r1;
        c("secp521r1", c0896n5, aVar13);
        c("sect113r1", SECObjectIdentifiers.sect113r1, aVar14);
        c("sect113r2", SECObjectIdentifiers.sect113r2, aVar15);
        c("sect131r1", SECObjectIdentifiers.sect131r1, aVar16);
        c("sect131r2", SECObjectIdentifiers.sect131r2, aVar17);
        C0896n c0896n6 = SECObjectIdentifiers.sect163k1;
        c("sect163k1", c0896n6, aVar18);
        c("sect163r1", SECObjectIdentifiers.sect163r1, aVar19);
        C0896n c0896n7 = SECObjectIdentifiers.sect163r2;
        c("sect163r2", c0896n7, aVar20);
        c("sect193r1", SECObjectIdentifiers.sect193r1, aVar21);
        c("sect193r2", SECObjectIdentifiers.sect193r2, aVar22);
        C0896n c0896n8 = SECObjectIdentifiers.sect233k1;
        c("sect233k1", c0896n8, aVar23);
        C0896n c0896n9 = SECObjectIdentifiers.sect233r1;
        c("sect233r1", c0896n9, aVar24);
        c("sect239k1", SECObjectIdentifiers.sect239k1, aVar25);
        C0896n c0896n10 = SECObjectIdentifiers.sect283k1;
        c("sect283k1", c0896n10, aVar26);
        C0896n c0896n11 = SECObjectIdentifiers.sect283r1;
        c("sect283r1", c0896n11, aVar27);
        C0896n c0896n12 = SECObjectIdentifiers.sect409k1;
        c("sect409k1", c0896n12, aVar28);
        C0896n c0896n13 = SECObjectIdentifiers.sect409r1;
        c("sect409r1", c0896n13, aVar29);
        C0896n c0896n14 = SECObjectIdentifiers.sect571k1;
        c("sect571k1", c0896n14, aVar30);
        C0896n c0896n15 = SECObjectIdentifiers.sect571r1;
        c("sect571r1", c0896n15, aVar31);
        c("sm2p256v1", GMObjectIdentifiers.sm2p256v1, aVar32);
        b(c0896n7, "B-163");
        b(c0896n9, "B-233");
        b(c0896n11, "B-283");
        b(c0896n13, "B-409");
        b(c0896n15, "B-571");
        b(c0896n6, "K-163");
        b(c0896n8, "K-233");
        b(c0896n10, "K-283");
        b(c0896n12, "K-409");
        b(c0896n14, "K-571");
        b(c0896n, "P-192");
        b(c0896n2, "P-224");
        b(c0896n3, "P-256");
        b(c0896n4, "P-384");
        b(c0896n5, "P-521");
    }

    public static AbstractC0243a a(AbstractC0243a abstractC0243a, h hVar) {
        int i;
        synchronized (abstractC0243a) {
            i = abstractC0243a.f1778f;
        }
        new h(abstractC0243a, hVar);
        if (!abstractC0243a.l(i)) {
            throw new IllegalStateException("unsupported coordinate system");
        }
        AbstractC0243a abstractC0243aA = abstractC0243a.a();
        if (abstractC0243aA == abstractC0243a) {
            throw new IllegalStateException("implementation returned current curve");
        }
        synchronized (abstractC0243aA) {
            abstractC0243aA.f1778f = i;
        }
        return abstractC0243aA;
    }

    public static void b(C0896n c0896n, String str) {
        Object obj = c.get(c0896n);
        if (obj == null) {
            throw new IllegalStateException();
        }
        String strB = e.b(str);
        b.put(strB, c0896n);
        f1191a.put(strB, obj);
    }

    public static void c(String str, C0896n c0896n, I3.c cVar) {
        e.addElement(str);
        d.put(c0896n, str);
        c.put(c0896n, cVar);
        String strB = e.b(str);
        b.put(strB, c0896n);
        f1191a.put(strB, cVar);
    }
}
