package org.mockito.internal.matchers;

import java.io.Serializable;
import java.util.Objects;
import org.mockito.ArgumentMatcher;

/* JADX INFO: loaded from: classes.dex */
public class Null<T> implements ArgumentMatcher<T>, Serializable {
    public static final Null<Object> NULL = new Null<>(Object.class);
    private final Class<T> type;

    public Null(Class<T> cls) {
        Objects.requireNonNull(cls);
        this.type = cls;
    }

    @Override // org.mockito.ArgumentMatcher
    public boolean matches(Object obj) {
        return obj == null;
    }

    public String toString() {
        return "isNull()";
    }

    @Override // org.mockito.ArgumentMatcher
    public Class<T> type() {
        return this.type;
    }
}
