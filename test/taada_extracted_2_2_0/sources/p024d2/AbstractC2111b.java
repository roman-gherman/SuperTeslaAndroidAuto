package p024d2;

import B2.b;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2111b {
    private static boolean f7600a;
    private static FileOutputStream f7601b;

    private static void m3596d(String str, String str2, String str3, String str4) {
        if (f7601b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(DateFormat.getDateTimeInstance().format(new Date()));
            sb.append(" ");
            sb.append(str2);
            sb.append(" - ");
            b.r(sb, str, ": ", str3);
            if (!str4.equalsIgnoreCase("")) {
                sb.append("# StackTrace: ");
                sb.append(str4);
            }
            try {
                f7601b.write(sb.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m3597c(String str, String str2, Throwable th) {
        if (f7600a) {
            m3596d(str, "E", str2, Log.getStackTraceString(th));
            Log.e(str, str2, th);
        }
    }

    public static void m3598b(String str, String str2) {
        m3597c(str, str2, null);
    }

    public static void m3599a(String str, String str2) {
        if (f7600a) {
            m3596d(str, "D", str2, "");
        }
    }
}
