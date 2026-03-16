package org.mockito.android.internal.creation;

import androidx.constraintlayout.core.motion.a;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class AndroidTempFileLocator {
    static final File target;

    static {
        File cacheDirFromInstrumentationRegistry = null;
        try {
            String property = System.getProperty("org.mockito.android.target");
            if (property != null) {
                cacheDirFromInstrumentationRegistry = new File(property);
            }
        } catch (Throwable unused) {
        }
        if (cacheDirFromInstrumentationRegistry == null) {
            cacheDirFromInstrumentationRegistry = getCacheDirFromInstrumentationRegistry("androidx.test.InstrumentationRegistry");
        }
        if (cacheDirFromInstrumentationRegistry == null) {
            cacheDirFromInstrumentationRegistry = getCacheDirFromInstrumentationRegistry("androidx.test.InstrumentationRegistry");
        }
        if (cacheDirFromInstrumentationRegistry == null) {
            try {
                Field declaredField = Class.forName("dalvik.system.PathClassLoader").getDeclaredField("path");
                declaredField.setAccessible(true);
                File[] fileArrGuessPath = guessPath((String) declaredField.get(AndroidTempFileLocator.class.getClassLoader()));
                if (fileArrGuessPath.length > 0) {
                    cacheDirFromInstrumentationRegistry = fileArrGuessPath[0];
                }
            } catch (Throwable unused2) {
            }
        }
        target = cacheDirFromInstrumentationRegistry;
    }

    private static boolean fileOrDirExists(File file) {
        return file.exists();
    }

    private static File getCacheDirFromInstrumentationRegistry(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object objInvoke = cls.getDeclaredMethod("getTargetContext", new Class[0]).invoke(cls, new Object[0]);
            return (File) objInvoke.getClass().getMethod("getCacheDir", new Class[0]).invoke(objInvoke, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static File[] guessPath(String str) {
        int iLastIndexOf;
        ArrayList arrayList = new ArrayList();
        for (String str2 : splitPathList(str)) {
            if (str2.startsWith("/data/app/") && (iLastIndexOf = str2.lastIndexOf(".apk")) == str2.length() - 4) {
                int iIndexOf = str2.indexOf("-");
                if (iIndexOf != -1) {
                    iLastIndexOf = iIndexOf;
                }
                File file = new File(a.p("/data/data/", str2.substring(10, iLastIndexOf)));
                if (isWritableDirectory(file)) {
                    File file2 = new File(file, "cache");
                    if ((fileOrDirExists(file2) || file2.mkdir()) && isWritableDirectory(file2)) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    private static boolean isWritableDirectory(File file) {
        return file.isDirectory() && file.canWrite();
    }

    private static String[] splitPathList(String str) {
        if (str.startsWith("dexPath=")) {
            int iIndexOf = str.indexOf(44);
            str = iIndexOf == -1 ? str.substring(8) : str.substring(8, iIndexOf);
        }
        return str.split(":");
    }
}
