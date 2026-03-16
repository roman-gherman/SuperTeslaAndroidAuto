package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import I2.a;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface DeserializationConfiguration {
    boolean getAllowUnstableDependencies();

    @Nullable
    a getBinaryVersion();

    boolean getPreserveDeclarationsOrdering();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();
}
