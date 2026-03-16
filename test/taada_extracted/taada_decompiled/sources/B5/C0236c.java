package b5;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;

/* JADX INFO: renamed from: b5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0236c implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f1715a;

    static {
        C0236c c0236c = new C0236c();
        g5.e.c("dilithium2");
        C0236c c0236c2 = new C0236c();
        g5.e.c("dilithium3");
        C0236c c0236c3 = new C0236c();
        g5.e.c("dilithium5");
        HashMap map = new HashMap();
        f1715a = map;
        map.put("dilithium2", c0236c);
        map.put("dilithium3", c0236c2);
        map.put("dilithium5", c0236c3);
    }
}
