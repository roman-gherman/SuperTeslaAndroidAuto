package org.mockito.internal.verification;

import java.util.Iterator;
import java.util.List;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.invocation.InvocationMarker;
import org.mockito.internal.invocation.InvocationsFinder;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public class AtMost implements VerificationMode {
    private final int maxNumberOfInvocations;

    public AtMost(int i) {
        if (i < 0) {
            throw new MockitoException("Negative value is not allowed here");
        }
        this.maxNumberOfInvocations = i;
    }

    private void removeAlreadyVerified(List<Invocation> list) {
        Iterator<Invocation> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isVerified()) {
                it.remove();
            }
        }
    }

    public String toString() {
        return "Wanted invocations count: at most " + this.maxNumberOfInvocations;
    }

    @Override // org.mockito.verification.VerificationMode
    public void verify(VerificationData verificationData) {
        List<Invocation> allInvocations = verificationData.getAllInvocations();
        MatchableInvocation target = verificationData.getTarget();
        List<Invocation> listFindInvocations = InvocationsFinder.findInvocations(allInvocations, target);
        int size = listFindInvocations.size();
        int i = this.maxNumberOfInvocations;
        if (size > i) {
            throw Reporter.wantedAtMostX(i, size);
        }
        removeAlreadyVerified(listFindInvocations);
        InvocationMarker.markVerified(listFindInvocations, target);
    }
}
