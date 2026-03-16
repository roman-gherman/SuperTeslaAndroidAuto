package b5;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import t4.C0829a;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f1716a;

    static {
        d dVar = new d(C0829a.c);
        d dVar2 = new d(C0829a.d);
        HashMap map = new HashMap();
        f1716a = map;
        map.put("falcon-512", dVar);
        map.put("falcon-1024", dVar2);
    }

    public d(C0829a c0829a) {
        g5.e.c(c0829a.f4842a);
    }
}
