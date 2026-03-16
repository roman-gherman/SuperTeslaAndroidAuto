package org.mockito.internal.debugging;

import java.io.Serializable;
import org.mockito.internal.exceptions.stacktrace.StackTraceFilter;
import org.mockito.invocation.Location;

/* JADX INFO: loaded from: classes.dex */
class Java8LocationImpl implements Location, Serializable {
    private static final long serialVersionUID = -9054861157390980624L;
    private static final StackTraceFilter stackTraceFilter = new StackTraceFilter();
    private String sourceFile;
    private String stackTraceLine;

    public Java8LocationImpl(Throwable th, boolean z6) {
        this(stackTraceFilter, th, z6);
    }

    private void computeStackTraceInformation(StackTraceFilter stackTraceFilter2, Throwable th, boolean z6) {
        StackTraceElement stackTraceElementFilterFirst = stackTraceFilter2.filterFirst(th, z6);
        if (stackTraceElementFilterFirst == null) {
            this.stackTraceLine = "-> at <<unknown line>>";
            this.sourceFile = "<unknown source file>";
        } else {
            this.stackTraceLine = "-> at " + stackTraceElementFilterFirst;
            this.sourceFile = stackTraceElementFilterFirst.getFileName();
        }
    }

    @Override // org.mockito.invocation.Location
    public String getSourceFile() {
        return this.sourceFile;
    }

    @Override // org.mockito.invocation.Location
    public String toString() {
        return this.stackTraceLine;
    }

    private Java8LocationImpl(StackTraceFilter stackTraceFilter2, Throwable th, boolean z6) {
        computeStackTraceInformation(stackTraceFilter2, th, z6);
    }
}
