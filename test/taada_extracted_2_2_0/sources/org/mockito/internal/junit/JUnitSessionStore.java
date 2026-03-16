package org.mockito.internal.junit;

import org.junit.runners.model.Statement;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoSession;
import org.mockito.internal.session.MockitoSessionLoggerAdapter;
import org.mockito.plugins.MockitoLogger;
import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
class JUnitSessionStore {
    private final MockitoLogger logger;
    private MockitoSession session;
    protected Strictness strictness;

    public JUnitSessionStore(MockitoLogger mockitoLogger, Strictness strictness) {
        this.logger = mockitoLogger;
        this.strictness = strictness;
    }

    public Statement createStatement(final Statement statement, final String str, final Object obj) {
        return new Statement() { // from class: org.mockito.internal.junit.JUnitSessionStore.1
            private Throwable evaluateSafely(Statement statement2) {
                try {
                    statement2.evaluate();
                    return null;
                } catch (Throwable th) {
                    return th;
                }
            }

            public void evaluate() throws Exception {
                AutoCloseable autoCloseableOpenMocks;
                if (JUnitSessionStore.this.session == null) {
                    JUnitSessionStore.this.session = Mockito.mockitoSession().name(str).strictness(JUnitSessionStore.this.strictness).logger(new MockitoSessionLoggerAdapter(JUnitSessionStore.this.logger)).initMocks(obj).startMocking();
                    autoCloseableOpenMocks = null;
                } else {
                    autoCloseableOpenMocks = MockitoAnnotations.openMocks(obj);
                }
                Throwable thEvaluateSafely = evaluateSafely(statement);
                JUnitSessionStore.this.session.finishMocking(thEvaluateSafely);
                if (autoCloseableOpenMocks != null) {
                    autoCloseableOpenMocks.close();
                }
                if (thEvaluateSafely != null) {
                    throw thEvaluateSafely;
                }
            }
        };
    }

    public void setStrictness(Strictness strictness) {
        this.strictness = strictness;
        MockitoSession mockitoSession = this.session;
        if (mockitoSession != null) {
            mockitoSession.setStrictness(strictness);
        }
    }
}
