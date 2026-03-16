package s1;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.g0;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.h;
import m3.V;
import z.e;

/* JADX INFO: renamed from: s1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0809b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f4765a = new e(10);
    public static final e b = new e(10);
    public static final e c = new e(10);
    public static final e d = new e(10);
    public static final e e = new e(10);

    public static final ByteChannel a(ByteReadChannel byteReadChannel, CoroutineContext context, Long l6, Function3 function3) {
        h.f(byteReadChannel, "<this>");
        h.f(context, "context");
        return g0.b(V.f4115a, context, true, new C0808a(l6, byteReadChannel, function3, null)).b;
    }

    public static final Throwable b(Throwable th) {
        Throwable cause = th;
        while (true) {
            if (!(cause instanceof CancellationException)) {
                if (cause == null) {
                    break;
                }
                return cause;
            }
            CancellationException cancellationException = (CancellationException) cause;
            if (h.a(cause, cancellationException.getCause())) {
                break;
            }
            cause = cancellationException.getCause();
        }
        return th;
    }
}
