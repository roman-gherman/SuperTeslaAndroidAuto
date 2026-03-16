package p3;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import o3.EnumC0743a;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements StateFlow, CancellableFlow, FusibleFlow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableStateFlow f4491a;

    public q(MutableStateFlow mutableStateFlow) {
        this.f4491a = mutableStateFlow;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        return this.f4491a.collect(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, EnumC0743a enumC0743a) {
        return (((i < 0 || i >= 2) && i != -2) || enumC0743a != EnumC0743a.b) ? v.h(this, coroutineContext, i, enumC0743a) : this;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public final List getReplayCache() {
        return this.f4491a.getReplayCache();
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        return this.f4491a.getValue();
    }
}
