package org.bouncycastle.crypto.engines;

/* JADX INFO: loaded from: classes2.dex */
interface ElephantEngine$Permutation {
    void lfsr_step();

    void permutation(byte[] bArr);
}
