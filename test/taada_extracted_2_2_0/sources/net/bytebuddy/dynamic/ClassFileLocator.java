package net.bytebuddy.dynamic;

import B2.b;
import androidx.constraintlayout.core.motion.a;
import com.android.multidex.ClassPathElement;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.StreamDrainer;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ClassFileLocator extends Closeable {
    public static final String CLASS_FILE_EXTENSION = ".class";

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements ClassFileLocator, Closeable {
        private final List<ClassFileLocator> classFileLocators;

        public Compound(ClassFileLocator... classFileLocatorArr) {
            this((List<? extends ClassFileLocator>) Arrays.asList(classFileLocatorArr));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Iterator<ClassFileLocator> it = this.classFileLocators.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileLocators.equals(((Compound) obj).classFileLocators);
        }

        public int hashCode() {
            return this.classFileLocators.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) {
            Iterator<ClassFileLocator> it = this.classFileLocators.iterator();
            while (it.hasNext()) {
                Resolution resolutionLocate = it.next().locate(str);
                if (resolutionLocate.isResolved()) {
                    return resolutionLocate;
                }
            }
            return new Resolution.Illegal(str);
        }

        public Compound(List<? extends ClassFileLocator> list) {
            this.classFileLocators = new ArrayList();
            for (ClassFileLocator classFileLocator : list) {
                if (classFileLocator instanceof Compound) {
                    this.classFileLocators.addAll(((Compound) classFileLocator).classFileLocators);
                } else if (!(classFileLocator instanceof NoOp)) {
                    this.classFileLocators.add(classFileLocator);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForClassLoader implements ClassFileLocator {
        private static final boolean ACCESS_CONTROLLER;
        private static final ClassLoader BOOT_LOADER_PROXY;
        private final ClassLoader classLoader;

        public enum BootLoaderProxyCreationAction implements PrivilegedAction<ClassLoader> {
            INSTANCE;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return new URLClassLoader(new URL[0], ClassLoadingStrategy.BOOTSTRAP_LOADER);
            }
        }

        public static class WeaklyReferenced extends WeakReference<ClassLoader> implements ClassFileLocator {
            private final int hashCode;

            public WeaklyReferenced(ClassLoader classLoader) {
                super(classLoader);
                this.hashCode = System.identityHashCode(classLoader);
            }

            public static ClassFileLocator of(@MaybeNull ClassLoader classLoader) {
                return (classLoader == null || classLoader == ClassLoader.getSystemClassLoader() || classLoader == ClassLoader.getSystemClassLoader().getParent()) ? ForClassLoader.of(classLoader) : new WeaklyReferenced(classLoader);
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public boolean equals(@MaybeNull Object obj) {
                ClassLoader classLoader;
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && (classLoader = ((WeaklyReferenced) obj).get()) != null && get() == classLoader;
            }

            public int hashCode() {
                return this.hashCode;
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator
            public Resolution locate(String str) {
                ClassLoader classLoader = get();
                return classLoader == null ? new Resolution.Illegal(str) : ForClassLoader.locate(classLoader, str);
            }
        }

        static {
            boolean z6 = false;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z6;
            } catch (SecurityException unused2) {
                z6 = true;
                ACCESS_CONTROLLER = z6;
            }
            BOOT_LOADER_PROXY = (ClassLoader) doPrivileged(BootLoaderProxyCreationAction.INSTANCE);
        }

        public ForClassLoader(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static ClassFileLocator of(@MaybeNull ClassLoader classLoader) {
            if (classLoader == null) {
                classLoader = BOOT_LOADER_PROXY;
            }
            return new ForClassLoader(classLoader);
        }

        public static ClassFileLocator ofBootLoader() {
            return new ForClassLoader(BOOT_LOADER_PROXY);
        }

        public static ClassFileLocator ofPlatformLoader() {
            return of(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassFileLocator ofSystemLoader() {
            return new ForClassLoader(ClassLoader.getSystemClassLoader());
        }

        public static byte[] read(Class<?> cls) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = BOOT_LOADER_PROXY;
                }
                return locate(classLoader, TypeDescription.ForLoadedType.getName(cls)).resolve();
            } catch (IOException e) {
                throw new IllegalStateException(a.j(cls, "Cannot read class file for "), e);
            }
        }

        public static Map<String, byte[]> readToNames(Class<?>... clsArr) {
            return readToNames(Arrays.asList(clsArr));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((ForClassLoader) obj).classLoader);
        }

        public int hashCode() {
            return this.classLoader.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) {
            return locate(this.classLoader, str);
        }

        public static Resolution locate(ClassLoader classLoader, String str) throws IOException {
            InputStream resourceAsStream = classLoader.getResourceAsStream(str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + ".class");
            if (resourceAsStream == null) {
                return new Resolution.Illegal(str);
            }
            try {
                return new Resolution.Explicit(StreamDrainer.DEFAULT.drain(resourceAsStream));
            } finally {
                resourceAsStream.close();
            }
        }

        public static Map<String, byte[]> readToNames(Collection<? extends Class<?>> collection) {
            HashMap map = new HashMap();
            for (Class<?> cls : collection) {
                map.put(cls.getName(), read(cls));
            }
            return map;
        }

        public static Map<Class<?>, byte[]> read(Class<?>... clsArr) {
            return read(Arrays.asList(clsArr));
        }

        public static Map<Class<?>, byte[]> read(Collection<? extends Class<?>> collection) {
            HashMap map = new HashMap();
            for (Class<?> cls : collection) {
                map.put(cls, read(cls));
            }
            return map;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForFolder implements ClassFileLocator {
        private final File folder;

        public ForFolder(File file) {
            this.folder = file;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.folder.equals(((ForFolder) obj).folder);
        }

        public int hashCode() {
            return this.folder.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) throws IOException {
            File file = new File(this.folder, str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, File.separatorChar) + ".class");
            if (!file.exists()) {
                return new Resolution.Illegal(str);
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return new Resolution.Explicit(StreamDrainer.DEFAULT.drain(fileInputStream));
            } finally {
                fileInputStream.close();
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForInstrumentation implements ClassFileLocator {
        private static final boolean ACCESS_CONTROLLER;
        private static final Dispatcher DISPATCHER;
        private final ClassLoadingDelegate classLoadingDelegate;
        private final Instrumentation instrumentation;

        public interface ClassLoadingDelegate {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Default implements ClassLoadingDelegate {
                private static final ClassLoader BOOT_LOADER_PROXY = (ClassLoader) ForInstrumentation.doPrivileged(BootLoaderProxyCreationAction.INSTANCE);
                protected final ClassLoader classLoader;

                public enum BootLoaderProxyCreationAction implements PrivilegedAction<ClassLoader> {
                    INSTANCE;

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.security.PrivilegedAction
                    public ClassLoader run() {
                        return new URLClassLoader(new URL[0], ClassLoadingStrategy.BOOTSTRAP_LOADER);
                    }
                }

                public Default(ClassLoader classLoader) {
                    this.classLoader = classLoader;
                }

                public static ClassLoadingDelegate of(@MaybeNull ClassLoader classLoader) {
                    if (ForDelegatingClassLoader.isDelegating(classLoader)) {
                        return new ForDelegatingClassLoader(classLoader);
                    }
                    if (classLoader == null) {
                        classLoader = BOOT_LOADER_PROXY;
                    }
                    return new Default(classLoader);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((Default) obj).classLoader);
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate
                @MaybeNull
                public ClassLoader getClassLoader() {
                    ClassLoader classLoader = this.classLoader;
                    return classLoader == BOOT_LOADER_PROXY ? ClassLoadingStrategy.BOOTSTRAP_LOADER : classLoader;
                }

                public int hashCode() {
                    return this.classLoader.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate
                public Class<?> locate(String str) {
                    return this.classLoader.loadClass(str);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Explicit implements ClassLoadingDelegate {
                private final ClassLoadingDelegate fallbackDelegate;
                private final Map<String, Class<?>> types;

                public Explicit(@MaybeNull ClassLoader classLoader, Collection<? extends Class<?>> collection) {
                    this(Default.of(classLoader), collection);
                }

                public static ClassLoadingDelegate of(Class<?> cls) {
                    return new Explicit(cls.getClassLoader(), Collections.singleton(cls));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Explicit explicit = (Explicit) obj;
                    return this.fallbackDelegate.equals(explicit.fallbackDelegate) && this.types.equals(explicit.types);
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate
                @MaybeNull
                public ClassLoader getClassLoader() {
                    return this.fallbackDelegate.getClassLoader();
                }

                public int hashCode() {
                    return this.types.hashCode() + ((this.fallbackDelegate.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate
                public Class<?> locate(String str) {
                    Class<?> cls = this.types.get(str);
                    return cls == null ? this.fallbackDelegate.locate(str) : cls;
                }

                public Explicit(ClassLoadingDelegate classLoadingDelegate, Collection<? extends Class<?>> collection) {
                    this.fallbackDelegate = classLoadingDelegate;
                    this.types = new HashMap();
                    for (Class<?> cls : collection) {
                        this.types.put(TypeDescription.ForLoadedType.getName(cls), cls);
                    }
                }
            }

            public static class ForDelegatingClassLoader extends Default {
                private static final boolean ACCESS_CONTROLLER;
                private static final String DELEGATING_CLASS_LOADER_NAME = "sun.reflect.DelegatingClassLoader";
                private static final Dispatcher.Initializable DISPATCHER;
                private static final int ONLY = 0;

                public interface Dispatcher {

                    public enum CreationAction implements PrivilegedAction<Initializable> {
                        INSTANCE;

                        @Override // java.security.PrivilegedAction
                        public Initializable run() {
                            try {
                                return new Resolved(ClassLoader.class.getDeclaredField("classes"));
                            } catch (Exception e) {
                                return new Unresolved(e.getMessage());
                            }
                        }
                    }

                    public interface Initializable {
                        Dispatcher initialize();
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Resolved implements Dispatcher, Initializable, PrivilegedAction<Dispatcher> {
                        private static final boolean ACCESS_CONTROLLER;
                        private final Field field;

                        static {
                            boolean z6 = false;
                            try {
                                Class.forName("java.security.AccessController", false, null);
                                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
                            } catch (ClassNotFoundException unused) {
                                ACCESS_CONTROLLER = z6;
                            } catch (SecurityException unused2) {
                                z6 = true;
                                ACCESS_CONTROLLER = z6;
                            }
                        }

                        public Resolved(Field field) {
                            this.field = field;
                        }

                        @AccessControllerPlugin.Enhance
                        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.field.equals(((Resolved) obj).field);
                        }

                        @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher
                        public Vector<Class<?>> extract(ClassLoader classLoader) {
                            try {
                                return (Vector) this.field.get(classLoader);
                            } catch (IllegalAccessException e) {
                                throw new IllegalStateException("Cannot access field", e);
                            }
                        }

                        public int hashCode() {
                            return this.field.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher.Initializable
                        public Dispatcher initialize() {
                            return (Dispatcher) doPrivileged(this);
                        }

                        @Override // java.security.PrivilegedAction
                        public Dispatcher run() {
                            this.field.setAccessible(true);
                            return this;
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Unresolved implements Initializable {
                        private final String message;

                        public Unresolved(String str) {
                            this.message = str;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.message.equals(((Unresolved) obj).message);
                        }

                        public int hashCode() {
                            return this.message.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.ForDelegatingClassLoader.Dispatcher.Initializable
                        public Dispatcher initialize() {
                            throw new UnsupportedOperationException("Could not locate classes vector: " + this.message);
                        }
                    }

                    Vector<Class<?>> extract(ClassLoader classLoader);
                }

                static {
                    boolean z6 = false;
                    try {
                        Class.forName("java.security.AccessController", false, null);
                        ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
                    } catch (ClassNotFoundException unused) {
                        ACCESS_CONTROLLER = z6;
                    } catch (SecurityException unused2) {
                        z6 = true;
                        ACCESS_CONTROLLER = z6;
                    }
                    DISPATCHER = (Dispatcher.Initializable) doPrivileged(Dispatcher.CreationAction.INSTANCE);
                }

                public ForDelegatingClassLoader(ClassLoader classLoader) {
                    super(classLoader);
                }

                @AccessControllerPlugin.Enhance
                private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                    return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
                }

                public static boolean isDelegating(@MaybeNull ClassLoader classLoader) {
                    return classLoader != null && classLoader.getClass().getName().equals(DELEGATING_CLASS_LOADER_NAME);
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate.Default, net.bytebuddy.dynamic.ClassFileLocator.ForInstrumentation.ClassLoadingDelegate
                public Class<?> locate(String str) {
                    try {
                        Vector<Class<?>> vectorExtract = DISPATCHER.initialize().extract(this.classLoader);
                        if (vectorExtract.size() != 1) {
                            return super.locate(str);
                        }
                        Class<?> cls = vectorExtract.get(0);
                        return TypeDescription.ForLoadedType.getName(cls).equals(str) ? cls : super.locate(str);
                    } catch (RuntimeException unused) {
                        return super.locate(str);
                    }
                }
            }

            @MaybeNull
            ClassLoader getClassLoader();

            Class<?> locate(String str);
        }

        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("addTransformer")
            void addTransformer(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, boolean z6);

            @JavaDispatcher.Proxied("isRetransformClassesSupported")
            boolean isRetransformClassesSupported(Instrumentation instrumentation);

            @JavaDispatcher.Proxied("retransformClasses")
            void retransformClasses(Instrumentation instrumentation, Class<?>[] clsArr);
        }

        public static class ExtractionClassFileTransformer implements ClassFileTransformer {

            @AlwaysNull
            private static final byte[] DO_NOT_TRANSFORM = null;

            @SuppressFBWarnings(justification = "The array is not to be modified by contract", value = {"VO_VOLATILE_REFERENCE_TO_ARRAY"})
            @MaybeNull
            private volatile byte[] binaryRepresentation;

            @MaybeNull
            private final ClassLoader classLoader;
            private final String typeName;

            public ExtractionClassFileTransformer(@MaybeNull ClassLoader classLoader, String str) {
                this.classLoader = classLoader;
                this.typeName = str;
            }

            @SuppressFBWarnings(justification = "The array is not to be modified by contract", value = {"EI_EXPOSE_REP"})
            @MaybeNull
            public byte[] getBinaryRepresentation() {
                return this.binaryRepresentation;
            }

            @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP", "EI_EXPOSE_REP2"})
            @MaybeNull
            public byte[] transform(@MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
                if (str != null && ElementMatchers.isChildOf(this.classLoader).matches(classLoader) && this.typeName.equals(str.replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH))) {
                    this.binaryRepresentation = (byte[]) bArr.clone();
                }
                return DO_NOT_TRANSFORM;
            }
        }

        static {
            boolean z6 = false;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z6;
            } catch (SecurityException unused2) {
                z6 = true;
                ACCESS_CONTROLLER = z6;
            }
            DISPATCHER = (Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class));
        }

        public ForInstrumentation(Instrumentation instrumentation, @MaybeNull ClassLoader classLoader) {
            this(instrumentation, ClassLoadingDelegate.Default.of(classLoader));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @AccessControllerPlugin.Enhance
        public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static ClassFileLocator fromInstalledAgent(@MaybeNull ClassLoader classLoader) {
            return new ForInstrumentation(resolveByteBuddyAgentInstrumentation(), classLoader);
        }

        public static ClassFileLocator of(Instrumentation instrumentation, Class<?> cls) {
            return new ForInstrumentation(instrumentation, ClassLoadingDelegate.Explicit.of(cls));
        }

        private static Instrumentation resolveByteBuddyAgentInstrumentation() {
            try {
                Class<?> clsLoadClass = ClassLoader.getSystemClassLoader().loadClass("net.bytebuddy.agent.Installer");
                JavaModule javaModuleOfType = JavaModule.ofType(AgentBuilder.class);
                JavaModule javaModuleOfType2 = JavaModule.ofType(clsLoadClass);
                if (javaModuleOfType != null && !javaModuleOfType.canRead(javaModuleOfType2)) {
                    Class<?> cls = Class.forName("java.lang.Module");
                    cls.getMethod("addReads", cls).invoke(javaModuleOfType.unwrap(), javaModuleOfType2.unwrap());
                }
                return (Instrumentation) clsLoadClass.getMethod("getInstrumentation", new Class[0]).invoke(null, new Object[0]);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e6) {
                throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", e6);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForInstrumentation forInstrumentation = (ForInstrumentation) obj;
            return this.instrumentation.equals(forInstrumentation.instrumentation) && this.classLoadingDelegate.equals(forInstrumentation.classLoadingDelegate);
        }

        public int hashCode() {
            return this.classLoadingDelegate.hashCode() + ((this.instrumentation.hashCode() + (getClass().hashCode() * 31)) * 31);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) {
            try {
                ExtractionClassFileTransformer extractionClassFileTransformer = new ExtractionClassFileTransformer(this.classLoadingDelegate.getClassLoader(), str);
                Dispatcher dispatcher = DISPATCHER;
                dispatcher.addTransformer(this.instrumentation, extractionClassFileTransformer, true);
                try {
                    dispatcher.retransformClasses(this.instrumentation, new Class[]{this.classLoadingDelegate.locate(str)});
                    byte[] binaryRepresentation = extractionClassFileTransformer.getBinaryRepresentation();
                    Resolution illegal = binaryRepresentation == null ? new Resolution.Illegal(str) : new Resolution.Explicit(binaryRepresentation);
                    this.instrumentation.removeTransformer(extractionClassFileTransformer);
                    return illegal;
                } catch (Throwable th) {
                    this.instrumentation.removeTransformer(extractionClassFileTransformer);
                    throw th;
                }
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
                return new Resolution.Illegal(str);
            }
        }

        public ForInstrumentation(Instrumentation instrumentation, ClassLoadingDelegate classLoadingDelegate) {
            if (DISPATCHER.isRetransformClassesSupported(instrumentation)) {
                this.instrumentation = instrumentation;
                this.classLoadingDelegate = classLoadingDelegate;
            } else {
                throw new IllegalArgumentException(instrumentation + " does not support retransformation");
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForJarFile implements ClassFileLocator {
        private static final List<String> RUNTIME_LOCATIONS = Arrays.asList("lib/rt.jar", "../lib/rt.jar", "../Classes/classes.jar");
        private final JarFile jarFile;

        public ForJarFile(JarFile jarFile) {
            this.jarFile = jarFile;
        }

        public static ClassFileLocator of(File file) {
            return new ForJarFile(new JarFile(file));
        }

        public static ClassFileLocator ofClassPath() {
            return ofClassPath(System.getProperty("java.class.path"));
        }

        public static ClassFileLocator ofRuntimeJar() {
            File file;
            String strReplace = System.getProperty("java.home").replace('\\', ClassPathElement.SEPARATOR_CHAR);
            Iterator<String> it = RUNTIME_LOCATIONS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    file = null;
                    break;
                }
                file = new File(strReplace, it.next());
                if (file.isFile()) {
                    break;
                }
            }
            if (file != null) {
                return of(file);
            }
            StringBuilder sbM = b.m("Runtime jar does not exist in ", strReplace, " for any of ");
            sbM.append(RUNTIME_LOCATIONS);
            throw new IllegalStateException(sbM.toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.jarFile.close();
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.jarFile.equals(((ForJarFile) obj).jarFile);
        }

        public int hashCode() {
            return this.jarFile.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) throws IOException {
            ZipEntry entry = this.jarFile.getEntry(str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + ".class");
            if (entry == null) {
                return new Resolution.Illegal(str);
            }
            InputStream inputStream = this.jarFile.getInputStream(entry);
            try {
                return new Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
            } finally {
                inputStream.close();
            }
        }

        public static ClassFileLocator ofClassPath(String str) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : Pattern.compile(System.getProperty("path.separator"), 16).split(str)) {
                File file = new File(str2);
                if (file.isDirectory()) {
                    arrayList.add(new ForFolder(file));
                } else if (file.isFile()) {
                    arrayList.add(of(file));
                }
            }
            return new Compound(arrayList);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForModule implements ClassFileLocator {
        private static final Object[] NO_ARGUMENT = new Object[0];
        private final JavaModule module;

        public static class WeaklyReferenced extends WeakReference<Object> implements ClassFileLocator {
            private final int hashCode;

            public WeaklyReferenced(Object obj) {
                super(obj);
                this.hashCode = System.identityHashCode(obj);
            }

            public static ClassFileLocator of(JavaModule javaModule) {
                return javaModule.isNamed() ? (javaModule.getClassLoader() == null || javaModule.getClassLoader() == ClassLoader.getSystemClassLoader() || javaModule.getClassLoader() == ClassLoader.getSystemClassLoader().getParent()) ? new ForModule(javaModule) : new WeaklyReferenced(javaModule.unwrap()) : ForClassLoader.WeaklyReferenced.of(javaModule.getClassLoader());
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public boolean equals(@MaybeNull Object obj) {
                Object obj2;
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && (obj2 = ((WeaklyReferenced) obj).get()) != null && get() == obj2;
            }

            public int hashCode() {
                return this.hashCode;
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator
            public Resolution locate(String str) {
                Object obj = get();
                return obj == null ? new Resolution.Illegal(str) : ForModule.locate(JavaModule.of(obj), str);
            }
        }

        public ForModule(JavaModule javaModule) {
            this.module = javaModule;
        }

        public static ClassFileLocator of(JavaModule javaModule) {
            return javaModule.isNamed() ? new ForModule(javaModule) : ForClassLoader.of(javaModule.getClassLoader());
        }

        @SuppressFBWarnings(justification = "Exception should always be wrapped for clarity", value = {"REC_CATCH_EXCEPTION"})
        public static ClassFileLocator ofBootLayer() {
            try {
                HashMap map = new HashMap();
                Class<?> cls = Class.forName("java.lang.ModuleLayer");
                Method method = JavaType.MODULE.load().getMethod("getPackages", new Class[0]);
                for (Object obj : (Set) cls.getMethod("modules", new Class[0]).invoke(cls.getMethod("boot", new Class[0]).invoke(null, new Object[0]), new Object[0])) {
                    ClassFileLocator classFileLocatorOf = of(JavaModule.of(obj));
                    Iterator it = ((Set) method.invoke(obj, NO_ARGUMENT)).iterator();
                    while (it.hasNext()) {
                        map.put((String) it.next(), classFileLocatorOf);
                    }
                }
                return new PackageDiscriminating(map);
            } catch (Exception e) {
                throw new IllegalStateException("Cannot process boot layer", e);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.module.equals(((ForModule) obj).module);
        }

        public int hashCode() {
            return this.module.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) {
            return locate(this.module, str);
        }

        public static Resolution locate(JavaModule javaModule, String str) throws IOException {
            InputStream resourceAsStream = javaModule.getResourceAsStream(str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + ".class");
            if (resourceAsStream == null) {
                return new Resolution.Illegal(str);
            }
            try {
                return new Resolution.Explicit(StreamDrainer.DEFAULT.drain(resourceAsStream));
            } finally {
                resourceAsStream.close();
            }
        }
    }

    public enum NoOp implements ClassFileLocator {
        INSTANCE;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) {
            return new Resolution.Illegal(str);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class PackageDiscriminating implements ClassFileLocator {
        private final Map<String, ClassFileLocator> classFileLocators;

        public PackageDiscriminating(Map<String, ClassFileLocator> map) {
            this.classFileLocators = map;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Iterator<ClassFileLocator> it = this.classFileLocators.values().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileLocators.equals(((PackageDiscriminating) obj).classFileLocators);
        }

        public int hashCode() {
            return this.classFileLocators.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) {
            int iLastIndexOf = str.lastIndexOf(46);
            ClassFileLocator classFileLocator = this.classFileLocators.get(iLastIndexOf == -1 ? "" : str.substring(0, iLastIndexOf));
            return classFileLocator == null ? new Resolution.Illegal(str) : classFileLocator.locate(str);
        }
    }

    public interface Resolution {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Explicit implements Resolution {
            private final byte[] binaryRepresentation;

            @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP2"})
            public Explicit(byte[] bArr) {
                this.binaryRepresentation = bArr;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && Arrays.equals(this.binaryRepresentation, ((Explicit) obj).binaryRepresentation);
            }

            public int hashCode() {
                return Arrays.hashCode(this.binaryRepresentation) + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator.Resolution
            public boolean isResolved() {
                return true;
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator.Resolution
            @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP"})
            public byte[] resolve() {
                return this.binaryRepresentation;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Illegal implements Resolution {
            private final String typeName;

            public Illegal(String str) {
                this.typeName = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeName.equals(((Illegal) obj).typeName);
            }

            public int hashCode() {
                return this.typeName.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator.Resolution
            public boolean isResolved() {
                return false;
            }

            @Override // net.bytebuddy.dynamic.ClassFileLocator.Resolution
            public byte[] resolve() {
                throw new IllegalStateException("Could not locate class file for " + this.typeName);
            }
        }

        boolean isResolved();

        byte[] resolve();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements ClassFileLocator {
        private final Map<String, byte[]> classFiles;

        public Simple(Map<String, byte[]> map) {
            this.classFiles = map;
        }

        public static ClassFileLocator of(String str, byte[] bArr) {
            return new Simple(Collections.singletonMap(str, bArr));
        }

        public static ClassFileLocator ofResources(Map<String, byte[]> map) {
            HashMap map2 = new HashMap();
            for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                if (entry.getKey().endsWith(".class")) {
                    map2.put(entry.getKey().substring(0, entry.getKey().length() - 6).replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH), entry.getValue());
                }
            }
            return new Simple(map2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFiles.equals(((Simple) obj).classFiles);
        }

        public int hashCode() {
            return this.classFiles.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) {
            byte[] bArr = this.classFiles.get(str);
            return bArr == null ? new Resolution.Illegal(str) : new Resolution.Explicit(bArr);
        }

        public static ClassFileLocator of(DynamicType dynamicType) {
            return of(dynamicType.getAllTypes());
        }

        public static ClassFileLocator of(Map<TypeDescription, byte[]> map) {
            HashMap map2 = new HashMap();
            for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
                map2.put(entry.getKey().getName(), entry.getValue());
            }
            return new Simple(map2);
        }
    }

    Resolution locate(String str);

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForUrl implements ClassFileLocator {
        private static final boolean ACCESS_CONTROLLER;
        private final ClassLoader classLoader;

        @HashCodeAndEqualsPlugin.Enhance
        public static class ClassLoaderCreationAction implements PrivilegedAction<ClassLoader> {
            private final URL[] url;

            public ClassLoaderCreationAction(URL[] urlArr) {
                this.url = urlArr;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && Arrays.equals(this.url, ((ClassLoaderCreationAction) obj).url);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + Arrays.hashCode(this.url);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return new URLClassLoader(this.url, ClassLoadingStrategy.BOOTSTRAP_LOADER);
            }
        }

        static {
            boolean z6 = false;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z6;
            } catch (SecurityException unused2) {
                z6 = true;
                ACCESS_CONTROLLER = z6;
            }
        }

        public ForUrl(URL... urlArr) {
            this.classLoader = (ClassLoader) doPrivileged(new ClassLoaderCreationAction(urlArr));
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Object obj = this.classLoader;
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((ForUrl) obj).classLoader);
        }

        public int hashCode() {
            return this.classLoader.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) {
            return ForClassLoader.locate(this.classLoader, str);
        }

        public ForUrl(Collection<? extends URL> collection) {
            this((URL[]) collection.toArray(new URL[0]));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForModuleFile implements ClassFileLocator {
        private static final List<String> BOOT_LOCATIONS = Arrays.asList("jmods", "../jmods", "modules");
        private static final String JMOD_FILE_EXTENSION = ".jmod";
        private final ZipFile zipFile;

        public ForModuleFile(ZipFile zipFile) {
            this.zipFile = zipFile;
        }

        public static ClassFileLocator of(File file) {
            return new ForModuleFile(new ZipFile(file));
        }

        public static ClassFileLocator ofBootPath() {
            File file;
            String strReplace = System.getProperty("java.home").replace('\\', ClassPathElement.SEPARATOR_CHAR);
            Iterator<String> it = BOOT_LOCATIONS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    file = null;
                    break;
                }
                file = new File(strReplace, it.next());
                if (file.isDirectory()) {
                    break;
                }
            }
            if (file != null) {
                return ofBootPath(file);
            }
            StringBuilder sbM = b.m("Boot modules do not exist in ", strReplace, " for any of ");
            sbM.append(BOOT_LOCATIONS);
            throw new IllegalStateException(sbM.toString());
        }

        public static ClassFileLocator ofModulePath() {
            String property = System.getProperty("jdk.module.path");
            return property == null ? NoOp.INSTANCE : ofModulePath(property);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.zipFile.close();
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.zipFile.equals(((ForModuleFile) obj).zipFile);
        }

        public int hashCode() {
            return this.zipFile.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public Resolution locate(String str) throws IOException {
            ZipEntry entry = this.zipFile.getEntry("classes/" + str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + ".class");
            if (entry == null) {
                return new Resolution.Illegal(str);
            }
            InputStream inputStream = this.zipFile.getInputStream(entry);
            try {
                return new Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
            } finally {
                inputStream.close();
            }
        }

        public static ClassFileLocator ofModulePath(String str) {
            return ofModulePath(str, System.getProperty("user.dir"));
        }

        public static ClassFileLocator ofModulePath(String str, String str2) {
            ClassFileLocator classFileLocatorOf;
            ClassFileLocator classFileLocatorOf2;
            ArrayList arrayList = new ArrayList();
            for (String str3 : Pattern.compile(System.getProperty("path.separator"), 16).split(str)) {
                File file = new File(str2, str3);
                if (file.isDirectory()) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null) {
                        for (File file2 : fileArrListFiles) {
                            if (file2.isDirectory()) {
                                arrayList.add(new ForFolder(file2));
                            } else if (file2.isFile()) {
                                if (file2.getName().endsWith(JMOD_FILE_EXTENSION)) {
                                    classFileLocatorOf2 = of(file2);
                                } else {
                                    classFileLocatorOf2 = ForJarFile.of(file2);
                                }
                                arrayList.add(classFileLocatorOf2);
                            }
                        }
                    }
                } else if (file.isFile()) {
                    if (file.getName().endsWith(JMOD_FILE_EXTENSION)) {
                        classFileLocatorOf = of(file);
                    } else {
                        classFileLocatorOf = ForJarFile.of(file);
                    }
                    arrayList.add(classFileLocatorOf);
                }
            }
            return new Compound(arrayList);
        }

        public static ClassFileLocator ofBootPath(File file) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return NoOp.INSTANCE;
            }
            ArrayList arrayList = new ArrayList(fileArrListFiles.length);
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    arrayList.add(of(file2));
                } else if (file2.isDirectory()) {
                    arrayList.add(new ForFolder(file2));
                }
            }
            return new Compound(arrayList);
        }
    }
}
