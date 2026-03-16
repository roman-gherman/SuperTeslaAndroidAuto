package m3;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends C0672f {
    public final B i;

    public f0(Continuation continuation, B b) {
        super(1, continuation);
        this.i = b;
    }

    @Override // m3.C0672f
    public final Throwable l(o0 o0Var) {
        Throwable thB;
        Object objP = this.i.p();
        return (!(objP instanceof h0) || (thB = ((h0) objP).b()) == null) ? objP instanceof C0677k ? ((C0677k) objP).f4133a : o0Var.getCancellationException() : thB;
    }

    @Override // m3.C0672f
    public final String r() {
        return "AwaitContinuation";
    }
}
