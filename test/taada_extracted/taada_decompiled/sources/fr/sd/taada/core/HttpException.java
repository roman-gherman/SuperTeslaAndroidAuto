package fr.sd.taada.core;

import kotlin.Metadata;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lfr/sd/taada/core/HttpException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "statusCode", "", "message", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(ILjava/lang/String;)V", "getStatusCode", "()I", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpException extends Exception {
    private final int statusCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(int i, @NotNull String message) {
        super("HTTP " + i + ": " + message);
        h.f(message, "message");
        this.statusCode = i;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}
