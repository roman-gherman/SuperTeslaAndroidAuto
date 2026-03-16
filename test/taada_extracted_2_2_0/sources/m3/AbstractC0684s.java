package m3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r3.AbstractC0800a;

/* JADX INFO: renamed from: m3.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0684s extends S1.a implements ContinuationInterceptor {

    @NotNull
    public static final r Key = new r(ContinuationInterceptor.Key, C0683q.f4143a);

    public AbstractC0684s() {
        super(ContinuationInterceptor.Key);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    @InternalCoroutinesApi
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // S1.a, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        E e;
        kotlin.jvm.internal.h.f(key, "key");
        if (!(key instanceof S1.b)) {
            if (ContinuationInterceptor.Key == key) {
                return this;
            }
            return null;
        }
        S1.b bVar = (S1.b) key;
        CoroutineContext.Key<?> key2 = getKey();
        kotlin.jvm.internal.h.f(key2, "key");
        if ((key2 == bVar || bVar.b == key2) && (e = (E) bVar.f1277a.invoke(this)) != null) {
            return e;
        }
        return null;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    @NotNull
    public final <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> continuation) {
        return new r3.h(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return !(this instanceof x0);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public AbstractC0684s limitedParallelism(int i) {
        AbstractC0800a.a(i);
        return new r3.i(this, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002c A[RETURN] */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // S1.a, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public kotlin.coroutines.CoroutineContext minusKey(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<?> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.h.f(r4, r0)
            boolean r1 = r4 instanceof S1.b
            S1.g r2 = S1.g.f1282a
            if (r1 == 0) goto L27
            S1.b r4 = (S1.b) r4
            kotlin.coroutines.CoroutineContext$Key r1 = r3.getKey()
            kotlin.jvm.internal.h.f(r1, r0)
            if (r1 == r4) goto L1c
            kotlin.coroutines.CoroutineContext$Key r0 = r4.b
            if (r0 != r1) goto L1b
            goto L1c
        L1b:
            return r3
        L1c:
            kotlin.jvm.internal.i r4 = r4.f1277a
            java.lang.Object r4 = r4.invoke(r3)
            kotlin.coroutines.CoroutineContext$Element r4 = (kotlin.coroutines.CoroutineContext.Element) r4
            if (r4 == 0) goto L2c
            goto L2b
        L27:
            S1.f r0 = kotlin.coroutines.ContinuationInterceptor.Key
            if (r0 != r4) goto L2c
        L2b:
            return r2
        L2c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.AbstractC0684s.minusKey(kotlin.coroutines.CoroutineContext$Key):kotlin.coroutines.CoroutineContext");
    }

    @Deprecated(level = N1.a.b, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @NotNull
    public final AbstractC0684s plus(@NotNull AbstractC0684s abstractC0684s) {
        return abstractC0684s;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final void releaseInterceptedContinuation(@NotNull Continuation<?> continuation) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        kotlin.jvm.internal.h.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        r3.h hVar = (r3.h) continuation;
        do {
            atomicReferenceFieldUpdater = r3.h.f4708h;
        } while (atomicReferenceFieldUpdater.get(hVar) == AbstractC0800a.d);
        Object obj = atomicReferenceFieldUpdater.get(hVar);
        C0672f c0672f = obj instanceof C0672f ? (C0672f) obj : null;
        if (c0672f != null) {
            c0672f.j();
        }
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0690y.e(this);
    }
}
