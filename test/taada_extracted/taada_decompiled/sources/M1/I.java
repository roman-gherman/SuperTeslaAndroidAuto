package m1;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class I extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public J f4039a;
    public /* synthetic */ Object b;
    public final /* synthetic */ J c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(J j6, Continuation continuation) {
        super(continuation);
        this.c = j6;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.execute(null, this);
    }
}
