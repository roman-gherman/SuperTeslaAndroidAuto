package org.mockito.internal;

import org.mockito.MockedStatic;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.debugging.LocationFactory;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.listeners.VerificationStartedNotifier;
import org.mockito.internal.progress.MockingProgress;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.util.StringUtil;
import org.mockito.internal.verification.MockAwareVerificationMode;
import org.mockito.internal.verification.VerificationDataImpl;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.invocation.Location;
import org.mockito.plugins.MockMaker;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public final class MockedStaticImpl<T> implements MockedStatic<T> {
    private boolean closed;
    private final MockMaker.StaticMockControl<T> control;
    private final Location location = LocationFactory.create();

    public MockedStaticImpl(MockMaker.StaticMockControl<T> staticMockControl) {
        this.control = staticMockControl;
    }

    private void assertNotClosed() {
        if (this.closed) {
            throw new MockitoException(StringUtil.join("The static mock created at", this.location.toString(), "is already resolved and cannot longer be used"));
        }
    }

    @Override // org.mockito.MockedStatic
    public void clearInvocations() {
        assertNotClosed();
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.validateState();
        mockingProgress.reset();
        mockingProgress.resetOngoingStubbing();
        MockUtil.getInvocationContainer(this.control.getType()).clearInvocations();
    }

    @Override // org.mockito.ScopedMock, java.lang.AutoCloseable
    public void close() {
        assertNotClosed();
        this.closed = true;
        this.control.disable();
    }

    @Override // org.mockito.ScopedMock
    public void closeOnDemand() {
        if (this.closed) {
            return;
        }
        close();
    }

    @Override // org.mockito.ScopedMock
    public boolean isClosed() {
        return this.closed;
    }

    @Override // org.mockito.MockedStatic
    public void reset() {
        assertNotClosed();
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.validateState();
        mockingProgress.reset();
        mockingProgress.resetOngoingStubbing();
        MockUtil.resetMock(this.control.getType());
    }

    public String toString() {
        return "static mock for ".concat(this.control.getType().getName());
    }

    @Override // org.mockito.MockedStatic
    public void verify(MockedStatic.Verification verification, VerificationMode verificationMode) throws Throwable {
        assertNotClosed();
        MockingDetails mockingDetails = Mockito.mockingDetails(this.control.getType());
        VerificationStartedNotifier.notifyVerificationStarted(mockingDetails.getMockHandler().getMockSettings().getVerificationStartedListeners(), mockingDetails);
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.verificationStarted(new MockAwareVerificationMode(this.control.getType(), mockingProgress.maybeVerifyLazily(verificationMode), mockingProgress.verificationListeners()));
        try {
            verification.apply();
        } catch (MockitoAssertionError e) {
            e = e;
            throw e;
        } catch (MockitoException e6) {
            e = e6;
            throw e;
        } catch (Throwable th) {
            throw new MockitoException(StringUtil.join("An unexpected error occurred while verifying a static stub", "", "To correctly verify a stub, invoke a single static method of " + this.control.getType().getName() + " in the provided lambda.", "For example, if a method 'sample' was defined, provide a lambda or anonymous class containing the code", "", "() -> " + this.control.getType().getSimpleName() + ".sample()", "or", this.control.getType().getSimpleName().concat("::sample")), th);
        }
    }

    @Override // org.mockito.MockedStatic
    public void verifyNoInteractions() {
        assertNotClosed();
        ThreadSafeMockingProgress.mockingProgress().validateState();
        VerificationModeFactory.noInteractions().verify(new VerificationDataImpl(MockUtil.getInvocationContainer(this.control.getType()), null));
    }

    @Override // org.mockito.MockedStatic
    public void verifyNoMoreInteractions() {
        assertNotClosed();
        ThreadSafeMockingProgress.mockingProgress().validateState();
        VerificationModeFactory.noMoreInteractions().verify(new VerificationDataImpl(MockUtil.getInvocationContainer(this.control.getType()), null));
    }

    @Override // org.mockito.MockedStatic
    public <S> OngoingStubbing<S> when(MockedStatic.Verification verification) {
        assertNotClosed();
        try {
            verification.apply();
        } catch (MockitoException e) {
            throw e;
        } catch (Throwable unused) {
        }
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.stubbingStarted();
        OngoingStubbing<S> ongoingStubbing = (OngoingStubbing<S>) mockingProgress.pullOngoingStubbing();
        if (ongoingStubbing != null) {
            return ongoingStubbing;
        }
        mockingProgress.reset();
        throw Reporter.missingMethodInvocation();
    }
}
