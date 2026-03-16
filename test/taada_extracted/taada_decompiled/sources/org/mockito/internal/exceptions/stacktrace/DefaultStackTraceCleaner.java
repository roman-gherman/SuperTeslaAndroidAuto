package org.mockito.internal.exceptions.stacktrace;

import org.mockito.exceptions.stacktrace.StackTraceCleaner;

/* JADX INFO: loaded from: classes.dex */
public class DefaultStackTraceCleaner implements StackTraceCleaner {
    private static boolean isFromMockito(String str) {
        return str.startsWith("org.mockito.");
    }

    private static boolean isFromMockitoRule(String str) {
        return str.startsWith("org.mockito.internal.junit.JUnitRule");
    }

    private static boolean isFromMockitoRunner(String str) {
        return str.startsWith("org.mockito.internal.runners.") || str.startsWith("org.mockito.runners.") || str.startsWith("org.mockito.junit.");
    }

    private static boolean isMockDispatcher(String str) {
        return str.contains("$$EnhancerByMockitoWithCGLIB$$") || str.contains("$MockitoMock$");
    }

    @Override // org.mockito.exceptions.stacktrace.StackTraceCleaner
    public boolean isIn(StackTraceElement stackTraceElement) {
        return isIn(stackTraceElement.getClassName());
    }

    @Override // org.mockito.exceptions.stacktrace.StackTraceCleaner
    public boolean isIn(StackTraceCleaner.StackFrameMetadata stackFrameMetadata) {
        return isIn(stackFrameMetadata.getClassName());
    }

    private boolean isIn(String str) {
        if (isFromMockitoRunner(str) || isFromMockitoRule(str)) {
            return true;
        }
        return (isMockDispatcher(str) || isFromMockito(str)) ? false : true;
    }
}
