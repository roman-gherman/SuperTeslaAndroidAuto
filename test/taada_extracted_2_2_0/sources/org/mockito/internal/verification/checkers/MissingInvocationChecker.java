package org.mockito.internal.verification.checkers;

import java.util.List;
import java.util.stream.Collectors;
import o5.a;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.invocation.InvocationsFinder;
import org.mockito.internal.reporting.SmartPrinter;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.internal.verification.argumentmatching.ArgumentMatchingTool;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;

/* JADX INFO: loaded from: classes.dex */
public class MissingInvocationChecker {
    private MissingInvocationChecker() {
    }

    public static void checkMissingInvocation(List<Invocation> list, MatchableInvocation matchableInvocation) {
        if (InvocationsFinder.findInvocations(list, matchableInvocation).isEmpty()) {
            Invocation invocationFindSimilarInvocation = InvocationsFinder.findSimilarInvocation(list, matchableInvocation);
            if (invocationFindSimilarInvocation == null) {
                throw Reporter.wantedButNotInvoked(matchableInvocation, list);
            }
            SmartPrinter smartPrinter = new SmartPrinter(matchableInvocation, list, ArgumentMatchingTool.getSuspiciouslyNotMatchingArgsIndexes(matchableInvocation.getMatchers(), invocationFindSimilarInvocation.getArguments()), ArgumentMatchingTool.getNotMatchingArgsWithSameName(matchableInvocation.getMatchers(), invocationFindSimilarInvocation.getArguments()));
            throw Reporter.argumentsAreDifferent(smartPrinter.getWanted(), smartPrinter.getActuals(), (List) list.stream().map(new a(5)).collect(Collectors.toList()));
        }
    }

    public static void checkMissingInvocation(List<Invocation> list, MatchableInvocation matchableInvocation, InOrderContext inOrderContext) {
        if (InvocationsFinder.findAllMatchingUnverifiedChunks(list, matchableInvocation, inOrderContext).isEmpty()) {
            Invocation invocationFindPreviousVerifiedInOrder = InvocationsFinder.findPreviousVerifiedInOrder(list, inOrderContext);
            if (invocationFindPreviousVerifiedInOrder == null) {
                checkMissingInvocation(list, matchableInvocation);
                return;
            }
            throw Reporter.wantedButNotInvokedInOrder(matchableInvocation, invocationFindPreviousVerifiedInOrder);
        }
    }
}
