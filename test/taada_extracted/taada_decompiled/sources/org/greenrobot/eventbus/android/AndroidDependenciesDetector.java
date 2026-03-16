package org.greenrobot.eventbus.android;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidDependenciesDetector {
    private static final String ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME = "org.greenrobot.eventbus.android.AndroidComponentsImpl";

    public static boolean areAndroidComponentsAvailable() {
        try {
            int i = AndroidComponentsImpl.f4433a;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static AndroidComponents instantiateAndroidComponents() {
        try {
            int i = AndroidComponentsImpl.f4433a;
            return (AndroidComponents) AndroidComponentsImpl.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isAndroidSDKAvailable() {
        try {
            return Class.forName("android.os.Looper").getDeclaredMethod("getMainLooper", new Class[0]).invoke(null, new Object[0]) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }
}
