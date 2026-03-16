package org.mockito.junit;

import org.junit.rules.TestRule;
import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
public interface MockitoTestRule extends TestRule {
    MockitoTestRule silent();

    MockitoTestRule strictness(Strictness strictness);
}
