package org.mockito;

import org.mockito.invocation.InvocationFactory;
import org.mockito.listeners.MockitoListener;
import org.mockito.plugins.MockitoPlugins;

/* JADX INFO: loaded from: classes.dex */
@NotExtensible
public interface MockitoFramework {
    MockitoFramework addListener(MockitoListener mockitoListener);

    void clearInlineMock(Object obj);

    void clearInlineMocks();

    InvocationFactory getInvocationFactory();

    MockitoPlugins getPlugins();

    MockitoFramework removeListener(MockitoListener mockitoListener);
}
