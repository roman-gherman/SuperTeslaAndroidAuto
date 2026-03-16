package org.mockito.internal.framework;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs$CastExtraArgs;
import org.mockito.MockitoFramework;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.invocation.DefaultInvocationFactory;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.util.Checks;
import org.mockito.invocation.InvocationFactory;
import org.mockito.listeners.MockitoListener;
import org.mockito.plugins.InlineMockMaker;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockitoPlugins;

/* JADX INFO: loaded from: classes.dex */
public class DefaultMockitoFramework implements MockitoFramework {
    private InlineMockMaker getInlineMockMaker() {
        MockMaker mockMaker = Plugins.getMockMaker();
        if (mockMaker instanceof InlineMockMaker) {
            return (InlineMockMaker) mockMaker;
        }
        return null;
    }

    @Override // org.mockito.MockitoFramework
    public MockitoFramework addListener(MockitoListener mockitoListener) {
        Checks.checkNotNull(mockitoListener, ServiceSpecificExtraArgs$CastExtraArgs.LISTENER);
        ThreadSafeMockingProgress.mockingProgress().addListener(mockitoListener);
        return this;
    }

    @Override // org.mockito.MockitoFramework
    public void clearInlineMock(Object obj) {
        InlineMockMaker inlineMockMaker = getInlineMockMaker();
        if (inlineMockMaker != null) {
            inlineMockMaker.clearMock(obj);
        }
    }

    @Override // org.mockito.MockitoFramework
    public void clearInlineMocks() {
        InlineMockMaker inlineMockMaker = getInlineMockMaker();
        if (inlineMockMaker != null) {
            inlineMockMaker.clearAllMocks();
        }
    }

    @Override // org.mockito.MockitoFramework
    public InvocationFactory getInvocationFactory() {
        return new DefaultInvocationFactory();
    }

    @Override // org.mockito.MockitoFramework
    public MockitoPlugins getPlugins() {
        return Plugins.getPlugins();
    }

    @Override // org.mockito.MockitoFramework
    public MockitoFramework removeListener(MockitoListener mockitoListener) {
        Checks.checkNotNull(mockitoListener, ServiceSpecificExtraArgs$CastExtraArgs.LISTENER);
        ThreadSafeMockingProgress.mockingProgress().removeListener(mockitoListener);
        return this;
    }
}
