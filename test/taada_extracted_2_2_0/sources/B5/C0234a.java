package b5;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import q4.C0789a;

/* JADX INFO: renamed from: b5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0234a implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f1713a;

    static {
        C0234a c0234a = new C0234a(C0789a.c);
        C0234a c0234a2 = new C0234a(C0789a.d);
        C0234a c0234a3 = new C0234a(C0789a.e);
        HashMap map = new HashMap();
        f1713a = map;
        map.put("bike128", c0234a);
        map.put("bike192", c0234a2);
        map.put("bike256", c0234a3);
    }

    public C0234a(C0789a c0789a) {
        c0789a.getClass();
    }
}
