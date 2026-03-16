package m1;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r1.b f4066a;
    public Iterator b;
    public /* synthetic */ Object c;
    public final /* synthetic */ v d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar, U1.c cVar) {
        super(cVar);
        this.d = vVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return v.b(this.d, null, this);
    }
}
