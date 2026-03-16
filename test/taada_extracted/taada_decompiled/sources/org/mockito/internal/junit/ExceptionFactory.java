package org.mockito.internal.junit;

import org.mockito.exceptions.verification.opentest4j.ArgumentsAreDifferent;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionFactory {
    private static final ExceptionFactoryImpl factory;

    public interface ExceptionFactoryImpl {
        AssertionError create(String str, String str2, String str3);
    }

    static {
        ExceptionFactoryImpl exceptionFactoryImpl;
        try {
            try {
                Class.forName("org.opentest4j.AssertionFailedError");
                final int i = 0;
                exceptionFactoryImpl = new ExceptionFactoryImpl() { // from class: org.mockito.internal.junit.a
                    @Override // org.mockito.internal.junit.ExceptionFactory.ExceptionFactoryImpl
                    public final AssertionError create(String str, String str2, String str3) {
                        switch (i) {
                            case 0:
                                return (AssertionError) new ArgumentsAreDifferent(str, str2, str3);
                            case 1:
                                return new org.mockito.exceptions.verification.junit.ArgumentsAreDifferent(str, str2, str3);
                            default:
                                return new org.mockito.exceptions.verification.ArgumentsAreDifferent(str, str2, str3);
                        }
                    }
                };
            } catch (ClassNotFoundException unused) {
                exceptionFactoryImpl = null;
            }
        } catch (ClassNotFoundException unused2) {
            Class.forName("junit.framework.ComparisonFailure");
            final int i3 = 1;
            exceptionFactoryImpl = new ExceptionFactoryImpl() { // from class: org.mockito.internal.junit.a
                @Override // org.mockito.internal.junit.ExceptionFactory.ExceptionFactoryImpl
                public final AssertionError create(String str, String str2, String str3) {
                    switch (i3) {
                        case 0:
                            return (AssertionError) new ArgumentsAreDifferent(str, str2, str3);
                        case 1:
                            return new org.mockito.exceptions.verification.junit.ArgumentsAreDifferent(str, str2, str3);
                        default:
                            return new org.mockito.exceptions.verification.ArgumentsAreDifferent(str, str2, str3);
                    }
                }
            };
        }
        if (exceptionFactoryImpl == null) {
            final int i4 = 2;
            exceptionFactoryImpl = new ExceptionFactoryImpl() { // from class: org.mockito.internal.junit.a
                @Override // org.mockito.internal.junit.ExceptionFactory.ExceptionFactoryImpl
                public final AssertionError create(String str, String str2, String str3) {
                    switch (i4) {
                        case 0:
                            return (AssertionError) new ArgumentsAreDifferent(str, str2, str3);
                        case 1:
                            return new org.mockito.exceptions.verification.junit.ArgumentsAreDifferent(str, str2, str3);
                        default:
                            return new org.mockito.exceptions.verification.ArgumentsAreDifferent(str, str2, str3);
                    }
                }
            };
        }
        factory = exceptionFactoryImpl;
    }

    private ExceptionFactory() {
    }

    public static AssertionError createArgumentsAreDifferentException(String str, String str2, String str3) {
        return factory.create(str, str2, str3);
    }
}
