package o1;

import io.ktor.http.ContentTypeMatcher;
import java.util.List;
import kotlin.collections.u;
import kotlin.text.r;
import u1.AbstractC0838c;
import u1.C0840e;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements ContentTypeMatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f4279a = new j();

    @Override // io.ktor.http.ContentTypeMatcher
    public final boolean contains(C0840e contentType) {
        kotlin.jvm.internal.h.f(contentType, "contentType");
        if (contentType.g(AbstractC0838c.f4860a)) {
            return true;
        }
        if (!((List) contentType.c).isEmpty()) {
            contentType = new C0840e(contentType.d, contentType.e, u.f3805a);
        }
        String string = contentType.toString();
        return r.C(string, "application/") && r.w(string, "+json");
    }
}
