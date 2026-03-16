package org.mockito;

/* JADX INFO: loaded from: classes.dex */
@FunctionalInterface
public interface ArgumentMatcher<T> {
    boolean matches(T t6);

    default Class<?> type() {
        return Void.class;
    }
}
