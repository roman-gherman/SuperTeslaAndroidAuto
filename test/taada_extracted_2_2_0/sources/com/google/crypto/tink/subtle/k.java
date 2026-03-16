package com.google.crypto.tink.subtle;

import com.google.crypto.tink.DeterministicAead;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class k implements DeterministicAead {
    public static final List c = Arrays.asList(64);
    public static final byte[] d = new byte[16];
    public static final byte[] e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f2961a;
    public final byte[] b;

    public k(byte[] bArr) throws GeneralSecurityException {
        if (!com.google.protobuf.a.a(1)) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (!c.contains(Integer.valueOf(bArr.length))) {
            throw new InvalidKeyException(B2.b.g(new StringBuilder("invalid key size: "), " bytes; key must have 64 bytes", bArr.length));
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
        this.b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
        this.f2961a = new s(bArrCopyOfRange);
    }

    public final byte[] a(byte[]... bArr) {
        byte[] bArrG;
        int length = bArr.length;
        s sVar = this.f2961a;
        if (length == 0) {
            return sVar.compute(e, 16);
        }
        byte[] bArrCompute = sVar.compute(d, 16);
        for (int i = 0; i < bArr.length - 1; i++) {
            byte[] bArr2 = bArr[i];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            bArrCompute = q.g(kotlin.reflect.l.p(bArrCompute), sVar.compute(bArr2, 16));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        if (bArr3.length < 16) {
            bArrG = q.g(kotlin.reflect.l.i(bArr3), kotlin.reflect.l.p(bArrCompute));
        } else {
            if (bArr3.length < bArrCompute.length) {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            int length2 = bArr3.length - bArrCompute.length;
            bArrG = Arrays.copyOf(bArr3, bArr3.length);
            for (int i3 = 0; i3 < bArrCompute.length; i3++) {
                int i4 = length2 + i3;
                bArrG[i4] = (byte) (bArrG[i4] ^ bArrCompute[i3]);
            }
        }
        return sVar.compute(bArrG, 16);
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public final byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        Cipher cipher = (Cipher) p.b.f2966a.getInstance("AES/CTR/NoPadding");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArr3 = (byte[]) bArrCopyOfRange.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipher.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(bArr3));
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
        byte[] bArrDoFinal = cipher.doFinal(bArrCopyOfRange2);
        if (bArrCopyOfRange2.length == 0 && bArrDoFinal == null && "The Android Project".equals(System.getProperty("java.vendor"))) {
            bArrDoFinal = new byte[0];
        }
        if (MessageDigest.isEqual(bArrCopyOfRange, a(bArr2, bArrDoFinal))) {
            return bArrDoFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public final byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipher = (Cipher) p.b.f2966a.getInstance("AES/CTR/NoPadding");
        byte[] bArrA = a(bArr2, bArr);
        byte[] bArr3 = (byte[]) bArrA.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipher.init(1, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(bArr3));
        return q.b(bArrA, cipher.doFinal(bArr));
    }
}
