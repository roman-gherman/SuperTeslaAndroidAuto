package h2;

import java.lang.reflect.Constructor;

/* JADX INFO: renamed from: h2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0503f extends s0 {
    public final Constructor b;

    public C0503f(Constructor constructor) {
        kotlin.jvm.internal.h.f(constructor, "constructor");
        this.b = constructor;
    }

    @Override // h2.s0
    public final String c() {
        Class<?>[] parameterTypes = this.b.getParameterTypes();
        kotlin.jvm.internal.h.e(parameterTypes, "constructor.parameterTypes");
        return kotlin.collections.j.G(parameterTypes, "<init>(", ")V", C0499b.f3393h, 24);
    }
}
