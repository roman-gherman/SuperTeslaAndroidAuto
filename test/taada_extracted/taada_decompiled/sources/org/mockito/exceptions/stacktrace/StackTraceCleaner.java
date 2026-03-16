package org.mockito.exceptions.stacktrace;

/* JADX INFO: loaded from: classes.dex */
public interface StackTraceCleaner {

    public interface StackFrameMetadata {
        String getClassName();

        String getFileName();

        int getLineNumber();

        String getMethodName();
    }

    boolean isIn(StackTraceElement stackTraceElement);

    default boolean isIn(StackFrameMetadata stackFrameMetadata) {
        return isIn(new StackTraceElement(stackFrameMetadata.getClassName(), stackFrameMetadata.getMethodName(), stackFrameMetadata.getFileName(), stackFrameMetadata.getLineNumber()));
    }
}
