package r3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends kotlin.jvm.internal.i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f4723a = new y(2);

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        ThreadContextElement threadContextElement = (ThreadContextElement) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (threadContextElement != null) {
            return threadContextElement;
        }
        if (element instanceof ThreadContextElement) {
            return (ThreadContextElement) element;
        }
        return null;
    }
}
