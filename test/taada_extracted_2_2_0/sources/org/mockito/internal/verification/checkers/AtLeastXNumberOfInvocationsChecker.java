package org.mockito.internal.verification.checkers;

import java.util.List;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.invocation.InvocationMarker;
import org.mockito.internal.invocation.InvocationsFinder;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;

/* JADX INFO: loaded from: classes.dex */
public final class AtLeastXNumberOfInvocationsChecker {
    private AtLeastXNumberOfInvocationsChecker() {
    }

    public static void checkAtLeastNumberOfInvocations(List<Invocation> list, MatchableInvocation matchableInvocation, int i) {
        List<Invocation> listFindInvocations = InvocationsFinder.findInvocations(list, matchableInvocation);
        int size = listFindInvocations.size();
        if (i <= size) {
            InvocationMarker.markVerified(listFindInvocations, matchableInvocation);
        } else {
            throw Reporter.tooFewActualInvocations(new AtLeastDiscrepancy(i, size), matchableInvocation, InvocationsFinder.getAllLocations(listFindInvocations));
        }
    }

    public static void checkAtLeastNumberOfInvocations(List<Invocation> list, MatchableInvocation matchableInvocation, int i, InOrderContext inOrderContext) {
        List<Invocation> listFindAllMatchingUnverifiedChunks = InvocationsFinder.findAllMatchingUnverifiedChunks(list, matchableInvocation, inOrderContext);
        int size = listFindAllMatchingUnverifiedChunks.size();
        if (i <= size) {
            InvocationMarker.markVerifiedInOrder(listFindAllMatchingUnverifiedChunks, matchableInvocation, inOrderContext);
        } else {
            throw Reporter.tooFewActualInvocationsInOrder(new AtLeastDiscrepancy(i, size), matchableInvocation, InvocationsFinder.getAllLocations(listFindAllMatchingUnverifiedChunks));
        }
    }
}
