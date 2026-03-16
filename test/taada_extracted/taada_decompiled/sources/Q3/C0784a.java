package q3;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: q3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0784a extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient p3.n f4650a;

    public C0784a(p3.n nVar) {
        super("Flow was aborted, no more elements needed");
        this.f4650a = nVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
