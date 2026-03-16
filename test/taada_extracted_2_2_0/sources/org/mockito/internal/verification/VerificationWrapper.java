package org.mockito.internal.verification;

import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public abstract class VerificationWrapper<WrapperT extends VerificationMode> implements VerificationMode {
    protected final WrapperT wrappedVerification;

    public VerificationWrapper(WrapperT wrappert) {
        this.wrappedVerification = wrappert;
    }

    public VerificationMode atLeast(int i) {
        return copySelfWithNewVerificationMode(VerificationModeFactory.atLeast(i));
    }

    public VerificationMode atLeastOnce() {
        return copySelfWithNewVerificationMode(VerificationModeFactory.atLeastOnce());
    }

    public VerificationMode atMost(int i) {
        return copySelfWithNewVerificationMode(VerificationModeFactory.atMost(i));
    }

    public VerificationMode atMostOnce() {
        return copySelfWithNewVerificationMode(VerificationModeFactory.atMostOnce());
    }

    public abstract VerificationMode copySelfWithNewVerificationMode(VerificationMode verificationMode);

    public VerificationMode never() {
        return copySelfWithNewVerificationMode(VerificationModeFactory.atMost(0));
    }

    public VerificationMode only() {
        return copySelfWithNewVerificationMode(VerificationModeFactory.only());
    }

    public VerificationMode times(int i) {
        return copySelfWithNewVerificationMode(VerificationModeFactory.times(i));
    }

    @Override // org.mockito.verification.VerificationMode
    public void verify(VerificationData verificationData) {
        this.wrappedVerification.verify(verificationData);
    }
}
