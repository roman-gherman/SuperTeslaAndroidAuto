package org.mockito;

/* JADX INFO: loaded from: classes.dex */
public interface ScopedMock extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    void closeOnDemand();

    boolean isClosed();
}
