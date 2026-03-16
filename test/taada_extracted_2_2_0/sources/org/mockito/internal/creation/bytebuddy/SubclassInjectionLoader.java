package org.mockito.internal.creation.bytebuddy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.utility.GraalImageCode;
import org.mockito.codegen.InjectionBase;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;

/* JADX INFO: loaded from: classes.dex */
class SubclassInjectionLoader implements SubclassLoader {
    private static final String ERROR_MESSAGE = StringUtil.join("The current JVM does not support any class injection mechanism.", "", "Currently, Mockito supports injection via either by method handle lookups or using sun.misc.Unsafe", "Neither seems to be available on your current JVM.");
    private final SubclassLoader loader;

    public static class WithIsolatedLoader implements SubclassLoader {
        private WithIsolatedLoader() {
        }

        @Override // org.mockito.internal.creation.bytebuddy.SubclassLoader
        public boolean isDisrespectingOpenness() {
            return false;
        }

        @Override // org.mockito.internal.creation.bytebuddy.SubclassLoader
        public ClassLoadingStrategy<ClassLoader> resolveStrategy(Class<?> cls, ClassLoader classLoader, boolean z6) {
            return ClassLoadingStrategy.Default.WRAPPER;
        }
    }

    public static class WithLookup implements SubclassLoader {
        private final Object codegenLookup;
        private final Object lookup;
        private final Method privateLookupIn;

        public WithLookup(Object obj, Object obj2, Method method) {
            this.lookup = obj;
            this.codegenLookup = obj2;
            this.privateLookupIn = method;
        }

        @Override // org.mockito.internal.creation.bytebuddy.SubclassLoader
        public boolean isDisrespectingOpenness() {
            return false;
        }

        @Override // org.mockito.internal.creation.bytebuddy.SubclassLoader
        public ClassLoadingStrategy<ClassLoader> resolveStrategy(Class<?> cls, ClassLoader classLoader, boolean z6) {
            if (!z6) {
                return classLoader == InjectionBase.class.getClassLoader() ? ClassLoadingStrategy.UsingLookup.of(this.codegenLookup) : ClassLoadingStrategy.Default.WRAPPER.with(cls.getProtectionDomain());
            }
            try {
                try {
                    return ClassLoadingStrategy.UsingLookup.of(this.privateLookupIn.invoke(null, cls, this.lookup));
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof IllegalAccessException) {
                        return ClassLoadingStrategy.Default.WRAPPER.with(cls.getProtectionDomain());
                    }
                    throw e.getCause();
                }
            } catch (Throwable th) {
                throw new MockitoException(StringUtil.join(androidx.constraintlayout.core.motion.a.j(cls, "The Java module system prevents Mockito from defining a mock class in the same package as "), "", "To overcome this, you must open and export the mocked type to Mockito.", "Remember that you can also do so programmatically if the mocked class is defined by the same module as your test code", th));
            }
        }
    }

    public static class WithReflection implements SubclassLoader {
        private WithReflection() {
        }

        @Override // org.mockito.internal.creation.bytebuddy.SubclassLoader
        public boolean isDisrespectingOpenness() {
            return true;
        }

        @Override // org.mockito.internal.creation.bytebuddy.SubclassLoader
        public ClassLoadingStrategy<ClassLoader> resolveStrategy(Class<?> cls, ClassLoader classLoader, boolean z6) {
            return ClassLoadingStrategy.Default.INJECTION.with(z6 ? cls.getProtectionDomain() : InjectionBase.class.getProtectionDomain());
        }
    }

    public SubclassInjectionLoader() {
        if (!Boolean.parseBoolean(System.getProperty("org.mockito.internal.noUnsafeInjection", Boolean.toString(GraalImageCode.getCurrent().isDefined()))) && ClassInjector.UsingReflection.isAvailable()) {
            this.loader = new WithReflection();
        } else if (GraalImageCode.getCurrent().isDefined()) {
            this.loader = new WithIsolatedLoader();
        } else {
            if (!ClassInjector.UsingLookup.isAvailable()) {
                throw new MockitoException(StringUtil.join(ERROR_MESSAGE, "", Platform.describe()));
            }
            this.loader = tryLookup();
        }
    }

    private static SubclassLoader tryLookup() {
        try {
            Class<?> cls = Class.forName("java.lang.invoke.MethodHandles");
            Object objInvoke = cls.getMethod("lookup", new Class[0]).invoke(null, new Object[0]);
            Method method = cls.getMethod("privateLookupIn", Class.class, Class.forName("java.lang.invoke.MethodHandles$Lookup"));
            return new WithLookup(objInvoke, method.invoke(null, InjectionBase.class, objInvoke), method);
        } catch (Exception e) {
            throw new MockitoException(StringUtil.join(ERROR_MESSAGE, "", Platform.describe()), e);
        }
    }

    @Override // org.mockito.internal.creation.bytebuddy.SubclassLoader
    public boolean isDisrespectingOpenness() {
        return this.loader.isDisrespectingOpenness();
    }

    @Override // org.mockito.internal.creation.bytebuddy.SubclassLoader
    public ClassLoadingStrategy<ClassLoader> resolveStrategy(Class<?> cls, ClassLoader classLoader, boolean z6) {
        return this.loader.resolveStrategy(cls, classLoader, z6);
    }
}
