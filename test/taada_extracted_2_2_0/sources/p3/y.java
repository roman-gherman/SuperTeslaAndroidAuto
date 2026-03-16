package p3;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f4505a;
    public FlowCollector b;
    public C0758A c;
    public Job d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ z f4507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4508h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(z zVar, Continuation continuation) {
        super(continuation);
        this.f4507g = zVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f4506f = obj;
        this.f4508h |= Integer.MIN_VALUE;
        this.f4507g.collect(null, this);
        return T1.a.f1304a;
    }
}
