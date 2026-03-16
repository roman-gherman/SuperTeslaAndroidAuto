package E1;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f289a;

    public f(Object context) {
        kotlin.jvm.internal.h.f(context, "context");
        this.f289a = context;
    }

    public abstract Object a(Object obj, U1.c cVar);

    public abstract Object b();

    public abstract Object c(Continuation continuation);

    public abstract Object d(Object obj, Continuation continuation);
}
