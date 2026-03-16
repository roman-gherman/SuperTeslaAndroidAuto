package J1;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ObjectPool {
    @Override // io.ktor.utils.io.pool.ObjectPool
    public final Object borrow() {
        return b.f828k;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final int getCapacity() {
        return 1;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(Object obj) {
        b instance = (b) obj;
        h.f(instance, "instance");
        if (instance != b.f828k) {
            throw new IllegalArgumentException("Only ChunkBuffer.Empty instance could be recycled.");
        }
    }
}
