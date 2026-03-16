package org.mockito.internal.creation.bytebuddy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import net.bytebuddy.implementation.bind.annotation.FieldValue;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.StubValue;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.This;
import org.mockito.internal.debugging.LocationFactory;
import org.mockito.internal.invocation.DefaultInvocationFactory;
import org.mockito.internal.invocation.RealMethod;
import org.mockito.invocation.Location;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;

/* JADX INFO: loaded from: classes.dex */
public class MockMethodInterceptor implements Serializable {
    private static final long serialVersionUID = 7152947254057253027L;
    final MockHandler handler;
    private final MockCreationSettings mockCreationSettings;
    private transient ThreadLocal<Object> weakReferenceHatch = new ThreadLocal<>();
    private final ByteBuddyCrossClassLoaderSerializationSupport serializationSupport = new ByteBuddyCrossClassLoaderSerializationSupport();

    public static class DispatcherDefaultingToRealMethod {
        @RuntimeType
        public static Object interceptAbstract(@This Object obj, @FieldValue("mockitoInterceptor") MockMethodInterceptor mockMethodInterceptor, @StubValue Object obj2, @Origin Method method, @AllArguments Object[] objArr) {
            return mockMethodInterceptor == null ? obj2 : mockMethodInterceptor.doIntercept(obj, method, objArr, RealMethod.IsIllegal.INSTANCE);
        }

        @BindingPriority(2)
        @RuntimeType
        public static Object interceptSuperCallable(@This Object obj, @FieldValue("mockitoInterceptor") MockMethodInterceptor mockMethodInterceptor, @Origin Method method, @AllArguments Object[] objArr, @SuperCall(serializableProxy = true) Callable<?> callable) {
            return mockMethodInterceptor == null ? callable.call() : mockMethodInterceptor.doIntercept(obj, method, objArr, new RealMethod.FromCallable(callable));
        }
    }

    public static class ForEquals {
        public static boolean doIdentityEquals(@This Object obj, @Argument(0) Object obj2) {
            return obj == obj2;
        }
    }

    public static final class ForHashCode {
        private ForHashCode() {
        }

        public static int doIdentityHashCode(@This Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static final class ForWriteReplace {
        private ForWriteReplace() {
        }

        public static Object doWriteReplace(@This MockAccess mockAccess) {
            return mockAccess.getMockitoInterceptor().getSerializationSupport().writeReplace(mockAccess);
        }
    }

    public MockMethodInterceptor(MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        this.handler = mockHandler;
        this.mockCreationSettings = mockCreationSettings;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.weakReferenceHatch = new ThreadLocal<>();
    }

    public Object doIntercept(Object obj, Method method, Object[] objArr, RealMethod realMethod) {
        return doIntercept(obj, method, objArr, realMethod, LocationFactory.create());
    }

    public MockHandler getMockHandler() {
        return this.handler;
    }

    public ByteBuddyCrossClassLoaderSerializationSupport getSerializationSupport() {
        return this.serializationSupport;
    }

    public Object doIntercept(Object obj, Method method, Object[] objArr, RealMethod realMethod, Location location) {
        this.weakReferenceHatch.set(obj);
        try {
            return this.handler.handle(DefaultInvocationFactory.createInvocation(obj, method, objArr, realMethod, this.mockCreationSettings, location));
        } finally {
            this.weakReferenceHatch.remove();
        }
    }
}
