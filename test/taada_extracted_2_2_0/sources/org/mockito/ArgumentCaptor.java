package org.mockito;

import java.util.List;
import org.mockito.internal.matchers.CapturingMatcher;
import org.mockito.internal.util.Primitives;

/* JADX INFO: loaded from: classes.dex */
public class ArgumentCaptor<T> {
    private final CapturingMatcher<T> capturingMatcher;
    private final Class<? extends T> clazz;

    private ArgumentCaptor(Class<? extends T> cls) {
        this.clazz = cls;
        this.capturingMatcher = new CapturingMatcher<>(cls);
    }

    public static <U, S extends U> ArgumentCaptor<U> forClass(Class<S> cls) {
        return new ArgumentCaptor<>(cls);
    }

    public T capture() {
        ArgumentMatchers.argThat(this.capturingMatcher);
        return (T) Primitives.defaultValue(this.clazz);
    }

    public List<T> getAllValues() {
        return this.capturingMatcher.getAllValues();
    }

    public T getValue() {
        return this.capturingMatcher.getLastValue();
    }
}
