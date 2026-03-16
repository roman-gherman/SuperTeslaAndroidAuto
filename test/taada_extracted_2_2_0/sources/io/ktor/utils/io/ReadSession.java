package io.ktor.utils.io;

import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lio/ktor/utils/io/ReadSession;", "", "", "n", "discard", "(I)I", "atLeast", "LJ1/b;", "request", "(I)LJ1/b;", "getAvailableForRead", "()I", "availableForRead", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ReadSession {
    int discard(int n6);

    int getAvailableForRead();

    @Nullable
    J1.b request(int atLeast);
}
