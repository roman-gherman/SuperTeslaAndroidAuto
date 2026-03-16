package io.ktor.http.content;

import io.ktor.http.Headers;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import u1.m;
import v1.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/content/Version;", "", "Lio/ktor/http/Headers;", "requestHeaders", "Lv1/k;", "check", "(Lio/ktor/http/Headers;)Lv1/k;", "Lu1/m;", "builder", "LN1/m;", "appendHeadersTo", "(Lu1/m;)V", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Version {
    void appendHeadersTo(@NotNull m builder);

    @NotNull
    k check(@NotNull Headers requestHeaders);
}
