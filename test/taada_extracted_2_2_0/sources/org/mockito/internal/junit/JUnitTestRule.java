package org.mockito.internal.junit;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.junit.MockitoTestRule;
import org.mockito.plugins.MockitoLogger;
import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
public final class JUnitTestRule implements MockitoTestRule {
    private final JUnitSessionStore sessionStore;
    private final Object testInstance;

    public JUnitTestRule(MockitoLogger mockitoLogger, Strictness strictness, Object obj) {
        this.sessionStore = new JUnitSessionStore(mockitoLogger, strictness);
        this.testInstance = obj;
    }

    public Statement apply(Statement statement, Description description) {
        return this.sessionStore.createStatement(statement, description.getDisplayName(), this.testInstance);
    }

    @Override // org.mockito.junit.MockitoTestRule
    public MockitoTestRule silent() {
        return strictness(Strictness.LENIENT);
    }

    @Override // org.mockito.junit.MockitoTestRule
    public MockitoTestRule strictness(Strictness strictness) {
        this.sessionStore.setStrictness(strictness);
        return this;
    }
}
