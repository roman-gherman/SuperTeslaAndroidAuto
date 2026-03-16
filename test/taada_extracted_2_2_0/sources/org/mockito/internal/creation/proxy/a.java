package org.mockito.internal.creation.proxy;

import java.lang.reflect.Method;
import org.mockito.internal.invocation.RealMethod;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ProxyRealMethod {
    @Override // org.mockito.internal.creation.proxy.ProxyRealMethod
    public final RealMethod resolve(Object obj, Method method, Object[] objArr) {
        return ProxyRealMethod.lambda$make$0(obj, method, objArr);
    }
}
