package org.mockito.verification;

import org.mockito.internal.verification.VerificationOverTimeImpl;
import org.mockito.internal.verification.VerificationWrapper;

/* JADX INFO: loaded from: classes.dex */
public class After extends VerificationWrapper<VerificationOverTimeImpl> implements VerificationAfterDelay {
    public After(long j6, VerificationMode verificationMode) {
        this(10L, j6, verificationMode);
    }

    @Override // org.mockito.internal.verification.VerificationWrapper
    public VerificationMode copySelfWithNewVerificationMode(VerificationMode verificationMode) {
        return new After(((VerificationOverTimeImpl) this.wrappedVerification).copyWithVerificationMode(verificationMode));
    }

    public String toString() {
        return "Wanted after " + ((VerificationOverTimeImpl) this.wrappedVerification).getTimer().duration() + " ms: [" + ((VerificationOverTimeImpl) this.wrappedVerification).getDelegate() + "]";
    }

    public After(long j6, long j7, VerificationMode verificationMode) {
        this(new VerificationOverTimeImpl(j6, j7, verificationMode, false));
    }

    public After(VerificationOverTimeImpl verificationOverTimeImpl) {
        super(verificationOverTimeImpl);
    }
}
