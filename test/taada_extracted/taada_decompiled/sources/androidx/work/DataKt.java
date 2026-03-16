package androidx.work;

import N1.e;
import androidx.work.Data;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a@\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a(\u0010\u000b\u001a\u00020\n\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u0003*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "LN1/e;", "", "", "pairs", "Landroidx/work/Data;", "workDataOf", "([LN1/e;)Landroidx/work/Data;", "T", "key", "", "hasKeyWithValueOfType", "(Landroidx/work/Data;Ljava/lang/String;)Z", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String key) {
        h.f(data, "<this>");
        h.f(key, "key");
        h.k();
        throw null;
    }

    public static final Data workDataOf(e... pairs) throws Throwable {
        h.f(pairs, "pairs");
        Data.Builder builder = new Data.Builder();
        for (e eVar : pairs) {
            builder.put((String) eVar.f1121a, eVar.b);
        }
        Data dataBuild = builder.build();
        h.e(dataBuild, "dataBuilder.build()");
        return dataBuild;
    }
}
