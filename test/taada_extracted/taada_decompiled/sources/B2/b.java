package B2;

import J4.o;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class b {
    public static float a(float f6, float f7, float f8, float f9) {
        return ((f6 - f7) * f8) + f9;
    }

    public static Object b(int i, List list) {
        return list.get(list.size() - i);
    }

    public static String c(int i, String str) {
        return str + i;
    }

    public static String d(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String e(String str, String str2) {
        return str + str2;
    }

    public static String f(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String g(StringBuilder sb, String str, int i) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String h(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String i(x xVar, Class cls, StringBuilder sb) {
        sb.append(xVar.b(cls));
        return sb.toString();
    }

    public static StringBuilder j(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder k(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder l(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder m(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder n(String str, SimpleTypeMarker simpleTypeMarker, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(simpleTypeMarker);
        sb.append(str2);
        return sb;
    }

    public static void o(int i, int i3, C0896n c0896n, HashMap map, Integer num) {
        map.put(num, new o(i, i3, c0896n));
    }

    public static void p(int i, String str, HashMap map, String str2) {
        map.put(str2, new J4.d(i, str));
    }

    public static void q(Z3.c cVar, C0896n c0896n) {
        cVar.addKeyInfoConverter(c0896n, new W4.c(W4.c.b));
    }

    public static void r(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    public static void s(HashMap map, C0896n c0896n) {
        map.put(c0896n, new I4.a(18));
    }

    public static void t(Z3.c cVar, C0896n c0896n) {
        cVar.addKeyInfoConverter(c0896n, new L4.c(7));
    }

    public static void u(HashMap map, C0896n c0896n) {
        map.put(c0896n, new I4.a(21));
    }

    public static void v(HashMap map, C0896n c0896n) {
        map.put(c0896n, new I4.a(22));
    }

    public static /* synthetic */ String w(int i) {
        if (i == 1) {
            return "unspecified";
        }
        if (i == 2) {
            return "googleplay";
        }
        if (i == 3) {
            return "amazon";
        }
        if (i == 4) {
            return "other";
        }
        throw null;
    }

    public static /* synthetic */ int x(String str) {
        if (str == null) {
            throw new NullPointerException("Name is null");
        }
        if (str.equals("unspecified")) {
            return 1;
        }
        if (str.equals("googleplay")) {
            return 2;
        }
        if (str.equals("amazon")) {
            return 3;
        }
        if (str.equals("other")) {
            return 4;
        }
        throw new IllegalArgumentException("No enum constant com.tenjin.android.TenjinSDK.AppStoreType.".concat(str));
    }
}
