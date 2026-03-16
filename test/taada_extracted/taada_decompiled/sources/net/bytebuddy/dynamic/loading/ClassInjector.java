package net.bytebuddy.dynamic.loading;

import androidx.constraintlayout.core.motion.a;
import com.android.multidex.ClassPathElement;
import com.sun.jna.FunctionMapper;
import com.sun.jna.JNIEnv;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;
import java.lang.reflect.Type;
import java.net.URL;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.MemberRemoval;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.GraalImageCode;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.nullability.UnknownNull;
import net.bytebuddy.utility.privilege.GetMethodAction;

/* JADX INFO: loaded from: classes2.dex */
public interface ClassInjector {
    public static final boolean ALLOW_EXISTING_TYPES = false;
    public static final Permission SUPPRESS_ACCESS_CHECKS = new ReflectPermission("suppressAccessChecks");

    public static abstract class AbstractBase implements ClassInjector {
        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public Map<TypeDescription, Class<?>> inject(Map<? extends TypeDescription, byte[]> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<? extends TypeDescription, byte[]> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey().getName(), entry.getValue());
            }
            Map<String, Class<?>> mapInjectRaw = injectRaw(linkedHashMap);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (TypeDescription typeDescription : map.keySet()) {
                linkedHashMap2.put(typeDescription, mapInjectRaw.get(typeDescription.getName()));
            }
            return linkedHashMap2;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingInstrumentation extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final String CLASS_FILE_EXTENSION = ".class";
        private static final Dispatcher DISPATCHER;
        private static final String JAR = "jar";
        private final File folder;
        private final Instrumentation instrumentation;
        private final RandomString randomString;
        private final Target target;

        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("appendToBootstrapClassLoaderSearch")
            void appendToBootstrapClassLoaderSearch(Instrumentation instrumentation, JarFile jarFile);

            @JavaDispatcher.Proxied("appendToSystemClassLoaderSearch")
            void appendToSystemClassLoaderSearch(Instrumentation instrumentation, JarFile jarFile);

            @JavaDispatcher.Proxied("isModifiableModule")
            boolean isModifiableModule(Instrumentation instrumentation, @JavaDispatcher.Proxied("java.lang.Module") Object obj);

