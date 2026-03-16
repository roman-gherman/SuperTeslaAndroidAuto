package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Mac;
import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Mac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Prf f2969a;
    public final int b;

    public u(Prf prf, int i) throws InvalidAlgorithmParameterException {
        this.f2969a = prf;
        this.b = i;
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        prf.compute(new byte[0], i);
    }

    @Override // com.google.crypto.tink.Mac
    public final byte[] computeMac(byte[] bArr) {
        return this.f2969a.compute(bArr, this.b);
    }

    @Override // com.google.crypto.tink.Mac
    public final void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(computeMac(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
