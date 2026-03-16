package org.mockito.internal.util.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
public class LenientCopyTool {
    MemberAccessor accessor = Plugins.getMemberAccessor();

    private <T> void copy(T t6, T t7, Class<?> cls) {
        while (cls != Object.class) {
            copyValues(t6, t7, cls);
            cls = cls.getSuperclass();
        }
    }

    private <T> void copyValues(T t6, T t7, Class<?> cls) {
        for (Field field : cls.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                try {
                    this.accessor.set(field, t7, this.accessor.get(field, t6));
                } catch (Throwable unused) {
                }
            }
        }
    }

    public <T> void copyToMock(T t6, T t7) {
        copy(t6, t7, t6.getClass());
    }

    public <T> void copyToRealObject(T t6, T t7) {
        copy(t6, t7, t6.getClass());
    }
}
