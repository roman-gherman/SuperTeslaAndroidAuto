package org.mockito.internal.util.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
public class BeanPropertySetter {
    private static final String SET_PREFIX = "set";
    private final Field field;
    private final boolean reportNoSetterFound;
    private final Object target;

    public BeanPropertySetter(Object obj, Field field, boolean z6) {
        this.field = field;
        this.target = obj;
        this.reportNoSetterFound = z6;
    }

    private void reportNoSetterFound() {
        if (this.reportNoSetterFound) {
            throw new RuntimeException("Problems setting value on object: [" + this.target + "] for property : [" + this.field.getName() + "], setter not found");
        }
    }

    private String setterName(String str) {
        StringBuilder sb = new StringBuilder(SET_PREFIX);
        sb.append(str.substring(0, 1).toUpperCase(Locale.ENGLISH));
        sb.append((CharSequence) str, 1, str.length());
        return sb.toString();
    }

    public boolean set(Object obj) {
        MemberAccessor memberAccessor = Plugins.getMemberAccessor();
        Method method = null;
        try {
            method = this.target.getClass().getMethod(setterName(this.field.getName()), this.field.getType());
            memberAccessor.invoke(method, this.target, obj);
            return true;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Access not authorized on field '" + this.field + "' of object '" + this.target + "' with value: '" + obj + "'", e);
        } catch (NoSuchMethodException unused) {
            reportNoSetterFound();
            reportNoSetterFound();
            return false;
        } catch (InvocationTargetException e6) {
            throw new RuntimeException("Setter '" + method + "' of '" + this.target + "' with value '" + obj + "' threw exception : '" + e6.getTargetException() + "'", e6);
        }
    }

    public BeanPropertySetter(Object obj, Field field) {
        this(obj, field, false);
    }
}
