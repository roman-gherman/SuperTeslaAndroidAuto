package kotlin.jvm.internal;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i implements FunctionBase, Serializable {
    private final int arity;

    public i(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @NotNull
    public String toString() {
        String strH = w.f3818a.h(this);
        h.e(strH, "renderLambdaToString(this)");
        return strH;
    }
}
