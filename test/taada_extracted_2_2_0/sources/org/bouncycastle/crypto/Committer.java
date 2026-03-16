package org.bouncycastle.crypto;

import L3.b;

/* JADX INFO: loaded from: classes2.dex */
public interface Committer {
    b commit(byte[] bArr);

    boolean isRevealed(b bVar, byte[] bArr);
}
