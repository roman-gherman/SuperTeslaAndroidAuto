package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Aead {
    public static final d e = new d(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f2955f = new d(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f2956a;
    public final byte[] b;
    public final SecretKeySpec c;
    public final int d;

    public f(byte[] bArr, int i) throws GeneralSecurityException {
        if (!com.google.protobuf.a.a(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.d = i;
        C.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.c = secretKeySpec;
        Cipher cipher = (Cipher) e.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrA = a(cipher.doFinal(new byte[16]));
        this.f2956a = bArrA;
        this.b = a(bArrA);
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i3 = i + 1;
            bArr2[i] = (byte) (((bArr[i] << 1) ^ ((bArr[i3] & 255) >>> 7)) & 255);
            i = i3;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public final byte[] b(Cipher cipher, int i, byte[] bArr, int i3, int i4) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArrCopyOf;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        byte[] bArr3 = this.f2956a;
        if (i4 == 0) {
            return cipher.doFinal(c(bArr2, bArr3));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i5 = 0;
        while (i4 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                bArrDoFinal[i6] = (byte) (bArrDoFinal[i6] ^ bArr[(i3 + i5) + i6]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i5 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5 + i3, i3 + i4);
        if (bArrCopyOfRange.length == 16) {
            bArrCopyOf = c(bArrCopyOfRange, bArr3);
        } else {
            bArrCopyOf = Arrays.copyOf(this.b, 16);
            for (int i7 = 0; i7 < bArrCopyOfRange.length; i7++) {
                bArrCopyOf[i7] = (byte) (bArrCopyOf[i7] ^ bArrCopyOfRange[i7]);
            }
            bArrCopyOf[bArrCopyOfRange.length] = (byte) (bArrCopyOf[bArrCopyOfRange.length] ^ 128);
        }
        return cipher.doFinal(c(bArrDoFinal, bArrCopyOf));
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.d;
        int i3 = (length - i) - 16;
        if (i3 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = (Cipher) e.get();
        SecretKeySpec secretKeySpec = this.c;
        cipher.init(1, secretKeySpec);
        byte[] bArrB = b(cipher, 0, bArr, 0, this.d);
        byte[] bArr3 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrB2 = b(cipher, 1, bArr3, 0, bArr3.length);
        byte[] bArrB3 = b(cipher, 2, bArr, this.d, i3);
        int length2 = bArr.length - 16;
        byte b = 0;
        for (int i4 = 0; i4 < 16; i4++) {
            b = (byte) (b | (((bArr[length2 + i4] ^ bArrB2[i4]) ^ bArrB[i4]) ^ bArrB3[i4]));
        }
        if (b != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = (Cipher) f2955f.get();
        cipher2.init(1, secretKeySpec, new IvParameterSpec(bArrB));
        return cipher2.doFinal(bArr, i, i3);
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.d;
        if (length > 2147483631 - i) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + i + 16];
        byte[] bArrA = v.a(i);
        System.arraycopy(bArrA, 0, bArr3, 0, i);
        Cipher cipher = (Cipher) e.get();
        SecretKeySpec secretKeySpec = this.c;
        cipher.init(1, secretKeySpec);
        byte[] bArrB = b(cipher, 0, bArrA, 0, bArrA.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrB2 = b(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = (Cipher) f2955f.get();
        cipher2.init(1, secretKeySpec, new IvParameterSpec(bArrB));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.d);
        byte[] bArrB3 = b(cipher, 2, bArr3, this.d, bArr.length);
        int length2 = bArr.length + i;
        for (int i3 = 0; i3 < 16; i3++) {
            bArr3[length2 + i3] = (byte) ((bArrB2[i3] ^ bArrB[i3]) ^ bArrB3[i3]);
        }
        return bArr3;
    }
}
