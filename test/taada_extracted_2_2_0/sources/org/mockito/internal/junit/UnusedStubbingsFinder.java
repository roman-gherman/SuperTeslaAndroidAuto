package org.mockito.internal.junit;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;
import org.mockito.internal.invocation.finder.AllInvocationsFinder;
import org.mockito.internal.stubbing.UnusedStubbingReporting;
import org.mockito.invocation.Invocation;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
public class UnusedStubbingsFinder {
    public UnusedStubbings getUnusedStubbings(Iterable<Object> iterable) {
        return new UnusedStubbings((Collection) AllInvocationsFinder.findStubbings(iterable).stream().filter(new c()).collect(Collectors.toList()));
    }

    public Collection<Invocation> getUnusedStubbingsByLocation(Iterable<Object> iterable) {
        Set<Stubbing> setFindStubbings = AllInvocationsFinder.findStubbings(iterable);
        HashSet hashSet = new HashSet();
        for (Stubbing stubbing : setFindStubbings) {
            if (!UnusedStubbingReporting.shouldBeReported(stubbing)) {
                hashSet.add(stubbing.getInvocation().getLocation().toString());
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Stubbing stubbing2 : setFindStubbings) {
            String string = stubbing2.getInvocation().getLocation().toString();
            if (!hashSet.contains(string)) {
                linkedHashMap.put(string, stubbing2.getInvocation());
            }
        }
        return linkedHashMap.values();
    }
}
