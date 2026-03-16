package u1;

import io.ktor.http.Parameters;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Parameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f4863a = new h();

    @Override // io.ktor.util.StringValues
    public final boolean contains(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        getAll(name);
        return false;
    }

    @Override // io.ktor.util.StringValues
    public final Set entries() {
        return kotlin.collections.w.f3806a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Parameters) && ((Parameters) obj).isEmpty();
    }

    @Override // io.ktor.util.StringValues
    public final void forEach(Function2 body) {
        kotlin.jvm.internal.h.f(body, "body");
        io.ktor.utils.io.internal.t.g(this, body);
    }

    @Override // io.ktor.util.StringValues
    public final String get(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        getAll(name);
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final List getAll(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final boolean getCaseInsensitiveName() {
        return true;
    }

    @Override // io.ktor.util.StringValues
    public final boolean isEmpty() {
        return true;
    }

    @Override // io.ktor.util.StringValues
    public final Set names() {
        return kotlin.collections.w.f3806a;
    }

    public final String toString() {
        return "Parameters " + kotlin.collections.w.f3806a;
    }

    @Override // io.ktor.util.StringValues
    public final boolean contains(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        getAll(name);
        return false;
    }
}
