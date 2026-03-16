package org.mockito.internal.exceptions.stacktrace;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.mockito.exceptions.stacktrace.StackTraceCleaner;
import org.mockito.internal.configuration.plugins.Plugins;

/* JADX INFO: loaded from: classes.dex */
public class StackTraceFilter implements Serializable {
    private static final StackTraceCleaner CLEANER = Plugins.getStackTraceCleanerProvider().getStackTraceCleaner(new DefaultStackTraceCleaner());
    private static Method GET_STACK_TRACE_ELEMENT = null;
    private static Object JAVA_LANG_ACCESS = null;
    static final long serialVersionUID = -5499819791513105700L;

    static {
        try {
            JAVA_LANG_ACCESS = Class.forName("sun.misc.SharedSecrets").getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
            GET_STACK_TRACE_ELEMENT = Class.forName("sun.misc.JavaLangAccess").getMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
        } catch (Exception unused) {
        }
    }

    public StackTraceElement[] filter(StackTraceElement[] stackTraceElementArr, boolean z6) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (CLEANER.isIn(stackTraceElement)) {
                arrayList.add(stackTraceElement);
            }
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    public StackTraceElement filterFirst(Throwable th, boolean z6) {
        if (GET_STACK_TRACE_ELEMENT != null) {
            int i = 0;
            while (true) {
                try {
                    StackTraceElement stackTraceElement = (StackTraceElement) GET_STACK_TRACE_ELEMENT.invoke(JAVA_LANG_ACCESS, th, Integer.valueOf(i));
                    if (CLEANER.isIn(stackTraceElement)) {
                        if (!z6) {
                            return stackTraceElement;
                        }
                        z6 = false;
                    }
                    i++;
                } catch (Exception unused) {
                }
            }
        }
        for (StackTraceElement stackTraceElement2 : th.getStackTrace()) {
            if (CLEANER.isIn(stackTraceElement2)) {
                if (!z6) {
                    return stackTraceElement2;
                }
                z6 = false;
            }
        }
        return null;
    }

    public String findSourceFile(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (CLEANER.isIn(stackTraceElement)) {
                return stackTraceElement.getFileName();
            }
        }
        return str;
    }
}
