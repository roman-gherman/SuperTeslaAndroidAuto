package m1;

import androidx.core.location.LocationRequestCompat;
import c4.AbstractC0246d;
import h1.C0494b;
import io.ktor.http.Headers;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.b0;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import org.slf4j.Logger;
import u1.AbstractC0839d;
import u1.C0840e;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends U1.g implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4072a;
    public int b;
    public /* synthetic */ E1.f c;
    public /* synthetic */ Object d;
    public final /* synthetic */ C0631A e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(C0631A c0631a, Continuation continuation, int i) {
        super(3, continuation);
        this.f4072a = i;
        this.e = c0631a;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        E1.f fVar = (E1.f) obj;
        switch (this.f4072a) {
            case 0:
                z zVar = new z(this.e, (Continuation) obj3, 0);
                zVar.c = fVar;
                zVar.d = obj2;
                return zVar.invokeSuspend(N1.m.f1129a);
            default:
                z zVar2 = new z(this.e, (Continuation) obj3, 1);
                zVar2.c = fVar;
                zVar2.d = (r1.c) obj2;
                return zVar2.invokeSuspend(N1.m.f1129a);
        }
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) throws A.a {
        Charset charset;
        E1.f fVar;
        F1.a aVar;
        C0840e c0840eX;
        C0631A c0631a = this.e;
        N1.m mVar = N1.m.f1129a;
        T1.a aVar2 = T1.a.f1304a;
        switch (this.f4072a) {
            case 0:
                int i = this.b;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.reflect.l.e0(obj);
                    return mVar;
                }
                kotlin.reflect.l.e0(obj);
                E1.f fVar2 = this.c;
                Object obj2 = this.d;
                q1.c context = (q1.c) fVar2.f289a;
                c0631a.getClass();
                kotlin.jvm.internal.h.f(context, "context");
                List list = u1.q.f4870a;
                u1.m mVar2 = context.c;
                if (mVar2.get("Accept-Charset") == null) {
                    Logger logger = B.f4028a;
                    StringBuilder sb = new StringBuilder("Adding Accept-Charset=");
                    String str = c0631a.c;
                    sb.append(str);
                    sb.append(" to ");
                    sb.append(context.f4513a);
                    logger.trace(sb.toString());
                    mVar2.set("Accept-Charset", str);
                }
                if (!(obj2 instanceof String)) {
                    return mVar;
                }
                Object obj3 = fVar2.f289a;
                C0840e c0840eE = k1.j.e((HttpMessageBuilder) obj3);
                if (c0840eE != null) {
                    if (!kotlin.jvm.internal.h.a(c0840eE.d, AbstractC0839d.f4861a.d)) {
                        return mVar;
                    }
                }
                q1.c cVar = (q1.c) obj3;
                String str2 = (String) obj2;
                C0840e c0840e = c0840eE == null ? AbstractC0839d.f4861a : c0840eE;
                if (c0840eE == null || (charset = io.ktor.utils.io.internal.t.d(c0840eE)) == null) {
                    charset = c0631a.b;
                }
                B.f4028a.trace("Sending request body to " + cVar.f4513a + " as text/plain with charset " + charset);
                kotlin.jvm.internal.h.f(c0840e, "<this>");
                kotlin.jvm.internal.h.f(charset, "charset");
                v1.j jVar = new v1.j(str2, c0840e.h(H1.a.c(charset)));
                this.c = null;
                this.b = 1;
                return fVar2.d(jVar, this) == aVar2 ? aVar2 : mVar;
            default:
                int i3 = this.b;
                if (i3 == 0) {
                    kotlin.reflect.l.e0(obj);
                    E1.f fVar3 = this.c;
                    r1.c cVar2 = (r1.c) this.d;
                    F1.a aVar3 = cVar2.f4689a;
                    if (!kotlin.jvm.internal.h.a(aVar3.f347a, kotlin.jvm.internal.w.f3818a.b(String.class))) {
                        return mVar;
                    }
                    Object obj4 = cVar2.b;
                    if (!(obj4 instanceof ByteReadChannel)) {
                        return mVar;
                    }
                    this.c = fVar3;
                    this.d = aVar3;
                    this.b = 1;
                    Object remaining = ((ByteReadChannel) obj4).readRemaining(LocationRequestCompat.PASSIVE_INTERVAL, this);
                    if (remaining != aVar2) {
                        fVar = fVar3;
                        obj = remaining;
                        aVar = aVar3;
                    }
                    return aVar2;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.reflect.l.e0(obj);
                    return mVar;
                }
                aVar = (F1.a) this.d;
                fVar = this.c;
                kotlin.reflect.l.e0(obj);
                I1.d body = (I1.d) obj;
                C0494b call = (C0494b) fVar.f289a;
                c0631a.getClass();
                kotlin.jvm.internal.h.f(call, "call");
                kotlin.jvm.internal.h.f(body, "body");
                Headers headers = call.d().getHeaders();
                List list2 = u1.q.f4870a;
                String str3 = headers.get("Content-Type");
                if (str3 != null) {
                    C0840e c0840e2 = C0840e.f4862f;
                    c0840eX = b0.x(str3);
                } else {
                    c0840eX = null;
                }
                Charset charset2 = c0840eX != null ? io.ktor.utils.io.internal.t.d(c0840eX) : null;
                if (charset2 == null) {
                    charset2 = c0631a.f4027a;
                }
                B.f4028a.trace("Reading response body for " + call.c().getUrl() + " as String with charset " + charset2);
                kotlin.jvm.internal.h.f(charset2, "charset");
                CharsetDecoder charsetDecoderNewDecoder = charset2.newDecoder();
                kotlin.jvm.internal.h.e(charsetDecoderNewDecoder, "charset.newDecoder()");
                r1.c cVar3 = new r1.c(aVar, AbstractC0246d.F(charsetDecoderNewDecoder, body));
                this.c = null;
                this.d = null;
                this.b = 2;
                if (fVar.d(cVar3, this) != aVar2) {
                    return mVar;
                }
                return aVar2;
        }
    }
}
