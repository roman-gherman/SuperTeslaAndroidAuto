package org.bouncycastle.pqc.crypto.lms;

import w4.i;

/* JADX INFO: loaded from: classes2.dex */
public interface LMSContextBasedVerifier {
    i generateLMSContext(byte[] bArr);

    boolean verify(i iVar);
}
