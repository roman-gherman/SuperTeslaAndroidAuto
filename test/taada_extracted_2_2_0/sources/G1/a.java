package G1;

import io.ktor.utils.io.bits.Allocator;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Allocator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f420a = new a();

    @Override // io.ktor.utils.io.bits.Allocator
    /* JADX INFO: renamed from: alloc-gFv-Zug, reason: not valid java name */
    public final ByteBuffer mo1allocgFvZug(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        h.e(byteBufferAllocate, "allocate(size)");
        ByteBuffer byteBuffer = b.f421a;
        return byteBufferAllocate;
    }

    @Override // io.ktor.utils.io.bits.Allocator
    /* JADX INFO: renamed from: free-3GNKZMM, reason: not valid java name */
    public final void mo3free3GNKZMM(ByteBuffer instance) {
        h.f(instance, "instance");
    }

    @Override // io.ktor.utils.io.bits.Allocator
    /* JADX INFO: renamed from: alloc-gFv-Zug, reason: not valid java name */
    public final ByteBuffer mo2allocgFvZug(long j6) {
        if (j6 < 2147483647L) {
            return mo1allocgFvZug((int) j6);
        }
        throw new IllegalArgumentException("Long value " + j6 + " of size doesn't fit into 32-bit integer");
    }
}
