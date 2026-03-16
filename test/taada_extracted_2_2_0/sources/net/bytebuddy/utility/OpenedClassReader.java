package net.bytebuddy.utility;

import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

/* JADX INFO: loaded from: classes2.dex */
public class OpenedClassReader {
    private static final boolean ACCESS_CONTROLLER;
    public static final int ASM_API;
    public static final boolean EXPERIMENTAL;
    public static final String EXPERIMENTAL_PROPERTY = "net.bytebuddy.experimental";

    static {
        boolean z6 = false;
        try {
            Class.forName("java.security.AccessController", false, null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = false;
        } catch (SecurityException unused2) {
            ACCESS_CONTROLLER = true;
        }
        try {
            z6 = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(EXPERIMENTAL_PROPERTY)));
        } catch (Exception unused3) {
        }
        EXPERIMENTAL = z6;
        ASM_API = Opcodes.ASM9;
    }

    private OpenedClassReader() {
        throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static ClassReader of(byte[] bArr) {
        ClassFileVersion classFileVersionOfClassFile = ClassFileVersion.ofClassFile(bArr);
        ClassFileVersion classFileVersionLatest = ClassFileVersion.latest();
        if (!classFileVersionOfClassFile.isGreaterThan(classFileVersionLatest)) {
            return new ClassReader(bArr);
        }
        if (EXPERIMENTAL) {
            bArr[6] = (byte) (classFileVersionLatest.getMajorVersion() >>> 8);
            bArr[7] = (byte) classFileVersionLatest.getMajorVersion();
            ClassReader classReader = new ClassReader(bArr);
            bArr[6] = (byte) (classFileVersionOfClassFile.getMajorVersion() >>> 8);
            bArr[7] = (byte) classFileVersionOfClassFile.getMajorVersion();
            return classReader;
        }
        throw new IllegalArgumentException(classFileVersionOfClassFile + " is not supported by the current version of Byte Buddy which officially supports " + classFileVersionLatest + " - update Byte Buddy or set net.bytebuddy.experimental as a VM property");
    }
}
