package I1;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f757h = new d(J1.b.f828k, 0, J1.b.f827j);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(J1.b head, long j6, ObjectPool pool) {
        super(head, j6, pool);
        h.f(head, "head");
        h.f(pool, "pool");
        if (this.f762g) {
            return;
        }
        this.f762g = true;
    }

    public final String toString() {
        return "ByteReadPacket[" + hashCode() + ']';
    }
}
