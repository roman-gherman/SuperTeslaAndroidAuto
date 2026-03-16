package org.mockito.junit;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.notification.RunNotifier;
import org.mockito.internal.runners.InternalRunner;
import org.mockito.internal.runners.RunnerFactory;
import org.mockito.internal.runners.StrictRunner;

/* JADX INFO: loaded from: classes.dex */
public class MockitoJUnitRunner extends Runner implements Filterable {
    private final InternalRunner runner;

    public static class Silent extends MockitoJUnitRunner {
        public Silent(Class<?> cls) {
            super(new RunnerFactory().create(cls));
        }
    }

    public static class Strict extends MockitoJUnitRunner {
        public Strict(Class<?> cls) {
            super(new StrictRunner(new RunnerFactory().createStrict(cls), cls));
        }
    }

    public static class StrictStubs extends MockitoJUnitRunner {
        public StrictStubs(Class<?> cls) {
            super(new StrictRunner(new RunnerFactory().createStrictStubs(cls), cls));
        }
    }

    public MockitoJUnitRunner(Class<?> cls) {
        this(new StrictRunner(new RunnerFactory().createStrict(cls), cls));
    }

    public void filter(Filter filter) {
        this.runner.filter(filter);
    }

    public Description getDescription() {
        return this.runner.getDescription();
    }

    public void run(RunNotifier runNotifier) {
        this.runner.run(runNotifier);
    }

    public MockitoJUnitRunner(InternalRunner internalRunner) {
        this.runner = internalRunner;
    }
}
