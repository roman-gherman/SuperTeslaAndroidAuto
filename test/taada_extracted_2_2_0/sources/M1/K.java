package m1;

import io.ktor.client.plugins.Sender;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
public final class K implements Sender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3 f4042a;
    public final Sender b;

    public K(Function3 interceptor, Sender sender) {
        kotlin.jvm.internal.h.f(interceptor, "interceptor");
        this.f4042a = interceptor;
        this.b = sender;
    }

    @Override // io.ktor.client.plugins.Sender
    public final Object execute(q1.c cVar, Continuation continuation) {
        return this.f4042a.invoke(this.b, cVar, continuation);
    }
}
