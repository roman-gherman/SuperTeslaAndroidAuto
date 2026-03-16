package org.mockito.internal.creation.bytebuddy;

import java.lang.reflect.Modifier;
import org.mockito.creation.instance.InstantiationException;
import org.mockito.creation.instance.Instantiator;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockMaker;

/* JADX INFO: loaded from: classes.dex */
public class SubclassByteBuddyMockMaker implements ClassCreatingMockMaker {
    private final BytecodeGenerator cachingMockBytecodeGenerator;

    public SubclassByteBuddyMockMaker() {
        this(new SubclassInjectionLoader());
    }

    private static String describeClass(Class<?> cls) {
        if (cls == null) {
            return "null";
        }
        return "'" + cls.getCanonicalName() + "', loaded by classloader : '" + cls.getClassLoader() + "'";
    }

    private static <T> T ensureMockIsAssignableToMockedType(MockCreationSettings<T> mockCreationSettings, T t6) {
        return mockCreationSettings.getTypeToMock().cast(t6);
    }

    private <T> RuntimeException prettifyFailure(MockCreationSettings<T> mockCreationSettings, Exception exc) {
        if (mockCreationSettings.getTypeToMock().isArray()) {
            throw new MockitoException(StringUtil.join("Mockito cannot mock arrays: " + mockCreationSettings.getTypeToMock() + ".", ""), exc);
        }
        if (Modifier.isPrivate(mockCreationSettings.getTypeToMock().getModifiers())) {
            throw new MockitoException(StringUtil.join("Mockito cannot mock this class: " + mockCreationSettings.getTypeToMock() + ".", "Most likely it is due to mocking a private class that is not visible to Mockito", ""), exc);
        }
        throw new MockitoException(StringUtil.join("Mockito cannot mock this class: " + mockCreationSettings.getTypeToMock() + ".", "", "Mockito can only mock non-private & non-final classes, but the root cause of this error might be different.", "Please check the full stacktrace to understand what the issue is.", "If you're still not sure why you're getting this error, please open an issue on GitHub.", "", Platform.warnForVM("IBM J9 VM", "Early IBM virtual machine are known to have issues with Mockito, please upgrade to an up-to-date version.\n", "Hotspot", Platform.isJava8BelowUpdate45() ? "Java 8 early builds have bugs that were addressed in Java 1.8.0_45, please update your JDK!\n" : ""), Platform.describe(), "", "Underlying exception : " + exc), exc);
    }

    @Override // org.mockito.plugins.MockMaker
    public void clearAllCaches() {
        this.cachingMockBytecodeGenerator.clearAllCaches();
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        ClassCastException classCastException;
        Object objNewInstance;
        Class<? extends T> clsCreateMockType = createMockType(mockCreationSettings);
        Instantiator instantiator = Plugins.getInstantiatorProvider().getInstantiator(mockCreationSettings);
        try {
            try {
                objNewInstance = instantiator.newInstance(clsCreateMockType);
                try {
                    ((MockAccess) objNewInstance).setMockitoInterceptor(new MockMethodInterceptor(mockHandler, mockCreationSettings));
                    return (T) ensureMockIsAssignableToMockedType(mockCreationSettings, objNewInstance);
                } catch (ClassCastException e) {
                    classCastException = e;
                    throw new MockitoException(StringUtil.join("ClassCastException occurred while creating the mockito mock :", "  class to mock : " + describeClass((Class<?>) mockCreationSettings.getTypeToMock()), "  created class : " + describeClass((Class<?>) clsCreateMockType), "  proxy instance class : " + describeClass(objNewInstance), "  instance creation by : ".concat(instantiator.getClass().getSimpleName()), "", "You might experience classloading issues, please ask the mockito mailing-list.", ""), classCastException);
                }
            } catch (ClassCastException e6) {
                classCastException = e6;
                objNewInstance = null;
            }
        } catch (InstantiationException e7) {
            throw new MockitoException("Unable to create mock instance of type '" + clsCreateMockType.getSuperclass().getSimpleName() + "'", e7);
        }
    }

    @Override // org.mockito.internal.creation.bytebuddy.ClassCreatingMockMaker
    public <T> Class<? extends T> createMockType(MockCreationSettings<T> mockCreationSettings) {
        try {
            return this.cachingMockBytecodeGenerator.mockClass(MockFeatures.withMockFeatures(mockCreationSettings.getTypeToMock(), mockCreationSettings.getExtraInterfaces(), mockCreationSettings.getSerializableMode(), mockCreationSettings.isStripAnnotations(), mockCreationSettings.getDefaultAnswer()));
        } catch (Exception e) {
            throw prettifyFailure(mockCreationSettings, e);
        }
    }

    @Override // org.mockito.plugins.MockMaker
    public MockHandler getHandler(Object obj) {
        if (obj instanceof MockAccess) {
            return ((MockAccess) obj).getMockitoInterceptor().getMockHandler();
        }
        return null;
    }

    @Override // org.mockito.plugins.MockMaker
    public MockMaker.TypeMockability isTypeMockable(final Class<?> cls) {
        return new MockMaker.TypeMockability() { // from class: org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.1
            @Override // org.mockito.plugins.MockMaker.TypeMockability
            public boolean mockable() {
                return (cls.isPrimitive() || Modifier.isFinal(cls.getModifiers()) || TypeSupport.INSTANCE.isSealed(cls)) ? false : true;
            }

            @Override // org.mockito.plugins.MockMaker.TypeMockability
            public String nonMockableReason() {
                return mockable() ? "" : cls.isPrimitive() ? "primitive type" : Modifier.isFinal(cls.getModifiers()) ? "final class" : TypeSupport.INSTANCE.isSealed(cls) ? "sealed class" : StringUtil.join("not handled type");
            }
        };
    }

    @Override // org.mockito.plugins.MockMaker
    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        ((MockAccess) obj).setMockitoInterceptor(new MockMethodInterceptor(mockHandler, mockCreationSettings));
    }

    public SubclassByteBuddyMockMaker(SubclassLoader subclassLoader) {
        this.cachingMockBytecodeGenerator = new TypeCachingBytecodeGenerator(new SubclassBytecodeGenerator(subclassLoader), false);
    }

    private static String describeClass(Object obj) {
        return obj == null ? "null" : describeClass(obj.getClass());
    }
}
