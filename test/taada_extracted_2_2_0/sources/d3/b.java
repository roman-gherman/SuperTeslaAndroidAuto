package D3;

import B.h;
import I3.c;
import c4.AbstractC0243a;
import c4.C0245c;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f269a;
    public static final Hashtable b;
    public static final Hashtable c;

    static {
        A3.a aVar = new A3.a(12);
        A3.a aVar2 = new A3.a(23);
        A3.a aVar3 = new A3.a(28);
        A3.a aVar4 = new A3.a(29);
        a aVar5 = new a(0);
        a aVar6 = new a(1);
        a aVar7 = new a(2);
        a aVar8 = new a(3);
        a aVar9 = new a(4);
        A3.a aVar10 = new A3.a(2);
        A3.a aVar11 = new A3.a(3);
        A3.a aVar12 = new A3.a(4);
        A3.a aVar13 = new A3.a(5);
        A3.a aVar14 = new A3.a(6);
        A3.a aVar15 = new A3.a(7);
        A3.a aVar16 = new A3.a(8);
        A3.a aVar17 = new A3.a(9);
        A3.a aVar18 = new A3.a(10);
        A3.a aVar19 = new A3.a(11);
        A3.a aVar20 = new A3.a(13);
        A3.a aVar21 = new A3.a(14);
        A3.a aVar22 = new A3.a(15);
        A3.a aVar23 = new A3.a(16);
        A3.a aVar24 = new A3.a(17);
        A3.a aVar25 = new A3.a(18);
        A3.a aVar26 = new A3.a(19);
        A3.a aVar27 = new A3.a(20);
        A3.a aVar28 = new A3.a(21);
        A3.a aVar29 = new A3.a(22);
        A3.a aVar30 = new A3.a(24);
        A3.a aVar31 = new A3.a(25);
        A3.a aVar32 = new A3.a(26);
        A3.a aVar33 = new A3.a(27);
        f269a = new Hashtable();
        b = new Hashtable();
        c = new Hashtable();
        c("secp112r1", SECObjectIdentifiers.secp112r1, aVar);
        c("secp112r2", SECObjectIdentifiers.secp112r2, aVar2);
        c("secp128r1", SECObjectIdentifiers.secp128r1, aVar3);
        c("secp128r2", SECObjectIdentifiers.secp128r2, aVar4);
        c("secp160k1", SECObjectIdentifiers.secp160k1, aVar5);
        c("secp160r1", SECObjectIdentifiers.secp160r1, aVar6);
        c("secp160r2", SECObjectIdentifiers.secp160r2, aVar7);
        c("secp192k1", SECObjectIdentifiers.secp192k1, aVar8);
        c("secp192r1", SECObjectIdentifiers.secp192r1, aVar9);
        c("secp224k1", SECObjectIdentifiers.secp224k1, aVar10);
        c("secp224r1", SECObjectIdentifiers.secp224r1, aVar11);
        c("secp256k1", SECObjectIdentifiers.secp256k1, aVar12);
        c("secp256r1", SECObjectIdentifiers.secp256r1, aVar13);
        c("secp384r1", SECObjectIdentifiers.secp384r1, aVar14);
        c("secp521r1", SECObjectIdentifiers.secp521r1, aVar15);
        c("sect113r1", SECObjectIdentifiers.sect113r1, aVar16);
        c("sect113r2", SECObjectIdentifiers.sect113r2, aVar17);
        c("sect131r1", SECObjectIdentifiers.sect131r1, aVar18);
        c("sect131r2", SECObjectIdentifiers.sect131r2, aVar19);
        c("sect163k1", SECObjectIdentifiers.sect163k1, aVar20);
        c("sect163r1", SECObjectIdentifiers.sect163r1, aVar21);
        c("sect163r2", SECObjectIdentifiers.sect163r2, aVar22);
        c("sect193r1", SECObjectIdentifiers.sect193r1, aVar23);
        c("sect193r2", SECObjectIdentifiers.sect193r2, aVar24);
        c("sect233k1", SECObjectIdentifiers.sect233k1, aVar25);
        c("sect233r1", SECObjectIdentifiers.sect233r1, aVar26);
        c("sect239k1", SECObjectIdentifiers.sect239k1, aVar27);
        c("sect283k1", SECObjectIdentifiers.sect283k1, aVar28);
        c("sect283r1", SECObjectIdentifiers.sect283r1, aVar29);
        c("sect409k1", SECObjectIdentifiers.sect409k1, aVar30);
        c("sect409r1", SECObjectIdentifiers.sect409r1, aVar31);
        c("sect571k1", SECObjectIdentifiers.sect571k1, aVar32);
        c("sect571r1", SECObjectIdentifiers.sect571r1, aVar33);
    }

    public static BigInteger a(String str) {
        return new BigInteger(1, h5.b.a(str));
    }

    public static AbstractC0243a b(C0245c c0245c, h hVar) {
        int i;
        synchronized (c0245c) {
            i = c0245c.f1778f;
        }
        new h(c0245c, hVar);
        if (!c0245c.l(i)) {
            throw new IllegalStateException("unsupported coordinate system");
        }
        AbstractC0243a abstractC0243aA = c0245c.a();
        if (abstractC0243aA == c0245c) {
            throw new IllegalStateException("implementation returned current curve");
        }
        synchronized (abstractC0243aA) {
            abstractC0243aA.f1778f = i;
        }
        return abstractC0243aA;
    }

    public static void c(String str, C0896n c0896n, c cVar) {
        f269a.put(str, c0896n);
        c.put(c0896n, str);
        b.put(c0896n, cVar);
    }
}
