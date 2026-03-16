package org.bouncycastle.tsp.ers;

import F3.a;
import org.bouncycastle.operator.DigestCalculator;

/* JADX INFO: loaded from: classes2.dex */
public interface ERSRootNodeCalculator {
    a[] computePathToRoot(DigestCalculator digestCalculator, a aVar, int i);

    byte[] computeRootHash(DigestCalculator digestCalculator, a[] aVarArr);

    byte[] recoverRootHash(DigestCalculator digestCalculator, a[] aVarArr);
}
