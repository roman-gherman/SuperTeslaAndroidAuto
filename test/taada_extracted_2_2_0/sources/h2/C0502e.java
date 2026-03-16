package h2;

import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: renamed from: h2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0502e extends s0 {
    public final List b;

    public C0502e(Class jClass) {
        kotlin.jvm.internal.h.f(jClass, "jClass");
        Method[] declaredMethods = jClass.getDeclaredMethods();
        kotlin.jvm.internal.h.e(declaredMethods, "jClass.declaredMethods");
        this.b = kotlin.collections.j.J(declaredMethods, new com.google.android.gms.location.h(4));
    }

    @Override // h2.s0
    public final String c() {
        return kotlin.collections.m.V(this.b, "", "<init>(", ")V", C0499b.f3392g, 24);
    }
}
