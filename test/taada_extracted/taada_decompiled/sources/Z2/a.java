package Z2;

import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$ExceptionHandlingStrategy;
import kotlin.reflect.jvm.internal.impl.storage.SimpleLock;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements SimpleLock, LockBasedStorageManager$ExceptionHandlingStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1496a = new a();

    @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$ExceptionHandlingStrategy
    public RuntimeException handleException(Throwable e) throws Throwable {
        if (e == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'throwable' of kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1.handleException must not be null");
        }
        kotlin.jvm.internal.h.f(e, "e");
        throw e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void unlock() {
    }
}
