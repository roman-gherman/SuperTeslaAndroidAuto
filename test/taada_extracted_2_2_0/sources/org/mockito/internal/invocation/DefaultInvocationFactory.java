package org.mockito.internal.invocation;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import org.mockito.internal.creation.DelegatingMethod;
import org.mockito.internal.debugging.LocationFactory;
import org.mockito.internal.invocation.RealMethod;
import org.mockito.internal.invocation.mockref.MockWeakReference;
import org.mockito.internal.progress.SequenceNumber;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationFactory;
import org.mockito.invocation.Location;
import org.mockito.mock.MockCreationSettings;

/* JADX INFO: loaded from: classes.dex */
public class DefaultInvocationFactory implements InvocationFactory {
    private static MockitoMethod createMockitoMethod(Method method, MockCreationSettings mockCreationSettings) {
        return mockCreationSettings.isSerializable() ? new SerializableMethod(method) : new DelegatingMethod(method);
    }

    public Invocation createInvocation(Object obj, MockCreationSettings mockCreationSettings, Method method, Callable callable, Object... objArr) {
        return createInvocation(obj, mockCreationSettings, method, new RealMethod.FromCallable(callable), objArr);
    }

    @Override // org.mockito.invocation.InvocationFactory
    public Invocation createInvocation(Object obj, MockCreationSettings mockCreationSettings, Method method, InvocationFactory.RealMethodBehavior realMethodBehavior, Object... objArr) {
        return createInvocation(obj, mockCreationSettings, method, new RealMethod.FromBehavior(realMethodBehavior), objArr);
    }

    private Invocation createInvocation(Object obj, MockCreationSettings mockCreationSettings, Method method, RealMethod realMethod, Object[] objArr) {
        return createInvocation(obj, method, objArr, realMethod, mockCreationSettings);
    }

    public static InterceptedInvocation createInvocation(Object obj, Method method, Object[] objArr, RealMethod realMethod, MockCreationSettings mockCreationSettings, Location location) {
        return new InterceptedInvocation(new MockWeakReference(obj), createMockitoMethod(method, mockCreationSettings), objArr, realMethod, location, SequenceNumber.next());
    }

    private static InterceptedInvocation createInvocation(Object obj, Method method, Object[] objArr, RealMethod realMethod, MockCreationSettings mockCreationSettings) {
        return createInvocation(obj, method, objArr, realMethod, mockCreationSettings, LocationFactory.create());
    }
}
