package kotlin.reflect.jvm.internal.impl.descriptors;

import n2.u;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface SourceElement {
    public static final SourceElement NO_SOURCE = new u();

    @NotNull
    SourceFile getContainingFile();
}
