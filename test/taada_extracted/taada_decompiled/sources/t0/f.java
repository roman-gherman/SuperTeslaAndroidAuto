package t0;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d {
    public final /* synthetic */ com.google.android.gms.tasks.c b;
    public final /* synthetic */ com.google.android.play.core.review.d c;
    public final /* synthetic */ h d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, com.google.android.gms.tasks.c cVar, com.google.android.gms.tasks.c cVar2, com.google.android.play.core.review.d dVar) {
        super(cVar);
        this.b = cVar2;
        this.c = dVar;
        this.d = hVar;
    }

    @Override // t0.d
    public final void a() {
        synchronized (this.d.f4785f) {
            try {
                h hVar = this.d;
                com.google.android.gms.tasks.c cVar = this.b;
                hVar.e.add(cVar);
                cVar.f2174a.a(new B.h(26, hVar, cVar));
                if (this.d.f4789k.getAndIncrement() > 0) {
                    this.d.b.a("Already connected to the service.", new Object[0]);
                }
                h.b(this.d, this.c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
