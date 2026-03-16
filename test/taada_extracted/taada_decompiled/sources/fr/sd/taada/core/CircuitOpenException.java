package fr.sd.taada.core;

import kotlin.Metadata;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lfr/sd/taada/core/CircuitOpenException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;)V", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CircuitOpenException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircuitOpenException(@NotNull String message) {
        super(message);
        h.f(message, "message");
    }
}
