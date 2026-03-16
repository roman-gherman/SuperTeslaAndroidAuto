package org.mockito.internal.creation.bytebuddy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import net.bytebuddy.agent.ByteBuddyAgent;
import org.mockito.MockedConstruction;
import org.mockito.creation.instance.InstantiationException;
import org.mockito.creation.instance.Instantiator;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.exceptions.base.MockitoInitializationException;
import org.mockito.exceptions.misusing.MockitoConfigurationException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.creation.instance.ConstructorInstantiator;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;
import org.mockito.internal.util.concurrent.DetachedThreadLocal;
import org.mockito.internal.util.concurrent.WeakConcurrentMap;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.InlineMockMaker;
import org.mockito.plugins.MemberAccessor;
import org.mockito.plugins.MockMaker;

/* JADX INFO: loaded from: classes.dex */
class InlineDelegateByteBuddyMockMaker implements ClassCreatingMockMaker, InlineMockMaker, Instantiator {
    private static final Throwable INITIALIZATION_ERROR;
    private static final Instrumentation INSTRUMENTATION;
    private final BytecodeGenerator bytecodeGenerator;
    private final ThreadLocal<Object> currentSpied;
    private final DetachedThreadLocal<Map<Class<?>, BiConsumer<Object, MockedConstruction.Context>>> mockedConstruction;
    private final DetachedThreadLocal<Map<Class<?>, MockMethodInterceptor>> mockedStatics;
    private final ThreadLocal<Boolean> mockitoConstruction;
    private final WeakConcurrentMap<Object, MockMethodInterceptor> mocks;

    public static class InlineConstructionMockContext implements MockedConstruction.Context {
        private static final Map<String, Class<?>> PRIMITIVES;
        private final Object[] arguments;
        private int count;
        private final String[] parameterTypeNames;
        private final Class<?> type;

        static {
            HashMap map = new HashMap();
            PRIMITIVES = map;
            Class cls = Boolean.TYPE;
            map.put(cls.getName(), cls);
            Class cls2 = Byte.TYPE;
            map.put(cls2.getName(), cls2);
            Class cls3 = Short.TYPE;
            map.put(cls3.getName(), cls3);
            Class cls4 = Character.TYPE;
            map.put(cls4.getName(), cls4);
            Class cls5 = Integer.TYPE;
            map.put(cls5.getName(), cls5);
            Class cls6 = Long.TYPE;
            map.put(cls6.getName(), cls6);
            Class cls7 = Float.TYPE;
            map.put(cls7.getName(), cls7);
            Class cls8 = Double.TYPE;
            map.put(cls8.getName(), cls8);
        }

        @Override // org.mockito.MockedConstruction.Context
        public List<?> arguments() {
            return Collections.unmodifiableList(Arrays.asList(this.arguments));
        }

        @Override // org.mockito.MockedConstruction.Context
        public Constructor<?> constructor() {
            String[] strArr = this.parameterTypeNames;
            Class<?>[] clsArr = new Class[strArr.length];
            int i = 0;
            for (String str : strArr) {
                Map<String, Class<?>> map = PRIMITIVES;
                if (map.containsKey(str)) {
                    clsArr[i] = map.get(str);
                    i++;
                } else {
                    int i3 = i + 1;
                    try {
                        clsArr[i] = Class.forName(str, false, this.type.getClassLoader());
                        i = i3;
                    } catch (ClassNotFoundException e) {
                        throw new MockitoException(androidx.constraintlayout.core.motion.a.p("Could not find parameter of type ", str), e);
                    }
                }
            }
            try {
                return this.type.getDeclaredConstructor(clsArr);
            } catch (NoSuchMethodException e6) {
                throw new MockitoException(StringUtil.join("Could not resolve constructor of type", "", this.type.getName(), "", "with arguments of types", Arrays.toString(clsArr)), e6);
            }
        }

        @Override // org.mockito.MockedConstruction.Context
        public int getCount() {
            int i = this.count;
            if (i != 0) {
                return i;
            }
            throw new MockitoConfigurationException("mocked construction context is not initialized");
        }

