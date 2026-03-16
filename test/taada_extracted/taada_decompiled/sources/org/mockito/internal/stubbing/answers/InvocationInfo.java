package org.mockito.internal.stubbing.answers;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import org.mockito.internal.invocation.AbstractAwareMethod;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.util.Primitives;
import org.mockito.internal.util.reflection.GenericMetadataSupport;
import org.mockito.invocation.InvocationOnMock;

/* JADX INFO: loaded from: classes.dex */
public class InvocationInfo implements AbstractAwareMethod {
    private final InvocationOnMock invocation;
    private final Method method;

    public InvocationInfo(InvocationOnMock invocationOnMock) {
        this.method = invocationOnMock.getMethod();
        this.invocation = invocationOnMock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isValidExceptionForClass, reason: merged with bridge method [inline-methods] */
    public boolean lambda$isValidExceptionForParents$0(Class<?> cls, Throwable th) {
        try {
            return isValidException(cls.getMethod(this.method.getName(), this.method.getParameterTypes()), th);
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isValidExceptionForParents, reason: merged with bridge method [inline-methods] */
    public boolean lambda$isValidExceptionForParents$1(Class<?> cls, final Throwable th) {
        ArrayList arrayList = new ArrayList(Arrays.asList(cls.getInterfaces()));
        if (cls.getSuperclass() != null) {
            arrayList.add(cls.getSuperclass());
        }
        final int i = 0;
        if (arrayList.stream().anyMatch(new Predicate(this) { // from class: org.mockito.internal.stubbing.answers.a
            public final /* synthetic */ InvocationInfo b;

            {
                this.b = this;
            }

            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                Class cls2 = (Class) obj;
                switch (i) {
                    case 0:
                        return this.b.lambda$isValidExceptionForParents$0(th, cls2);
                    default:
                        return this.b.lambda$isValidExceptionForParents$1(th, cls2);
                }
            }
        })) {
            return true;
        }
        final int i3 = 1;
        return arrayList.stream().anyMatch(new Predicate(this) { // from class: org.mockito.internal.stubbing.answers.a
            public final /* synthetic */ InvocationInfo b;

            {
                this.b = this;
            }

            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                Class cls2 = (Class) obj;
                switch (i3) {
                    case 0:
                        return this.b.lambda$isValidExceptionForParents$0(th, cls2);
                    default:
                        return this.b.lambda$isValidExceptionForParents$1(th, cls2);
                }
            }
        });
    }

    public Method getMethod() {
        return this.method;
    }

    public String getMethodName() {
        return this.method.getName();
    }

    @Override // org.mockito.internal.invocation.AbstractAwareMethod
    public boolean isAbstract() {
        return (this.method.getModifiers() & 1024) != 0;
    }

    public boolean isDeclaredOnInterface() {
        return this.method.getDeclaringClass().isInterface();
    }

    public boolean isValidException(Throwable th) {
        if (isValidException(this.method, th)) {
            return true;
        }
        return lambda$isValidExceptionForParents$1(this.method.getDeclaringClass(), th);
    }

    public boolean isValidReturnType(Class<?> cls) {
        return (this.method.getReturnType().isPrimitive() || cls.isPrimitive()) ? Primitives.primitiveTypeOf(cls) == Primitives.primitiveTypeOf(this.method.getReturnType()) : this.method.getReturnType().isAssignableFrom(cls);
    }

    public boolean isVoid() {
        Class<?> clsRawType = GenericMetadataSupport.inferFrom(MockUtil.getMockHandler(this.invocation.getMock()).getMockSettings().getTypeToMock()).resolveGenericReturnType(this.method).rawType();
        return clsRawType == Void.TYPE || clsRawType == Void.class;
    }

    public String printMethodReturnType() {
        return this.method.getReturnType().getSimpleName();
    }

    public boolean returnsPrimitive() {
        return this.method.getReturnType().isPrimitive();
    }

    private boolean isValidException(Method method, Throwable th) {
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        Class<?> cls = th.getClass();
        for (Class<?> cls2 : exceptionTypes) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }
}
