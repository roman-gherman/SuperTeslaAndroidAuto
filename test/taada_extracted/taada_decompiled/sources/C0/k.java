package C0;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static final k b = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f146a = new AtomicReference(new q(new B.h(3)));

    public final synchronized void a(o oVar) {
        B.h hVar = new B.h((q) this.f146a.get());
        hVar.k(oVar);
        this.f146a.set(new q(hVar));
    }
}
