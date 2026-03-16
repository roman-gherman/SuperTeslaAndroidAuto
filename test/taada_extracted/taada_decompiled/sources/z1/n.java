package z1;

import io.ktor.util.StringValues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n implements StringValues {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5182a;

    public n(Map values) {
        kotlin.jvm.internal.h.f(values, "values");
        d dVar = new d();
        for (Map.Entry entry : values.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add((String) list.get(i));
            }
            dVar.put(str, arrayList);
        }
        this.f5182a = dVar;
    }

    @Override // io.ktor.util.StringValues
    public final boolean contains(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        return ((List) this.f5182a.get(name)) != null;
    }

    @Override // io.ktor.util.StringValues
    public final Set entries() {
        Set setEntrySet = this.f5182a.entrySet();
        kotlin.jvm.internal.h.f(setEntrySet, "<this>");
        Set setUnmodifiableSet = Collections.unmodifiableSet(setEntrySet);
        kotlin.jvm.internal.h.e(setUnmodifiableSet, "unmodifiableSet(this)");
        return setUnmodifiableSet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringValues)) {
            return false;
        }
        StringValues stringValues = (StringValues) obj;
        if (true != stringValues.getCaseInsensitiveName()) {
            return false;
        }
        return entries().equals(stringValues.entries());
    }

    @Override // io.ktor.util.StringValues
    public final void forEach(Function2 body) {
        kotlin.jvm.internal.h.f(body, "body");
        for (Map.Entry entry : this.f5182a.entrySet()) {
            body.mo5invoke((String) entry.getKey(), (List) entry.getValue());
        }
    }

    @Override // io.ktor.util.StringValues
    public final String get(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        List list = (List) this.f5182a.get(name);
        if (list != null) {
            return (String) kotlin.collections.m.R(list);
        }
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final List getAll(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        return (List) this.f5182a.get(name);
    }

    @Override // io.ktor.util.StringValues
    public final boolean getCaseInsensitiveName() {
        return true;
    }

    public final int hashCode() {
        Set setEntries = entries();
        return setEntries.hashCode() + (Boolean.hashCode(true) * 961);
    }

    @Override // io.ktor.util.StringValues
    public final boolean isEmpty() {
        return this.f5182a.isEmpty();
    }

    @Override // io.ktor.util.StringValues
    public final Set names() {
        Set setKeySet = this.f5182a.keySet();
        kotlin.jvm.internal.h.f(setKeySet, "<this>");
        Set setUnmodifiableSet = Collections.unmodifiableSet(setKeySet);
        kotlin.jvm.internal.h.e(setUnmodifiableSet, "unmodifiableSet(this)");
        return setUnmodifiableSet;
    }

    @Override // io.ktor.util.StringValues
    public final boolean contains(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        List list = (List) this.f5182a.get(name);
        if (list != null) {
            return list.contains(value);
        }
        return false;
    }
}
