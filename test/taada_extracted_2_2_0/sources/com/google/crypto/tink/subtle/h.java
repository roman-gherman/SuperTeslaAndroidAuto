package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class h implements StreamSegmentEncrypter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f2958a;
    public final Cipher b = (Cipher) p.b.f2966a.getInstance("AES/GCM/NoPadding");
    public final byte[] c;
    public final ByteBuffer d;
    public long e;

    public h(i iVar, byte[] bArr) {
        this.e = 0L;
        this.e = 0L;
        byte[] bArrA = v.a(iVar.f2959a);
        byte[] bArrA2 = v.a(7);
        this.c = bArrA2;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iVar.d());
        this.d = byteBufferAllocate;
        byteBufferAllocate.put((byte) iVar.d());
        byteBufferAllocate.put(bArrA);
        byteBufferAllocate.put(bArrA2);
        byteBufferAllocate.flip();
        int i = iVar.f2959a;
        this.f2958a = new SecretKeySpec(q.a(iVar.e, bArrA, iVar.d, bArr, i), "AES");
    }

    @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
    public final synchronized void encryptSegment(ByteBuffer byteBuffer, boolean z6, ByteBuffer byteBuffer2) {
        this.b.init(1, this.f2958a, i.h(this.c, this.e, z6));
        this.e++;
        this.b.doFinal(byteBuffer, byteBuffer2);
    }

    @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
    public final ByteBuffer getHeader() {
        return this.d.asReadOnlyBuffer();
    }

    @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
    public final synchronized void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z6, ByteBuffer byteBuffer3) {
        try {
            this.b.init(1, this.f2958a, i.h(this.c, this.e, z6));
            this.e++;
            if (byteBuffer2.hasRemaining()) {
                this.b.update(byteBuffer, byteBuffer3);
                this.b.doFinal(byteBuffer2, byteBuffer3);
            } else {
                this.b.doFinal(byteBuffer, byteBuffer3);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
