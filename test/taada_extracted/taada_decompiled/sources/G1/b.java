package G1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f421a;

    static {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        h.e(byteBufferOrder, "allocate(0).order(ByteOrder.BIG_ENDIAN)");
        f421a = byteBufferOrder;
    }

    public static final void a(ByteBuffer byteBuffer, ByteBuffer destination, int i, int i3, int i4) {
        h.f(destination, "destination");
        if (byteBuffer.hasArray() && destination.hasArray() && !byteBuffer.isReadOnly() && !destination.isReadOnly()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i, destination.array(), destination.arrayOffset() + i4, i3);
            return;
        }
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.limit(i + i3);
        ByteBuffer byteBufferDuplicate2 = destination.duplicate();
        byteBufferDuplicate2.position(i4);
        byteBufferDuplicate2.put(byteBufferDuplicate);
    }
}
