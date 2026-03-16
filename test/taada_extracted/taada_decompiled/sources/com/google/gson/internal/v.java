package com.google.gson.internal;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class v extends x {
    public final /* synthetic */ Method b;

    public v(Method method) {
        this.b = method;
    }

    @Override // com.google.gson.internal.x
    public final Object a(Class cls) {
        String strA = B.w.a(cls);
        if (strA != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
        }
        return this.b.invoke(null, cls, Object.class);
    }
}
