package m1;

import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.internal.play_billing.U0;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
public final class N extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4045a;
    public final /* synthetic */ Long b;
    public final /* synthetic */ q1.c c;
    public final /* synthetic */ CompletableJob d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(Long l6, q1.c cVar, CompletableJob completableJob, Continuation continuation) {
        super(2, continuation);
        this.b = l6;
        this.c = cVar;
        this.d = completableJob;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        return new N(this.b, this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((N) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f4045a;
        if (i == 0) {
            kotlin.reflect.l.e0(obj);
            long jLongValue = this.b.longValue();
            this.f4045a = 1;
            if (m3.D.b(jLongValue, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.reflect.l.e0(obj);
        }
        q1.c request = this.c;
        kotlin.jvm.internal.h.f(request, "request");
        u1.y yVar = request.f4513a;
        yVar.a();
        StringBuilder sb = new StringBuilder(256);
        io.ktor.utils.io.internal.t.a(yVar, sb);
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "appendTo(StringBuilder(256)).toString()");
        O o6 = P.d;
        Map map = (Map) request.f4514f.getOrNull(j1.f.f3652a);
        M m6 = (M) (map != null ? map.get(o6) : null);
        Object obj2 = m6 != null ? m6.f4044a : null;
        StringBuilder sbM = B2.b.m("Request timeout has expired [url=", string, ", request_timeout=");
        if (obj2 == null) {
            obj2 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        sbM.append(obj2);
        sbM.append(" ms]");
        U0 u02 = new U0(sbM.toString());
        Q.f4047a.trace("Request timeout: " + yVar);
        String message = u02.getMessage();
        kotlin.jvm.internal.h.c(message);
        CancellationException cancellationException = new CancellationException(message);
        cancellationException.initCause(u02);
        this.d.cancel(cancellationException);
        return N1.m.f1129a;
    }
}
