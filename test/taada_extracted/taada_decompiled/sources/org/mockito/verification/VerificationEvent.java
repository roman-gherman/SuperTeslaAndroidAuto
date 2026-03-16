package org.mockito.verification;

import org.mockito.internal.verification.api.VerificationData;

/* JADX INFO: loaded from: classes.dex */
public interface VerificationEvent {
    VerificationData getData();

    Object getMock();

    VerificationMode getMode();

    Throwable getVerificationError();
}
