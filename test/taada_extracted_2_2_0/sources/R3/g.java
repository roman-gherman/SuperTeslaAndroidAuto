package r3;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient CoroutineContext f4707a;

    public g(CoroutineContext coroutineContext) {
        this.f4707a = coroutineContext;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f4707a.toString();
    }
}
