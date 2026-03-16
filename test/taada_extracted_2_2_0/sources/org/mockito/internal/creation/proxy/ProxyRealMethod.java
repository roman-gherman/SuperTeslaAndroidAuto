package org.mockito.internal.creation.proxy;

import java.lang.reflect.Method;
import org.mockito.internal.creation.proxy.MethodHandleProxy;
import org.mockito.internal.invocation.RealMethod;

/* JADX INFO: loaded from: classes.dex */
interface ProxyRealMethod {
    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ RealMethod lambda$make$0(Object obj, Method method, Object[] objArr) {
        return RealMethod.IsIllegal.INSTANCE;
    }

    static ProxyRealMethod make() {
        try {
            try {
                try {
                    return new InvokeDefaultProxy();
                } catch (Throwable unused) {
                    return new a();
                }
            } catch (Throwable unused2) {
                return new MethodHandleProxy.LegacyVersion();
            }
        } catch (Throwable unused3) {
            return new MethodHandleProxy();
        }
    }

    RealMethod resolve(Object obj, Method method, Object[] objArr);
}
