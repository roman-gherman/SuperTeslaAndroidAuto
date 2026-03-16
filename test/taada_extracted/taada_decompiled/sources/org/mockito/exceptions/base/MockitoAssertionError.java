package org.mockito.exceptions.base;

import B2.b;
import org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter;

/* JADX INFO: loaded from: classes.dex */
public class MockitoAssertionError extends AssertionError {
    private static final long serialVersionUID = 1;
    private final StackTraceElement[] unfilteredStackTrace;

    public MockitoAssertionError(String str) {
        super(str);
        this.unfilteredStackTrace = getStackTrace();
        new ConditionalStackTraceFilter().filter(this);
    }

    public StackTraceElement[] getUnfilteredStackTrace() {
        return this.unfilteredStackTrace;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MockitoAssertionError(MockitoAssertionError mockitoAssertionError, String str) {
        StringBuilder sbL = b.l(str, "\n");
        sbL.append(mockitoAssertionError.getMessage());
        super(sbL.toString());
        super.setStackTrace(mockitoAssertionError.getStackTrace());
        this.unfilteredStackTrace = mockitoAssertionError.getUnfilteredStackTrace();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MockitoAssertionError(AssertionError assertionError, String str) {
        StringBuilder sbL = b.l(str, "\n");
        sbL.append(assertionError.getMessage());
        super(sbL.toString());
        StackTraceElement[] stackTrace = assertionError.getStackTrace();
        this.unfilteredStackTrace = stackTrace;
        super.setStackTrace(stackTrace);
    }
}
