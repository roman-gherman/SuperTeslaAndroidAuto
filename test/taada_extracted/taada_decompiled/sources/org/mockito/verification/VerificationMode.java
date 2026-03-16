package org.mockito.verification;

import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.internal.verification.api.VerificationData;

/* JADX INFO: loaded from: classes.dex */
public interface VerificationMode {
    default VerificationMode description(String str) {
        return VerificationModeFactory.description(this, str);
    }

    void verify(VerificationData verificationData);
}
