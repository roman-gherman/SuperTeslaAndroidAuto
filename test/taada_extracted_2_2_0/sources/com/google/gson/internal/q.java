package com.google.gson.internal;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f3014a;

    static {
        q oVar;
        if (i.f3002a >= 9) {
            try {
                oVar = new o(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
            } catch (NoSuchMethodException unused) {
                oVar = null;
            }
        } else {
            oVar = null;
        }
        if (oVar == null) {
            oVar = new p();
        }
        f3014a = oVar;
    }

    public abstract boolean a(Object obj, AccessibleObject accessibleObject);
}
