package org.mockito.invocation;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.mockito.mock.MockCreationSettings;

/* JADX INFO: loaded from: classes.dex */
public interface InvocationFactory {

    public interface RealMethodBehavior<R> extends Serializable {
        R call();
    }

    Invocation createInvocation(Object obj, MockCreationSettings mockCreationSettings, Method method, RealMethodBehavior realMethodBehavior, Object... objArr);
}
