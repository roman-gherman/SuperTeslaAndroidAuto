package org.mockito.internal.creation.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.invocation.RealMethod;
import org.mockito.internal.invocation.SerializableMethod;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;

/* JADX INFO: loaded from: classes.dex */
class InvokeDefaultProxy implements ProxyRealMethod {
    private final Method invokeDefault = InvocationHandler.class.getMethod("invokeDefault", Object.class, Method.class, Object[].class);

    public class InvokeDefaultRealMethod implements RealMethod, Serializable {
        private static final long serialVersionUID = -1;
        private final Object[] args;
        private final Object proxy;
        private final SerializableMethod serializableMethod;

        @Override // org.mockito.internal.invocation.RealMethod
        public Object invoke() throws Throwable {
            try {
                return InvokeDefaultProxy.this.invokeDefault.invoke(null, this.proxy, this.serializableMethod.getJavaMethod(), this.args);
            } catch (IllegalAccessException e) {
                e = e;
                throw new MockitoException(StringUtil.join("Failed to access default method or invoked method with illegal arguments", "", "Method " + this.serializableMethod.getJavaMethod() + " could not be delegated, this is not supposed to happen", Platform.describe()), e);
            } catch (IllegalArgumentException e6) {
                e = e6;
                throw new MockitoException(StringUtil.join("Failed to access default method or invoked method with illegal arguments", "", "Method " + this.serializableMethod.getJavaMethod() + " could not be delegated, this is not supposed to happen", Platform.describe()), e);
            } catch (InvocationTargetException e7) {
                throw e7.getTargetException();
            }
        }

        @Override // org.mockito.internal.invocation.RealMethod
        public boolean isInvokable() {
            return true;
        }

        private InvokeDefaultRealMethod(Object obj, Method method, Object[] objArr) {
            this.proxy = obj;
            this.serializableMethod = new SerializableMethod(method);
            this.args = objArr;
        }
    }

    @Override // org.mockito.internal.creation.proxy.ProxyRealMethod
    public RealMethod resolve(Object obj, Method method, Object[] objArr) {
        return new InvokeDefaultRealMethod(obj, method, objArr);
    }
}
