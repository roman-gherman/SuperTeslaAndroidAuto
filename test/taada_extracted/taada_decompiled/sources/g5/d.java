package g5;

import java.security.AccessControlException;
import java.security.AccessController;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f3345a = new ThreadLocal();

    public static String a(String str) {
        String str2;
        String str3 = (String) AccessController.doPrivileged(new K4.b(str, 1));
        if (str3 != null) {
            return str3;
        }
        Map map = (Map) f3345a.get();
        return (map == null || (str2 = (String) map.get(str)) == null) ? (String) AccessController.doPrivileged(new K4.b(str, 2)) : str2;
    }

    public static boolean b(String str) {
        try {
            String strA = a(str);
            if (strA != null && strA.length() == 4 && ((strA.charAt(0) == 't' || strA.charAt(0) == 'T') && ((strA.charAt(1) == 'r' || strA.charAt(1) == 'R') && (strA.charAt(2) == 'u' || strA.charAt(2) == 'U')))) {
                if (strA.charAt(3) != 'e') {
                    if (strA.charAt(3) == 'E') {
                    }
                }
                return true;
            }
        } catch (AccessControlException unused) {
        }
        return false;
    }
}
