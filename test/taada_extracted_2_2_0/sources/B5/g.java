package b5;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f1718a;

    static {
        g gVar = new g();
        g5.e.c("ML-KEM-512");
        g gVar2 = new g();
        g5.e.c("ML-KEM-768");
        g gVar3 = new g();
        g5.e.c("ML-KEM-1024");
        HashMap map = new HashMap();
        f1718a = map;
        map.put("kyber512", gVar);
        map.put("kyber768", gVar2);
        map.put("kyber1024", gVar3);
    }
}
