package org.mockito.internal.junit;

import org.mockito.listeners.MockCreationListener;

/* JADX INFO: loaded from: classes.dex */
public interface MockitoTestListener extends MockCreationListener {
    void testFinished(TestFinishedEvent testFinishedEvent);
}
