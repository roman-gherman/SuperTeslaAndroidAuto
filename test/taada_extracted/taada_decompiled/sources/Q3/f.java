package q3;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4654a;
    public /* synthetic */ Object b;
    public final /* synthetic */ g c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, Continuation continuation) {
        super(2, continuation);
        this.c = gVar;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        f fVar = new f(this.c, continuation);
        fVar.b = obj;
        return fVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((f) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f4654a;
        if (i == 0) {
            kotlin.reflect.l.e0(obj);
            ProducerScope producerScope = (ProducerScope) this.b;
            this.f4654a = 1;
            if (this.c.a(producerScope, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.reflect.l.e0(obj);
        }
        return N1.m.f1129a;
    }
}
