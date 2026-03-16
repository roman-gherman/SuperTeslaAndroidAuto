package org.mockito.internal.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.JvmInline;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.stubbing.answers.InvocationInfo;
import org.mockito.invocation.InvocationOnMock;

/* JADX INFO: loaded from: classes.dex */
public class KotlinInlineClassUtil {
    private static Class<Annotation> jvmInlineAnnotation;

    static {
        try {
            jvmInlineAnnotation = JvmInline.class;
        } catch (ClassNotFoundException unused) {
        }
    }

    public static boolean isInlineClassWithAssignableUnderlyingType(Class<?> cls, Class<?> cls2) {
        try {
            Class<Annotation> cls3 = jvmInlineAnnotation;
            if (cls3 != null && cls.isAnnotationPresent(cls3)) {
                cls.getDeclaredMethod("box-impl", cls2);
                return true;
            }
        } catch (NoSuchMethodException unused) {
        }
        return false;
    }

    private static Object unboxInlineClassIfPossible(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return cls.getDeclaredMethod("unbox-impl", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw Reporter.inlineClassWithoutUnboxImpl(cls, e);
        }
    }

    public static Object unboxUnderlyingValueIfNeeded(InvocationOnMock invocationOnMock, Object obj) {
        if (obj != null && jvmInlineAnnotation != null) {
            Class<?> cls = obj.getClass();
            Class<?> returnType = new InvocationInfo(invocationOnMock).getMethod().getReturnType();
            if (!cls.isAssignableFrom(returnType) && isInlineClassWithAssignableUnderlyingType(cls, returnType)) {
                return unboxInlineClassIfPossible(obj);
            }
        }
        return obj;
    }
}
