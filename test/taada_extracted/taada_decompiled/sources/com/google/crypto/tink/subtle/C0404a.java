package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: com.google.crypto.tink.subtle.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0404a implements StreamSegmentDecrypter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecretKeySpec f2944a;
    public SecretKeySpec b;
    public Cipher c;
    public Mac d;
    public byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0406c f2945f;

    public C0404a(C0406c c0406c) {
        this.f2945f = c0406c;
    }

    @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
    public final synchronized void decryptSegment(ByteBuffer byteBuffer, int i, boolean z6, ByteBuffer byteBuffer2) {
        int iPosition = byteBuffer.position();
        byte[] bArrH = C0406c.h(this.f2945f, this.e, i, z6);
        int iRemaining = byteBuffer.remaining();
        int i3 = this.f2945f.c;
        if (iRemaining < i3) {
            throw new GeneralSecurityException("Ciphertext too short");
        }
        int i4 = (iRemaining - i3) + iPosition;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.limit(i4);
        ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
        byteBufferDuplicate2.position(i4);
        this.d.init(this.b);
        this.d.update(bArrH);
        this.d.update(byteBufferDuplicate);
        byte[] bArrCopyOf = Arrays.copyOf(this.d.doFinal(), this.f2945f.c);
        byte[] bArr = new byte[this.f2945f.c];
        byteBufferDuplicate2.get(bArr);
        if (!MessageDigest.isEqual(bArr, bArrCopyOf)) {
            throw new GeneralSecurityException("Tag mismatch");
        }
        byteBuffer.limit(i4);
        this.c.init(1, this.f2944a, new IvParameterSpec(bArrH));
        this.c.doFinal(byteBuffer, byteBuffer2);
    }

    @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
    public final synchronized void init(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() != this.f2945f.d()) {
            throw new InvalidAlgorithmParameterException("Invalid header length");
        }
        if (byteBuffer.get() != this.f2945f.d()) {
            throw new GeneralSecurityException("Invalid ciphertext");
        }
        this.e = new byte[7];
        byte[] bArr2 = new byte[this.f2945f.f2950a];
        byteBuffer.get(bArr2);
        byteBuffer.get(this.e);
        C0406c c0406c = this.f2945f;
        int i = c0406c.f2950a + 32;
        byte[] bArrA = q.a(c0406c.f2952g, bArr2, c0406c.f2951f, bArr, i);
        C0406c c0406c2 = this.f2945f;
        c0406c2.getClass();
        this.f2944a = new SecretKeySpec(bArrA, 0, c0406c2.f2950a, "AES");
        C0406c c0406c3 = this.f2945f;
        c0406c3.getClass();
        this.b = new SecretKeySpec(bArrA, c0406c3.f2950a, 32, c0406c3.b);
        this.c = (Cipher) p.b.f2966a.getInstance("AES/CTR/NoPadding");
        C0406c c0406c4 = this.f2945f;
        c0406c4.getClass();
        this.d = (Mac) p.c.f2966a.getInstance(c0406c4.b);
    }
}
