package com.google.gson.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class o extends q {
    public final /* synthetic */ Method b;

    public o(Method method) {
        this.b = method;
    }

    @Override // com.google.gson.internal.q
    public final boolean a(Object obj, AccessibleObject accessibleObject) {
        try {
            return ((Boolean) this.b.invoke(accessibleObject, obj)).booleanValue();
        } catch (Exception e) {
            throw new RuntimeException("Failed invoking canAccess", e);
        }
    }
}
