package org.mockito.internal;

import java.util.Collections;
import java.util.List;
import org.mockito.MockedConstruction;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.debugging.LocationFactory;
import org.mockito.internal.util.StringUtil;
import org.mockito.invocation.Location;
import org.mockito.plugins.MockMaker;

/* JADX INFO: loaded from: classes.dex */
public final class MockedConstructionImpl<T> implements MockedConstruction<T> {
    private boolean closed;
    private final MockMaker.ConstructionMockControl<T> control;
    private final Location location = LocationFactory.create();

    public MockedConstructionImpl(MockMaker.ConstructionMockControl<T> constructionMockControl) {
        this.control = constructionMockControl;
    }

    private void assertNotClosed() {
        if (this.closed) {
            throw new MockitoException(StringUtil.join("The static mock created at", this.location.toString(), "is already resolved and cannot longer be used"));
        }
    }

    @Override // org.mockito.ScopedMock, java.lang.AutoCloseable
    public void close() {
        assertNotClosed();
        this.closed = true;
        this.control.disable();
    }

    @Override // org.mockito.ScopedMock
    public void closeOnDemand() {
        if (this.closed) {
            return;
        }
        close();
    }

    @Override // org.mockito.MockedConstruction
    public List<T> constructed() {
        return Collections.unmodifiableList(this.control.getMocks());
    }

    @Override // org.mockito.ScopedMock
    public boolean isClosed() {
        return this.closed;
    }
}
