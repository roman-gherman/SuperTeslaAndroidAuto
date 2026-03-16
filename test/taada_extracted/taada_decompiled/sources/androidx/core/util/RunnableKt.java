package androidx.core.util;

import N1.m;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "LN1/m;", "Ljava/lang/Runnable;", "asRunnable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Runnable;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RunnableKt {
    public static final Runnable asRunnable(Continuation<? super m> continuation) {
        return new ContinuationRunnable(continuation);
    }
}
