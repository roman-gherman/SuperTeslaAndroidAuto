package A;

import com.google.android.gms.common.Feature;
import io.ktor.http.Headers;
import java.util.List;
import kotlin.reflect.KClass;
import kotlin.text.k;
import u1.q;

/* JADX INFO: loaded from: classes.dex */
public final class g extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1a = 0;
    public final Object b;

    public g(Feature feature) {
        this.b = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        switch (this.f1a) {
            case 0:
                return "Missing ".concat(String.valueOf((Feature) this.b));
            default:
                return (String) this.b;
        }
    }

    public g(r1.b bVar, KClass from, KClass to) {
        kotlin.jvm.internal.h.f(from, "from");
        kotlin.jvm.internal.h.f(to, "to");
        StringBuilder sb = new StringBuilder("\n        Expected response body of the type '");
        sb.append(to);
        sb.append("' but was '");
        sb.append(from);
        sb.append("'\n        In response from `");
        sb.append(bVar.getCall().c().getUrl());
        sb.append("`\n        Response status `");
        sb.append(bVar.d());
        sb.append("`\n        Response header `ContentType: ");
        Headers headers = bVar.getHeaders();
        List list = q.f4869a;
        sb.append(headers.get("Content-Type"));
        sb.append("` \n        Request header `Accept: ");
        sb.append(bVar.getCall().c().getHeaders().get("Accept"));
        sb.append("`\n        \n        You can read how to resolve NoTransformationFoundException at FAQ: \n        https://ktor.io/docs/faq.html#no-transformation-found-exception\n    ");
        this.b = k.t(sb.toString());
    }
}
