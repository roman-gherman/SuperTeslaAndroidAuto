package org.mockito.junit;

import org.junit.rules.TestRule;

/* JADX INFO: loaded from: classes.dex */
public interface VerificationCollector extends TestRule {
    VerificationCollector assertLazily();

    void collectAndReport();
}
