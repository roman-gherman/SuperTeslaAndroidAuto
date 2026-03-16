package org.mockito.internal.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoSession;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.exceptions.misusing.RedundantListenerException;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.junit.TestFinishedEvent;
import org.mockito.internal.junit.UniversalTestListener;
import org.mockito.plugins.MockitoLogger;
import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
public class DefaultMockitoSession implements MockitoSession {
    private final List<AutoCloseable> closeables = new ArrayList();
    private final UniversalTestListener listener;
    private final String name;

    public DefaultMockitoSession(List<Object> list, String str, Strictness strictness, MockitoLogger mockitoLogger) {
        this.name = str;
        UniversalTestListener universalTestListener = new UniversalTestListener(strictness, mockitoLogger);
        this.listener = universalTestListener;
        try {
            Mockito.framework().addListener(universalTestListener);
        } catch (RedundantListenerException unused) {
            Reporter.unfinishedMockingSession();
        }
        try {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                this.closeables.add(MockitoAnnotations.openMocks(it.next()));
            }
        } catch (RuntimeException e) {
            try {
                release();
            } catch (Throwable th) {
                e.addSuppressed(th);
            }
            this.listener.setListenerDirty();
            throw e;
        }
    }

    private void release() {
        for (AutoCloseable autoCloseable : this.closeables) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                throw new MockitoException("Failed to release " + autoCloseable, e);
            }
        }
    }

    @Override // org.mockito.MockitoSession
    public void finishMocking() {
        finishMocking(null);
    }

    @Override // org.mockito.MockitoSession
    public void setStrictness(Strictness strictness) {
        this.listener.setStrictness(strictness);
    }

    @Override // org.mockito.MockitoSession
    public void finishMocking(final Throwable th) {
        try {
            Mockito.framework().removeListener(this.listener);
            this.listener.testFinished(new TestFinishedEvent() { // from class: org.mockito.internal.framework.DefaultMockitoSession.1
                @Override // org.mockito.internal.junit.TestFinishedEvent
                public Throwable getFailure() {
                    return th;
                }

                @Override // org.mockito.internal.junit.TestFinishedEvent
                public String getTestName() {
                    return DefaultMockitoSession.this.name;
                }
            });
            if (th == null) {
                Mockito.validateMockitoUsage();
            }
        } finally {
            release();
        }
    }
}
