package io.ktor.serialization;

import F1.a;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u1.C0840e;
import v1.g;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J9\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0001H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ;\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\fJ1\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lio/ktor/serialization/ContentConverter;", "", "Lu1/e;", CMSAttributeTableGenerator.CONTENT_TYPE, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "LF1/a;", "typeInfo", "value", "Lv1/g;", "serialize", "(Lu1/e;Ljava/nio/charset/Charset;LF1/a;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serializeNullable", "Lio/ktor/utils/io/ByteReadChannel;", "content", "deserialize", "(Ljava/nio/charset/Charset;LF1/a;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-serialization"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ContentConverter {
    @Nullable
    Object deserialize(@NotNull Charset charset, @NotNull a aVar, @NotNull ByteReadChannel byteReadChannel, @NotNull Continuation<Object> continuation);

    @Deprecated(level = N1.a.f1118a, message = "Please override and use serializeNullable instead", replaceWith = @ReplaceWith(expression = "serializeNullable(charset, typeInfo, contentType, value)", imports = {}))
    @Nullable
    Object serialize(@NotNull C0840e c0840e, @NotNull Charset charset, @NotNull a aVar, @NotNull Object obj, @NotNull Continuation<? super g> continuation);

    @Nullable
    Object serializeNullable(@NotNull C0840e c0840e, @NotNull Charset charset, @NotNull a aVar, @Nullable Object obj, @NotNull Continuation<? super g> continuation);
}
