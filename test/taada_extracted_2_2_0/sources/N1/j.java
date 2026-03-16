package N1;

import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Lazy, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0 f1126a;
    public volatile Object b;
    public final Object c;

    public j(Function0 initializer) {
        kotlin.jvm.internal.h.f(initializer, "initializer");
        this.f1126a = initializer;
        this.b = l.f1128a;
        this.c = this;
    }

    private final Object writeReplace() {
        return new b(getValue());
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.b;
        l lVar = l.f1128a;
        if (obj != lVar) {
            return obj;
        }
        synchronized (this.c) {
            objInvoke = this.b;
            if (objInvoke == lVar) {
                Function0 function0 = this.f1126a;
                kotlin.jvm.internal.h.c(function0);
                objInvoke = function0.invoke();
                this.b = objInvoke;
                this.f1126a = null;
            }
        }
        return objInvoke;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        return this.b != l.f1128a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
