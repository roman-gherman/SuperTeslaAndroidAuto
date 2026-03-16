package z3;

import I3.c;
import h5.b;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.internal.asn1.rosstandart.RosstandartObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: renamed from: z3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0947a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f5204a;
    public static final Hashtable b;
    public static final Hashtable c;

    static {
        O3.a aVar = new O3.a(15);
        O3.a aVar2 = new O3.a(16);
        O3.a aVar3 = new O3.a(17);
        O3.a aVar4 = new O3.a(18);
        O3.a aVar5 = new O3.a(19);
        O3.a aVar6 = new O3.a(20);
        O3.a aVar7 = new O3.a(21);
        f5204a = new Hashtable();
        b = new Hashtable();
        c = new Hashtable();
        b("GostR3410-2001-CryptoPro-A", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A, aVar);
        b("GostR3410-2001-CryptoPro-B", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B, aVar2);
        b("GostR3410-2001-CryptoPro-C", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C, aVar3);
        b("GostR3410-2001-CryptoPro-XchA", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA, aVar);
        b("GostR3410-2001-CryptoPro-XchB", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB, aVar3);
        b("Tc26-Gost-3410-12-256-paramSetA", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetA, aVar4);
        b("Tc26-Gost-3410-12-256-paramSetB", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetB, aVar);
        b("Tc26-Gost-3410-12-256-paramSetC", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetC, aVar2);
        b("Tc26-Gost-3410-12-256-paramSetD", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetD, aVar3);
        b("Tc26-Gost-3410-12-512-paramSetA", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetA, aVar5);
        b("Tc26-Gost-3410-12-512-paramSetB", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetB, aVar6);
        b("Tc26-Gost-3410-12-512-paramSetC", RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetC, aVar7);
    }

    public static BigInteger a(String str) {
        return new BigInteger(1, b.a(str));
    }

    public static void b(String str, C0896n c0896n, c cVar) {
        f5204a.put(str, c0896n);
        c.put(c0896n, str);
        b.put(c0896n, cVar);
    }
}
