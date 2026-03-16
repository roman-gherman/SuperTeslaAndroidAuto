package io.ktor.utils.io.internal;

import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements ObjectPool {
    @Override // io.ktor.utils.io.pool.ObjectPool
    public final Object borrow() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(h.f3584a);
        kotlin.jvm.internal.h.e(byteBufferAllocateDirect, "allocateDirect(BUFFER_SIZE)");
        return new k(byteBufferAllocateDirect, 8);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final int getCapacity() {
        return 0;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public void recycle(Object instance) {
        kotlin.jvm.internal.h.f(instance, "instance");
    }
}
