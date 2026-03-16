package m3;

import kotlinx.coroutines.Incomplete;

/* JADX INFO: loaded from: classes2.dex */
public final class J implements Incomplete {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4108a;

    public J(boolean z6) {
        this.f4108a = z6;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final q0 getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return this.f4108a;
    }

    public final String toString() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("Empty{"), this.f4108a ? "Active" : "New", '}');
    }
}
