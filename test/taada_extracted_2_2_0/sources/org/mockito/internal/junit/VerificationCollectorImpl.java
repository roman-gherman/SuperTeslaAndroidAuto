package org.mockito.internal.junit;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.internal.progress.MockingProgressImpl;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.junit.VerificationCollector;
import org.mockito.verification.VerificationMode;
import org.mockito.verification.VerificationStrategy;

/* JADX INFO: loaded from: classes.dex */
public class VerificationCollectorImpl implements VerificationCollector {
    private StringBuilder builder;
    private int numberOfFailures;

    public class VerificationWrapper implements VerificationMode {
        private final VerificationMode delegate;

        @Override // org.mockito.verification.VerificationMode
        public VerificationMode description(String str) {
            throw new IllegalStateException("Should not fail in this mode");
        }

        @Override // org.mockito.verification.VerificationMode
        public void verify(VerificationData verificationData) {
            try {
                this.delegate.verify(verificationData);
            } catch (AssertionError e) {
                VerificationCollectorImpl.this.append(e.getMessage());
            }
        }

        private VerificationWrapper(VerificationMode verificationMode) {
            this.delegate = verificationMode;
        }
    }

    public VerificationCollectorImpl() {
        resetBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void append(String str) {
        this.numberOfFailures++;
        StringBuilder sb = this.builder;
        sb.append('\n');
        sb.append(this.numberOfFailures);
        sb.append(". ");
        sb.append(str.trim());
        sb.append('\n');
    }

    private void resetBuilder() {
        this.builder = B2.b.k("There were multiple verification failures:");
        this.numberOfFailures = 0;
    }

    public Statement apply(final Statement statement, Description description) {
        return new Statement() { // from class: org.mockito.internal.junit.VerificationCollectorImpl.1
            public void evaluate() {
                try {
                    VerificationCollectorImpl.this.assertLazily();
                    statement.evaluate();
                    VerificationCollectorImpl.this.collectAndReport();
                } finally {
                    ThreadSafeMockingProgress.mockingProgress().setVerificationStrategy(MockingProgressImpl.getDefaultVerificationStrategy());
                }
            }
        };
    }

    @Override // org.mockito.junit.VerificationCollector
    public VerificationCollector assertLazily() {
        ThreadSafeMockingProgress.mockingProgress().setVerificationStrategy(new VerificationStrategy() { // from class: org.mockito.internal.junit.VerificationCollectorImpl.2
            @Override // org.mockito.verification.VerificationStrategy
            public VerificationMode maybeVerifyLazily(VerificationMode verificationMode) {
                return new VerificationWrapper(verificationMode);
            }
        });
        return this;
    }

    @Override // org.mockito.junit.VerificationCollector
    public void collectAndReport() {
        ThreadSafeMockingProgress.mockingProgress().setVerificationStrategy(MockingProgressImpl.getDefaultVerificationStrategy());
        if (this.numberOfFailures <= 0) {
            return;
        }
        String string = this.builder.toString();
        resetBuilder();
        throw new MockitoAssertionError(string);
    }
}
