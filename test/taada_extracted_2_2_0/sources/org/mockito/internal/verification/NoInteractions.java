package org.mockito.internal.verification;

import java.util.List;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public class NoInteractions implements VerificationMode {
    @Override // org.mockito.verification.VerificationMode
    public void verify(VerificationData verificationData) {
        List<Invocation> allInvocations = verificationData.getAllInvocations();
        if (!allInvocations.isEmpty()) {
            throw Reporter.noInteractionsWanted(allInvocations.get(0).getMock(), allInvocations);
        }
    }
}
