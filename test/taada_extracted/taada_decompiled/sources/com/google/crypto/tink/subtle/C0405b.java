package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: com.google.crypto.tink.subtle.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0405b implements StreamSegmentEncrypter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f2946a;
    public final SecretKeySpec b;
    public final Cipher c = (Cipher) p.b.f2966a.getInstance("AES/CTR/NoPadding");
    public final Mac d;
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ByteBuffer f2947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f2948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0406c f2949h;

    public C0405b(C0406c c0406c, byte[] bArr) throws GeneralSecurityException {
        this.f2949h = c0406c;
        this.f2948g = 0L;
        c0406c.getClass();
        EngineFactory$Policy engineFactory$Policy = p.c.f2966a;
        String str = c0406c.b;
        this.d = (Mac) engineFactory$Policy.getInstance(str);
        this.f2948g = 0L;
        int i = c0406c.f2950a;
        byte[] bArrA = v.a(i);
        byte[] bArrA2 = v.a(7);
        this.e = bArrA2;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(c0406c.d());
        this.f2947f = byteBufferAllocate;
        byteBufferAllocate.put((byte) c0406c.d());
        byteBufferAllocate.put(bArrA);
        byteBufferAllocate.put(bArrA2);
        byteBufferAllocate.flip();
        String str2 = c0406c.f2951f;
        byte[] bArrA3 = q.a(c0406c.f2952g, bArrA, str2, bArr, i + 32);
        this.f2946a = new SecretKeySpec(bArrA3, 0, i, "AES");
        this.b = new SecretKeySpec(bArrA3, i, 32, str);
    }

    @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
    public final synchronized void encryptSegment(ByteBuffer byteBuffer, boolean z6, ByteBuffer byteBuffer2) {
        int iPosition = byteBuffer2.position();
        byte[] bArrH = C0406c.h(this.f2949h, this.e, this.f2948g, z6);
        this.c.init(1, this.f2946a, new IvParameterSpec(bArrH));
        this.f2948g++;
        this.c.doFinal(byteBuffer, byteBuffer2);
        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
        byteBufferDuplicate.flip();
        byteBufferDuplicate.position(iPosition);
        this.d.init(this.b);
        this.d.update(bArrH);
        this.d.update(byteBufferDuplicate);
        byteBuffer2.put(this.d.doFinal(), 0, this.f2949h.c);
    }

    @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
    public final ByteBuffer getHeader() {
        return this.f2947f.asReadOnlyBuffer();
    }

    @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
    public final synchronized void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z6, ByteBuffer byteBuffer3) {
        int iPosition = byteBuffer3.position();
        byte[] bArrH = C0406c.h(this.f2949h, this.e, this.f2948g, z6);
        this.c.init(1, this.f2946a, new IvParameterSpec(bArrH));
        this.f2948g++;
        this.c.update(byteBuffer, byteBuffer3);
        this.c.doFinal(byteBuffer2, byteBuffer3);
        ByteBuffer byteBufferDuplicate = byteBuffer3.duplicate();
        byteBufferDuplicate.flip();
        byteBufferDuplicate.position(iPosition);
        this.d.init(this.b);
        this.d.update(bArrH);
        this.d.update(byteBufferDuplicate);
        byteBuffer3.put(this.d.doFinal(), 0, this.f2949h.c);
    }
}
