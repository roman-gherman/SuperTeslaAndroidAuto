package kotlin.reflect.jvm.internal.impl.descriptors;

import n2.v;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface SourceFile {
    public static final SourceFile NO_SOURCE_FILE = new v(5);

    @Nullable
    String getName();
}
