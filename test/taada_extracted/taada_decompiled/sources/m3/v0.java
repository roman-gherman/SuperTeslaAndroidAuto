package m3;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CopyableThrowable;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 extends CancellationException implements CopyableThrowable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient w0 f4146a;

    public v0(String str, w0 w0Var) {
        super(str);
        this.f4146a = w0Var;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final Throwable createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        v0 v0Var = new v0(message, this.f4146a);
        v0Var.initCause(this);
        return v0Var;
    }
}
