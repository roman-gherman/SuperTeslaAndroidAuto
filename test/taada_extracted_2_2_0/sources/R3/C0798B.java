package r3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: renamed from: r3.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0798B implements ThreadContextElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f4697a;
    public final ThreadLocal b;
    public final C0799C c;

    public C0798B(Integer num, ThreadLocal threadLocal) {
        this.f4697a = num;
        this.b = threadLocal;
        this.c = new C0799C(threadLocal);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return kotlin.coroutines.a.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        if (this.c.equals(key)) {
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return this.c;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return this.c.equals(key) ? S1.g.f1282a : this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return kotlin.coroutines.a.d(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final void restoreThreadContext(CoroutineContext coroutineContext, Object obj) {
        this.b.set(obj);
    }

    public final String toString() {
        return "ThreadLocal(value=" + this.f4697a + ", threadLocal = " + this.b + ')';
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final Object updateThreadContext(CoroutineContext coroutineContext) {
        ThreadLocal threadLocal = this.b;
        Object obj = threadLocal.get();
        threadLocal.set(this.f4697a);
        return obj;
    }
}
