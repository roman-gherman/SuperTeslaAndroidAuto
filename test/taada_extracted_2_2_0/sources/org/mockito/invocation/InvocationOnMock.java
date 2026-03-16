package org.mockito.invocation;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.mockito.NotExtensible;

/* JADX INFO: loaded from: classes.dex */
@NotExtensible
public interface InvocationOnMock extends Serializable {
    Object callRealMethod();

    <T> T getArgument(int i);

    <T> T getArgument(int i, Class<T> cls);

    Object[] getArguments();

    Method getMethod();

    Object getMock();

    Object[] getRawArguments();
}
