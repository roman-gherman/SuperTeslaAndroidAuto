package org.mockito.junit;

import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.junit.JUnitRule;
import org.mockito.internal.junit.JUnitTestRule;
import org.mockito.internal.junit.VerificationCollectorImpl;
import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
public final class MockitoJUnit {
    private MockitoJUnit() {
    }

    public static VerificationCollector collector() {
        return new VerificationCollectorImpl();
    }

    public static MockitoRule rule() {
        return new JUnitRule(Plugins.getMockitoLogger(), Strictness.WARN);
    }

    public static MockitoTestRule testRule(Object obj) {
        return new JUnitTestRule(Plugins.getMockitoLogger(), Strictness.WARN, obj);
    }
}
