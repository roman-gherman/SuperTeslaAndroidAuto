package q3;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import m3.AbstractC0682p;
import o3.C0741B;

/* JADX INFO: renamed from: q3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0788e extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4653a;
    public /* synthetic */ Object b;
    public final /* synthetic */ FlowCollector c;
    public final /* synthetic */ g d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0788e(FlowCollector flowCollector, g gVar, Continuation continuation) {
        super(2, continuation);
        this.c = flowCollector;
        this.d = gVar;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        C0788e c0788e = new C0788e(this.c, this.d, continuation);
        c0788e.b = obj;
        return c0788e;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((C0788e) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f4653a;
        N1.m mVar = N1.m.f1129a;
        if (i == 0) {
            kotlin.reflect.l.e0(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.b;
            g gVar = this.d;
            int i3 = gVar.b;
            if (i3 == -3) {
                i3 = -2;
            }
            Function2 fVar = new f(gVar, null);
            C0741B c0741b = new C0741B(AbstractC0682p.b(coroutineScope, gVar.f4655a), io.ktor.utils.io.jvm.javaio.q.a(i3, gVar.c, 4));
            c0741b.H(3, c0741b, fVar);
            this.f4653a = 1;
            Object objE = p3.v.e(this.c, c0741b, true, this);
            if (objE != aVar) {
                objE = mVar;
            }
            if (objE == aVar) {
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
