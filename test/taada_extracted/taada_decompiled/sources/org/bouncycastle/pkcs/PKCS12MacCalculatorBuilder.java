package org.bouncycastle.pkcs;

import H3.a;
import org.bouncycastle.operator.MacCalculator;

/* JADX INFO: loaded from: classes2.dex */
public interface PKCS12MacCalculatorBuilder {
    MacCalculator build(char[] cArr);

    a getDigestAlgorithmIdentifier();
}
