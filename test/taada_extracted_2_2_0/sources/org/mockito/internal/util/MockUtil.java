package org.mockito.internal.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.NotAMockException;
import org.mockito.internal.configuration.plugins.DefaultMockitoPlugins;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.creation.settings.CreationSettings;
import org.mockito.internal.handler.MockHandlerFactory;
import org.mockito.internal.stubbing.InvocationContainerImpl;
import org.mockito.internal.util.reflection.LenientCopyTool;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.mock.MockName;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockResolver;

/* JADX INFO: loaded from: classes.dex */
public class MockUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final MockMaker defaultMockMaker;
    private static final Map<Class<? extends MockMaker>, MockMaker> mockMakers;

    static {
        MockMaker mockMaker = Plugins.getMockMaker();
        defaultMockMaker = mockMaker;
        mockMakers = new ConcurrentHashMap(Collections.singletonMap(mockMaker.getClass(), mockMaker));
    }

    private MockUtil() {
    }

    public static boolean areSameMocks(Object obj, Object obj2) {
        return obj == obj2 || resolve(obj) == resolve(obj2);
    }

    public static void clearAllCaches() {
        Iterator<MockMaker> it = mockMakers.values().iterator();
        while (it.hasNext()) {
            it.next().clearAllCaches();
        }
    }

    public static <T> MockMaker.ConstructionMockControl<T> createConstructionMock(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, MockedConstruction.MockInitializer<T> mockInitializer) {
        return defaultMockMaker.createConstructionMock(cls, function, new org.mockito.internal.invocation.a(function, 1), mockInitializer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T createMock(final MockCreationSettings<T> mockCreationSettings) {
        final MockMaker mockMaker = getMockMaker(mockCreationSettings.getMockMaker());
        final MockHandler mockHandlerCreateMockHandler = MockHandlerFactory.createMockHandler(mockCreationSettings);
        final Object spiedInstance = mockCreationSettings.getSpiedInstance();
        return spiedInstance != null ? (T) mockMaker.createSpy(mockCreationSettings, mockHandlerCreateMockHandler, spiedInstance).orElseGet(new java.util.function.Supplier() { // from class: org.mockito.internal.util.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return MockUtil.lambda$createMock$1(mockMaker, mockCreationSettings, mockHandlerCreateMockHandler, spiedInstance);
            }
        }) : (T) mockMaker.createMock(mockCreationSettings, mockHandlerCreateMockHandler);
    }

    public static <T> MockMaker.StaticMockControl<T> createStaticMock(Class<T> cls, MockCreationSettings<T> mockCreationSettings) {
        return getMockMaker(mockCreationSettings.getMockMaker()).createStaticMock(cls, mockCreationSettings, MockHandlerFactory.createMockHandler(mockCreationSettings));
    }

    public static InvocationContainerImpl getInvocationContainer(Object obj) {
        return (InvocationContainerImpl) getMockHandler(obj).getInvocationContainer();
    }

    public static MockHandler<?> getMockHandler(Object obj) {
        MockHandler<?> mockHandlerOrNull = getMockHandlerOrNull(obj);
        if (mockHandlerOrNull != null) {
            return mockHandlerOrNull;
        }
        throw new NotAMockException("Argument should be a mock, but is: " + obj.getClass());
    }

    private static MockHandler<?> getMockHandlerOrNull(Object obj) {
        if (obj == null) {
            throw new NotAMockException("Argument should be a mock, but is null!");
        }
        Object objResolve = resolve(obj);
        Iterator<MockMaker> it = mockMakers.values().iterator();
        while (it.hasNext()) {
            MockHandler<?> handler = it.next().getHandler(objResolve);
            if (handler != null) {
                return handler;
            }
        }
        return null;
    }

    private static MockMaker getMockMaker(String str) {
        if (str == null) {
            return defaultMockMaker;
        }
        String defaultPluginClass = DefaultMockitoPlugins.MOCK_MAKER_ALIASES.contains(str) ? DefaultMockitoPlugins.getDefaultPluginClass(str) : str;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassLoader.getSystemClassLoader();
        }
        try {
            return mockMakers.computeIfAbsent((Class<? extends MockMaker>) contextClassLoader.loadClass(defaultPluginClass).asSubclass(MockMaker.class), new o5.a(4));
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load MockMaker: ".concat(str), e);
        }
    }

    public static MockName getMockName(Object obj) {
        return getMockHandler(obj).getMockSettings().getMockName();
    }

    public static MockCreationSettings getMockSettings(Object obj) {
        return getMockHandler(obj).getMockSettings();
    }

    public static boolean isMock(Object obj) {
        return (obj == null || getMockHandlerOrNull(obj) == null) ? false : true;
    }

    public static boolean isSpy(Object obj) {
        return isMock(obj) && getMockSettings(obj).getDefaultAnswer() == Mockito.CALLS_REAL_METHODS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MockHandler lambda$createConstructionMock$2(Function function, MockedConstruction.Context context) {
        return MockHandlerFactory.createMockHandler((MockCreationSettings) function.apply(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createMock$1(MockMaker mockMaker, MockCreationSettings mockCreationSettings, MockHandler mockHandler, Object obj) {
        Object objCreateMock = mockMaker.createMock(mockCreationSettings, mockHandler);
        new LenientCopyTool().copyToMock(obj, objCreateMock);
        return objCreateMock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MockMaker lambda$getMockMaker$0(Class cls) {
        try {
            return (MockMaker) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to construct MockMaker: ".concat(cls.getName()), e);
        }
    }

    public static void maybeRedefineMockName(Object obj, String str) {
        MockName mockName = getMockName(obj);
        MockCreationSettings<?> mockSettings = getMockHandler(obj).getMockSettings();
        if (mockName.isDefault() && (mockSettings instanceof CreationSettings)) {
            ((CreationSettings) mockSettings).setMockName(new MockNameImpl(str));
        }
    }

    public static void resetMock(Object obj) {
        MockCreationSettings<?> mockSettings = getMockHandler(obj).getMockSettings();
        MockHandler mockHandlerCreateMockHandler = MockHandlerFactory.createMockHandler(mockSettings);
        getMockMaker(mockSettings.getMockMaker()).resetMock(resolve(obj), mockHandlerCreateMockHandler, mockSettings);
    }

    private static Object resolve(Object obj) {
        if (obj instanceof Class) {
            return obj;
        }
        Iterator<MockResolver> it = Plugins.getMockResolvers().iterator();
        while (it.hasNext()) {
            obj = it.next().resolve(obj);
        }
        return obj;
    }

    public static MockMaker.TypeMockability typeMockabilityOf(Class<?> cls, String str) {
        return getMockMaker(str).isTypeMockable(cls);
    }
}
