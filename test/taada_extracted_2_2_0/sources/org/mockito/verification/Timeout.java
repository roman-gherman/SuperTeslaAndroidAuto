package org.mockito.verification;

import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.util.Timer;
import org.mockito.internal.verification.VerificationOverTimeImpl;
import org.mockito.internal.verification.VerificationWrapper;

/* JADX INFO: loaded from: classes.dex */
public class Timeout extends VerificationWrapper<VerificationOverTimeImpl> implements VerificationWithTimeout {
    public Timeout(long j6, VerificationMode verificationMode) {
        this(10L, j6, verificationMode);
    }

    @Override // org.mockito.internal.verification.VerificationWrapper
    public VerificationMode atMost(int i) {
        throw Reporter.atMostAndNeverShouldNotBeUsedWithTimeout();
    }

    @Override // org.mockito.internal.verification.VerificationWrapper
    public VerificationMode copySelfWithNewVerificationMode(VerificationMode verificationMode) {
        return new Timeout(((VerificationOverTimeImpl) this.wrappedVerification).copyWithVerificationMode(verificationMode));
    }

    @Override // org.mockito.internal.verification.VerificationWrapper
    public VerificationMode never() {
        throw Reporter.atMostAndNeverShouldNotBeUsedWithTimeout();
    }

    public String toString() {
        return "Wanted after at most " + ((VerificationOverTimeImpl) this.wrappedVerification).getTimer().duration() + " ms: [" + ((VerificationOverTimeImpl) this.wrappedVerification).getDelegate() + "]";
    }

    public Timeout(long j6, long j7, VerificationMode verificationMode) {
        this(new VerificationOverTimeImpl(j6, j7, verificationMode, true));
    }

    public Timeout(long j6, VerificationMode verificationMode, Timer timer) {
        this(new VerificationOverTimeImpl(j6, verificationMode, true, timer));
    }

    public Timeout(VerificationOverTimeImpl verificationOverTimeImpl) {
        super(verificationOverTimeImpl);
    }
}
