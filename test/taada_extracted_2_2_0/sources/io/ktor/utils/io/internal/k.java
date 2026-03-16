package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends p {
    public final ByteBuffer c;
    public final ByteBuffer d;
    public final j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f3586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f3587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m f3588h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(ByteBuffer backingBuffer, int i) {
        super(backingBuffer, new r(backingBuffer.capacity() - i));
        kotlin.jvm.internal.h.f(backingBuffer, "backingBuffer");
        if (backingBuffer.position() != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (backingBuffer.limit() != backingBuffer.capacity()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        ByteBuffer byteBufferDuplicate = backingBuffer.duplicate();
        kotlin.jvm.internal.h.e(byteBufferDuplicate, "backingBuffer.duplicate()");
        this.c = byteBufferDuplicate;
        ByteBuffer byteBufferDuplicate2 = backingBuffer.duplicate();
        kotlin.jvm.internal.h.e(byteBufferDuplicate2, "backingBuffer.duplicate()");
        this.d = byteBufferDuplicate2;
        this.e = new j(this);
        this.f3586f = new l(this);
        this.f3587g = new o(this);
        this.f3588h = new m(this);
    }

    @Override // io.ktor.utils.io.internal.p
    public final boolean a() {
        throw new IllegalStateException("Not available for initial state");
    }

    @Override // io.ktor.utils.io.internal.p
    public final ByteBuffer b() {
        return this.d;
    }

    @Override // io.ktor.utils.io.internal.p
    public final ByteBuffer c() {
        return this.c;
    }

    @Override // io.ktor.utils.io.internal.p
    public final p d() {
        return this.f3586f;
    }

    @Override // io.ktor.utils.io.internal.p
    public final p e() {
        return this.f3587g;
    }

    public final String toString() {
        return "Initial";
    }
}
