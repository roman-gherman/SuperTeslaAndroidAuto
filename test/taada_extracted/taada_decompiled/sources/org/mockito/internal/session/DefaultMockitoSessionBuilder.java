package org.mockito.internal.session;

import B2.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mockito.MockitoSession;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.framework.DefaultMockitoSession;
import org.mockito.quality.Strictness;
import org.mockito.session.MockitoSessionBuilder;
import org.mockito.session.MockitoSessionLogger;

/* JADX INFO: loaded from: classes.dex */
public class DefaultMockitoSessionBuilder implements MockitoSessionBuilder {
    private MockitoSessionLogger logger;
    private String name;
    private Strictness strictness;
    private final List<Object> testClassInstances = new ArrayList();

    @Override // org.mockito.session.MockitoSessionBuilder
    public MockitoSessionBuilder initMocks(Object obj) {
        if (obj != null) {
            this.testClassInstances.add(obj);
        }
        return this;
    }

    @Override // org.mockito.session.MockitoSessionBuilder
    public MockitoSessionBuilder logger(MockitoSessionLogger mockitoSessionLogger) {
        this.logger = mockitoSessionLogger;
        return this;
    }

    @Override // org.mockito.session.MockitoSessionBuilder
    public MockitoSessionBuilder name(String str) {
        this.name = str;
        return this;
    }

    @Override // org.mockito.session.MockitoSessionBuilder
    public MockitoSession startMocking() {
        List arrayList;
        String name;
        if (this.testClassInstances.isEmpty()) {
            arrayList = Collections.EMPTY_LIST;
            name = this.name;
            if (name == null) {
                name = "<Unnamed Session>";
            }
        } else {
            arrayList = new ArrayList(this.testClassInstances);
            Object objB = b.b(1, this.testClassInstances);
            String str = this.name;
            name = str == null ? objB.getClass().getName() : str;
        }
        Strictness strictness = this.strictness;
        if (strictness == null) {
            strictness = Strictness.STRICT_STUBS;
        }
        MockitoSessionLogger mockitoSessionLogger = this.logger;
        return new DefaultMockitoSession(arrayList, name, strictness, mockitoSessionLogger == null ? Plugins.getMockitoLogger() : new MockitoLoggerAdapter(mockitoSessionLogger));
    }

    @Override // org.mockito.session.MockitoSessionBuilder
    public MockitoSessionBuilder strictness(Strictness strictness) {
        this.strictness = strictness;
        return this;
    }

    @Override // org.mockito.session.MockitoSessionBuilder
    public MockitoSessionBuilder initMocks(Object... objArr) {
        if (objArr != null) {
            for (Object obj : objArr) {
                initMocks(obj);
            }
        }
        return this;
    }
}
