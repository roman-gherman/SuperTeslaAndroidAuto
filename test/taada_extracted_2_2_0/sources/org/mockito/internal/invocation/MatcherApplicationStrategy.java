package org.mockito.internal.invocation;

import B2.b;
import java.util.ArrayList;
import java.util.List;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;
import org.mockito.internal.matchers.VarargMatcher;
import org.mockito.invocation.Invocation;

/* JADX INFO: loaded from: classes.dex */
public class MatcherApplicationStrategy {
    private final Invocation invocation;
    private final List<? extends ArgumentMatcher<?>> matchers;

    private MatcherApplicationStrategy(Invocation invocation, List<? extends ArgumentMatcher<?>> list) {
        this.invocation = invocation;
        this.matchers = list;
    }

    private List<? extends ArgumentMatcher<?>> appendLastMatcherNTimes(int i) {
        ArgumentMatcher<?> argumentMatcherLastMatcher = lastMatcher();
        ArrayList arrayList = new ArrayList(this.matchers);
        for (int i3 = 0; i3 < i; i3++) {
            arrayList.add(argumentMatcherLastMatcher);
        }
        return arrayList;
    }

    private boolean argsMatch(Object[] objArr, List<? extends ArgumentMatcher<?>> list, ArgumentMatcherAction argumentMatcherAction) {
        for (int i = 0; i < objArr.length; i++) {
            if (!argumentMatcherAction.apply(list.get(i), objArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static MatcherApplicationStrategy getMatcherApplicationStrategyFor(Invocation invocation, List<? extends ArgumentMatcher<?>> list) {
        return new MatcherApplicationStrategy(invocation, list);
    }

    private boolean isLastMatcherVarargMatcher() {
        ArgumentMatcher<?> argumentMatcherLastMatcher = lastMatcher();
        return argumentMatcherLastMatcher instanceof HamcrestArgumentMatcher ? ((HamcrestArgumentMatcher) argumentMatcherLastMatcher).isVarargMatcher() : argumentMatcherLastMatcher instanceof VarargMatcher;
    }

    private ArgumentMatcher<?> lastMatcher() {
        return (ArgumentMatcher) b.b(1, this.matchers);
    }

    private Class<?> lastParameterType() {
        return this.invocation.getMethod().getParameterTypes()[r0.length - 1];
    }

    private int varargLength() {
        return this.invocation.getArguments().length - this.invocation.getRawArguments().length;
    }

    public boolean forEachMatcherAndArgument(ArgumentMatcherAction argumentMatcherAction) {
        boolean z6 = this.invocation.getMethod().isVarArgs() && this.invocation.getRawArguments().length == this.matchers.size();
        if (z6) {
            if (lastParameterType().isAssignableFrom(lastMatcher().type())) {
                return argsMatch(this.invocation.getRawArguments(), this.matchers, argumentMatcherAction);
            }
        }
        if (this.invocation.getArguments().length == this.matchers.size()) {
            return argsMatch(this.invocation.getArguments(), this.matchers, argumentMatcherAction);
        }
        if (z6 && isLastMatcherVarargMatcher()) {
            return argsMatch(this.invocation.getArguments(), appendLastMatcherNTimes(varargLength()), argumentMatcherAction);
        }
        return false;
    }
}
