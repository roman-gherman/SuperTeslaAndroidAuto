package p3;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f4493a;
    public FlowCollector b;
    public w c;
    public Job d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ u f4494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4495g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, Continuation continuation) {
        super(continuation);
        this.f4494f = uVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f4495g |= Integer.MIN_VALUE;
        u.g(this.f4494f, null, this);
        return T1.a.f1304a;
    }
}
