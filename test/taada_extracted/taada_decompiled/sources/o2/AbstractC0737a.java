package o2;

import io.ktor.util.StringValues;
import io.ktor.util.StringValuesBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.w;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import net.bytebuddy.description.method.MethodDescription;
import z1.m;

/* JADX INFO: renamed from: o2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0737a implements Annotated, StringValuesBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4279a;

    public AbstractC0737a(Annotations annotations) {
        if (annotations != null) {
            this.f4279a = annotations;
        } else {
            a(0);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 1 ? 3 : 2];
        if (i != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i != 1) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void append(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        d(value);
        b(name).add(value);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(StringValues stringValues) {
        kotlin.jvm.internal.h.f(stringValues, "stringValues");
        stringValues.forEach(new m(this, 0));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(StringValues stringValues) {
        kotlin.jvm.internal.h.f(stringValues, "stringValues");
        stringValues.forEach(new m(this, 1));
    }

    public List b(String str) {
        Map map = (Map) this.f4279a;
        List list = (List) map.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        c(str);
        map.put(str, arrayList);
        return arrayList;
    }

    public void c(String str) {
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void clear() {
        ((Map) this.f4279a).clear();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        return ((Map) this.f4279a).containsKey(name);
    }

    public void d(String value) {
        kotlin.jvm.internal.h.f(value, "value");
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set entries() {
        Set setEntrySet = ((Map) this.f4279a).entrySet();
        kotlin.jvm.internal.h.f(setEntrySet, "<this>");
        Set setUnmodifiableSet = Collections.unmodifiableSet(setEntrySet);
        kotlin.jvm.internal.h.e(setUnmodifiableSet, "unmodifiableSet(this)");
        return setUnmodifiableSet;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public String get(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        List all = getAll(name);
        if (all != null) {
            return (String) kotlin.collections.m.R(all);
        }
        return null;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public List getAll(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        return (List) ((Map) this.f4279a).get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations annotations = (Annotations) this.f4279a;
        if (annotations != null) {
            return annotations;
        }
        a(1);
        throw null;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean getCaseInsensitiveName() {
        return true;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean isEmpty() {
        return ((Map) this.f4279a).isEmpty();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set names() {
        return ((Map) this.f4279a).keySet();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void remove(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        ((Map) this.f4279a).remove(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void removeKeysWithNoEntries() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) this.f4279a).entrySet()) {
            if (((List) entry.getValue()).isEmpty()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            remove((String) ((Map.Entry) it.next()).getKey());
        }
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void set(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        d(value);
        List listB = b(name);
        listB.clear();
        listB.add(value);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(String name, Iterable values) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(values, "values");
        List listB = b(name);
        Iterator it = values.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            d(str);
            listB.add(str);
        }
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(String name, Iterable values) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(values, "values");
        List list = (List) ((Map) this.f4279a).get(name);
        Set setS0 = list != null ? kotlin.collections.m.s0(list) : w.f3806a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (!setS0.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        appendAll(name, arrayList);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        List list = (List) ((Map) this.f4279a).get(name);
        if (list != null) {
            return list.contains(value);
        }
        return false;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean remove(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        List list = (List) ((Map) this.f4279a).get(name);
        if (list != null) {
            return list.remove(value);
        }
        return false;
    }

    public AbstractC0737a(int i) {
        this.f4279a = new z1.d();
    }
}
