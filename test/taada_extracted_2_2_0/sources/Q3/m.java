package q3;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends U1.g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4660a;
    public final /* synthetic */ Flow[] b;
    public final /* synthetic */ int c;
    public final /* synthetic */ AtomicInteger d;
    public final /* synthetic */ o3.n e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Flow[] flowArr, int i, AtomicInteger atomicInteger, o3.n nVar, Continuation continuation) {
        super(2, continuation);
        this.b = flowArr;
        this.c = i;
        this.d = atomicInteger;
        this.e = nVar;
    }

    @Override // U1.a
    public final Continuation create(Object obj, Continuation continuation) {
        return new m(this.b, this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return ((m) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(N1.m.f1129a);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.f4660a;
        AtomicInteger atomicInteger = this.d;
        o3.n nVar = this.e;
        try {
            if (i == 0) {
                kotlin.reflect.l.e0(obj);
                Flow[] flowArr = this.b;
                int i3 = this.c;
                Flow flow = flowArr[i3];
                l lVar = new l(nVar, i3);
                this.f4660a = 1;
                if (flow.collect(lVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.reflect.l.e0(obj);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                nVar.close(null);
            }
            return N1.m.f1129a;
        } finally {
            if (atomicInteger.decrementAndGet() == 0) {
                nVar.close(null);
            }
        }
    }
}
