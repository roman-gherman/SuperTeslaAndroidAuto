package o1;

import u1.C0835D;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0835D f4275a;
    public /* synthetic */ Object b;
    public final /* synthetic */ g c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, U1.c cVar) {
        super(cVar);
        this.c = gVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.b(null, null, null, null, null, this);
    }
}
