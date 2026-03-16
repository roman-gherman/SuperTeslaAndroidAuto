package r3;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: r3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0804e implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f4705a;

    public C0804e(CoroutineContext coroutineContext) {
        this.f4705a = coroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f4705a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f4705a + ')';
    }
}
