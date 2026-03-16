package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import w0.C0863b;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Aead {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2960a;
    public final Object b;

    public j(byte[] bArr, int i) throws GeneralSecurityException {
        this.f2960a = i;
        switch (i) {
            case 1:
                this.b = new w0.d(bArr, 0);
                return;
            case 2:
                this.b = new w0.d(bArr, 1);
                return;
            default:
                if (!com.google.protobuf.a.b(2)) {
                    throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
                }
                this.b = new C0863b(bArr);
                return;
        }
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        switch (this.f2960a) {
            case 0:
                byte[] bArrCopyOf = Arrays.copyOf(bArr, 12);
                C0863b c0863b = (C0863b) this.b;
                c0863b.getClass();
                if (bArrCopyOf.length != 12) {
                    throw new GeneralSecurityException("iv is wrong size");
                }
                boolean z6 = c0863b.b;
                if (bArr.length < (z6 ? 28 : 16)) {
                    throw new GeneralSecurityException("ciphertext too short");
                }
                if (z6 && !ByteBuffer.wrap(bArrCopyOf).equals(ByteBuffer.wrap(bArr, 0, 12))) {
                    throw new GeneralSecurityException("iv does not match prepended iv");
                }
                AlgorithmParameterSpec algorithmParameterSpecA = C0863b.a(bArrCopyOf);
                c2.b bVar = C0863b.c;
                ((Cipher) bVar.get()).init(2, c0863b.f4958a, algorithmParameterSpecA);
                if (bArr2 != null && bArr2.length != 0) {
                    ((Cipher) bVar.get()).updateAAD(bArr2);
                }
                int i = z6 ? 12 : 0;
                int length = bArr.length;
                if (z6) {
                    length -= 12;
                }
                return ((Cipher) bVar.get()).doFinal(bArr, i, length);
            case 1:
                if (bArr.length < 28) {
                    throw new GeneralSecurityException("ciphertext too short");
                }
                return ((w0.d) this.b).b(ByteBuffer.wrap(bArr, 12, bArr.length - 12), Arrays.copyOf(bArr, 12), bArr2);
            default:
                if (bArr.length < 40) {
                    throw new GeneralSecurityException("ciphertext too short");
                }
                return ((w0.d) this.b).b(ByteBuffer.wrap(bArr, 24, bArr.length - 24), Arrays.copyOf(bArr, 24), bArr2);
        }
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        switch (this.f2960a) {
            case 0:
                byte[] bArrA = v.a(12);
                C0863b c0863b = (C0863b) this.b;
                c0863b.getClass();
                if (bArrA.length != 12) {
                    throw new GeneralSecurityException("iv is wrong size");
                }
                if (bArr.length > 2147483619) {
                    throw new GeneralSecurityException("plaintext too long");
                }
                boolean z6 = c0863b.b;
                byte[] bArr3 = new byte[z6 ? bArr.length + 28 : bArr.length + 16];
                if (z6) {
                    System.arraycopy(bArrA, 0, bArr3, 0, 12);
                }
                AlgorithmParameterSpec algorithmParameterSpecA = C0863b.a(bArrA);
                c2.b bVar = C0863b.c;
                ((Cipher) bVar.get()).init(1, c0863b.f4958a, algorithmParameterSpecA);
                if (bArr2 != null && bArr2.length != 0) {
                    ((Cipher) bVar.get()).updateAAD(bArr2);
                }
                int iDoFinal = ((Cipher) bVar.get()).doFinal(bArr, 0, bArr.length, bArr3, z6 ? 12 : 0);
                if (iDoFinal == bArr.length + 16) {
                    return bArr3;
                }
                throw new GeneralSecurityException(B2.b.d(iDoFinal - bArr.length, "encryption failed; GCM tag must be 16 bytes, but got only ", " bytes"));
            case 1:
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 28);
                byte[] bArrA2 = v.a(12);
                byteBufferAllocate.put(bArrA2);
                ((w0.d) this.b).c(byteBufferAllocate, bArrA2, bArr, bArr2);
                return byteBufferAllocate.array();
            default:
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(bArr.length + 40);
                byte[] bArrA3 = v.a(24);
                byteBufferAllocate2.put(bArrA3);
                ((w0.d) this.b).c(byteBufferAllocate2, bArrA3, bArr, bArr2);
                return byteBufferAllocate2.array();
        }
    }
}
