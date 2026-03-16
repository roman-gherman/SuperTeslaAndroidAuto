package kotlin.coroutines;

import S1.d;
import S1.g;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static Object a(CoroutineContext.Element element, Object obj, Function2 operation) {
        h.f(operation, "operation");
        return operation.mo5invoke(obj, element);
    }

    public static CoroutineContext.Element b(CoroutineContext.Element element, CoroutineContext.Key key) {
        h.f(key, "key");
        if (h.a(element.getKey(), key)) {
            return element;
        }
        return null;
    }

    public static CoroutineContext c(CoroutineContext.Element element, CoroutineContext.Key key) {
        h.f(key, "key");
        return h.a(element.getKey(), key) ? g.f1282a : element;
    }

    public static CoroutineContext d(CoroutineContext.Element element, CoroutineContext context) {
        h.f(context, "context");
        return context == g.f1282a ? element : (CoroutineContext) context.fold(element, d.c);
    }
}
