package E3;

import I3.c;
import g5.e;
import h5.b;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f319a;
    public static final Hashtable b;
    public static final Hashtable c;

    static {
        D3.a aVar = new D3.a(10);
        D3.a aVar2 = new D3.a(11);
        D3.a aVar3 = new D3.a(12);
        D3.a aVar4 = new D3.a(13);
        D3.a aVar5 = new D3.a(14);
        D3.a aVar6 = new D3.a(15);
        D3.a aVar7 = new D3.a(16);
        D3.a aVar8 = new D3.a(17);
        D3.a aVar9 = new D3.a(18);
        D3.a aVar10 = new D3.a(5);
        D3.a aVar11 = new D3.a(6);
        D3.a aVar12 = new D3.a(7);
        D3.a aVar13 = new D3.a(8);
        D3.a aVar14 = new D3.a(9);
        f319a = new Hashtable();
        b = new Hashtable();
        c = new Hashtable();
        b("brainpoolP160r1", TeleTrusTObjectIdentifiers.brainpoolP160r1, aVar);
        b("brainpoolP160t1", TeleTrusTObjectIdentifiers.brainpoolP160t1, aVar2);
        b("brainpoolP192r1", TeleTrusTObjectIdentifiers.brainpoolP192r1, aVar3);
        b("brainpoolP192t1", TeleTrusTObjectIdentifiers.brainpoolP192t1, aVar4);
        b("brainpoolP224r1", TeleTrusTObjectIdentifiers.brainpoolP224r1, aVar5);
        b("brainpoolP224t1", TeleTrusTObjectIdentifiers.brainpoolP224t1, aVar6);
        b("brainpoolP256r1", TeleTrusTObjectIdentifiers.brainpoolP256r1, aVar7);
        b("brainpoolP256t1", TeleTrusTObjectIdentifiers.brainpoolP256t1, aVar8);
        b("brainpoolP320r1", TeleTrusTObjectIdentifiers.brainpoolP320r1, aVar9);
        b("brainpoolP320t1", TeleTrusTObjectIdentifiers.brainpoolP320t1, aVar10);
        b("brainpoolP384r1", TeleTrusTObjectIdentifiers.brainpoolP384r1, aVar11);
        b("brainpoolP384t1", TeleTrusTObjectIdentifiers.brainpoolP384t1, aVar12);
        b("brainpoolP512r1", TeleTrusTObjectIdentifiers.brainpoolP512r1, aVar13);
        b("brainpoolP512t1", TeleTrusTObjectIdentifiers.brainpoolP512t1, aVar14);
    }

    public static BigInteger a(String str) {
        return new BigInteger(1, b.a(str));
    }

    public static void b(String str, C0896n c0896n, c cVar) {
        f319a.put(e.b(str), c0896n);
        c.put(c0896n, str);
        b.put(c0896n, cVar);
    }
}
