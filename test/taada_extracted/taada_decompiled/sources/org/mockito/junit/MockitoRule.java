package org.mockito.junit;

import org.junit.rules.MethodRule;
import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
public interface MockitoRule extends MethodRule {
    MockitoRule silent();

    MockitoRule strictness(Strictness strictness);
}
