package org.mockito.internal.invocation.mockref;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class MockWeakReference<T> implements MockReference<T> {
    private final WeakReference<T> ref;

    public MockWeakReference(T t6) {
        this.ref = new WeakReference<>(t6);
    }

    private Object writeReplace() {
        return new MockStrongReference(get(), true);
    }

    @Override // org.mockito.internal.invocation.mockref.MockReference
    public T get() {
        T t6 = this.ref.get();
        if (t6 != null) {
            return t6;
        }
        throw new IllegalStateException("The mock object was garbage collected. This should not happen in normal circumstances when using public API. Typically, the test class keeps strong reference to the mock object and it prevents getting the mock collected. Mockito internally needs to keep weak references to mock objects to avoid memory leaks for certain types of MockMaker implementations. If you see this exception using Mockito public API, please file a bug. For more information see issue #1313.");
    }
}
