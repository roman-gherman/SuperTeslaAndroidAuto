package net.bytebuddy.agent;

import com.android.multidex.ClassPathElement;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import net.bytebuddy.agent.VirtualMachine;
import net.bytebuddy.agent.utility.nullability.AlwaysNull;
import net.bytebuddy.agent.utility.nullability.MaybeNull;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public class ByteBuddyAgent {
    private static final String AGENT_CLASS_PROPERTY = "Agent-Class";
    private static final String ATTACHER_FILE_NAME = "byteBuddyAttacher";
    private static final AttachmentTypeEvaluator ATTACHMENT_TYPE_EVALUATOR = (AttachmentTypeEvaluator) doPrivileged(AttachmentTypeEvaluator.InstallationAction.INSTANCE);

    @AlwaysNull
    private static final ClassLoader BOOTSTRAP_CLASS_LOADER = null;
    private static final int BUFFER_SIZE = 1024;

    @AlwaysNull
    private static final File CANNOT_SELF_RESOLVE = null;
    private static final String CAN_REDEFINE_CLASSES_PROPERTY = "Can-Redefine-Classes";
    private static final String CAN_RETRANSFORM_CLASSES_PROPERTY = "Can-Retransform-Classes";
    private static final String CAN_SET_NATIVE_METHOD_PREFIX = "Can-Set-Native-Method-Prefix";
    private static final String CLASS_FILE_EXTENSION = ".class";
    private static final String CLASS_PATH_ARGUMENT = "-cp";
    private static final int END_OF_FILE = -1;
    private static final String FILE_PROTOCOL = "file";
    private static final String INSTRUMENTATION_METHOD = "getInstrumentation";
    private static final String JAR_FILE_EXTENSION = ".jar";
    private static final String JAVA_HOME = "java.home";
    public static final String LATENT_RESOLVE = "net.bytebuddy.agent.latent";
    private static final String MANIFEST_VERSION_VALUE = "1.0";
    private static final String OS_NAME = "os.name";
    private static final int START_INDEX = 0;
    private static final int SUCCESSFUL_ATTACH = 0;

    @AlwaysNull
    private static final Instrumentation UNAVAILABLE = null;

    @AlwaysNull
    private static final String WITHOUT_ARGUMENT = null;

    public interface AgentProvider {

        public enum ForByteBuddyAgent implements AgentProvider {
            INSTANCE;

            private static final String AGENT_FILE_NAME = "byteBuddyAgent";

            private static File createJarFile() throws IOException {
                InputStream resourceAsStream = Installer.class.getResourceAsStream("/" + Installer.class.getName().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + ".class");
                if (resourceAsStream == null) {
                    throw new IllegalStateException("Cannot locate class file for Byte Buddy installer");
                }
                try {
                    File fileCreateTempFile = File.createTempFile(AGENT_FILE_NAME, ByteBuddyAgent.JAR_FILE_EXTENSION);
                    fileCreateTempFile.deleteOnExit();
                    Manifest manifest = new Manifest();
                    manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, ByteBuddyAgent.MANIFEST_VERSION_VALUE);
                    manifest.getMainAttributes().put(new Attributes.Name(ByteBuddyAgent.AGENT_CLASS_PROPERTY), Installer.class.getName());
                    Attributes mainAttributes = manifest.getMainAttributes();
                    Attributes.Name name = new Attributes.Name(ByteBuddyAgent.CAN_REDEFINE_CLASSES_PROPERTY);
                    Boolean bool = Boolean.TRUE;
                    mainAttributes.put(name, bool.toString());
                    manifest.getMainAttributes().put(new Attributes.Name(ByteBuddyAgent.CAN_RETRANSFORM_CLASSES_PROPERTY), bool.toString());
                    manifest.getMainAttributes().put(new Attributes.Name(ByteBuddyAgent.CAN_SET_NATIVE_METHOD_PREFIX), bool.toString());
                    JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(fileCreateTempFile), manifest);
                    try {
                        jarOutputStream.putNextEntry(new JarEntry(Installer.class.getName().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + ".class"));
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = resourceAsStream.read(bArr);
                            if (i == -1) {
                                jarOutputStream.closeEntry();
                                jarOutputStream.close();
                                return fileCreateTempFile;
                            }
                            jarOutputStream.write(bArr, 0, i);
                        }
                    } catch (Throwable th) {
                        jarOutputStream.close();
                        throw th;
                    }
                } finally {
                    resourceAsStream.close();
                }
            }

            @MaybeNull
            private static File trySelfResolve() throws IOException {
                CodeSource codeSource;
                File file;
                ProtectionDomain protectionDomain = Installer.class.getProtectionDomain();
                if (!Boolean.getBoolean(ByteBuddyAgent.LATENT_RESOLVE) && protectionDomain != null && (codeSource = protectionDomain.getCodeSource()) != null) {
                    URL location = codeSource.getLocation();
                    if (!location.getProtocol().equals(ByteBuddyAgent.FILE_PROTOCOL)) {
                        return ByteBuddyAgent.CANNOT_SELF_RESOLVE;
                    }
                    try {
                        file = new File(location.toURI());
                    } catch (URISyntaxException unused) {
                        file = new File(location.getPath());
                    }
                    if (!file.isFile() || !file.canRead()) {
                        return ByteBuddyAgent.CANNOT_SELF_RESOLVE;
                    }
                    JarInputStream jarInputStream = new JarInputStream(new FileInputStream(file));
                    try {
                        Manifest manifest = jarInputStream.getManifest();
                        if (manifest == null) {
                            return ByteBuddyAgent.CANNOT_SELF_RESOLVE;
                        }
                        Attributes mainAttributes = manifest.getMainAttributes();
                        return mainAttributes == null ? ByteBuddyAgent.CANNOT_SELF_RESOLVE : (Installer.class.getName().equals(mainAttributes.getValue(ByteBuddyAgent.AGENT_CLASS_PROPERTY)) && Boolean.parseBoolean(mainAttributes.getValue(ByteBuddyAgent.CAN_REDEFINE_CLASSES_PROPERTY)) && Boolean.parseBoolean(mainAttributes.getValue(ByteBuddyAgent.CAN_RETRANSFORM_CLASSES_PROPERTY)) && Boolean.parseBoolean(mainAttributes.getValue(ByteBuddyAgent.CAN_SET_NATIVE_METHOD_PREFIX))) ? file : ByteBuddyAgent.CANNOT_SELF_RESOLVE;
                    } finally {
                        jarInputStream.close();
                    }
                }
                return ByteBuddyAgent.CANNOT_SELF_RESOLVE;
            }

            @Override // net.bytebuddy.agent.ByteBuddyAgent.AgentProvider
            public File resolve() {
                try {
                    File fileTrySelfResolve = trySelfResolve();
                    return fileTrySelfResolve == null ? createJarFile() : fileTrySelfResolve;
                } catch (Exception unused) {
                    return createJarFile();
                }
            }
        }

        public static class ForExistingAgent implements AgentProvider {
            private final File agent;

            public ForExistingAgent(File file) {
                this.agent = file;
            }

            @Override // net.bytebuddy.agent.ByteBuddyAgent.AgentProvider
            public File resolve() {
                return this.agent;
            }
        }

        File resolve();
    }

    @SuppressFBWarnings(justification = "Safe initialization is implied", value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"})
    public interface AttachmentProvider {
        public static final AttachmentProvider DEFAULT = new Compound(ForModularizedVm.INSTANCE, ForJ9Vm.INSTANCE, ForStandardToolsJarVm.JVM_ROOT, ForStandardToolsJarVm.JDK_ROOT, ForStandardToolsJarVm.MACINTOSH, ForUserDefinedToolsJar.INSTANCE, ForEmulatedAttachment.INSTANCE);

        public interface Accessor {
            public static final String VIRTUAL_MACHINE_TYPE_NAME = "com.sun.tools.attach.VirtualMachine";
            public static final String VIRTUAL_MACHINE_TYPE_NAME_J9 = "com.ibm.tools.attach.VirtualMachine";

            public static class ExternalAttachment {
                private final List<File> classPath;
                private final String virtualMachineType;

                public ExternalAttachment(String str, List<File> list) {
                    this.virtualMachineType = str;
                    this.classPath = list;
                }

                public List<File> getClassPath() {
                    return this.classPath;
                }

                public String getVirtualMachineType() {
                    return this.virtualMachineType;
                }
            }

            public static abstract class Simple implements Accessor {
                protected final Class<?> virtualMachineType;

                public static class WithDirectAttachment extends Simple {
                    public WithDirectAttachment(Class<?> cls) {
                        super(cls);
                    }

                    @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor
                    public ExternalAttachment getExternalAttachment() {
                        throw new IllegalStateException("Cannot apply external attachment");
                    }

                    @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor
                    public boolean isExternalAttachmentRequired() {
                        return false;
                    }
                }

                public static class WithExternalAttachment extends Simple {
                    private final List<File> classPath;

                    public WithExternalAttachment(Class<?> cls, List<File> list) {
                        super(cls);
                        this.classPath = list;
                    }

                    @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor
                    public ExternalAttachment getExternalAttachment() {
                        return new ExternalAttachment(this.virtualMachineType.getName(), this.classPath);
                    }

                    @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor
                    public boolean isExternalAttachmentRequired() {
                        return true;
                    }
                }

                public Simple(Class<?> cls) {
                    this.virtualMachineType = cls;
                }

                public static Accessor of(@MaybeNull ClassLoader classLoader, File... fileArr) {
                    try {
                        return new WithExternalAttachment(Class.forName(Accessor.VIRTUAL_MACHINE_TYPE_NAME, false, classLoader), Arrays.asList(fileArr));
                    } catch (ClassNotFoundException unused) {
                        return Unavailable.INSTANCE;
                    }
                }

                public static Accessor ofJ9() {
                    try {
                        return new WithExternalAttachment(ClassLoader.getSystemClassLoader().loadClass(Accessor.VIRTUAL_MACHINE_TYPE_NAME_J9), Collections.EMPTY_LIST);
                    } catch (ClassNotFoundException unused) {
                        return Unavailable.INSTANCE;
                    }
                }

                @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor
                public Class<?> getVirtualMachineType() {
                    return this.virtualMachineType;
                }

                @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor
                public boolean isAvailable() {
                    return true;
                }
            }

            public enum Unavailable implements Accessor {
                INSTANCE;

                @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor
                public ExternalAttachment getExternalAttachment() {
                    throw new IllegalStateException("Cannot read the virtual machine type for an unavailable accessor");
                }

                @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor
                public Class<?> getVirtualMachineType() {
                    throw new IllegalStateException("Cannot read the virtual machine type for an unavailable accessor");
                }

                @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor
                public boolean isAvailable() {
                    return false;
                }

                @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.Accessor
                public boolean isExternalAttachmentRequired() {
                    throw new IllegalStateException("Cannot read the virtual machine type for an unavailable accessor");
                }
            }

            ExternalAttachment getExternalAttachment();

            Class<?> getVirtualMachineType();

            boolean isAvailable();

            boolean isExternalAttachmentRequired();
        }

        public static class Compound implements AttachmentProvider {
            private final List<AttachmentProvider> attachmentProviders;

            public Compound(AttachmentProvider... attachmentProviderArr) {
                this((List<? extends AttachmentProvider>) Arrays.asList(attachmentProviderArr));
            }

            @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider
            public Accessor attempt() {
                Iterator<AttachmentProvider> it = this.attachmentProviders.iterator();
                while (it.hasNext()) {
                    Accessor accessorAttempt = it.next().attempt();
                    if (accessorAttempt.isAvailable()) {
                        return accessorAttempt;
                    }
                }
                return Accessor.Unavailable.INSTANCE;
            }

            public Compound(List<? extends AttachmentProvider> list) {
                this.attachmentProviders = new ArrayList();
                for (AttachmentProvider attachmentProvider : list) {
                    if (attachmentProvider instanceof Compound) {
                        this.attachmentProviders.addAll(((Compound) attachmentProvider).attachmentProviders);
                    } else {
                        this.attachmentProviders.add(attachmentProvider);
                    }
                }
            }
        }

        public enum ForEmulatedAttachment implements AttachmentProvider {
            INSTANCE;

            @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider
            public Accessor attempt() {
                try {
                    return new Accessor.Simple.WithDirectAttachment((Class) ByteBuddyAgent.doPrivileged(VirtualMachine.Resolver.INSTANCE));
                } catch (Throwable unused) {
                    return Accessor.Unavailable.INSTANCE;
                }
            }
        }

        public enum ForJ9Vm implements AttachmentProvider {
            INSTANCE;

            @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider
            public Accessor attempt() {
                return Accessor.Simple.ofJ9();
            }
        }

        public enum ForModularizedVm implements AttachmentProvider {
            INSTANCE;

            @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider
            public Accessor attempt() {
                return Accessor.Simple.of(ClassLoader.getSystemClassLoader(), new File[0]);
            }
        }

        public enum ForStandardToolsJarVm implements AttachmentProvider {
            JVM_ROOT("../lib/tools.jar"),
            JDK_ROOT("lib/tools.jar"),
            MACINTOSH("../Classes/classes.jar");

            private static final String JAVA_HOME_PROPERTY = "java.home";
            private final String toolsJarPath;

            ForStandardToolsJarVm(String str) {
                this.toolsJarPath = str;
            }

            @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider
            @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
            public Accessor attempt() {
                File file = new File(System.getProperty(JAVA_HOME_PROPERTY), this.toolsJarPath);
                try {
                    return (file.isFile() && file.canRead()) ? Accessor.Simple.of(new URLClassLoader(new URL[]{file.toURI().toURL()}, ByteBuddyAgent.BOOTSTRAP_CLASS_LOADER), file) : Accessor.Unavailable.INSTANCE;
                } catch (MalformedURLException unused) {
                    throw new IllegalStateException("Could not represent " + file + " as URL");
                }
            }
        }

        public enum ForUserDefinedToolsJar implements AttachmentProvider {
            INSTANCE;

            public static final String PROPERTY = "net.bytebuddy.agent.toolsjar";

            @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider
            @SuppressFBWarnings(justification = "Assuring privilege is explicit user responsibility.", value = {"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
            public Accessor attempt() {
                String property = System.getProperty(PROPERTY);
                if (property == null) {
                    return Accessor.Unavailable.INSTANCE;
                }
                File file = new File(property);
                try {
                    return Accessor.Simple.of(new URLClassLoader(new URL[]{file.toURI().toURL()}, ByteBuddyAgent.BOOTSTRAP_CLASS_LOADER), file);
                } catch (MalformedURLException unused) {
                    throw new IllegalStateException("Could not represent " + file + " as URL");
                }
            }
        }

        Accessor attempt();
    }

    public interface AttachmentTypeEvaluator {

        public enum Disabled implements AttachmentTypeEvaluator {
            INSTANCE;

            @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentTypeEvaluator
            public boolean requiresExternalAttachment(String str) {
                return false;
            }
        }

        public static class ForJava9CapableVm implements AttachmentTypeEvaluator {
            private final Method current;
            private final Method pid;

            public ForJava9CapableVm(Method method, Method method2) {
                this.current = method;
                this.pid = method2;
            }

            @Override // net.bytebuddy.agent.ByteBuddyAgent.AttachmentTypeEvaluator
            public boolean requiresExternalAttachment(String str) {
                try {
                    return this.pid.invoke(this.current.invoke(null, new Object[0]), new Object[0]).toString().equals(str);
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException("Cannot access Java 9 process API", e);
                } catch (InvocationTargetException e6) {
                    throw new IllegalStateException("Error when accessing Java 9 process API", e6.getTargetException());
                }
            }
        }

        public enum InstallationAction implements PrivilegedAction<AttachmentTypeEvaluator> {
            INSTANCE;

            private static final String JDK_ALLOW_SELF_ATTACH = "jdk.attach.allowAttachSelf";

            @Override // java.security.PrivilegedAction
            @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
            public AttachmentTypeEvaluator run() {
                try {
                    return Boolean.getBoolean(JDK_ALLOW_SELF_ATTACH) ? Disabled.INSTANCE : new ForJava9CapableVm(Class.forName("java.lang.ProcessHandle").getMethod("current", new Class[0]), Class.forName("java.lang.ProcessHandle").getMethod("pid", new Class[0]));
                } catch (Exception unused) {
                    return Disabled.INSTANCE;
                }
            }
        }

        boolean requiresExternalAttachment(String str);
    }

    public interface ProcessProvider {

        public enum ForCurrentVm implements ProcessProvider {
            INSTANCE;

            private final ProcessProvider dispatcher = ForJava9CapableVm.make();

            public static class ForJava9CapableVm implements ProcessProvider {
                private final Method current;
                private final Method pid;

                public ForJava9CapableVm(Method method, Method method2) {
                    this.current = method;
                    this.pid = method2;
                }

                @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
                public static ProcessProvider make() {
                    try {
                        return new ForJava9CapableVm(Class.forName("java.lang.ProcessHandle").getMethod("current", new Class[0]), Class.forName("java.lang.ProcessHandle").getMethod("pid", new Class[0]));
                    } catch (Exception unused) {
                        return ForLegacyVm.INSTANCE;
                    }
                }

                @Override // net.bytebuddy.agent.ByteBuddyAgent.ProcessProvider
                public String resolve() {
                    try {
                        return this.pid.invoke(this.current.invoke(null, new Object[0]), new Object[0]).toString();
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException("Cannot access Java 9 process API", e);
                    } catch (InvocationTargetException e6) {
                        throw new IllegalStateException("Error when accessing Java 9 process API", e6.getTargetException());
                    }
                }
            }

            public enum ForLegacyVm implements ProcessProvider {
                INSTANCE;

                @Override // net.bytebuddy.agent.ByteBuddyAgent.ProcessProvider
                @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
                public String resolve() {
                    try {
                        Method method = Class.forName("java.lang.management.ManagementFactory").getMethod("getRuntimeMXBean", new Class[0]);
                        String str = (String) method.getReturnType().getMethod("getName", new Class[0]).invoke(method.invoke(null, new Object[0]), new Object[0]);
                        int iIndexOf = str.indexOf(64);
                        if (iIndexOf != -1) {
                            return str.substring(0, iIndexOf);
                        }
                        throw new IllegalStateException("Cannot extract process id from runtime management bean");
                    } catch (Exception e) {
                        throw new IllegalStateException("Failed to access VM name via management factory", e);
                    }
                }
            }

            ForCurrentVm() {
            }

            @Override // net.bytebuddy.agent.ByteBuddyAgent.ProcessProvider
            public String resolve() {
                return this.dispatcher.resolve();
            }
        }

        String resolve();
    }

    private ByteBuddyAgent() {
        throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
    }

    public static void attach(File file, String str) {
        attach(file, str, WITHOUT_ARGUMENT);
    }

    public static void attachNative(File file, String str) {
        attachNative(file, str, WITHOUT_ARGUMENT);
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
    @MaybeNull
    private static Instrumentation doGetInstrumentation() {
        try {
            Class<?> cls = Class.forName(Installer.class.getName(), true, ClassLoader.getSystemClassLoader());
            try {
                Class<?> cls2 = Class.forName("java.lang.Module");
                Method method = Class.class.getMethod("getModule", new Class[0]);
                Object objInvoke = method.invoke(ByteBuddyAgent.class, new Object[0]);
                Object objInvoke2 = method.invoke(cls, new Object[0]);
                if (!((Boolean) cls2.getMethod("canRead", cls2).invoke(objInvoke, objInvoke2)).booleanValue()) {
                    cls2.getMethod("addReads", cls2).invoke(objInvoke, objInvoke2);
                }
            } catch (ClassNotFoundException unused) {
            }
            return (Instrumentation) Class.forName(Installer.class.getName(), true, ClassLoader.getSystemClassLoader()).getMethod(INSTRUMENTATION_METHOD, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused2) {
            return UNAVAILABLE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        try {
            return (T) Class.forName("java.security.AccessController").getMethod("doPrivileged", PrivilegedAction.class).invoke(null, privilegedAction);
        } catch (ClassNotFoundException unused) {
            return privilegedAction.run();
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Failed to access access controller", e);
        } catch (NoSuchMethodException e6) {
            throw new IllegalStateException("Failed to resolve well-known access controller method", e6);
        } catch (InvocationTargetException e7) {
            throw new IllegalStateException("Failed to invoke access controller", e7.getTargetException());
        }
    }

    public static Instrumentation getInstrumentation() {
        Instrumentation instrumentationDoGetInstrumentation = doGetInstrumentation();
        if (instrumentationDoGetInstrumentation != null) {
            return instrumentationDoGetInstrumentation;
        }
        throw new IllegalStateException("The Byte Buddy agent is not initialized or unavailable");
    }

    public static Instrumentation install() {
        return install(AttachmentProvider.DEFAULT);
    }

    private static void installExternal(AttachmentProvider.Accessor.ExternalAttachment externalAttachment, String str, File file, boolean z6, @MaybeNull String str2) {
        File fileTrySelfResolve = trySelfResolve();
        File fileCreateTempFile = null;
        if (fileTrySelfResolve == null) {
            try {
                InputStream resourceAsStream = Attacher.class.getResourceAsStream("/" + Attacher.class.getName().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + ".class");
                if (resourceAsStream == null) {
                    throw new IllegalStateException("Cannot locate class file for Byte Buddy installation process");
                }
                try {
                    fileCreateTempFile = File.createTempFile(ATTACHER_FILE_NAME, JAR_FILE_EXTENSION);
                    JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(fileCreateTempFile));
                    try {
                        jarOutputStream.putNextEntry(new JarEntry(Attacher.class.getName().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + ".class"));
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = resourceAsStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                jarOutputStream.write(bArr, 0, i);
                            }
                        }
                        jarOutputStream.closeEntry();
                        jarOutputStream.close();
                    } finally {
                        jarOutputStream.close();
                    }
                } finally {
                    resourceAsStream.close();
                }
            } finally {
                if (fileCreateTempFile != null && !fileCreateTempFile.delete()) {
                    fileCreateTempFile.deleteOnExit();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (fileTrySelfResolve == null) {
            fileTrySelfResolve = fileCreateTempFile;
        }
        sb.append(fileTrySelfResolve.getCanonicalPath());
        for (File file2 : externalAttachment.getClassPath()) {
            sb.append(File.pathSeparatorChar);
            sb.append(file2.getCanonicalPath());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.getProperty(JAVA_HOME));
        char c = File.separatorChar;
        sb2.append(c);
        sb2.append("bin");
        sb2.append(c);
        sb2.append(System.getProperty(OS_NAME, "").toLowerCase(Locale.US).contains("windows") ? "java.exe" : "java");
        if (new ProcessBuilder(sb2.toString(), CLASS_PATH_ARGUMENT, sb.toString(), Attacher.class.getName(), externalAttachment.getVirtualMachineType(), str, file.getAbsolutePath(), Boolean.toString(z6), str2 != null ? "=" + str2 : "").start().waitFor() != 0) {
            throw new IllegalStateException("Could not self-attach to current VM using external process");
        }
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
    @MaybeNull
    private static File trySelfResolve() {
        ProtectionDomain protectionDomain;
        CodeSource codeSource;
        try {
            if (!Boolean.getBoolean(LATENT_RESOLVE) && (protectionDomain = Attacher.class.getProtectionDomain()) != null && (codeSource = protectionDomain.getCodeSource()) != null) {
                URL location = codeSource.getLocation();
                if (!location.getProtocol().equals(FILE_PROTOCOL)) {
                    return CANNOT_SELF_RESOLVE;
                }
                try {
                    return new File(location.toURI());
                } catch (URISyntaxException unused) {
                    return new File(location.getPath());
                }
            }
            return CANNOT_SELF_RESOLVE;
        } catch (Exception unused2) {
            return CANNOT_SELF_RESOLVE;
        }
    }

    public static void attach(File file, String str, @MaybeNull String str2) {
        attach(file, str, str2, AttachmentProvider.DEFAULT);
    }

    public static void attachNative(File file, String str, @MaybeNull String str2) {
        attachNative(file, str, str2, AttachmentProvider.DEFAULT);
    }

    public static Instrumentation install(AttachmentProvider attachmentProvider) {
        return install(attachmentProvider, ProcessProvider.ForCurrentVm.INSTANCE);
    }

    public static void attach(File file, String str, AttachmentProvider attachmentProvider) {
        attach(file, str, WITHOUT_ARGUMENT, attachmentProvider);
    }

    public static void attachNative(File file, String str, AttachmentProvider attachmentProvider) {
        attachNative(file, str, WITHOUT_ARGUMENT, attachmentProvider);
    }

    public static Instrumentation install(ProcessProvider processProvider) {
        return install(AttachmentProvider.DEFAULT, processProvider);
    }

    public static void attach(File file, String str, @MaybeNull String str2, AttachmentProvider attachmentProvider) {
        install(attachmentProvider, str, str2, new AgentProvider.ForExistingAgent(file), false);
    }

    public static void attachNative(File file, String str, @MaybeNull String str2, AttachmentProvider attachmentProvider) {
        install(attachmentProvider, str, str2, new AgentProvider.ForExistingAgent(file), true);
    }

    public static synchronized Instrumentation install(AttachmentProvider attachmentProvider, ProcessProvider processProvider) {
        Instrumentation instrumentationDoGetInstrumentation = doGetInstrumentation();
        if (instrumentationDoGetInstrumentation != null) {
            return instrumentationDoGetInstrumentation;
        }
        install(attachmentProvider, processProvider.resolve(), WITHOUT_ARGUMENT, AgentProvider.ForByteBuddyAgent.INSTANCE, false);
        return getInstrumentation();
    }

    public static void attach(File file, ProcessProvider processProvider) {
        attach(file, processProvider, WITHOUT_ARGUMENT);
    }

    public static void attachNative(File file, ProcessProvider processProvider) {
        attachNative(file, processProvider, WITHOUT_ARGUMENT);
    }

    public static void attach(File file, ProcessProvider processProvider, @MaybeNull String str) {
        attach(file, processProvider, str, AttachmentProvider.DEFAULT);
    }

    public static void attachNative(File file, ProcessProvider processProvider, @MaybeNull String str) {
        attachNative(file, processProvider, str, AttachmentProvider.DEFAULT);
    }

    public static void attach(File file, ProcessProvider processProvider, AttachmentProvider attachmentProvider) {
        attach(file, processProvider, WITHOUT_ARGUMENT, attachmentProvider);
    }

    public static void attachNative(File file, ProcessProvider processProvider, AttachmentProvider attachmentProvider) {
        attachNative(file, processProvider, WITHOUT_ARGUMENT, attachmentProvider);
    }

    public static void attach(File file, ProcessProvider processProvider, @MaybeNull String str, AttachmentProvider attachmentProvider) {
        install(attachmentProvider, processProvider.resolve(), str, new AgentProvider.ForExistingAgent(file), false);
    }

    public static void attachNative(File file, ProcessProvider processProvider, @MaybeNull String str, AttachmentProvider attachmentProvider) {
        install(attachmentProvider, processProvider.resolve(), str, new AgentProvider.ForExistingAgent(file), true);
    }

    private static void install(AttachmentProvider attachmentProvider, String str, @MaybeNull String str2, AgentProvider agentProvider, boolean z6) {
        AttachmentProvider.Accessor accessorAttempt = attachmentProvider.attempt();
        if (accessorAttempt.isAvailable()) {
            try {
                if (accessorAttempt.isExternalAttachmentRequired() && ATTACHMENT_TYPE_EVALUATOR.requiresExternalAttachment(str)) {
                    installExternal(accessorAttempt.getExternalAttachment(), str, agentProvider.resolve(), z6, str2);
                    return;
                } else {
                    Attacher.install(accessorAttempt.getVirtualMachineType(), str, agentProvider.resolve().getAbsolutePath(), z6, str2);
                    return;
                }
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e6) {
                throw new IllegalStateException("Error during attachment using: " + attachmentProvider, e6);
            }
        }
        throw new IllegalStateException("No compatible attachment provider is available");
    }
}
