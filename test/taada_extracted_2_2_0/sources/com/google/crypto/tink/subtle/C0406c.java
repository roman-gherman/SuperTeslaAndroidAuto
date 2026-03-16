package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.google.crypto.tink.subtle.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0406c extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2950a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f2952g;

    public C0406c(byte[] bArr, String str, int i, String str2, int i3, int i4) throws GeneralSecurityException {
        if (!com.google.protobuf.a.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC streaming in FIPS-mode.");
        }
        int length = bArr.length;
        if (length < 16 || length < i) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i));
        }
        C.a(i);
        if (i3 < 10) {
            throw new InvalidAlgorithmParameterException(B2.b.c(i3, "tag size too small "));
        }
        if ((str2.equals("HmacSha1") && i3 > 20) || ((str2.equals("HmacSha256") && i3 > 32) || (str2.equals("HmacSha512") && i3 > 64))) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        if (((i4 - i3) - i) - 8 <= 0) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
        this.f2952g = Arrays.copyOf(bArr, bArr.length);
        this.f2951f = str;
        this.f2950a = i;
        this.b = str2;
        this.c = i3;
        this.d = i4;
        this.e = i4 - i3;
    }

    public static byte[] h(C0406c c0406c, byte[] bArr, long j6, boolean z6) throws GeneralSecurityException {
        c0406c.getClass();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(bArr);
        if (0 > j6 || j6 >= 4294967296L) {
            throw new GeneralSecurityException("Index out of range");
        }
        byteBufferAllocate.putInt((int) j6);
        byteBufferAllocate.put(z6 ? (byte) 1 : (byte) 0);
        byteBufferAllocate.putInt(0);
        return byteBufferAllocate.array();
    }

    @Override // com.google.crypto.tink.subtle.r
    public final int a() {
        return d();
    }

    @Override // com.google.crypto.tink.subtle.r
    public final int b() {
        return this.c;
    }

    @Override // com.google.crypto.tink.subtle.r
    public final int c() {
        return this.d;
    }

    @Override // com.google.crypto.tink.subtle.r
    public final int d() {
        return this.f2950a + 8;
    }

    @Override // com.google.crypto.tink.subtle.r
    public final int e() {
        return this.e;
    }

    @Override // com.google.crypto.tink.subtle.r
    public final StreamSegmentDecrypter f() {
        return new C0404a(this);
    }

    @Override // com.google.crypto.tink.subtle.r
    public final StreamSegmentEncrypter g(byte[] bArr) {
        return new C0405b(this, bArr);
    }
}
