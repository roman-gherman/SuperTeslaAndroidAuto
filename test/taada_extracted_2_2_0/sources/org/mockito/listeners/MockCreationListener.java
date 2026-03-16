package org.mockito.listeners;

import org.mockito.mock.MockCreationSettings;

/* JADX INFO: loaded from: classes.dex */
public interface MockCreationListener extends MockitoListener {
    void onMockCreated(Object obj, MockCreationSettings mockCreationSettings);

    default void onStaticMockCreated(Class<?> cls, MockCreationSettings mockCreationSettings) {
    }
}
