package org.mockito.internal.exceptions;

import org.mockito.invocation.DescribedInvocation;

/* JADX INFO: loaded from: classes.dex */
public interface VerificationAwareInvocation extends DescribedInvocation {
    boolean isVerified();
}
