package net.bytebuddy.agent;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.security.Permission;
import net.bytebuddy.agent.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public class Installer {

    @MaybeNull
    private static volatile Instrumentation instrumentation;

    private Installer() {
        throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
    }

    public static void agentmain(String str, Instrumentation instrumentation2) {
        instrumentation = instrumentation2;
    }

    public static Instrumentation getInstrumentation() {
        try {
            Object objInvoke = System.class.getMethod("getSecurityManager", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke != null) {
                Class.forName("java.lang.SecurityManager").getMethod("checkPermission", Permission.class).invoke(objInvoke, new RuntimePermission("net.bytebuddy.agent.getInstrumentation"));
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Failed to access security manager", e);
        } catch (InvocationTargetException e6) {
            Throwable targetException = e6.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            throw new IllegalStateException("Failed to assert access rights using security manager", targetException);
        }
        Instrumentation instrumentation2 = instrumentation;
        if (instrumentation2 != null) {
            return instrumentation2;
        }
        throw new IllegalStateException("The Byte Buddy agent is not loaded or this method is not called via the system class loader");
    }

    public static void premain(String str, Instrumentation instrumentation2) {
        instrumentation = instrumentation2;
    }
}
