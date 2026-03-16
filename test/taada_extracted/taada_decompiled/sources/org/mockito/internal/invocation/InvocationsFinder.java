package org.mockito.internal.invocation;

import B2.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.mockito.internal.debugging.d;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.Location;
import org.mockito.invocation.MatchableInvocation;

/* JADX INFO: loaded from: classes.dex */
public class InvocationsFinder {
    private InvocationsFinder() {
    }

    public static List<Invocation> findAllMatchingUnverifiedChunks(List<Invocation> list, MatchableInvocation matchableInvocation, InOrderContext inOrderContext) {
        Stream<Invocation> stream = removeVerifiedInOrder(list, inOrderContext).stream();
        Objects.requireNonNull(matchableInvocation);
        return (List) stream.filter(new d(matchableInvocation, 2)).collect(Collectors.toList());
    }

    public static Invocation findFirstMatchingUnverifiedInvocation(List<Invocation> list, MatchableInvocation matchableInvocation, InOrderContext inOrderContext) {
        for (Invocation invocation : removeVerifiedInOrder(list, inOrderContext)) {
            if (matchableInvocation.matches(invocation)) {
                return invocation;
            }
        }
        return null;
    }

    public static Invocation findFirstUnverified(List<Invocation> list) {
        return findFirstUnverified(list, null);
    }

    public static Invocation findFirstUnverifiedInOrder(InOrderContext inOrderContext, List<Invocation> list) {
        while (true) {
            Invocation invocation = null;
            for (Invocation invocation2 : list) {
                if (!inOrderContext.isVerified(invocation2)) {
                    if (invocation == null) {
                        invocation = invocation2;
                    }
                }
            }
            return invocation;
        }
    }

    public static List<Invocation> findInvocations(List<Invocation> list, MatchableInvocation matchableInvocation) {
        Stream<Invocation> stream = list.stream();
        Objects.requireNonNull(matchableInvocation);
        return (List) stream.filter(new d(matchableInvocation, 2)).collect(Collectors.toList());
    }

    public static List<Invocation> findMatchingChunk(List<Invocation> list, MatchableInvocation matchableInvocation, int i, InOrderContext inOrderContext) {
        List<Invocation> firstMatchingChunk = getFirstMatchingChunk(matchableInvocation, removeVerifiedInOrder(list, inOrderContext));
        return i != firstMatchingChunk.size() ? findAllMatchingUnverifiedChunks(list, matchableInvocation, inOrderContext) : firstMatchingChunk;
    }

    public static Invocation findPreviousVerifiedInOrder(List<Invocation> list, InOrderContext inOrderContext) {
        Stream<Invocation> stream = list.stream();
        Objects.requireNonNull(inOrderContext);
        List list2 = (List) stream.filter(new d(inOrderContext, 1)).collect(Collectors.toList());
        if (list2.isEmpty()) {
            return null;
        }
        return (Invocation) b.b(1, list2);
    }

    public static Invocation findSimilarInvocation(List<Invocation> list, MatchableInvocation matchableInvocation) {
        Invocation invocation = null;
        for (Invocation invocation2 : list) {
            if (matchableInvocation.hasSimilarMethod(invocation2)) {
                if (invocation == null) {
                    invocation = invocation2;
                }
                if (matchableInvocation.hasSameMethod(invocation2)) {
                    return invocation2;
                }
            }
        }
        return invocation;
    }

    public static List<Location> getAllLocations(List<Invocation> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<Invocation> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().getLocation());
        }
        return linkedList;
    }

    private static List<Invocation> getFirstMatchingChunk(MatchableInvocation matchableInvocation, List<Invocation> list) {
        LinkedList linkedList = new LinkedList();
        for (Invocation invocation : list) {
            if (!matchableInvocation.matches(invocation)) {
                if (!linkedList.isEmpty()) {
                    break;
                }
            } else {
                linkedList.add(invocation);
            }
        }
        return linkedList;
    }

    public static Location getLastLocation(List<Invocation> list) {
        if (list.isEmpty()) {
            return null;
        }
        return ((Invocation) b.b(1, list)).getLocation();
    }

    private static List<Invocation> removeVerifiedInOrder(List<Invocation> list, InOrderContext inOrderContext) {
        LinkedList linkedList = new LinkedList();
        for (Invocation invocation : list) {
            if (inOrderContext.isVerified(invocation)) {
                linkedList.clear();
            } else {
                linkedList.add(invocation);
            }
        }
        return linkedList;
    }

    public static Invocation findFirstUnverified(List<Invocation> list, Object obj) {
        for (Invocation invocation : list) {
            boolean z6 = obj == null || obj == invocation.getMock();
            if (!invocation.isVerified() && z6) {
                return invocation;
            }
        }
        return null;
    }
}
