package androidx.work;

import C5.f;
import T1.a;
import U1.d;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import m3.C0672f;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"await", "R", "Lcom/google/common/util/concurrent/ListenableFuture;", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListenableFutureKt {
    public static final <R> Object await(ListenableFuture<R> listenableFuture, Continuation<? super R> continuation) throws Throwable {
        if (!listenableFuture.isDone()) {
            C0672f c0672f = new C0672f(1, f.J(continuation));
            c0672f.initCancellability();
            listenableFuture.addListener(new ListenableFutureKt$await$2$1(c0672f, listenableFuture), DirectExecutor.INSTANCE);
            c0672f.invokeOnCancellation(new ListenableFutureKt$await$2$2(listenableFuture));
            return c0672f.m();
        }
        try {
            return listenableFuture.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            }
            throw cause;
        }
    }

    private static final <R> Object await$$forInline(ListenableFuture<R> listenableFuture, Continuation<? super R> continuation) throws Throwable {
        if (listenableFuture.isDone()) {
            try {
                return listenableFuture.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        C0672f c0672f = new C0672f(1, f.J(continuation));
        c0672f.initCancellability();
        listenableFuture.addListener(new ListenableFutureKt$await$2$1(c0672f, listenableFuture), DirectExecutor.INSTANCE);
        c0672f.invokeOnCancellation(new ListenableFutureKt$await$2$2(listenableFuture));
        Object objM = c0672f.m();
        if (objM == a.f1304a) {
            d.a(continuation);
        }
        return objM;
    }
}
