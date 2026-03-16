package q3;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4656a;
    public /* synthetic */ Object b;
    public final /* synthetic */ i c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, Continuation continuation) {
        super(2, continuation);
        this.c = iVar;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        h hVar = new h(this.c, continuation);
        hVar.b = obj;
        return hVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((h) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f4656a;
        N1.m mVar = N1.m.f1129a;
        if (i == 0) {
            kotlin.reflect.l.e0(obj);
            FlowCollector flowCollector = (FlowCollector) this.b;
            this.f4656a = 1;
            Object objCollect = ((j) this.c).d.collect(flowCollector, this);
            if (objCollect != aVar) {
                objCollect = mVar;
            }
            if (objCollect == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.reflect.l.e0(obj);
        }
        return mVar;
    }
}
