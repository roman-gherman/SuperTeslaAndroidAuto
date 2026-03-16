package r1;

import kotlinx.coroutines.CompletableJob;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CompletableJob f4691a;
    public /* synthetic */ Object b;
    public final /* synthetic */ j c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(j jVar, U1.c cVar) {
        super(cVar);
        this.c = jVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, this);
    }
}
