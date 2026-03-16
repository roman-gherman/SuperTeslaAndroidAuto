package org.bouncycastle.crypto.threshold;

/* JADX INFO: loaded from: classes2.dex */
public interface SecretSplitter {
    SplitSecret resplit(byte[] bArr, int i, int i3);

    SplitSecret split(int i, int i3);

    SplitSecret splitAround(SecretShare secretShare, int i, int i3);
}
