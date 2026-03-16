package W1;

import java.lang.reflect.Method;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f1389a;

    static {
        Method method;
        Method[] throwableMethods = Throwable.class.getMethods();
        h.e(throwableMethods, "throwableMethods");
        int length = throwableMethods.length;
        int i = 0;
        while (true) {
            method = null;
            if (i >= length) {
                break;
            }
            Method method2 = throwableMethods[i];
            if (h.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                h.e(parameterTypes, "it.parameterTypes");
                if (h.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i++;
        }
        f1389a = method;
        int length2 = throwableMethods.length;
        for (int i3 = 0; i3 < length2 && !h.a(throwableMethods[i3].getName(), "getSuppressed"); i3++) {
        }
    }
}
