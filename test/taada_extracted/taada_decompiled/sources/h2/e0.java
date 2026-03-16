package h2;

import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 extends AbstractC0514q implements KFunction, KProperty.Accessor {
    @Override // h2.AbstractC0514q
    public final D c() {
        return i().f3412f;
    }

    @Override // h2.AbstractC0514q
    public final Caller d() {
        return null;
    }

    @Override // h2.AbstractC0514q
    public final boolean g() {
        return i().g();
    }

    public abstract PropertyAccessorDescriptor h();

    public abstract k0 i();

    @Override // kotlin.reflect.KFunction
    public final boolean isExternal() {
        return h().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isInfix() {
        return h().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isInline() {
        return h().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isOperator() {
        return h().isOperator();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public final boolean isSuspend() {
        return h().isSuspend();
    }
}
