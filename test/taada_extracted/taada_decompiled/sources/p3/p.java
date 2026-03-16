package p3;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import o3.EnumC0743a;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements SharedFlow, CancellableFlow, FusibleFlow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f4489a;

    public p(u uVar) {
        this.f4489a = uVar;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        u.g(this.f4489a, flowCollector, continuation);
        return T1.a.f1304a;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, EnumC0743a enumC0743a) {
        return v.h(this, coroutineContext, i, enumC0743a);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public final List getReplayCache() {
        return this.f4489a.getReplayCache();
    }
}