            @JavaDispatcher.Proxied("redefineModule")
            void redefineModule(Instrumentation instrumentation, @JavaDispatcher.Proxied("java.lang.Module") Object obj, Set<?> set, Map<String, Set<?>> map, Map<String, Set<?>> map2, Set<Class<?>> set2, Map<Class<?>, List<Class<?>>> map3);
        }

        public enum Target {
            BOOTSTRAP(null) { // from class: net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation.Target.1
                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation.Target
                public void inject(Instrumentation instrumentation, JarFile jarFile) {
                    UsingInstrumentation.DISPATCHER.appendToBootstrapClassLoaderSearch(instrumentation, jarFile);
                }
            },
            SYSTEM(ClassLoader.getSystemClassLoader()) { // from class: net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation.Target.2
                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation.Target
                public void inject(Instrumentation instrumentation, JarFile jarFile) {
                    UsingInstrumentation.DISPATCHER.appendToSystemClassLoaderSearch(instrumentation, jarFile);
                }
            };


            @MaybeNull
            private final ClassLoader classLoader;

            @MaybeNull
            public ClassLoader getClassLoader() {
                return this.classLoader;
            }

            public abstract void inject(Instrumentation instrumentation, JarFile jarFile);

            Target(@MaybeNull ClassLoader classLoader) {
                this.classLoader = classLoader;
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

        public UsingInstrumentation(File file, Target target, Instrumentation instrumentation, RandomString randomString) {
            this.folder = file;
            this.target = target;
            this.instrumentation = instrumentation;
            this.randomString = randomString;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static boolean isAvailable() {
            return ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V6);
        }

        public static ClassInjector of(File file, Target target, Instrumentation instrumentation) {
            return new UsingInstrumentation(file, target, instrumentation, new RandomString());
        }

        public static void redefineModule(Instrumentation instrumentation, JavaModule javaModule, Set<JavaModule> set, Map<String, Set<JavaModule>> map, Map<String, Set<JavaModule>> map2, Set<Class<?>> set2, Map<Class<?>, List<Class<?>>> map3) {
            if (!DISPATCHER.isModifiableModule(instrumentation, javaModule.unwrap())) {
                throw new IllegalArgumentException("Cannot modify module: " + javaModule);
            }
            HashSet hashSet = new HashSet();
            Iterator<JavaModule> it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().unwrap());
            }
            HashMap map4 = new HashMap();
            for (Map.Entry<String, Set<JavaModule>> entry : map.entrySet()) {
                HashSet hashSet2 = new HashSet();
                Iterator<JavaModule> it2 = entry.getValue().iterator();
                while (it2.hasNext()) {
                    hashSet2.add(it2.next().unwrap());
                }
                map4.put(entry.getKey(), hashSet2);
            }
            HashMap map5 = new HashMap();
            for (Map.Entry<String, Set<JavaModule>> entry2 : map2.entrySet()) {
                HashSet hashSet3 = new HashSet();
                Iterator<JavaModule> it3 = entry2.getValue().iterator();
                while (it3.hasNext()) {
                    hashSet3.add(it3.next().unwrap());
                }
                map5.put(entry2.getKey(), hashSet3);
            }
            DISPATCHER.redefineModule(instrumentation, javaModule.unwrap(), hashSet, map4, map5, set2, map3);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UsingInstrumentation usingInstrumentation = (UsingInstrumentation) obj;
            return this.target.equals(usingInstrumentation.target) && this.instrumentation.equals(usingInstrumentation.instrumentation) && this.folder.equals(usingInstrumentation.folder) && this.randomString.equals(usingInstrumentation.randomString);
        }

        public int hashCode() {
            return this.randomString.hashCode() + ((this.folder.hashCode() + ((this.target.hashCode() + ((this.instrumentation.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31);
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map) {
            File file = new File(this.folder, JAR + this.randomString.nextString() + ".jar");
            try {
                if (!file.createNewFile()) {
                    throw new IllegalStateException("Cannot create file " + file);
                }
                try {
                    JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(file));
                    try {
                        for (Map.Entry<? extends String, byte[]> entry : map.entrySet()) {
                            jarOutputStream.putNextEntry(new JarEntry(entry.getKey().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + ".class"));
                            jarOutputStream.write(entry.getValue());
                        }
                        jarOutputStream.close();
                        JarFile jarFile = new JarFile(file, false);
                        try {
                            this.target.inject(this.instrumentation, jarFile);
                            jarFile.close();
                            HashMap map2 = new HashMap();
                            for (String str : map.keySet()) {
                                map2.put(str, Class.forName(str, false, this.target.getClassLoader()));
                            }
                        } catch (Throwable th) {
                            jarFile.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        jarOutputStream.close();
                        throw th2;
                    }
                } finally {
                    if (!file.delete()) {
                        file.deleteOnExit();
                    }
                }
            } catch (IOException e) {
                throw new IllegalStateException("Cannot write jar file to disk", e);
            } catch (ClassNotFoundException e6) {
                throw new IllegalStateException("Cannot load injected class", e6);
            }
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public boolean isAlive() {
            return isAvailable();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingJna extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final Object BOOTSTRAP_LOADER_LOCK;
        private static final Dispatcher DISPATCHER;

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ClassLoader classLoader;

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ProtectionDomain protectionDomain;

        public interface Dispatcher {

            public enum CreationAction implements PrivilegedAction<Dispatcher> {
                INSTANCE;

                @Override // java.security.PrivilegedAction
                public Dispatcher run() {
                    if (System.getProperty("java.vm.name", "").toUpperCase(Locale.US).contains("J9")) {
                        return new Unavailable("J9 does not support JNA-based class definition");
                    }
                    try {
                        HashMap map = new HashMap();
                        map.put("allow-objects", Boolean.TRUE);
                        if (Platform.isWindows() && !Platform.is64Bit()) {
                            map.put("function-mapper", Windows32BitFunctionMapper.INSTANCE);
                        }
                        return new Enabled((Jvm) Native.loadLibrary("jvm", Jvm.class, map));
                    } catch (Throwable th) {
                        return new Unavailable(th.getMessage());
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements Dispatcher {
                private final Jvm jvm;

                public Enabled(Jvm jvm) {
                    this.jvm = jvm;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.Dispatcher
                public Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    return this.jvm.JVM_DefineClass(JNIEnv.CURRENT, str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR), classLoader, bArr, bArr.length, protectionDomain);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.jvm.equals(((Enabled) obj).jvm);
                }

                public int hashCode() {
                    return this.jvm.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.Dispatcher
                public boolean isAvailable() {
                    return true;
                }
            }

            public interface Jvm extends Library {
                Class<?> JVM_DefineClass(JNIEnv jNIEnv, String str, @MaybeNull ClassLoader classLoader, byte[] bArr, int i, @MaybeNull ProtectionDomain protectionDomain);
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unavailable implements Dispatcher {
                private final String error;

                public Unavailable(String str) {
                    this.error = str;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.Dispatcher
                public Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("JNA is not available and JNA-based injection cannot be used: " + this.error);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.error.equals(((Unavailable) obj).error);
                }

                public int hashCode() {
                    return this.error.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.Dispatcher
                public boolean isAvailable() {
                    return false;
                }
            }

            public enum Windows32BitFunctionMapper implements FunctionMapper {
                INSTANCE;

                public String getFunctionName(NativeLibrary nativeLibrary, Method method) {
                    return method.getName().equals("JVM_DefineClass") ? "_JVM_DefineClass@24" : method.getName();
                }
            }

            Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain);

            boolean isAvailable();
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
            DISPATCHER = (Dispatcher) doPrivileged(Dispatcher.CreationAction.INSTANCE);
            BOOTSTRAP_LOADER_LOCK = new Object();
        }

        public UsingJna(@MaybeNull ClassLoader classLoader) {
            this(classLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofBootLoader() {
            return new UsingJna(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        public static ClassInjector ofPlatformLoader() {
            return new UsingJna(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassInjector ofSystemLoader() {
            return new UsingJna(ClassLoader.getSystemClassLoader());
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
        
            if (r2 != null) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0039 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                r1 = 0
                if (r5 != 0) goto L8
                return r1
            L8:
                java.lang.Class r2 = r4.getClass()
                java.lang.Class r3 = r5.getClass()
                if (r2 == r3) goto L13
                return r1
            L13:
                java.lang.ClassLoader r2 = r4.classLoader
                net.bytebuddy.dynamic.loading.ClassInjector$UsingJna r5 = (net.bytebuddy.dynamic.loading.ClassInjector.UsingJna) r5
                java.lang.ClassLoader r3 = r5.classLoader
                if (r3 == 0) goto L24
                if (r2 == 0) goto L26
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L27
                return r1
            L24:
                if (r2 == 0) goto L27
            L26:
                return r1
            L27:
                java.security.ProtectionDomain r2 = r4.protectionDomain
                java.security.ProtectionDomain r5 = r5.protectionDomain
                if (r5 == 0) goto L36
                if (r2 == 0) goto L38
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L39
                return r1
            L36:
                if (r2 == 0) goto L39
            L38:
                return r1
            L39:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int iHashCode = getClass().hashCode() * 31;
            ClassLoader classLoader = this.classLoader;
            if (classLoader != null) {
                iHashCode += classLoader.hashCode();
            }
            int i = iHashCode * 31;
            ProtectionDomain protectionDomain = this.protectionDomain;
            return protectionDomain != null ? protectionDomain.hashCode() + i : i;
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map) {
            HashMap map2 = new HashMap();
            Object obj = this.classLoader;
            if (obj == null) {
                obj = BOOTSTRAP_LOADER_LOCK;
            }
            synchronized (obj) {
                for (Map.Entry<? extends String, byte[]> entry : map.entrySet()) {
                    try {
                        map2.put(entry.getKey(), Class.forName(entry.getKey(), false, this.classLoader));
                    } catch (ClassNotFoundException unused) {
                        map2.put(entry.getKey(), DISPATCHER.defineClass(this.classLoader, entry.getKey(), entry.getValue(), this.protectionDomain));
                    }
                }
            }
            return map2;
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public boolean isAlive() {
            return DISPATCHER.isAvailable();
        }

        public UsingJna(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
            this.classLoader = classLoader;
            this.protectionDomain = protectionDomain;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingLookup extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final MethodHandles METHOD_HANDLES;
        private static final MethodHandles.Lookup METHOD_HANDLES_LOOKUP;
        private static final int PACKAGE_LOOKUP = 8;
        private final Object lookup;

        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles")
        public interface MethodHandles {

            @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup")
            public interface Lookup {
                @JavaDispatcher.Proxied("defineClass")
                Class<?> defineClass(Object obj, byte[] bArr);

                @JavaDispatcher.Proxied("lookupClass")
                Class<?> lookupClass(Object obj);

                @JavaDispatcher.Proxied("lookupModes")
                int lookupModes(Object obj);
            }

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("privateLookupIn")
            Object privateLookupIn(Class<?> cls, @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup") Object obj);
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
            METHOD_HANDLES = (MethodHandles) doPrivileged(JavaDispatcher.of(MethodHandles.class));
            METHOD_HANDLES_LOOKUP = (MethodHandles.Lookup) doPrivileged(JavaDispatcher.of(MethodHandles.Lookup.class));
        }

        public UsingLookup(Object obj) {
            this.lookup = obj;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static boolean isAvailable() {
            return JavaType.MODULE.isAvailable();
        }

        public static UsingLookup of(Object obj) {
            if (!isAvailable()) {
                throw new IllegalStateException("The current VM does not support class definition via method handle lookups");
            }
            if (!JavaType.METHOD_HANDLES_LOOKUP.isInstance(obj)) {
                throw new IllegalArgumentException(a.m(obj, "Not a method handle lookup: "));
            }
            if ((METHOD_HANDLES_LOOKUP.lookupModes(obj) & 8) != 0) {
                return new UsingLookup(obj);
            }
            throw new IllegalArgumentException(a.m(obj, "Lookup does not imply package-access: "));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.lookup.equals(((UsingLookup) obj).lookup);
        }

        public int hashCode() {
            return this.lookup.hashCode() + (getClass().hashCode() * 31);
        }

        public UsingLookup in(Class<?> cls) {
            try {
                return new UsingLookup(METHOD_HANDLES.privateLookupIn(cls, this.lookup));
            } catch (IllegalAccessException e) {
                StringBuilder sb = new StringBuilder("Cannot access ");
                a.u(cls, sb, " from ");
                sb.append(this.lookup);
                throw new IllegalStateException(sb.toString(), e);
            }
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map) {
            PackageDescription packageDescription = TypeDescription.ForLoadedType.of(lookupType()).getPackage();
            if (packageDescription == null) {
                throw new IllegalArgumentException("Cannot inject array or primitive type");
            }
            HashMap map2 = new HashMap();
            for (Map.Entry<? extends String, byte[]> entry : map.entrySet()) {
                int iLastIndexOf = entry.getKey().lastIndexOf(46);
                if (!packageDescription.getName().equals(iLastIndexOf == -1 ? "" : entry.getKey().substring(0, iLastIndexOf))) {
                    throw new IllegalArgumentException(entry.getKey() + " must be defined in the same package as " + this.lookup);
                }
                try {
                    map2.put(entry.getKey(), METHOD_HANDLES_LOOKUP.defineClass(this.lookup, entry.getValue()));
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
            return map2;
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public boolean isAlive() {
            return isAvailable();
        }

        public Class<?> lookupType() {
            return METHOD_HANDLES_LOOKUP.lookupClass(this.lookup);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingReflection extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final Method CHECK_PERMISSION;
        private static final Dispatcher.Initializable DISPATCHER;
        private static final System SYSTEM;
        private final ClassLoader classLoader;
        private final boolean forbidExisting;
        private final PackageDefinitionStrategy packageDefinitionStrategy;

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ProtectionDomain protectionDomain;

        public interface Dispatcher {

            @AlwaysNull
            public static final Class<?> UNDEFINED = null;

            public enum CreationAction implements PrivilegedAction<Initializable> {
                INSTANCE;

                @Override // java.security.PrivilegedAction
                @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
                public Initializable run() {
                    try {
                        return JavaModule.isSupported() ? UsingUnsafe.isAvailable() ? UsingUnsafeInjection.make() : UsingUnsafeOverride.make() : Direct.make();
                    } catch (InvocationTargetException e) {
                        return new Initializable.Unavailable(e.getTargetException().getMessage());
                    } catch (Exception e6) {
                        return new Initializable.Unavailable(e6.getMessage());
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Direct implements Dispatcher, Initializable {
                protected final Method defineClass;
                protected final Method definePackage;
                protected final Method findLoadedClass;

                @UnknownNull
                protected final Method getDefinedPackage;
                protected final Method getPackage;

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJava7CapableVm extends Direct {
                    private final Method getClassLoadingLock;

                    public ForJava7CapableVm(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5, Method method6) {
                        super(method, method2, method3, method4, method5);
                        this.getClassLoadingLock = method6;
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Direct
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.getClassLoadingLock.equals(((ForJava7CapableVm) obj).getClassLoadingLock);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        try {
                            return this.getClassLoadingLock.invoke(classLoader, str);
                        } catch (IllegalAccessException e) {
                            throw new IllegalStateException(e);
                        } catch (InvocationTargetException e6) {
                            throw new IllegalStateException(e6.getTargetException());
                        }
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Direct
                    public int hashCode() {
                        return this.getClassLoadingLock.hashCode() + (super.hashCode() * 31);
                    }
                }

                public static class ForLegacyVm extends Direct {
                    public ForLegacyVm(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5) {
                        super(method, method2, method3, method4, method5);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        return classLoader;
                    }
                }

                public Direct(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5) {
                    this.findLoadedClass = method;
                    this.defineClass = method2;
                    this.getDefinedPackage = method3;
                    this.getPackage = method4;
                    this.definePackage = method5;
                }

                @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
                public static Initializable make() throws NoSuchMethodException {
                    Method method = null;
                    if (JavaModule.isSupported()) {
                        try {
                            method = ClassLoader.class.getMethod("getDefinedPackage", String.class);
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                    Method method2 = method;
                    Method declaredMethod = ClassLoader.class.getDeclaredMethod("getPackage", String.class);
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
                    declaredMethod2.setAccessible(true);
                    Class cls = Integer.TYPE;
                    Method declaredMethod3 = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls, cls, ProtectionDomain.class);
                    declaredMethod3.setAccessible(true);
                    Method declaredMethod4 = ClassLoader.class.getDeclaredMethod("definePackage", String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class);
                    declaredMethod4.setAccessible(true);
                    try {
                        Method declaredMethod5 = ClassLoader.class.getDeclaredMethod("getClassLoadingLock", String.class);
                        declaredMethod5.setAccessible(true);
                        return new ForJava7CapableVm(declaredMethod2, declaredMethod3, method2, declaredMethod, declaredMethod4, declaredMethod5);
                    } catch (NoSuchMethodException unused2) {
                        return new ForLegacyVm(declaredMethod2, declaredMethod3, method2, declaredMethod, declaredMethod4);
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(classLoader, str, bArr, 0, Integer.valueOf(bArr.length), protectionDomain);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url) {
                    try {
                        return (Package) this.definePackage.invoke(classLoader, str, str2, str3, str4, str5, str6, str7, url);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Direct direct = (Direct) obj;
                    return this.findLoadedClass.equals(direct.findLoadedClass) && this.defineClass.equals(direct.defineClass) && this.getDefinedPackage.equals(direct.getDefinedPackage) && this.getPackage.equals(direct.getPackage) && this.definePackage.equals(direct.definePackage);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return (Class) this.findLoadedClass.invoke(classLoader, str);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                @MaybeNull
                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    Method method = this.getDefinedPackage;
                    if (method == null) {
                        return getPackage(classLoader, str);
                    }
                    try {
                        return (Package) method.invoke(classLoader, str);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getPackage(ClassLoader classLoader, String str) {
                    try {
                        return (Package) this.getPackage.invoke(classLoader, str);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                public int hashCode() {
                    return this.definePackage.hashCode() + ((this.getPackage.hashCode() + ((this.getDefinedPackage.hashCode() + ((this.defineClass.hashCode() + ((this.findLoadedClass.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public Dispatcher initialize() {
                    Object securityManager = UsingReflection.SYSTEM.getSecurityManager();
                    if (securityManager == null) {
                        return this;
                    }
                    try {
                        UsingReflection.CHECK_PERMISSION.invoke(securityManager, ClassInjector.SUPPRESS_ACCESS_CHECKS);
                        return this;
                    } catch (InvocationTargetException e) {
                        return new Unavailable(e.getTargetException().getMessage());
                    } catch (Exception e6) {
                        return new Unavailable(e6.getMessage());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public boolean isAvailable() {
                    return true;
                }
            }

            public interface Initializable {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Unavailable implements Dispatcher, Initializable {
                    private final String message;

                    public Unavailable(String str) {
                        this.message = str;
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                        throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url) {
                        throw new UnsupportedOperationException("Cannot define package using injection: " + this.message);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Class<?> findClass(ClassLoader classLoader, String str) {
                        try {
                            return classLoader.loadClass(str);
                        } catch (ClassNotFoundException unused) {
                            return Dispatcher.UNDEFINED;
                        }
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        return classLoader;
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Package getDefinedPackage(ClassLoader classLoader, String str) {
                        throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Package getPackage(ClassLoader classLoader, String str) {
                        throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message);
                    }

                    public int hashCode() {
                        return this.message.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                    public Dispatcher initialize() {
                        return this;
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                    public boolean isAvailable() {
                        return false;
                    }
                }

                Dispatcher initialize();

                boolean isAvailable();
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unavailable implements Dispatcher {
                private final String message;

                public Unavailable(String str) {
                    this.message = str;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url) {
                    throw new UnsupportedOperationException("Cannot define package using injection: " + this.message);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return classLoader.loadClass(str);
                    } catch (ClassNotFoundException unused) {
                        return Dispatcher.UNDEFINED;
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                    return classLoader;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getPackage(ClassLoader classLoader, String str) {
                    throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message);
                }

                public int hashCode() {
                    return this.message.hashCode() + (getClass().hashCode() * 31);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class UsingUnsafeInjection implements Dispatcher, Initializable {
                private final Object accessor;
                private final Method defineClass;
                private final Method definePackage;
                private final Method findLoadedClass;
                private final Method getClassLoadingLock;

                @UnknownNull
                private final Method getDefinedPackage;
                private final Method getPackage;

                public UsingUnsafeInjection(Object obj, Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5, Method method6) {
                    this.accessor = obj;
                    this.findLoadedClass = method;
                    this.defineClass = method2;
                    this.getDefinedPackage = method3;
                    this.getPackage = method4;
                    this.definePackage = method5;
                    this.getClassLoadingLock = method6;
                }

                @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
                public static Initializable make() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
                    Method declaredMethod;
                    DynamicType.Builder builderIntercept;
                    if (Boolean.parseBoolean(java.lang.System.getProperty(UsingUnsafe.SAFE_PROPERTY, Boolean.toString(GraalImageCode.getCurrent().isDefined())))) {
                        return new Initializable.Unavailable("Use of Unsafe was disabled by system property");
                    }
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(null);
                    if (JavaModule.isSupported()) {
                        try {
                            declaredMethod = ClassLoader.class.getDeclaredMethod("getDefinedPackage", String.class);
                        } catch (NoSuchMethodException unused) {
                            declaredMethod = null;
                        }
                    } else {
                        declaredMethod = null;
                    }
                    Method method = declaredMethod;
                    DynamicType.Builder builderName = new ByteBuddy().with(TypeValidation.DISABLED).subclass(Object.class, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).name(ClassLoader.class.getName().concat("$ByteBuddyAccessor$V1"));
                    Visibility visibility = Visibility.PUBLIC;
                    DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial initialDefineMethod = builderName.defineMethod("findLoadedClass", Class.class, visibility).withParameters(ClassLoader.class, String.class).intercept(MethodCall.invoke(ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class)).onArgument(0).withArgument(1)).defineMethod("defineClass", Class.class, visibility);
                    Class cls2 = Integer.TYPE;
                    DynamicType.Builder builderIntercept2 = initialDefineMethod.withParameters(ClassLoader.class, String.class, byte[].class, cls2, cls2, ProtectionDomain.class).intercept(MethodCall.invoke(ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls2, cls2, ProtectionDomain.class)).onArgument(0).withArgument(1, 2, 3, 4, 5)).defineMethod("getPackage", Package.class, visibility).withParameters(ClassLoader.class, String.class).intercept(MethodCall.invoke(ClassLoader.class.getDeclaredMethod("getPackage", String.class)).onArgument(0).withArgument(1)).defineMethod("definePackage", Package.class, visibility).withParameters(ClassLoader.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class).intercept(MethodCall.invoke(ClassLoader.class.getDeclaredMethod("definePackage", String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class)).onArgument(0).withArgument(1, 2, 3, 4, 5, 6, 7, 8));
                    int i = 1;
                    if (method != null) {
                        builderIntercept2 = builderIntercept2.defineMethod("getDefinedPackage", Package.class, visibility).withParameters(ClassLoader.class, String.class).intercept(MethodCall.invoke(method).onArgument(0).withArgument(1));
                    }
                    try {
                        try {
                            builderIntercept = builderIntercept2.defineMethod("getClassLoadingLock", Object.class, visibility).withParameters(ClassLoader.class, String.class).intercept(MethodCall.invoke(ClassLoader.class.getDeclaredMethod("getClassLoadingLock", String.class)).onArgument(0).withArgument(1));
                        } catch (NoSuchMethodException unused2) {
                            ModifierContributor.ForMethod[] forMethodArr = new ModifierContributor.ForMethod[i];
                            forMethodArr[0] = Visibility.PUBLIC;
                            DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial initialDefineMethod2 = builderIntercept2.defineMethod("getClassLoadingLock", Object.class, forMethodArr);
                            Type[] typeArr = new Type[2];
                            typeArr[0] = ClassLoader.class;
                            typeArr[i] = String.class;
                            builderIntercept = initialDefineMethod2.withParameters(typeArr).intercept(FixedValue.argument(0));
                        }
                    } catch (NoSuchMethodException unused3) {
                        i = 1;
                    }
                    Class loaded = builderIntercept.make().load(ClassLoadingStrategy.BOOTSTRAP_LOADER, new ClassLoadingStrategy.ForUnsafeInjection()).getLoaded();
                    Object objInvoke = cls.getMethod("allocateInstance", Class.class).invoke(obj, loaded);
                    Method method2 = loaded.getMethod("findLoadedClass", ClassLoader.class, String.class);
                    Class cls3 = Integer.TYPE;
                    return new UsingUnsafeInjection(objInvoke, method2, loaded.getMethod("defineClass", ClassLoader.class, String.class, byte[].class, cls3, cls3, ProtectionDomain.class), method != null ? loaded.getMethod("getDefinedPackage", ClassLoader.class, String.class) : null, loaded.getMethod("getPackage", ClassLoader.class, String.class), loaded.getMethod("definePackage", ClassLoader.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class), loaded.getMethod("getClassLoadingLock", ClassLoader.class, String.class));
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(this.accessor, classLoader, str, bArr, 0, Integer.valueOf(bArr.length), protectionDomain);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url) {
                    try {
                        return (Package) this.definePackage.invoke(this.accessor, classLoader, str, str2, str3, str4, str5, str6, str7, url);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    UsingUnsafeInjection usingUnsafeInjection = (UsingUnsafeInjection) obj;
                    return this.accessor.equals(usingUnsafeInjection.accessor) && this.findLoadedClass.equals(usingUnsafeInjection.findLoadedClass) && this.defineClass.equals(usingUnsafeInjection.defineClass) && this.getDefinedPackage.equals(usingUnsafeInjection.getDefinedPackage) && this.getPackage.equals(usingUnsafeInjection.getPackage) && this.definePackage.equals(usingUnsafeInjection.definePackage) && this.getClassLoadingLock.equals(usingUnsafeInjection.getClassLoadingLock);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return (Class) this.findLoadedClass.invoke(this.accessor, classLoader, str);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                    try {
                        return this.getClassLoadingLock.invoke(this.accessor, classLoader, str);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                @MaybeNull
                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    Method method = this.getDefinedPackage;
                    if (method == null) {
                        return getPackage(classLoader, str);
                    }
                    try {
                        return (Package) method.invoke(this.accessor, classLoader, str);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getPackage(ClassLoader classLoader, String str) {
                    try {
                        return (Package) this.getPackage.invoke(this.accessor, classLoader, str);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                public int hashCode() {
                    return this.getClassLoadingLock.hashCode() + ((this.definePackage.hashCode() + ((this.getPackage.hashCode() + ((this.getDefinedPackage.hashCode() + ((this.defineClass.hashCode() + ((this.findLoadedClass.hashCode() + ((this.accessor.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public Dispatcher initialize() {
                    Object securityManager = UsingReflection.SYSTEM.getSecurityManager();
                    if (securityManager == null) {
                        return this;
                    }
                    try {
                        UsingReflection.CHECK_PERMISSION.invoke(securityManager, ClassInjector.SUPPRESS_ACCESS_CHECKS);
                        return this;
                    } catch (InvocationTargetException e) {
                        return new Unavailable(e.getTargetException().getMessage());
                    } catch (Exception e6) {
                        return new Unavailable(e6.getMessage());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public boolean isAvailable() {
                    return true;
                }
            }

            public static abstract class UsingUnsafeOverride implements Dispatcher, Initializable {
                protected final Method defineClass;
                protected final Method definePackage;
                protected final Method findLoadedClass;

                @MaybeNull
                protected final Method getDefinedPackage;
                protected final Method getPackage;

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJava7CapableVm extends UsingUnsafeOverride {
                    private final Method getClassLoadingLock;

                    public ForJava7CapableVm(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5, Method method6) {
                        super(method, method2, method3, method4, method5);
                        this.getClassLoadingLock = method6;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.getClassLoadingLock.equals(((ForJava7CapableVm) obj).getClassLoadingLock);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        try {
                            return this.getClassLoadingLock.invoke(classLoader, str);
                        } catch (IllegalAccessException e) {
                            throw new IllegalStateException(e);
                        } catch (InvocationTargetException e6) {
                            throw new IllegalStateException(e6.getTargetException());
                        }
                    }

                    public int hashCode() {
                        return this.getClassLoadingLock.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                public static class ForLegacyVm extends UsingUnsafeOverride {
                    public ForLegacyVm(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5) {
                        super(method, method2, method3, method4, method5);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        return classLoader;
                    }
                }

                public UsingUnsafeOverride(Method method, Method method2, @MaybeNull Method method3, Method method4, Method method5) {
                    this.findLoadedClass = method;
                    this.defineClass = method2;
                    this.getDefinedPackage = method3;
                    this.getPackage = method4;
                    this.definePackage = method5;
                }

                @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
                public static Initializable make() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
                    Field declaredField;
                    if (Boolean.parseBoolean(java.lang.System.getProperty(UsingUnsafe.SAFE_PROPERTY, Boolean.toString(GraalImageCode.getCurrent().isDefined())))) {
                        return new Initializable.Unavailable("Use of Unsafe was disabled by system property");
                    }
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField2 = cls.getDeclaredField("theUnsafe");
                    declaredField2.setAccessible(true);
                    Method method = null;
                    Object obj = declaredField2.get(null);
                    try {
                        declaredField = AccessibleObject.class.getDeclaredField("override");
                    } catch (NoSuchFieldException unused) {
                        declaredField = new ByteBuddy().redefine(AccessibleObject.class).name("net.bytebuddy.mirror.AccessibleObject").noNestMate().visit(new MemberRemoval().stripInvokables(ElementMatchers.any())).make().load(AccessibleObject.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER.with(AccessibleObject.class.getProtectionDomain())).getLoaded().getDeclaredField("override");
                    }
                    Long l6 = (Long) cls.getMethod("objectFieldOffset", Field.class).invoke(obj, declaredField);
                    l6.longValue();
                    Method method2 = cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
                    if (JavaModule.isSupported()) {
                        try {
                            method = ClassLoader.class.getMethod("getDefinedPackage", String.class);
                        } catch (NoSuchMethodException unused2) {
                        }
                    }
                    Method method3 = method;
                    Method declaredMethod = ClassLoader.class.getDeclaredMethod("getPackage", String.class);
                    Boolean bool = Boolean.TRUE;
                    method2.invoke(obj, declaredMethod, l6, bool);
                    Method declaredMethod2 = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
                    Class cls2 = Integer.TYPE;
                    Method declaredMethod3 = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls2, cls2, ProtectionDomain.class);
                    Method declaredMethod4 = ClassLoader.class.getDeclaredMethod("definePackage", String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class);
                    method2.invoke(obj, declaredMethod3, l6, bool);
                    method2.invoke(obj, declaredMethod2, l6, bool);
                    method2.invoke(obj, declaredMethod4, l6, bool);
                    try {
                        Method declaredMethod5 = ClassLoader.class.getDeclaredMethod("getClassLoadingLock", String.class);
                        method2.invoke(obj, declaredMethod5, l6, bool);
                        return new ForJava7CapableVm(declaredMethod2, declaredMethod3, method3, declaredMethod, declaredMethod4, declaredMethod5);
                    } catch (NoSuchMethodException unused3) {
                        return new ForLegacyVm(declaredMethod2, declaredMethod3, method3, declaredMethod, declaredMethod4);
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(classLoader, str, bArr, 0, Integer.valueOf(bArr.length), protectionDomain);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url) {
                    try {
                        return (Package) this.definePackage.invoke(classLoader, str, str2, str3, str4, str5, str6, str7, url);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return (Class) this.findLoadedClass.invoke(classLoader, str);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                @MaybeNull
                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    Method method = this.getDefinedPackage;
                    if (method == null) {
                        return getPackage(classLoader, str);
                    }
                    try {
                        return (Package) method.invoke(classLoader, str);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getPackage(ClassLoader classLoader, String str) {
                    try {
                        return (Package) this.getPackage.invoke(classLoader, str);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public Dispatcher initialize() {
                    Object securityManager = UsingReflection.SYSTEM.getSecurityManager();
                    if (securityManager == null) {
                        return this;
                    }
                    try {
                        UsingReflection.CHECK_PERMISSION.invoke(securityManager, ClassInjector.SUPPRESS_ACCESS_CHECKS);
                        return this;
                    } catch (InvocationTargetException e) {
                        return new Unavailable(e.getTargetException().getMessage());
                    } catch (Exception e6) {
                        return new Unavailable(e6.getMessage());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public boolean isAvailable() {
                    return true;
                }
            }

            Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain);

            Package definePackage(ClassLoader classLoader, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull String str7, @MaybeNull URL url);

            @MaybeNull
            Class<?> findClass(ClassLoader classLoader, String str);

            Object getClassLoadingLock(ClassLoader classLoader, String str);

            @MaybeNull
            Package getDefinedPackage(ClassLoader classLoader, String str);

            @MaybeNull
            Package getPackage(ClassLoader classLoader, String str);
        }

        @JavaDispatcher.Proxied("java.lang.System")
        public interface System {
            @JavaDispatcher.IsStatic
            @JavaDispatcher.Defaults
            @MaybeNull
            @JavaDispatcher.Proxied("getSecurityManager")
            Object getSecurityManager();
        }

        static {
            boolean z6 = false;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(java.lang.System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z6;
            } catch (SecurityException unused2) {
                z6 = true;
                ACCESS_CONTROLLER = z6;
            }
            DISPATCHER = (Dispatcher.Initializable) doPrivileged(Dispatcher.CreationAction.INSTANCE);
            SYSTEM = (System) doPrivileged(JavaDispatcher.of(System.class));
            CHECK_PERMISSION = (Method) doPrivileged(new GetMethodAction("java.lang.SecurityManager", "checkPermission", Permission.class));
        }

        public UsingReflection(ClassLoader classLoader) {
            this(classLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofSystemClassLoader() {
            return new UsingReflection(ClassLoader.getSystemClassLoader());
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
        
            if (r2 != null) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                r1 = 0
                if (r5 != 0) goto L8
                return r1
            L8:
                java.lang.Class r2 = r4.getClass()
                java.lang.Class r3 = r5.getClass()
                if (r2 == r3) goto L13
                return r1
            L13:
                boolean r2 = r4.forbidExisting
                net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection r5 = (net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection) r5
                boolean r3 = r5.forbidExisting
                if (r2 == r3) goto L1c
                return r1
            L1c:
                java.lang.ClassLoader r2 = r4.classLoader
                java.lang.ClassLoader r3 = r5.classLoader
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L27
                return r1
            L27:
                java.security.ProtectionDomain r2 = r4.protectionDomain
                java.security.ProtectionDomain r3 = r5.protectionDomain
                if (r3 == 0) goto L36
                if (r2 == 0) goto L38
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L39
                return r1
            L36:
                if (r2 == 0) goto L39
            L38:
                return r1
            L39:
                net.bytebuddy.dynamic.loading.PackageDefinitionStrategy r2 = r4.packageDefinitionStrategy
                net.bytebuddy.dynamic.loading.PackageDefinitionStrategy r5 = r5.packageDefinitionStrategy
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L44
                return r1
            L44:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int iHashCode = (this.classLoader.hashCode() + (getClass().hashCode() * 31)) * 31;
            ProtectionDomain protectionDomain = this.protectionDomain;
            if (protectionDomain != null) {
                iHashCode += protectionDomain.hashCode();
            }
            return ((this.packageDefinitionStrategy.hashCode() + (iHashCode * 31)) * 31) + (this.forbidExisting ? 1 : 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:67:0x011d  */
        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.Map<java.lang.String, java.lang.Class<?>> injectRaw(java.util.Map<? extends java.lang.String, byte[]> r18) {
            /*
                Method dump skipped, instruction units count: 352
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.injectRaw(java.util.Map):java.util.Map");
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public boolean isAlive() {
            return isAvailable();
        }

        public UsingReflection(ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
            this(classLoader, protectionDomain, PackageDefinitionStrategy.Trivial.INSTANCE, false);
        }

        public UsingReflection(ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain, PackageDefinitionStrategy packageDefinitionStrategy, boolean z6) {
            if (classLoader != null) {
                this.classLoader = classLoader;
                this.protectionDomain = protectionDomain;
                this.packageDefinitionStrategy = packageDefinitionStrategy;
                this.forbidExisting = z6;
                return;
            }
            throw new IllegalArgumentException("Cannot inject classes into the bootstrap class loader");
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingUnsafe extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final Object BOOTSTRAP_LOADER_LOCK;
        private static final Method CHECK_PERMISSION;
        private static final Dispatcher.Initializable DISPATCHER;
        public static final String SAFE_PROPERTY = "net.bytebuddy.safe";
        private static final System SYSTEM;

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ClassLoader classLoader;
        private final Dispatcher.Initializable dispatcher;

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ProtectionDomain protectionDomain;

        public interface Dispatcher {

            public enum CreationAction implements PrivilegedAction<Initializable> {
                INSTANCE;

                @Override // java.security.PrivilegedAction
                @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
                public Initializable run() {
                    Field declaredField;
                    if (Boolean.parseBoolean(java.lang.System.getProperty(UsingUnsafe.SAFE_PROPERTY, Boolean.toString(GraalImageCode.getCurrent().isDefined())))) {
                        return new Unavailable("Use of Unsafe was disabled by system property");
                    }
                    try {
                        Class<?> cls = Class.forName("sun.misc.Unsafe");
                        Field declaredField2 = cls.getDeclaredField("theUnsafe");
                        declaredField2.setAccessible(true);
                        Object obj = declaredField2.get(null);
                        try {
                            Class cls2 = Integer.TYPE;
                            Method method = cls.getMethod("defineClass", String.class, byte[].class, cls2, cls2, ClassLoader.class, ProtectionDomain.class);
                            method.setAccessible(true);
                            return new Enabled(obj, method);
                        } catch (Exception e) {
                            try {
                                try {
                                    declaredField = AccessibleObject.class.getDeclaredField("override");
                                } catch (NoSuchFieldException unused) {
                                    declaredField = new ByteBuddy().redefine(AccessibleObject.class).name("net.bytebuddy.mirror.AccessibleObject").noNestMate().visit(new MemberRemoval().stripInvokables(ElementMatchers.any())).make().load(AccessibleObject.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER.with(AccessibleObject.class.getProtectionDomain())).getLoaded().getDeclaredField("override");
                                }
                                Long l6 = (Long) cls.getMethod("objectFieldOffset", Field.class).invoke(obj, declaredField);
                                l6.longValue();
                                Method method2 = cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
                                Class<?> cls3 = Class.forName("jdk.internal.misc.Unsafe");
                                Field declaredField3 = cls3.getDeclaredField("theUnsafe");
                                Boolean bool = Boolean.TRUE;
                                method2.invoke(obj, declaredField3, l6, bool);
                                Class cls4 = Integer.TYPE;
                                Method method3 = cls3.getMethod("defineClass", String.class, byte[].class, cls4, cls4, ClassLoader.class, ProtectionDomain.class);
                                method2.invoke(obj, method3, l6, bool);
                                return new Enabled(declaredField3.get(null), method3);
                            } catch (Exception unused2) {
                                throw e;
                            }
                        }
                    } catch (Exception e6) {
                        return new Unavailable(e6.getMessage());
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements Dispatcher, Initializable {
                private final Method defineClass;
                private final Object unsafe;

                public Enabled(Object obj, Method method) {
                    this.unsafe = obj;
                    this.defineClass = method;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher
                public Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(this.unsafe, str, bArr, 0, Integer.valueOf(bArr.length), classLoader, protectionDomain);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException(e6.getTargetException());
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Enabled enabled = (Enabled) obj;
                    return this.unsafe.equals(enabled.unsafe) && this.defineClass.equals(enabled.defineClass);
                }

                public int hashCode() {
                    return this.defineClass.hashCode() + ((this.unsafe.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable
                public Dispatcher initialize() {
                    Object securityManager = UsingUnsafe.SYSTEM.getSecurityManager();
                    if (securityManager == null) {
                        return this;
                    }
                    try {
                        UsingUnsafe.CHECK_PERMISSION.invoke(securityManager, ClassInjector.SUPPRESS_ACCESS_CHECKS);
                        return this;
                    } catch (InvocationTargetException e) {
                        return new Unavailable(e.getTargetException().getMessage());
                    } catch (Exception e6) {
                        return new Unavailable(e6.getMessage());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable
                public boolean isAvailable() {
                    return true;
                }
            }

            public interface Initializable {
                Dispatcher initialize();

                boolean isAvailable();
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unavailable implements Dispatcher, Initializable {
                private final String message;

                public Unavailable(String str) {
                    this.message = str;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher
                public Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("Could not access Unsafe class: " + this.message);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                }

                public int hashCode() {
                    return this.message.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable
                public Dispatcher initialize() {
                    throw new UnsupportedOperationException("Could not access Unsafe class: " + this.message);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable
                public boolean isAvailable() {
                    return false;
                }
            }

            Class<?> defineClass(@MaybeNull ClassLoader classLoader, String str, byte[] bArr, @MaybeNull ProtectionDomain protectionDomain);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Factory {
            private final Dispatcher.Initializable dispatcher;

            public interface AccessResolver {

                public enum Default implements AccessResolver {
                    INSTANCE;

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Factory.AccessResolver
                    public void apply(AccessibleObject accessibleObject) {
                        accessibleObject.setAccessible(true);
                    }
                }

                void apply(AccessibleObject accessibleObject);
            }

            public Factory() {
                this(AccessResolver.Default.INSTANCE);
            }

            public static Factory resolve(Instrumentation instrumentation) {
                return resolve(instrumentation, false);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.dispatcher.equals(((Factory) obj).dispatcher);
            }

            public int hashCode() {
                return this.dispatcher.hashCode() + (getClass().hashCode() * 31);
            }

            public boolean isAvailable() {
                return this.dispatcher.isAvailable();
            }

            public ClassInjector make(@MaybeNull ClassLoader classLoader) {
                return make(classLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
            }

            @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
            public Factory(AccessResolver accessResolver) {
                Dispatcher.Initializable unavailable;
                if (UsingUnsafe.DISPATCHER.isAvailable()) {
                    unavailable = UsingUnsafe.DISPATCHER;
                } else {
                    try {
                        Class<?> cls = Class.forName("jdk.internal.misc.Unsafe");
                        Field declaredField = cls.getDeclaredField("theUnsafe");
                        accessResolver.apply(declaredField);
                        Object obj = declaredField.get(null);
                        Class cls2 = Integer.TYPE;
                        Method method = cls.getMethod("defineClass", String.class, byte[].class, cls2, cls2, ClassLoader.class, ProtectionDomain.class);
                        accessResolver.apply(method);
                        unavailable = new Dispatcher.Enabled(obj, method);
                    } catch (Exception e) {
                        unavailable = new Dispatcher.Unavailable(e.getMessage());
                    }
                }
                this.dispatcher = unavailable;
            }

            @SuppressFBWarnings(justification = "Exception intends to trigger disabled injection strategy. Modules are assumed if module system is supported.", value = {"REC_CATCH_EXCEPTION", "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public static Factory resolve(Instrumentation instrumentation, boolean z6) {
                if (UsingUnsafe.isAvailable() || !JavaModule.isSupported()) {
                    return new Factory();
                }
                try {
                    Class<?> cls = Class.forName("jdk.internal.misc.Unsafe");
                    PackageDescription.ForLoadedPackage forLoadedPackage = new PackageDescription.ForLoadedPackage(cls.getPackage());
                    JavaModule javaModuleOfType = JavaModule.ofType(cls);
                    if (javaModuleOfType.isOpened(forLoadedPackage, JavaModule.ofType(UsingUnsafe.class))) {
                        return new Factory();
                    }
                    if (z6) {
                        JavaModule javaModuleOfType2 = JavaModule.ofType(AccessResolver.Default.class);
                        Set setSingleton = Collections.singleton(javaModuleOfType2);
                        Map map = Collections.EMPTY_MAP;
                        UsingInstrumentation.redefineModule(instrumentation, javaModuleOfType, setSingleton, map, Collections.singletonMap(forLoadedPackage.getName(), Collections.singleton(javaModuleOfType2)), Collections.EMPTY_SET, map);
                        return new Factory();
                    }
                    Class loaded = new ByteBuddy().subclass(AccessResolver.class).method(ElementMatchers.named("apply")).intercept(MethodCall.invoke(AccessibleObject.class.getMethod("setAccessible", Boolean.TYPE)).onArgument(0).with(Boolean.TRUE)).make().load(AccessResolver.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER.with(AccessResolver.class.getProtectionDomain())).getLoaded();
                    JavaModule javaModuleOfType3 = JavaModule.ofType(loaded);
                    Set setSingleton2 = Collections.singleton(javaModuleOfType3);
                    Map map2 = Collections.EMPTY_MAP;
                    UsingInstrumentation.redefineModule(instrumentation, javaModuleOfType, setSingleton2, map2, Collections.singletonMap(forLoadedPackage.getName(), Collections.singleton(javaModuleOfType3)), Collections.EMPTY_SET, map2);
                    return new Factory((AccessResolver) loaded.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception e) {
                    return new Factory(new Dispatcher.Unavailable(e.getMessage()));
                }
            }

            public ClassInjector make(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
                return new UsingUnsafe(classLoader, protectionDomain, this.dispatcher);
            }

            public Factory(Dispatcher.Initializable initializable) {
                this.dispatcher = initializable;
            }
        }

        @JavaDispatcher.Proxied("java.lang.System")
        public interface System {
            @JavaDispatcher.IsStatic
            @JavaDispatcher.Defaults
            @MaybeNull
            @JavaDispatcher.Proxied("getSecurityManager")
            Object getSecurityManager();
        }

        static {
            boolean z6 = false;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(java.lang.System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z6;
            } catch (SecurityException unused2) {
                z6 = true;
                ACCESS_CONTROLLER = z6;
            }
            DISPATCHER = (Dispatcher.Initializable) doPrivileged(Dispatcher.CreationAction.INSTANCE);
            SYSTEM = (System) doPrivileged(JavaDispatcher.of(System.class));
            CHECK_PERMISSION = (Method) doPrivileged(new GetMethodAction("java.lang.SecurityManager", "checkPermission", Permission.class));
            BOOTSTRAP_LOADER_LOCK = new Object();
        }

        public UsingUnsafe(@MaybeNull ClassLoader classLoader) {
            this(classLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofBootLoader() {
            return new UsingUnsafe(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        public static ClassInjector ofPlatformLoader() {
            return new UsingUnsafe(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassInjector ofSystemLoader() {
            return new UsingUnsafe(ClassLoader.getSystemClassLoader());
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
        
            if (r2 != null) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
        
            if (r2 != null) goto L26;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                r1 = 0
                if (r5 != 0) goto L8
                return r1
            L8:
                java.lang.Class r2 = r4.getClass()
                java.lang.Class r3 = r5.getClass()
                if (r2 == r3) goto L13
                return r1
            L13:
                java.lang.ClassLoader r2 = r4.classLoader
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe r5 = (net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe) r5
                java.lang.ClassLoader r3 = r5.classLoader
                if (r3 == 0) goto L24
                if (r2 == 0) goto L26
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L27
                return r1
            L24:
                if (r2 == 0) goto L27
            L26:
                return r1
            L27:
                java.security.ProtectionDomain r2 = r4.protectionDomain
                java.security.ProtectionDomain r3 = r5.protectionDomain
                if (r3 == 0) goto L36
                if (r2 == 0) goto L38
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L39
                return r1
            L36:
                if (r2 == 0) goto L39
            L38:
                return r1
            L39:
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable r2 = r4.dispatcher
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable r5 = r5.dispatcher
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L44
                return r1
            L44:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int iHashCode = getClass().hashCode() * 31;
            ClassLoader classLoader = this.classLoader;
            if (classLoader != null) {
                iHashCode += classLoader.hashCode();
            }
            int iHashCode2 = iHashCode * 31;
            ProtectionDomain protectionDomain = this.protectionDomain;
            if (protectionDomain != null) {
                iHashCode2 += protectionDomain.hashCode();
            }
            return this.dispatcher.hashCode() + (iHashCode2 * 31);
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map) {
            Dispatcher dispatcherInitialize = this.dispatcher.initialize();
            HashMap map2 = new HashMap();
            Object obj = this.classLoader;
            if (obj == null) {
                obj = BOOTSTRAP_LOADER_LOCK;
            }
            synchronized (obj) {
                for (Map.Entry<? extends String, byte[]> entry : map.entrySet()) {
                    try {
                        map2.put(entry.getKey(), Class.forName(entry.getKey(), false, this.classLoader));
                    } catch (ClassNotFoundException unused) {
                        map2.put(entry.getKey(), dispatcherInitialize.defineClass(this.classLoader, entry.getKey(), entry.getValue(), this.protectionDomain));
                    }
                }
            }
            return map2;
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public boolean isAlive() {
            return this.dispatcher.isAvailable();
        }

        public UsingUnsafe(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain) {
            this(classLoader, protectionDomain, DISPATCHER);
        }

        public UsingUnsafe(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain, Dispatcher.Initializable initializable) {
            this.classLoader = classLoader;
            this.protectionDomain = protectionDomain;
            this.dispatcher = initializable;
        }
    }

    Map<TypeDescription, Class<?>> inject(Map<? extends TypeDescription, byte[]> map);

    Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map);

    boolean isAlive();
}
