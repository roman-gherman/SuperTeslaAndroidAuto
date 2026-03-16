package org.mockito.internal.verification;

import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public final class VerificationModeFactory {
    private VerificationModeFactory() {
    }

    public static VerificationMode atLeast(int i) {
        return new AtLeast(i);
    }

    public static VerificationMode atLeastOnce() {
        return atLeast(1);
    }

    public static VerificationMode atMost(int i) {
        return new AtMost(i);
    }

    public static VerificationMode atMostOnce() {
        return atMost(1);
    }

    public static Calls calls(int i) {
        return new Calls(i);
    }

    public static VerificationMode description(VerificationMode verificationMode, String str) {
        return new Description(verificationMode, str);
    }

    public static NoInteractions noInteractions() {
        return new NoInteractions();
    }

    public static NoMoreInteractions noMoreInteractions() {
        return new NoMoreInteractions();
    }

    public static VerificationMode only() {
        return new Only();
    }

    public static Times times(int i) {
        return new Times(i);
    }
}
