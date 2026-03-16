package org.mockito;

import org.mockito.stubbing.OngoingStubbing;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public interface MockedStatic<T> extends ScopedMock {

    public interface Verification {
        void apply();
    }

    void clearInvocations();

    void reset();

    default void verify(Verification verification) {
        verify(verification, Mockito.times(1));
    }

    void verify(Verification verification, VerificationMode verificationMode);

    void verifyNoInteractions();

    void verifyNoMoreInteractions();

    <S> OngoingStubbing<S> when(Verification verification);
}
