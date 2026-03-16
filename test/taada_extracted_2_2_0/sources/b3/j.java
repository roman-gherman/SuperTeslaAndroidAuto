package b3;

import a3.AbstractC0162z;
import a3.C0142e;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements NewKotlinTypeChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1706a = b.f1698a;
    public final N2.o b = new N2.o(N2.o.d);

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public final boolean equalTypes(AbstractC0162z a6, AbstractC0162z b) {
        kotlin.jvm.internal.h.f(a6, "a");
        kotlin.jvm.internal.h.f(b, "b");
        return C0142e.g(e.n(false, this.f1706a, 6), a6.f(), b.f());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public final d getKotlinTypeRefiner() {
        return c.f1699a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public final N2.o getOverridingUtil() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public final boolean isSubtypeOf(AbstractC0162z subtype, AbstractC0162z supertype) {
        kotlin.jvm.internal.h.f(subtype, "subtype");
        kotlin.jvm.internal.h.f(supertype, "supertype");
        return C0142e.m(C0142e.f1548a, e.n(true, this.f1706a, 6), subtype.f(), supertype.f());
    }
}
