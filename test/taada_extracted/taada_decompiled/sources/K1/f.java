package K1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f935g;

    public f(int i, int i3) {
        super(i);
        this.f935g = i3;
    }

    @Override // K1.e
    public final Object c(Object obj) {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        byteBuffer.clear();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        return byteBuffer;
    }

    @Override // K1.e
    public final Object e() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.f935g);
        h.c(byteBufferAllocateDirect);
        return byteBufferAllocateDirect;
    }

    @Override // K1.e
    public final void g(Object obj) {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (byteBuffer.capacity() != this.f935g) {
            throw new IllegalStateException("Check failed.");
        }
        if (!byteBuffer.isDirect()) {
            throw new IllegalStateException("Check failed.");
        }
    }
}
