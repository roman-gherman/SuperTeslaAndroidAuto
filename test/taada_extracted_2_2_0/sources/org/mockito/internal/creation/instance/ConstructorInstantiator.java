package org.mockito.internal.creation.instance;

import B2.b;
import androidx.constraintlayout.core.motion.a;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.mockito.creation.instance.InstantiationException;
import org.mockito.creation.instance.Instantiator;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.util.Primitives;
import org.mockito.internal.util.StringUtil;

/* JADX INFO: loaded from: classes.dex */
public class ConstructorInstantiator implements Instantiator {
    private final Object[] constructorArgs;
    private final boolean hasOuterClassInstance;

    public ConstructorInstantiator(boolean z6, Object... objArr) {
        this.hasOuterClassInstance = z6;
        this.constructorArgs = objArr;
    }

    private String constructorArgTypes() {
        boolean z6 = this.hasOuterClassInstance;
        String[] strArr = new String[this.constructorArgs.length - (z6 ? 1 : 0)];
        int i = z6 ? 1 : 0;
        while (true) {
            Object[] objArr = this.constructorArgs;
            if (i >= objArr.length) {
                return Arrays.toString(strArr);
            }
            int i3 = i - (z6 ? 1 : 0);
            Object obj = objArr[i];
            strArr[i3] = obj == null ? null : obj.getClass().getName();
            i++;
        }
    }

    private String constructorArgsString() {
        Object[] objArr = this.constructorArgs;
        if (objArr.length == 0) {
            return "a 0-arg constructor";
        }
        if (this.hasOuterClassInstance && objArr.length == 1) {
            return "a 0-arg constructor";
        }
        return "a constructor that matches these argument types: " + constructorArgTypes();
    }

    private void evaluateConstructor(List<Constructor<?>> list, Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        boolean z6 = false;
        boolean z7 = false;
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> cls = parameterTypes[i];
            if (!cls.isPrimitive()) {
                Iterator<Constructor<?>> it = list.iterator();
                while (it.hasNext()) {
                    Class<?> cls2 = it.next().getParameterTypes()[i];
                    if (cls != cls2) {
                        if (cls.isAssignableFrom(cls2)) {
                            z6 = true;
                        } else {
                            z7 = true;
                        }
                    }
                }
            }
        }
        if (!z6) {
            list.clear();
        }
        if (z7 || !z6) {
            list.add(constructor);
        }
    }

    private static <T> T invokeConstructor(Constructor<?> constructor, Object... objArr) {
        return (T) Plugins.getMemberAccessor().lambda$newInstance$0(constructor, objArr);
    }

    private InstantiationException multipleMatchingConstructors(Class<?> cls, List<Constructor<?>> list) {
        return new InstantiationException(StringUtil.join("Unable to create instance of '" + cls.getSimpleName() + "'.", b.h(new StringBuilder("Multiple constructors could be matched to arguments of types "), constructorArgTypes(), ":"), StringUtil.join("", " - ", list), "If you believe that Mockito could do a better job deciding on which constructor to use, please let us know.", "Ticket 685 contains the discussion and a workaround for ambiguous constructors using inner class.", "See https://github.com/mockito/mockito/issues/685"), null);
    }

    private InstantiationException noMatchingConstructor(Class<?> cls) {
        return new InstantiationException(StringUtil.join("Unable to create instance of '" + cls.getSimpleName() + "'.", a.r("Please ensure that the target class has ", constructorArgsString(), this.hasOuterClassInstance ? " and provided outer instance is correct" : "", ".")), null);
    }

    private InstantiationException paramsException(Class<?> cls, Exception exc) {
        return new InstantiationException(StringUtil.join("Unable to create instance of '" + cls.getSimpleName() + "'.", b.h(new StringBuilder("Please ensure the target class has "), constructorArgsString(), " and executes cleanly.")), exc);
    }

    private static boolean paramsMatch(Class<?>[] clsArr, Object[] objArr) {
        if (objArr.length != clsArr.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] == null) {
                if (clsArr[i].isPrimitive()) {
                    return false;
                }
            } else if ((!clsArr[i].isPrimitive() && !clsArr[i].isInstance(objArr[i])) || (clsArr[i].isPrimitive() && !clsArr[i].equals(Primitives.primitiveTypeOf(objArr[i].getClass())))) {
                return false;
            }
        }
        return true;
    }

    private <T> T withParams(Class<T> cls, Object... objArr) {
        LinkedList linkedList = new LinkedList();
        try {
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                if (paramsMatch(constructor.getParameterTypes(), objArr)) {
                    evaluateConstructor(linkedList, constructor);
                }
            }
            if (linkedList.size() == 1) {
                return (T) invokeConstructor((Constructor) linkedList.get(0), objArr);
            }
            if (linkedList.isEmpty()) {
                throw noMatchingConstructor(cls);
            }
            throw multipleMatchingConstructors(cls, linkedList);
        } catch (Exception e) {
            throw paramsException(cls, e);
        }
    }

    @Override // org.mockito.creation.instance.Instantiator
    public <T> T newInstance(Class<T> cls) {
        return (T) withParams(cls, this.constructorArgs);
    }
}
