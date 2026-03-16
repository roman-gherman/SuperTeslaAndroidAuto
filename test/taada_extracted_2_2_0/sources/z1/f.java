package z1;

import io.ktor.util.Attributes;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Attributes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f5176a = new ConcurrentHashMap();

    public final Map a() {
        return this.f5176a;
    }

    @Override // io.ktor.util.Attributes
    public final Object computeIfAbsent(a key, Function0 block) {
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(block, "block");
        ConcurrentHashMap concurrentHashMap = this.f5176a;
        Object obj = concurrentHashMap.get(key);
        if (obj != null) {
            return obj;
        }
        Object objInvoke = block.invoke();
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(key, objInvoke);
        if (objPutIfAbsent != null) {
            objInvoke = objPutIfAbsent;
        }
        kotlin.jvm.internal.h.d(objInvoke, "null cannot be cast to non-null type T of io.ktor.util.ConcurrentSafeAttributes.computeIfAbsent");
        return objInvoke;
    }

    @Override // io.ktor.util.Attributes
    public final boolean contains(a key) {
        kotlin.jvm.internal.h.f(key, "key");
        return a().containsKey(key);
    }

    @Override // io.ktor.util.Attributes
    public final Object get(a key) {
        kotlin.jvm.internal.h.f(key, "key");
        Object orNull = getOrNull(key);
        if (orNull != null) {
            return orNull;
        }
        throw new IllegalStateException("No instance for key " + key);
    }

    @Override // io.ktor.util.Attributes
    public final List getAllKeys() {
        return kotlin.collections.m.o0(a().keySet());
    }

    @Override // io.ktor.util.Attributes
    public final Object getOrNull(a key) {
        kotlin.jvm.internal.h.f(key, "key");
        return a().get(key);
    }

    @Override // io.ktor.util.Attributes
    public final void put(a key, Object value) {
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(value, "value");
        a().put(key, value);
    }

    @Override // io.ktor.util.Attributes
    public final void remove(a key) {
        kotlin.jvm.internal.h.f(key, "key");
        a().remove(key);
    }

    @Override // io.ktor.util.Attributes
    public final Object take(a key) {
        kotlin.jvm.internal.h.f(key, "key");
        Object obj = get(key);
        remove(key);
        return obj;
    }

    @Override // io.ktor.util.Attributes
    public final Object takeOrNull(a key) {
        kotlin.jvm.internal.h.f(key, "key");
        Object orNull = getOrNull(key);
        remove(key);
        return orNull;
    }
}
