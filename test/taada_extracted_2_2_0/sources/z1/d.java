package z1;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Map, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f5174a = new LinkedHashMap();

    @Override // java.util.Map
    public final void clear() {
        this.f5174a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String key = (String) obj;
        kotlin.jvm.internal.h.f(key, "key");
        return this.f5174a.containsKey(new e(key));
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f5174a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return new i(this.f5174a.entrySet(), c.b, c.c);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        return kotlin.jvm.internal.h.a(((d) obj).f5174a, this.f5174a);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        kotlin.jvm.internal.h.f(key, "key");
        return this.f5174a.get(k1.j.d(key));
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f5174a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f5174a.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return new i(this.f5174a.keySet(), c.d, c.e);
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object value) {
        String key = (String) obj;
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(value, "value");
        return this.f5174a.put(k1.j.d(key), value);
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        kotlin.jvm.internal.h.f(from, "from");
        for (Map.Entry entry : from.entrySet()) {
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            kotlin.jvm.internal.h.f(key, "key");
            kotlin.jvm.internal.h.f(value, "value");
            this.f5174a.put(k1.j.d(key), value);
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        kotlin.jvm.internal.h.f(key, "key");
        return this.f5174a.remove(k1.j.d(key));
    }

    @Override // java.util.Map
    public final int size() {
        return this.f5174a.size();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f5174a.values();
    }
}
