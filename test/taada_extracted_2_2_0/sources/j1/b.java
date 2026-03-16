package J1;

import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.h;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends I1.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f826h;
    public static final /* synthetic */ AtomicIntegerFieldUpdater i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f827j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f828k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ObjectPool f829g;

    @NotNull
    private volatile /* synthetic */ Object nextRef;

    @NotNull
    private volatile /* synthetic */ int refCount;

    static {
        a aVar = new a();
        f827j = aVar;
        f828k = new b(G1.b.f421a, aVar);
        f826h = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "nextRef");
        i = AtomicIntegerFieldUpdater.newUpdater(b.class, "refCount");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ByteBuffer memory, ObjectPool objectPool) {
        super(memory);
        h.f(memory, "memory");
        this.f829g = objectPool;
        this.nextRef = null;
        this.refCount = 1;
    }

    public final b g() {
        return (b) f826h.getAndSet(this, null);
    }

    public final b h() {
        return (b) this.nextRef;
    }

    public final int i() {
        return this.refCount;
    }

    public final void j(ObjectPool pool) {
        int i3;
        int i4;
        h.f(pool, "pool");
        do {
            i3 = this.refCount;
            if (i3 <= 0) {
                throw new IllegalStateException("Unable to release: it is already released.");
            }
            i4 = i3 - 1;
        } while (!i.compareAndSet(this, i3, i4));
        if (i4 == 0) {
            ObjectPool objectPool = this.f829g;
            if (objectPool != null) {
                pool = objectPool;
            }
            pool.recycle(this);
        }
    }

    public final void k() {
        d(0);
        int i3 = this.f751f;
        this.e = i3;
        f(i3 - this.d);
        this.nextRef = null;
    }

    public final void l(b bVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (bVar == null) {
            g();
            return;
        }
        do {
            atomicReferenceFieldUpdater = f826h;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, bVar)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        throw new IllegalStateException("This chunk has already a next chunk.");
    }

    public final void m() {
        int i3;
        do {
            i3 = this.refCount;
            if (i3 < 0) {
                throw new IllegalStateException("This instance is already disposed and couldn't be borrowed.");
            }
            if (i3 > 0) {
                throw new IllegalStateException("This instance is already in use but somehow appeared in the pool.");
            }
        } while (!i.compareAndSet(this, i3, 1));
    }
}
