package org.mockito.internal.invocation;

import java.io.Serializable;
import java.util.concurrent.Callable;
import org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter;
import org.mockito.invocation.InvocationFactory;

/* JADX INFO: loaded from: classes.dex */
public interface RealMethod extends Serializable {

    public static class FromBehavior implements RealMethod {
        private final InvocationFactory.RealMethodBehavior<?> behavior;

        public FromBehavior(InvocationFactory.RealMethodBehavior<?> realMethodBehavior) {
            this.behavior = realMethodBehavior;
        }

        @Override // org.mockito.internal.invocation.RealMethod
        public Object invoke() {
            try {
                return this.behavior.call();
            } catch (Throwable th) {
                new ConditionalStackTraceFilter().filter(th);
                throw th;
            }
        }

        @Override // org.mockito.internal.invocation.RealMethod
        public boolean isInvokable() {
            return true;
        }
    }

    public static class FromCallable extends FromBehavior implements RealMethod {
        public FromCallable(final Callable<?> callable) {
            super(new InvocationFactory.RealMethodBehavior() { // from class: org.mockito.internal.invocation.RealMethod.FromCallable.1
                @Override // org.mockito.invocation.InvocationFactory.RealMethodBehavior
                public Object call() {
                    return callable.call();
                }
            });
        }
    }

    public enum IsIllegal implements RealMethod {
        INSTANCE;

        @Override // org.mockito.internal.invocation.RealMethod
        public Object invoke() {
            throw new IllegalStateException();
        }

        @Override // org.mockito.internal.invocation.RealMethod
        public boolean isInvokable() {
            return false;
        }
    }

    Object invoke();

    boolean isInvokable();
}
