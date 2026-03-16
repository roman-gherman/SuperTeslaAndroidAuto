package com.google.android.gms.dynamic;

import D.j;
import android.os.IBinder;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class a extends O.a implements IObjectWrapper {
    public static final /* synthetic */ int c = 0;
    public final Object b;

    public a(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper");
        this.b = obj;
    }

    public static Object b(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof a) {
            return ((a) iObjectWrapper).b;
        }
        IBinder iBinderAsBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException(B2.b.c(declaredFields.length, "Unexpected number of IObjectWrapper declared fields: "));
        }
        j.c(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e6) {
            throw new IllegalArgumentException("Binder object is null.", e6);
        }
    }
}
