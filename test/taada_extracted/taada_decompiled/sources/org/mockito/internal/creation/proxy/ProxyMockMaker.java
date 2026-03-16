package org.mockito.internal.creation.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicReference;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.debugging.LocationFactory;
import org.mockito.internal.invocation.DefaultInvocationFactory;
import org.mockito.internal.invocation.RealMethod;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockMaker;

/* JADX INFO: loaded from: classes.dex */
public class ProxyMockMaker implements MockMaker {
    private static final Object[] EMPTY = new Object[0];
    private final ProxyRealMethod proxyRealMethod = ProxyRealMethod.make();

    public static class CommonClassLoader extends ClassLoader {
        private final ClassLoader left;
        private final ClassLoader right;

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str) {
            try {
                return this.left.loadClass(str);
            } catch (ClassNotFoundException unused) {
                return this.right.loadClass(str);
            }
        }

        private CommonClassLoader(ClassLoader classLoader, ClassLoader classLoader2) {
            super(null);
            this.left = classLoader;
            this.right = classLoader2;
        }
    }

    public class MockInvocationHandler implements InvocationHandler {
        private final AtomicReference<MockHandler<?>> handler;
        private final MockCreationSettings<?> settings;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (objArr == null) {
                objArr = ProxyMockMaker.EMPTY;
            }
            Object[] objArr2 = objArr;
            if (method.getDeclaringClass() == Object.class) {
                String name = method.getName();
                name.getClass();
                switch (name) {
                    case "toString":
                        break;
                    case "equals":
                        return Boolean.valueOf(obj == objArr2[0]);
                    case "hashCode":
                        return Integer.valueOf(System.identityHashCode(obj));
                    default:
                        throw new MockitoException(StringUtil.join("Unexpected overridable method of Object class found", "", "The method " + method + " was not expected to be declared. Either your JVM build offers non-official API or the current functionality is not supported", Platform.describe()));
                }
            }
            return this.handler.get().handle(DefaultInvocationFactory.createInvocation(obj, method, objArr2, Modifier.isAbstract(method.getModifiers()) ? RealMethod.IsIllegal.INSTANCE : ProxyMockMaker.this.proxyRealMethod.resolve(obj, method, objArr2), this.settings, LocationFactory.create()));
        }

        private MockInvocationHandler(MockHandler<?> mockHandler, MockCreationSettings<?> mockCreationSettings) {
            this.handler = new AtomicReference<>(mockHandler);
            this.settings = mockCreationSettings;
        }
    }

    private static ClassLoader resolveCommonClassLoader(ClassLoader classLoader, Class<?> cls) {
        if (classLoader == null) {
            return cls.getClassLoader();
        }
        ClassLoader classLoader2 = cls.getClassLoader();
        if (classLoader2 != null && classLoader != classLoader2) {
            while (classLoader2 != null) {
                if (classLoader2 == classLoader) {
                    return cls.getClassLoader();
                }
                classLoader2 = classLoader2.getParent();
            }
            for (ClassLoader parent = classLoader; parent != null; parent = parent.getParent()) {
                if (parent != cls.getClassLoader()) {
                }
            }
            return new CommonClassLoader(classLoader, cls.getClassLoader());
        }
        return classLoader;
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        int i = 0;
        int i3 = mockCreationSettings.getTypeToMock() == Object.class ? 1 : 0;
        Class[] clsArr = new Class[mockCreationSettings.getExtraInterfaces().size() + (i3 ^ 1)];
        if (i3 == 0) {
            clsArr[0] = mockCreationSettings.getTypeToMock();
            i = 1;
        }
        ClassLoader classLoader = mockCreationSettings.getTypeToMock().getClassLoader();
        for (Class<?> cls : mockCreationSettings.getExtraInterfaces()) {
            clsArr[i] = cls;
            classLoader = resolveCommonClassLoader(classLoader, cls);
            i++;
        }
        return (T) Proxy.newProxyInstance(resolveCommonClassLoader(classLoader, ProxyMockMaker.class), clsArr, new MockInvocationHandler(mockHandler, mockCreationSettings));
    }

    @Override // org.mockito.plugins.MockMaker
    public MockHandler getHandler(Object obj) {
        if (!Proxy.isProxyClass(obj.getClass())) {
            return null;
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
        if (invocationHandler instanceof MockInvocationHandler) {
            return (MockHandler) ((MockInvocationHandler) invocationHandler).handler.get();
        }
        return null;
    }

    @Override // org.mockito.plugins.MockMaker
    public MockMaker.TypeMockability isTypeMockable(final Class<?> cls) {
        return new MockMaker.TypeMockability() { // from class: org.mockito.internal.creation.proxy.ProxyMockMaker.1
            @Override // org.mockito.plugins.MockMaker.TypeMockability
            public boolean mockable() {
                return cls.isInterface() || cls == Object.class;
            }

            @Override // org.mockito.plugins.MockMaker.TypeMockability
            public String nonMockableReason() {
                return mockable() ? "" : "non-interface";
            }
        };
    }

    @Override // org.mockito.plugins.MockMaker
    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        ((MockInvocationHandler) Proxy.getInvocationHandler(obj)).handler.set(mockHandler);
    }
}
