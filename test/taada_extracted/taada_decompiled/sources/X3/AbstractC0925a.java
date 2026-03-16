package x3;

import g5.e;
import java.util.Hashtable;
import org.bouncycastle.asn1.anssi.ANSSIObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: renamed from: x3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0925a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f5124a;
    public static final Hashtable b;

    static {
        O3.a aVar = new O3.a(14);
        Hashtable hashtable = new Hashtable();
        f5124a = hashtable;
        Hashtable hashtable2 = new Hashtable();
        b = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        C0896n c0896n = ANSSIObjectIdentifiers.FRP256v1;
        hashtable.put(e.b("FRP256v1"), c0896n);
        hashtable3.put(c0896n, "FRP256v1");
        hashtable2.put(c0896n, aVar);
    }
}
