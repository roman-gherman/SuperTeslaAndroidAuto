package kotlin.reflect.jvm.internal.impl.incremental.components;

import org.jetbrains.annotations.NotNull;
import v2.C0852c;
import v2.EnumC0853d;

/* JADX INFO: loaded from: classes2.dex */
public interface LookupTracker {
    boolean getRequiresPosition();

    void record(@NotNull String str, @NotNull C0852c c0852c, @NotNull String str2, @NotNull EnumC0853d enumC0853d, @NotNull String str3);
}
