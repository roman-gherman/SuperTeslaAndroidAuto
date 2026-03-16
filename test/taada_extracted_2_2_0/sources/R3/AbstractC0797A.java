package r3;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: renamed from: r3.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0797A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E1.h f4696a = new E1.h("NO_THREAD_ELEMENTS", 9);
    public static final x b = x.f4723a;
    public static final y c = y.f4724a;
    public static final z d = z.f4725a;

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == f4696a) {
            return;
        }
        if (!(obj instanceof E)) {
            Object objFold = coroutineContext.fold(null, c);
            kotlin.jvm.internal.h.d(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((ThreadContextElement) objFold).restoreThreadContext(coroutineContext, obj);
            return;
        }
        E e = (E) obj;
        ThreadContextElement[] threadContextElementArr = e.c;
        int length = threadContextElementArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            ThreadContextElement threadContextElement = threadContextElementArr[length];
            kotlin.jvm.internal.h.c(threadContextElement);
            threadContextElement.restoreThreadContext(coroutineContext, e.b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, b);
        kotlin.jvm.internal.h.c(objFold);
        return objFold;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        return obj == 0 ? f4696a : obj instanceof Integer ? coroutineContext.fold(new E(((Number) obj).intValue(), coroutineContext), d) : ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
    }
}
