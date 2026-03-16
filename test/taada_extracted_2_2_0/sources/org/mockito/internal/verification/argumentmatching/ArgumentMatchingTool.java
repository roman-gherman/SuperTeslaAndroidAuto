package org.mockito.internal.verification.argumentmatching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import o5.a;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.matchers.ContainsExtraTypeInfo;

/* JADX INFO: loaded from: classes.dex */
public class ArgumentMatchingTool {
    private ArgumentMatchingTool() {
    }

    public static Set<String> getNotMatchingArgsWithSameName(List<ArgumentMatcher> list, Object[] objArr) {
        Object wanted;
        HashMap map = new HashMap();
        for (ArgumentMatcher argumentMatcher : list) {
            if ((argumentMatcher instanceof ContainsExtraTypeInfo) && (wanted = ((ContainsExtraTypeInfo) argumentMatcher).getWanted()) != null) {
                Class<?> cls = wanted.getClass();
                ((Set) map.computeIfAbsent(cls.getSimpleName(), new a(0))).add(cls.getCanonicalName());
            }
        }
        for (Object obj : objArr) {
            if (obj != null) {
                Class<?> cls2 = obj.getClass();
                ((Set) map.computeIfAbsent(cls2.getSimpleName(), new a(1))).add(cls2.getCanonicalName());
            }
        }
        return (Set) map.entrySet().stream().filter(new n5.a(1)).map(new a(2)).collect(Collectors.toSet());
    }

    public static Integer[] getSuspiciouslyNotMatchingArgsIndexes(List<ArgumentMatcher> list, Object[] objArr) {
        if (list.size() != objArr.length) {
            return new Integer[0];
        }
        LinkedList linkedList = new LinkedList();
        int i = 0;
        for (ArgumentMatcher argumentMatcher : list) {
            if ((argumentMatcher instanceof ContainsExtraTypeInfo) && !safelyMatches(argumentMatcher, objArr[i]) && toStringEquals(argumentMatcher, objArr[i]) && !((ContainsExtraTypeInfo) argumentMatcher).typeMatches(objArr[i])) {
                linkedList.add(Integer.valueOf(i));
            }
            i++;
        }
        return (Integer[]) linkedList.toArray(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Set lambda$getNotMatchingArgsWithSameName$0(String str) {
        return new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Set lambda$getNotMatchingArgsWithSameName$1(String str) {
        return new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getNotMatchingArgsWithSameName$2(Map.Entry entry) {
        return ((Set) entry.getValue()).size() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getNotMatchingArgsWithSameName$3(Map.Entry entry) {
        return (String) entry.getKey();
    }

    private static boolean safelyMatches(ArgumentMatcher argumentMatcher, Object obj) {
        try {
            return argumentMatcher.matches(obj);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean toStringEquals(ArgumentMatcher argumentMatcher, Object obj) {
        return argumentMatcher.toString().equals(String.valueOf(obj));
    }
}
