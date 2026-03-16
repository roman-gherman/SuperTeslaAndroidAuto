package org.mockito.internal.verification.api;

import java.util.List;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;

/* JADX INFO: loaded from: classes.dex */
public interface VerificationData {
    List<Invocation> getAllInvocations();

    MatchableInvocation getTarget();
}
