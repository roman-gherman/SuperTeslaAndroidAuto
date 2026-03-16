package org.mockito.internal.matchers;

import java.io.Serializable;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes.dex */
public class LessThan<T extends Comparable<T>> extends CompareTo<T> implements Serializable {
    public LessThan(T t6) {
        super(t6);
    }

    @Override // org.mockito.internal.matchers.CompareTo
    public String getName() {
        return "lt";
    }

    @Override // org.mockito.internal.matchers.CompareTo
    public boolean matchResult(int i) {
        return i < 0;
    }
}
