package net.bytebuddy.agent;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.InvocationTargetException;
import net.bytebuddy.agent.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public class Attacher {
    private static final String ATTACH_METHOD_NAME = "attach";
    private static final String DETACH_METHOD_NAME = "detach";
    private static final String LOAD_AGENT_METHOD_NAME = "loadAgent";
    private static final String LOAD_AGENT_PATH_METHOD_NAME = "loadAgentPath";

    private Attacher() {
        throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
    }

    public static void install(Class<?> cls, String str, String str2, boolean z6, @MaybeNull String str3) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = cls.getMethod(ATTACH_METHOD_NAME, String.class).invoke(null, str);
        try {
            cls.getMethod(z6 ? LOAD_AGENT_PATH_METHOD_NAME : LOAD_AGENT_METHOD_NAME, String.class, String.class).invoke(objInvoke, str2, str3);
            cls.getMethod(DETACH_METHOD_NAME, new Class[0]).invoke(objInvoke, new Object[0]);
        } catch (Throwable th) {
            cls.getMethod(DETACH_METHOD_NAME, new Class[0]).invoke(objInvoke, new Object[0]);
            throw th;
        }
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
    public static void main(String[] strArr) {
        String string;
        try {
            if (strArr.length < 5 || strArr[4].length() == 0) {
                string = null;
            } else {
                StringBuilder sb = new StringBuilder(strArr[4].substring(1));
                for (int i = 5; i < strArr.length; i++) {
                    sb.append(' ');
                    sb.append(strArr[i]);
                }
                string = sb.toString();
            }
            install(Class.forName(strArr[0]), strArr[1], strArr[2], Boolean.parseBoolean(strArr[3]), string);
        } catch (Throwable unused) {
            System.exit(1);
        }
    }
}
