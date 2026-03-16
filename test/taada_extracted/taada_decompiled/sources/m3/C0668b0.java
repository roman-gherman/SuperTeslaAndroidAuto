package m3;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CopyableThrowable;

/* JADX INFO: renamed from: m3.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0668b0 extends CancellationException implements CopyableThrowable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient o0 f4120a;

    public C0668b0(String str, Throwable th, o0 o0Var) {
        super(str);
        this.f4120a = o0Var;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final /* bridge */ /* synthetic */ Throwable createCopy() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0668b0)) {
            return false;
        }
        C0668b0 c0668b0 = (C0668b0) obj;
        return kotlin.jvm.internal.h.a(c0668b0.getMessage(), getMessage()) && kotlin.jvm.internal.h.a(c0668b0.f4120a, this.f4120a) && kotlin.jvm.internal.h.a(c0668b0.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.h.c(message);
        int iHashCode = (this.f4120a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f4120a;
    }
}
