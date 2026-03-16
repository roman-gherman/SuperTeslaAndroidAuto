package u1;

import io.ktor.http.Headers;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: u1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0842g implements Headers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0842g f4862a = new C0842g();

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
        return "Headers " + kotlin.collections.w.f3806a;
    }

    @Override // io.ktor.util.StringValues
    public final boolean contains(String name, String value) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(value, "value");
        getAll(name);
        return false;
    }
}
