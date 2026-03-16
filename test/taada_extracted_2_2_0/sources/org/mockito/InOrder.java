package org.mockito;

import org.mockito.MockedStatic;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public interface InOrder {
    <T> T verify(T t6);

    <T> T verify(T t6, VerificationMode verificationMode);

    default void verify(MockedStatic<?> mockedStatic, MockedStatic.Verification verification) {
        verify(mockedStatic, verification, Mockito.times(1));
    }

    void verify(MockedStatic<?> mockedStatic, MockedStatic.Verification verification, VerificationMode verificationMode);

    void verifyNoMoreInteractions();
}
