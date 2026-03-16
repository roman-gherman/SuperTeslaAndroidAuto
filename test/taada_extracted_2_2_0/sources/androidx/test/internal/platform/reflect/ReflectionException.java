package androidx.test.internal.platform.reflect;

/* JADX INFO: loaded from: classes.dex */
public class ReflectionException extends Exception {
    public ReflectionException(Exception exc) {
        super("Reflection access failed", exc);
    }
}
