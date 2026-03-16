package io.ktor.utils.io.jvm.javaio;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f3606a;
    public /* synthetic */ Object b;
    public final /* synthetic */ h c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, U1.c cVar) {
        super(cVar);
        this.c = hVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.b(this);
    }
}
