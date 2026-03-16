package org.mockito.internal.creation.proxy;

import java.io.Serializable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.mockito.internal.invocation.RealMethod;

/* JADX INFO: loaded from: classes.dex */
class MethodHandleProxy implements ProxyRealMethod {
    private final MethodHandles.Lookup lookup = MethodHandles.lookup();

    public static class LegacyVersion implements ProxyRealMethod {
        private final Constructor<MethodHandles.Lookup> constructor;

        public LegacyVersion() throws NoSuchMethodException {
            try {
                Class.forName("java.lang.Module");
                throw new RuntimeException("Must not be used when modules are available");
            } catch (ClassNotFoundException unused) {
                Constructor<MethodHandles.Lookup> declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class);
                this.constructor = declaredConstructor;
                declaredConstructor.setAccessible(true);
            }
        }

        @Override // org.mockito.internal.creation.proxy.ProxyRealMethod
        public RealMethod resolve(Object obj, Method method, Object[] objArr) {
            try {
                return new MethodHandleRealMethod(this.constructor.newInstance(method.getDeclaringClass()).in(method.getDeclaringClass()).unreflectSpecial(method, method.getDeclaringClass()).bindTo(obj), objArr);
            } catch (Throwable unused) {
                return RealMethod.IsIllegal.INSTANCE;
            }
        }
    }

    public static class MethodHandleRealMethod implements RealMethod, Serializable {
        private static final long serialVersionUID = -1;
        private final Object[] args;
        private final MethodHandle handle;

        @Override // org.mockito.internal.invocation.RealMethod
        public Object invoke() {
            return this.handle.invokeWithArguments(this.args);
        }

        @Override // org.mockito.internal.invocation.RealMethod
        public boolean isInvokable() {
            return true;
        }

        private MethodHandleRealMethod(MethodHandle methodHandle, Object[] objArr) {
            this.handle = methodHandle;
            this.args = objArr;
        }
    }

    @Override // org.mockito.internal.creation.proxy.ProxyRealMethod
    public RealMethod resolve(Object obj, Method method, Object[] objArr) {
        try {
            return new MethodHandleRealMethod(this.lookup.findSpecial(method.getDeclaringClass(), method.getName(), MethodType.methodType(method.getReturnType(), method.getParameterTypes()), method.getDeclaringClass()).bindTo(obj), objArr);
        } catch (Throwable unused) {
            return RealMethod.IsIllegal.INSTANCE;
        }
    }
}
