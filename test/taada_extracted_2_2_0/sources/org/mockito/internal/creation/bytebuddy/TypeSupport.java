package org.mockito.internal.creation.bytebuddy;

import java.lang.reflect.Method;
import org.mockito.exceptions.base.MockitoException;

/* JADX INFO: loaded from: classes.dex */
class TypeSupport {
    static final TypeSupport INSTANCE;
    private final Method isSealed;

    static {
        Method method;
        try {
            method = Class.class.getMethod("isSealed", new Class[0]);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        INSTANCE = new TypeSupport(method);
    }

    private TypeSupport(Method method) {
        this.isSealed = method;
    }

    public boolean isSealed(Class<?> cls) {
        Method method = this.isSealed;
        if (method == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(cls, new Object[0])).booleanValue();
        } catch (Throwable th) {
            throw new MockitoException("Failed to check if type is sealed using handle " + this.isSealed, th);
        }
    }
}
