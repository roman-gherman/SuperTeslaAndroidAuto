package U1;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends a {

    @Nullable
    private final CoroutineContext _context;

    @Nullable
    private transient Continuation<Object> intercepted;

    public c(Continuation continuation, CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        h.c(coroutineContext);
        return coroutineContext;
    }

    @NotNull
    public final Continuation<Object> intercepted() {
        Continuation<Object> continuationInterceptContinuation = this.intercepted;
        if (continuationInterceptContinuation == null) {
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) getContext().get(ContinuationInterceptor.Key);
            if (continuationInterceptor == null || (continuationInterceptContinuation = continuationInterceptor.interceptContinuation(this)) == null) {
                continuationInterceptContinuation = this;
            }
            this.intercepted = continuationInterceptContinuation;
        }
        return continuationInterceptContinuation;
    }

    @Override // U1.a
    public void releaseIntercepted() {
        Continuation<?> continuation = this.intercepted;
        if (continuation != null && continuation != this) {
            CoroutineContext.Element element = getContext().get(ContinuationInterceptor.Key);
            h.c(element);
            ((ContinuationInterceptor) element).releaseInterceptedContinuation(continuation);
        }
        this.intercepted = b.f1314a;
    }

    public c(Continuation continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }
}
