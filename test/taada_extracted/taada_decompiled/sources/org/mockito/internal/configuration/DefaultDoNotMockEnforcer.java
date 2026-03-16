package org.mockito.internal.configuration;

import B2.b;
import java.lang.annotation.Annotation;
import org.mockito.DoNotMock;
import org.mockito.plugins.DoNotMockEnforcer;

/* JADX INFO: loaded from: classes.dex */
public class DefaultDoNotMockEnforcer implements DoNotMockEnforcer {
    @Override // org.mockito.plugins.DoNotMockEnforcer
    public String checkTypeForDoNotMockViolation(Class<?> cls) {
        for (Annotation annotation : cls.getAnnotations()) {
            if (annotation.annotationType().getName().endsWith("org.mockito.DoNotMock")) {
                String str = cls + " is annotated with @org.mockito.DoNotMock and can't be mocked.";
                if (!DoNotMock.class.equals(annotation.annotationType())) {
                    return str;
                }
                StringBuilder sbL = b.l(str, " ");
                sbL.append(((DoNotMock) cls.getAnnotation(DoNotMock.class)).reason());
                return sbL.toString();
            }
        }
        return null;
    }
}
