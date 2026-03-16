package net.bytebuddy;

import B2.b;
import com.android.dx.Version;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class ClassFileVersion implements Comparable<ClassFileVersion>, Serializable {
    private static final boolean ACCESS_CONTROLLER;
    protected static final int BASE_VERSION = 44;
    public static final ClassFileVersion JAVA_V1;
    public static final ClassFileVersion JAVA_V10;
    public static final ClassFileVersion JAVA_V11;
    public static final ClassFileVersion JAVA_V12;
    public static final ClassFileVersion JAVA_V13;
    public static final ClassFileVersion JAVA_V14;
    public static final ClassFileVersion JAVA_V15;
    public static final ClassFileVersion JAVA_V16;
    public static final ClassFileVersion JAVA_V17;
    public static final ClassFileVersion JAVA_V18;
    public static final ClassFileVersion JAVA_V19;
    public static final ClassFileVersion JAVA_V2;
    public static final ClassFileVersion JAVA_V20;
    public static final ClassFileVersion JAVA_V3;
    public static final ClassFileVersion JAVA_V4;
    public static final ClassFileVersion JAVA_V5;
    public static final ClassFileVersion JAVA_V6;
    public static final ClassFileVersion JAVA_V7;
    public static final ClassFileVersion JAVA_V8;
    public static final ClassFileVersion JAVA_V9;
    private static final VersionLocator VERSION_LOCATOR;
    private static final long serialVersionUID = 1;
    private final int versionNumber;

    public interface VersionLocator {
        public static final String EARLY_ACCESS = "-ea";
        public static final String JAVA_VERSION = "java.version";

        @HashCodeAndEqualsPlugin.Enhance
        public static class Resolved implements VersionLocator {
            private final ClassFileVersion classFileVersion;

            public Resolved(ClassFileVersion classFileVersion) {
                this.classFileVersion = classFileVersion;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.classFileVersion.equals(((Resolved) obj).classFileVersion);
            }

            public int hashCode() {
                return this.classFileVersion.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.ClassFileVersion.VersionLocator
            public ClassFileVersion resolve() {
                return this.classFileVersion;
            }
        }

        public enum Resolver implements PrivilegedAction<VersionLocator> {
            INSTANCE;

            @Override // java.security.PrivilegedAction
            @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
            public VersionLocator run() {
                Method method;
                try {
                    Class<?> cls = Class.forName(Runtime.class.getName().concat("$Version"));
                    try {
                        try {
                            method = cls.getMethod("feature", new Class[0]);
                        } catch (NoSuchMethodException unused) {
                            method = cls.getMethod("major", new Class[0]);
                        }
                        return new Resolved(ClassFileVersion.ofJavaVersion(((Integer) method.invoke(Runtime.class.getMethod("version", new Class[0]).invoke(null, new Object[0]), new Object[0])).intValue()));
                    } catch (Throwable th) {
                        return new Unresolved(th.getMessage());
                    }
                } catch (Throwable unused2) {
                    String property = System.getProperty(VersionLocator.JAVA_VERSION);
                    if (property == null) {
                        throw new IllegalStateException("Java version property is not set");
                    }
                    if (property.equals("0")) {
                        return new Resolved(ClassFileVersion.JAVA_V6);
                    }
                    if (property.endsWith(VersionLocator.EARLY_ACCESS)) {
                        property = property.substring(0, property.length() - 3);
                    }
                    int[] iArr = new int[3];
                    iArr[0] = -1;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    for (int i = 1; i < 3; i++) {
                        int iIndexOf = property.indexOf(46, iArr[i - 1] + 1);
                        iArr[i] = iIndexOf;
                        if (iIndexOf == -1) {
                            throw new IllegalStateException("This JVM's version string does not seem to be valid: " + property);
                        }
                    }
                    return new Resolved(ClassFileVersion.ofJavaVersion(Integer.parseInt(property.substring(iArr[1] + 1, iArr[2]))));
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Unresolved implements VersionLocator {
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

            @Override // net.bytebuddy.ClassFileVersion.VersionLocator
            public ClassFileVersion resolve() {
                throw new IllegalStateException("Failed to resolve the class file version of the current VM: " + this.message);
            }
        }

        ClassFileVersion resolve();
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
        JAVA_V1 = new ClassFileVersion(Opcodes.V1_1);
        JAVA_V2 = new ClassFileVersion(46);
        JAVA_V3 = new ClassFileVersion(47);
        JAVA_V4 = new ClassFileVersion(48);
        JAVA_V5 = new ClassFileVersion(49);
        JAVA_V6 = new ClassFileVersion(50);
        JAVA_V7 = new ClassFileVersion(51);
        JAVA_V8 = new ClassFileVersion(52);
        JAVA_V9 = new ClassFileVersion(53);
        JAVA_V10 = new ClassFileVersion(54);
        JAVA_V11 = new ClassFileVersion(55);
        JAVA_V12 = new ClassFileVersion(56);
        JAVA_V13 = new ClassFileVersion(57);
        JAVA_V14 = new ClassFileVersion(58);
        JAVA_V15 = new ClassFileVersion(59);
        JAVA_V16 = new ClassFileVersion(60);
        JAVA_V17 = new ClassFileVersion(61);
        JAVA_V18 = new ClassFileVersion(62);
        JAVA_V19 = new ClassFileVersion(63);
        JAVA_V20 = new ClassFileVersion(64);
        VERSION_LOCATOR = (VersionLocator) doPrivileged(VersionLocator.Resolver.INSTANCE);
    }

    public ClassFileVersion(int i) {
        this.versionNumber = i;
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static ClassFileVersion latest() {
        return JAVA_V20;
    }

    public static ClassFileVersion of(Class<?> cls) {
        return of(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public static ClassFileVersion ofClassFile(byte[] bArr) {
        if (bArr.length < 7) {
            throw new IllegalArgumentException(b.g(new StringBuilder("Supplied byte array is too short to be a class file with "), " byte", bArr.length));
        }
        return ofMinorMajor((bArr[7] & 255) | (bArr[6] << 8));
    }

    public static ClassFileVersion ofJavaVersion(int i) {
        switch (i) {
            case 1:
                return JAVA_V1;
            case 2:
                return JAVA_V2;
            case 3:
                return JAVA_V3;
            case 4:
                return JAVA_V4;
            case 5:
                return JAVA_V5;
            case 6:
                return JAVA_V6;
            case 7:
                return JAVA_V7;
            case 8:
                return JAVA_V8;
            case 9:
                return JAVA_V9;
            case 10:
                return JAVA_V10;
            case 11:
                return JAVA_V11;
            case 12:
                return JAVA_V12;
            case 13:
                return JAVA_V13;
            case 14:
                return JAVA_V14;
            case 15:
                return JAVA_V15;
            case 16:
                return JAVA_V16;
            case 17:
                return JAVA_V17;
            case 18:
                return JAVA_V18;
            case 19:
                return JAVA_V19;
            case 20:
                return JAVA_V20;
            default:
                if (!OpenedClassReader.EXPERIMENTAL || i <= 0) {
                    throw new IllegalArgumentException(b.c(i, "Unknown Java version: "));
                }
                return new ClassFileVersion(i + 44);
        }
    }

    public static ClassFileVersion ofJavaVersionString(String str) {
        if (str.equals("1.1")) {
            return JAVA_V1;
        }
        if (str.equals("1.2")) {
            return JAVA_V2;
        }
        if (str.equals("1.3")) {
            return JAVA_V3;
        }
        if (str.equals("1.4")) {
            return JAVA_V4;
        }
        if (str.equals("1.5") || str.equals("5")) {
            return JAVA_V5;
        }
        if (str.equals("1.6") || str.equals("6")) {
            return JAVA_V6;
        }
        if (str.equals("1.7") || str.equals("7")) {
            return JAVA_V7;
        }
        if (str.equals("1.8") || str.equals("8")) {
            return JAVA_V8;
        }
        if (str.equals("1.9") || str.equals("9")) {
            return JAVA_V9;
        }
        if (str.equals("1.10") || str.equals("10")) {
            return JAVA_V10;
        }
        if (str.equals("1.11") || str.equals("11")) {
            return JAVA_V11;
        }
        if (str.equals("1.12") || str.equals("12")) {
            return JAVA_V12;
        }
        if (str.equals("1.13") || str.equals("13")) {
            return JAVA_V13;
        }
        if (str.equals("1.14") || str.equals("14")) {
            return JAVA_V14;
        }
        if (str.equals("1.15") || str.equals("15")) {
            return JAVA_V15;
        }
        if (str.equals(Version.VERSION) || str.equals("16")) {
            return JAVA_V16;
        }
        if (str.equals("1.17") || str.equals("17")) {
            return JAVA_V17;
        }
        if (str.equals("1.18") || str.equals("18")) {
            return JAVA_V18;
        }
        if (str.equals("1.19") || str.equals("19")) {
            return JAVA_V19;
        }
        if (str.equals("1.20") || str.equals("20")) {
            return JAVA_V20;
        }
        if (OpenedClassReader.EXPERIMENTAL) {
            try {
                int i = Integer.parseInt(str.startsWith("1.") ? str.substring(2) : str);
                if (i > 0) {
                    return new ClassFileVersion(i + 44);
                }
            } catch (NumberFormatException unused) {
            }
        }
        throw new IllegalArgumentException("Unknown Java version string: ".concat(str));
    }

    public static ClassFileVersion ofMinorMajor(int i) {
        ClassFileVersion classFileVersion = new ClassFileVersion(i);
        if (classFileVersion.getMajorVersion() > 44) {
            return classFileVersion;
        }
        throw new IllegalArgumentException(b.d(i, "Class version ", " is not valid"));
    }

    public static ClassFileVersion ofThisVm() {
        return VERSION_LOCATOR.resolve();
    }

    public ClassFileVersion asPreviewVersion() {
        return new ClassFileVersion(this.versionNumber | (-65536));
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.versionNumber == ((ClassFileVersion) obj).versionNumber;
    }

    public int getJavaVersion() {
        return getMajorVersion() - 44;
    }

    public short getMajorVersion() {
        return (short) (this.versionNumber & 255);
    }

    public int getMinorMajorVersion() {
        return this.versionNumber;
    }

    public short getMinorVersion() {
        return (short) (this.versionNumber >> 16);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.versionNumber;
    }

    public boolean isAtLeast(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) > -1;
    }

    public boolean isAtMost(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) < 1;
    }

    public boolean isGreaterThan(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) > 0;
    }

    public boolean isLessThan(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) < 0;
    }

    public boolean isPreviewVersion() {
        return (this.versionNumber & (-65536)) == -65536;
    }

    public String toString() {
        return "Java " + getJavaVersion() + " (" + getMinorMajorVersion() + ")";
    }

    public static ClassFileVersion of(Class<?> cls, ClassFileLocator classFileLocator) {
        return of(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
    public static ClassFileVersion ofThisVm(ClassFileVersion classFileVersion) {
        try {
            return ofThisVm();
        } catch (Exception unused) {
            return classFileVersion;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassFileVersion classFileVersion) {
        short majorVersion;
        short majorVersion2;
        if (getMajorVersion() == classFileVersion.getMajorVersion()) {
            majorVersion = getMinorVersion();
            majorVersion2 = classFileVersion.getMinorVersion();
        } else {
            majorVersion = getMajorVersion();
            majorVersion2 = classFileVersion.getMajorVersion();
        }
        return Integer.signum(majorVersion - majorVersion2);
    }

    public static ClassFileVersion of(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return ofClassFile(classFileLocator.locate(typeDescription.getName()).resolve());
    }
}
