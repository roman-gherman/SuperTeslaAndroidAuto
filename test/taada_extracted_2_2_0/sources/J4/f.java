package J4;

import java.util.HashMap;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.ExtendedDigest;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f884a;
    public static final HashMap b;

    static {
        HashMap map = new HashMap();
        f884a = map;
        HashMap map2 = new HashMap();
        b = map2;
        C0896n c0896n = NISTObjectIdentifiers.id_sha256;
        map.put("SHA-256", c0896n);
        C0896n c0896n2 = NISTObjectIdentifiers.id_sha512;
        map.put("SHA-512", c0896n2);
        C0896n c0896n3 = NISTObjectIdentifiers.id_shake128;
        map.put("SHAKE128", c0896n3);
        C0896n c0896n4 = NISTObjectIdentifiers.id_shake256;
        map.put("SHAKE256", c0896n4);
        map2.put(c0896n, "SHA-256");
        map2.put(c0896n2, "SHA-512");
        map2.put(c0896n3, "SHAKE128");
        map2.put(c0896n4, "SHAKE256");
    }

    public static ExtendedDigest a(C0896n c0896n) {
        if (c0896n.f(NISTObjectIdentifiers.id_sha256)) {
            return new N3.c();
        }
        if (c0896n.f(NISTObjectIdentifiers.id_sha512)) {
            return new N3.f();
        }
        if (c0896n.f(NISTObjectIdentifiers.id_shake128)) {
            return new N3.g(128);
        }
        if (c0896n.f(NISTObjectIdentifiers.id_shake256)) {
            return new N3.g(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + c0896n);
    }

    public static C0896n b(String str) {
        C0896n c0896n = (C0896n) f884a.get(str);
        if (c0896n != null) {
            return c0896n;
        }
        throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.p("unrecognized digest name: ", str));
    }
}
