package l1;

import java.net.ConnectException;
import kotlin.jvm.internal.h;

/* JADX INFO: renamed from: l1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0616a extends ConnectException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f3958a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0616a(String message, Throwable th) {
        super(message);
        h.f(message, "message");
        this.f3958a = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f3958a;
    }
}