        private InlineConstructionMockContext(Object[] objArr, Class<?> cls, String[] strArr) {
            this.arguments = objArr;
            this.type = cls;
            this.parameterTypeNames = strArr;
        }
    }

    public class InlineConstructionMockControl<T> implements MockMaker.ConstructionMockControl<T> {
        private final List<Object> all;
        private int count;
        private final Function<MockedConstruction.Context, MockHandler<T>> handlerFactory;
        private final Map<Class<?>, BiConsumer<Object, MockedConstruction.Context>> interceptors;
        private final MockedConstruction.MockInitializer<T> mockInitializer;
        private final Function<MockedConstruction.Context, MockCreationSettings<T>> settingsFactory;
        private final Class<T> type;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$enable$0(Object obj, MockedConstruction.Context context) {
            int i = this.count + 1;
            this.count = i;
            ((InlineConstructionMockContext) context).count = i;
            InlineDelegateByteBuddyMockMaker.this.mocks.put(obj, new MockMethodInterceptor(this.handlerFactory.apply(context), this.settingsFactory.apply(context)));
            try {
                this.mockInitializer.prepare(obj, context);
                this.all.add(obj);
            } catch (Throwable th) {
                InlineDelegateByteBuddyMockMaker.this.mocks.remove(obj);
                throw new MockitoException("Could not initialize mocked construction", th);
            }
        }

        @Override // org.mockito.plugins.MockMaker.ConstructionMockControl
        public void disable() {
            if (this.interceptors.remove(this.type) != null) {
                this.all.clear();
                return;
            }
            throw new MockitoException(StringUtil.join("Could not deregister " + this.type.getName() + " as a static mock since it is not currently registered", "", "To register a static mock, use Mockito.mockStatic(" + this.type.getSimpleName() + ".class)"));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.mockito.plugins.MockMaker.ConstructionMockControl
        public void enable() {
            if (this.interceptors.putIfAbsent((Class<?>) this.type, new BiConsumer() { // from class: org.mockito.internal.creation.bytebuddy.g
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f4444a.lambda$enable$0(obj, (MockedConstruction.Context) obj2);
                }
            }) == null) {
                return;
            }
            throw new MockitoException(StringUtil.join("For " + this.type.getName() + ", static mocking is already registered in the current thread", "", "To create a new mock, the existing static mock registration must be deregistered"));
        }

        @Override // org.mockito.plugins.MockMaker.ConstructionMockControl
        public List<T> getMocks() {
            return (List<T>) this.all;
        }

        @Override // org.mockito.plugins.MockMaker.ConstructionMockControl
        public Class<T> getType() {
            return this.type;
        }

        private InlineConstructionMockControl(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, Function<MockedConstruction.Context, MockHandler<T>> function2, MockedConstruction.MockInitializer<T> mockInitializer, Map<Class<?>, BiConsumer<Object, MockedConstruction.Context>> map) {
            this.all = new ArrayList();
            this.type = cls;
            this.settingsFactory = function;
            this.handlerFactory = function2;
            this.mockInitializer = mockInitializer;
            this.interceptors = map;
        }
    }

    public static class InlineStaticMockControl<T> implements MockMaker.StaticMockControl<T> {
        private final MockHandler handler;
        private final Map<Class<?>, MockMethodInterceptor> interceptors;
        private final MockCreationSettings<T> settings;
        private final Class<T> type;

        @Override // org.mockito.plugins.MockMaker.StaticMockControl
        public void disable() {
            if (this.interceptors.remove(this.type) != null) {
                return;
            }
            throw new MockitoException(StringUtil.join("Could not deregister " + this.type.getName() + " as a static mock since it is not currently registered", "", "To register a static mock, use Mockito.mockStatic(" + this.type.getSimpleName() + ".class)"));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.mockito.plugins.MockMaker.StaticMockControl
        public void enable() {
            if (this.interceptors.putIfAbsent((Class<?>) this.type, new MockMethodInterceptor(this.handler, this.settings)) == null) {
                return;
            }
            throw new MockitoException(StringUtil.join("For " + this.type.getName() + ", static mocking is already registered in the current thread", "", "To create a new mock, the existing static mock registration must be deregistered"));
        }

        @Override // org.mockito.plugins.MockMaker.StaticMockControl
        public Class<T> getType() {
            return this.type;
        }

        private InlineStaticMockControl(Class<T> cls, Map<Class<?>, MockMethodInterceptor> map, MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
            this.type = cls;
            this.interceptors = map;
            this.settings = mockCreationSettings;
            this.handler = mockHandler;
        }
    }

