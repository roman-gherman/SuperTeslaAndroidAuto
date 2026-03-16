package org.mockito.listeners;

import org.mockito.verification.VerificationEvent;

/* JADX INFO: loaded from: classes.dex */
public interface VerificationListener extends MockitoListener {
    void onVerification(VerificationEvent verificationEvent);
}
