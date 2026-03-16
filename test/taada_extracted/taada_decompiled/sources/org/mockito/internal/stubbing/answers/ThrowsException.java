package org.mockito.internal.stubbing.answers;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ThrowsException extends AbstractThrowsException implements Serializable {
    private static final long serialVersionUID = 1128820328555183980L;
    private final Throwable throwable;

    public ThrowsException(Throwable th) {
        this.throwable = th;
    }

    @Override // org.mockito.internal.stubbing.answers.AbstractThrowsException
    public Throwable getThrowable() {
        return this.throwable;
    }
}
