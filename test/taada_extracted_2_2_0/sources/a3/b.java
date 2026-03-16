package A3;

import I3.c;
import g5.e;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f80a;
    public static final Hashtable b;
    public static final Hashtable c;

    static {
        a aVar = new a(0);
        a aVar2 = new a(1);
        f80a = new Hashtable();
        b = new Hashtable();
        c = new Hashtable();
        b("wapip192v1", GMObjectIdentifiers.wapip192v1, aVar2);
        b("wapi192v1", GMObjectIdentifiers.wapi192v1, aVar2);
        b("sm2p256v1", GMObjectIdentifiers.sm2p256v1, aVar);
    }

    public static BigInteger a(String str) {
        return new BigInteger(1, h5.b.a(str));
    }

    public static void b(String str, C0896n c0896n, c cVar) {
        f80a.put(e.b(str), c0896n);
        c.put(c0896n, str);
        b.put(c0896n, cVar);
    }
}
