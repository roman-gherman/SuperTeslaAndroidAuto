package l1;

import java.net.SocketTimeoutException;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends SocketTimeoutException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f3960a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String message, Throwable th) {
        super(message);
        h.f(message, "message");
        this.f3960a = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f3960a;
    }
}
