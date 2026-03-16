package org.mockito.internal.matchers;

import java.io.Serializable;
import java.lang.Comparable;
import org.mockito.ArgumentMatcher;

/* JADX INFO: loaded from: classes.dex */
public abstract class CompareTo<T extends Comparable<T>> implements ArgumentMatcher<T>, Serializable {
    private final T wanted;

    public CompareTo(T t6) {
        this.wanted = t6;
    }

    public abstract String getName();

    public abstract boolean matchResult(int i);

    public final String toString() {
        return getName() + "(" + this.wanted + ")";
    }

    @Override // org.mockito.ArgumentMatcher
    public final boolean matches(T t6) {
        if (t6 != null && t6.getClass().isInstance(this.wanted)) {
            return matchResult(t6.compareTo(this.wanted));
        }
        return false;
    }
}
