package org.mockito.internal.invocation;

import org.mockito.ArgumentMatcher;

/* JADX INFO: loaded from: classes.dex */
public interface ArgumentMatcherAction {
    boolean apply(ArgumentMatcher<?> argumentMatcher, Object obj);
}
