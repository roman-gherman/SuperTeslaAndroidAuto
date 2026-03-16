package org.mockito.internal.util.reflection;

import D0.b;
import R0.d;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
public class ReflectionMemberAccessor implements MemberAccessor {
    private static void silentSetAccessible(AccessibleObject accessibleObject, boolean z6) {
        try {
            accessibleObject.setAccessible(z6);
        } catch (RuntimeException unused) {
        }
    }

    @Override // org.mockito.plugins.MemberAccessor
    public Object get(Field field, Object obj) {
        silentSetAccessible(field, true);
        try {
            try {
                return field.get(obj);
            } catch (IllegalAccessException e) {
                throw e;
            } catch (IllegalArgumentException e6) {
                throw e6;
            } catch (RuntimeException e7) {
                throw new IllegalStateException("Could not read " + field + " from " + obj, e7);
            }
        } finally {
            silentSetAccessible(field, false);
        }
    }

    @Override // org.mockito.plugins.MemberAccessor
    public Object invoke(Method method, Object obj, Object... objArr) throws IllegalAccessException {
        silentSetAccessible(method, true);
        try {
            try {
                return method.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
                throw e;
            } catch (IllegalArgumentException e6) {
                throw e6;
            } catch (RuntimeException e7) {
                throw new IllegalStateException("Could not invoke " + method + " on " + obj, e7);
            } catch (InvocationTargetException e8) {
                throw e8;
            }
        } finally {
            silentSetAccessible(method, false);
        }
    }

    @Override // org.mockito.plugins.MemberAccessor
    /* JADX INFO: renamed from: newInstance */
    public Object lambda$newInstance$0(Constructor<?> constructor, Object... objArr) {
        return newInstance(constructor, new b(24), objArr);
    }

    @Override // org.mockito.plugins.MemberAccessor
    public void set(Field field, Object obj, Object obj2) {
        silentSetAccessible(field, true);
        try {
            try {
                field.set(obj, obj2);
            } catch (IllegalAccessException e) {
                throw e;
            } catch (IllegalArgumentException e6) {
            } catch (RuntimeException e7) {
                throw new IllegalStateException("Could not write " + field + " to " + obj, e7);
            }
        } finally {
            silentSetAccessible(field, false);
        }
    }

    @Override // org.mockito.plugins.MemberAccessor
    public Object newInstance(Constructor<?> constructor, MemberAccessor.OnConstruction onConstruction, Object... objArr) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        silentSetAccessible(constructor, true);
        try {
            try {
                return onConstruction.invoke(new d(5, constructor, objArr));
            } catch (IllegalAccessException e) {
                throw e;
            } catch (IllegalArgumentException e6) {
                throw e6;
            } catch (InstantiationException e7) {
                throw e7;
            } catch (RuntimeException e8) {
                throw new IllegalStateException("Failed to invoke " + constructor + " with " + Arrays.toString(objArr), e8);
            } catch (InvocationTargetException e9) {
                throw e9;
            }
        } finally {
            silentSetAccessible(constructor, false);
        }
    }
}
