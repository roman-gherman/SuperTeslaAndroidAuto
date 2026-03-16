package b5;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import v4.C0858a;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f1717a;

    static {
        f fVar = new f(C0858a.b);
        f fVar2 = new f(C0858a.c);
        f fVar3 = new f(C0858a.d);
        HashMap map = new HashMap();
        f1717a = map;
        map.put("hqc128", fVar);
        map.put("hqc192", fVar2);
        map.put("hqc256", fVar3);
    }

    public f(C0858a c0858a) {
        c0858a.getClass();
    }
}
