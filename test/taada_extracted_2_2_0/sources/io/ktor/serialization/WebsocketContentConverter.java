package io.ktor.serialization;

import F1.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000b\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\nJ1\u0010\r\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lio/ktor/serialization/WebsocketContentConverter;", "", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "LF1/a;", "typeInfo", "value", "LL1/a;", "serialize", "(Ljava/nio/charset/Charset;LF1/a;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serializeNullable", "content", "deserialize", "(Ljava/nio/charset/Charset;LF1/a;LL1/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TypedValues.AttributesType.S_FRAME, "", "isApplicable", "(LL1/a;)Z", "ktor-serialization"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface WebsocketContentConverter {
    @Nullable
    Object deserialize(@NotNull Charset charset, @NotNull a aVar, @NotNull L1.a aVar2, @NotNull Continuation<Object> continuation);

    boolean isApplicable(@NotNull L1.a frame);

    @Nullable
    Object serialize(@NotNull Charset charset, @NotNull a aVar, @NotNull Object obj, @NotNull Continuation<? super L1.a> continuation);

    @Nullable
    Object serializeNullable(@NotNull Charset charset, @NotNull a aVar, @Nullable Object obj, @NotNull Continuation<? super L1.a> continuation);
}
