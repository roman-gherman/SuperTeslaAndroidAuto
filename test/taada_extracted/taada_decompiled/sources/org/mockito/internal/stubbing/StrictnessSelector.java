package org.mockito.internal.stubbing;

import org.mockito.mock.MockCreationSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Stubbing;

/* JADX INFO: loaded from: classes.dex */
public final class StrictnessSelector {
    private StrictnessSelector() {
    }

    public static Strictness determineStrictness(Stubbing stubbing, MockCreationSettings mockCreationSettings, Strictness strictness) {
        return (stubbing == null || stubbing.getStrictness() == null) ? mockCreationSettings.getStrictness() != null ? mockCreationSettings.getStrictness() : strictness : stubbing.getStrictness();
    }
}
