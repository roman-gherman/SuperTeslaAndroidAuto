package m3;

import kotlinx.coroutines.Incomplete;

/* JADX INFO: loaded from: classes2.dex */
public final class W implements Incomplete {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f4116a;

    public W(q0 q0Var) {
        this.f4116a = q0Var;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final q0 getList() {
        return this.f4116a;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return false;
    }
}
