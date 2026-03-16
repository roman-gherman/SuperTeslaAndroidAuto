package org.mockito.internal.verification;

import org.mockito.internal.util.Timer;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public class VerificationOverTimeImpl implements VerificationMode {
    private final VerificationMode delegate;
    private final long pollingPeriodMillis;
    private final boolean returnOnSuccess;
    private final Timer timer;

    public VerificationOverTimeImpl(long j6, long j7, VerificationMode verificationMode, boolean z6) {
        this(j6, verificationMode, z6, new Timer(j7));
    }

    private AssertionError handleVerifyException(AssertionError assertionError) {
        if (!canRecoverFromFailure(this.delegate)) {
            throw assertionError;
        }
        sleep(this.pollingPeriodMillis);
        return assertionError;
    }

    private void sleep(long j6) {
        try {
            Thread.sleep(j6);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread sleep has been interrupted", e);
        }
    }

    public boolean canRecoverFromFailure(VerificationMode verificationMode) {
        return ((verificationMode instanceof AtMost) || (verificationMode instanceof NoMoreInteractions)) ? false : true;
    }

    public VerificationOverTimeImpl copyWithVerificationMode(VerificationMode verificationMode) {
        return new VerificationOverTimeImpl(this.pollingPeriodMillis, this.timer.duration(), verificationMode, this.returnOnSuccess);
    }

    public VerificationMode getDelegate() {
        return this.delegate;
    }

    public long getPollingPeriodMillis() {
        return this.pollingPeriodMillis;
    }

    public Timer getTimer() {
        return this.timer;
    }

    public boolean isReturnOnSuccess() {
        return this.returnOnSuccess;
    }

    @Override // org.mockito.verification.VerificationMode
    public void verify(VerificationData verificationData) {
        this.timer.start();
        do {
            AssertionError assertionErrorHandleVerifyException = null;
            while (this.timer.isCounting()) {
                try {
                    this.delegate.verify(verificationData);
                } catch (AssertionError e) {
                    assertionErrorHandleVerifyException = handleVerifyException(e);
                }
            }
            if (assertionErrorHandleVerifyException != null) {
                throw assertionErrorHandleVerifyException;
            }
            return;
        } while (!this.returnOnSuccess);
    }

    public VerificationOverTimeImpl(long j6, VerificationMode verificationMode, boolean z6, Timer timer) {
        this.pollingPeriodMillis = j6;
        this.delegate = verificationMode;
        this.returnOnSuccess = z6;
        this.timer = timer;
    }
}
