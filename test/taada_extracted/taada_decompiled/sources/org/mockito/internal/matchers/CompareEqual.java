package org.mockito.internal.matchers;

import java.io.Serializable;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes.dex */
public class CompareEqual<T extends Comparable<T>> extends CompareTo<T> implements Serializable {
    public CompareEqual(T t6) {
        super(t6);
    }

    @Override // org.mockito.internal.matchers.CompareTo
    public String getName() {
        return "cmpEq";
    }

    @Override // org.mockito.internal.matchers.CompareTo
    public boolean matchResult(int i) {
        return i == 0;
    }
}
