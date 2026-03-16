package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class g implements StreamSegmentDecrypter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecretKeySpec f2957a;
    public Cipher b;
    public byte[] c;
    public final /* synthetic */ i d;

    public g(i iVar) {
        this.d = iVar;
    }

    @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
    public final synchronized void decryptSegment(ByteBuffer byteBuffer, int i, boolean z6, ByteBuffer byteBuffer2) {
        this.b.init(2, this.f2957a, i.h(this.c, i, z6));
        this.b.doFinal(byteBuffer, byteBuffer2);
    }

    @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
    public final synchronized void init(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() != this.d.d()) {
            throw new InvalidAlgorithmParameterException("Invalid header length");
        }
        if (byteBuffer.get() != this.d.d()) {
            throw new GeneralSecurityException("Invalid ciphertext");
        }
        this.c = new byte[7];
        byte[] bArr2 = new byte[this.d.f2959a];
        byteBuffer.get(bArr2);
        byteBuffer.get(this.c);
        i iVar = this.d;
        this.f2957a = new SecretKeySpec(q.a(iVar.e, bArr2, iVar.d, bArr, iVar.f2959a), "AES");
        this.b = (Cipher) p.b.f2966a.getInstance("AES/GCM/NoPadding");
    }
}
