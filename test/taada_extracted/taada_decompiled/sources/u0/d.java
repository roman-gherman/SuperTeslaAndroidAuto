package U0;

import a.AbstractC0132a;
import f.s;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends V0.a {
    public static final String[] d = (String[]) AbstractC0132a.p(S0.a.b, S0.a.f1276a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f1312a;
    public String[] b;
    public int c;

    public static HashMap a(Map map, String[] strArr) {
        HashMap map2 = new HashMap();
        for (String str : strArr) {
            if (map.get(str) != null) {
                map2.put(str, (String) map.get(str));
            }
        }
        return map2;
    }

    @Override // com.tenjin.android.params.base.ParamProvider
    public final Map apply(Map map) {
        int iB = s.b(this.c);
        if (iB == 0) {
            map.put("opt_in", String.valueOf(true));
            return map;
        }
        if (iB == 1) {
            HashMap mapA = a(map, d);
            mapA.put("opt_out", String.valueOf(true));
            return mapA;
        }
        if (iB == 2) {
            String[] strArr = this.f1312a;
            for (String str : strArr) {
                map.remove(str);
            }
            map.put("opt_out_params", AbstractC0132a.L(strArr));
            return map;
        }
        if (iB != 3) {
            return map;
        }
        String[] strArr2 = S0.a.f1276a;
        String[] strArr3 = this.b;
        String[] strArr4 = (String[]) AbstractC0132a.p(strArr3, strArr2);
        if (map.get("device_all") != null) {
            strArr4 = (String[]) AbstractC0132a.p(strArr4, S0.a.c);
        }
        if (map.get("referrer") != null) {
            strArr4 = (String[]) AbstractC0132a.p(strArr4, S0.a.b);
        }
        HashMap mapA2 = a(map, strArr4);
        mapA2.put("opt_in_params", AbstractC0132a.L(strArr3));
        return mapA2;
    }
}
