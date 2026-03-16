package org.mockito.internal.configuration.injection;

import java.lang.reflect.Field;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class MockInjectionStrategy {
    private MockInjectionStrategy nextStrategy;

    public static MockInjectionStrategy nop() {
        return new MockInjectionStrategy() { // from class: org.mockito.internal.configuration.injection.MockInjectionStrategy.1
            @Override // org.mockito.internal.configuration.injection.MockInjectionStrategy
            public boolean processInjection(Field field, Object obj, Set<Object> set) {
                return false;
            }
        };
    }

    private boolean relayProcessToNextStrategy(Field field, Object obj, Set<Object> set) {
        MockInjectionStrategy mockInjectionStrategy = this.nextStrategy;
        return mockInjectionStrategy != null && mockInjectionStrategy.process(field, obj, set);
    }

    public boolean process(Field field, Object obj, Set<Object> set) {
        if (processInjection(field, obj, set)) {
            return true;
        }
        return relayProcessToNextStrategy(field, obj, set);
    }

    public abstract boolean processInjection(Field field, Object obj, Set<Object> set);

    public MockInjectionStrategy thenTry(MockInjectionStrategy mockInjectionStrategy) {
        MockInjectionStrategy mockInjectionStrategy2 = this.nextStrategy;
        if (mockInjectionStrategy2 != null) {
            mockInjectionStrategy2.thenTry(mockInjectionStrategy);
            return mockInjectionStrategy;
        }
        this.nextStrategy = mockInjectionStrategy;
        return mockInjectionStrategy;
    }
}
