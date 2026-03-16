package org.mockito.internal.invocation.mockref;

/* JADX INFO: loaded from: classes.dex */
public class MockStrongReference<T> implements MockReference<T> {
    private final boolean deserializeAsWeakRef;
    private final T ref;

    public MockStrongReference(T t6, boolean z6) {
        this.ref = t6;
        this.deserializeAsWeakRef = z6;
    }

    private Object readResolve() {
        return this.deserializeAsWeakRef ? new MockWeakReference(this.ref) : this;
    }

    @Override // org.mockito.internal.invocation.mockref.MockReference
    public T get() {
        return this.ref;
    }
}
