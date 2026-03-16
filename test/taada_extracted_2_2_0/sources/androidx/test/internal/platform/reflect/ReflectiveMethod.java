package androidx.test.internal.platform.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ReflectiveMethod<T> {
    private final String className;
    private boolean initialized = false;
    private Method method;
    private final String methodName;
    private final Class<?>[] paramTypes;

    public ReflectiveMethod(String str, String str2, Class<?>... clsArr) {
        this.className = str;
        this.paramTypes = clsArr;
        this.methodName = str2;
    }

    private synchronized void initIfNecessary() {
        if (this.initialized) {
            return;
        }
        Method declaredMethod = Class.forName(this.className).getDeclaredMethod(this.methodName, this.paramTypes);
        this.method = declaredMethod;
        declaredMethod.setAccessible(true);
        this.initialized = true;
    }

    public T invoke(Object obj, Object... objArr) throws ReflectionException {
        try {
            initIfNecessary();
            return (T) this.method.invoke(obj, objArr);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new ReflectionException(e);
        }
    }

    public T invokeStatic(Object... objArr) {
        return invoke(null, objArr);
    }
}
