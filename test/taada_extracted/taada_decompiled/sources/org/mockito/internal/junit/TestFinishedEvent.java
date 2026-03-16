package org.mockito.internal.junit;

/* JADX INFO: loaded from: classes.dex */
public interface TestFinishedEvent {
    Throwable getFailure();

    String getTestName();
}
