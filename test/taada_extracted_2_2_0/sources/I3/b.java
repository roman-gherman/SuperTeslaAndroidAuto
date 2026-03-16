package I3;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f792a;
    public static final Hashtable b;
    public static final Hashtable c;

    static {
        D3.a aVar = new D3.a(29);
        a aVar2 = new a(4);
        a aVar3 = new a(5);
        a aVar4 = new a(6);
        a aVar5 = new a(7);
        a aVar6 = new a(8);
        a aVar7 = new a(9);
        a aVar8 = new a(10);
        a aVar9 = new a(11);
        D3.a aVar10 = new D3.a(19);
        D3.a aVar11 = new D3.a(20);
        D3.a aVar12 = new D3.a(21);
        D3.a aVar13 = new D3.a(22);
        D3.a aVar14 = new D3.a(23);
        D3.a aVar15 = new D3.a(24);
        D3.a aVar16 = new D3.a(25);
        D3.a aVar17 = new D3.a(26);
        D3.a aVar18 = new D3.a(27);
        D3.a aVar19 = new D3.a(28);
        a aVar20 = new a(0);
        a aVar21 = new a(1);
        a aVar22 = new a(2);
        a aVar23 = new a(3);
        f792a = new Hashtable();
        b = new Hashtable();
        c = new Hashtable();
        b("prime192v1", X9ObjectIdentifiers.prime192v1, aVar);
        b("prime192v2", X9ObjectIdentifiers.prime192v2, aVar2);
        b("prime192v3", X9ObjectIdentifiers.prime192v3, aVar3);
        b("prime239v1", X9ObjectIdentifiers.prime239v1, aVar4);
        b("prime239v2", X9ObjectIdentifiers.prime239v2, aVar5);
        b("prime239v3", X9ObjectIdentifiers.prime239v3, aVar6);
        b("prime256v1", X9ObjectIdentifiers.prime256v1, aVar7);
        b("c2pnb163v1", X9ObjectIdentifiers.c2pnb163v1, aVar8);
        b("c2pnb163v2", X9ObjectIdentifiers.c2pnb163v2, aVar9);
        b("c2pnb163v3", X9ObjectIdentifiers.c2pnb163v3, aVar10);
        b("c2pnb176w1", X9ObjectIdentifiers.c2pnb176w1, aVar11);
        b("c2tnb191v1", X9ObjectIdentifiers.c2tnb191v1, aVar12);
        b("c2tnb191v2", X9ObjectIdentifiers.c2tnb191v2, aVar13);
        b("c2tnb191v3", X9ObjectIdentifiers.c2tnb191v3, aVar14);
        b("c2pnb208w1", X9ObjectIdentifiers.c2pnb208w1, aVar15);
        b("c2tnb239v1", X9ObjectIdentifiers.c2tnb239v1, aVar16);
        b("c2tnb239v2", X9ObjectIdentifiers.c2tnb239v2, aVar17);
        b("c2tnb239v3", X9ObjectIdentifiers.c2tnb239v3, aVar18);
        b("c2pnb272w1", X9ObjectIdentifiers.c2pnb272w1, aVar19);
        b("c2pnb304w1", X9ObjectIdentifiers.c2pnb304w1, aVar20);
        b("c2tnb359v1", X9ObjectIdentifiers.c2tnb359v1, aVar21);
        b("c2pnb368w1", X9ObjectIdentifiers.c2pnb368w1, aVar22);
        b("c2tnb431r1", X9ObjectIdentifiers.c2tnb431r1, aVar23);
    }

    public static BigInteger a(String str) {
        return new BigInteger(1, h5.b.a(str));
    }

    public static void b(String str, C0896n c0896n, c cVar) {
        f792a.put(str, c0896n);
        c.put(c0896n, str);
        b.put(c0896n, cVar);
    }
}
