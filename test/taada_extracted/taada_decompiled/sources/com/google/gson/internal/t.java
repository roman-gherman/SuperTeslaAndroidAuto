package com.google.gson.internal;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class t extends x {
    public final /* synthetic */ Method b;
    public final /* synthetic */ Object c;

    public t(Object obj, Method method) {
        this.b = method;
        this.c = obj;
    }

    @Override // com.google.gson.internal.x
    public final Object a(Class cls) {
        String strA = B.w.a(cls);
        if (strA != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
        }
        return this.b.invoke(this.c, cls);
    }
}
