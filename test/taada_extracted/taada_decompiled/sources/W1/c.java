package W1;

import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1390a;

    static {
        b bVar;
        try {
            Object objNewInstance = Y1.b.class.newInstance();
            h.e(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    bVar = (b) objNewInstance;
                } catch (ClassCastException e) {
                    ClassLoader classLoader = objNewInstance.getClass().getClassLoader();
                    ClassLoader classLoader2 = b.class.getClassLoader();
                    if (h.a(classLoader, classLoader2)) {
                        throw e;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
                }
            } catch (ClassNotFoundException unused) {
                Object objNewInstance2 = X1.b.class.newInstance();
                h.e(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        bVar = (b) objNewInstance2;
                    } catch (ClassNotFoundException unused2) {
                        bVar = new b();
                    }
                } catch (ClassCastException e6) {
                    ClassLoader classLoader3 = objNewInstance2.getClass().getClassLoader();
                    ClassLoader classLoader4 = b.class.getClassLoader();
                    if (h.a(classLoader3, classLoader4)) {
                        throw e6;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e6);
                }
            }
        } catch (ClassNotFoundException unused3) {
            Object objNewInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            h.e(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    bVar = (b) objNewInstance3;
                } catch (ClassNotFoundException unused4) {
                    Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    h.e(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        bVar = (b) objNewInstance4;
                    } catch (ClassCastException e7) {
                        ClassLoader classLoader5 = objNewInstance4.getClass().getClassLoader();
                        ClassLoader classLoader6 = b.class.getClassLoader();
                        if (h.a(classLoader5, classLoader6)) {
                            throw e7;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e7);
                    }
                }
            } catch (ClassCastException e8) {
                ClassLoader classLoader7 = objNewInstance3.getClass().getClassLoader();
                ClassLoader classLoader8 = b.class.getClassLoader();
                if (h.a(classLoader7, classLoader8)) {
                    throw e8;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e8);
            }
        }
        f1390a = bVar;
    }
}
