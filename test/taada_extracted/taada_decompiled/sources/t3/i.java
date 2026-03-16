package t3;

import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements TaskContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4834a;

    public i(int i) {
        this.f4834a = i;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final void afterTask() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final int getTaskMode() {
        return this.f4834a;
    }
}
