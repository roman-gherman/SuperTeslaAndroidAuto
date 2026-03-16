package org.mockito.internal.runners;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.junit.DefaultTestFinishedEvent;
import org.mockito.internal.junit.MockitoTestListener;
import org.mockito.internal.util.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class DefaultInternalRunner implements InternalRunner {
    private final BlockJUnit4ClassRunner runner;

    /* JADX INFO: renamed from: org.mockito.internal.runners.DefaultInternalRunner$1, reason: invalid class name */
    public class AnonymousClass1 extends BlockJUnit4ClassRunner {
        private MockitoTestListener mockitoTestListener;
        public Object target;
        final /* synthetic */ Supplier val$listenerSupplier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Class cls, Supplier supplier) {
            super(cls);
            this.val$listenerSupplier = supplier;
        }

        public void run(final RunNotifier runNotifier) {
            runNotifier.addListener(new RunListener() { // from class: org.mockito.internal.runners.DefaultInternalRunner.1.2
                Throwable failure;

                public void testFailure(Failure failure) {
                    this.failure = failure.getException();
                }

                public void testFinished(Description description) {
                    try {
                        if (AnonymousClass1.this.mockitoTestListener != null) {
                            Mockito.framework().removeListener(AnonymousClass1.this.mockitoTestListener);
                            AnonymousClass1.this.mockitoTestListener.testFinished(new DefaultTestFinishedEvent(AnonymousClass1.this.target, description.getMethodName(), this.failure));
                            AnonymousClass1.this.mockitoTestListener = null;
                        }
                        Mockito.validateMockitoUsage();
                    } catch (Throwable th) {
                        runNotifier.fireTestFailure(new Failure(description, th));
                    }
                }
            });
            super.run(runNotifier);
        }

        public Statement withBefores(FrameworkMethod frameworkMethod, final Object obj, Statement statement) {
            this.target = obj;
            final Statement statementWithBefores = super.withBefores(frameworkMethod, obj, statement);
            return new Statement() { // from class: org.mockito.internal.runners.DefaultInternalRunner.1.1
                public void evaluate() throws Exception {
                    AutoCloseable autoCloseableOpenMocks;
                    if (AnonymousClass1.this.mockitoTestListener == null) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.mockitoTestListener = (MockitoTestListener) anonymousClass1.val$listenerSupplier.get();
                        Mockito.framework().addListener(AnonymousClass1.this.mockitoTestListener);
                        autoCloseableOpenMocks = MockitoAnnotations.openMocks(obj);
                    } else {
                        autoCloseableOpenMocks = null;
                    }
                    try {
                        statementWithBefores.evaluate();
                    } finally {
                        if (autoCloseableOpenMocks != null) {
                            autoCloseableOpenMocks.close();
                        }
                    }
                }
            };
        }
    }

    public DefaultInternalRunner(Class<?> cls, Supplier<MockitoTestListener> supplier) {
        this.runner = new AnonymousClass1(cls, supplier);
    }

    public void filter(Filter filter) {
        this.runner.filter(filter);
    }

    @Override // org.mockito.internal.runners.InternalRunner
    public Description getDescription() {
        return this.runner.getDescription();
    }

    @Override // org.mockito.internal.runners.InternalRunner
    public void run(RunNotifier runNotifier) {
        this.runner.run(runNotifier);
    }
}
