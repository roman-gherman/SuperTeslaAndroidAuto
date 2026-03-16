package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public class e extends b implements FunctionBase, KFunction {
    private final int arity;

    @SinceKotlin(version = "1.4")
    private final int flags;

    public e(int i) {
        this(i, b.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.b
    @SinceKotlin(version = "1.1")
    public KCallable computeReflected() {
        return w.f3818a.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return getName().equals(eVar.getName()) && getSignature().equals(eVar.getSignature()) && this.flags == eVar.flags && this.arity == eVar.arity && h.a(getBoundReceiver(), eVar.getBoundReceiver()) && h.a(getOwner(), eVar.getOwner());
        }
        if (obj instanceof KFunction) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // kotlin.reflect.KFunction
    @SinceKotlin(version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    @SinceKotlin(version = "1.1")
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    @SinceKotlin(version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.KFunction
    @SinceKotlin(version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.b, kotlin.reflect.KCallable, kotlin.reflect.KFunction
    @SinceKotlin(version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        KCallable kCallableCompute = compute();
        if (kCallableCompute != this) {
            return kCallableCompute.toString();
        }
        if (MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public e(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.b
    @SinceKotlin(version = "1.1")
    public KFunction getReflected() {
        KCallable kCallableCompute = compute();
        if (kCallableCompute != this) {
            return (KFunction) kCallableCompute;
        }
        throw new N1.d();
    }

    public e(int i, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.arity = i;
        this.flags = 0;
    }
}
