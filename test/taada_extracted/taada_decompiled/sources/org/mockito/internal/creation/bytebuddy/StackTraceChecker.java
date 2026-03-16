package org.mockito.internal.creation.bytebuddy;

import java.util.function.Predicate;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
class StackTraceChecker implements Predicate<Class<?>> {
    @Override // java.util.function.Predicate
    public boolean test(Class<?> cls) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i = 1;
        while (true) {
            if (i >= stackTrace.length - 1) {
                break;
            }
            if (!stackTrace[i].getClassName().startsWith("org.mockito.internal.")) {
                int i3 = i + 1;
                if (stackTrace[i3].getMethodName().startsWith(MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
                    try {
                        if (!stackTrace[i3].getClassName().equals(cls.getName())) {
                            if (cls.isAssignableFrom(Class.forName(stackTrace[i3].getClassName(), false, cls.getClassLoader()))) {
                                return true;
                            }
                        }
                    } catch (ClassNotFoundException unused) {
                    }
                }
            }
            i++;
        }
        return false;
    }
}
