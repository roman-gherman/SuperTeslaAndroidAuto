package r3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends kotlin.jvm.internal.i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f4725a = new z(2);

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        E e = (E) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (element instanceof ThreadContextElement) {
            ThreadContextElement threadContextElement = (ThreadContextElement) element;
            Object objUpdateThreadContext = threadContextElement.updateThreadContext(e.f4700a);
            int i = e.d;
            e.b[i] = objUpdateThreadContext;
            e.d = i + 1;
            e.c[i] = threadContextElement;
        }
        return e;
    }
}
