package org.mockito;

import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.GlobalConfiguration;
import org.mockito.internal.util.StringUtil;

/* JADX INFO: loaded from: classes.dex */
public final class MockitoAnnotations {
    private MockitoAnnotations() {
    }

    @Deprecated
    public static void initMocks(Object obj) {
        try {
            openMocks(obj).close();
        } catch (Exception e) {
            throw new MockitoException(StringUtil.join("Failed to release mocks", "", "This should not happen unless you are using a third-party mock maker"), e);
        }
    }

    public static AutoCloseable openMocks(Object obj) {
        if (obj != null) {
            return new GlobalConfiguration().tryGetPluginAnnotationEngine().process(obj.getClass(), obj);
        }
        throw new MockitoException("testClass cannot be null. For info how to use @Mock annotations see examples in javadoc for MockitoAnnotations class");
    }
}
