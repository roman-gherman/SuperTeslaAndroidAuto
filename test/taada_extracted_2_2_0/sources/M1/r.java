package m1;

import h1.C0494b;
import io.ktor.utils.io.ByteReadChannel;
import java.io.InputStream;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends U1.g implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4064a;
    public /* synthetic */ E1.f b;
    public /* synthetic */ r1.c c;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        r rVar = new r(3, (Continuation) obj3);
        rVar.b = (E1.f) obj;
        rVar.c = (r1.c) obj2;
        return rVar.invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f4064a;
        N1.m mVar = N1.m.f1129a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.reflect.l.e0(obj);
            return mVar;
        }
        kotlin.reflect.l.e0(obj);
        E1.f fVar = this.b;
        r1.c cVar = this.c;
        F1.a aVar2 = cVar.f4689a;
        Object obj2 = cVar.b;
        if ((obj2 instanceof ByteReadChannel) && kotlin.jvm.internal.h.a(aVar2.f347a, kotlin.jvm.internal.w.f3818a.b(InputStream.class))) {
            ByteReadChannel byteReadChannel = (ByteReadChannel) obj2;
            Job job = (Job) ((C0494b) fVar.f289a).getCoroutineContext().get(Job.Key);
            N1.j jVar = io.ktor.utils.io.jvm.javaio.e.f3600a;
            kotlin.jvm.internal.h.f(byteReadChannel, "<this>");
            r1.c cVar2 = new r1.c(aVar2, new C0648q(new io.ktor.utils.io.jvm.javaio.i(job, byteReadChannel), fVar));
            this.b = null;
            this.f4064a = 1;
            if (fVar.d(cVar2, this) == aVar) {
                return aVar;
            }
        }
        return mVar;
    }
}
