package io.ktor.client.plugins.cookies;

import N1.m;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u1.AbstractC0841f;
import u1.C0835D;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lio/ktor/client/plugins/cookies/CookiesStorage;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lu1/D;", "requestUrl", "", "Lu1/f;", "get", "(Lu1/D;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cookie", "LN1/m;", "addCookie", "(Lu1/D;Lu1/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CookiesStorage extends Closeable {
    @Nullable
    Object addCookie(@NotNull C0835D c0835d, @NotNull AbstractC0841f abstractC0841f, @NotNull Continuation<? super m> continuation);

    @Nullable
    Object get(@NotNull C0835D c0835d, @NotNull Continuation<? super List<AbstractC0841f>> continuation);
}
