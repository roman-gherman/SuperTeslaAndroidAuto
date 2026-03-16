package kotlin.reflect.jvm.internal.impl.storage;

import Z2.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface SimpleLock {

    @NotNull
    public static final o Companion = o.f1503a;

    void lock();

    void unlock();
}
