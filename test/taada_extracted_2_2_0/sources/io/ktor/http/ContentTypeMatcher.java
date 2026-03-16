package io.ktor.http;

import kotlin.Metadata;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.jetbrains.annotations.NotNull;
import u1.C0840e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/ContentTypeMatcher;", "", "Lu1/e;", CMSAttributeTableGenerator.CONTENT_TYPE, "", "contains", "(Lu1/e;)Z", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ContentTypeMatcher {
    boolean contains(@NotNull C0840e contentType);
}
