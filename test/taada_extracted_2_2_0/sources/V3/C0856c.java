package v3;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import r3.u;

/* JADX INFO: renamed from: v3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0856c implements SelectInstanceInternal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SelectInstanceInternal f4942a;
    public final Object b;
    public final /* synthetic */ g c;

    public C0856c(g gVar, SelectInstanceInternal selectInstanceInternal, Object obj) {
        this.c = gVar;
        this.f4942a = selectInstanceInternal;
        this.b = obj;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void disposeOnCompletion(DisposableHandle disposableHandle) {
        this.f4942a.disposeOnCompletion(disposableHandle);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final CoroutineContext getContext() {
        return this.f4942a.getContext();
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(u uVar, int i) {
        this.f4942a.invokeOnCancellation(uVar, i);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void selectInRegistrationPhase(Object obj) {
        g.f4946h.set(this.c, this.b);
        this.f4942a.selectInRegistrationPhase(obj);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final boolean trySelect(Object obj, Object obj2) {
        boolean zTrySelect = this.f4942a.trySelect(obj, obj2);
        if (zTrySelect) {
            g.f4946h.set(this.c, this.b);
        }
        return zTrySelect;
    }
}
