package h2;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: h2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0508k extends s0 {
    public final Method b;
    public final Method c;

    public C0508k(Method getterMethod, Method method) {
        kotlin.jvm.internal.h.f(getterMethod, "getterMethod");
        this.b = getterMethod;
        this.c = method;
    }

    @Override // h2.s0
    public final String c() {
        return s0.b(this.b);
    }
}
