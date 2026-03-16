package org.mockito.plugins;

import org.mockito.creation.instance.Instantiator;
import org.mockito.mock.MockCreationSettings;

/* JADX INFO: loaded from: classes.dex */
public interface InstantiatorProvider2 {
    Instantiator getInstantiator(MockCreationSettings<?> mockCreationSettings);
}
