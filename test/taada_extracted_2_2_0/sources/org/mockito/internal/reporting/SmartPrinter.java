package org.mockito.internal.reporting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;

/* JADX INFO: loaded from: classes.dex */
public class SmartPrinter {
    private final List<String> actuals;
    private final String wanted;

    public SmartPrinter(MatchableInvocation matchableInvocation, Invocation invocation, Integer... numArr) {
        this(matchableInvocation, Collections.singletonList(invocation), numArr, Collections.EMPTY_SET);
    }

    private static boolean isMultiLine(MatchableInvocation matchableInvocation, List<Invocation> list) {
        boolean zContains = matchableInvocation.toString().contains("\n");
        Iterator<Invocation> it = list.iterator();
        boolean zContains2 = false;
        while (it.hasNext()) {
            zContains2 |= it.next().toString().contains("\n");
        }
        return zContains || zContains2;
    }

    public List<String> getActuals() {
        return this.actuals;
    }

    public String getWanted() {
        return this.wanted;
    }

    public SmartPrinter(MatchableInvocation matchableInvocation, List<Invocation> list, Integer[] numArr, Set<String> set) {
        PrintSettings printSettings = new PrintSettings();
        printSettings.setMultiline(isMultiLine(matchableInvocation, list));
        printSettings.setMatchersToBeDescribedWithExtraTypeInfo(numArr);
        printSettings.setMatchersToBeDescribedWithFullName(set);
        this.wanted = printSettings.print(matchableInvocation);
        ArrayList arrayList = new ArrayList();
        Iterator<Invocation> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(printSettings.print(it.next()));
        }
        this.actuals = Collections.unmodifiableList(arrayList);
    }
}
