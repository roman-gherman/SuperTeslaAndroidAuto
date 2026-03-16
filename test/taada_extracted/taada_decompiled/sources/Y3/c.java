package Y3;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements AlgorithmParameterSpec {
    public static final HashMap b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1489a;

    static {
        c cVar = new c("ML-KEM-512");
        c cVar2 = new c("ML-KEM-768");
        c cVar3 = new c("ML-KEM-1024");
        HashMap map = new HashMap();
        b = map;
        map.put("ml-kem-512", cVar);
        map.put("ml-kem-768", cVar2);
        map.put("ml-kem-1024", cVar3);
        map.put("kyber512", cVar);
        map.put("kyber768", cVar2);
        map.put("kyber1024", cVar3);
    }

    public c(String str) {
        this.f1489a = str;
    }

    public static c a(String str) {
        c cVar = (c) b.get(g5.e.b(str));
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalArgumentException("unknown parameter name: ".concat(str));
    }
}
