package F0;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a b = new a(Collections.unmodifiableMap(new HashMap()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f344a;

    public a(Map map) {
        this.f344a = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f344a.equals(((a) obj).f344a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f344a.hashCode();
    }

    public final String toString() {
        return this.f344a.toString();
    }
}
