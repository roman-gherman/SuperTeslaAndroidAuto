package y1;

import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: y1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0930b extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f5129a;
    public final /* synthetic */ g b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0930b(g gVar, Continuation continuation) {
        super(continuation);
        this.b = gVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f5129a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.deserialize(null, null, null, this);
    }
}
