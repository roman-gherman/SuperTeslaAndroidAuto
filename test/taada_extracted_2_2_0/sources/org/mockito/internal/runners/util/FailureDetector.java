package org.mockito.internal.runners.util;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* JADX INFO: loaded from: classes.dex */
public class FailureDetector extends RunListener {
    private boolean failed;

    public boolean isSuccessful() {
        return !this.failed;
    }

    public void testFailure(Failure failure) {
        super.testFailure(failure);
        this.failed = true;
    }
}
