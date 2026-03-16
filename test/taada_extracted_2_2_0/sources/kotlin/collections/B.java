package kotlin.collections;

import io.ktor.utils.io.b0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class B extends b0 {
    public static int F(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map G(N1.e pair) {
        kotlin.jvm.internal.h.f(pair, "pair");
        Map mapSingletonMap = Collections.singletonMap(pair.f1121a, pair.b);
        kotlin.jvm.internal.h.e(mapSingletonMap, "singletonMap(pair.first, pair.second)");
        return mapSingletonMap;
    }
}
