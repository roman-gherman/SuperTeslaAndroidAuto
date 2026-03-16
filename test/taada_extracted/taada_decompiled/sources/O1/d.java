package o1;

import java.util.Iterator;
import java.util.List;
import u1.C0840e;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q1.c f4269a;
    public Object b;
    public C0840e c;
    public List d;
    public Iterator e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0735a f4270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f4271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g f4272h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(g gVar, U1.c cVar) {
        super(cVar);
        this.f4272h = gVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f4271g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f4272h.a(null, null, this);
    }
}
