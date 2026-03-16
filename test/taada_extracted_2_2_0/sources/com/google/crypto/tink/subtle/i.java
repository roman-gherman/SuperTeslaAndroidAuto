package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes.dex */
public final class i extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2959a;
    public final int b;
    public final int c;
    public final String d;
    public final byte[] e;

    public i(int i, int i3, String str, byte[] bArr) throws InvalidAlgorithmParameterException {
        if (bArr.length < 16 || bArr.length < i) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i));
        }
        C.a(i);
        if (i3 <= d() + 16) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
        this.e = Arrays.copyOf(bArr, bArr.length);
        this.d = str;
        this.f2959a = i;
        this.b = i3;
        this.c = i3 - 16;
    }

    public static GCMParameterSpec h(byte[] bArr, long j6, boolean z6) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(bArr);
        if (0 > j6 || j6 >= 4294967296L) {
            throw new GeneralSecurityException("Index out of range");
        }
        byteBufferAllocate.putInt((int) j6);
        byteBufferAllocate.put(z6 ? (byte) 1 : (byte) 0);
        return new GCMParameterSpec(128, byteBufferAllocate.array());
    }

    @Override // com.google.crypto.tink.subtle.r
    public final int a() {
        return d();
    }

    @Override // com.google.crypto.tink.subtle.r
    public final int b() {
        return 16;
    }

    @Override // com.google.crypto.tink.subtle.r
    public final int c() {
        return this.b;
    }

    @Override // com.google.crypto.tink.subtle.r
    public final int d() {
        return this.f2959a + 8;
    }

    @Override // com.google.crypto.tink.subtle.r
    public final int e() {
        return this.c;
    }

    @Override // com.google.crypto.tink.subtle.r
    public final StreamSegmentDecrypter f() {
        return new g(this);
    }

    @Override // com.google.crypto.tink.subtle.r
    public final StreamSegmentEncrypter g(byte[] bArr) {
        return new h(this, bArr);
    }
}
