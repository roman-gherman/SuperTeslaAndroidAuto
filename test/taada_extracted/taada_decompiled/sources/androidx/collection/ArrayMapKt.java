package androidx.collection;

import N1.e;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001aQ\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"K", "V", "Landroidx/collection/ArrayMap;", "arrayMapOf", "()Landroidx/collection/ArrayMap;", "", "LN1/e;", "pairs", "([LN1/e;)Landroidx/collection/ArrayMap;", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class ArrayMapKt {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> ArrayMap<K, V> arrayMapOf(e... pairs) {
        h.g(pairs, "pairs");
        ArrayMap<K, V> arrayMap = (ArrayMap<K, V>) new ArrayMap(pairs.length);
        for (e eVar : pairs) {
            arrayMap.put(eVar.f1121a, eVar.b);
        }
        return arrayMap;
    }
}
