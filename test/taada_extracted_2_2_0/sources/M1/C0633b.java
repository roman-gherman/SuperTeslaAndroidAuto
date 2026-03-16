package m1;

import i1.C0527b;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.utils.io.ByteReadChannel;
import java.io.InputStream;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import u1.AbstractC0839d;
import u1.C0840e;

/* JADX INFO: renamed from: m1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0633b extends U1.g implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4049a;
    public int b;
    public /* synthetic */ E1.f c;
    public /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0633b(int i, Continuation continuation, int i3) {
        super(i, continuation);
        this.f4049a = i3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        E1.f fVar = (E1.f) obj;
        Continuation continuation = (Continuation) obj3;
        switch (this.f4049a) {
            case 0:
                C0633b c0633b = new C0633b(3, continuation, 0);
                c0633b.c = fVar;
                c0633b.d = obj2;
                return c0633b.invokeSuspend(N1.m.f1129a);
            default:
                C0633b c0633b2 = new C0633b(3, continuation, 1);
                c0633b2.c = fVar;
                c0633b2.d = obj2;
                return c0633b2.invokeSuspend(N1.m.f1129a);
        }
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        v1.g c0644m;
        N1.m mVar = N1.m.f1129a;
        T1.a aVar = T1.a.f1304a;
        switch (this.f4049a) {
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
                E1.f fVar = this.c;
                Object obj2 = this.d;
                Function3 function3 = (Function3) ((q1.c) fVar.f289a).f4514f.getOrNull(AbstractC0635d.f4051a);
                if (function3 == null) {
                    return mVar;
                }
                kotlin.jvm.internal.h.d(obj2, "null cannot be cast to non-null type io.ktor.http.content.OutgoingContent");
                C0527b c0527b = new C0527b((v1.g) obj2, ((q1.c) fVar.f289a).e, function3);
                this.c = null;
                this.b = 1;
                return fVar.d(c0527b, this) == aVar ? aVar : mVar;
            default:
                int i3 = this.b;
                if (i3 != 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.reflect.l.e0(obj);
                    return mVar;
                }
                kotlin.reflect.l.e0(obj);
                E1.f fVar2 = this.c;
                Object body = this.d;
                u1.m mVar2 = ((q1.c) fVar2.f289a).c;
                List list = u1.q.f4870a;
                String str = mVar2.get("Accept");
                Object obj3 = fVar2.f289a;
                if (str == null) {
                    ((q1.c) obj3).c.append("Accept", "*/*");
                }
                C0840e c0840eE = k1.j.e((HttpMessageBuilder) obj3);
                if (body instanceof String) {
                    String str2 = (String) body;
                    if (c0840eE == null) {
                        c0840eE = AbstractC0839d.f4861a;
                    }
                    c0644m = new v1.j(str2, c0840eE);
                } else if (body instanceof byte[]) {
                    c0644m = new C0643l(c0840eE, body);
                } else if (body instanceof ByteReadChannel) {
                    c0644m = new C0644m(fVar2, c0840eE, body);
                } else if (body instanceof v1.g) {
                    c0644m = (v1.g) body;
                } else {
                    q1.c context = (q1.c) obj3;
                    kotlin.jvm.internal.h.f(context, "context");
                    kotlin.jvm.internal.h.f(body, "body");
                    c0644m = body instanceof InputStream ? new C0644m(context, c0840eE, body) : null;
                }
                if ((c0644m != null ? c0644m.b() : null) == null) {
                    return mVar;
                }
                q1.c cVar = (q1.c) obj3;
                cVar.c.remove("Content-Type");
                AbstractC0647p.f4062a.trace("Transformed with default transformers request body for " + cVar.f4513a + " from " + kotlin.jvm.internal.w.f3818a.b(body.getClass()));
                this.c = null;
                this.b = 1;
                return fVar2.d(c0644m, this) == aVar ? aVar : mVar;
        }
    }
}
