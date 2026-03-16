package org.mockito.internal.junit;

import org.mockito.mock.MockCreationSettings;
import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
public class StrictStubsRunnerTestListener implements MockitoTestListener {
    private final DefaultStubbingLookupListener stubbingLookupListener = new DefaultStubbingLookupListener(Strictness.STRICT_STUBS);

    @Override // org.mockito.listeners.MockCreationListener
    public void onMockCreated(Object obj, MockCreationSettings mockCreationSettings) {
        mockCreationSettings.getStubbingLookupListeners().add(this.stubbingLookupListener);
    }

    @Override // org.mockito.internal.junit.MockitoTestListener
    public void testFinished(TestFinishedEvent testFinishedEvent) {
    }
}
