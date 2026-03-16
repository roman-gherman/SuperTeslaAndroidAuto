package org.mockito.internal.junit;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.mockito.junit.MockitoRule;
import org.mockito.plugins.MockitoLogger;
import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
public final class JUnitRule implements MockitoRule {
    private final JUnitSessionStore sessionStore;

    public JUnitRule(MockitoLogger mockitoLogger, Strictness strictness) {
        this.sessionStore = new JUnitSessionStore(mockitoLogger, strictness);
    }

    public Statement apply(Statement statement, FrameworkMethod frameworkMethod, Object obj) {
        return this.sessionStore.createStatement(statement, obj.getClass().getSimpleName() + "." + frameworkMethod.getName(), obj);
    }

    @Override // org.mockito.junit.MockitoRule
    public MockitoRule silent() {
        return strictness(Strictness.LENIENT);
    }

    @Override // org.mockito.junit.MockitoRule
    public MockitoRule strictness(Strictness strictness) {
        this.sessionStore.setStrictness(strictness);
        return this;
    }
}
