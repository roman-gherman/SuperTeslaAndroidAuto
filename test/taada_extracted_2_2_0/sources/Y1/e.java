package y1;

import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Writer f5133a;
    public /* synthetic */ Object b;
    public final /* synthetic */ g c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, U1.c cVar) {
        super(cVar);
        this.c = gVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return g.a(this.c, null, null, this);
    }
}
