package org.mockito.internal.runners.util;

import java.lang.reflect.InvocationTargetException;
import org.mockito.internal.runners.InternalRunner;

/* JADX INFO: loaded from: classes.dex */
public class RunnerProvider {
    public InternalRunner newInstance(String str, Object... objArr) throws InvocationTargetException {
        try {
            Class<?> cls = Class.forName(str);
            if (cls.getConstructors().length != 1) {
                throw new IllegalArgumentException("Expected " + str + " to have exactly one constructor.");
            }
            try {
                return (InternalRunner) cls.getConstructors()[0].newInstance(objArr);
            } catch (InvocationTargetException e) {
                throw e;
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        } catch (Exception e7) {
            throw new RuntimeException(e7);
        }
    }
}
