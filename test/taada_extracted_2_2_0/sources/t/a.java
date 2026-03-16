package T;

import D.j;
import com.google.android.gms.common.api.Api$ApiOptions;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Api$ApiOptions.Optional {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1299a = new a();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        ((a) obj).getClass();
        return j.f(null, null) && j.f(null, null) && j.f(null, null) && j.f(null, null) && j.f(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Arrays.hashCode(new Object[]{bool, bool, null, bool, bool, null, null, null, null});
    }
}
