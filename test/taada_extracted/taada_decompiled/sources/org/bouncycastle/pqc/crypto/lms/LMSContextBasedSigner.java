package org.bouncycastle.pqc.crypto.lms;

import w4.i;

/* JADX INFO: loaded from: classes2.dex */
public interface LMSContextBasedSigner {
    i generateLMSContext();

    byte[] generateSignature(i iVar);

    long getUsagesRemaining();
}