    static {
        Instrumentation instrumentationInstall;
        Instrumentation instrumentation = null;
        try {
            try {
                instrumentationInstall = ByteBuddyAgent.install();
            } catch (Throwable th) {
                th = th;
            }
            if (!instrumentationInstall.isRetransformClassesSupported()) {
                throw new IllegalStateException(StringUtil.join("Byte Buddy requires retransformation for creating inline mocks. This feature is unavailable on the current VM.", "", "You cannot use this mock maker on this VM"));
            }
            File fileCreateTempFile = File.createTempFile("mockitoboot", ".jar");
            fileCreateTempFile.deleteOnExit();
            JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(fileCreateTempFile));
            try {
                InputStream resourceAsStream = InlineDelegateByteBuddyMockMaker.class.getClassLoader().getResourceAsStream("org/mockito/internal/creation/bytebuddy/inject/MockMethodDispatcher.raw");
                if (resourceAsStream == null) {
                    throw new IllegalStateException(StringUtil.join("The MockMethodDispatcher class file is not locatable: org/mockito/internal/creation/bytebuddy/inject/MockMethodDispatcher.raw", "", "The class loader responsible for looking up the resource: " + InlineDelegateByteBuddyMockMaker.class.getClassLoader()));
                }
                jarOutputStream.putNextEntry(new JarEntry("org/mockito/internal/creation/bytebuddy/inject/MockMethodDispatcher.class"));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = resourceAsStream.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            jarOutputStream.write(bArr, 0, i);
                        }
                    }
                    resourceAsStream.close();
                    jarOutputStream.closeEntry();
                    jarOutputStream.close();
                    JarFile jarFile = new JarFile(fileCreateTempFile);
                    try {
                        instrumentationInstall.appendToBootstrapClassLoaderSearch(jarFile);
                        jarFile.close();
                        try {
                            Class.forName("org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher", false, null);
                            th = null;
                            instrumentation = instrumentationInstall;
                            INSTRUMENTATION = instrumentation;
                            INITIALIZATION_ERROR = th;
                        } catch (ClassNotFoundException e) {
                            throw new IllegalStateException(StringUtil.join("Mockito failed to inject the MockMethodDispatcher class into the bootstrap class loader", "", "It seems like your current VM does not support the instrumentation API correctly."), e);
                        }
                    } catch (Throwable th2) {
                        try {
                            jarFile.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    resourceAsStream.close();
                    throw th4;
                }
            } catch (Throwable th5) {
                jarOutputStream.close();
                throw th5;
            }
        } catch (IOException e6) {
            throw new IllegalStateException(StringUtil.join("Mockito could not self-attach a Java agent to the current VM. This feature is required for inline mocking.", "This error occured due to an I/O error during the creation of this agent: " + e6, "", "Potentially, the current VM does not support the instrumentation API correctly"), e6);
        }
    }

    public InlineDelegateByteBuddyMockMaker() {
        String strJoin;
        final int i = 1;
        final int i3 = 0;
        WeakConcurrentMap<Object, MockMethodInterceptor> weakConcurrentMap = new WeakConcurrentMap<>(false);
        this.mocks = weakConcurrentMap;
        DetachedThreadLocal.Cleaner cleaner = DetachedThreadLocal.Cleaner.MANUAL;
        DetachedThreadLocal<Map<Class<?>, MockMethodInterceptor>> detachedThreadLocal = new DetachedThreadLocal<>(cleaner);
        this.mockedStatics = detachedThreadLocal;
        this.mockedConstruction = new DetachedThreadLocal<>(cleaner);
        this.mockitoConstruction = ThreadLocal.withInitial(new Supplier() { // from class: org.mockito.internal.creation.bytebuddy.c
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i3) {
                }
                return Boolean.FALSE;
            }
        });
        this.currentSpied = new ThreadLocal<>();
        Throwable th = INITIALIZATION_ERROR;
        if (th != null) {
            if (System.getProperty("java.specification.vendor", "").toLowerCase().contains("android")) {
                strJoin = "It appears as if you are trying to run this mock maker on Android which does not support the instrumentation API.";
            } else {
                try {
                    strJoin = ((th instanceof NoClassDefFoundError) && th.getMessage() != null && th.getMessage().startsWith("net/bytebuddy/agent/")) ? StringUtil.join("It seems like you are running Mockito with an incomplete or inconsistent class path. Byte Buddy Agent could not be loaded.", "", "Byte Buddy Agent is available on Maven Central as 'net.bytebuddy:byte-buddy-agent' with the module name 'net.bytebuddy.agent'.", "Normally, your IDE or build tool (such as Maven or Gradle) should take care of your class path completion but ") : Class.forName("javax.tools.ToolProvider").getMethod("getSystemJavaCompiler", new Class[0]).invoke(null, new Object[0]) == null ? "It appears as if you are running on a JRE. Either install a JDK or add JNA to the class path." : "It appears as if your JDK does not supply a working agent attachment mechanism.";
                } catch (Throwable unused) {
                    strJoin = "It appears as if you are running an incomplete JVM installation that might not support all tooling APIs";
                }
            }
            throw new MockitoInitializationException(StringUtil.join("Could not initialize inline Byte Buddy mock maker.", "", strJoin, Platform.describe()), INITIALIZATION_ERROR);
        }
        final ThreadLocal threadLocal = new ThreadLocal();
        final ThreadLocal threadLocalWithInitial = ThreadLocal.withInitial(new Supplier() { // from class: org.mockito.internal.creation.bytebuddy.c
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i) {
                }
                return Boolean.FALSE;
            }
        });
        final Predicate<Class<?>> predicateOrFallback = StackWalkerChecker.orFallback();
        this.bytecodeGenerator = new TypeCachingBytecodeGenerator(new InlineBytecodeGenerator(INSTRUMENTATION, weakConcurrentMap, detachedThreadLocal, new Predicate() { // from class: org.mockito.internal.creation.bytebuddy.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                InlineDelegateByteBuddyMockMaker inlineDelegateByteBuddyMockMaker = this.f4441a;
                ThreadLocal threadLocal2 = threadLocal;
                return inlineDelegateByteBuddyMockMaker.lambda$new$2(threadLocalWithInitial, threadLocal2, predicateOrFallback, (Class) obj);
            }
        }, new ConstructionCallback() { // from class: org.mockito.internal.creation.bytebuddy.e
            @Override // org.mockito.internal.creation.bytebuddy.ConstructionCallback
            public final Object apply(Class cls, Object obj, Object[] objArr, String[] strArr) {
                return this.f4442a.lambda$new$3(threadLocalWithInitial, threadLocal, cls, obj, objArr, strArr);
            }
        }), true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private <T> T doCreateMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler, boolean z6) {
        MockAccess mockAccess;
        Class<? extends T> clsCreateMockType = createMockType(mockCreationSettings);
        try {
            if (mockCreationSettings.isUsingConstructor()) {
                mockAccess = (T) new ConstructorInstantiator(mockCreationSettings.getOuterClassInstance() != null, mockCreationSettings.getConstructorArgs()).newInstance(clsCreateMockType);
            } else {
                try {
                    mockAccess = (T) newInstance(clsCreateMockType);
                } catch (InstantiationException unused) {
                    if (z6) {
                        return null;
                    }
                    mockAccess = (T) Plugins.getInstantiatorProvider().getInstantiator(mockCreationSettings).newInstance(clsCreateMockType);
                }
            }
            MockMethodInterceptor mockMethodInterceptor = new MockMethodInterceptor(mockHandler, mockCreationSettings);
            this.mocks.put(mockAccess, mockMethodInterceptor);
            if (mockAccess instanceof MockAccess) {
                mockAccess.setMockitoInterceptor(mockMethodInterceptor);
            }
            this.mocks.expungeStaleEntries();
            return (T) mockAccess;
        } catch (InstantiationException e) {
            throw new MockitoException("Unable to create mock instance of type '" + clsCreateMockType.getSimpleName() + "'", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$2(ThreadLocal threadLocal, ThreadLocal threadLocal2, Predicate predicate, Class cls) {
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return false;
        }
        if (this.mockitoConstruction.get().booleanValue() || threadLocal2.get() != null) {
            return true;
        }
        Map<Class<?>, BiConsumer<Object, MockedConstruction.Context>> map = this.mockedConstruction.get();
        if (map == null || !map.containsKey(cls) || predicate.test(cls)) {
            return false;
        }
        threadLocal2.set(cls);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object lambda$new$3(ThreadLocal threadLocal, ThreadLocal threadLocal2, Class cls, Object obj, Object[] objArr, String[] strArr) {
        BiConsumer<Object, MockedConstruction.Context> biConsumer;
        Object[] objArr2 = 0;
        if (!this.mockitoConstruction.get().booleanValue()) {
            if (threadLocal2.get() != cls) {
                return null;
            }
            threadLocal2.remove();
            threadLocal.set(Boolean.TRUE);
            try {
                Map<Class<?>, BiConsumer<Object, MockedConstruction.Context>> map = this.mockedConstruction.get();
                if (map != null && (biConsumer = map.get(cls)) != null) {
                    biConsumer.accept(obj, new InlineConstructionMockContext(objArr, obj.getClass(), strArr));
                }
                return null;
            } finally {
                threadLocal.set(Boolean.FALSE);
            }
        }
        Object obj2 = this.currentSpied.get();
        if (obj2 == null) {
            return null;
        }
        if (cls.isInstance(obj2)) {
            return obj2;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            throw new MockitoException("Unexpected spy for " + cls.getName() + " on instance of " + obj.getClass().getName(), obj instanceof Throwable ? (Throwable) obj : null);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$newInstance$4(MemberAccessor.ConstructionDispatcher constructionDispatcher) {
        this.mockitoConstruction.set(Boolean.TRUE);
        try {
            return constructionDispatcher.newInstance();
        } finally {
            this.mockitoConstruction.set(Boolean.FALSE);
        }
    }

    private Object makeStandardArgument(Class<?> cls) {
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Character.TYPE) {
            return (char) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        return null;
    }

    private <T> RuntimeException prettifyFailure(MockCreationSettings<T> mockCreationSettings, Exception exc) {
        if (mockCreationSettings.getTypeToMock().isArray()) {
            throw new MockitoException(StringUtil.join("Arrays cannot be mocked: " + mockCreationSettings.getTypeToMock() + ".", ""), exc);
        }
        if (Modifier.isFinal(mockCreationSettings.getTypeToMock().getModifiers())) {
            throw new MockitoException(StringUtil.join("Mockito cannot mock this class: " + mockCreationSettings.getTypeToMock() + ".", "Can not mock final classes with the following settings :", " - explicit serialization (e.g. withSettings().serializable())", " - extra interfaces (e.g. withSettings().extraInterfaces(...))", "", "You are seeing this disclaimer because Mockito is configured to create inlined mocks.", "You can learn about inline mocks and their limitations under item #39 of the Mockito class javadoc.", "", "Underlying exception : " + exc), exc);
        }
        if (Modifier.isPrivate(mockCreationSettings.getTypeToMock().getModifiers())) {
            throw new MockitoException(StringUtil.join("Mockito cannot mock this class: " + mockCreationSettings.getTypeToMock() + ".", "Most likely it is a private class that is not visible by Mockito", "", "You are seeing this disclaimer because Mockito is configured to create inlined mocks.", "You can learn about inline mocks and their limitations under item #39 of the Mockito class javadoc.", ""), exc);
        }
        throw new MockitoException(StringUtil.join("Mockito cannot mock this class: " + mockCreationSettings.getTypeToMock() + ".", "", "If you're not sure why you're getting this error, please open an issue on GitHub.", "", Platform.warnForVM("IBM J9 VM", "Early IBM virtual machine are known to have issues with Mockito, please upgrade to an up-to-date version.\n", "Hotspot", Platform.isJava8BelowUpdate45() ? "Java 8 early builds have bugs that were addressed in Java 1.8.0_45, please update your JDK!\n" : ""), Platform.describe(), "", "You are seeing this disclaimer because Mockito is configured to create inlined mocks.", "You can learn about inline mocks and their limitations under item #39 of the Mockito class javadoc.", "", "Underlying exception : " + exc), exc);
    }

    @Override // org.mockito.plugins.MockMaker
    public void clearAllCaches() {
        clearAllMocks();
        this.bytecodeGenerator.clearAllCaches();
    }

    @Override // org.mockito.plugins.InlineMockMaker
    public void clearAllMocks() {
        this.mockedStatics.getBackingMap().clear();
        this.mocks.clear();
    }

    @Override // org.mockito.plugins.InlineMockMaker
    public void clearMock(Object obj) {
        if (!(obj instanceof Class)) {
            this.mocks.remove(obj);
            return;
        }
        Iterator<Map<Class<?>, MockMethodInterceptor>> it = this.mockedStatics.getBackingMap().target.values().iterator();
        while (it.hasNext()) {
            it.next().remove(obj);
        }
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> MockMaker.ConstructionMockControl<T> createConstructionMock(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, Function<MockedConstruction.Context, MockHandler<T>> function2, MockedConstruction.MockInitializer<T> mockInitializer) {
        if (cls == Object.class) {
            throw new MockitoException("It is not possible to mock construction of the Object class to avoid inference with default object constructor chains");
        }
        if (cls.isPrimitive() || Modifier.isAbstract(cls.getModifiers())) {
            throw new MockitoException("It is not possible to construct primitive types or abstract types: ".concat(cls.getName()));
        }
        this.bytecodeGenerator.mockClassConstruction(cls);
        Map<Class<?>, BiConsumer<Object, MockedConstruction.Context>> weakHashMap = this.mockedConstruction.get();
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap<>();
            this.mockedConstruction.set(weakHashMap);
        }
        Map<Class<?>, BiConsumer<Object, MockedConstruction.Context>> map = weakHashMap;
        this.mockedConstruction.getBackingMap().expungeStaleEntries();
        return new InlineConstructionMockControl(cls, function, function2, mockInitializer, map);
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return (T) doCreateMock(mockCreationSettings, mockHandler, false);
    }

    @Override // org.mockito.internal.creation.bytebuddy.ClassCreatingMockMaker
    public <T> Class<? extends T> createMockType(MockCreationSettings<T> mockCreationSettings) {
        try {
            return this.bytecodeGenerator.mockClass(MockFeatures.withMockFeatures(mockCreationSettings.getTypeToMock(), mockCreationSettings.getExtraInterfaces(), mockCreationSettings.getSerializableMode(), mockCreationSettings.isStripAnnotations(), mockCreationSettings.getDefaultAnswer()));
        } catch (Exception e) {
            throw prettifyFailure(mockCreationSettings, e);
        }
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> Optional<T> createSpy(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler, T t6) {
        if (t6 == null) {
            throw new MockitoConfigurationException("Spy instance must not be null");
        }
        this.currentSpied.set(t6);
        try {
            return Optional.ofNullable(doCreateMock(mockCreationSettings, mockHandler, true));
        } finally {
            this.currentSpied.remove();
        }
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> MockMaker.StaticMockControl<T> createStaticMock(Class<T> cls, MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        if (cls == ConcurrentHashMap.class) {
            throw new MockitoException("It is not possible to mock static methods of ConcurrentHashMap to avoid infinitive loops within Mockito's implementation of static mock handling");
        }
        if (cls == Thread.class || cls == System.class || cls == Arrays.class || ClassLoader.class.isAssignableFrom(cls)) {
            throw new MockitoException("It is not possible to mock static methods of " + cls.getName() + " to avoid interfering with class loading what leads to infinite loops");
        }
        this.bytecodeGenerator.mockClassStatic(cls);
        Map<Class<?>, MockMethodInterceptor> weakHashMap = this.mockedStatics.get();
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap<>();
            this.mockedStatics.set(weakHashMap);
        }
        Map<Class<?>, MockMethodInterceptor> map = weakHashMap;
        this.mockedStatics.getBackingMap().expungeStaleEntries();
        return new InlineStaticMockControl(cls, map, mockCreationSettings, mockHandler);
    }

    @Override // org.mockito.plugins.MockMaker
    public MockHandler getHandler(Object obj) {
        MockMethodInterceptor mockMethodInterceptor;
        if (obj instanceof Class) {
            Map<Class<?>, MockMethodInterceptor> map = this.mockedStatics.get();
            mockMethodInterceptor = map != null ? map.get(obj) : null;
        } else {
            mockMethodInterceptor = this.mocks.get(obj);
        }
        if (mockMethodInterceptor == null) {
            return null;
        }
        return mockMethodInterceptor.handler;
    }

    @Override // org.mockito.plugins.MockMaker
    public MockMaker.TypeMockability isTypeMockable(final Class<?> cls) {
        return new MockMaker.TypeMockability() { // from class: org.mockito.internal.creation.bytebuddy.InlineDelegateByteBuddyMockMaker.1
            @Override // org.mockito.plugins.MockMaker.TypeMockability
            public boolean mockable() {
                return InlineDelegateByteBuddyMockMaker.INSTRUMENTATION.isModifiableClass(cls) && !InlineBytecodeGenerator.EXCLUDES.contains(cls);
            }

            @Override // org.mockito.plugins.MockMaker.TypeMockability
            public String nonMockableReason() {
                return mockable() ? "" : cls.isPrimitive() ? "primitive type" : InlineBytecodeGenerator.EXCLUDES.contains(cls) ? "Cannot mock wrapper types, String.class or Class.class" : "VM does not support modification of given type";
            }
        };
    }

    @Override // org.mockito.creation.instance.Instantiator
    public <T> T newInstance(Class<T> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors.length == 0) {
            throw new InstantiationException(cls.getName().concat(" does not define a constructor"));
        }
        int i = 0;
        Constructor<?> constructor = declaredConstructors[0];
        int length = declaredConstructors.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Constructor<?> constructor2 = declaredConstructors[i3];
            if (Modifier.isPublic(constructor2.getModifiers())) {
                constructor = constructor2;
                break;
            }
            i3++;
        }
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        int length2 = parameterTypes.length;
        int i4 = 0;
        while (i < length2) {
            objArr[i4] = makeStandardArgument(parameterTypes[i]);
            i++;
            i4++;
        }
        try {
            return (T) Plugins.getMemberAccessor().newInstance(constructor, new MemberAccessor.OnConstruction() { // from class: org.mockito.internal.creation.bytebuddy.f
                @Override // org.mockito.plugins.MemberAccessor.OnConstruction
                public final Object invoke(MemberAccessor.ConstructionDispatcher constructionDispatcher) {
                    return this.f4443a.lambda$newInstance$4(constructionDispatcher);
                }
            }, objArr);
        } catch (Exception e) {
            throw new InstantiationException("Could not instantiate ".concat(cls.getName()), e);
        }
    }

    @Override // org.mockito.plugins.MockMaker
    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        MockMethodInterceptor mockMethodInterceptor = new MockMethodInterceptor(mockHandler, mockCreationSettings);
        if (obj instanceof Class) {
            Map<Class<?>, MockMethodInterceptor> map = this.mockedStatics.get();
            if (map != null && map.containsKey(obj)) {
                map.put((Class) obj, mockMethodInterceptor);
                return;
            }
            throw new MockitoException("Cannot reset " + obj + " which is not currently registered as a static mock");
        }
        if (!this.mocks.containsKey(obj)) {
            throw new MockitoException("Cannot reset " + obj + " which is not currently registered as a mock");
        }
        this.mocks.put(obj, mockMethodInterceptor);
        if (obj instanceof MockAccess) {
            ((MockAccess) obj).setMockitoInterceptor(mockMethodInterceptor);
        }
        this.mocks.expungeStaleEntries();
    }
}
