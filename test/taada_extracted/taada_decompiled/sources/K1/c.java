package K1;

import androidx.core.view.InputDeviceCompat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f931g;

    public c() {
        super(2048);
        this.f931g = InputDeviceCompat.SOURCE_TOUCHSCREEN;
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
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f931g);
        h.c(byteBufferAllocate);
        return byteBufferAllocate;
    }

    @Override // K1.e
    public final void g(Object obj) {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (byteBuffer.capacity() != this.f931g) {
            throw new IllegalStateException("Check failed.");
        }
        if (byteBuffer.isDirect()) {
            throw new IllegalStateException("Check failed.");
        }
    }
}
