package org.mockito.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mockito.InOrder;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.verification.InOrderContextImpl;
import org.mockito.internal.verification.InOrderWrapper;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.internal.verification.VerificationWrapper;
import org.mockito.internal.verification.VerificationWrapperInOrderWrapper;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.internal.verification.api.VerificationInOrderMode;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public class InOrderImpl implements InOrder, InOrderContext {
    private final InOrderContext inOrderContext;
    private final MockitoCore mockitoCore = new MockitoCore();
    private final List<Object> mocksToBeVerifiedInOrder;

    public InOrderImpl(List<?> list) {
        ArrayList arrayList = new ArrayList();
        this.mocksToBeVerifiedInOrder = arrayList;
        this.inOrderContext = new InOrderContextImpl();
        arrayList.addAll(list);
    }

    private boolean objectIsMockToBeVerified(Object obj) {
        Iterator<Object> it = this.mocksToBeVerifiedInOrder.iterator();
        while (it.hasNext()) {
            if (it.next() == obj) {
                return true;
            }
        }
        return false;
    }

    public List<Object> getMocksToBeVerifiedInOrder() {
        return this.mocksToBeVerifiedInOrder;
    }

    @Override // org.mockito.internal.verification.api.InOrderContext
    public boolean isVerified(Invocation invocation) {
        return this.inOrderContext.isVerified(invocation);
    }

    @Override // org.mockito.internal.verification.api.InOrderContext
    public void markVerified(Invocation invocation) {
        this.inOrderContext.markVerified(invocation);
    }

    @Override // org.mockito.InOrder
    public <T> T verify(T t6) {
        return (T) verify(t6, VerificationModeFactory.times(1));
    }

    @Override // org.mockito.InOrder
    public void verifyNoMoreInteractions() {
        this.mockitoCore.verifyNoMoreInteractionsInOrder(this.mocksToBeVerifiedInOrder, this);
    }

    @Override // org.mockito.InOrder
    public <T> T verify(T t6, VerificationMode verificationMode) {
        if (t6 == null) {
            throw Reporter.nullPassedToVerify();
        }
        if (!Mockito.mockingDetails(t6).isMock()) {
            throw Reporter.notAMockPassedToVerify(t6.getClass());
        }
        if (!objectIsMockToBeVerified(t6)) {
            throw Reporter.inOrderRequiresFamiliarMock();
        }
        if (verificationMode instanceof VerificationWrapper) {
            return (T) this.mockitoCore.verify(t6, new VerificationWrapperInOrderWrapper((VerificationWrapper) verificationMode, this));
        }
        if (verificationMode instanceof VerificationInOrderMode) {
            return (T) this.mockitoCore.verify(t6, new InOrderWrapper((VerificationInOrderMode) verificationMode, this));
        }
        throw new MockitoException(verificationMode.getClass().getSimpleName().concat(" is not implemented to work with InOrder"));
    }

    @Override // org.mockito.InOrder
    public void verify(MockedStatic<?> mockedStatic, MockedStatic.Verification verification, VerificationMode verificationMode) {
        if (verificationMode instanceof VerificationWrapper) {
            mockedStatic.verify(verification, new VerificationWrapperInOrderWrapper((VerificationWrapper) verificationMode, this));
        } else {
            if (verificationMode instanceof VerificationInOrderMode) {
                mockedStatic.verify(verification, new InOrderWrapper((VerificationInOrderMode) verificationMode, this));
                return;
            }
            throw new MockitoException(verificationMode.getClass().getSimpleName().concat(" is not implemented to work with InOrder"));
        }
    }
}
