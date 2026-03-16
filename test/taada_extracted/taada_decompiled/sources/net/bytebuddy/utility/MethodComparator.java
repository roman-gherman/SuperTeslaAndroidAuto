package net.bytebuddy.utility;

import java.lang.reflect.Method;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public enum MethodComparator implements Comparator<Method> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(Method method, Method method2) {
        if (method == method2) {
            return 0;
        }
        int iCompareTo = method.getName().compareTo(method2.getName());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?>[] parameterTypes2 = method2.getParameterTypes();
        if (parameterTypes.length < parameterTypes2.length) {
            return -1;
        }
        if (parameterTypes.length > parameterTypes2.length) {
            return 1;
        }
        for (int i = 0; i < parameterTypes.length; i++) {
            int iCompareTo2 = parameterTypes[i].getName().compareTo(parameterTypes2[i].getName());
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
        }
        return method.getReturnType().getName().compareTo(method2.getReturnType().getName());
    }
}
