package N1;

import java.io.Serializable;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements Lazy, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.i f1130a;
    public Object b;

    private final Object writeReplace() {
        return new b(getValue());
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.jvm.functions.Function0, kotlin.jvm.internal.i] */
    @Override // kotlin.Lazy
    public final Object getValue() {
        if (this.b == l.f1128a) {
            ?? r02 = this.f1130a;
            kotlin.jvm.internal.h.c(r02);
            this.b = r02.invoke();
            this.f1130a = null;
        }
        return this.b;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        return this.b != l.f1128a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
