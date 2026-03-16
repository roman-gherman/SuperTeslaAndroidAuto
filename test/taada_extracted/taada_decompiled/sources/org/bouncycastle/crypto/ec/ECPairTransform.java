package org.bouncycastle.crypto.ec;

import O3.c;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes2.dex */
public interface ECPairTransform {
    void init(CipherParameters cipherParameters);

    c transform(c cVar);
}
