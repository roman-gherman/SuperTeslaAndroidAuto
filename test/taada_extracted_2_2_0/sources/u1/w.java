package u1;

import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import java.util.Map;
import o2.AbstractC0737a;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends AbstractC0737a implements ParametersBuilder {
    public w(int i) {
        super(i);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final Parameters build() {
        Map values = (Map) this.f4280a;
        kotlin.jvm.internal.h.f(values, "values");
        return new x(values);
    }
}
