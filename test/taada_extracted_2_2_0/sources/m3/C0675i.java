package m3;

import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;

/* JADX INFO: renamed from: m3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0675i extends c0 implements ChildHandle {
    public final ChildJob e;

    public C0675i(ChildJob childJob) {
        this.e = childJob;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean childCancelled(Throwable th) {
        return f().h(th);
    }

    @Override // m3.e0
    public final void g(Throwable th) {
        this.e.parentCancelled(f());
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        g((Throwable) obj);
        return N1.m.f1129a;
    }
}
