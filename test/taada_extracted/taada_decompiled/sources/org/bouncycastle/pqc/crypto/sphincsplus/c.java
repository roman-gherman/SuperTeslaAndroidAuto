package org.bouncycastle.pqc.crypto.sphincsplus;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public c(int i, int i3, int i4) {
        if (i > 8 && i > 136 && i > 256) {
            throw new IllegalArgumentException("cannot precompute SPX_WOTS_LEN2 for n outside {2, .., 256}");
        }
        int i5 = i4 / i3;
    }
}
