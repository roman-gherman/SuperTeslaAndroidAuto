package v3;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import r3.u;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends u {
    public final AtomicReferenceArray e;

    public m(long j6, m mVar, int i) {
        super(j6, mVar, i);
        this.e = new AtomicReferenceArray(l.f4953f);
    }

    @Override // r3.u
    public final int f() {
        return l.f4953f;
    }

    @Override // r3.u
    public final void g(int i, CoroutineContext coroutineContext) {
        this.e.set(i, l.e);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.c + ", hashCode=" + hashCode() + ']';
    }
}
