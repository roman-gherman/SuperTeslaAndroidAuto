package org.bouncycastle.crypto.prng;

/* JADX INFO: loaded from: classes2.dex */
public interface RandomGenerator {
    void addSeedMaterial(long j6);

    void addSeedMaterial(byte[] bArr);

    void nextBytes(byte[] bArr);

    void nextBytes(byte[] bArr, int i, int i3);
}
