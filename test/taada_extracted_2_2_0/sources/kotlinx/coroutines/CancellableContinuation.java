package kotlinx.coroutines;

import N1.m;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import m3.AbstractC0684s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b\u0006\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\tH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004H'¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH'¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0019\u0010\u001aJ8\u0010\u001d\u001a\u00020\r2'\u0010\u001c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\u00020\r*\u00020\u001f2\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b \u0010!J\u001b\u0010\"\u001a\u00020\r*\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\tH'¢\u0006\u0004\b\"\u0010#J<\u0010$\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'¨\u0006*"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "value", "", "idempotent", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "LN1/m;", "onCancellation", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "completeResume", "(Ljava/lang/Object;)V", "initCancellability", "()V", "", "cancel", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "Lm3/s;", "resumeUndispatched", "(Lm3/s;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lm3/s;Ljava/lang/Throwable;)V", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "isActive", "()Z", "isCompleted", "isCancelled", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CancellableContinuation<T> extends Continuation<T> {
    boolean cancel(@Nullable Throwable cause);

    @InternalCoroutinesApi
    void completeResume(@NotNull Object token);

    @InternalCoroutinesApi
    void initCancellability();

    void invokeOnCancellation(@NotNull Function1<? super Throwable, m> handler);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @ExperimentalCoroutinesApi
    void resume(T value, @Nullable Function1<? super Throwable, m> onCancellation);

    @ExperimentalCoroutinesApi
    void resumeUndispatched(@NotNull AbstractC0684s abstractC0684s, T t6);

    @ExperimentalCoroutinesApi
    void resumeUndispatchedWithException(@NotNull AbstractC0684s abstractC0684s, @NotNull Throwable th);

    @InternalCoroutinesApi
    @Nullable
    Object tryResume(T value, @Nullable Object idempotent);

    @InternalCoroutinesApi
    @Nullable
    Object tryResume(T value, @Nullable Object idempotent, @Nullable Function1<? super Throwable, m> onCancellation);

    @InternalCoroutinesApi
    @Nullable
    Object tryResumeWithException(@NotNull Throwable exception);
}
