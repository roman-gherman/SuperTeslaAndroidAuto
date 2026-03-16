package m3;

import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 implements DisposableHandle, ChildHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f4143a = new r0();

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean childCancelled(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final Job getParent() {
        return null;
    }

    public final String toString() {
        return "NonDisposableHandle";
    }
}
