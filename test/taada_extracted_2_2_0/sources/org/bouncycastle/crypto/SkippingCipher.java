package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes2.dex */
public interface SkippingCipher {
    long getPosition();

    long seekTo(long j6);

    long skip(long j6);
}
