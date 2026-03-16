package org.mockito.internal.matchers.text;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.matchers.ContainsExtraTypeInfo;
import org.mockito.internal.reporting.PrintSettings;

/* JADX INFO: loaded from: classes.dex */
public class MatchersPrinter {
    private Iterator<FormattedText> applyPrintSettings(List<ArgumentMatcher> list, PrintSettings printSettings) {
        LinkedList linkedList = new LinkedList();
        int i = 0;
        for (ArgumentMatcher argumentMatcher : list) {
            if (argumentMatcher instanceof ContainsExtraTypeInfo) {
                ContainsExtraTypeInfo containsExtraTypeInfo = (ContainsExtraTypeInfo) argumentMatcher;
                Object wanted = containsExtraTypeInfo.getWanted();
                String simpleName = wanted != null ? wanted.getClass().getSimpleName() : "";
                String canonicalName = wanted != null ? wanted.getClass().getCanonicalName() : "";
                if (printSettings.extraTypeInfoFor(i)) {
                    linkedList.add(new FormattedText(containsExtraTypeInfo.toStringWithType(simpleName)));
                } else if (printSettings.fullyQualifiedNameFor(simpleName)) {
                    linkedList.add(new FormattedText(containsExtraTypeInfo.toStringWithType(canonicalName)));
                } else {
                    linkedList.add(new FormattedText(MatcherToString.toString(argumentMatcher)));
                }
            } else {
                linkedList.add(new FormattedText(MatcherToString.toString(argumentMatcher)));
            }
            i++;
        }
        return linkedList.iterator();
    }

    public String getArgumentsBlock(List<ArgumentMatcher> list, PrintSettings printSettings) {
        return ValuePrinter.printValues("(\n    ", ",\n    ", "\n);", applyPrintSettings(list, printSettings));
    }

    public String getArgumentsLine(List<ArgumentMatcher> list, PrintSettings printSettings) {
        return ValuePrinter.printValues("(", ", ", ");", applyPrintSettings(list, printSettings));
    }
}
