package m3;

import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: loaded from: classes2.dex */
public final class L extends N {
    public final CancellableContinuation c;
    public final /* synthetic */ P d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(P p5, long j6, CancellableContinuation cancellableContinuation) {
        super(j6);
        this.d = p5;
        this.c = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.resumeUndispatched(this.d, N1.m.f1129a);
    }

    @Override // m3.N
    public final String toString() {
        return super.toString() + this.c;
    }
}
