package r1;

import h1.C0494b;
import io.ktor.http.HttpMessage;
import io.ktor.utils.io.ByteReadChannel;
import kotlinx.coroutines.CoroutineScope;
import u1.s;
import u1.t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements HttpMessage, CoroutineScope {
    public abstract ByteReadChannel a();

    public abstract C1.b b();

    public abstract C1.b c();

    public abstract t d();

    public abstract s e();

    public abstract C0494b getCall();

    public final String toString() {
        return "HttpResponse[" + getCall().c().getUrl() + ", " + d() + ']';
    }
}
