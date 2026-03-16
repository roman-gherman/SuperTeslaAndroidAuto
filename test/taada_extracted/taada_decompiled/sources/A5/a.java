package A5;

import B.w;
import B5.c;
import C5.d;
import C5.e;
import C5.f;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.impl.StaticLoggerBinder;
import z5.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f81a;
    public static final w b = new w();
    public static final b c = new b(1);
    public static final boolean d;
    public static final String[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f82f;

    static {
        String property;
        try {
            property = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            property = null;
        }
        d = property == null ? false : property.equalsIgnoreCase("true");
        e = new String[]{"1.6", "1.7"};
        f82f = "org/slf4j/impl/StaticLoggerBinder.class";
    }

    public static final void a() {
        LinkedHashSet linkedHashSetB;
        try {
            try {
                try {
                    if (f()) {
                        linkedHashSetB = null;
                    } else {
                        linkedHashSetB = b();
                        i(linkedHashSetB);
                    }
                    StaticLoggerBinder.getSingleton();
                    f81a = 3;
                    h(linkedHashSetB);
                    g();
                } catch (NoClassDefFoundError e6) {
                    String message = e6.getMessage();
                    if (message == null || (!message.contains("org/slf4j/impl/StaticLoggerBinder") && !message.contains("org.slf4j.impl.StaticLoggerBinder"))) {
                        f81a = 2;
                        System.err.println("Failed to instantiate SLF4J LoggerFactory");
                        System.err.println("Reported exception:");
                        e6.printStackTrace();
                        throw e6;
                    }
                    f81a = 4;
                    f.a0("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                    f.a0("Defaulting to no-operation (NOP) logger implementation");
                    f.a0("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                    g();
                }
            } catch (Exception e7) {
                f81a = 2;
                System.err.println("Failed to instantiate SLF4J LoggerFactory");
                System.err.println("Reported exception:");
                e7.printStackTrace();
                throw new IllegalStateException("Unexpected initialization failure", e7);
            } catch (NoSuchMethodError e8) {
                String message2 = e8.getMessage();
                if (message2 != null && message2.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                    f81a = 2;
                    f.a0("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                    f.a0("Your binding is version 1.5.5 or earlier.");
                    f.a0("Upgrade your binding to version 1.6.x.");
                }
                throw e8;
            }
        } catch (Throwable th) {
            g();
            throw th;
        }
    }

    public static LinkedHashSet b() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = a.class.getClassLoader();
            String str = f82f;
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(str) : classLoader.getResources(str);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e6) {
            System.err.println("Error getting resources from path");
            System.err.println("Reported exception:");
            e6.printStackTrace();
        }
        return linkedHashSet;
    }

    public static ILoggerFactory c() {
        if (f81a == 0) {
            synchronized (a.class) {
                try {
                    if (f81a == 0) {
                        f81a = 1;
                        a();
                        if (f81a == 3) {
                            j();
                        }
                    }
                } finally {
                }
            }
        }
        int i = f81a;
        if (i == 1) {
            return b;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (i == 4) {
            return c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static Logger d(Class cls) {
        int i;
        Logger loggerE = e(cls.getName());
        if (d) {
            e eVar = f.f180a;
            Class cls2 = null;
            if (eVar == null) {
                if (f.b) {
                    eVar = null;
                } else {
                    try {
                        eVar = new e();
                    } catch (SecurityException unused) {
                        eVar = null;
                    }
                    f.f180a = eVar;
                    f.b = true;
                }
            }
            if (eVar != null) {
                Class[] classContext = eVar.getClassContext();
                String name = f.class.getName();
                int i3 = 0;
                while (i3 < classContext.length && !name.equals(classContext[i3].getName())) {
                    i3++;
                }
                if (i3 >= classContext.length || (i = i3 + 2) >= classContext.length) {
                    throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
                }
                cls2 = classContext[i];
            }
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                f.a0("Detected logger name mismatch. Given name: \"" + loggerE.getName() + "\"; computed name: \"" + cls2.getName() + "\".");
                f.a0("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return loggerE;
    }

    public static Logger e(String str) {
        return c().getLogger(str);
    }

    public static boolean f() {
        String property;
        try {
            property = System.getProperty("java.vendor.url");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return false;
        }
        return property.toLowerCase().contains("android");
    }

    public static void g() {
        w wVar = b;
        synchronized (wVar) {
            try {
                wVar.b = true;
                for (d dVar : new ArrayList(((HashMap) wVar.c).values())) {
                    dVar.b = e(dVar.f177a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = (LinkedBlockingQueue) b.d;
        int size = linkedBlockingQueue.size();
        ArrayList<c> arrayList = new ArrayList(128);
        int i = 0;
        while (linkedBlockingQueue.drainTo(arrayList, 128) != 0) {
            for (c cVar : arrayList) {
                if (cVar != null) {
                    d dVar2 = cVar.d;
                    String str = dVar2.f177a;
                    if (dVar2.b == null) {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    }
                    if (!(dVar2.b instanceof C5.b)) {
                        if (!dVar2.b()) {
                            f.a0(str);
                        } else if (dVar2.b()) {
                            try {
                                dVar2.d.invoke(dVar2.b, cVar);
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i3 = i + 1;
                if (i == 0) {
                    if (cVar.d.b()) {
                        f.a0("A number (" + size + ") of logging calls during the initialization phase have been intercepted and are");
                        f.a0("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        f.a0("See also http://www.slf4j.org/codes.html#replay");
                    } else if (!(cVar.d.b instanceof C5.b)) {
                        f.a0("The following set of substitute loggers may have been accessed");
                        f.a0("during the initialization phase. Logging calls during this");
                        f.a0("phase were not honored. However, subsequent logging calls to these");
                        f.a0("loggers will work as normally expected.");
                        f.a0("See also http://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i = i3;
            }
            arrayList.clear();
        }
        w wVar2 = b;
        ((HashMap) wVar2.c).clear();
        ((LinkedBlockingQueue) wVar2.d).clear();
    }

    public static void h(LinkedHashSet linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.size() <= 1) {
            return;
        }
        f.a0("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
    }

    public static void i(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.size() > 1) {
            f.a0("Class path contains multiple SLF4J bindings.");
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                f.a0("Found binding in [" + ((URL) it.next()) + "]");
            }
            f.a0("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static final void j() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z6 = false;
            for (String str2 : e) {
                if (str.startsWith(str2)) {
                    z6 = true;
                }
            }
            if (z6) {
                return;
            }
            f.a0("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(e).toString());
            f.a0("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            System.err.println("Unexpected problem occured during version sanity check");
            System.err.println("Reported exception:");
            th.printStackTrace();
        }
    }
}
