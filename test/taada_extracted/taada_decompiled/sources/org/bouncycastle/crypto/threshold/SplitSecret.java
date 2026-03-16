package org.bouncycastle.crypto.threshold;

/* JADX INFO: loaded from: classes2.dex */
public interface SplitSecret {
    byte[] getSecret();

    SecretShare[] getSecretShares();
}
