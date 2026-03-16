package kotlin.reflect.jvm.internal.impl.storage;

import Z2.a;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface LockBasedStorageManager$ExceptionHandlingStrategy {
    public static final LockBasedStorageManager$ExceptionHandlingStrategy THROW = new a();

    @NotNull
    RuntimeException handleException(@NotNull Throwable th);
}
