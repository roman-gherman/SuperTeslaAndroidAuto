package q3;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProducerScope f4673a;

    public w(ProducerScope producerScope) {
        this.f4673a = producerScope;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Object objSend = this.f4673a.send(obj, continuation);
        return objSend == T1.a.f1304a ? objSend : N1.m.f1129a;
    }
}
