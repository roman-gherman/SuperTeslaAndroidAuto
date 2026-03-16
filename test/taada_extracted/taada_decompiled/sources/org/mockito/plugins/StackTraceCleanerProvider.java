package org.mockito.plugins;

import org.mockito.exceptions.stacktrace.StackTraceCleaner;

/* JADX INFO: loaded from: classes.dex */
public interface StackTraceCleanerProvider {
    StackTraceCleaner getStackTraceCleaner(StackTraceCleaner stackTraceCleaner);
}
