package org.mockito.listeners;

import java.util.Collection;
import org.mockito.invocation.Invocation;
import org.mockito.mock.MockCreationSettings;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
public interface StubbingLookupEvent {
    Collection<Stubbing> getAllStubbings();

    Invocation getInvocation();

    MockCreationSettings getMockSettings();

    Stubbing getStubbingFound();
}
