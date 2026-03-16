package p3;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import q3.AbstractC0786c;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Flow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Flow f4478a;
    public final k b;
    public final j c;

    public f(Flow flow, k kVar, j jVar) {
        this.f4478a = flow;
        this.b = kVar;
        this.c = jVar;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
        vVar.f3816a = AbstractC0786c.b;
        Object objCollect = this.f4478a.collect(new e(this, vVar, flowCollector), continuation);
        return objCollect == T1.a.f1304a ? objCollect : N1.m.f1129a;
    }
}
