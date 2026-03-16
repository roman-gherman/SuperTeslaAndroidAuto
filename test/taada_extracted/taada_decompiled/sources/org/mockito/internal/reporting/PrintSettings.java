package org.mockito.internal.reporting;

import B2.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.matchers.text.MatchersPrinter;
import org.mockito.internal.util.MockUtil;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;

/* JADX INFO: loaded from: classes.dex */
public class PrintSettings {
    public static final int MAX_LINE_LENGTH = 45;
    private boolean multiline;
    private List<Integer> withTypeInfo = new LinkedList();
    private Set<String> withFullyQualifiedName = Collections.EMPTY_SET;

    public static PrintSettings verboseMatchers(Integer... numArr) {
        PrintSettings printSettings = new PrintSettings();
        printSettings.setMatchersToBeDescribedWithExtraTypeInfo(numArr);
        return printSettings;
    }

    public boolean extraTypeInfoFor(int i) {
        return this.withTypeInfo.contains(Integer.valueOf(i));
    }

    public boolean fullyQualifiedNameFor(String str) {
        return this.withFullyQualifiedName.contains(str);
    }

    public boolean isMultiline() {
        return this.multiline;
    }

    public String print(List<ArgumentMatcher> list, Invocation invocation) {
        MatchersPrinter matchersPrinter = new MatchersPrinter();
        String str = MockUtil.getMockName(invocation.getMock()) + "." + invocation.getMethod().getName();
        StringBuilder sbK = b.k(str);
        sbK.append(matchersPrinter.getArgumentsLine(list, this));
        String string = sbK.toString();
        if (!isMultiline() && (list.isEmpty() || string.length() <= 45)) {
            return string;
        }
        StringBuilder sbK2 = b.k(str);
        sbK2.append(matchersPrinter.getArgumentsBlock(list, this));
        return sbK2.toString();
    }

    public void setMatchersToBeDescribedWithExtraTypeInfo(Integer[] numArr) {
        this.withTypeInfo = Arrays.asList(numArr);
    }

    public void setMatchersToBeDescribedWithFullName(Set<String> set) {
        this.withFullyQualifiedName = set;
    }

    public void setMultiline(boolean z6) {
        this.multiline = z6;
    }

    public String print(Invocation invocation) {
        return print(invocation.getArgumentsAsMatchers(), invocation);
    }

    public String print(MatchableInvocation matchableInvocation) {
        return print(matchableInvocation.getMatchers(), matchableInvocation.getInvocation());
    }
}
