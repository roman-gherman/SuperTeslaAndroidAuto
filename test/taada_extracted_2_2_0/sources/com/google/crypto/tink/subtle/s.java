package com.google.crypto.tink.subtle;

import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Prf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f2967a;
    public final byte[] b;
    public final byte[] c;

    public s(byte[] bArr) throws GeneralSecurityException {
        C.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f2967a = secretKeySpec;
        if (!com.google.protobuf.a.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        Cipher cipher = (Cipher) p.b.f2966a.getInstance("AES/ECB/NoPadding");
        cipher.init(1, secretKeySpec);
        byte[] bArrP = kotlin.reflect.l.p(cipher.doFinal(new byte[16]));
        this.b = bArrP;
        this.c = kotlin.reflect.l.p(bArrP);
    }

    @Override // com.google.crypto.tink.prf.Prf
    public final byte[] compute(byte[] bArr, int i) {
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        if (!com.google.protobuf.a.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        Cipher cipher = (Cipher) p.b.f2966a.getInstance("AES/ECB/NoPadding");
        cipher.init(1, this.f2967a);
        int iMax = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
        byte[] bArrF = iMax * 16 == bArr.length ? q.f(bArr, (iMax - 1) * 16, 0, this.b, 16) : q.g(kotlin.reflect.l.i(Arrays.copyOfRange(bArr, (iMax - 1) * 16, bArr.length)), this.c);
        byte[] bArrDoFinal = new byte[16];
        for (int i3 = 0; i3 < iMax - 1; i3++) {
            bArrDoFinal = cipher.doFinal(q.f(bArrDoFinal, 0, i3 * 16, bArr, 16));
        }
        return Arrays.copyOf(cipher.doFinal(q.g(bArrF, bArrDoFinal)), i);
    }
}
