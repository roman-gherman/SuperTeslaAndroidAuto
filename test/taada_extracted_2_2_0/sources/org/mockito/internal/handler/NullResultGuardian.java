package org.mockito.internal.handler;

import org.mockito.internal.util.Primitives;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationContainer;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;

/* JADX INFO: loaded from: classes.dex */
class NullResultGuardian<T> implements MockHandler<T> {
    private final MockHandler<T> delegate;

    public NullResultGuardian(MockHandler<T> mockHandler) {
        this.delegate = mockHandler;
    }

    @Override // org.mockito.invocation.MockHandler
    public InvocationContainer getInvocationContainer() {
        return this.delegate.getInvocationContainer();
    }

    @Override // org.mockito.invocation.MockHandler
    public MockCreationSettings<T> getMockSettings() {
        return this.delegate.getMockSettings();
    }

    @Override // org.mockito.invocation.MockHandler
    public Object handle(Invocation invocation) {
        Object objHandle = this.delegate.handle(invocation);
        Class<?> returnType = invocation.getMethod().getReturnType();
        return (objHandle == null && returnType.isPrimitive()) ? Primitives.defaultValue(returnType) : objHandle;
    }
}
