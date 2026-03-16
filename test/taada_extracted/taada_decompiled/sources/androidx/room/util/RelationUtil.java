package androidx.room.util;

import N1.m;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u000b\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u00022\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00042\u0006\u0010\u0007\u001a\u00020\u00062.\u0010\n\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\f\u001aC\u0010\u000e\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000e\u0010\u000f\u001aY\u0010\u0011\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "K", "V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "", "isRelationCollection", "Lkotlin/Function1;", "LN1/m;", "fetchBlock", "recursiveFetchHashMap", "(Ljava/util/HashMap;ZLkotlin/jvm/functions/Function1;)V", "Landroidx/collection/LongSparseArray;", "recursiveFetchLongSparseArray", "(Landroidx/collection/LongSparseArray;ZLkotlin/jvm/functions/Function1;)V", "Landroidx/collection/ArrayMap;", "recursiveFetchArrayMap", "(Landroidx/collection/ArrayMap;ZLkotlin/jvm/functions/Function1;)V", "room-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RelationUtil {
    public static final <K, V> void recursiveFetchArrayMap(ArrayMap<K, V> map, boolean z6, Function1<? super ArrayMap<K, V>, m> fetchBlock) {
        h.f(map, "map");
        h.f(fetchBlock, "fetchBlock");
        ArrayMap arrayMap = new ArrayMap(999);
        int size = map.size();
        int i = 0;
        int i3 = 0;
        while (i < size) {
            if (z6) {
                arrayMap.put(map.keyAt(i), map.valueAt(i));
            } else {
                arrayMap.put(map.keyAt(i), null);
            }
            i++;
            i3++;
            if (i3 == 999) {
                fetchBlock.invoke(arrayMap);
                if (!z6) {
                    map.putAll((Map) arrayMap);
                }
                arrayMap.clear();
                i3 = 0;
            }
        }
        if (i3 > 0) {
            fetchBlock.invoke(arrayMap);
            if (z6) {
                return;
            }
            map.putAll((Map) arrayMap);
        }
    }

    public static final <K, V> void recursiveFetchHashMap(HashMap<K, V> map, boolean z6, Function1<? super HashMap<K, V>, m> fetchBlock) {
        int i;
        h.f(map, "map");
        h.f(fetchBlock, "fetchBlock");
        HashMap map2 = new HashMap(999);
        loop0: while (true) {
            i = 0;
            for (K key : map.keySet()) {
                if (z6) {
                    h.e(key, "key");
                    map2.put(key, map.get(key));
                } else {
                    h.e(key, "key");
                    map2.put(key, null);
                }
                i++;
                if (i == 999) {
                    fetchBlock.invoke(map2);
                    if (!z6) {
                        map.putAll(map2);
                    }
                    map2.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            fetchBlock.invoke(map2);
            if (z6) {
                return;
            }
            map.putAll(map2);
        }
    }

    public static final <V> void recursiveFetchLongSparseArray(LongSparseArray<V> map, boolean z6, Function1<? super LongSparseArray<V>, m> fetchBlock) {
        h.f(map, "map");
        h.f(fetchBlock, "fetchBlock");
        LongSparseArray<? extends V> longSparseArray = new LongSparseArray<>(999);
        int size = map.size();
        int i = 0;
        int i3 = 0;
        while (i < size) {
            if (z6) {
                longSparseArray.put(map.keyAt(i), map.valueAt(i));
            } else {
                longSparseArray.put(map.keyAt(i), null);
            }
            i++;
            i3++;
            if (i3 == 999) {
                fetchBlock.invoke(longSparseArray);
                if (!z6) {
                    map.putAll(longSparseArray);
                }
                longSparseArray.clear();
                i3 = 0;
            }
        }
        if (i3 > 0) {
            fetchBlock.invoke(longSparseArray);
            if (z6) {
                return;
            }
            map.putAll(longSparseArray);
        }
    }
}
