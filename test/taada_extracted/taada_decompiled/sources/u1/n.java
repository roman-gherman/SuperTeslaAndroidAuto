package u1;

import io.ktor.http.Headers;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends z1.n implements Headers {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Map values) {
        super(values);
        kotlin.jvm.internal.h.f(values, "values");
    }

    public final String toString() {
        return "Headers " + entries();
    }
}
