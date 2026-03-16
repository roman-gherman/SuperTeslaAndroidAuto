package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface InvalidModuleNotifier {
    void notifyModuleInvalidated(@NotNull ModuleDescriptor moduleDescriptor);
}
