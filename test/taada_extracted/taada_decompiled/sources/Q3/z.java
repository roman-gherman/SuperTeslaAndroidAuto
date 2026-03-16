package q3;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4674a;
    public /* synthetic */ Object b;
    public final /* synthetic */ FlowCollector c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.c = flowCollector;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        z zVar = new z(this.c, continuation);
        zVar.b = obj;
        return zVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((z) create(obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f4674a;
        if (i == 0) {
            kotlin.reflect.l.e0(obj);
            Object obj2 = this.b;
            this.f4674a = 1;
            if (this.c.emit(obj2, this) == aVar) {
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
